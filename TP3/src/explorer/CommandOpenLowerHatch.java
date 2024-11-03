package explorer;

public class CommandOpenLowerHatch extends Command {

    public CommandOpenLowerHatch() {
        this.command = 'o';
    }
    public void execute(Explorer explorer) {
        explorer.openLowerHatch();
    }
    public boolean findCommand (char com){
        return com == this.command;
    }

}