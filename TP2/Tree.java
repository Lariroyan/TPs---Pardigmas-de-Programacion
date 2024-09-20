package tree;

import java.util.*;
public class Tree {
    private Rama root;

    public Tree(Object carga) {
        this.root = new RamaNoVacia(carga);
    }

    public List<Object> dfs() {
        List<Object> result = new ArrayList<>();
        dfsAuxiliar(this.root, result);
        return result;
    }

    private void dfsAuxiliar(Rama node , List<Object> result) {
        if (node.esNula()) return;  // No hacemos nada si es una arista nula

        result.add(node.carga());
        dfsAuxiliar(node.left(), result);
        dfsAuxiliar(node.right(), result);
    }
    public List<Object> bfs() {
        List<Object> result = new ArrayList<>();
        Queue<Rama> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Rama node= queue.poll();
            if (!node.esNula()) {
                result.add(node.carga());
                queue.add(node.left());
                queue.add(node.right());
            }
        }

        return result;
    }

    public Tree atLeft(Tree b) {
        ((RamaNoVacia) this.root).atLeft(b.root);
        return this;
    }

    public Tree atRight(Tree b) {
        ((RamaNoVacia) this.root).atRight(b.root);
        return this;
    }

    public Rama left() {
        return root.left();
    }

    public Rama right() {
        return root.right();
    }
    public Object carga() {
        return root.carga();
    }

}

