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
        result.add(this.carga); 
        result.addAll(left.dfs()); 
        result.addAll(right.dfs()); 
        return result;
    }

    public List<Object> bfs() {
        List<Object> result = new ArrayList<>();
        Queue<Tree> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            result.add(node.carga); 
            node.left.addToQueue(queue);
            node.right.addToQueue(queue);
        }

        return result;
    }
    public Tree atLeft(Tree b) {
        this.left = new ValidLink(b);
        return this;
    }

    public Tree atRight(Tree b) {
        this.right = new ValidLink(b);
        return this;
    }

    public Tree left() {
        return left.getSubTree("siniestra"); 
    }

    public Tree right() {
        return right.getSubTree("diestra"); 
    }

    public Object carga() {
        return this.carga;
    }
}
