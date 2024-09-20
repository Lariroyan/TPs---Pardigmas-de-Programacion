package tree;

import java.util.*;
// Clase principal del Árbol
public class Tree {
    private Rama root;

    public Tree(Object carga) {
        this.root = new Nodo(carga);
    }

    public List<Object> dfs() {
        List<Object> result = new ArrayList<>();
        root.dfs(result); // Ejecuta el DFS a partir de la raíz
        return result;
    }

    public List<Object> bfs() {
        List<Object> result = new ArrayList<>();
        Queue<Rama> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Rama node = queue.poll();
            if (node != null) {
                node.bfs(queue, result);
            }
        }
        return result;
    }

    public Tree atLeft(Tree b) {
        this.root = root.atLeft(b.root);
        return this;
    }

    public Tree atRight(Tree b) {
        this.root = root.atRight(b.root);
        return this;
    }

    public Object carga() {
        return root.carga();
    }

    public Tree left() {
        this.root.atLeft(new RamaVacia());
        return this;
    }

    public Tree right() {
        this.root.atRight(new RamaVacia());
        return this;
    }
}
