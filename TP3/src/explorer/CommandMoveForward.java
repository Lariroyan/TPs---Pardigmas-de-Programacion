package explorer;

public class CommandMoveForward extends Command {

    public CommandMoveForward() {
        this.command = 'f';
    }

    public boolean findCommand(char com) {
        return this.command == com;
    }
    public void execute(Explorer explorer) {
        explorer.moveForward();
    }
}


