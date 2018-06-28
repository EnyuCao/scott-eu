#!/usr/bin/env python
import sys
import numpy as np
import rospy
import geometry_msgs.msg
import tf
from moveit_commander import RobotCommander, roscpp_initialize
from moveit_commander import roscpp_shutdown, PlanningSceneInterface
from moveit_msgs.msg import RobotState, Grasp, CollisionObject
from geometry_msgs.msg import PoseStamped
from control_msgs.msg import JointTrajectoryControllerState
from sensor_msgs.msg import JointState
from trajectory_msgs.msg import JointTrajectory, JointTrajectoryPoint
import time

def openGripper():
    posture = dict()
    posture["PhantomXPincher_gripperClose_joint"] = 0.03
    print posture
    return posture
    

def closeGripper():
    posture = dict()
    posture["PhantomXPincher_gripperClose_joint"] = 0.015
    print posture
    return posture

def try_target(target, arm, attemps = 10):
    d = pow(pow(target[0], 2) + pow(target[1], 2), 0.5)
    if d > 3.0:
        print("Too far. Out of reach")
        return None
    print("Distance: ", d)
    rp = np.pi/2.0 - np.arcsin((d-0.1)/.205)
    ry = np.arctan2(target[1], target[0])

    attemp = 0
    again = True
    while (again and attemp < 10):
        again = False
        print attemp

        rp_a = attemp * ((0.05 + 0.05)*np.random.ranf() - 0.05) + rp
        ry_a = attemp * ((0.05 + 0.05)*np.random.ranf() - 0.05) + ry

        q = tf.transformations.quaternion_from_euler(0, rp_a, ry_a)
        print [0, rp_a, ry_a]

        p = geometry_msgs.msg.Pose()
        p.position.x = target[0]
        p.position.y = target[1]
        p.position.z = target[2]
        p.orientation.x = q[0]
        p.orientation.y = q[1]
        p.orientation.z = q[2]
        p.orientation.w = q[3]

        target[2] += np.abs(np.cos(rp))/250.0

        print p

        arm.set_pose_target(p)
        planed = arm.plan()
        if len(planed.joint_trajectory.points) == 0:
            print "useless"
            attemp += 1
            again = True
    if again:
        return None
    return planed

class Arm():
    def __init__(self):
        self.stoped = True
        self.count_stp = 0
        #rospy.Subscriber('phantom_controller/state',
        #                 JointTrajectoryControllerState,
        #                 self.checkStopedArm)
        #rospy.Subscriber('joint_states',
        #                 JointState,
        #                 self.checkStopedArm)

    def checkStopedArm(self, state):
        '''
        Simple function to check if the arm is stopped for a while
        '''
        #vel = np.abs(np.asarray(state.actual.velocities))
        vel = np.abs(np.asarray(state.velocity))
        print vel
        vel = sum(vel > 0.005)
        print 'velocities'
        print vel
        print 'stop'
        print self.stoped
        if vel > 0:
            self.count_stp = 0
            self.stoped = False
            return 
        else:
            self.count_stp += 1
            time.sleep(0.1)
        if self.count_stp > 10:
            self.stoped = True

    def isInPosition(self, state, target):
        state = np.asarray(state)
        target = np.asarray(target)
        diff = abs(target-state)
        tol = 1/180 * np.pi
        diff = sum(diff > tol)
        if diff > 0:
            return True
        return False

if __name__ == '__main__':
    
    roscpp_initialize(sys.argv)
    rospy.init_node('moveit_py_demo', anonymous=True)
    arm = Arm()
    robot = RobotCommander()
    scene = PlanningSceneInterface()

    # -----------------------------
    #  Add objecto to the scene
    #------------------------------
    
    rospy.sleep(2)
    scene.remove_world_object("base")
    scene.remove_attached_object("gripper_link", "box")
    print robot.get_planning_frame()
    p = geometry_msgs.msg.PoseStamped()
    p.header.frame_id = "base_link"
    p.pose.position.x = 0.165
    p.pose.position.y = 0.
    p.pose.position.z = 0.066 - 0.115
    p.pose.orientation.x = 0.707106
    p.pose.orientation.y = 0
    p.pose.orientation.z = 0
    p.pose.orientation.w = 0.707106
    scene.add_box("base", p, [0.052, 0.136, 0.526])
    p.header.frame_id = "base_link"
    p.pose.position.x = 0.165
    p.pose.position.y = 0.
    p.pose.position.z = 0.150 - 0.115
    p.pose.orientation.w = 1
    p.pose.orientation.x = 0
    scene.add_box("box", p, [0.03, 0.03, 0.03])
    rospy.sleep(1)

    #exit()

    robot = RobotCommander()
    print "Current state:"    
    robot.get_current_state()
    robot.pincher_arm.set_start_state(RobotState())

    print "Arm Joints:"
    print robot.pincher_arm.get_joints()

    print "Arm Tip:"
    print robot.pincher_arm.get_end_effector_link()

    robot.pincher_arm.set_num_planning_attempts(10000)
    robot.pincher_arm.set_planning_time(10)
    print "Tolerances"
    robot.pincher_arm.set_goal_position_tolerance(0.01)
    robot.pincher_arm.set_goal_orientation_tolerance(0.5)
    print robot.pincher_arm.get_goal_position_tolerance()
    print robot.pincher_arm.get_goal_orientation_tolerance()

    pose_now = robot.pincher_arm.get_current_pose()
    print pose_now

    # -----------------------------
    #  Abre o gripper
    #------------------------------

    robot.get_current_state()
    robot.pincher_arm.set_start_state(RobotState())
    fechado = openGripper()
    robot.pincher_gripper.set_joint_value_target(fechado)
    gplan = robot.pincher_gripper.plan()
    robot.pincher_gripper.execute(gplan)

    # -----------------------------
    #  Vai para algum lugar
    #------------------------------
    #0.19169 0.05708 0.13376 -0.02705 0.1856 0.1416 0.9719
    robot.get_current_state()
    robot.pincher_arm.set_start_state(RobotState())
    target = [0.17, 0, 0.019]
    #target = [0.17, 0.05, 0.025]
    plan = try_target(target, robot.pincher_arm)


    if plan is not None:
        robot.pincher_arm.execute(plan)
        print(plan)
    else:
        print('No trajectory found')
        exit()

    count = 0
    while not (arm.isInPosition(robot.pincher_arm.get_current_joint_values(),
                                plan.joint_trajectory.points[-1].positions)):
        print 'Moving'
        count = count + 1
        if (count % 100 == 0):
            print robot.pincher_arm.get_current_joint_values()
            print plan.joint_trajectory.points[-1].positions
    rospy.sleep(1)
    # -----------------------------
    #  Vai para algum lugar
    #------------------------------
    #0.19169 0.05708 0.13376 -0.02705 0.1856 0.1416 0.9719
    '''
    robot.get_current_state()
    robot.pincher_arm.set_start_state(RobotState())
    target = [0.17, 0, 0.019]
    #target = [0.17, 0.05, 0.025]
    plan = try_target(target, robot.pincher_arm)

    if plan is not None:
        robot.pincher_arm.execute(plan)
        print(plan)
    else:
        print('No trajectory found')
        exit()

    while not (arm.isInPosition(robot.pincher_arm.get_current_joint_values(),
                                plan.joint_trajectory.points[-1].positions)):
        print 'Moving'
        count = count + 1
        if (count % 100 == 0):
            print robot.pincher_arm.get_current_joint_values()
            print plan.joint_trajectory.points[-1].positions

    '''
    # -----------------------------
    # Fecha o gripper
    #------------------------------
    robot.get_current_state()
    robot.pincher_arm.set_start_state(RobotState())
    fechado = closeGripper()
    robot.pincher_gripper.set_joint_value_target(fechado)
    gplan = robot.pincher_gripper.plan()
    robot.pincher_gripper.execute(gplan)

    rospy.sleep(1)
    scene.attach_box("gripper_link", "box", p, [0.03, 0.03, 0.03])
    rospy.sleep(1)

    
    # -----------------------------
    #  Vai para algum lugar
    #------------------------------
    #0.19169 0.05708 0.13376 -0.02705 0.1856 0.1416 0.9719
    robot.get_current_state()
    robot.pincher_arm.set_start_state(RobotState())
    target = [0.17, 0.10, 0.028]
    plan = try_target(target, robot.pincher_arm)
    
    if plan is not None:
        robot.pincher_arm.execute(plan)
        print(plan)
    else:
        print('No trajectory found')
        exit()

    count = 0
    while not (arm.isInPosition(robot.pincher_arm.get_current_joint_values(),
                                plan.joint_trajectory.points[-1].positions)):
        print 'Moving'
        count = count + 1
        if (count % 100 == 0):
            print robot.pincher_arm.get_current_joint_values()
            print plan.joint_trajectory.points[-1].positions
    
    # -----------------------------
    #  Abre o gripper
    #------------------------------
    robot.get_current_state()
    robot.pincher_arm.set_start_state(RobotState())
    fechado = openGripper()
    robot.pincher_gripper.set_joint_value_target(fechado)
    gplan = robot.pincher_gripper.plan()
    robot.pincher_gripper.execute(gplan)

