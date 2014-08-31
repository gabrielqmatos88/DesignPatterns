/*
 * Copyright (c) 2014 HollowSoft @IgorMorais
 *
 * Licensed under the Apache License, Version 2.0 (the �License�);
 * you may not use this file except in compliance with the License.
 *
 *          You may obtain a copy of the License at
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an �AS IS� BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package pattern;

/**
 * @author Igor Morais
 * @author mor41s.1gor@gmail.com
 */
public enum State {

    UNKNOWN                 (0, "Unknown", "Unknown"),
    ACRE                    (1, "Acre", "AC"),
    ALAGOAS                 (2, "Alagoas", "AL"),
    AMAPA                   (3, "Amap�", "AP"),
    AMAZONAS                (4, "Amazonas", "AM"),
    BAHIA                   (5, "Bahia", "BA"),
    CEARA                   (6, "Cear�", "CE"),
    DISTRITO_FEDERAL        (7, "Distrito Federal", "DF"),
    ESPIRITO_SANTO          (8, "Esp�rito Santo", "ES"),
    GOIAS                   (9, "Goi�s", "GO"),
    MARANHAO                (10, "Maranh�o", "MA"),
    MATO_GROSSO             (11, "Mato Grosso", "MT"),
    MATO_GROSSO_DO_SUL      (12, "Mato Grosso do Sul", "MS"),
    MINAS_GERAIS            (13, "Minas Gerais", "MG"),
    PARA                    (14, "Par�", "PA"),
    PARAIBA                 (15, "Para�ba", "PB"),
    PARANA                  (16, "Paran�", "PR"),
    PERNAMBUCO              (17, "Pernambuco", "PE"),
    PIAUI                   (18, "Piau�", "AC"),
    RIO_DE_JANEIRO          (19, "Rio de Janeiro", "RJ"),
    RIO_GRANDE_DO_NORTE     (20, "Rio Grande do Norte", "RN"),
    RIO_GRANDE_DO_SUL       (21, "Rio Grande do Sul", "RS"),
    RONDONIA                (22, "Rond�nia", "RO"),
    RORAIMA                 (23, "Roraima", "RR"),
    SANTA_CATARINA          (24, "Santa Catarina", "SC"),
    SAO_PAULO               (25, "S�o Paulo", "SP"),
    SERGIPE                 (26, "Sergipe", "SE"),
    TOCANTINS               (27, "Tocantins", "TO");

    private final int id;
    private final String name;
    private final String acronym;

    /**
     *
     * @param id
     * @param name
     * @param acronym
     */
    private State(final int id, final String name, final String acronym) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
    }

    /**
     * @return The id
     */
    public final int getId() {
        return id;
    }

    /**
     * @return The name
     */
    public final String getName() {
        return name;
    }

    /**
     * @return The acronym
     */
    public final String getAcronym() {
        return acronym;
    }

    /**
     *
     * @param id
     * @return
     */
    public static State getById(final long id) {
        State state = State.UNKNOWN;

        for (final State stateValue : State.values()) {

            if (id == stateValue.getId()) {
                state = stateValue;
            }
        }

        return state;
    }
}
