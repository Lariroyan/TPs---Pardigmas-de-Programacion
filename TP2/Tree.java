package tree;

import java.util.*;

public class Tree {
    //private List<Object> listElements = new ArrayList<>();

    private Object carga;
    private Tree left;
    private Tree right;

    public Tree( Object a ) {
        this.carga = a;
        this.left = null;
        this.right = null;
    }
    public List dfs() {
        List result = new ArrayList();
        dfsAuxiliar (this, result);
        return result;
    }

    private void dfsAuxiliar(Tree node, List result) {
        if (node == null) {
            return;
        }
        result.add(node.carga);
        dfsAuxiliar(node.left, result);
        dfsAuxiliar(node.right, result);
    }


    public List bfs() {
        List result = new ArrayList();
        Queue<Tree> queue = new LinkedList();
        queue.add(this);

        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            if (node != null) {
                result.add(node.carga); // Añadir el nodo actual
                if (node.left != null) {
                    queue.add(node.left); // Añadir el hijo izquierdo a la cola
                }
                if (node.right != null) {
                    queue.add(node.right); // Añadir el hijo derecho a la cola
                }
            }
        }

        return result;
    }
    public Tree atLeft( Tree b ) {
        this.left = b;
        return this;
    }

    public Tree atRight( Tree b ) {
        this.right = b;
        return this;
    }

    public Tree left() {
        if (left == null) {
            throw new RuntimeException("Nada a la siniestra!");
        }
        return left;
    }

    public Tree right() {
        if (right == null) {
            throw new RuntimeException("Nada a la diestra!");
        }
        return right;
    }

    public Object carga() {
        return this.carga;
    }




}
