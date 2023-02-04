import java.util.Scanner;

public class Jugador {
    private EstadoCasilla color;

    public Jugador(EstadoCasilla color) {
        this.color = color;
    }

    private int devolverEntero(String pedir, String error) {
        do {
            System.out.println(pedir);
            if (TresEnRaya.teclat.hasNextInt()) {
                return TresEnRaya.teclat.nextInt();
            }
            System.out.println(error);
            TresEnRaya.teclat.next();

        } while (true);
    }

    private Coordenada recogerCoordenada() {
        do {
            int numFila = devolverEntero("Introduce fila [1-" + Tablero.DIMENSION + "]" + color + ":", "¡Error! Debe introducir un número entero");
            int numColumna = devolverEntero("Introduce Columna [1-" + Tablero.DIMENSION + "]:", "\"¡Error! Debe introducir un número entero");
            Coordenada coordenadas = new Coordenada(numFila, numColumna);
            if (coordenadas.isValida(Tablero.DIMENSION)) {
                return coordenadas;
            }
            System.out.println("¡Error! Introduce una coordenada válida" + EstadoCasilla.ERROR);
        } while (true);
    }

    public void ponerFicha(Tablero tablero) {
        do {
            Coordenada coordenada = recogerCoordenada();
            if (!tablero.isOcupada(coordenada)) {
                tablero.ponerFicha(coordenada, color);
                return;
            } else {
                System.out.println("¡Error! Coordenada ocupada en el tablero" + EstadoCasilla.ERROR);
            }
        } while (true);
    }

    public void cantarVictoria() {
        System.out.println("¡El jugador" + color + "es el ganador!" + EstadoCasilla.GANADOR);
    }
}
