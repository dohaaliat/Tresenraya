import java.util.Scanner;

public class TresEnRaya {
    public

    static Scanner teclat;

    public static void main(String[] args) {
        teclat = new Scanner(System.in);
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar();
    }

    public void jugar() {
        Jugador[] jugadores = {
                new Jugador(EstadoCasilla.FICHA_X),
                new Jugador(EstadoCasilla.FICHA_O)
        };

        Tablero tablero = new Tablero();

        boolean usuarioHuegaDeNuevo;
        do {
            int turno = 0;
            tablero.vaciar();
            do {
                tablero.mostrar();
                jugadores[turno].ponerFicha(tablero);

                if (tablero.hayTresEnRaya()) {
                    jugadores[turno].cantarVictoria();
                    break;
                }
                if (tablero.estaLleno()){
                    System.out.println("Empate");
                    break;
                }

                if (turno == 0) {
                    turno++;
                } else {
                    turno--;
                }

            } while (!tablero.estaLleno());
            usuarioHuegaDeNuevo = volverAJugar();

        } while (usuarioHuegaDeNuevo);

    }

    private boolean volverAJugar() {
        do {
            System.out.print("¿Quieres volver a jugar ? S/N  " + EstadoCasilla.PENSATIVO);
            String respuesta = teclat.next();
            if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
                System.out.println("¡Error! Debes introducir S o N" + EstadoCasilla.ERROR);

            } else {
                if (respuesta.equalsIgnoreCase("S")) {
                    return true;
                }
                if (respuesta.equalsIgnoreCase("N")) {
                    return false;
                }
            }

        } while (true);


    }
}