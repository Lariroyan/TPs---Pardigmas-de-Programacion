package explorer;

import java.util.ArrayList;
import java.util.List;

public class South extends Direction{

    public Direction turnLeft () {
        return new East ();
    }

    public Direction turnRight () {
        return new West ();
    }
    public List<Integer> moveForward (){
        List<Integer> coordinates = new ArrayList();
        coordinates.add(0);
        coordinates.add(-1);
        return coordinates;
    }

    public  List<Integer> moveBackwards (){
        List<Integer> coordinates = new ArrayList();
        coordinates.add(0);
        coordinates.add(1);
        return coordinates;

    }

    public String getDirection () {
        return "South";
    }
}
