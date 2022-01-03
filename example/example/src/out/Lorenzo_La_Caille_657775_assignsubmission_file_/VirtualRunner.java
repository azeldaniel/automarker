package out.Lorenzo_La_Caille_657775_assignsubmission_file_;//816015560
import java.util.Random;
import java.util.Scanner;
public class VirtualRunner
{
 
    public static void main(String[] args)
    {
        VirtualMeetingSystem virtualMeetingSystem=new VirtualMeetingSystem();
        
        virtualMeetingSystem.loadParticipantData("participant.dat");
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter VR name");
        String name = keyboard.nextLine();
        virtualMeetingSystem.createVirtualRoom(name);
        
        
        System.out.println("Enter VR code");
        String code = keyboard.nextLine();
        virtualMeetingSystem.allocateParticipants(code);
        
        System.out.println("Enter participant ID and room number");
        String participantID = keyboard.nextLine();
        int roomNumber = keyboard.nextInt();
        virtualMeetingSystem.addParticipant(participantID,roomNumber);
        
        System.out.println("Enter room number");
        roomNumber = keyboard.nextInt();
        String list=virtualMeetingSystem.listParticipants(roomNumber);
        System.out.println(list);
        
        System.out.println("Enter room number");
        roomNumber = keyboard.nextInt();
        virtualMeetingSystem.openBreakoutRoom(roomNumber);
        
        System.out.println("Enter room number");
        roomNumber = keyboard.nextInt();
        virtualMeetingSystem.closeBreakoutRoom(roomNumber);
        
        System.out.println("Enter participant ID ");
        participantID = keyboard.nextLine();
        list=virtualMeetingSystem.findParticipantBreakoutRoom(participantID);
        System.out.println(list);
        
        list=virtualMeetingSystem.listAllBreakoutRooms();
        System.out.println(list);
        
        list=virtualMeetingSystem.listParticipantsInAllBreakoutRooms();
        System.out.println(list);
        
        
    }

    
}
