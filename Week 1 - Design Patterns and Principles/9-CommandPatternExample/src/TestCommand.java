public class TestCommand {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        remote.on();
        remote.off();

        remote.off();
        remote.on();
        remote.on();
    }
}
