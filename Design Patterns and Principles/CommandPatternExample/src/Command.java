abstract public class Command {
    static Light light = new Light();
    static boolean isOn = false;

    public void setIsOn() {
        isOn = !isOn;
    }

    abstract public void execute();
}
