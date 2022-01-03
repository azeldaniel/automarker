package out.Danielle_Charles_657700_assignsubmission_file_;
/**
 * @author Danielle Charles 816017229
 */

public class VirtualRunner
{
    public static void main(String[] arg)
    {
        VirtualMeetingSystem virtualMeetingSystem = new VirtualMeetingSystem();
        
        virtualMeetingSystem.loadParticipantData("participant.dat");
       
        virtualMeetingSystem.createVirtualRoom("HELLO");
     
        virtualMeetingSystem.openBreakoutRoom(1);
    
        virtualMeetingSystem.openBreakoutRoom(2);
     
        virtualMeetingSystem.openBreakoutRoom(3);
       
        virtualMeetingSystem.openBreakoutRoom(4);

        virtualMeetingSystem.openBreakoutRoom(5);
        
        virtualMeetingSystem.allocateParticipants("C5");
        //virtualMeetingSystem.allocateParticipants("RR");
        
        System.out.println(virtualMeetingSystem.addParticipant("81601722", 5));
        
        System.out.println(virtualMeetingSystem.listParticipants(1));        
        System.out.println(virtualMeetingSystem.listParticipants(2));
        System.out.println(virtualMeetingSystem.listParticipants(3));
        System.out.println(virtualMeetingSystem.listParticipants(4));
        System.out.println(virtualMeetingSystem.listParticipants(5));
        
        System.out.println(virtualMeetingSystem.findParticipantBreakoutRoom("22927494"));
        System.out.println(virtualMeetingSystem.findParticipantBreakoutRoom("78094192"));
        
        //virtualMeetingSystem.closeBreakoutRoom(1);
        //virtualMeetingSystem.closeBreakoutRoom(2);
        //virtualMeetingSystem.closeBreakoutRoom(3);
        //virtualMeetingSystem.closeBreakoutRoom(4);
        //virtualMeetingSystem.closeBreakoutRoom(5);
        
        System.out.println(virtualMeetingSystem.listAllBreakoutRooms());
        
        System.out.println(virtualMeetingSystem.listParticipantsInAllBreakoutRooms());
        
    }
}
