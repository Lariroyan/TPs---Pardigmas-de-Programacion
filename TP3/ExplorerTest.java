package explorer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ExplorerTest {

    @Test void test00InitialPosition() {
        Explorer rover = new Explorer(0, 0,  new North());
        assertEquals(0, rover.getCoordinateX());
        assertEquals(0, rover.getCoordinateY());
        assertEquals("North", rover.getDirection());
    }

    @Test void test01TurnRightFromNorth() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('r');
        assertEquals("East", rover.getDirection());
    }

    @Test
    void test02TurnLeftFromNorth() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('l');
        assertEquals("West", rover.getDirection());
    }

    @Test void test03MoveForwardFacingNorth() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('f');
        assertEquals(0, rover.getCoordinateX());
        assertEquals(1, rover.getCoordinateY());
    }

    @Test void test04MoveBackwardFacingNorth() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('b');
        assertEquals(0, rover.getCoordinateX());
        assertEquals(-1, rover.getCoordinateY());
    }

    @Test void test05InvalidCommandStopsProcessing() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('x');
        assertEquals(0, rover.getCoordinateX());
        assertEquals(0, rover.getCoordinateY());
        assertEquals("North", rover.getDirection());
    }
    @Test void test06MoveToRightFacingNorthAndGoForward() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('r');
        rover.processCommand('f');
        assertEquals("East", rover.getDirection());
        assertEquals(0, rover.getCoordinateY());
        assertEquals(1, rover.getCoordinateX());

    }
    @Test void test07MoveToRightFacingNorthAndGoBackwards() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('r');
        rover.processCommand('b');
        assertEquals("East", rover.getDirection());
        assertEquals(0, rover.getCoordinateY());
        assertEquals(-1, rover.getCoordinateX());

    }
    @Test void test08MoveToLeftFacingNorthAndGoBackwards() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('l');
        rover.processCommand('b');
        assertEquals("West", rover.getDirection());
        assertEquals(0, rover.getCoordinateY());
        assertEquals(1, rover.getCoordinateX());

    }

    @Test
    void test09OpenUpperHatch() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('O'); // Abrir escotilla superior
        assertTrue(rover.isUpperHatchOpen());
    }

    @Test
    void test10OpenLowerHatch() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('o'); // Abrir escotilla inferior
        assertTrue(rover.isLowerHatchOpen());
    }

    @Test
    void test11CannotOpenUpperHatchIfLowerHatchIsOpen() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('o'); // Abrir escotilla inferior
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            rover.processCommand('O'); // Intentar abrir la escotilla superior
        });
        assertEquals("Cannot open upper hatch when lower hatch is open", exception.getMessage());
    }

    @Test
    void test12CannotOpenLowerHatchIfUpperHatchIsOpen() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('O');
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            rover.processCommand('o');
        });
        assertEquals("Cannot open lower hatch when upper hatch is open", exception.getMessage());
    }


    @Test
    void testCannotAspirateWithUpperHatchClosed() {
        Explorer rover = new Explorer(0, 0, new North());
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            rover.processCommand('a');
        });
        assertEquals("Cannot aspirate with upper hatch closed", exception.getMessage());
    }

    @Test
    void testAspirateWithUpperHatchOpen() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('O');
        rover.processCommand('a');

    }

    @Test
    void testCannotDigWithLowerHatchClosed() {
        Explorer rover = new Explorer(0, 0, new North());
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            rover.processCommand('i');
        });
        assertEquals("Cannot dig with lower hatch closed", exception.getMessage());
    }

    @Test
    void testDigWithLowerHatchOpen() {
        Explorer rover = new Explorer(0, 0, new North());
        rover.processCommand('o');
        rover.processCommand('i');

    }


}