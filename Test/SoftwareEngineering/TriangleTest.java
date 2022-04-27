package SoftwareEngineering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void triangle() {
        Triangle triangle = new Triangle();

        assertEquals(triangle.INVALID,triangle.triangle(1,2,3));
        assertEquals(triangle.INVALID,triangle.triangle(2,2,5));


        assertEquals(triangle.EQUILATERAL,triangle.triangle(3,3,3));


        assertEquals(triangle.ISOSCELES,triangle.triangle(5,5,3));
        assertNotEquals(triangle.ISOSCELES,triangle.triangle(2,2,5));
        assertNotEquals(triangle.ISOSCELES,triangle.triangle(2,2,5));


        assertEquals(triangle.SCALENE,triangle.triangle(3,4,5));
        assertEquals(triangle.SCALENE,triangle.triangle(7,12,15));

        assertNotNull(triangle.triangle(1,1,1));
    }
}