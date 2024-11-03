package explorer;

import java.util.ArrayList;
import java.util.List;

public class East extends Direction{
    public Direction turnLeft () {
        return new North ();
    }

    public Direction turnRight () {
        return new South ();
    }
    public List<Integer> moveForward() {
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(1);
        coordinates.add(0);
        return coordinates;
    }

    @Override
    public List<Integer> moveBackwards() {
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(-1);
        coordinates.add(0);
        return coordinates;
    }


    public String getDirection () {
        return "East";
    }

}
