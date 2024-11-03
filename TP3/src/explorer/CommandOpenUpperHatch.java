package explorer;

public class CommandOpenUpperHatch extends Command {

    public CommandOpenUpperHatch() {
        this.command = 'O';
    }
    public void execute(Explorer explorer) {
        explorer.openUpperHatch();
    }
    public boolean findCommand (char com){
        return com == this.command;
    }

}