package out.Isaiah_Norcisse_657783_assignsubmission_file_;//Student ID : 816016804
// COMP 2603 A1
import java.util.Scanner; 

public class VirtualRunner
{
    public static void main(String args[]) {
        String s="";
        Scanner scan = new Scanner(System.in);
        
        VirtualMeetingSystem vms= new VirtualMeetingSystem();
        vms.loadParticipantData("participant.dat");
        vms.createVirtualRoom("VirtualRoom");
        System.out.println("Enter Code to Allocate Participants: ");
        s=scan.nextLine();
        vms.allocateParticipants(s);
        vms.addParticipant("12345678",4);
        System.out.println("Participants in Room N0. : ");
        vms.listParticipants(4);
        vms.vr.listParticipantsInBreakoutRoom(4);
        vms.closeBreakoutRoom(4);
        vms.openBreakoutRoom(4);
        vms.findParticipantBreakoutRoom("84528887");
        vms.listAllBreakoutRooms();
        vms.listParticipantsInAllBreakoutRoom();
        
    }

    
}
