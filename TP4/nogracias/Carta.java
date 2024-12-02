package nogracias;
public class Carta {
    public int valor;
    public int fichas;

    public Carta(int valor){
        if (valor < 3 || valor > 35){
            throw new RuntimeException("Los valores de la carta debe ser entre 3 y 35");
        }
        this.valor = valor;
        this.fichas = 0;
    }

    public int getValor() {
        return this.valor;
    }

    public int getFichas() {
        return this.fichas;
    }

    public void agregarFicha() {
        this.fichas++;
    }


}
