<!DOCTYPE html>
<%--
 Copyright (c) 2011, 2012, 2017 IBM Corporation and others.

 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 and Eclipse Distribution License v. 1.0 which accompanies this distribution.

 The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 and the Eclipse Distribution License is available at
 http://www.eclipse.org/org/documents/edl-v10.php.

 Contributors:

  Sam Padgett     - initial API and implementation
  Michael Fiedler - adapted for OSLC4J
  Jad El-khoury   - initial implementation of code generator (422448)
  Frédéric Loiret - Switch the template to Bootstrap (519699)

 This file is generated by org.eclipse.lyo.oslc4j.codegenerator
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="java.util.List" %>
<%@page import="se.ericsson.cf.scott.sandbox.resources.Waypoint"%>
<%--
Start of user code imports
--%>
<%--
End of user code
--%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  Waypoint aWaypoint = (Waypoint) request.getAttribute("aWaypoint");
%>
<%--
Start of user code getRequestAttributes
--%>
<%--
End of user code
--%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title><%= aWaypoint.toString(true) %></title>

  <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/static/css/sticky-footer-navbar.css"/>" rel="stylesheet">

  <%--
Start of user code (RECOMMENDED) headStuff
    --%>
    <%--
End of user code
  --%>
</head>


<body class="tundra">

  <!-- Fixed navbar -->
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="<c:url value="/services/catalog/singleton"/>">WarehouseController</a>
      </div>
    </div>
  </nav>


<!-- Begin page content -->
<div class="container">
    <div class="page-header">
        <h2>Resource Presentation</h2>
        <h5>Resource Type:&nbsp;
            Waypoint
        </h5>
        <h5>URI:&nbsp;
      <a href="<%= aWaypoint.getAbout() %>"><%= aWaypoint.getAbout() %></a>
        </h5>
    </div>
        <%--
Start of user code (RECOMMENDED) bodyStuff1
        --%>
        <%--
End of user code
        --%>

        <h2>Properties</h2>

        <div>
          <dl class="dl-horizontal">
            <dt>canMove</dt>
            <dd><%= aWaypoint.canMoveToHtml()%></dd>
          </dl>
        </div>


        <table style="clear: both;">
          <tr>
            <td><%= aWaypoint.canMoveToHtml()%></td>
          </tr>
        </table>
      </div>
    </div>

  <footer class="footer">
    <div class="container">
      <p class="text-muted">
        OSLC Adaptor was generated using <a href="http://eclipse.org/lyo">Eclipse Lyo</a> 2.3.0-SNAPSHOT.
      </p>
    </div>
  </footer>
</body>
</html>
