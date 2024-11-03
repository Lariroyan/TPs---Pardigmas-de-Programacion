package explorer;

public abstract class Command {
    protected char command;
    public abstract boolean findCommand(char com);
    public abstract void execute(Explorer explorer);
}
