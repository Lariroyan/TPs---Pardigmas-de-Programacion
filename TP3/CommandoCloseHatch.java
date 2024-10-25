package explorer;

public class CommandoCloseHatch extends Command {
    public CommandoCloseHatch() {
        this.command = 'c';
    }

    public boolean findCommand(char com) {
        return com == this.command;
    }

    public void execute(Explorer explorer) {
        explorer.closeHatch();
    }
}
