package explorer;

public class CommandAspirate extends Command{
    public CommandAspirate() {
        this.command = 'a';
    }

    public boolean findCommand(char com) {
        return com == this.command;
    }

    public void execute(Explorer explorer) {
        explorer.aspirate();
    }
}
