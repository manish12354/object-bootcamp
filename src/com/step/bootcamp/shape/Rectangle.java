package com.step.bootcamp.shape;

// Understands the enclosed shape with four corners at right angle
public class Rectangle {
    private final float length;
    private final float width;

    private Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    private static void validateDimensions(float[] dimensions) throws InvalidDimensionException {
        for (float dimension : dimensions) {
            if (dimension <= 0) throw new InvalidDimensionException();
        }
    }

    public static Rectangle createRectangle(float length, float width) throws InvalidDimensionException {
        validateDimensions(new float[] {length,width});
        return new Rectangle(length, width);
    }

    public static Rectangle createSquare(float side) throws InvalidDimensionException {
        validateDimensions(new float[] {side});
        return new Rectangle(side, side);
    }

    public float area() {
        return length * width;
    }

    public float perimeter() {
        return 2 * (length + width);
    }
}