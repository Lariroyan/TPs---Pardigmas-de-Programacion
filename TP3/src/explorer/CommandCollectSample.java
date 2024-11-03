package explorer;

public class CommandCollectSample extends Command {

    public CommandCollectSample() {
        this.command = 'i';
    }
    public void execute(Explorer explorer) {
        explorer.collectSample();
    }
    public boolean findCommand (char com){
        return com == this.command;
    }

}