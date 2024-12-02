package nogracias;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jugador {
    private String nombre;
    private List<Carta> cartas = new ArrayList<>();
    private int fichas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartas = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public int getFichas(){
        return this.fichas;
    }
    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public void pagarCarta() {
        if (fichas > 0){
            fichas --;
        }
        else{
            throw new IllegalStateException("El jugador no tiene fichas suficientes para pagar");
        }
    }

    public void tomarCarta(Carta carta) {
        cartas.add(carta);
        this.fichas += carta.getFichas();
    }


    public int puntuacion() {

        List<Integer> cartaOrdenada = cartas.stream(). map(Carta::getValor)
                .sorted()
                .collect(Collectors.toList());

        int totalPuntos = cartaOrdenada.stream()
                .reduce(0, (acumulado, cartaActual) -> {
                    if (acumulado == 0 || cartaActual != acumulado + 1) {
                        return acumulado + cartaActual;
                    } else {
                        return acumulado;
                    }
                });

        return totalPuntos - fichas;

    }
    public List<Carta> getCartas() {
        return cartas;
    }


}

