// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.android.core.http.implementation;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains utility methods useful for building client libraries.
 */
public final class Util {
    private static final Charset UTF_32BE = Charset.forName("UTF-32BE");
    private static final Charset UTF_32LE = Charset.forName("UTF-32LE");
    private static final byte ZERO = (byte) 0x00;
    private static final byte BB = (byte) 0xBB;
    private static final byte BF = (byte) 0xBF;
    private static final byte EF = (byte) 0xEF;
    private static final byte FE = (byte) 0xFE;
    private static final byte FF = (byte) 0xFF;
    private static final Pattern CHARSET_PATTERN = Pattern.compile("charset=([\\S]+)\\b", Pattern.CASE_INSENSITIVE);
    private static final DateTimeFormatter RFC1123_DATE_TIME_FORMATTER =
        DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'").withZone(ZoneId.of("UTC")).withLocale(Locale.US);

    private Util() {
        // Exists only to defeat instantiation.
    }

    /**
     * Parse the given Rfc1123 value to {@link OffsetDateTime}.
     *
     * @param formattedString The Rfc1123 formatted string to parse
     * @return The parsed value in {@link OffsetDateTime} format.
     */
    public static OffsetDateTime parseRfc1123Time(String formattedString) {
        return OffsetDateTime.parse(formattedString, DateTimeFormatter.RFC_1123_DATE_TIME);
    }

    /**
     * Creates a copy of the source byte array.
     * @param source Array to make copy of
     * @return A copy of the array, or null if source was null.
     */
    public static byte[] clone(byte[] source) {
        if (source == null) {
            return null;
        }
        byte[] copy = new byte[source.length];
        System.arraycopy(source, 0, copy, 0, source.length);
        return copy;
    }

    /**
     * Creates a copy of the source int array.
     * @param source Array to make copy of
     * @return A copy of the array, or null if source was null.
     */
    public static int[] clone(int[] source) {
        if (source == null) {
            return null;
        }
        int[] copy = new int[source.length];
        System.arraycopy(source, 0, copy, 0, source.length);
        return copy;
    }

    /**
     * Creates a copy of the source array.
     * @param source Array being copied.
     * @param <T> Generic representing the type of the source array.
     * @return A copy of the array or null if source was null.
     */
    public static <T> T[] clone(T[] source) {
        if (source == null) {
            return null;
        }

        return Arrays.copyOf(source, source.length);
    }

    /**
     * Checks if the array is null or empty.
     * @param array Array being checked for nullness or emptiness.
     * @return True if the array is null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Checks if the collection is null or empty.
     * @param collection Collection being checked for nullness or emptiness.
     * @return True if the collection is null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Checks if the map is null or empty.
     * @param map Map being checked for nullness or emptiness.
     * @return True if the map is null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * Checks if the character sequence is null or empty.
     * @param charSequence Character sequence being checked for nullness or emptiness.
     * @return True if the character sequence is null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /**
     * Attempts to convert a byte stream into the properly encoded String.
     * <p>
     * This utility method will attempt to find the encoding for the String in this order.
     * <ol>
     *     <li>Find the byte order mark in the byte array.</li>
     *     <li>Find the {@code charset} in the {@code Content-Type} header.</li>
     *     <li>Default to {@code UTF-8}.</li>
     * </ol>
     *
     * @param bytes Byte array.
     * @param contentType {@code Content-Type} header value.
     * @return A string representation of the byte array encoded to the found encoding.
     */
    public static String bomAwareToString(byte[] bytes, String contentType) {
        if (bytes == null) {
            return null;
        }

        if (bytes.length >= 3 && bytes[0] == EF && bytes[1] == BB && bytes[2] == BF) {
            return new String(bytes, 3, bytes.length - 3, StandardCharsets.UTF_8);
        } else if (bytes.length >= 4 && bytes[0] == ZERO && bytes[1] == ZERO && bytes[2] == FE && bytes[3] == FF) {
            return new String(bytes, 4, bytes.length - 4, UTF_32BE);
        } else if (bytes.length >= 4 && bytes[0] == FF && bytes[1] == FE && bytes[2] == ZERO && bytes[3] == ZERO) {
            return new String(bytes, 4, bytes.length - 4, UTF_32LE);
        } else if (bytes.length >= 2 && bytes[0] == FE && bytes[1] == FF) {
            return new String(bytes, 2, bytes.length - 2, StandardCharsets.UTF_16BE);
        } else if (bytes.length >= 2 && bytes[0] == FF && bytes[1] == FE) {
            return new String(bytes, 2, bytes.length - 2, StandardCharsets.UTF_16LE);
        } else {
            /*
             * Attempt to retrieve the default charset from the 'Content-Encoding' header, if the value isn't
             * present or invalid fallback to 'UTF-8' for the default charset.
             */
            if (!isNullOrEmpty(contentType)) {
                try {
                    Matcher charsetMatcher = CHARSET_PATTERN.matcher(contentType);
                    if (charsetMatcher.find()) {
                        return new String(bytes, Charset.forName(charsetMatcher.group(1)));
                    } else {
                        return new String(bytes, StandardCharsets.UTF_8);
                    }
                } catch (IllegalCharsetNameException | UnsupportedCharsetException ex) {
                    return new String(bytes, StandardCharsets.UTF_8);
                }
            } else {
                return new String(bytes, StandardCharsets.UTF_8);
            }
        }
    }
}
