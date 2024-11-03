package explorer;

public class CommandCloseHatches extends Command {
    public CommandCloseHatches() {
        this.command = 'c';
    }
    public void execute(Explorer explorer) {
        explorer.closeHatches();
    }
    public boolean findCommand (char comm){
        return comm == this.command;
    }
}
