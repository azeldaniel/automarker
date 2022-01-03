package out.Xern_Mottley_657730_assignsubmission_file_;//816019358
public class VirtualRunner
{
    public static void main(String[] args){
        VirtualMeetingSystem VMS= new VirtualMeetingSystem();
        VMS.createVirtualRoom("Workshop");
        VMS.loadParticipantData("participant.dat");
        VMS.allocateParticipants("C5");
        VMS.addParticipant("84528887", 5);        
        /*System.out.println(VMS.closeBreakoutRoom(3));
        System.out.println(VMS.openBreakoutRoom(3));
        System.out.println(VMS.findParticipantBreakoutRoom("81601935"));
        System.out.println(VMS.listAllBreakoutRooms());
        System.out.println(VMS.listParticipantsInAllBreakoutRooms());
       */
    }
}
