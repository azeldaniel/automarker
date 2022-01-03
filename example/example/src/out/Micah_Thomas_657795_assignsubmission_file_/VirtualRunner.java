package out.Micah_Thomas_657795_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class VirtualRunner
{
    // instance variables - replace the example below with your own
    private VirtualMeetingSystem virtualMeetingSystem;
    private String participantID;

    /**
     * Constructor for objects of class VirtualRunner
     */
    public VirtualRunner(){
        VirtualMeetingSystem virtualMeetingSystem= new VirtualMeetingSystem();
        String participantID= new String();
        int roomNumber=0;
        // initialise instance variables
        virtualMeetingSystem.loadParticipantData("participant.dat");
        virtualMeetingSystem.createVirtualRoom("Workshop");
        virtualMeetingSystem.allocateParticipants("C5");
        System.out.println(virtualMeetingSystem.addParticipant(participantID,roomNumber));
        System.out.println(virtualMeetingSystem.listParticipants(roomNumber));
        System.out.println(virtualMeetingSystem.openBreakoutRoom(roomNumber));
        System.out.println(virtualMeetingSystem.closeBreakoutRoom(roomNumber));
        System.out.println(virtualMeetingSystem.findParticipantBreakoutRoom(participantID));
        System.out.println(virtualMeetingSystem.listAllBreakoutRooms());
        System.out.println(virtualMeetingSystem.listParticipantsInAllBreakoutRooms());
    }
    

    
    
}
