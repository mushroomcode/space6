package com.DiffBean;

public abstract class Node {

    private Integer k;

    private Integer x;

    private Node prev;

    public Node(int k, int x, Node prev) {
        this.k = k;
        this.x = x;
        this.prev = prev;
    }

    public Integer getK() {
        return k;
    }

    public Integer getX() {
        return x;
    }

    public abstract boolean isSnake();

}
