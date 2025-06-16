public class Computer {
    private String brand;
    private String processor;
    private int ram;
    private int storage;
    private String operatingSystem;

    private Computer(String brand, String processor, int ram, int storage, String operatingSystem) {
        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
    }

    public String display() {
        return "Brand: " + brand +
                "\nProcessor: " + processor +
                "\nRAM: " + ram + "GB" +
                "\nStorage: " + storage + "GB" +
                "\nOS: " + operatingSystem;
    }

    static class ComputerBuilder {
        private String brand;
        private String processor;
        private int ram;
        private int storage;
        private String operatingSystem;

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public void setRam(int ram) {
            this.ram = ram;
        }

        public void setStorage(int storage) {
            this.storage = storage;
        }

        public void setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
        }

        public Computer build() {
            return new Computer(brand, processor, ram, storage,operatingSystem);
        }
    }
}
