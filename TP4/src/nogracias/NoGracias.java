package nogracias;

import java.util.ArrayList;
import java.util.List;

public class NoGracias {
    private List<Jugador> jugadores = new ArrayList<>();
    private List<Carta> mazo;
    public int indiceTurno;
    private EstadoJuego estado;

    public NoGracias (List<Jugador> jugadores, List<Carta> mazoInicial ) {
        if (jugadores.size() < 3 || jugadores.size() > 7) {
            throw new IllegalArgumentException("El número de jugadores debe estar entre 3 y 7");
        }
        this.jugadores = new ArrayList<>(jugadores);
        this.mazo = mazoInicial;
        this.indiceTurno = 0;
        this.estado = new JuegoEnProgreso(this);
        int fichasPorJugador = calcularFichasPorJugador(jugadores.size());
        jugadores.stream().forEach(jugador -> jugador.setFichas(fichasPorJugador));


    }

    public void pagarCarta(Jugador jugador) {
        esTurno(jugador);
        if (jugador.getFichas() == 0) {
            this.tomarCarta(jugador);
        } else {
            estado.pagarCarta(jugador);
            mazo.getFirst().agregarFicha();
        }
        pasarTurno();
    }

    public void tomarCarta(Jugador jugador) {
        esTurno(jugador);
        Carta carta = mazo.remove(0);
        estado.tomarCarta(jugador, carta);
        pasarTurno();
    }

    public void esTurno (Jugador unJugador){
        if (jugadores.get(indiceTurno) != unJugador  ){
            throw new RuntimeException("No es el turno de " + unJugador.getNombre());
        }

    }
    public void pasarTurno() {
        indiceTurno = (indiceTurno + 1) % jugadores.size();
        if (mazo.isEmpty()) {
            estado = new JuegoFinalizado(this);
        }
    }

    public EstadoJuego getEstado () {
        return estado;
    }
    private int calcularFichasPorJugador(int numJugadores) {
        List<Integer> fichasPorJugador = List.of(11, 11, 11, 9, 7);
        return fichasPorJugador.get(numJugadores - 3);
    }

    public List<Jugador> getJugadores () {
        return jugadores;
    }


}


