package tree;

import java.util.List;

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
        if (node.left != null) {
            dfsAuxiliar(node.left, result);
        }
        if (node.right != null) {
            dfsAuxiliar(node.right, result);
        }
    }
    
    public List bfs() {
        return null;
    }

    public Tree atLeft( Tree b ) {
        this.left = b;
        return this;
    }

    public Tree atRight( Tree b ) {
        this.right = b;
        return this;
    }

    public Tree right() {
        if (this.right == null) {
            throw new RuntimeException("Nada en el nodo derecho");
        }
        return this.right;
    }

    public Tree left() {
        if (this.left == null) {
            throw new RuntimeException("Nada en el nodo izquierdo");
        }
        return this.left;
    }

    public Object carga() {
        return this.carga;
    }

    // metodos agregados que capaz sirva wu
    public void addLeft(Tree node) {
        this.left = node;
    }
    public void addRight(Tree node) {
        this.right = node;
    }
    //un public -> tiene hijos? es hoja? 

}

