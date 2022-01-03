package out.Derwin_Jack_657816_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (Derwin Jack 816022295)
 * @version (14/02/2021)
 */
public class VirtualRunner
{
    public static void main(String[] args){
        VirtualMeetingSystem VMS = new VirtualMeetingSystem();
        VMS.loadParticipantData("participant.dat.txt");
        VMS.createVirtualRoom("Tutourial");
        VMS.allocateParticipants("C5");
        //VMS.addParticipant("74966077",3);
        //System.out.println(VMS.listParticipants(0));
        //VMS.closeBreakoutRoom(3);
        //VMS.openBreakoutRoom(3);
        System.out.println(VMS.listAllBreakoutRooms());
        System.out.println("\n list Of All Participants and alocated Rooms");
        System.out.println(VMS.listParticipantsInAllBreakoutRooms());
        System.out.println(VMS.findParticipantBreakoutRoom("95916883"));
        
    }
}
