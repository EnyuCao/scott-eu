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
 *     Michael Fiedler      - Bugzilla adpater implementations
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 * 
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/

package se.ericsson.cf.scott.sandbox.resources;

import org.eclipse.lyo.oslc4j.core.model.OslcConstants;

// Start of user code imports
// End of user code

public interface WhConstants
{
    // Start of user code user constants
    // End of user code

    public static String WAREHOUSE_DOMAIN = "http://aide.md.kth.se/ns/wh#";
    public static String WAREHOUSE_NAMSPACE = "http://aide.md.kth.se/ns/wh#";
    public static String WAREHOUSE_NAMSPACE_PREFIX = "wh";

    public static String PLACE = "Place";
    public static String PATH_PLACE = "place";
    public static String TYPE_PLACE = WAREHOUSE_NAMSPACE + PLACE;
    public static String ROBOT = "Robot";
    public static String PATH_ROBOT = "robot";
    public static String TYPE_ROBOT = WAREHOUSE_NAMSPACE + ROBOT;
    public static String WAYPOINT = "Waypoint";
    public static String PATH_WAYPOINT = "waypoint";
    public static String TYPE_WAYPOINT = WAREHOUSE_NAMSPACE + WAYPOINT;
    public static String WHOBJECT = "WhObject";
    public static String PATH_WHOBJECT = "whObject";
    public static String TYPE_WHOBJECT = WAREHOUSE_NAMSPACE + WHOBJECT;
}