package explorer;

public class CommandMoveBackwards extends Command {

    public CommandMoveBackwards () {
        this.command = 'b';
    }

    public boolean findCommand(char com) {
        return this.command == com;
    }
    public void execute(Explorer explorer) {
        explorer.moveBackwards();
    }
}