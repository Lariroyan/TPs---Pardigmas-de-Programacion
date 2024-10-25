package explorer;
import java.util.*;
public class Explorer {

    private Position coordinate;
    private Direction direction;
    private List<Command> commands = new ArrayList();
    private boolean upperHatchOpen = false;
    private boolean lowerHatchOpen = false;

    public Explorer(int initialX, int initialY, Direction initialDirection) {
        coordinate = new Position (initialX, initialY);
        direction = initialDirection;
        commands.addAll(Arrays.asList(new CommandMoveForward(),
                new CommandMoveBackwards(),
                new CommandTurnLeft(),
                new CommandTurnRight(),
                new CommandAspirate(),
                new CommandDig(),
                new CommandOpenLowerHatch(),
                new CommandOpenUpperHatch(),
                new CommandoCloseHatch()));
    }

    public Explorer doThis(String command){
        command.chars()
                .forEach(c -> this.commands.stream()
                        .filter(com -> com.findCommand((char) c))
                        .findFirst()
                        .ifPresent(commandFound -> commandFound.execute(this)));
        return this;

    }


    public void moveForward() {
        coordinate = coordinate.add(direction.moveForward());
    }

    public void moveBackward() {
        coordinate = coordinate.add(direction.moveBackwards());    }

    public void turnRight() {
       direction = direction.turnRight();
    }

    public void turnLeft() {
      direction = direction.turnLeft();
    }

    public void openUpperHatch() {
        if (lowerHatchOpen) {
            throw new IllegalStateException("Cannot open upper hatch when lower hatch is open");
        }
        upperHatchOpen = true;
    }

    public void openLowerHatch() {
        if (upperHatchOpen) {
            throw new IllegalStateException("Cannot open lower hatch when upper hatch is open");
        }
        lowerHatchOpen = true;
    }

    public void closeHatch() {
        if (upperHatchOpen) {
            upperHatchOpen = false;
        } else if (lowerHatchOpen) {
            lowerHatchOpen = false;
        } else {
            throw new IllegalStateException("No hatch is open to close");
        }
    }

    public void aspirate() {
        if (!upperHatchOpen) {
            throw new IllegalStateException("Cannot aspirate with upper hatch closed");
        }
    }

    public void dig() {
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




