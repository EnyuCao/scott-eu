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
import eu.scott.warehouse.domains.pddl.Step;

// Start of user code imports
// End of user code

// Start of user code preClassCode
// End of user code

// Start of user code classAnnotations
// End of user code
@OslcNamespace(PddlDomainConstants.PLAN_NAMESPACE)
@OslcName(PddlDomainConstants.PLAN_LOCALNAME)
@OslcResourceShape(title = "Plan Resource Shape", describes = PddlDomainConstants.PLAN_TYPE)
public class Plan
    extends AbstractResource
    implements IPlan
{
    // Start of user code attributeAnnotation:cost
    // End of user code
    private Float cost;
    // Start of user code attributeAnnotation:step
    // End of user code
    private HashSet<Step> step = new HashSet<Step>();
    // Start of user code attributeAnnotation:time
    // End of user code
    private Float time;
    
    // Start of user code classAttributes
    // End of user code
    // Start of user code classMethods
    // End of user code
    public Plan()
           throws URISyntaxException
    {
        super();
    
        // Start of user code constructor1
        // End of user code
    }
    
    public Plan(final URI about)
           throws URISyntaxException
    {
        super(about);
    
        // Start of user code constructor2
        // End of user code
    }
    
    
    public static ResourceShape createResourceShape() throws OslcCoreApplicationException, URISyntaxException {
        return ResourceShapeFactory.createResourceShape(OSLC4JUtils.getServletURI(),
        OslcConstants.PATH_RESOURCE_SHAPES,
        PddlDomainConstants.PLAN_PATH,
        Plan.class);
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
            result = result + "{a Local Plan Resource} - update Plan.toString() to present resource as desired.";
            // Start of user code toString_bodyForLocalResource
            // End of user code
        }
        else {
            result = getAbout().toString();
        }
    
        // Start of user code toString_finalize
        result = "Plan{" + "cost=" + cost + ", step=" + step + ", time=" + time + '}';
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
    
    public void addStep(final Step step)
    {
        this.step.add(step);
    }
    
    
    // Start of user code getterAnnotation:cost
    // End of user code
    @OslcName("cost")
    @OslcPropertyDefinition(PddlDomainConstants.SCOTT_PDDL_2_1_SUBSET_SPEC_NAMSPACE + "cost")
    @OslcDescription("Cost of the plan according to metric.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Float)
    @OslcReadOnly(false)
    public Float getCost()
    {
        // Start of user code getterInit:cost
        // End of user code
        return cost;
    }
    
    // Start of user code getterAnnotation:step
    // End of user code
    @OslcName("step")
    @OslcPropertyDefinition(PddlDomainConstants.SCOTT_PDDL_2_1_SUBSET_SPEC_NAMSPACE + "step")
    @OslcDescription("Step of the plan containing an action.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.LocalResource)
    @OslcRange({PddlDomainConstants.STEP_TYPE})
    @OslcReadOnly(false)
    public HashSet<Step> getStep()
    {
        // Start of user code getterInit:step
        // End of user code
        return step;
    }
    
    // Start of user code getterAnnotation:time
    // End of user code
    @OslcName("time")
    @OslcPropertyDefinition(PddlDomainConstants.SCOTT_PDDL_2_1_SUBSET_SPEC_NAMSPACE + "time")
    @OslcDescription("Time in seconds it took to produce the plan.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Float)
    @OslcReadOnly(false)
    public Float getTime()
    {
        // Start of user code getterInit:time
        // End of user code
        return time;
    }
    
    
    // Start of user code setterAnnotation:cost
    // End of user code
    public void setCost(final Float cost )
    {
        // Start of user code setterInit:cost
        // End of user code
        this.cost = cost;
    
        // Start of user code setterFinalize:cost
        // End of user code
    }
    
    // Start of user code setterAnnotation:step
    // End of user code
    public void setStep(final HashSet<Step> step )
    {
        // Start of user code setterInit:step
        // End of user code
        this.step.clear();
        if (step != null)
        {
            this.step.addAll(step);
        }
    
        // Start of user code setterFinalize:step
        // End of user code
    }
    
    // Start of user code setterAnnotation:time
    // End of user code
    public void setTime(final Float time )
    {
        // Start of user code setterInit:time
        // End of user code
        this.time = time;
    
        // Start of user code setterFinalize:time
        // End of user code
    }
    
    
    static public String costToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:costToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"cost\">cost: </LABEL>";
    
        // Start of user code "Mid:costToHtmlForCreation(...)"
        // End of user code
    
        s= s + "<input name=\"cost\" type=\"text\" style=\"width: 400px\" id=\"cost\" >";
        // Start of user code "Finalize:costToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String stepToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:stepToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"step\">step: </LABEL>";
    
        // Start of user code "Mid:stepToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:stepToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String timeToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:timeToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"time\">time: </LABEL>";
    
        // Start of user code "Mid:timeToHtmlForCreation(...)"
        // End of user code
    
        s= s + "<input name=\"time\" type=\"text\" style=\"width: 400px\" id=\"time\" >";
        // Start of user code "Finalize:timeToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    
    public String costToHtml()
    {
        String s = "";
    
        // Start of user code costtoHtml_mid
        // End of user code
    
        try {
            if (cost == null) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + cost.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code costtoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String stepToHtml()
    {
        String s = "";
    
        // Start of user code steptoHtml_mid
        // End of user code
    
        try {
            s = s + "<ul>";
            for(Step next : step) {
                s = s + "<li>";
                s = s + next.toHtml(true);
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code steptoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String timeToHtml()
    {
        String s = "";
    
        // Start of user code timetoHtml_mid
        // End of user code
    
        try {
            if (time == null) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + time.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code timetoHtml_finalize
        // End of user code
    
        return s;
    }
    
    
}
