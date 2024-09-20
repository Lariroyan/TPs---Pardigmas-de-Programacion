package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    private Rama root;

    public Tree(Object carga) {
        this.root = new Nodo(carga);
    }

    public List dfs() {
        List result = new ArrayList();
        this.root.dfs(result);
        return result;
    }

    public List bfs() {
        List result = new ArrayList();
        Queue<Rama> queue = new LinkedList();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Rama node = queue.poll();
            node.bfs(queue, result);
        }
        return result;
    }

public Tree atLeft(Tree b) {
        this.root = this.root.atLeft(b.root);
        return this;
    }

    public Tree atRight(Tree b) {
        this.root = this.root.atRight(b.root);
        return this;
    }

    public Object carga() {
        return this.root.carga();
    }

    public Tree left() {
//        Rama ramaIzquierda = this.root.left();
//        if (ramaIzquierda instanceof RamaVacia) {
//            throw new RuntimeException("Nada a la siniestra!");
//        }
//        return new Tree(ramaIzquierda.carga());
        return new Tree(this.root.left());
    }

    public Tree right() {
//        Rama ramaDerecha = this.root.right();
//        if (ramaDerecha instanceof RamaVacia) {
//            throw new RuntimeException("Nada a la diestra!");
//        }
//        return new Tree(ramaDerecha.carga());
        return new Tree(this.root.right());
    }

}

