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

package se.ericsson.cf.scott.sandbox.resources;

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

import se.ericsson.cf.scott.sandbox.TwinConstants;
import se.ericsson.cf.scott.sandbox.resources.Predicate;
import se.ericsson.cf.scott.sandbox.resources.Variable;
import se.ericsson.cf.scott.sandbox.resources.Predicate;

// Start of user code imports
// End of user code

// Start of user code preClassCode
// End of user code

// Start of user code classAnnotations
// End of user code
@OslcNamespace(TwinConstants.PLANNING_NAMSPACE)
@OslcName(TwinConstants.ACTIONTYPE)
@OslcResourceShape(title = "ActionType Resource Shape", describes = TwinConstants.TYPE_ACTIONTYPE)
public class ActionType
    extends AbstractResource
    implements IActionType
{
    // Start of user code attributeAnnotation:label
    // End of user code
    private String label;
    // Start of user code attributeAnnotation:hasVariable
    // End of user code
    private HashSet<Link> hasVariable = new HashSet<Link>();
    // Start of user code attributeAnnotation:precondition
    // End of user code
    private Link precondition = new Link();
    // Start of user code attributeAnnotation:effect
    // End of user code
    private HashSet<Link> effect = new HashSet<Link>();
    // Start of user code attributeAnnotation:title
    // End of user code
    private String title;
    
    // Start of user code classAttributes
    // End of user code
    // Start of user code classMethods
    // End of user code
    public ActionType()
           throws URISyntaxException
    {
        super();
    
        // Start of user code constructor1
        // End of user code
    }
    
    public ActionType(final URI about)
           throws URISyntaxException
    {
        super(about);
    
        // Start of user code constructor2
        // End of user code
    }
    
    
    public static ResourceShape createResourceShape() throws OslcCoreApplicationException, URISyntaxException {
        return ResourceShapeFactory.createResourceShape(OSLC4JUtils.getServletURI(),
        OslcConstants.PATH_RESOURCE_SHAPES,
        TwinConstants.PATH_ACTIONTYPE,
        ActionType.class);
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
            result = result + "{a Local ActionType Resource} - update ActionType.toString() to present resource as desired.";
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
            result = "<a href=\"" + getAbout() + "\">" + toString() + "</a>";
        }
    
        // Start of user code toHtml_finalize
        // End of user code
    
        return result;
    }
    
    public void addHasVariable(final Link hasVariable)
    {
        this.hasVariable.add(hasVariable);
    }
    
    public void addEffect(final Link effect)
    {
        this.effect.add(effect);
    }
    
    
    // Start of user code getterAnnotation:label
    // End of user code
    @OslcName("label")
    @OslcPropertyDefinition(TwinConstants.RDFS_NAMSPACE + "label")
    @OslcDescription("May be used to provide a human-readable version of a resource's name.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.XMLLiteral)
    @OslcReadOnly(false)
    public String getLabel()
    {
        // Start of user code getterInit:label
        // End of user code
        return label;
    }
    
    // Start of user code getterAnnotation:hasVariable
    // End of user code
    @OslcName("hasVariable")
    @OslcPropertyDefinition(TwinConstants.PLANNING_NAMSPACE + "hasVariable")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({TwinConstants.TYPE_VARIABLE})
    @OslcReadOnly(false)
    @OslcTitle("")
    public HashSet<Link> getHasVariable()
    {
        // Start of user code getterInit:hasVariable
        // End of user code
        return hasVariable;
    }
    
    // Start of user code getterAnnotation:precondition
    // End of user code
    @OslcName("precondition")
    @OslcPropertyDefinition(TwinConstants.PLANNING_NAMSPACE + "precondition")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({TwinConstants.TYPE_PREDICATE})
    @OslcReadOnly(false)
    public Link getPrecondition()
    {
        // Start of user code getterInit:precondition
        // End of user code
        return precondition;
    }
    
    // Start of user code getterAnnotation:effect
    // End of user code
    @OslcName("effect")
    @OslcPropertyDefinition(TwinConstants.PLANNING_NAMSPACE + "effect")
    @OslcOccurs(Occurs.OneOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({TwinConstants.TYPE_PREDICATE})
    @OslcReadOnly(false)
    public HashSet<Link> getEffect()
    {
        // Start of user code getterInit:effect
        // End of user code
        return effect;
    }
    
    // Start of user code getterAnnotation:title
    // End of user code
    @OslcName("title")
    @OslcPropertyDefinition(TwinConstants.DUBLIN_CORE_NAMSPACE + "title")
    @OslcDescription("Title of the resource represented as rich text in XHTML content. SHOULD include only content that is valid inside an XHTML <span> element.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.XMLLiteral)
    @OslcReadOnly(false)
    public String getTitle()
    {
        // Start of user code getterInit:title
        // End of user code
        return title;
    }
    
    
    // Start of user code setterAnnotation:label
    // End of user code
    public void setLabel(final String label )
    {
        // Start of user code setterInit:label
        // End of user code
        this.label = label;
    
        // Start of user code setterFinalize:label
        // End of user code
    }
    
    // Start of user code setterAnnotation:hasVariable
    // End of user code
    public void setHasVariable(final HashSet<Link> hasVariable )
    {
        // Start of user code setterInit:hasVariable
        // End of user code
        this.hasVariable.clear();
        if (hasVariable != null)
        {
            this.hasVariable.addAll(hasVariable);
        }
    
        // Start of user code setterFinalize:hasVariable
        // End of user code
    }
    
    // Start of user code setterAnnotation:precondition
    // End of user code
    public void setPrecondition(final Link precondition )
    {
        // Start of user code setterInit:precondition
        // End of user code
        this.precondition = precondition;
    
        // Start of user code setterFinalize:precondition
        // End of user code
    }
    
    // Start of user code setterAnnotation:effect
    // End of user code
    public void setEffect(final HashSet<Link> effect )
    {
        // Start of user code setterInit:effect
        // End of user code
        this.effect.clear();
        if (effect != null)
        {
            this.effect.addAll(effect);
        }
    
        // Start of user code setterFinalize:effect
        // End of user code
    }
    
    // Start of user code setterAnnotation:title
    // End of user code
    public void setTitle(final String title )
    {
        // Start of user code setterInit:title
        // End of user code
        this.title = title;
    
        // Start of user code setterFinalize:title
        // End of user code
    }
    
    
    static public String labelToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:labelToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"label\">label: </LABEL>";
    
        // Start of user code "Mid:labelToHtmlForCreation(...)"
        // End of user code
    
        s= s + "<input name=\"label\" type=\"text\" style=\"width: 400px\" id=\"label\" >";
        // Start of user code "Finalize:labelToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String hasVariableToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:hasVariableToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"hasVariable\">hasVariable: </LABEL>";
    
        // Start of user code "Mid:hasVariableToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:hasVariableToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String preconditionToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:preconditionToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"precondition\">precondition: </LABEL>";
    
        // Start of user code "Mid:preconditionToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:preconditionToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String effectToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:effectToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"effect\">effect: </LABEL>";
    
        // Start of user code "Mid:effectToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:effectToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String titleToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:titleToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"title\">title: </LABEL>";
    
        // Start of user code "Mid:titleToHtmlForCreation(...)"
        // End of user code
    
        s= s + "<input name=\"title\" type=\"text\" style=\"width: 400px\" id=\"title\" >";
        // Start of user code "Finalize:titleToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    
    public String labelToHtml()
    {
        String s = "";
    
        // Start of user code labeltoHtml_init
        // End of user code
    
    
        // Start of user code labeltoHtml_mid
        // End of user code
    
        try {
            if (label == null) {
                s= s + "<em>null</em>";
            }
            else {
                s= s + label.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code labeltoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String hasVariableToHtml()
    {
        String s = "";
    
        // Start of user code hasVariabletoHtml_init
        // End of user code
    
    
        // Start of user code hasVariabletoHtml_mid
        // End of user code
    
        try {
            s = s + "<ul>";
            for(Link next : hasVariable) {
                s = s + "<li>";
                s = s + (new Variable (next.getValue())).toHtml(false);
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code hasVariabletoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String preconditionToHtml()
    {
        String s = "";
    
        // Start of user code preconditiontoHtml_init
        // End of user code
    
    
        // Start of user code preconditiontoHtml_mid
        // End of user code
    
        try {
            if ((precondition == null) || (precondition.getValue() == null)) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + (new Predicate (precondition.getValue())).toHtml(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code preconditiontoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String effectToHtml()
    {
        String s = "";
    
        // Start of user code effecttoHtml_init
        // End of user code
    
    
        // Start of user code effecttoHtml_mid
        // End of user code
    
        try {
            s = s + "<ul>";
            for(Link next : effect) {
                s = s + "<li>";
                s = s + (new Predicate (next.getValue())).toHtml(false);
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code effecttoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String titleToHtml()
    {
        String s = "";
    
        // Start of user code titletoHtml_init
        // End of user code
    
    
        // Start of user code titletoHtml_mid
        // End of user code
    
        try {
            if (title == null) {
                s= s + "<em>null</em>";
            }
            else {
                s= s + title.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code titletoHtml_finalize
        // End of user code
    
        return s;
    }
    
    
}
