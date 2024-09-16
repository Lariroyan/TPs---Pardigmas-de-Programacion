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
    public List<Object> dfs() {
        List<Object> result = new ArrayList<>();
        dfsAuxiliar(this, result);
        return result;
    }

    private void dfsAuxiliar(TreeState node, List<Object> result) {
        if (node == null) return;
        result.add(node.carga());
        if (node.left() instanceof NonEmptyTree) {
            dfsAuxiliar(node.left(), result);
        }
        if (node.right() instanceof NonEmptyTree) {
            dfsAuxiliar(node.right(), result);
        }
    }

    @Override
    public List<Object> bfs() {
        List<Object> result = new ArrayList<>();
        Queue<TreeState> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            TreeState node = queue.poll();
            result.add(node.carga());
            if (node.left() instanceof NonEmptyTree) {
                queue.add(node.left());
            }
            if (node.right() instanceof NonEmptyTree) {
                queue.add(node.right());
            }
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
