/**
 * Copyright (c) 2012 Selventa.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html

 * Contributors:
 *     Selventa - initial API and implementation
 */

package org.openbel.workbench.core.common.lang;

import org.openbel.workbench.core.common.Strings;

/**
 * Denotes the frequency or abundance of events in which a member acts to
 * catalyze an oxidation-reduction reaction.
 * <p>
 * Function {@link Signature signature(s)}:
 * 
 * <pre>
 * oxidoreductaseActivity(F:abundance)abundance
 * </pre>
 * 
 * </p>
 * 
 * @see Signature
 */
public class OxidoreductaseActivity extends Function {

    /**
     * {@link Strings#OXIDOREDUCTASE_ACTIVITY}
     */
    public final static String NAME;

    /**
     * {@link Strings#OXIDOREDUCTASE_ACTIVITY_ABBREV}
     */
    public final static String ABBREVIATION;

    /**
     * Function description.
     */
    public final static String DESC;

    static {
        NAME = Strings.OXIDOREDUCTASE_ACTIVITY;
        ABBREVIATION = Strings.OXIDOREDUCTASE_ACTIVITY_ABBREV;
        DESC = "Denotes the frequency or abundance of events in which a " +
                "member acts to catalyze an oxidation-reduction reaction";
    }

    public OxidoreductaseActivity() {
        super(NAME, ABBREVIATION, DESC,
                "oxidoreductaseActivity(F:complexAbundance)abundance",
                "oxidoreductaseActivity(F:proteinAbundance)abundance");
    }

    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean validArgumentCount(int count) {
        switch (count) {
        case 1:
            return true;
        default:
            return false;
        }
    }
}
