package explorer;

public class CommandTurnRight extends Command{
    public CommandTurnRight() {
        this.command = 'r';
    }

    public boolean findCommand(char com) {
        return com == this.command;
    }

    public void execute(Explorer explorer) {
        explorer.turnRight();
    }
}
