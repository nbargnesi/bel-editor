/**
 * Copyright (c) 2012 Selventa.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html

 * Contributors:
 *     Selventa - initial API and implementation
 */

package org.openbel.editor.ui.util;

import static org.openbel.editor.core.common.BELUtilities.asPath;
import static org.openbel.editor.core.common.BELUtilities.readable;
import static org.openbel.editor.core.common.PathConstants.SYSCONFIG_FILENAME;
import static org.openbel.editor.ui.UIFunctions.isNix;
import static org.openbel.editor.ui.UIFunctions.isWindows;

import java.io.File;

import org.openbel.editor.ui.preferences.BELFrameworkPreferencePage;

/**
 * Defines validation utilities for the BEL Editor.
 */
public class ValidationUtilities {

    /**
     * Validate the {@link BELFrameworkPreferencePage#BF_PREF_KEY BEL Framework}
     * preference.
     * 
     * @param belFrameworkHome the {@link String path} to the BEL Framework
     *            home, which cannot be null
     * @return the {@link FileState file state} result for validation of this
     *         path, or {@code null} if the {@code belFrameworkHome} was
     *         {@code null}
     * @throws IllegalArgumentException Thrown if {@code belFrameworkHome} is
     *             {@code null}
     */
    public static FileState validateFramework(
            final String belFrameworkHome) {
        String path = asPath(belFrameworkHome, "config", SYSCONFIG_FILENAME);
        File file = new File(path);
        if (!readable(file)) {
            return FileState.FAIL_READ;
        }

        if (isNix()) {
            String belc_sh = asPath(belFrameworkHome, "belc.sh");
            if (!readable(new File(belc_sh))) {
                return FileState.FAIL_MISSING;
            }
        } else if (isWindows()) {
            String belc_cmd = asPath(belFrameworkHome, "belc.cmd");
            if (!readable(new File(belc_cmd))) {
                return FileState.FAIL_MISSING;
            }
        }
        return FileState.OK;
    }

    /**
     * Validate the cytoscape installation path.
     * 
     * @param path The {@link String path} to the Cytoscape installation
     * @return {@link FileState}
     */
    public static FileState validateCytoscape(final String path) {
        if (isWindows()) {
            String exe = asPath(path, "Cytoscape.exe");
            if (!readable(new File(exe))) {
                return FileState.FAIL_READ;
            }
            return FileState.OK;
        }
        String sh = asPath(path, "cytoscape.sh");
        if (!readable(new File(sh))) {
            return FileState.FAIL_READ;
        }
        return FileState.OK;
    }

    /**
     * Prevent public instantiation.
     */
    private ValidationUtilities() {
        // no-op
    }

    /**
     * {@link FileState} defines different states of a file system resource.
     */
    public enum FileState {
        OK, FAIL_MISSING, FAIL_READ;
    }
}
