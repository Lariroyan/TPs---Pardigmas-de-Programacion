package tree;
import java.util.*;

public class EmptyLink extends Link {
    @Override
    public Tree getSubTree(String side) {
        throw new RuntimeException("Nada a la " + side + "!");
    }
    @Override
    public List<Object> dfs() {
        return new ArrayList<>();
    }
    public void addToQueue(Queue<Tree> queue) {
        
    }
}
