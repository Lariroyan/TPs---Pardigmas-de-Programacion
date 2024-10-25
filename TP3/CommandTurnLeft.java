package explorer;

public class CommandTurnLeft extends Command{
    public CommandTurnLeft() {
        this.command = 'l';
    }

    public boolean findCommand(char com) {
        return com == this.command;
    }

    public void execute(Explorer explorer) {
        explorer.turnLeft();
    }
}
