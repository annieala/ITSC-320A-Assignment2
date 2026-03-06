//Laptop computer: uses composition to include a Computer object, and adds screen size.
//Cam Rieger: This class is immutable - all fields are set once via the constructor and cannot be changed afterwards.
//Implements the device interface to allow Laptop and Desktop to be stored in a single ArrayList<device>.

public class Laptop implements ManageComputers.device { //No longer extends Computer - uses composition instead

    //Laptop now HAS-A Computer rather than IS-A Computer.
    //Both fields are final, making the object immutable once constructed.

    // Estefano: Uses an instance of the superclass instead of inheritance.
    private final Computer computer;
    private final String screenSize;

    //No-arg constructor sets all fields to null
    public Laptop() {
        this.computer   = new Computer(); //Initialise the composed Computer object with null fields
        this.screenSize = null;
    }

    // Estafano: Parameterised constructor - the only way to set field values
    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        this.computer   = new Computer(CPU, RAM, disk); //Composed Computer object holds CPU, RAM and disk
        this.screenSize = screenSize;
    }

    //Getters only - no setters, as this class is immutable.
    //CPU, RAM and disk are retrieved by delegating to the composed Computer object.
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
