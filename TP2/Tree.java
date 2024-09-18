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
        TreeState leftState = state.left();
        if (leftState instanceof EmptyTree) {
            throw new RuntimeException("Nada a la siniestra!");
        }
        return new Tree(leftState.carga());
    }

    public Tree right() {
        TreeState rightState = state.right();
        if (rightState instanceof EmptyTree) {
            throw new RuntimeException("Nada a la diestra!");
        }
        return new Tree(rightState.carga());
    }

    public Object carga() {
        return state.carga();
    }


}







}
