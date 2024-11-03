package explorer;
import java.util.*;
public abstract class Direction {
    public abstract Direction turnLeft();
    public abstract Direction turnRight();
    public abstract List<Integer> moveForward ();
    public abstract List<Integer> moveBackwards ();
    public abstract String getDirection ();

}
