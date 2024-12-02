package nogracias;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NoGraciasTest {

    private List<Carta> mazo;
    private NoGracias game;
    @BeforeEach
    void setUp() {
        mazo = new ArrayList<>(List.of(new Carta(5), new Carta(4), new Carta(6), new Carta(7)));
        game = new NoGracias(crearJugadores("Mila", "Emma", "Lara"), mazo);
    }

    @Test void test00IniciarJuego() {
        game.getJugadores().forEach(jugador -> assertEquals(11, jugador.getFichas()));
    }

    @Test void test01DistribucionDeFichas(){
        assertDistribucionFichas(crearJugadores("Mila", "Emma", "Lara", "Giselle"), 11);
        assertDistribucionFichas(crearJugadores("Mila", "Emma", "Lara", "Giselle", "Peter"), 11);
        assertDistribucionFichas(crearJugadores("Mila", "Emma", "Lara", "Giselle", "Peter", "Julio"), 9);
        assertDistribucionFichas(crearJugadores("Mila", "Emma", "Lara", "Giselle", "Peter", "Julio", "Emilio"), 7);
    }

    @Test void test02NoAlcanzaLaMinimaCantidadDeJugadores () {
        assertThrowsLike("El número de jugadores debe estar entre 3 y 7",
                () -> new NoGracias(crearJugadores("Mila", "Emma"), mazo));
    }
    @Test void test03SuperaElMaximoDeJugadores(){
        assertThrowsLike("El número de jugadores debe estar entre 3 y 7",
                () ->  new NoGracias(crearJugadores("Mila", "Emma", "Lara", "Giselle", "Peter", "Julio", "Emilio", "Rocio"), mazo));
    }
    @Test void test04PagarCartaColocarFicha() {
        Jugador jugador1 = game.getJugadores().get(0);
        game.pagarCarta(jugador1);
        assertEquals(10, jugador1.getFichas());
    }

    @Test void test05TomarCartaConFichasAcumuladas() {
        Jugador jugador1 = game.getJugadores().get(0);
        Carta cartaActual = mazo.get(0);

        game.getJugadores().forEach(jugador -> game.pagarCarta(jugador));

        game.tomarCarta(jugador1);
        assertEquals(5, cartaActual.getValor());
        assertEquals(13, jugador1.getFichas());
    }
    @Test void test06JugadorFueraDeTurno(){
        Jugador jugador2 = game.getJugadores().get(1);
        assertThrowsLike("No es el turno de Emma", () ->  game.pagarCarta(jugador2));
        assertThrowsLike("No es el turno de Emma", () ->  game.tomarCarta(jugador2));
    }


    @Test void test07ObligarATomarCartaSiElJugadorNoTieneFichas(){
        Jugador jugador1 = game.getJugadores().get(0);
        jugador1.setFichas(0);
        game.pagarCarta(jugador1);
        assertEquals(1, jugador1.getCartas().size());
        assertEquals(5, jugador1.getCartas().get(0).getValor());
    }

    @Test void test08FlujoDelJuegoConEstados() {
        assertFalse(game.getEstado().esFinalizado());

        game.tomarCarta(game.getJugadores().get(0));
        game.tomarCarta(game.getJugadores().get(1));
        game.tomarCarta(game.getJugadores().get(2));
        game.tomarCarta(game.getJugadores().get(0));

        assertTrue(game.getEstado().esFinalizado());
    }

    @Test void test09PuntuacionDespuesDeTomarCartasEscalonadasConFichas() {
        game.tomarCarta(game.getJugadores().get(0)); // mila toma carta 5
        game.pagarCarta(game.getJugadores().get(1)); // pagan carta 4
        game.pagarCarta(game.getJugadores().get(2)); // pagan carta 4
        game.tomarCarta(game.getJugadores().get(0)); // mila toma carta 4 con 2 fichas

        assertEquals(-9, game.getJugadores().get(0).puntuacion());
    }

    @Test void test10JuegoFinalizado() {
        mazo.clear();
        assertThrows(RuntimeException.class, () -> game.pagarCarta(game.getJugadores().get(0)));
        assertThrows(RuntimeException.class, () -> game.tomarCarta(game.getJugadores().get(0)));
    }
    @Test void test11JugadorPagaConJuegoFinalizado(){
        mazo.clear();
        game.pasarTurno();
        assertThrowsLike("Juego finalizado",() ->  game.pagarCarta(game.getJugadores().get(1)) );
    }

    private void assertDistribucionFichas(List<Jugador> jugadores, int fichasEsperadas) {
        new NoGracias(jugadores, mazo);
        jugadores.forEach(jugador -> assertEquals(fichasEsperadas, jugador.getFichas()));
    }
    private List<Jugador> crearJugadores(String... nombres) {
        return Arrays.stream(nombres)
                .map(Jugador::new)
                .collect(Collectors.toList());
    }
    private static void assertThrowsLike(String expectedMessage, Executable executable) {
        assertEquals(expectedMessage,
                assertThrows(Exception.class, executable)
                        .getMessage());
    }
}


