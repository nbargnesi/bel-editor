/**
 * Copyright (c) 2012 Selventa.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html

 * Contributors:
 *     Selventa - initial API and implementation
 */

package org.openbel.editor.core.common.enums;

import static org.openbel.editor.core.common.BELUtilities.constrainedHashMap;

import java.util.Map;

/**
 * Enumerated representation of semantic status.
 * <p>
 * Portions of this enum have been automatically generated.
 * </p>
 */
public enum SemanticStatus {

    /**
     * No semantic failure.
     * <p>
     * e.g.,
     * <ul>
     * <li>{@code foo()bar} and</li>
     * <li>{@code foo()bar}</li>
     * </ul>
     * </p>
     */
    VALID(0, "Valid"),

    /**
     * Invalid function.
     * <p>
     * e.g.,
     * <ul>
     * <li>{@code foo()bar} and</li>
     * <li>{@code fop()bar}</li>
     * </ul>
     * </p>
     */
    INVALID_FUNCTION(1,
            "mismatched function names"
    ),

    /**
     * Invalid return type.
     * <p>
     * e.g.,
     * <ul>
     * <li>{@code foo()bar} and</li>
     * <li>{@code foo()baz}</li>
     * </ul>
     * </p>
     */
    INVALID_RETURN_TYPE(2,
            "mismatched return types"
    ),

    /**
     * Invalid encoding argument.
     * <p>
     * e.g.,
     * <ul>
     * <li>{@code foo(E:A)bar} and</li>
     * <li>{@code foo(E:B)bar}</li>
     * </ul>
     * </p>
     */
    INVALID_ENCODING_ARGUMENT(3,
            "the encoded argument is not valid"
    ),

    /**
     * Invalid return type argument.
     * <p>
     * e.g.,
     * <ul>
     * <li>{@code foo(F:bar)fop} and</li>
     * <li>{@code foo(F:baz)fop}</li>
     * </ul>
     * </p>
     */
    INVALID_RETURN_TYPE_ARGUMENT(4,
            "the function argument is not valid"
    ),

    /**
     * Too many arguments.
     * <p>
     * e.g.,
     * <ul>
     * <li>{@code foo(F:bar,F:baz)fop} and</li>
     * <li>{@code foo(F:bar,F:baz,F:bat))fop}</li>
     * </ul>
     * </p>
     */
    TOO_MANY_ARGUMENTS(5,
            "incorrect number of arguments (too many)"
    ),

    /**
     * Too few arguments.
     * <p>
     * e.g.,
     * <ul>
     * <li>{@code foo(F:bar,F:baz)fop} and</li>
     * <li>{@code foo(F:bar)fop}</li>
     * </ul>
     * </p>
     */
    TOO_FEW_ARGUMENTS(6,
            "incorrect number of arguments (too few)"
    );

    /* Value unique to each enumeration. */
    private final Integer value;
    /* Enumeration display value. */
    private String displayValue;

    /* Static cache of enum by string representation. */
    private static final Map<String, SemanticStatus> STRINGTOENUM;
    static {
        STRINGTOENUM = constrainedHashMap(values().length);
        for (final SemanticStatus e : values())
            STRINGTOENUM.put(e.toString(), e);
    }

    /**
     * Constructor for setting enum and display value.
     * 
     * @param value
     *            Enum value
     * @param displayValue
     *            Display value
     */
    private SemanticStatus(Integer value, String displayValue) {
        this.value = value;
        this.displayValue = displayValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return displayValue;
    }

    /**
     * Returns the semantic status's value.
     * 
     * @return value
     * @see java.lang.Enum#ordinal() Contrast with {@code ordinal}
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Returns the semantic status's display value.
     * 
     * @return display value
     */
    public String getDisplayValue() {
        return displayValue;
    }

    /**
     * Returns the semantic status by its string representation
     * (case-insensitive).
     * 
     * @param s
     *            Semantic status string representation
     * @return SemanticStatus, may be null if the provided string has no
     *         semantic status representation
     */
    public static SemanticStatus getSemanticStatus(final String s) {
        SemanticStatus e = STRINGTOENUM.get(s);
        if (e != null)
            return e;

        for (final String dispval : STRINGTOENUM.keySet()) {
            if (dispval.equalsIgnoreCase(s))
                return STRINGTOENUM.get(dispval);
        }

        return null;
    }
}
