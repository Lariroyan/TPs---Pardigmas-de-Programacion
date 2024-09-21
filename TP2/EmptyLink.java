package tree;
import java.util.*;
public class EmptyLink extends Link {
    @Override
    Tree getTree(String side) {
        throw new RuntimeException("Nada a la " + side + "!");
    }

    @Override
    List<Object> dfs() {
        return new ArrayList<>();
    }



    public void addToQueue(Queue<Tree> queue) {
        // No se añade nada a la cola en caso de rama vacía
    }
}
