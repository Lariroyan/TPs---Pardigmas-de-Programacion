package nogracias;

public abstract class EstadoJuego {
    protected NoGracias juego;

    public EstadoJuego(NoGracias juego) {
        this.juego = juego;
    }

    public abstract boolean esFinalizado();

    public abstract void pagarCarta(Jugador unJugador);
    public abstract void tomarCarta(Jugador unJugador, Carta unaCarta);

}
