package out.Satash_Rampersad_657829_assignsubmission_file_;
/**
 * 816020134
 */
public class VirtualRunner{
    public static void main(String[] args){
        String filename = "participant.dat"; 
        
        VirtualMeetingSystem vMSystem = new VirtualMeetingSystem();
        vMSystem.loadParticipantData(filename);
        vMSystem.createVirtualRoom("Seminar");
        
        vMSystem.allocateParticipants("C5");
        vMSystem.addParticipant("82391732", 1);
        System.out.println(vMSystem.listParticipants(1));
                vMSystem.closeBreakoutRoom(1);
                vMSystem.openBreakoutRoom(1);
                System.out.println(vMSystem.findParticipantBreakoutRoom("73978883"));
                System.out.println(vMSystem.listAllBreakoutRooms());
                System.out.println(vMSystem.listParticipantsInAllBreakoutRooms());


    }
}
