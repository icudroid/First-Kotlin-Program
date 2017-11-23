package com.adbeback.nombre


class NombreApplication


enum class UNITE(val letter: String) {
    ZERO("zero"),
    UN("un"),
    DEUX("deux"),
    TROIS("trois"),
    QUATRE("quatre"),
    CINQ("cinq"),
    SIX("six"),
    SETP("sept"),
    HUIT("huit"),
    NEUF("neuf")
}

enum class DIXAINE(val letter: String) {
    DIX("dix") {
        override fun compute(value: Int): String = when (value) {
            10 -> "dix"
            11 -> "onze"
            12 -> "douze"
            13 -> "treize"
            14 -> "quatorze"
            15 -> "quinze"
            16 -> "seize"
            17 -> "dix-sept"
            18 -> "dix-huit"
            19 -> "dix-neuf"
            else -> ""
        }
    },
    VINGT("vingt") {
        override fun compute(value: Int): String {
            return regular(value)
        }
    },
    TRENTE("trente") {
        override fun compute(value: Int): String {
            return regular(value)
        }
    },
    QUARANTE("quarante") {
        override fun compute(value: Int): String {
            return regular(value)
        }
    },
    CINQUANTE("cinquante") {
        override fun compute(value: Int): String {
            return regular(value)
        }
    },
    SOIXANTE("soixante") {
        override fun compute(value: Int): String {
            return regular(value)
        }
    },
    SOIXANTE_DIX("soixante-dix") {
        override fun compute(value: Int): String {
            if (value == 70)
                return letter
            else if (value == 71)
                return "soixante" + " et " + (value - 60).compute()
            else
                return "soixante-" + (value - 60).compute()
        }
    },
    QUATRE_VINGT("quatre-vingt") {
        override fun compute(value: Int): String {
            if (value == 80)
                return "quatre-vingts"
            else
                return letter + "-" + (value - 80).compute()
        }
    },
    QUATRE_VINGT_DIX("quatre-vingt-dix") {
        override fun compute(value: Int): String {
            if (value == 90)
                return letter
            else
                return "quatre-vingt-" + (value - 80).compute()
        }
    };

    internal abstract fun compute(value: Int): String


    internal fun regular(value: Int): String {
        return if (value % 10 == 0)
            values()[(value / 10) - 1].letter
        else if (value % 10 == 1)
            letter + " et " + (value % 10).compute()
        else
            letter + "-" + (value % 10).compute()
    }


    companion object {

        fun toLetter(value: Int): String = when (value) {
            in 10..19 -> DIX.compute(value)
            in 20..99 -> values()[(value / 10) - 1].compute(value)
            else -> ""
        }
    }
}


enum class CENTAINE(val value: Int, val letter: String) {
    CENT(100, "cent"),
    DEUX_CENT(200, "deux cent"),
    TROIS_CENT(300, "trois cent"),
    QUATRE_CENT(400, "quatre cent"),
    CINQ_CENT(500, "cinq cent"),
    SIX_CENT(600, "six cent"),
    SEPT_CENT(700, "sept cent"),
    HUIT_CENT(800, "huit cent"),
    NEUF_CENT(900, "neuf cent");

    internal fun compute(value: Int): String {
        if (100 == value)
            return letter
        if (this.value == value)
            return letter + "s"
        else
            return letter + " " + (value - this.value).compute()
    }

    companion object {

        fun toLetter(value: Int): String {
            return values()[(value / 100) - 1].compute(value)
        }
    }
}


enum class MILLIER(val letter: String) {
    MILLE("mille");

    companion object {

        fun toLetter(value: Int): String {
            if (1000 == value) {
                return MILLE.letter
            } else if (value in 1001..1999) {
                return MILLE.letter + " " + (value / 1000).compute()
            } else if (value % 1000 == 0) {
                return (value / 1000).compute() + " " + MILLE.letter + "s"
            } else {
                return (value / 1000).compute() + " " + MILLE.letter + " " + (value - ((value / 1000) * 1000)).compute()
            }

        }
    }
}


enum class MILLION_MILLARD(val letter: String, val min: Long, val maxExclude: Long) {
    MILLION("million", 1000000, 1000000000),
    MILLIARD("millard", 1000000000, 1000000000000);


    fun compute(value: Long): String {
        if (min == value) {
            return UNITE.UN.letter + " " + letter
        } else if (value % min == 0L) {
            return (value / min).compute() + " " + letter + "s"
        } else {
            return (value / min).compute() + " " + letter + " " + (value - ((value / min).toInt() * min)).compute()
        }

    }

    companion object {

        fun toLetter(value: Long): String = when {
            value in MILLION.min until MILLION.maxExclude -> MILLION.compute(value)
            value in MILLIARD.min until MILLIARD.maxExclude -> MILLIARD.compute(value)
            else -> ""
        }
    }
}


fun Int.compute(): String = when {
    this in 0..9 -> UNITE.values()[this].letter
    this in 10..99 -> DIXAINE.toLetter(this)
    this in 100..999 -> CENTAINE.toLetter(this)
    this in 1000..999999 -> MILLIER.toLetter(this)
    this in 1000000..999999999999 -> MILLION_MILLARD.toLetter(this.toLong())
    else -> ""
}


fun Long.compute(): String = when {
    this in 0..9 -> UNITE.values()[this.toInt()].letter
    this in 10..99 -> DIXAINE.toLetter(this.toInt())
    this in 100..999 -> CENTAINE.toLetter(this.toInt())
    this in 1000..999999 -> MILLIER.toLetter(this.toInt())
    this in 1000000..999999999999 -> MILLION_MILLARD.toLetter(this)
    else -> ""
}


fun main(args: Array<String>) {
    //SpringApplication.run(NombreApplication::class.java, *args)
    println(102561843501.compute())
}

