# Architecture for the Warehouse Robots

## 1. Overview

This document is intended to present details about the ROS architecture used within the warehouse controller. 
This architecture focuses on the communication in the robot side. This gives an understanding about how the sensor and
the robot inner data are sent to the warehouse controller.

The robot model is a Turtlebot2i which is equipped with a robotic arm and two active cameras (Aster and Real Sense).

## 2. Architecture

The  presented architecture is formed by the following components that are necessary to run and monitor the robots inside the
warehouse: V-REP, Robots and Digital Twin. These components are intended to run in different machines in a seamless way
and in different networks. 

There are two scenarios in this architecture: 

- **Simulated Scenario:** The robots and the warehouse are simulated by V-REP and all the information are gathered from the simulator. In this scenario a single ROS MASTER is used. ROS algorithms communicate with the V-REP through *ROS_INTERFACE* and *ROS API*.
- **Real Scenario:** In this scenario, real robots are used and each robot has its own ROS MASTER. Each robot will be equipped with its own computer and running ROS on top of it. Each ROS MASTER can communicate with each other with using [ROS MultiMaster](http://wiki.ros.org/ROS/Tutorials/MultipleMachines). 

The following figure illustrates the components of the architecture and the communication
between them.


![alt text](http://url/to/img.png)

### 2.1. V-REP

As in the first moment it is not possible to perform real experiments due to the absence of real robots, the
architecture considers the communication with the robot simulation software (V-REP). The V-REP component makes the role
of the robot hardware, thus, it makes necessary the use of two interfaces to communicate with the robot logical part
(ROS) through two interfaces: *ROS_INTERFACE* and *ROS_CONTROLLER*. The *ROS_INTERFACE* enables the use of ROS messages and
topics within the V-REP, and *ROS_CONTROLLER* enables the hardware communication with the robotic arm. In order to
facilitate the communication to the Robot component, the *ROS_CONTROLLER* was moved to robot side and the communication
performed trough remot API.


### 2.2. Robots

Each robot runs ROS on it to manage the sensor data aquisition, robot control and exposes robot data to the respective digital
twin. In essence, ROS provides all the high level communication interface to the robots/sensors and many facilities for
coding. An important characteristic of ROS is the possibility to use the same code developed for the
simulated scenario in the real robots. Following this idea, our architecture automatically handles the transition between the real
robot and simulation robot.


### 2.3. Digital Twins

Here the digital twin makes an interface between the robots to the warehouse controller and keep tracking the robot
status (e.g. battery level, wifi signal intensity). Therefore, it must have access to all the data generated by the
Robot component. In the first moment, the ROS messages are going to be used to communicate with the Robots. However, as all
the robot information will flow to the digital twin and may cause an overhead in the communication, an alternative
protocol is under discussion.