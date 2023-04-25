package checker;

public abstract class Commander implements Command {

    private Command command;

    public Commander(Command command) {
        this.command = command;
    }

    protected void run() {
        command.execute();
    }
}
