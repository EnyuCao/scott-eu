// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2011, 2012 IBM Corporation and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *  
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Eclipse Distribution License is available at
 *  http://www.eclipse.org/org/documents/edl-v10.php.
 *  
 *  Contributors:
 *  
 *	   Sam Padgett	       - initial API and implementation
 *     Michael Fiedler     - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Matthieu Helleboid   - Support for multiple Service Providers.
 *     Anass Radouani       - Support for multiple Service Providers.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package se.ericsson.cf.scott.sandbox.twin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContextEvent;

import eu.scott.warehouse.domains.mission.AgentRequest;
import eu.scott.warehouse.domains.mission.Mission;
import eu.scott.warehouse.domains.pddl.PlanExecutionResult;

// Start of user code imports
import org.eclipse.paho.client.mqttv3.MqttException;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.ericsson.cf.scott.sandbox.twin.clients.TwinRegistrationClient;
import se.ericsson.cf.scott.sandbox.twin.trs.TrsMqttClientManager;
import se.ericsson.cf.scott.sandbox.twin.trs.TwinAckRegistrationAgent;

//import se.ericsson.cf.scott.sandbox.twin.ros.RobotClientNode;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import eu.scott.warehouse.lib.MqttClientBuilder;
import eu.scott.warehouse.lib.MqttTopics;
import eu.scott.warehouse.lib.TrsMqttGateway;
import java.util.UUID;
import javax.servlet.ServletContext;

import org.eclipse.lyo.client.oslc.OslcClient;
import org.eclipse.lyo.store.Store;

// End of user code

// Start of user code pre_class_code
// End of user code

public class RobotTwinManager {

    // Start of user code class_attributes
    public final static String PACKAGE_ROOT = RobotTwinManager.class.getPackage().getName();
    private final static Logger log = LoggerFactory.getLogger(RobotTwinManager.class);
    private final static UUID uuid = UUID.randomUUID();
    private static String trsTopic;
    private static TrsMqttClientManager trsClientManager;
    private static Store store;
    private static ServletContext servletContext;
    private static TrsMqttGateway mqttGateway;
    // End of user code
    
    
    // Start of user code class_methods
    @NotNull
    public static String getTwinUUID() {
        return "twn-" + uuid.toString();
    }

    public static String getTrsTopic() {
        if(Strings.isNullOrEmpty(trsTopic)) {
            log.warn("The TRS topic was requested before it was set");
        }
        return trsTopic;
    }

    public static void setTrsTopic(String trsTopic) {
        RobotTwinManager.trsTopic = trsTopic;
    }

    public static TrsMqttClientManager getTrsClientManager() {
        return trsClientManager;
    }

    public static void setTrsClientManager(TrsMqttClientManager trsClientManager) {
        RobotTwinManager.trsClientManager = trsClientManager;
    }

    public static ServletContext getServletContext() {
        return servletContext;
    }

    private static void registerTwins() {
        final OslcClient client = new OslcClient();
        final TwinRegistrationClient registrationClient = new TwinRegistrationClient(
            client, "http://sandbox-whc:8080/services/service2/registrationRequests/register");

        for(String id: ImmutableList.of("r1", "r2", "r3")) {
            registrationClient.registerTwin("robot", id);
        }

    }

    private static void setStore(final Store store) {
        RobotTwinManager.store = store;
    }
    // End of user code

    public static void contextInitializeServletListener(final ServletContextEvent servletContextEvent)
    {
        
        // Start of user code contextInitializeServletListener
        log.info("Twin {} is starting", getTwinUUID());
        servletContext = servletContextEvent.getServletContext();
//        final Store store = LyoStoreManager.initLyoStore();
//        setStore(store);

//        RosManager.runRosNode();
//        new Thread(RobotTwinManager::runRosNode).run();
//        RosManager.execMainNode();

        final String mqttBroker = AdaptorHelper.p("trs.mqtt.broker");
//        final TrsMqttClientManager trsClientManager = new TrsMqttClientManager(mqttBroker);
//        setTrsClientManager(trsClientManager);
//        new Thread(trsClientManager::connectAndSubscribeToPlans).run();
        // FIXME Andrew@2018-07-31: remove non-gateway based code
        try {
            mqttGateway = new MqttClientBuilder().withBroker(mqttBroker)
                                                 .withId(getTwinUUID())
                                                 .withRegistration(new TwinAckRegistrationAgent(
                                                         MqttTopics.WHC_PLANS))
                                                 .build();
        } catch (MqttException e) {
            log.error("Failed to initialise the MQTT gateway", e);
        }

        registerTwins();
        // End of user code
    }

    public static void contextDestroyServletListener(ServletContextEvent servletContextEvent) 
    {
        
        // Start of user code contextDestroyed
        log.info("Destroying the servlet");
        try {
            mqttGateway.disconnect();
        } catch (MqttException e) {
            log.error("Failed to disconnect from the MQTT broker");
        }
//        getTrsClientManager().unregisterTwinAndDisconnect();
        // End of user code
    }

    public static RobotsServiceProviderInfo[] getRobotsServiceProviderInfos(HttpServletRequest httpServletRequest)
    {
        RobotsServiceProviderInfo[] serviceProviderInfos = {};
        
        // Start of user code "RobotsServiceProviderInfo[] getRobotsServiceProviderInfos(...)"
        // TODO Implement code to return the set of ServiceProviders
        // End of user code
        return serviceProviderInfos;
    }
    public static BeltsServiceProviderInfo[] getBeltsServiceProviderInfos(HttpServletRequest httpServletRequest)
    {
        BeltsServiceProviderInfo[] serviceProviderInfos = {};
        
        // Start of user code "BeltsServiceProviderInfo[] getBeltsServiceProviderInfos(...)"
        // TODO Implement code to return the set of ServiceProviders
        // End of user code
        return serviceProviderInfos;
    }



    public static PlanExecutionResult getPlanExecutionResult(HttpServletRequest httpServletRequest, final String serviceProviderId, final String planExecutionResultId)
    {
        PlanExecutionResult aResource = null;
        
        // Start of user code getPlanExecutionResult
        // TODO Implement code to return a resource
        // End of user code
        return aResource;
    }





    public static Mission getMission(HttpServletRequest httpServletRequest, final String beltId, final String missionId)
    {
        Mission aResource = null;
        
        // Start of user code getMission
        // TODO Implement code to return a resource
        // End of user code
        return aResource;
    }
    public static AgentRequest getAgentRequest(HttpServletRequest httpServletRequest, final String beltId, final String agentRequestId)
    {
        AgentRequest aResource = null;
        
        // Start of user code getAgentRequest
        // TODO Implement code to return a resource
        // End of user code
        return aResource;
    }




    public static String getETagFromAgentRequest(final AgentRequest aResource)
    {
        String eTag = null;
        // Start of user code getETagFromAgentRequest
        // TODO Implement code to return an ETag for a particular resource
        // End of user code
        return eTag;
    }
    public static String getETagFromMission(final Mission aResource)
    {
        String eTag = null;
        // Start of user code getETagFromMission
        // TODO Implement code to return an ETag for a particular resource
        // End of user code
        return eTag;
    }
    public static String getETagFromPlanExecutionResult(final PlanExecutionResult aResource)
    {
        String eTag = null;
        // Start of user code getETagFromPlanExecutionResult
        // TODO Implement code to return an ETag for a particular resource
        // End of user code
        return eTag;
    }

}