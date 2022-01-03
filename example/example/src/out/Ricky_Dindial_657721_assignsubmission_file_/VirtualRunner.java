package out.Ricky_Dindial_657721_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * Ricky Dindial
 * 816022023
 */

import java.util.Scanner;

public class VirtualRunner
{
    public static void main(String[] args){
        //1. Load participant data from a data file
        VirtualMeetingSystem virtualSystem = new VirtualMeetingSystem();
        String filename = "participant.dat";
        Scanner reader = new Scanner(filename);
        filename = reader.nextLine();
        virtualSystem.loadParticipantData(filename);
        
        
        //2. Create a new virtual room
        String virtualRoomName; 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of Virtual Room: ");
        virtualRoomName = keyboard.nextLine();
        virtualSystem.createVirtualRoom(virtualRoomName);
        System.out.println("\n");
        
        
        //3. Allocate participants to breakout rooms
        String allocate;
        System.out.println("Enter C5 to allocate participants");
        allocate = keyboard.nextLine();
        virtualSystem.allocateParticipants(allocate);
        System.out.println("Participants were allocated to their respective breakout rooms");
        
        
        //4. Add a new participant to a breakout room
        String addNewParticipant;
        int idOfBreakoutroom;
        System.out.println("Enter a new participant ID: ");
        addNewParticipant = keyboard.nextLine();
        System.out.println("Enter the breakout room ID for the new participant ID: ");
        idOfBreakoutroom = keyboard.nextInt();
        virtualSystem.addParticipant(addNewParticipant, idOfBreakoutroom);
        
        
        //5. Display the list of of participants in a breakout room
        int breakoutRoomNumber;
        String listOfParticipants;
        System.out.println("Enter the number of a breakout room to list its participants (0 to 4): ");
        breakoutRoomNumber = keyboard.nextInt();
        listOfParticipants = virtualSystem.listParticipants(breakoutRoomNumber);
        
        
        //6. Close a breakout room based on a room number
        System.out.println("Enter a room number to close a breakout room (0 to 4): ");
        boolean closedState;
        int roomNum = keyboard.nextInt();
        closedState = virtualSystem.closeBreakoutRoom(roomNum);
        if(closedState == true){
            System.out.println("Breakout Room " + roomNum + " has been closed");
        }
        
        
        //7. Open a breakout room based on a room number
        System.out.println("Enter a room number to open a breakout room (0 to 4): ");
        boolean openedState;
        roomNum = keyboard.nextInt();
        openedState = virtualSystem.openBreakoutRoom(roomNum);
        if(openedState == true){
            System.out.println("Breakout Room " + roomNum + " has been opened");
        }
        
        
        //8. Find a participant's breakout room number
        String findParticipantRoom;
        System.out.println("Enter a participant ID to locate their breakout room: ");
        findParticipantRoom = keyboard.nextLine();
        System.out.println(virtualSystem.findParticipantBreakoutRoom(findParticipantRoom));
        
        
        //9. Display a list of all breakout rooms managed by the system
        System.out.println("List of all breakout rooms managed by the system: " + "\n");
        virtualSystem.listAllBreakoutRooms();
        
        
        //10. Display a list of all breakout rooms managed by the system and the participants in each room
        System.out.println("List of all breakout rooms and their corresponding participants: " + "\n");
        System.out.println(virtualSystem.listParticipantsInAllBreakoutRooms());  
    }
}
