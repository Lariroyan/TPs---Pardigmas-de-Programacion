package tree;
import java.util.*;
public class EmptyTree extends TreeState {
    public List<Object> dfs() {
        return new ArrayList<>();
    }

    @Override
    public List<Object> bfs() {
        return new ArrayList<>();
    }


    @Override
    public TreeState left() {
        throw new RuntimeException("Nada a la siniestra!");
    }

    @Override
    public TreeState right() {
        throw new RuntimeException("Nada a la diestra!");
    }

    @Override
    public Object carga() {
        throw new RuntimeException("No hay carga");
    }
}
