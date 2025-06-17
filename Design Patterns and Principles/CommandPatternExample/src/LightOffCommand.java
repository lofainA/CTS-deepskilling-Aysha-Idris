public class LightOffCommand extends Command {
    @Override
    public void execute() {
        if(isOn) {
            System.out.println("Turning off lights");
            light.isOff();
            isOn = false;
        } else {
            System.out.println("Lights are already off..");
        }
    }
}
