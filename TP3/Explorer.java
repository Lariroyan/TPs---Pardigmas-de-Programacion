package explorer;
import java.util.*;
public class Explorer {

    //private String direction;
    private Position coordinate;
    private Direction direction;

    private boolean upperHatchOpen = false;
    private boolean lowerHatchOpen = false;

    public Explorer(int initialX, int initialY, Direction initialDirection) {
        coordinate = new Position (initialX, initialY);
        direction = initialDirection;
    }



    public void processCommand(char command) {
        switch (command) {
            case 'f': moveForward(); break;
            case 'b': moveBackward(); break;
            case 'l': turnLeft(); break;
            case 'r': turnRight(); break;
            case 'O': openUpperHatch(); break;
            case 'o': openLowerHatch(); break;
            case 'c': closeHatch(); break;
            case 'a': aspirate(); break;
            case 'i': dig(); break;
            default: return;
        }
    }

    private void moveForward() {
        coordinate = coordinate.add(direction.moveForward());
    }

    private void moveBackward() {
        coordinate = coordinate.add(direction.moveBackwards());    }

    private void turnRight() {
       direction = direction.turnRight();
    }

    private void turnLeft() {
      direction = direction.turnLeft();
    }

    private void openUpperHatch() {
        if (lowerHatchOpen) {
            throw new IllegalStateException("Cannot open upper hatch when lower hatch is open");
        }
        upperHatchOpen = true;
    }

    private void openLowerHatch() {
        if (upperHatchOpen) {
            throw new IllegalStateException("Cannot open lower hatch when upper hatch is open");
        }
        lowerHatchOpen = true;
    }

    private void closeHatch() {
        if (upperHatchOpen) {
            upperHatchOpen = false;
        } else if (lowerHatchOpen) {
            lowerHatchOpen = false;
        } else {
            throw new IllegalStateException("No hatch is open to close");
        }
    }

    private void aspirate() {
        if (!upperHatchOpen) {
            throw new IllegalStateException("Cannot aspirate with upper hatch closed");
        }
    }

    private void dig() {
        if (!lowerHatchOpen) {
            throw new IllegalStateException("Cannot dig with lower hatch closed");
        }
    }

    public boolean isUpperHatchOpen() {
        if(upperHatchOpen == true){
            return true;
        }
        throw new IllegalStateException("Cannot open upper hatch when lower hatch is open");
    }

    public boolean isLowerHatchOpen() {
        if(lowerHatchOpen == true){
            return true;
        }
        throw new IllegalStateException("Cannot open lower hatch when upper hatch is open");
    }

    public int getCoordinateX () {return coordinate.coordenadaX();}
    public int getCoordinateY () {return coordinate.coordenadaY();}
    public String getDirection () {return direction.getDirection();}
}




