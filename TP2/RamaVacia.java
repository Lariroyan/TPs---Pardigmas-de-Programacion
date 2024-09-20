package tree;

import java.util.*;
public class RamaVacia extends Rama{
    @Override
    public Rama atLeft(Rama rama) {
        throw new RuntimeException("Nada a la siniestra!");
    }

    @Override
    public Rama atRight(Rama rama) {
        throw new RuntimeException("Nada a la diestra!");
    }


    @Override
    public Object carga() {
        throw new RuntimeException("Rama vacía no tiene carga!");
    }

    @Override
    public List<Object> dfs(List<Object> result) {
        return result; // Nada que agregar para una rama vacía
    }

    @Override
    public List<Object> bfs(Queue<Rama> queue, List<Object> result) {
        return result;
    }

}
