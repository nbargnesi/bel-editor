/**
 * Copyright (c) 2012 Selventa.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html

 * Contributors:
 *     Selventa - initial API and implementation
 */

package org.openbel.editor.core.record;

import static org.openbel.editor.core.common.Strings.SHA_256;
import static org.openbel.editor.core.common.Strings.UTF_8;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hasher is a singleton used to hash {@link String} input and produce a
 * byte array.
 *
 * @author Anthony Bargnesi &lt;abargnesi@selventa.com&gt;
 */
public enum Hasher {
    INSTANCE;

    /**
     * Defines the SHA-256 message digest to hash with.
     */
    private final MessageDigest sha256Digest;

    /**
     * Defines the hex character set.
     */
    private final String HEXES = "0123456789abcdef";

    /**
     * Constructs the Hasher by creating a "SHA-256" message digest.
     *
     * @throws MissingAlgorithmException Unchecked exception thrown if the
     * "SHA-256" algorithm is missing on the current environment
     */
    private Hasher() {
        try {
            sha256Digest = MessageDigest.getInstance(SHA_256);
        } catch (NoSuchAlgorithmException e) {
            throw new MissingAlgorithmException(SHA_256, e);
        }
    }

    /**
     * Hash a {@link String} value, read as "UTF-8", using the SHA-256
     * algorithm.
     *
     * @param value {@link String}, the value to hash
     * @return {@link String} the hash string represented in base 16
     * @throws MissingAlgorithmException Unchecked exception thrown if the
     * SHA-256 algorithm is missing on the current environment
     * @throws MissingEncodingException Unchecked exception thrown if the
     * UTF-8 character encoding is missing on the current environment
     */
    public String hashValue(String value) {
        if(value == null) {
            return null;
        }

        try {
            return hash(value.getBytes(UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new MissingAlgorithmException(SHA_256, e);
        } catch (UnsupportedEncodingException e) {
            throw new MissingEncodingException(UTF_8, e);
        }
    }

    /**
     * Hashes the <tt>input</tt> byte array.  The process is:<ul>
     * <li>Reset the SHA-256 digest.</li>
     * <li>Update the digest with the <tt>input</tt> byte array</li>
     * <li>Hash the <tt>digest</tt> data and return base 16 {@link String}</li>
     * </ul>
     *
     * @param input <tt>byte[]</tt> the byte array to hash
     * @return {@link String} the hash string represented in base 16
     * @throws NoSuchAlgorithmException Thrown if the "SHA-256" algorithm is
     * not available on the current runtime
     */
    private String hash(byte[] input) throws NoSuchAlgorithmException {
        sha256Digest.reset();
        sha256Digest.update(input);
        return getHex(sha256Digest.digest());
    }

    /**
     * Converts the <tt>byte[]</tt> to a hexadecimal string.
     *
     * @param bytes <tt>byte[]</tt>, the byte array to convert to hexadecimal
     * @return {@link String} representing the hexadecimal string, using
     * lowercase a-f as the six additional symbols
     */
    private String getHex(byte[] bytes) {
        if (bytes == null) {
            return null;
        }

        final StringBuilder hex = new StringBuilder(2 * bytes.length);

        for (final byte b : bytes) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(
                    HEXES.charAt((b & 0x0F)));
        }

        return hex.toString();
    }
}
