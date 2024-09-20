package tree;

import java.util.List;
import java.util.Queue;

public class RamaVacia extends Rama {

    public RamaVacia() {
    }


    @Override
    public Rama atLeft(Rama rama) {
        throw new RuntimeException("Nada a la siniestra!");
    }
    @Override
    public Rama atRight(Rama rama) {
        throw new RuntimeException("Nada a la diestra!");
    }
    @Override
    public Rama right() {
        throw new RuntimeException("Nada a la diestra!");
    }
    @Override
    public Rama left() {
        throw new RuntimeException("Nada a la siniestra!");
    }
    @Override
    public Object carga() {
        throw new RuntimeException("Rama vacía no tiene carga!");
    }

    @Override
    public List dfs(List result) {
        return result;
    }
    @Override
    public List bfs(Queue<Rama> queue, List result) {
        return result;
    }

}
