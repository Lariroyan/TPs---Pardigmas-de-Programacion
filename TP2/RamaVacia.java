package tree;

import java.util.*;
public class RamaVacia extends Rama {

    @Override
    public Object carga() {
        throw new RuntimeException("Nodo nulo no tiene carga!");
    }

    @Override
    public Rama left() {
        throw new RuntimeException("Nada a la siniestra!");
    }

    @Override
    public Rama right() {
        throw new RuntimeException("Nada a la diestra!");
    }
    public boolean esNula() {
        return true;
    }

}
