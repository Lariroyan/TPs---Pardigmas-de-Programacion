package tree;

import java.util.*;

public class Tree {
    private TreeState state;

    public Tree(Object carga) {
        this.state = new NonEmptyTree(carga, new EmptyTree(), new EmptyTree());
    }

    public Tree atLeft(Tree tree) {
        this.state = new NonEmptyTree(this.state.carga(), tree.state, this.state.right());
        return this;
    }

    public Tree atRight(Tree tree) {
        this.state = new NonEmptyTree(this.state.carga(), this.state.left(), tree.state);
        return this;
    }

    public List<Object> dfs() {
        return state.dfs();
    }

    public List<Object> bfs() {
        return state.bfs();
    }

    public Tree left() {
        return new Tree(state.left().carga());
    }

    public Tree right() {
        return new Tree(state.right().carga());
    }

    public Object carga() {
        return state.carga();
    }


}



}
