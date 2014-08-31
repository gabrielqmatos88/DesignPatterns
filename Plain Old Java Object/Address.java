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

package pattern;

import pattern.State;

/**
 * @author Igor Morais
 * @author mor41s.1gor@gmail.com
 */
public final class Address {

    private long id;
    private String street;
    private String number;
    private String complement;
    private String referencePoint;
    private String city;
    private State state;
    private String postalCode;

    /**
     * @return The id
     */
    public final long getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set
     */
    public final void setId(final long id) {
        this.id = id;
    }

    /**
     * @return The street
     */
    public final String getStreet() {
        return street;
    }

    /**
     * @param street
     *            The street to set
     */
    public final void setStreet(final String street) {
        this.street = street;
    }

    /**
     * @return The number
     */
    public final String getNumber() {
        return number;
    }

    /**
     * @param number
     *            The number to set
     */
    public final void setNumber(final String number) {
        this.number = number;
    }

    /**
     * @return The complement
     */
    public final String getComplement() {
        return complement;
    }

    /**
     * @param complement
     *            The complement to set
     */
    public final void setComplement(final String complement) {
        this.complement = complement;
    }

    /**
     * @return The referencePoint
     */
    public final String getReferencePoint() {
        return referencePoint;
    }

    /**
     * @param referencePoint
     *            The referencePoint to set
     */
    public final void setReferencePoint(final String referencePoint) {
        this.referencePoint = referencePoint;
    }

    /**
     * @return The city
     */
    public final String getCity() {
        return city;
    }

    /**
     * @param city
     *            The city to set
     */
    public final void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return The state
     */
    public final State getState() {
        return state;
    }

    /**
     * @param state
     *            The state to set
     */
    public final void setState(final State state) {
        this.state = state;
    }

    /**
     * @return The postalCode
     */
    public final String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode
     *            The postalCode to set
     */
    public final void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }
}
