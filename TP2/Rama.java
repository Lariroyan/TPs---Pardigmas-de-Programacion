package tree;

import java.util.*;

public abstract class Rama {
    public abstract Rama atLeft(Rama rama);
    public abstract Rama atRight(Rama rama);
    public abstract Object carga();
    public abstract List<Object> dfs(List<Object> result);
    public abstract List<Object> bfs(Queue<Rama> queue, List<Object> result);
}

