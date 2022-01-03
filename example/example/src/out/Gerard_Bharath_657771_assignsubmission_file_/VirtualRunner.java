package out.Gerard_Bharath_657771_assignsubmission_file_;/**
 * 
 *
 * @Gerard Bharath
 * 816020015
 * @version (a version number or a date)
 */




import java.util.Scanner;

public class VirtualRunner
{
    public static void main(String[] args){
        VirtualMeetingSystem virtualSystem = new VirtualMeetingSystem();
        String filename = "participant.dat";
        Scanner reader = new Scanner(filename);
        filename = reader.nextLine();
        
        virtualSystem.loadParticipantData(filename);
        
        
        
        
        String virtualRoomName; 
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please input the Virtual Room's name: ");
        virtualRoomName = keyboard.nextLine();
        virtualSystem.createVirtualRoom(virtualRoomName);
        
        System.out.println("\n");
        
        
        
        
        String allocate;
        
        System.out.println("Please Input C5 to Allocate The Participants");
        allocate = keyboard.nextLine();
        virtualSystem.allocateParticipants(allocate);
        
        System.out.println("\n");
        System.out.println("The Participants have been allocated to their breakout rooms");
        
        
        
        
        String addParticipant_New;
        int breakoutroom_ID;
        
        System.out.println("\n");
        System.out.println("Please input a NEW Participant's ID: ");
        addParticipant_New = keyboard.nextLine();
        
        System.out.println("\n");
        System.out.println("Please input the breakout room ID needed for the new participant: ");
        breakoutroom_ID = keyboard.nextInt();
        virtualSystem.addParticipant(addParticipant_New, breakoutroom_ID);
        
        
        
        
        int breakoutRoomNumber;
        String listOfParticipants;
        
        System.out.println("\n");
        System.out.println("Please input the breakout room number{0 to 4} to list participants contained: ");
        breakoutRoomNumber = keyboard.nextInt();
        listOfParticipants = virtualSystem.listParticipants(breakoutRoomNumber);
        
        
        
        
        System.out.println("\n");
        System.out.println("Please input a room number{0 to 4} to close selected breakout room: ");
        boolean close_State;
        int roomNum = keyboard.nextInt();
        close_State = virtualSystem.closeBreakoutRoom(roomNum);
        if(close_State == true)
        {
            System.out.println("Breakout Room " + roomNum + " was sucessfully closed.");
        }
        
        
        
        
        System.out.println("\n");
        System.out.println("Please input a room number{0 to 4} to open selected breakout room: ");
        boolean open_State;
        roomNum = keyboard.nextInt();
        open_State = virtualSystem.openBreakoutRoom(roomNum);
        if(open_State == true)
        {
            System.out.println("Breakout Room " + roomNum + " was sucessfully opened");
        }
        
        
        
        
        String findParticipantRoom;
        
        System.out.println("\n");
        System.out.println("Please input a participant's ID to find their allocated breakout room: ");
        findParticipantRoom = keyboard.nextLine();
        
        System.out.println(virtualSystem.findParticipantBreakoutRoom(findParticipantRoom));
        
        
        
        
        System.out.println("A List of all the breakout rooms being managed by the program: " + "\n");
        virtualSystem.listAllBreakoutRooms();
        
        System.out.println("\n");
        System.out.println("\n");
        
        
        
        
        System.out.println("A List of all the Rooms and assigned participants: " +"\n");
        System.out.println("\n");
        System.out.println(virtualSystem.listParticipantsInAllBreakoutRooms());  
    }
    
    
    
    
}