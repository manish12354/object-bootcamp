package com.step.bootcamp.shape;

public class InvalidDimensionException extends Throwable {
    public InvalidDimensionException() {
        super("Invalid Dimensions : Provide valid dimensions!");
    }
}
