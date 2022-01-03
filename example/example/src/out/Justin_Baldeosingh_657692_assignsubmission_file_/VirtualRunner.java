package out.Justin_Baldeosingh_657692_assignsubmission_file_;/* Justin Baldeosingh
 * 816021226
 * COMP 2603 - OOP
 * Assignment 1
 */

//Imports the scanner class for input.
import java.util.Scanner;

//Virtual Runner Class
public class VirtualRunner{
    //Main function - Bootstraps the program.
    public static void main(String[] args){
        //Declares a new scanner to be used to get input from the keyboard.
        Scanner input = new Scanner(System.in);
        //Creates a new meeting system object.
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        
        //Declares the variables to be used.
        String filename, virtualRoomName, allocationMode, newParticipantID, partID, listOfParticipants;
        String participantBreakoutRoomNumber, listBreakoutRooms, listBreakoutRoomsAndParticipants;
        int newBreakoutRoomNumber, breakoutRoomNumber;
        boolean successfulOp, mainLoop = true, successfulAdd;
        
        //Sets the filename to the datafile name.
        filename = "participant.dat";
        //Loads the data from the datafile into the virtual meeting system.
        vms.loadParticipantData(filename);
        
        //Sets the virtual meeting system name and creates a virtual room using that input virtual room name.
        virtualRoomName = "Workshop";
        vms.createVirtualRoom(virtualRoomName);
        
        //Prompts the user to enter an allocation mode, accepts the allocation mode, and allocates 
        //the participants based on the entered allocation mode.
        System.out.println("Enter Allocation Mode (C5 or RR): ");
        allocationMode = input.nextLine(); 
        vms.allocateParticipants(allocationMode);

        //While the user has not entered option 8, continue processing data.
        while(mainLoop){
            //Displays a menu to the user and prompts for and accepts their selection.
            System.out.println("PLEASE SELECT AN OPTION \n");
            System.out.println("1. Add A New Participant");
            System.out.println("2. Display Breakout Room Participants");
            System.out.println("3. Close Breakout Room");
            System.out.println("4. Open Breakout Room");
            System.out.println("5. Find Participant Breakout Room");
            System.out.println("6. Display Breakout Rooms");
            System.out.println("7. Display Breakout Rooms and Participants");
            System.out.println("8. Exit\n");
            

            System.out.println("SELECTION: ");
            String selection = input.nextLine();
            
            //Determines the appropriate action based on the user's selection.
            switch(selection){
                //If the user chose menu option 1, prompt for the ID and room number and add the participant
                //to the corresponding room.
                case "1":
                    //Prompts for and accepts the participant's ID.
                    System.out.println("Enter New Participant ID: ");
                    newParticipantID = input.nextLine();
                    //Prompts for and accepts the breakout room.
                    System.out.println("Enter Breakout Room Number: ");
                    newBreakoutRoomNumber = input.nextInt();
                    //Adds the entered participant ID to the entered breakout room and stores the outcome.
                    successfulAdd = vms.addParticipant(newParticipantID, newBreakoutRoomNumber);
                    //Prints the outcome of the operation to the user.
                    if(successfulAdd)
                        System.out.println("Succesfully added the participant!");
                    else
                        System.out.println("Unable to add participant!");
                    break;
                //If the user chose menu option 2, prompt for the room number and list the participants of
                //the corresponding room.
                case "2":
                    //Prompts for and accepts the breakout room.
                    System.out.println("Enter Breakout Room Number: ");
                    breakoutRoomNumber = input.nextInt();
                    
                    //Gets and stores the list of the participant of the breakout room.
                    listOfParticipants = vms.listParticipants(breakoutRoomNumber);
                    
                    //Prints the participants of the entered breakout room if the 
                    if(listOfParticipants != null)
                        System.out.println(listOfParticipants);
                    else
                        System.out.println("Unable to find breakout room!");
                    break;
                //If the user chose menu option 3, prompt for the room number and close that room.
                case "3":
                    //Prompts for and accepts the breakout room.
                    System.out.println("Enter Breakout Room Number: ");
                    breakoutRoomNumber = input.nextInt();
                    //Close the entered room and store the outcome of the operation.
                    successfulOp = vms.closeBreakoutRoom(breakoutRoomNumber);
                    
                    //Inform the user of the outcome of the operation.
                    if(successfulOp)
                        System.out.println("Successfully closed breakout room!\n");
                    else
                        System.out.println("Unable to close breakout room!\n");
                        
                    break;
                //If the user chose menu option 4, prompt for the room number and open that room.
                case "4":
                    //Prompts for and accepts the breakout room.
                    System.out.println("Enter Breakout Room Number: ");
                    breakoutRoomNumber = input.nextInt();
                    //Open the entered room and store the outcome of the operation.
                    successfulOp = vms.openBreakoutRoom(breakoutRoomNumber);
                    
                    //Inform the user of the outcome of the operation.
                    if(successfulOp)
                        System.out.println("Successfully opened breakout room!\n");
                    else
                        System.out.println("Unable to open breakout room!\n");
                        
                    break;
                //If the user chose menu option 5, prompt for their ID and find their breakout room.
                case "5":
                    //Prompts for and accepts the participant's ID.
                    System.out.println("Enter Participant ID: ");
                    partID = input.nextLine();
                    
                    //Finds and stores the breakout room Id of the entered participant.
                    participantBreakoutRoomNumber = vms.findParticipantBreakoutRoom(partID);
                    
                    //If the room was found, print its breakout ID,
                    if(participantBreakoutRoomNumber != null){
                        System.out.println("BreakoutID of Participant: " + participantBreakoutRoomNumber + "\n");
                    } else
                    //Otherwise, inform the user that the participant's room could not be found.
                        System.out.println("Unable to find participant's breakout room!\n");
                        
                    break;    
                //If the user chose menu option 6, display a list of all the breakout rooms.
                case "6":
                    //Finds and stores a list of all the breakout rooms.
                    listBreakoutRooms = vms.listAllBreakoutRooms();
                    
                    //Prints a list of all the breakout rooms if there exists breakout rooms.
                    if(listBreakoutRooms != null){   
                        System.out.println(listBreakoutRooms);
                    } else 
                    //Otherwise, no breakout rooms were found.
                        System.out.println("No breakout rooms found!\n");
                        
                    break; 
                //If the user chose menu option 7, list all of the participants in all of the breakout rooms.
                case "7":
                    //Finds and stores a list of all participants in all of the breakout rooms.
                    listBreakoutRoomsAndParticipants = vms.listParticipantsInAllBreakoutRooms();
                    //Prints the header.
                    System.out.println("Breakout Rooms and Participants Managed by System\n");
                    
                    //Prints a list of all of the participants in all of the breakout rooms if there exists breakout rooms.
                    if(listBreakoutRoomsAndParticipants != null){   
                        System.out.println(listBreakoutRoomsAndParticipants);
                    } else 
                    //Otherwise, no breakout rooms were found.
                        System.out.println("No breakout rooms found!\n");
                    break;  
                //If the user chose menu option 8, exit the program.
                case "8":
                    //Sets the program loop to false.
                    mainLoop = false;
                    break;
            }
        }
        
        return;
    }
}
