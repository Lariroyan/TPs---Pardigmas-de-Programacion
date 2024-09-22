package tree;
import java.util.*;

public abstract class Link {
    public abstract Tree getSubTree(String side); 
    public abstract List<Object> dfs();
    public abstract void addToQueue(Queue<Tree> queue);
}

