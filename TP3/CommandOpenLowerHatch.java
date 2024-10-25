package explorer;

public class CommandOpenLowerHatch extends Command {
    public CommandOpenLowerHatch() {
        this.command = 'o';
    }

    public boolean findCommand(char com) {
        return com == this.command;
    }

    public void execute(Explorer explorer) {
        explorer.openLowerHatch();
    }

}
