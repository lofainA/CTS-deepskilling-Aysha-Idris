public class TestBuilder {
    public static void main(String[] args) {
        Computer.ComputerBuilder cb = new Computer.ComputerBuilder();
        cb.setBrand("Dell");
        cb.setProcessor("Intel core i7");
        cb.setRam(8);
        cb.setStorage(1400);
        cb.setOperatingSystem("Windows");
        Computer comp = cb.build();

        System.out.println(comp.display());
    }
}
