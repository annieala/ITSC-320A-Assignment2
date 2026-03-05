//Desktop computer: uses composition to include a Computer object, and adds GPU type

public class Desktop { //No longer extends Computer - uses composition instead

    //Desktop now HAS-A Computer rather than IS-A Computer
    private Computer computer;
    private String GPUType=null;

    //Constructors
    public Desktop() {
        this.computer = new Computer(); //Initialise the composed Computer object
    }

    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        this.computer = new Computer(CPU, RAM, disk); //Composed Computer object holds CPU, RAM and disk
        this.GPUType=GPUType;
    }

    //Setters - delegate CPU, RAM and disk to the composed Computer object
    public void setCPU(String CPU) {
        this.computer.setCPU(CPU);
    }

    public void setRAM(String RAM) {
        this.computer.setRAM(RAM);
    }

    public void setDisk(String disk) {
        this.computer.setDisk(disk);
    }

    public void setGPUType(String GPUType) {
        this.GPUType=GPUType;
    }

    //Getters - delegate CPU, RAM and disk to the composed Computer object
    public String getCPU() {
        return this.computer.getCPU();
    }

    public String getRAM() {
        return this.computer.getRAM();
    }

    public String getDisk() {
        return this.computer.getDisk();
    }

    public String getGPUType() {
        return this.GPUType;
    }

    //Return formatted version of data
    public String toString() {
        return "Type:Desktop\tCPU:" + this.computer.getCPU() + "\tRAM:" + this.computer.getRAM() + "\tDisk:" + this.computer.getDisk() + "\tGPU:" + this.GPUType;
    }

}
