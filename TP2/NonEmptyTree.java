package tree;
import java.util.*;
public class NonEmptyTree extends TreeState {
    private Object carga;
    private TreeState left;
    private TreeState right;

    public NonEmptyTree(Object carga, TreeState left, TreeState right) {
        this.carga = carga;
        this.left = left;
        this.right = right;
    }
    @Override
    public void traverse(List result) {
        result.add(carga);
        // ac hace recorrido in orden
        left.traverse(result);
        right.traverse(result);
    }
    @Override
    public void traverseBFS(Queue<TreeState> queue, List result) {
        //result.add(this.carga);
        //list carga -> lista de resultados
        result.add(carga);
        queue.add(left);
        queue.add(right);
    }
    @Override
    public List dfs() {
        List result = new ArrayList<>();
        dfsAuxiliar(this, result);
        return result;
    }
    private void dfsAuxiliar(NonEmptyTree node, List result) {
        result.add(node.carga);
        node.left.traverse(result);
        node.right.traverse(result);
    }

    @Override
    public List bfs() {
        List result = new ArrayList();
        Queue<TreeState> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeState node = queue.poll();
            node.traverseBFS(queue, result);
        }
        return result;
    }

    @Override
    public TreeState left() {
        return left;
    }

    @Override
    public TreeState right() {
        return right;
    }

    @Override
    public Object carga() {
        return carga;
    }
}
