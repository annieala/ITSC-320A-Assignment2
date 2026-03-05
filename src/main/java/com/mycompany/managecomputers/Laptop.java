//Laptop computer: uses composition to include a Computer object, and adds screen size

public class Laptop { //No longer extends Computer - uses composition instead

    //Laptop now HAS-A Computer rather than IS-A Computer
    private Computer computer;
    private String screenSize=null;

    //Constructors
    public Laptop() {
        this.computer = new Computer(); //Initialise the composed Computer object
    }

    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        this.computer = new Computer(CPU, RAM, disk); //Composed Computer object holds CPU, RAM and disk
        this.screenSize=screenSize;
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

    public void setScreenSize(String screenSize) {
        this.screenSize=screenSize;
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

    public String getScreenSize() {
        return this.screenSize;
    }

    //Return formatted version of data
    public String toString() {
        return "Type:Laptop\tCPU:" + this.computer.getCPU() + "\tRAM:" + this.computer.getRAM() + "\tDisk:" + this.computer.getDisk() + "\tScreen:" + this.screenSize;
    }

}
