package explorer;

public class CommandMoveBackwards extends Command {
    public CommandMoveBackwards() {
        this.command = 'b';
    }

    public boolean findCommand(char com) {
        return com == this.command;
    }

    public void execute(Explorer explorer) {
        explorer.moveBackward();
    }
}
