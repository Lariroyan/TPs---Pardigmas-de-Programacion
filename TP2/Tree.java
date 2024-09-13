package tree;

import java.util.List;

public class Tree {
    private Object value;
    private Tree left;
    private Tree right;

    public Tree( Object a ) {
        this.value = a;
        this.left = null;
        this.right = null;
    }

    public List dfs() {
        return null;
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
        return this.right;
    }

    public Tree left() {
        return this.left;
    }

    public Object carga() {
        return this.value;
    }
}

