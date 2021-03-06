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
 *     Russell Boykin       - initial API and implementation
 *     Alberto Giammaria    - initial API and implementation
 *     Chris Peters         - initial API and implementation
 *     Gianluca Bernardini  - initial API and implementation
 *       Sam Padgett          - initial API and implementation
 *     Michael Fiedler      - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (422448)
 *     Matthieu Helleboid   - Support for multiple Service Providers.
 *     Anass Radouani       - Support for multiple Service Providers.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package eu.scott.warehouse.domains.pddl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.annotation.OslcAllowedValue;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcMemberProperty;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;
import org.eclipse.lyo.oslc4j.core.model.ResourceShape;
import org.eclipse.lyo.oslc4j.core.model.ResourceShapeFactory;

import eu.scott.warehouse.domains.pddl.PddlDomainConstants;
import eu.scott.warehouse.domains.pddl.PddlDomainConstants;
import eu.scott.warehouse.domains.pddl.Action;

// Start of user code imports
// End of user code

// Start of user code preClassCode
// End of user code

// Start of user code classAnnotations
// End of user code
@OslcNamespace(PddlDomainConstants.STEP_NAMESPACE)
@OslcName(PddlDomainConstants.STEP_LOCALNAME)
@OslcResourceShape(title = "Step Resource Shape", describes = PddlDomainConstants.STEP_TYPE)
public class Step
    extends AbstractResource
    implements IStep
{
    // Start of user code attributeAnnotation:action
    // End of user code
    private Link action = new Link();
    // Start of user code attributeAnnotation:adding
    // End of user code
    private HashSet<Link> adding = new HashSet<Link>();
    // Start of user code attributeAnnotation:deleting
    // End of user code
    private HashSet<Link> deleting = new HashSet<Link>();
    // Start of user code attributeAnnotation:updating
    // End of user code
    private HashSet<Link> updating = new HashSet<Link>();
    // Start of user code attributeAnnotation:order
    // End of user code
    private Integer order;
    
    // Start of user code classAttributes
    // End of user code
    // Start of user code classMethods
    // End of user code
    public Step()
           throws URISyntaxException
    {
        super();
    
        // Start of user code constructor1
        // End of user code
    }
    
    public Step(final URI about)
           throws URISyntaxException
    {
        super(about);
    
        // Start of user code constructor2
        // End of user code
    }
    
    
    public static ResourceShape createResourceShape() throws OslcCoreApplicationException, URISyntaxException {
        return ResourceShapeFactory.createResourceShape(OSLC4JUtils.getServletURI(),
        OslcConstants.PATH_RESOURCE_SHAPES,
        PddlDomainConstants.STEP_PATH,
        Step.class);
    }
    
    
    public String toString()
    {
        return toString(false);
    }
    
    public String toString(boolean asLocalResource)
    {
        String result = "";
        // Start of user code toString_init
        // End of user code
    
        if (asLocalResource) {
            result = result + "{a Local Step Resource} - update Step.toString() to present resource as desired.";
            // Start of user code toString_bodyForLocalResource
            // End of user code
        }
        else {
            result = getAbout().toString();
        }
    
        // Start of user code toString_finalize
        // End of user code
    
        return result;
    }
    
    public String toHtml()
    {
        return toHtml(false);
    }
    
    public String toHtml(boolean asLocalResource)
    {
        String result = "";
        // Start of user code toHtml_init
        // End of user code
    
        if (asLocalResource) {
            result = toString(true);
            // Start of user code toHtml_bodyForLocalResource
            // End of user code
        }
        else {
            result = "<a href=\"" + getAbout() + "\" class=\"oslc-resource-link\">" + toString() + "</a>";
        }
    
        // Start of user code toHtml_finalize
        // End of user code
    
        return result;
    }
    
    public void addAdding(final Link adding)
    {
        this.adding.add(adding);
    }
    
    public void addDeleting(final Link deleting)
    {
        this.deleting.add(deleting);
    }
    
    public void addUpdating(final Link updating)
    {
        this.updating.add(updating);
    }
    
    
    // Start of user code getterAnnotation:action
    // End of user code
    @OslcName("action")
    @OslcPropertyDefinition(PddlDomainConstants.SCOTT_PDDL_2_1_SUBSET_SPEC_NAMSPACE + "action")
    @OslcDescription("Action of the plan step.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({PddlDomainConstants.ACTION_TYPE})
    @OslcReadOnly(false)
    public Link getAction()
    {
        // Start of user code getterInit:action
        // End of user code
        return action;
    }
    
    // Start of user code getterAnnotation:adding
    // End of user code
    @OslcName("adding")
    @OslcPropertyDefinition(PddlDomainConstants.SCOTT_PDDL_2_1_SUBSET_SPEC_NAMSPACE + "adding")
    @OslcDescription("Step additions.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getAdding()
    {
        // Start of user code getterInit:adding
        // End of user code
        return adding;
    }
    
    // Start of user code getterAnnotation:deleting
    // End of user code
    @OslcName("deleting")
    @OslcPropertyDefinition(PddlDomainConstants.SCOTT_PDDL_2_1_SUBSET_SPEC_NAMSPACE + "deleting")
    @OslcDescription("Step deletions.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getDeleting()
    {
        // Start of user code getterInit:deleting
        // End of user code
        return deleting;
    }
    
    // Start of user code getterAnnotation:updating
    // End of user code
    @OslcName("updating")
    @OslcPropertyDefinition(PddlDomainConstants.SCOTT_PDDL_2_1_SUBSET_SPEC_NAMSPACE + "updating")
    @OslcDescription("Step updates.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public HashSet<Link> getUpdating()
    {
        // Start of user code getterInit:updating
        // End of user code
        return updating;
    }
    
    // Start of user code getterAnnotation:order
    // End of user code
    @OslcName("order")
    @OslcPropertyDefinition(PddlDomainConstants.SCOTT_PDDL_2_1_SUBSET_SPEC_NAMSPACE + "order")
    @OslcDescription("Parameter order.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Integer)
    @OslcReadOnly(false)
    public Integer getOrder()
    {
        // Start of user code getterInit:order
        // End of user code
        return order;
    }
    
    
    // Start of user code setterAnnotation:action
    // End of user code
    public void setAction(final Link action )
    {
        // Start of user code setterInit:action
        // End of user code
        this.action = action;
    
        // Start of user code setterFinalize:action
        // End of user code
    }
    
    // Start of user code setterAnnotation:adding
    // End of user code
    public void setAdding(final HashSet<Link> adding )
    {
        // Start of user code setterInit:adding
        // End of user code
        this.adding.clear();
        if (adding != null)
        {
            this.adding.addAll(adding);
        }
    
        // Start of user code setterFinalize:adding
        // End of user code
    }
    
    // Start of user code setterAnnotation:deleting
    // End of user code
    public void setDeleting(final HashSet<Link> deleting )
    {
        // Start of user code setterInit:deleting
        // End of user code
        this.deleting.clear();
        if (deleting != null)
        {
            this.deleting.addAll(deleting);
        }
    
        // Start of user code setterFinalize:deleting
        // End of user code
    }
    
    // Start of user code setterAnnotation:updating
    // End of user code
    public void setUpdating(final HashSet<Link> updating )
    {
        // Start of user code setterInit:updating
        // End of user code
        this.updating.clear();
        if (updating != null)
        {
            this.updating.addAll(updating);
        }
    
        // Start of user code setterFinalize:updating
        // End of user code
    }
    
    // Start of user code setterAnnotation:order
    // End of user code
    public void setOrder(final Integer order )
    {
        // Start of user code setterInit:order
        // End of user code
        this.order = order;
    
        // Start of user code setterFinalize:order
        // End of user code
    }
    
    
    static public String actionToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:actionToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"action\">action: </LABEL>";
    
        // Start of user code "Mid:actionToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:actionToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String addingToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:addingToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"adding\">adding: </LABEL>";
    
        // Start of user code "Mid:addingToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:addingToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String deletingToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:deletingToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"deleting\">deleting: </LABEL>";
    
        // Start of user code "Mid:deletingToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:deletingToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String updatingToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:updatingToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"updating\">updating: </LABEL>";
    
        // Start of user code "Mid:updatingToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:updatingToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String orderToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:orderToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"order\">order: </LABEL>";
    
        // Start of user code "Mid:orderToHtmlForCreation(...)"
        // End of user code
    
        s= s + "<input name=\"order\" type=\"text\" style=\"width: 400px\" id=\"order\" >";
        // Start of user code "Finalize:orderToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    
    public String actionToHtml()
    {
        String s = "";
    
        // Start of user code actiontoHtml_mid
        // End of user code
    
        try {
            if ((action == null) || (action.getValue() == null)) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + (new Action (action.getValue())).toHtml(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code actiontoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String addingToHtml()
    {
        String s = "";
    
        // Start of user code addingtoHtml_mid
        // End of user code
    
        try {
            s = s + "<ul>";
            for(Link next : adding) {
                s = s + "<li>";
                if (next.getValue() == null) {
                    s= s + "<em>null</em>";
                }
                else {
                    s = s + "<a href=\"" + next.getValue().toString() + "\">" + next.getValue().toString() + "</a>";
                }
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code addingtoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String deletingToHtml()
    {
        String s = "";
    
        // Start of user code deletingtoHtml_mid
        // End of user code
    
        try {
            s = s + "<ul>";
            for(Link next : deleting) {
                s = s + "<li>";
                if (next.getValue() == null) {
                    s= s + "<em>null</em>";
                }
                else {
                    s = s + "<a href=\"" + next.getValue().toString() + "\">" + next.getValue().toString() + "</a>";
                }
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code deletingtoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String updatingToHtml()
    {
        String s = "";
    
        // Start of user code updatingtoHtml_mid
        // End of user code
    
        try {
            s = s + "<ul>";
            for(Link next : updating) {
                s = s + "<li>";
                if (next.getValue() == null) {
                    s= s + "<em>null</em>";
                }
                else {
                    s = s + "<a href=\"" + next.getValue().toString() + "\">" + next.getValue().toString() + "</a>";
                }
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code updatingtoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String orderToHtml()
    {
        String s = "";
    
        // Start of user code ordertoHtml_mid
        // End of user code
    
        try {
            if (order == null) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + order.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code ordertoHtml_finalize
        // End of user code
    
        return s;
    }
    
    
}
