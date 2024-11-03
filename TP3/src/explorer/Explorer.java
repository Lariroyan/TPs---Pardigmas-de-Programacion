package explorer;
import java.util.*;
public class Explorer {
    private Position coordinate;
    private Direction direction;
    private List<Command> commands = new ArrayList();
    public HatchState hatchState;

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
        hatchState.openUpper(this);
    }

    public void openLowerHatch() {
        hatchState.openLower(this);
    }

    public void closeHatches() {
        hatchState.close(this);
    }

    public void aspirate() {
        hatchState.aspirate(this);
    }

    public void collectSample() {
        hatchState.collectSample(this);
    }

    public void setHatchState(HatchState state) {
        this.hatchState = state;
    }

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
