public class Coordenada {
    private int fila;
    private int columna;

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public boolean isValida(int dimension) {

        return fila >= 0 && fila <= dimension && columna >= 0 && columna <= dimension;

    }

}

