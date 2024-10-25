package explorer;

public class CommandDig extends Command{
    public CommandDig() {
        this.command = 'i';
    }

    public boolean findCommand(char com) {
        return com == this.command;
    }

    public void execute(Explorer explorer) {
        explorer.dig();
    }
}
