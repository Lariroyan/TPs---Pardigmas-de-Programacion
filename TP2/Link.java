package tree;
import java.util.*;
public abstract class Link {
    abstract Tree getTree(String side); // Método para obtener el árbol o lanzar la excepción.

    abstract List<Object> dfs();

    abstract void addToQueue(Queue<Tree> queue);
}

