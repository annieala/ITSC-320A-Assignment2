//Manage Computers program: maintains a single ArrayList<Object> holding Laptop and Desktop objects.
//Desktop and Laptop use composition (they contain a Computer object) rather than inheritance.

import java.util.ArrayList;
import java.util.Scanner;

public class ManageComputers {

    // WHITELISTS - edit these strings to allow or disallow accepted values.
    // Each accepted value must be separated by a comma.
    static final String WHITELIST_CPU        = "i5,i7";
    static final String WHITELIST_RAM        = "16,32";
    static final String WHITELIST_DISK       = "512,1024";
    static final String WHITELIST_GPU        = "Nvidia,AMD";
    static final String WHITELIST_SCREENSIZE = "13,14";

    public static void main(String args[]) {

        //This ArrayList will hold all the computers in the system. Since Desktop and Laptop no longer extend
        //Computer (they use composition instead), the ArrayList type is Object so both can be stored in it.
        ArrayList<Object> computers = new ArrayList<Object>(); 

        Scanner s = new Scanner(System.in);
        String menuOption="";

        do { //Start of main program loop

            //Show computer data in ArrayList<Object>
            showComputers(computers); 

            //Display menu and return menu option selected by the user
            menuOption = getMenuSelection(s);

            switch(menuOption) {
                //Add new computer
                case "a": 

                    addComputer(computers,s);

                    break;

                //Delete a computer    
                case "d": 

                    deleteComputer(computers,s);

                    break;

                //Edit a computer    
                case "e": 

                    editComputer(computers, s);

                    break;

            }

        } while ( ! menuOption.equals("x") ); //Stop when "x" is entered

        s.close(); //Close keyboard scanner

    } //End of main

    //Display menu and get user selection, return it
    private static String getMenuSelection(Scanner s) {
        String menuOption="";

        //Display menu options on-screen
        System.out.println("----------");
        System.out.println("A) Add Computer");
        System.out.println("D) Delete Computer");
        System.out.println("E) Edit Computer");
        System.out.println("X) eXit");
        System.out.println("----------");

        //Get menu selection from keyboard
        System.out.print("Enter menu selection:");
        menuOption = s.nextLine();

        menuOption = menuOption.toLowerCase(); //Make lower case for comparison purposes

        return menuOption;
    } //End of getMenuSelection

    //Show data for all Laptop and Desktop objects stored in the single ArrayList<Object>
    private static void showComputers(ArrayList<Object> computers) {
        int computerListNumber=0; //This variable is used to hold the "list number" for each computer, starting at 1.

        System.out.println("=========");

        System.out.println("LIST OF COMPUTERS:-");

        for (Object c: computers) {

            computerListNumber++; //Increment list number for each computer

            //Call overridden toString() method for current object to get and display its data
            System.out.println(computerListNumber + ": " + c.toString());
        }

        System.out.println("=========");

    } //End of showComputers

    //Add a new Laptop or Desktop computer to the ArrayList<Object>
    private static void addComputer(ArrayList<Object> computers, Scanner s) {
        String computerType="";

        Computer tempComputer=null;

        System.out.println("ADDING COMPUTER:-");

        System.out.println("Enter type of computer to add ('L' for Laptop, 'D' for Desktop):");
        computerType=s.nextLine();
        computerType=computerType.toLowerCase(); //Convert to lower case for comparison purposes

        switch(computerType) {

            //Add a laptop
            case "l": 

                //Get CPU, RAM and Disk info
                tempComputer = getComputerData(s); 

                String screenSize = getValidatedInput(s, "Enter screen size (" + WHITELIST_SCREENSIZE + "):", WHITELIST_SCREENSIZE);

                //Add new Laptop to ArrayList in main() method
                computers.add(new Laptop(tempComputer.getCPU(),tempComputer.getRAM(),tempComputer.getDisk(),screenSize)); 

                break;
            
            //Add a desktop    
            case "d": 

                //Get CPU, RAM and Disk info
                tempComputer = getComputerData(s); 

                String GPUType = getValidatedInput(s, "Enter GPU (" + WHITELIST_GPU + "):", WHITELIST_GPU);

                //Add new Desktop to ArrayList in main() method
                computers.add(new Desktop(tempComputer.getCPU(),tempComputer.getRAM(),tempComputer.getDisk(),GPUType)); 

                break;

            //Invalid computer type to add entered
            default:

                System.out.println("Invalid computer type entered!");

        }
    } //End of addComputer

    //Delete a specified computer from the ArrayList
    private static void deleteComputer(ArrayList<Object> computers, Scanner s) {
        int computerListNumberToDelete=0;

        System.out.println("DELETE COMPUTER:-");

        System.out.print("Enter number of computer to delete:");
        computerListNumberToDelete = Integer.parseInt(s.nextLine());

        //Check if computer list number is valid before deleting computer from list
        if (computerListNumberToDelete>=1 && computerListNumberToDelete<=computers.size()) {
            //Subtract 1 to get ArrayList index from on-screen list number to create correct index in ArrayList to delete
            computers.remove(computerListNumberToDelete-1); 
        }   
        else {
            System.out.println("Invalid computer number entered!");
        }

    } //End of deleteComputer

    //Edit a computer. Since Laptop and Desktop are now immutable, the old object cannot be changed.
    //Instead, a new object is created with the updated values and replaces the old one in the ArrayList.
    private static void editComputer(ArrayList<Object> computers, Scanner s) {
        int computerListNumberToEdit=0;
        String computerType="";
        Computer tempComputer=null;

        System.out.println("EDIT COMPUTER:-");

        System.out.print("Enter number of computer to edit:");
        computerListNumberToEdit = Integer.parseInt(s.nextLine());

        //Check that computerListNumberToEdit is valid first
        if (computerListNumberToEdit>=1 && computerListNumberToEdit<=computers.size()) {

            //Determine exact type of computer being edited
            //Subtract 1 to get ArrayList index from on-screen list number
            if (computers.get(computerListNumberToEdit-1) instanceof Laptop) { 
                computerType="laptop";
            }
            //Subtract 1 to get ArrayList index from on-screen list number
            else if (computers.get(computerListNumberToEdit-1) instanceof Desktop) { 
                computerType="desktop";
            }

            //Edit computer
            switch(computerType) {

                //Editing a laptop
                case "laptop": 
            
                    System.out.println("Editing a Laptop:");

                    //Get validated CPU, RAM and Disk info
                    tempComputer = getComputerData(s); 

                    String screenSize = getValidatedInput(s, "Enter screen size (" + WHITELIST_SCREENSIZE + "):", WHITELIST_SCREENSIZE);

                    //Replace the old immutable Laptop object at this index with a newly constructed one
                    computers.set(computerListNumberToEdit-1, new Laptop(tempComputer.getCPU(), tempComputer.getRAM(), tempComputer.getDisk(), screenSize));

                    break;

                //Editing a desktop
                case "desktop": 

                    System.out.println("Editing a Desktop:");

                    //Get validated CPU, RAM and Disk info
                    tempComputer = getComputerData(s); 

                    String GPUType = getValidatedInput(s, "Enter GPU (" + WHITELIST_GPU + "):", WHITELIST_GPU);

                    //Replace the old immutable Desktop object at this index with a newly constructed one
                    computers.set(computerListNumberToEdit-1, new Desktop(tempComputer.getCPU(), tempComputer.getRAM(), tempComputer.getDisk(), GPUType));

                    break;

            }

        }
        else {
            System.out.println("Invalid computer number entered!");
        }

    } //End of editComputer

    //Helper method to get data common to Laptop and Desktop (CPU, RAM and disk) objects. Returns a Computer-type object
    //holding these values as attributes. All fields are whitelist validated before the object is returned.
    private static Computer getComputerData(Scanner s) {

        String CPU  = getValidatedInput(s, "Enter CPU ("  + WHITELIST_CPU  + "):", WHITELIST_CPU);
        String RAM  = getValidatedInput(s, "Enter RAM ("  + WHITELIST_RAM  + "):", WHITELIST_RAM);
        String disk = getValidatedInput(s, "Enter Disk (" + WHITELIST_DISK + "):", WHITELIST_DISK);

        return new Computer(CPU, RAM, disk);

    } //End of getComputerData

    //Whitelist input validation helper: repeatedly prompts the user until they enter a value that
    //exists in the comma-separated whitelist string. Returns the accepted value.
    //To add or remove allowed values, edit the whitelist constants declared at the top of this class.
    private static String getValidatedInput(Scanner s, String prompt, String whitelist) {

        String input = "";
        boolean valid = false;

        //Split the whitelist string on commas to get individual allowed values
        String[] allowedValues = whitelist.split(",");

        do {
            System.out.print(prompt + " ");
            input = s.nextLine().trim(); //Read input and remove leading/trailing whitespace

            //Check whether the input matches any value in the whitelist
            for (String allowed : allowedValues) {
                if (input.equals(allowed)) {
                    valid = true;
                    break;
                }
            }

            //If no match was found, tell the user what values are accepted
            if (!valid) {
                System.out.println("Invalid input. Accepted values are: " + whitelist);
            }

        } while (!valid); //Keep looping until a valid value is entered

        return input;

    } //End of getValidatedInput


} //End of ManageComputer class
