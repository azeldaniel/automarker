package out.Ishika_Gopie_657680_assignsubmission_file_;
/**
 * StudentID: 816018253
 */
public class VirtualRunner{
    public static void main(String[] args){
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        vms.loadParticipantData("participant.dat");
        vms.createVirtualRoom("Room");
        //vms.allocateParticipants("RR");
       vms.allocateParticipants("C5");
        
        System.out.println(vms.listAllBreakoutRooms());
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
       // System.out.println(vms.findParticipantBreakoutRoom("78606510"));
        //System.out.println(vms.listParticipants(3));
        
       // vms.addParticipant("81601825",4);
       //System.out.println(vms.listParticipantsInAllBreakoutRooms());
       
         //vms.openBreakoutRoom(2);
        //vms.openBreakoutRoom(4);
        //System.out.println(vms.listAllBreakoutRooms());
        
        //vms.closeBreakoutRoom(2);
        //System.out.println(vms.listAllBreakoutRooms());
        
        
        
    }
}
