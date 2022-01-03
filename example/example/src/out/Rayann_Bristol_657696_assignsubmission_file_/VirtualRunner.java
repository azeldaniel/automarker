package out.Rayann_Bristol_657696_assignsubmission_file_;
/**
 * Rayann Bristol
 * 816013958
 */
public class VirtualRunner
{
    public static void main(String[] args){
        
         VirtualMeetingSystem virtualMeetingSystem = new VirtualMeetingSystem();
         
         virtualMeetingSystem.loadParticipantData("participant.dat");
         virtualMeetingSystem.createVirtualRoom("Happiness");
         virtualMeetingSystem.allocateParticipants("C5");
         virtualMeetingSystem.addParticipant("72638293",3);
         
         System.out.println(virtualMeetingSystem.listParticipants(2).toString());
         
         virtualMeetingSystem.openBreakoutRoom(1);
         virtualMeetingSystem.closeBreakoutRoom(5);
         
         virtualMeetingSystem.openBreakoutRoom(1);
        
         System.out.println(virtualMeetingSystem.findParticipantBreakoutRoom("12345678").toString());
         
         System.out.println(virtualMeetingSystem.listAllBreakoutRooms().toString());
         
         System.out.println(virtualMeetingSystem.listParticipantsInAllBreakoutRooms().toString());
         
         
    }
}
        

