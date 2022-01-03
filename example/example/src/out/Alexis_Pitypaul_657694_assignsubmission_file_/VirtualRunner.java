package out.Alexis_Pitypaul_657694_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (Alexis Pitypaul - 816020068)
 * @version (1)
 */
public class VirtualRunner
{
   public static void main(String[] args){
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        vms.loadParticipantData("participant.dat");
        vms.createVirtualRoom("room");
        vms.allocateParticipants("C5");
        System.out.println(vms.addParticipant("12345678", 1));
        System.out.println(vms.listParticipants(1));
        System.out.println(vms.findParticipantBreakoutRoom("12345678"));
        System.out.println(vms.listAllBreakoutRooms());
        System.out.println(vms.listAllParticipantsInallBreakoutRooms());
        
        vms.allocateParticipants("RR");
        System.out.println(vms.addParticipant("12345678", 1));
        System.out.println(vms.listParticipants(1));
        System.out.println(vms.findParticipantBreakoutRoom("12345678"));
        System.out.println(vms.listAllBreakoutRooms());
        System.out.println(vms.listAllParticipantsInallBreakoutRooms());
    }
}
