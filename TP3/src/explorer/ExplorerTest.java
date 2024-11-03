package explorer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ExplorerTest {

    @Test void test00InitialPosition() {
        assertPosition(initializeExplorer(),0, 0, "North");
    }

    @Test void test01TurnRightFromNorth() {
        assertEquals("East", initializeExplorer()
                .processCommand("r")
                .getDirection());
    }

    @Test
    void test02TurnLeftFromNorth() {
        assertEquals("West", initializeExplorer()
                .processCommand("l")
                .getDirection());
    }

    @Test void test03MoveForwardFacingNorth() {
        assertCoordinates(initializeExplorer()
                .processCommand("f"), 0,1);
    }

    @Test void test04MoveBackwardFacingNorth() {
        assertCoordinates(initializeExplorer()
                .processCommand("b"), 0,-1);
    }

    @Test void test05InvalidCommandStopsProcessing() {
        assertPosition(initializeExplorer()
                .processCommand("x"), 0, 0, "North");
    }

    @Test void test06MoveToRightFacingNorthAndGoForward() {
        Explorer rover = initializeExplorer().processCommand("rf");
        assertPosition(rover, 1, 0, "East");
    }
    
    @Test void test07MoveToRightFacingNorthAndGoBackwards() {
        Explorer rover = initializeExplorer().processCommand("rb");
        assertPosition(rover, -1, 0, "East");

    }
    @Test void test08MoveToLeftFacingNorthAndGoBackwards() {
        Explorer rover = initializeExplorer().processCommand("lb");
        assertPosition(rover, 1, 0, "West");
    }

    @Test
    void test09OpenUpperHatch() {
        assertTrue(initializeExplorer().processCommand("O").hatchState.isUpperHatchOpen());
    }

    @Test
    void test10OpenLowerHatch() {
        assertTrue(initializeExplorer().processCommand("o").hatchState.isLowerHatchOpen());
    }
    @Test
    void test11CannotOpenUpperHatchIfLowerHatchIsOpen() {
        assertThrowsLike(HatchState.errorMessage_UpperOpen,() ->
            initializeExplorer().processCommand("oO"));
    }

    @Test
    void test12CannotOpenLowerHatchIfUpperHatchIsOpen() {
        assertThrowsLike(HatchState.errorMessage_LowerOpen,
                () -> initializeExplorer().processCommand("Oo"));
    }


    @Test
    void test13CannotAspirateWithUpperHatchClosed() {
        assertThrowsLike(HatchState.errorMessage_AspirateUpperClosed
                ,()-> initializeExplorer().processCommand("a") );
    }

    @Test
    void test14AspirateWithUpperHatchOpen() {
        initializeExplorer().processCommand("Oa");

    }

    @Test
    void test15CannotDigWithLowerHatchClosed() {
        assertThrowsLike(HatchState.errorMessage_CollectSampleLowerClosed,
                () -> initializeExplorer().processCommand("i"));
    }

    @Test
    void test16DigWithLowerHatchOpen() {
        initializeExplorer().processCommand("oi");
    }

    @Test
    void test17ToOriginFacingNorth() {
        Explorer rover = initializeExplorer().processCommand("lfrfrbfflb");
        assertPosition(rover, 0, 0, "North");
    }

    private static Explorer initializeExplorer() {
        return new Explorer(0, 0,  new North());
    }

    private static void assertPosition(Explorer explorer, int x, int y, String direction) {
        assertEquals(x, explorer.getCoordinateX());
        assertEquals(y, explorer.getCoordinateY());
        assertEquals(direction, explorer.getDirection());
    }
    private static void assertCoordinates (Explorer explorer, int x, int y) {
        assertEquals(x, explorer.getCoordinateX());
        assertEquals(y, explorer.getCoordinateY());
    }
    private static void assertThrowsLike(String expectedMessage, Executable executable) {
        assertEquals(expectedMessage,
                assertThrows(Exception.class, executable)
                        .getMessage());
    }

}
