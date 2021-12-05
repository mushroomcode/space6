package com.DiffBean;

public class SnakeParam extends Node {

    public SnakeParam(int x, int y, Node prev) {
        super(x, y, prev);
    }

    @Override
    public boolean isSnake() {
        return true;
    }
}
