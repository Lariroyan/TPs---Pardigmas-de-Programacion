package explorer;

public class CommandTurnLeft extends Command {

    public CommandTurnLeft() {
        this.command = 'l';
    }
    public void execute(Explorer explorer) {
        explorer.turnLeft();
    }

    public boolean findCommand (char com){
        return com == this.command;
    }

}

