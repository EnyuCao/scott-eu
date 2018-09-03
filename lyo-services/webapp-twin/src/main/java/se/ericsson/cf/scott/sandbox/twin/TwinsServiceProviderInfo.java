// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2014 Jad El-khoury.
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
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package se.ericsson.cf.scott.sandbox.twin;

// Start of user code imports
import java.io.Serializable;
// End of user code

// Start of user code pre_class_code
// End of user code
public class TwinsServiceProviderInfo implements Serializable {
    public String name;
    public String twinKind;
;
    public String twinId;

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods

    @Override
    public String toString() {
        return "TwinsServiceProviderInfo{" + "name='" + name + '\'' + ", twinKind='" + twinKind
            + '\'' + ", twinId='" + twinId + '\'' + '}';
    }

    // End of user code
}

