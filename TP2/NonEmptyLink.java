package tree;
import java.util.*;
public class NonEmptyLink extends Link {
    private final Tree tree;

    NonEmptyLink(Tree tree) {
        this.tree = tree;
    }

    @Override
    Tree getTree(String side) {
        return this.tree;
    }

    @Override
    List<Object> dfs() {
        return tree.dfs();
    }


    public void addToQueue(Queue<Tree> queue) {
        // Añadir el árbol a la cola si no es nulo
        queue.add(this.tree);
    }
}