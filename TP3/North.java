package explorer;
import java.util.*;
public class North extends Direction{

    public Direction turnLeft () {
        return new West ();
    }

    public Direction turnRight () {
        return new East ();
    }
    public List<Integer> moveForward (){
        List<Integer> coordinates = new ArrayList();
        coordinates.add(0);
        coordinates.add(1);
        return coordinates;
    }

    public  List<Integer> moveBackwards (){
        List<Integer> coordinates = new ArrayList();
        coordinates.add(0);
        coordinates.add(-1);
        return coordinates;

    }

    public String getDirection () {
        return "North";
    }


}
