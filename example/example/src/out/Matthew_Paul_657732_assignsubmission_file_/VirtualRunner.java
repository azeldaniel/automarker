package out.Matthew_Paul_657732_assignsubmission_file_;/**
 * Write a description of class VirtualRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//Matthew Paul 816018640
import java.util.Scanner;
public class VirtualRunner
{
    public static VirtualMeetingSystem vms=new VirtualMeetingSystem();
    public static void main(String args[]){
        vms.loadParticipantData("participant.dat");
        System.out.println("Participant Data loaded and ready to be allocated");
        
        
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Enter the name of the Virtual Room");
        String name=keyboard.nextLine();
        vms.createVirtualRoom(name);
        
        System.out.println("\n");
        System.out.println("Would you like to allocate participants in C5 or RR pattern?");
        String code=keyboard.nextLine();
        vms.allocateParticipants(code); 
        
        
        System.out.println("\n");
        System.out.println("Enter an ID to be added");
        String id=keyboard.nextLine();
        System.out.println("Enter the room number to add the ID");
        int roomNumber=keyboard.nextInt();
        boolean added=vms.addParticipant(id,roomNumber);
        if(added==true){
            System.out.println(id +" successfully added");
        }
        else{
            System.out.println(id +" was not added");
        }
        
        System.out.println("\n");
        System.out.println("Enter the room number in which you want to view the list of its participants");
        roomNumber=keyboard.nextInt();
        String list=vms.listParticipants(roomNumber);
        System.out.println(list);
        
        System.out.println("\n");
        System.out.println("Enter the room number to open");
        roomNumber=keyboard.nextInt();
        boolean open=vms.openBreakoutRoom(roomNumber);
        if(open==true){
            System.out.println("Successfully opened");
        }
        else{
            System.out.println("Room not opened");
        }
        
        System.out.println("\n");
        System.out.println("Enter the room number to close");
        roomNumber=keyboard.nextInt();
        boolean close=vms.openBreakoutRoom(roomNumber);
        if(close==true){
            System.out.println("Successfully closed");
        }
        else{
            System.out.println("Room not closed");
        }
        
        System.out.println("\n");
        Scanner key=new Scanner(System.in);
        System.out.println("Enter a participant you'd like to find.");
        String partID=key.nextLine();
        String getRoom=vms.findParticipantBreakoutRoom(partID);
        if(getRoom==null){
            System.out.println(partID + " not found.");
        }
        else{
            System.out.println(partID + " found in " + getRoom);
        }
        
        System.out.println("\n");
        System.out.println("All break out rooms");
        list=vms.listAllBreakoutRooms();
        System.out.println(list);
        
        System.out.println("\n");
        System.out.println("All Participants in the BreakoutRooms allocated in " + code);
        list=vms.listParticipantsInAllBreakoutRooms();
        System.out.println(list);
    }
}
