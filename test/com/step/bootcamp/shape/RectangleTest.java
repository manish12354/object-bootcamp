package com.step.bootcamp.shape;

import com.step.bootcamp.shape.InvalidDimensionException;
import com.step.bootcamp.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

// Ensures that Rectangle is behaving correctly
public class RectangleTest {

    private Rectangle rectangle;

    @Before
    public void setUp() throws InvalidDimensionException {
        rectangle = Rectangle.createRectangle(10, 12);
    }

    @Test(expected = InvalidDimensionException.class)
    public void shouldThrowInvalidDimensionException() throws InvalidDimensionException {
        rectangle = Rectangle.createRectangle(4, -5);
    }

    @Test
    public void shouldReturnAreaAs120ForLengthAs10AndWidthAs12() {
        assertThat(rectangle.area(),is(120f));
    }

    @Test
    public void shouldReturnArea() throws InvalidDimensionException {
        assertThat(Rectangle.createRectangle(4,5).area(),is(20f));
    }

    @Test
    public void shouldReturnPerimeterAs44ForLengthAs10AndWidthAs12() {
        assertThat(rectangle.perimeter(),is(44f));
    }

    @Test
    public void shouldReturnPerimeter() throws InvalidDimensionException {
        assertThat(Rectangle.createRectangle(4,5).perimeter(),is(18f));
    }
}