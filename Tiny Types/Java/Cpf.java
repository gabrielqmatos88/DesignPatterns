/*
 * Copyright (c) 2014 HollowSoft @IgorMorais
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 *
 *          You may obtain a copy of the License at
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package tinytype;

/**
 * @author Igor Morais
 * @author mor41s.1gor@gmail.com
 */
public final class Cpf {

    /**
     * Position of the first dot.
     */
    private static final byte POSITION_DOT_ONE = 3;

    /**
     * Position of the second dot.
     */
    private static final byte POSITION_DOT_TWO = 7;

    /**
     * Position of the hyphen.
     */
    private static final byte POSITION_HYPHEN = 11;

    /**
     * Length of the {@code Cpf} number without masks.
     */
    private static final byte LENGTH_UNFORMATTED = 11;

    /**
     * Length of the {@code Cpf} number with masks.
     */
    private static final byte LENGTH_FORMATTED = 14;

    /**
     * String empty value.
     */
    private static final String EMPTY = "";

    /**
     * Masks.
     */
    private static final char DOT = '.';
    private static final char HYPHEN = '-';
    private static final String MASK = "[.-]";

    /**
     * The {@code Cpf} number.
     */
    private String number;

    /**
     * Default public constructor.
     */
    public Cpf() {

    }

    /**
     *
     * @param number
     *            The {@code Cpf} number.
     */
    public Cpf(final String number) {
        setNumber(number);
    }

    /**
     *
     * @param number
     * @return {@code True} if the {@code String} have only numbers, otherwise
     *         return {@code false}.
     */
    private static boolean hasOnlyNumbers(final String number) {
        boolean onlyNumbers = true;

        try {

            Long.parseLong(number);

        } catch (final NumberFormatException e) {
            onlyNumbers = false;
        }

        return onlyNumbers;
    }

    /**
     *
     * @param sum
     * @return
     */
    private static int verify(final int sum) {
        final int value = sum * 10 % 11;

        return value == 10 || value == 11 ? 0 : value;
    }

    /**
     *
     * @param number
     * @return {@code True} if the {@code Cpf} number is valid, otherwise return
     *         {@code false}.
     */
    private static boolean hasValidNumber(final String number) {
        boolean validNumber = true;

        byte amount = 0;

        final char[] numberArray = number.replaceAll(MASK, EMPTY).toCharArray();

        for (byte i = 1; i < numberArray.length; i++) {

            if (numberArray[0] == numberArray[i]) {
                amount++;
            }
        }

        if (amount == 10) {
            validNumber = false;
        }

        return validNumber;
    }

    /**
     *
     * @param number
     * @return
     */
    public static String format(final String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("The number cannot be nul or empty.");
        }

        return new StringBuilder(number).insert(POSITION_DOT_ONE, DOT).insert(POSITION_DOT_TWO, DOT)
                .insert(POSITION_HYPHEN, HYPHEN).toString();
    }

    /**
     *
     * @param number
     * @return
     */
    public static String unformat(final String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("The number cannot be nul or empty.");
        }

        return number.replaceAll(MASK, EMPTY);
    }

    /**
     *
     * @param number
     * @return {@code True} if the {@code Cpf} number have a valid format,
     *         otherwise return {@code false}.
     */
    public static boolean hasValidFormat(final String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("The number cannot be nul or empty.");
        }

        boolean validFormat = false;

        if (number.length() == LENGTH_UNFORMATTED) {

            if (hasOnlyNumbers(number)) {
                validFormat = true;
            }

        } else if (number.length() == LENGTH_FORMATTED) {

            if (number.charAt(POSITION_DOT_ONE) == DOT && number.charAt(POSITION_DOT_TWO) == DOT
                    && number.charAt(POSITION_HYPHEN) == HYPHEN) {

                if (hasOnlyNumbers(number.replaceAll(MASK, EMPTY))) {
                    validFormat = true;
                }
            }
        }

        return validFormat;
    }

    /**
     *
     * @param number
     * @return {@code True} if the {@code Cpf} number is valid, otherwise return
     *         {@code false}.
     */
    public static boolean validate(final String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("The number cannot be nul or empty.");
        }

        boolean valid = false;

        if (hasValidFormat(number) && hasValidNumber(number)) {

            final char[] numberArray = number.length() == LENGTH_FORMATTED ? number.replaceAll(MASK, EMPTY)
                    .toCharArray() : number.toCharArray();

            int sum = 0;

            int verificationDigit = Character.getNumericValue(numberArray[9]);

            for (byte i = 0; i < numberArray.length - 2; i++) {

                sum += Character.getNumericValue(numberArray[i]) * (numberArray.length - 1 - i);
            }

            if (verify(sum) == verificationDigit) {

                sum = 0;

                verificationDigit = Character.getNumericValue(numberArray[10]);

                for (byte i = 0; i < numberArray.length - 1; i++) {

                    sum += Character.getNumericValue(numberArray[i]) * (numberArray.length - i);
                }

                if (verify(sum) == verificationDigit) {
                    valid = true;
                }
            }
        }

        return valid;
    }

    /**
     *
     * @return The unformatted {@code Cpf} number.
     */
    public String getUnformattedNumber() {
        return number;
    }

    /**
     *
     * @return The formatted {@code Cpf} number.
     */
    public String getFormattedNumber() {
        return new StringBuilder(number).insert(POSITION_DOT_ONE, DOT).insert(POSITION_DOT_TWO, DOT)
                .insert(POSITION_HYPHEN, HYPHEN).toString();
    }

    /**
     *
     * @param number
     *            The {@code Cpf} number.
     */
    public void setNumber(final String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("The number cannot be nul or empty.");
        }

        this.number = number.replaceAll(MASK, EMPTY);
    }

    /**
     *
     * @return {@code True} if the {@code Cpf} number is valid, otherwise return
     *         {@code false}.
     */
    public boolean isValid() {
        return validate(number);
    }
}
