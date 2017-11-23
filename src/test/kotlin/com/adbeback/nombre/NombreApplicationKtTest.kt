package com.adbeback.nombre

import org.assertj.core.api.Assertions
import org.junit.Test

import java.util.*

class NombreApplicationKtTest {
    @Test
    fun should_return_letter_0_to_9() {
        val values = Arrays.asList("zero", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf")

        values.withIndex().forEach { (value, expected) ->
            Assertions.assertThat(value.compute()).isEqualTo(expected)
        }

    }


    @Test
    fun should_return_letter_10_to_19() {
        val values = Arrays.asList("dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf")

        values.withIndex().forEach { (value, expected) ->
            Assertions.assertThat(value.plus(10).compute()).isEqualTo(expected)
        }

    }

    @Test
    fun should_return_letter_20() {
        Assertions.assertThat(20.compute()).isEqualTo("vingt")
    }

    @Test
    fun should_return_letter_21() {
        Assertions.assertThat(21.compute()).isEqualTo("vingt et un")
    }

    @Test
    fun should_return_letter_22() {
        Assertions.assertThat(22.compute()).isEqualTo("vingt-deux")
    }

    @Test
    fun should_return_letter_30() {
        Assertions.assertThat(30.compute()).isEqualTo("trente")
    }

    @Test
    fun should_return_letter_31() {
        Assertions.assertThat(31.compute()).isEqualTo("trente et un")
    }


    @Test
    fun should_return_letter_71_to_79() {
        val values = Arrays.asList(
                "soixante et onze",
                "soixante-douze",
                "soixante-treize",
                "soixante-quatorze",
                "soixante-quinze",
                "soixante-seize",
                "soixante-dix-sept",
                "soixante-dix-huit",
                "soixante-dix-neuf")

        values.withIndex().forEach { (value, expected) ->
            Assertions.assertThat(value.plus(71).compute()).isEqualTo(expected)
        }
    }



    @Test
    fun should_return_letter_80() {
        Assertions.assertThat(80.compute()).isEqualTo("quatre-vingts")
    }

    @Test
    fun should_return_letter_81() {
        Assertions.assertThat(81.compute()).isEqualTo("quatre-vingt-un")
    }


    @Test
    fun should_return_letter_81_to_89() {
        val values = Arrays.asList(
                "quatre-vingt-un",
                "quatre-vingt-deux",
                "quatre-vingt-trois",
                "quatre-vingt-quatre",
                "quatre-vingt-cinq",
                "quatre-vingt-six",
                "quatre-vingt-sept",
                "quatre-vingt-huit",
                "quatre-vingt-neuf")

        values.withIndex().forEach { (value, expected) ->
            Assertions.assertThat(value.plus(81).compute()).isEqualTo(expected)
        }
    }

    @Test
    fun should_return_letter_90() {
        Assertions.assertThat(90.compute()).isEqualTo("quatre-vingt-dix")
    }

    @Test
    fun should_return_letter_91_to_99() {
        val values = Arrays.asList(
                "quatre-vingt-onze",
                "quatre-vingt-douze",
                "quatre-vingt-treize",
                "quatre-vingt-quatorze",
                "quatre-vingt-quinze",
                "quatre-vingt-seize",
                "quatre-vingt-dix-sept",
                "quatre-vingt-dix-huit",
                "quatre-vingt-dix-neuf")

        values.withIndex().forEach { (value, expected) ->
            Assertions.assertThat(value.plus(91).compute()).isEqualTo(expected)
        }
    }

    @Test
    fun should_return_letter_100() {
        Assertions.assertThat(100.compute()).isEqualTo("cent")
    }

    @Test
    fun should_return_letter_101() {
        Assertions.assertThat(101.compute()).isEqualTo("cent un")
    }

    @Test
    fun should_return_letter_200() {
        Assertions.assertThat(200.compute()).isEqualTo("deux cents")
    }

    @Test
    fun should_return_letter_201() {
        Assertions.assertThat(201.compute()).isEqualTo("deux cent un")
    }


    @Test
    fun should_return_letter_1000() {
        Assertions.assertThat(1000.compute()).isEqualTo("mille")
    }

    @Test
    fun should_return_letter_1001() {
        Assertions.assertThat(1001.compute()).isEqualTo("mille un")
    }

    @Test
    fun should_return_letter_2000() {
        Assertions.assertThat(2000.compute()).isEqualTo("deux milles")
    }

    @Test
    fun should_return_letter_2001() {
        Assertions.assertThat(2001.compute()).isEqualTo("deux mille un")
    }

    @Test
    fun should_return_letter_10000() {
        Assertions.assertThat(10000.compute()).isEqualTo("dix milles")
    }


    @Test
    fun should_return_letter_100000() {
        Assertions.assertThat(100000.compute()).isEqualTo("cent milles")
    }

    @Test
    fun should_return_letter_100001() {
        Assertions.assertThat(100001.compute()).isEqualTo("cent mille un")
    }

    @Test
    fun should_return_letter_200000() {
        Assertions.assertThat(200000.compute()).isEqualTo("deux cents milles")
    }

    @Test
    fun should_return_letter_200001() {
        Assertions.assertThat(200001.compute()).isEqualTo("deux cents mille un")
    }


    @Test
    fun should_return_letter_1000000() {
        Assertions.assertThat(1000000.compute()).isEqualTo("un million")
    }

    @Test
    fun should_return_letter_1000001() {
        Assertions.assertThat(1000001.compute()).isEqualTo("un million un")
    }

    @Test
    fun should_return_letter_2000000() {
        Assertions.assertThat(2000000.compute()).isEqualTo("deux millions")
    }

    @Test
    fun should_return_letter_2000001() {
        Assertions.assertThat(2000001.compute()).isEqualTo("deux million un")
    }





    @Test
    fun should_return_letter_1000000000() {
        Assertions.assertThat(1000000000.compute()).isEqualTo("un millard")
    }

    @Test
    fun should_return_letter_1000000001() {
        Assertions.assertThat(1000000001.compute()).isEqualTo("un millard un")
    }

    @Test
    fun should_return_letter_2000000000() {
        Assertions.assertThat(2000000000.compute()).isEqualTo("deux millards")
    }

    @Test
    fun should_return_letter_2000000001() {
        Assertions.assertThat(2000000001.compute()).isEqualTo("deux millard un")
    }


}