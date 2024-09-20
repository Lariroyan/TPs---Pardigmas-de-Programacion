package tree;
import java.util.*;
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
    public List<Object> dfs(List<Object> result) {
        result.add(this.carga); // Agrega la carga actual al resultado
        left.dfs(result); // Explora la rama izquierda
        right.dfs(result); // Explora la rama derecha
        return result;
    }

    @Override
    public List<Object> bfs(Queue<Rama> queue, List<Object> result) {
        result.add(this.carga);
        queue.add(this.left);
        queue.add(this.right);
        return result;
    }
}
