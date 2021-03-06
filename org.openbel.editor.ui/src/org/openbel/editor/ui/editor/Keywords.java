/**
 * Copyright (c) 2012 Selventa.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html

 * Contributors:
 *     Selventa - initial API and implementation
 */

package org.openbel.editor.ui.editor;

import static org.openbel.editor.ui.editor.TokenClass.FUNCTION;
import static org.openbel.editor.ui.editor.TokenClass.KEYWORD;

public enum Keywords {

    SET("SET", KEYWORD, ""),
    UNSET("UNSET", KEYWORD, ""),
    DEFINE("DEFINE", KEYWORD, ""),
    AS("AS", KEYWORD, ""),

    DOCUMENT("DOCUMENT", KEYWORD, ""),
    NAMESPACE("NAMESPACE", KEYWORD, ""),
    ANNOTATION("ANNOTATION", KEYWORD, ""),
    URL("URL", KEYWORD, ""),
    STATEMENT_GROUP("STATEMENT_GROUP", KEYWORD, ""),

    PROTEIN_ABUNDANCE("proteinAbundance", FUNCTION, ""),
    RNA_ABUNDANCE("rnaAbundance", FUNCTION, ""),
    GENE_ABUNDANCE("geneAbundance", FUNCTION, ""),
    MICRO_RNA_ABUNDANCE("microRNAAbundance", FUNCTION, ""),
    ABUNDANCE("abundance", FUNCTION, ""),
    KINASE_ACTIVITY("kinaseActivity", FUNCTION, ""),
    CATALYTIC_ACTIVITY("catalyticActivity", FUNCTION, "");

    String value, description = "";
    TokenClass tokenClass;

    Keywords(String val) {
        value = val;
    }

    Keywords(String val, TokenClass c, String desc) {
        value = val;
        tokenClass = c;
        description = desc;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
