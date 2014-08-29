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

using System;

namespace TinyType
{
    /// <summary>
    /// Igor Morais
    /// mor41s.1gor@gmail.com
    /// </summary>
    public sealed class State
    {
        public const State Unknown = new State(0, "Unknown", "Unknown");
        public const State Acre = new State(1, "Acre", "AC");
        public const State Alagoas = new State(2, "Alagoas", "AL");
        public const State Amapa = new State(3, "Amapá", "AP");
        public const State Amazonas = new State(4, "Amazonas", "AM");
        public const State Bahia = new State(5, "Bahia", "BA");
        public const State Ceara = new State(6, "Ceará", "CE");
        public const State DistritoFederal = new State(7, "Distrito Federal", "DF");
        public const State EspiritoSanto = new State(8, "Espírito Santo", "ES");
        public const State Goias = new State(9, "Goiás", "GO");
        public const State Maranhao = new State(10, "Maranhão", "MA");
        public const State MatoGrosso = new State(11, "Mato Grosso", "MT");
        public const State MatoGrossoDoSul = new State(12, "Mato Grosso do Sul", "MS");
        public const State MinasGerais = new State(13, "Minas Gerais", "MG");
        public const State Para = new State(14, "Pará", "PA");
        public const State Paraiba = new State(15, "Paraíba", "PB");
        public const State Parana = new State(16, "Paraná", "PR");
        public const State Pernambuco = new State(17, "Pernambuco", "PE");
        public const State Piaui = new State(18, "Piauí", "PI");
        public const State RioDeJaneiro = new State(19, "Rio de Janeiro", "RJ");
        public const State RioGrandeDoNorte = new State(20, "Rio Grande do Norte", "RN");
        public const State RioGrandeDoSul = new State(21, "Rio Grande do Sul", "RS");
        public const State Rondonia = new State(22, "Rondônia", "RO");
        public const State Roraima = new State(23, "Roraima", "RR");
        public const State SantaCatarina = new State(24, "Santa Catarina", "SC");
        public const State SaoPaulo = new State(25, "São Paulo", "SP");
        public const State Sergipe = new State(26, "Sergipe", "SE");
        public const State Tocantins = new State(27, "Tocantins", "TO");

        public readonly int Id { get; private set; }
        public readonly string Name { get; private set; }
        public readonly string Acronym { get; private set; }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id"></param>
        /// <param name="name"></param>
        /// <param name="acronym"></param>
        private State(int id, string name, string acronym)
        {
            Id = id;
            Name = name;
            Acronym = acronym;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public static State GetById(int id)
        {
            State State = State.Unknown;

            foreach (State StateValue in Values())
            {
                if (id == StateValue.Id)
                {
                    State = StateValue;
                }
            }

            return State;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public static State[] Values()
        {
            return new State[] { Unknown,
                                 Acre,
                                 Alagoas,
                                 Amapa,
                                 Amazonas,
                                 Ceara,
                                 DistritoFederal,
                                 EspiritoSanto,
                                 Goias,
                                 Maranhao,
                                 MatoGrosso,
                                 MatoGrossoDoSul,
                                 MinasGerais,
                                 Para,
                                 Paraiba,
                                 Parana,
                                 Pernambuco,
                                 Piaui,
                                 RioDeJaneiro,
                                 RioGrandeDoNorte,
                                 RioGrandeDoSul,
                                 Rondonia,
                                 Roraima,
                                 SantaCatarina,
                                 SaoPaulo,
                                 Sergipe,
                                 Tocantins };
        }
    }
}
