package tree;

import java.util.*;

public class Tree {
    private Object carga;
    private Link left;
    private Link right;

    public Tree(Object a) {
        this.carga = a;
        this.left = new EmptyLink();
        this.right = new EmptyLink();
    }

    public List<Object> dfs() {
        List<Object> result = new ArrayList<>();
        result.add(this.carga); // Visitar la raíz.
        result.addAll(left.dfs()); // Recorrer la rama izquierda.
        result.addAll(right.dfs()); // Recorrer la rama derecha.
        return result;
    }

    public List<Object> bfs() {
        List<Object> result = new ArrayList<>();
        Queue<Tree> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            result.add(node.carga); // Añadir el nodo actual a la lista de resultados

            // En lugar de usar la recursión, simplemente añadimos los hijos a la cola
            node.left.addToQueue(queue);
            node.right.addToQueue(queue);
        }

        return result;
    }
    public Tree atLeft(Tree b) {
        this.left = new NonEmptyLink(b);
        return this;
    }

    public Tree atRight(Tree b) {
        this.right = new NonEmptyLink(b);
        return this;
    }

    public Tree left() {
        return left.getTree("siniestra"); // Lanza excepción si es una EmptyLink
    }

    public Tree right() {
        return right.getTree("diestra"); // Lanza excepción si es una EmptyLink
    }

    public Object carga() {
        return this.carga;
    }
}