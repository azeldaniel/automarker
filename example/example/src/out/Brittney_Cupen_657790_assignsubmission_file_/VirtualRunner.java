package out.Brittney_Cupen_657790_assignsubmission_file_;//Brittney Cupen 816022438
import java.io.FileNotFoundException;
public class VirtualRunner
{
    public static void main(String[] args) throws FileNotFoundException{
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        vms.loadParticipantData("participant.dat");
        vms.createVirtualRoom("Lecture");
        
        vms.addParticipant("84528881", 3);
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
        
        vms.allocateParticipants("RR");
        
        vms.closeBreakoutRoom(3);
        System.out.println(vms.listAllBreakoutRooms());
        
        vms.openBreakoutRoom(3);
        System.out.println(vms.listAllBreakoutRooms());
        
        System.out.println(vms.findParticipantBreakoutRoom("84528887"));
        System.out.println(vms.listAllBreakoutRooms());
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
    }
}
