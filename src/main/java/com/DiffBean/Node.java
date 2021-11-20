package com.DiffBean;

public abstract class Node {

    private Integer x;

    private Integer y;

    private Node prev;

    public Node (int x, int y, Node prev) {
        this.x = x;
        this.y = y;
        this.prev = prev;
    }

}
