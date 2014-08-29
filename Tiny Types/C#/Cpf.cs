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
using System.Linq;
using System.Text;

namespace TinyType
{
    /// <summary>
    /// Igor Morais
    /// mor41s.1gor@gmail.com
    /// </summary>
    public sealed class Cpf
    {
        /// <summary>
        /// Position of the first dot.
        /// </summary>
        private const byte PositionDotOne = 3;

        /// <summary>
        /// Position of the second dot.
        /// </summary>
        private const byte PositionDotTwo = 7;

        /// <summary>
        /// Position of the hyphen.
        /// </summary>
        private const byte PositionHyphen = 11;

        /// <summary>
        /// Length of the Cpf number without masks.
        /// </summary>
        private const byte LengthUnformatted = 11;

        /// <summary>
        /// Length of the Cpf number with masks.
        /// </summary>
        private const byte LengthFormatted = 14;

        /// <summary>
        /// Masks.
        /// </summary>
        private const char Dot = '.';
        private const char Hyphen = '-';
        private const string Mask = "[.-]";

        /// <summary>
        /// The Cpf number.
        /// </summary>
        private string Number;

        /// <summary>
        /// Default public constructor.
        /// </summary>
        public Cpf()
        {

        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="number">The Cpf number.</param>
        public Cpf(string number)
        {
            SetNumber(number);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="number"></param>
        /// <returns>True if the string have only numbers, otherwise return false.</returns>
        private static bool HasOnlyNumbers(string number)
        {
            bool OnlyNumbers = true;

            try
            {
                long.Parse(number);
            }
            catch (FormatException)
            {
                OnlyNumbers = false;
            }

            return OnlyNumbers;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sum"></param>
        /// <returns></returns>
        private static int Verify(int sum)
        {
            int Value = sum * 10 % 11;

            return Value == 10 || Value == 11 ? 0 : Value;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="number"></param>
        /// <returns>True if the Cpf number is valid, otherwise return false.</returns>
        private static bool HasValidNumber(string number)
        {
            bool ValidNumber = true;

            byte Amount = 0;

            char[] NumberArray = number.Replace(Mask, string.Empty).ToCharArray();

            for (byte i = 1; i < NumberArray.Length; i++)
            {
                if (NumberArray[0] == NumberArray[i])
                {
                    Amount++;
                }
            }

            if (Amount == 10)
            {
                ValidNumber = false;
            }

            return ValidNumber;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="number"></param>
        /// <returns></returns>
        public static string Format(string number)
        {
            if (string.IsNullOrEmpty(number))
            {
                throw new ArgumentException("The Number cannot be null or empty.");
            }

            return new StringBuilder(number)
                .Insert(PositionDotOne, Dot)
                .Insert(PositionDotTwo, Dot)
                .Insert(PositionHyphen, Hyphen)
                .ToString();
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="number"></param>
        /// <returns></returns>
        public static string Unformat(string number)
        {
            if (string.IsNullOrEmpty(number))
            {
                throw new ArgumentException("The Number cannot be null or empty.");
            }

            return number.Replace(Mask, string.Empty);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="number"></param>
        /// <returns>True if the Cpf number have a valid format, otherwise return false.</returns>
        public static bool HasValidFormat(string number)
        {
            if (string.IsNullOrEmpty(number))
            {
                throw new ArgumentException("The Number cannot be null or empty.");
            }

            bool ValidFormat = false;

            if (number.Length == LengthUnformatted)
            {
                if (HasOnlyNumbers(number))
                {
                    ValidFormat = true;
                }
            }
            else if (number.Length == LengthFormatted)
            {
                if (number.ElementAt(PositionDotOne) == Dot &&
                    number.ElementAt(PositionDotTwo) == Dot &&
                    number.ElementAt(PositionHyphen) == Hyphen)
                {
                    if (HasOnlyNumbers(number.Replace(Mask, string.Empty)))
                    {
                        ValidFormat = true;
                    }
                }
            }

            return ValidFormat;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="number"></param>
        /// <returns>True if the Cpf number is valid, otherwise return false.</returns>
        public static bool Validate(string number)
        {
            if (string.IsNullOrEmpty(number))
            {
                throw new ArgumentException("The Number cannot be null or empty.");
            }

            bool Valid = false;

            if (HasValidFormat(number) && HasValidNumber(number))
            {
                char[] NumberArray = number.Length == LengthFormatted ?
                    number.Replace(Mask, String.Empty).ToCharArray() : number.ToCharArray();

                int Sum = 0;

                int VerificationDigit = (int)char.GetNumericValue(NumberArray[9]);

                for (byte i = 0; i < NumberArray.Length - 2; i++)
                {
                    Sum += (int)char.GetNumericValue(NumberArray[i]) * (NumberArray.Length - 1 - i);
                }

                if (Verify(Sum) == VerificationDigit)
                {
                    Sum = 0;

                    VerificationDigit = (int)char.GetNumericValue(NumberArray[10]);

                    for (byte i = 0; i < NumberArray.Length - 1; i++)
                    {
                        Sum += (int)char.GetNumericValue(NumberArray[i]) * (NumberArray.Length - i);
                    }
                }

                if (Verify(Sum) == VerificationDigit)
                {
                    Valid = true;
                }
            }

            return Valid;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns>The unformatted Cpf number.</returns>
        public string GetUnformattedNumber()
        {
            return Number;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns>The formatted Cpf number.</returns>
        public string GetFormattedNumber()
        {
            return new StringBuilder(Number)
                .Insert(PositionDotOne, Dot)
                .Insert(PositionDotTwo, Dot)
                .Insert(PositionHyphen, Hyphen)
                .ToString();
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="number">The Cpf number.</param>
        public void SetNumber(string number)
        {
            if (string.IsNullOrEmpty(number))
            {
                throw new ArgumentException("The Number cannot be null or empty.");
            }

            this.Number = number.Replace(Mask, String.Empty);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns>True if the Cpf number is valid, otherwise return false.</returns>
        public bool IsValid()
        {
            return Validate(Number);
        }
    }
}
