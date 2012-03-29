package org.openbel.workbench.ui.text;

import static java.lang.Character.isLetter;
import static java.lang.Character.isLowerCase;
import static org.openbel.workbench.ui.UIConstants.FUNCTION;
import static org.openbel.workbench.ui.UIConstants.OTHER;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ui.text.AbstractScriptScanner;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.dltk.ui.text.rules.IScriptWordDetector;
import org.eclipse.dltk.ui.text.rules.ScriptWordRule;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;

/**
 * Highlights function syntactic elements.
 */
public class FunctionScanner extends AbstractScriptScanner {

    public static String[] FUNCTIONS = {
            "a", "abundance", "act", "biologicalProcess", "bp",
            "cat", "catalyticActivity", "cellSecretion",
            "cellSurfaceExpression", "chap",
            "chaperoneActivity", "complex", "complexAbundance", "composite",
            "compositeAbundance", "deg", "degradation", "fus", "fusion", "g",
            "geneAbundance", "gtp", "gtpBoundActivity", "kin",
            "kinaseActivity", "list", "m", "microRNAAbundance",
            "molecularActivity", "p", "path", "pathology", "pep",
            "peptidaseActivity", "phos", "phosphataseActivity", "pmod",
            "products", "proteinAbundance", "proteinModification", "r",
            "reactants", "reaction", "ribo", "ribosylationActivity",
            "rnaAbundance", "rxn", "sec", "sub", "substitution", "surf",
            "tloc", "tport", "transcriptionalActivity", "translocation",
            "transportActivity", "trunc", "truncation", "tscript"
    };

    /**
     * BEL function scanner.
     * 
     * @param manager
     *            Color manager
     * @param store
     *            Preference store
     */
    public FunctionScanner(IColorManager manager, IPreferenceStore store) {
        super(manager, store);
        this.initialize();
    }

    @Override
    protected List<IRule> createRules() {
        List<IRule> rules = new ArrayList<IRule>();

        IToken function = this.getToken(FUNCTION);
        IToken other = this.getToken(OTHER);

        ScriptWordRule swr = new ScriptWordRule(new FunctionDetector(), other);
        for (String s : FUNCTIONS) {
            swr.addWord(s, function);
        }
        rules.add(swr);

        this.setDefaultReturnToken(other);
        return rules;
    }

    @Override
    protected String[] getTokenProperties() {
        return new String[] { FUNCTION };
    }

    /**
     * Detects BEL functions.
     */
    private static class FunctionDetector implements IScriptWordDetector {

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isWordPart(char c) {
            System.out.print(c);
            boolean ret = isLetter(c);
            if (!ret) System.out.println(" (false)");
            return ret;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isWordStart(char c) {
            System.out.print("\nFunction: " + c);
            return isLowerCase(c);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isPriorCharValid(char c) {
            return true;
        }
    }
}
