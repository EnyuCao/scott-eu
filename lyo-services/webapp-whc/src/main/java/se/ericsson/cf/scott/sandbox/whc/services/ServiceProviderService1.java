// Start of user code Copyright
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
 *     Jad El-khoury       - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Jim Amsden          - Support for UI Preview (494303)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package se.ericsson.cf.scott.sandbox.whc.services;

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
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
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

import se.ericsson.cf.scott.sandbox.whc.WarehouseControllerManager;
import se.ericsson.cf.scott.sandbox.whc.WarehouseControllerConstants;
import eu.scott.warehouse.domains.pddl.PddlDomainConstants;
import eu.scott.warehouse.domains.pddl.PddlDomainConstants;
import se.ericsson.cf.scott.sandbox.whc.servlet.ServiceProviderCatalogSingleton;
import eu.scott.warehouse.domains.pddl.Action;
import eu.scott.warehouse.domains.pddl.Plan;
import eu.scott.warehouse.domains.pddl.Step;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(PddlDomainConstants.SCOTT_PDDL_2_1_SUBSET_SPEC_DOMAIN)
@Path("serviceProviders/{serviceProviderId}/service1/plans")
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
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public Object[] getPlan(
                @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("planId") final String planId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final Object[] aPlan = WarehouseControllerManager.getPlan(httpServletRequest,
                                                               serviceProviderId, planId);

        if (aPlan != null) {
            // Start of user code getPlan
            // End of user code
            httpServletResponse.addHeader(WarehouseControllerConstants.HDR_OSLC_VERSION, WarehouseControllerConstants.OSLC_VERSION_V2);
            // FIXME Andrew@2018-06-19: performance issue
            return Arrays.copyOf(aPlan, aPlan.length, Object[].class);
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

        final Object[] aPlan = WarehouseControllerManager.getPlan(httpServletRequest,
                                                             serviceProviderId, planId);

        if (aPlan != null) {
            // FIXME Andrew@2018-02-26: replace with the strongly typed wrapper class with main field for the plan and the rest of objects
            httpServletRequest.setAttribute("aPlan", aPlan[0]);
            // Start of user code getPlanAsHtml_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/se/ericsson/cf/scott/sandbox/whc/plan.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

   /* @GET
    @Path("{planId}")
    @Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML})
    public Compact getPlanCompact(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("planId") final String planId
        ) throws ServletException, IOException, URISyntaxException
    {
        String iconUri = OSLC4JUtils.getPublicURI() + "/images/ui_preview_icon.gif";
        String smallPreviewHintHeight = "10em";
        String smallPreviewHintWidth = "45em";
        String largePreviewHintHeight = "20em";
        String largePreviewHintWidth = "45em";

        // Start of user code getPlanCompact_init
        //TODO: adjust the preview height & width values from the default values provided above.
        // End of user code

        final Plan aPlan = WarehouseControllerManager.getPlan(httpServletRequest, serviceProviderId, planId);

        if (aPlan != null) {
            final Compact compact = new Compact();

            compact.setAbout(aPlan.getAbout());
            compact.setTitle(aPlan.toString());

            compact.setIcon(new URI(iconUri));

            //Create and set attributes for OSLC preview resource
            final Preview smallPreview = new Preview();
            smallPreview.setHintHeight(smallPreviewHintHeight);
            smallPreview.setHintWidth(smallPreviewHintWidth);
            smallPreview.setDocument(UriBuilder.fromUri(aPlan.getAbout()).path("smallPreview").build());
            compact.setSmallPreview(smallPreview);

            final Preview largePreview = new Preview();
            largePreview.setHintHeight(largePreviewHintHeight);
            largePreview.setHintWidth(largePreviewHintWidth);
            largePreview.setDocument(UriBuilder.fromUri(aPlan.getAbout()).path("largePreview").build());
            compact.setLargePreview(largePreview);

            httpServletResponse.addHeader(WarehouseControllerConstants.HDR_OSLC_VERSION, WarehouseControllerConstants.OSLC_VERSION_V2);
            return compact;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{planId}/smallPreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getPlanAsHtmlSmallPreview(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("planId") final String planId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getPlanAsHtmlSmallPreview_init
        // End of user code

        final Plan aPlan = WarehouseControllerManager.getPlan(httpServletRequest, serviceProviderId, planId);

        if (aPlan != null) {
            httpServletRequest.setAttribute("aPlan", aPlan);
            // Start of user code getPlanAsHtmlSmallPreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/se/ericsson/cf/scott/sandbox/whc/plansmallpreview.jsp");
            httpServletResponse.addHeader(WarehouseControllerConstants.HDR_OSLC_VERSION, WarehouseControllerConstants.OSLC_VERSION_V2);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{planId}/largePreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getPlanAsHtmlLargePreview(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("planId") final String planId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getPlanAsHtmlLargePreview_init
        // End of user code

        final Plan aPlan = WarehouseControllerManager.getPlan(httpServletRequest, serviceProviderId, planId);

        if (aPlan != null) {
            httpServletRequest.setAttribute("aPlan", aPlan);
            // Start of user code getPlanAsHtmlLargePreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/se/ericsson/cf/scott/sandbox/whc/planlargepreview.jsp");
            httpServletResponse.addHeader(WarehouseControllerConstants.HDR_OSLC_VERSION, WarehouseControllerConstants.OSLC_VERSION_V2);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }*/
}
