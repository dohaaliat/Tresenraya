public enum EstadoCasilla {
    FICHA_X {
        public String toString() {
            return "\u274C";
        }

    },
    FICHA_O {
        public String toString() {
            return "\u2B55";
        }

    },
    VACIO {
        public String toString() {
            return "\u2B1C";
        }

    },
    GANADOR {
        public String toString() { return "\uD83C\uDFC6";
        }

    },
    ERROR {
        public String toString() { return " \uD83D\uDE21";
        }

    },
    PENSATIVO {
        public String toString() { return " \uD83E\uDD14";
        }

    },



}
