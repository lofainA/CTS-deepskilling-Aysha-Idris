public class LightOnCommand extends Command {
    @Override
    public void execute() {
        if(!isOn){
            System.out.println("Turning on lights");
            light.isOn();
            isOn = true;
        } else {
            System.out.println("Lights are already on..");
        }
    }
}
