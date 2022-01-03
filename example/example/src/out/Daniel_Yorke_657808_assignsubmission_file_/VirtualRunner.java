package out.Daniel_Yorke_657808_assignsubmission_file_;
/**
 * 816019400
 */
public class VirtualRunner
{
    public static void main(String[] args){
        VirtualMeetingSystem vs = new VirtualMeetingSystem();
        vs.createVirtualRoom("Workshop");
        vs.loadParticipantData("participant.dat");
        vs.allocateParticipants("C5");
        System.out.println(vs.listParticipantsInAllBreakoutRooms());
        
    }
}
