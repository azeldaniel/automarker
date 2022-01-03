package out.Amelia_Lalla_657844_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRunner
{
    public static void main(String[] args){
        VirtualMeetingSystem VMS = new VirtualMeetingSystem();
        VMS.loadParticipantData("participant.dat");
        
        VMS.createVirtualRoom("Workshop");
       
        VMS.allocateParticipants("C5");
        
        System.out.println(VMS.listParticipantsInAllBreakoutRooms() + "\n");
      
        //System.out.println(VMS.listAllBreakoutRooms()+ "\n");
        //System.out.println(VMS.listParticipants(2)+"\n");
        VMS.closeBreakoutRoom(4);
        //System.out.println(VMS.listParticipantsInAllBreakoutRooms() +"\n");
        VMS.openBreakoutRoom(4);
        System.out.println(VMS.listParticipantsInAllBreakoutRooms()+"\n");
        VMS.addParticipant("12345678",4);
        System.out.println(VMS.listParticipantsInAllBreakoutRooms()+"\n");
        //System.out.println(VMS.findParticipantBreakoutRoom("12345678"));
    }
}
