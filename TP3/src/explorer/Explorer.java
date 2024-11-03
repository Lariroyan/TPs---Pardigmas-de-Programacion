package explorer;
import java.util.*;
public class Explorer {
    private Position coordinate;
    private Direction direction;
    private List<Command> commands = new ArrayList();
    public HatchState hatchState;
//    private boolean upperHatchOpen = false;
//    private boolean lowerHatchOpen = false;

    public Explorer(int initialX, int initialY, Direction initialDirection) {
        coordinate = new Position (initialX, initialY);
        direction = initialDirection;
        commands.addAll(Arrays.asList(new CommandMoveForward(),
                new CommandMoveBackwards(),
                new CommandTurnLeft(),
                new CommandTurnRight(),
                new CommandAspirate(),
                new CommandCollectSample(),
                new CommandOpenLowerHatch(),
                new CommandOpenUpperHatch(),
                new CommandCloseHatches()));
        hatchState = new ClosedHatches();
    }
    public Explorer processCommand(String commands) {
        commands.chars()
                .forEach(c -> this.commands.stream()
                        .filter(com -> com.findCommand((char)c))
                        .findFirst()
                        .ifPresent(commandFound -> commandFound.execute(this)));
        return this;
    }

    public void moveForward() {
        coordinate = coordinate.add(direction.moveForward());
    }

    public void moveBackwards() {
        coordinate = coordinate.add(direction.moveBackwards());    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void openUpperHatch() {
//        if (lowerHatchOpen) {
//            throw new IllegalStateException("Cannot open upper hatch when lower hatch is open");
//        }
//        upperHatchOpen = true;
        hatchState.openUpper(this);
    }

    public void openLowerHatch() {
//        if (upperHatchOpen) {
//            throw new IllegalStateException("Cannot open lower hatch when upper hatch is open");
//        }
//        lowerHatchOpen = true;
        hatchState.openLower(this);
    }

    public void closeHatches() {
//        if (upperHatchOpen) {
//            upperHatchOpen = false;
//        } else if (lowerHatchOpen) {
//            lowerHatchOpen = false;
//        } else {
//            throw new IllegalStateException("No hatch is open to close");
//        }
        hatchState.close(this);
    }

    public void aspirate() {
//        if (!upperHatchOpen) {
//            throw new IllegalStateException("Cannot aspirate with upper hatch closed");
//        }
        hatchState.aspirate(this);
    }

    public void collectSample() {
//        if (!lowerHatchOpen) {
//            throw new IllegalStateException("Cannot dig with lower hatch closed");
//        }
        hatchState.collectSample(this);
    }

    public void setHatchState(HatchState state) {
        this.hatchState = state;
    }
//    public HatchState getHatchState() {
//        return hatchState;
//    }
//    public boolean isUpperHatchOpen() {
//        return hatchState.isUpperHatchOpen(); //-> en test rover.hacthcState.isUpperHatchOpen()
//    }
//
//    public boolean isLowerHatchOpen() {
//        return hatchState.isLowerHatchOpen();
//    }

    public int getCoordinateX () {return coordinate.coordenadaX();}
    public int getCoordinateY () {return coordinate.coordenadaY();}
    public String getDirection () {return direction.getDirection();}

    public void changeToClosed() {
        setHatchState(new ClosedHatches());
    }

    public void changeToOpenUpper() {
        setHatchState(new OpenUpperHatch());
    }

    public void changeToOpenLower() {
        setHatchState(new OpenLowerHatch());
    }
}