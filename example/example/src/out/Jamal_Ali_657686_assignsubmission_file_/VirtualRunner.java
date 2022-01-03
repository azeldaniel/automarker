package out.Jamal_Ali_657686_assignsubmission_file_;
/**
 * Runner for the code
 * @author (Jamal Ali)
 * @ID (816014616)
 */
public class VirtualRunner
{

    /**
     * Runner for the Program
     */
    public static void main(String[] args) {
        VirtualMeetingSystem NotZoom = new VirtualMeetingSystem(); 
        NotZoom.createVirtualRoom("Room");
        NotZoom.loadParticipantData("participant.dat");
        NotZoom.allocateParticipants("c5");
        NotZoom.addParticipant("65788221",3);
        System.out.println(NotZoom.listParticipants(3));
        System.out.println(NotZoom.findParticipantBreakoutRoom("84528887"));
        System.out.println(NotZoom.listAllBreakoutRooms());
        System.out.println(NotZoom.listParticipantsInAllBreakoutRooms());
        NotZoom.closeBreakoutRoom(1);
        NotZoom.openBreakoutRoom(1);
        System.out.println(NotZoom.listAllBreakoutRooms());
    }
}
