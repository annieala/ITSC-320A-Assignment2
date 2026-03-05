//Computer class: manages computer CPU, RAM and Disk information.
//This class is immutable - all fields are set once via the constructor and cannot be changed afterwards.

public class Computer {

    //Fields are private and final so they can only be assigned once, making the object immutable
    private final String CPU;
    private final String RAM;
    private final String disk;

    //No-arg constructor sets all fields to null
    public Computer() {
        this.CPU  = null;
        this.RAM  = null;
        this.disk = null;
    }

    //Parameterised constructor - the only way to set field values
    public Computer(String CPU, String RAM, String disk) {
        this.CPU  = CPU;
        this.RAM  = RAM;
        this.disk = disk;
    }

    //Getters only - no setters, as this class is immutable
    public String getCPU() {
        return this.CPU;
    }

    public String getRAM() {
        return this.RAM;
    }

    public String getDisk() {
        return this.disk;
    }

}
