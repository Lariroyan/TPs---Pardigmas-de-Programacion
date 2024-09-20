package tree;

import java.util.List;
import java.util.Queue;

public class Nodo extends Rama {
    private Object carga;
    private Rama left;
    private Rama right;

    public Nodo(Object carga) {
        this.carga = carga;
        this.left = new RamaVacia();
        this.right = new RamaVacia();
    }
    @Override
    public Rama atLeft(Rama rama) {
        this.left = rama;
        return this;
    }
    @Override
    public Rama atRight(Rama rama) {
        this.right = rama;
        return this;
    }
    @Override
    public Object carga() {
        return this.carga;
    }
    @Override
    public List dfs(List result) {
        result.add(this.carga);
        this.left.dfs(result);
        this.right.dfs(result);
        return result;
    }
    @Override
    public List bfs(Queue<Rama> queue, List result) {
        result.add(this.carga);
        queue.add(this.left);
        queue.add(this.right);
        return result;
    }

    @Override
    public Rama left() {
        return this.left;
    }

    @Override
    public Rama right() {
        return this.right;
    }


}

