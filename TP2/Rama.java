package tree;

import java.util.List;
import java.util.Queue;

public abstract class Rama {
    public Rama() {
    }
    public abstract Rama atLeft(Rama var1);
    public abstract Rama atRight(Rama var1);
    public abstract Object carga();
    public abstract List dfs(List var1);
    public abstract List bfs(Queue<Rama> var1, List var2);
    public abstract Rama left ();
    public abstract Rama right ();

}
