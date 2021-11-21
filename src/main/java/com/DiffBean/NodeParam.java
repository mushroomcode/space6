package com.DiffBean;

public class NodeParam extends Node {

    public NodeParam(int k, int x, Node prev) {
        super(k, x, prev);
    }

    public boolean isSnake() {
        return false;
    }

}
