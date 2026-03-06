//Desktop computer: uses composition to include a Computer object, and adds GPU type.
//This class is immutable - all fields are set once via the constructor and cannot be changed afterwards.
//Implements the device interface to allow Laptop and Desktop to be stored in a single ArrayList<device>.

// Cam Rieger - the classes now implement the empty device interface, which allows them to 
// 				be added to the same arrayList
public class Desktop implements ManageComputers.device { //No longer extends Computer - uses composition instead

    //Desktop now HAS-A Computer rather than IS-A Computer.
    //Both fields are final, making the object immutable once constructed.

    // Estefano - Uses an instance of the superclass instead of inheritance.
    private final Computer computer;
    private final String GPUType;

    // Anne Marie - No-arg constructor sets all fields to null
    public Desktop() {
        this.computer = new Computer(); //Initialise the composed Computer object with null fields
        this.GPUType  = null;
    }

    //Parameterised constructor - the only way to set field values
    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        this.computer = new Computer(CPU, RAM, disk); //Composed Computer object holds CPU, RAM and disk
        this.GPUType  = GPUType;
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

    public String getGPUType() {
        return this.GPUType;
    }

    //Return formatted version of data
    public String toString() {
        return "Type:Desktop\tCPU:" + this.computer.getCPU() + "\tRAM:" + this.computer.getRAM() + "\tDisk:" + this.computer.getDisk() + "\tGPU:" + this.GPUType;
    }

}
