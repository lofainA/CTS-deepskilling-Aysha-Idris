public class RemoteControl {
    Command command;

    public void on() {
        command = new LightOnCommand();
        command.execute();
    }

    public void off() {
        command = new LightOffCommand();
        command.execute();
    }
}
