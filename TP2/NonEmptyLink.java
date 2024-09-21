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
        queue.add(this.tree);
    }
}
