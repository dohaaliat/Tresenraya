public class Tablero {
    final static int DIMENSION = 3;
    private EstadoCasilla[][] tablero;
    final static int VALOR_INICIAL = 0;

    public Tablero() {
        tablero = new EstadoCasilla[DIMENSION][DIMENSION];
    }

    public void mostrar() {
        System.out.println("Vamos a jugar al Tres en Raya");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.printf("|%s", tablero[i][j]);
            }
            System.out.print("|\n");
        }
    }

    public void vaciar() {
        for (int i = VALOR_INICIAL; i < tablero.length; i++) {
            for (int j = VALOR_INICIAL; j < tablero.length; j++) {
                tablero[i][j] = EstadoCasilla.VACIO;
            }
        }
    }

    public boolean estaLleno() {
        for (int i = VALOR_INICIAL; i < tablero.length ; i++) {
            for (int j = VALOR_INICIAL; j <tablero[i].length ; j++) {
                if (tablero[i][j] == EstadoCasilla.VACIO){
                    return false;
                }
            }

        }

        return true;
    }

    public void ponerFicha(Coordenada casilla, EstadoCasilla color) {
        tablero[casilla.getFila() - 1][casilla.getColumna() -1] = color;
        estaLleno();
    }

    private boolean hayTresEnRayaColumna(EstadoCasilla color) {

        for (int i = VALOR_INICIAL; i < tablero.length; i++) {
            int contador = VALOR_INICIAL;
            for (int j = VALOR_INICIAL; j < tablero.length; j++) {
                if (tablero[j][i].equals(color)) {
                    contador++;
                }
                if (contador == DIMENSION) {
                    return true;
                }
            }
        }


        return false;
    }

    private boolean hayTresEnRayaFila(EstadoCasilla color) {
        for (int i = VALOR_INICIAL; i < tablero.length; i++) {
            int contador = VALOR_INICIAL;
            for (int j = VALOR_INICIAL; j < tablero.length; j++) {
                if (color.equals(tablero[i][j])) {
                    contador++;
                }
                if (contador == DIMENSION) {
                    return true;
            }
            }
        }

        return false;
    }

    private boolean hayTresEnRayaDiagonal(EstadoCasilla color) {
        int contador = VALOR_INICIAL;
        for (int i = VALOR_INICIAL; i < tablero.length; i++) {
            if (tablero[i][i].equals(color)) {
                contador++;
            }
        }

        if (contador == DIMENSION) {
            return true;
        }
        return false;
    }

    private boolean hayTresEnRayaSubDiagonal(EstadoCasilla color) {
        int contador = VALOR_INICIAL;
        int index = tablero.length -1;
        for (int i = VALOR_INICIAL; i < tablero.length ; i++, index--) {
            if (tablero[index][i].equals(color)){
                contador++;
        }
        }
        if (contador == DIMENSION) {
            return true;
        }
        return false;
    }

    private boolean hayTresEnRaya(EstadoCasilla color) {

        return hayTresEnRayaFila(color) || hayTresEnRayaColumna(color) || hayTresEnRayaDiagonal(color) || hayTresEnRayaSubDiagonal(color);
    }

    public boolean hayTresEnRaya() {
        return hayTresEnRaya(EstadoCasilla.FICHA_X) || hayTresEnRaya(EstadoCasilla.FICHA_O);
    }

    public boolean isOcupada(Coordenada casilla) {
        return tablero[casilla.getFila() - 1][casilla.getColumna() -1] != EstadoCasilla.VACIO;
    }
}