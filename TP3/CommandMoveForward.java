package explorer;

public class CommandMoveForward extends Command{
    public CommandMoveForward() {
        this.command = 'f';
    }

    public boolean findCommand(char com) {
        return com == this.command;
    }

    public void execute(Explorer explorer) {
        explorer.moveForward();
    }
}
