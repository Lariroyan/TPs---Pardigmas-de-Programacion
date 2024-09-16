package tree;
import java.util.*;
public abstract class TreeState {
    public abstract List<Object> dfs();
    public abstract List<Object> bfs();
    public abstract TreeState left();
    public abstract TreeState right();
    public abstract Object carga();
}
