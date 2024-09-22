package tree;
import java.util.*;
public class validLink extends Link {
    private final Tree tree;

    validLink(Tree tree) {
        this.tree = tree;
    }

    @Override
    public Tree getSubTree(String side) {
        return this.tree;
    }

    @Override
    public List<Object> dfs() {
        return tree.dfs();
    }


    public void addToQueue(Queue<Tree> queue) {
        queue.add(this.tree);
    }
}
