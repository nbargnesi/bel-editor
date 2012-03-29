package org.openbel.workbench.core.common.lang;

import org.openbel.workbench.core.common.Strings;

/**
 * Denotes the frequency or abundance of events in which a member acts as a
 * kinase, performing enzymatic phosphorylation of a substrate.
 * <p>
 * Function {@link Signature signature(s)}:
 * 
 * <pre>
 * kinaseActivity(F:abundance)abundance
 * </pre>
 * 
 * </p>
 * 
 * @see Signature
 */
public class KinaseActivity extends Function {

    /**
     * {@link Strings#KINASE_ACTIVITY}
     */
    public final static String NAME;

    /**
     * {@link Strings#KINASE_ACTIVITY_ABBREV}
     */
    public final static String ABBREVIATION;

    /**
     * Function description.
     */
    public final static String DESC;

    static {
        NAME = Strings.KINASE_ACTIVITY;
        ABBREVIATION = Strings.KINASE_ACTIVITY_ABBREV;
        DESC = "Denotes the frequency or abundance of events in which a " +
                "member acts as a kinase, performing enzymatic " +
                "phosphorylation of a substrate";
    }

    public KinaseActivity() {
        super(NAME, ABBREVIATION, DESC,
                "kinaseActivity(F:complexAbundance)abundance",
                "kinaseActivity(F:proteinAbundance)abundance");
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
