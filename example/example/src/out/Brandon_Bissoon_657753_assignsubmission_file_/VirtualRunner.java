package out.Brandon_Bissoon_657753_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRunner
{
    public static void main(String[] args){
        String filename = "participant.dat";
        
        VirtualMeetingSystem system = new VirtualMeetingSystem();
        
        system.loadParticipantData(filename);
        system.createVirtualRoom(" Workshop ");
        system.allocateParticipants("C5");
        
        system.addParticipant("12345678",5);
        
        system.openBreakoutRoom(2);
        system.closeBreakoutRoom(2);
        
        System.out.println(system.listParticipants(5));
        System.out.println(system.findParticipantBreakoutRoom("95709651"));
        System.out.println(system.listAllBreakoutRooms());
        System.out.println(system.listParticipantsInAllBreakoutRooms());
    }
}
