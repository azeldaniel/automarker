package out.Dexter_Cain_657793_assignsubmission_file_;/* The University of the West Indies St. Augustine Campus
    COMP2603 2021 S2
    Assignment1
    NAME: Dexter Cain
    ID: 816021817
    
    SUBMISSION #2
    
    PLEASE WATCH DEMO VIDEO: https://drive.google.com/file/d/17CVyw-Nj3GWwAEHrx-DkVL_CRC5LAxaN/view?usp=sharing
*/

import java.util.Scanner; // Import the Scanner class to read text files

public class VirtualRunner {
    private static VirtualMeetingSystem virtualMeetingSystem;
    public static void main(String[] args) {
        int choice = 0;
        Scanner inputChoice, inputData;
        String participantID;
        int roomNumber;
        
        System.out.println("\n");
        printMenuToConsole();
        System.out.print("Please choose an option from above by\nentering the corresponding menu item number (1-11) -> ");
        inputChoice = new Scanner(System.in);
        choice = inputChoice.nextInt();
        System.out.println("\n");
        while (choice != 11) {
            
            switch (choice) {
                case 1:
                    String filename = "participant.dat";
                    virtualMeetingSystem = new VirtualMeetingSystem();
                    virtualMeetingSystem.loadParticipantData(filename);
                    break;

                case 2:
                    System.out.print("Please enter a name for the virtual room -> ");
                    inputData = new Scanner(System.in);
                    virtualMeetingSystem.createVirtualRoom(inputData.nextLine());
                    break;

                case 3:
                    System.out.print("Please enter the code for the allocation strategy -> ");
                    inputData = new Scanner(System.in);
                    virtualMeetingSystem.allocateParticipants(inputData.nextLine());
                    break;

                case 4:
                System.out.print("Please enter an 8 digit number for the participant's identifier -> ");
                inputData = new Scanner(System.in);
                participantID = inputData.nextLine();
                System.out.print("Please enter the room number to add the particpant to -> ");
                inputData = new Scanner(System.in);
                roomNumber = inputData.nextInt();
                virtualMeetingSystem.addParticipant(participantID, roomNumber);

                break;

                case 5: 
                System.out.print("Please enter the room number for the breakout room -> ");
                inputData = new Scanner(System.in);
                System.out.println(virtualMeetingSystem.listParticipants(inputData.nextInt()));
                    break;

                case 6:
                System.out.print("Please enter the room number for the room you wish to close -> ");
                inputData = new Scanner(System.in);
                virtualMeetingSystem.closeBreakoutRoom(inputData.nextInt());
                break;

                case 7:
                System.out.print("Please enter the room number for the room you wish to open -> ");
                inputData = new Scanner(System.in);
                virtualMeetingSystem.openBreakoutRoom(inputData.nextInt());
                break;

                case 8:
                System.out.print("Please enter the participant's 8 digit identifier -> ");
                inputData = new Scanner(System.in);
                System.out.println(virtualMeetingSystem.findParticipantBreakoutRoom(inputData.nextLine()));
                break;

                case 9:
                System.out.println(virtualMeetingSystem.listAllBreakoutRooms());
                break;

                case 10:
                System.out.println(virtualMeetingSystem.listParticipantsInAllBreakoutRooms());
                break;

                default:
                System.out.println("Invalid option entered...please try again!");

                break;


            }

            System.out.println("\n");
            printMenuToConsole();
            System.out.print("Please choose an option from above by\nentering the corresponding menu item number -> ");
            inputChoice = new Scanner(System.in);
            choice = inputChoice.nextInt();
            System.out.println("\n");
        }

        inputChoice.close();
        System.out.print("\nExiting application...");
    }

    public static void printSymbol(int c, char symbol) {
        for (int i = 1; i <= c; i = i + 1) {
            System.out.print(symbol);
        }
        System.out.println("");
    }

    public static void printMenuToConsole() {
        printSymbol(50, '=');
        System.out.println("\tVIRTUAL MEETING SYSTEM APPLICATION");
        printSymbol(50, '=');
        System.out.println("1. Load participant data from a data file");
        System.out.println("2. Create a new virtual room");
        System.out.println("3. Allocate participants to breakout rooms");
        System.out.println("4. Add a new participant to a breakout room");
        System.out.println("5. Display a list of all participants in a breakout room");
        System.out.println("6. Close a breakout room based on a room number");
        System.out.println("7. Open a breakout room based on a room number");
        System.out.println("8. Find a participant’s breakout room number");
        System.out.println("9. Display a list of all breakout rooms managed by the system");
        System.out.println("10. Display a list of all breakout rooms managed by the system and the participants in each room");
        System.out.println("11. Exit application");
        printSymbol(60, '-');
    }

}
