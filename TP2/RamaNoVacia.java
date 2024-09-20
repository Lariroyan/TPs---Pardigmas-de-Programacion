package tree;
import java.util.*;
public class RamaNoVacia extends Rama {
    private Object carga;
    private Rama left;
    private Rama right;

    public RamaNoVacia(Object carga) {
        this.carga = carga;
        this.left = new RamaVacia();
        this.right = new RamaVacia() {
        };
    }

    @Override
    public Object carga() {
        return this.carga;
    }

    @Override
    public Rama left() {
        return this.left;
    }

    @Override
    public Rama right() {
        return this.right;
    }
    public boolean esNula() {
        return false;
    }

    public RamaNoVacia atLeft(Rama left) {
        this.left = left;
        return this;
    }

    public RamaNoVacia atRight(Rama right) {
        this.right = right;
        return this;
    }
}
