package com.step.bootcamp.shape;

import com.step.bootcamp.shape.InvalidDimensionException;
import com.step.bootcamp.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

// Ensures that Square is behaving correctly
public class SquareTest {

    private Rectangle square;

    @Before
    public void setUp() throws InvalidDimensionException {
        square = Rectangle.createSquare(10f);
    }

    @Test(expected = InvalidDimensionException.class)
    public void shouldThrowInvalidDimensionException() throws InvalidDimensionException {
        square = Rectangle.createSquare(-10);
    }

    @Test
    public void shouldReturnAreaAs100ForSideAs10() {
        assertThat(square.area(),is(100f));
    }

    @Test
    public void shouldReturnArea() throws InvalidDimensionException {
        assertThat(Rectangle.createSquare(5).area(),is(25f));
    }

    @Test
    public void shouldReturnPerimeterAs40ForSideAs10() {
        assertThat(square.perimeter(),is(40f));
    }

    @Test
    public void shouldReturnPerimeter() throws InvalidDimensionException {
        assertThat(Rectangle.createSquare(5).perimeter(),is(20f));
    }
}