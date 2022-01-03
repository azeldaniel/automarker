package out.Bria_Paul_657710_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author Bria Paul
 * @version 04/02/2021
 */

import java.util.Scanner; //Import input class

public class VirtualRunner{
     
    public static void main(String args []) throws Exception{
        VirtualMeetingSystem newVirtualMeetingSystem = new VirtualMeetingSystem();
        Scanner input = new Scanner(System.in);
      
        //1. Load participant data from a data file
        System.out.println("Enter the file name... \n");
        String filename = input.nextLine();
        newVirtualMeetingSystem.loadParticipantData(filename);
        
        //2. Create a new virtual room
        System.out.println("Enter the name  of the Virtual Room you wish to create. \n");
        String name = input.nextLine();
        newVirtualMeetingSystem.createVirtualRoom(name);
        
        //3. Allocate participants to breakout rooms
        System.out.println("Enter the Code (C5 or RR) to allocate participants to breakout rooms... \n");
        String code = input.nextLine();
        newVirtualMeetingSystem.allocateParticipants(code);
        System.out.println(newVirtualMeetingSystem.listParticipantsInAllBreakoutRooms());
        
        //8. Find a participant’s breakout room number
        System.out.println("Enter the ID to locate there breakoutRoom ..");
        String pID = input.nextLine();
        newVirtualMeetingSystem.findParticipantBreakoutRoom (pID);
        
        //4. Add a new participant to a breakout room
        System.out.println("Adding a new participant to the meeting room... \n");
        String participantID = input.nextLine();
        int roomNumber = input.nextInt();
        newVirtualMeetingSystem.addParticipant (participantID, roomNumber);
        
        //5. Display a list of all participants in a breakout room
        System.out.println("Enter room number to locate participants ...");
        roomNumber = input.nextInt();
        String pList=newVirtualMeetingSystem.listParticipants(roomNumber);
        
        //6. Close a breakout room based on a room number
        System.out.println("Which breakoutroom would you like to close?");
        roomNumber = input.nextInt();
        boolean isClose = newVirtualMeetingSystem.closeBreakoutRoom(roomNumber);
        
        //7. Open a breakout room based on a room number
        System.out.println("Which breakoutroom would you like to open?");
        roomNumber = input.nextInt();
        boolean isOpen = newVirtualMeetingSystem.openBreakoutRoom(roomNumber);
      
        //9. Display a list of all breakout rooms managed by the system
        System.out.println("List of all breakout rooms managed by the system");
        newVirtualMeetingSystem.listAllBreakoutRooms();
        
        //10. Display a list of all breakout rooms managed by the system and the participants in each room
        System.out.println(newVirtualMeetingSystem.listParticipantsInAllBreakoutRooms());
        
    } 
} 
