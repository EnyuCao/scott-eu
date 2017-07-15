/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Michael Fiedler     - initial API and implementation for Bugzilla adapter
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
package se.ericsson.cf.scott.sandbox.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import se.ericsson.cf.scott.sandbox.PlannerReasonerManager;
import se.ericsson.cf.scott.sandbox.PlannerReasonerConstants;
import se.ericsson.cf.scott.sandbox.servlet.ServiceProviderCatalogSingleton;
import scott.lyo.domain.planning.Action;
import scott.lyo.domain.planning.ActionType;
import scott.lyo.domain.planning.Mission;
import scott.lyo.domain.warehouse.Place;
import scott.lyo.domain.planning.Plan;
import scott.lyo.domain.planning.Predicate;
import scott.lyo.domain.planning.ProblemState;
import scott.lyo.domain.warehouse.Robot;
import scott.lyo.domain.planning.Variable;
import scott.lyo.domain.planning.VariableInstance;
import scott.lyo.domain.warehouse.Waypoint;
import scott.lyo.domain.warehouse.WhObject;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(PlannerReasonerConstants.PLANNING_DOMAIN)
@Path("serviceProviders/{serviceProviderId}/plans")
public class ServiceProviderService1
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public ServiceProviderService1()
    {
        super();
    }

    @GET
    @Path("{planId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Plan getPlan(
                @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("planId") final String planId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final Plan aPlan = PlannerReasonerManager.getPlan(httpServletRequest, serviceProviderId, planId);

        if (aPlan != null) {
            // Start of user code getPlan
            // End of user code
            httpServletResponse.addHeader(PlannerReasonerConstants.HDR_OSLC_VERSION, PlannerReasonerConstants.OSLC_VERSION_V2);
            return aPlan;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{planId}")
    @Produces({ MediaType.TEXT_HTML })
    public Response getPlanAsHtml(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("planId") final String planId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getPlanAsHtml_init
        // End of user code

        final Plan aPlan = PlannerReasonerManager.getPlan(httpServletRequest, serviceProviderId, planId);

        if (aPlan != null) {
            httpServletRequest.setAttribute("aPlan", aPlan);
            // Start of user code getPlanAsHtml_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/se/ericsson/cf/scott/sandbox/plan.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

}
