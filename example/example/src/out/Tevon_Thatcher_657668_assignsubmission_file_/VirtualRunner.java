package out.Tevon_Thatcher_657668_assignsubmission_file_;/**
 * @Tevon Thatcher - 816019492
 */

public class VirtualRunner
{
    
    public static void main(String[] args){
        VirtualMeetingSystem newMeeting = new VirtualMeetingSystem();
        
        newMeeting.addParticipant("95916883",1);
        
        newMeeting.createVirtualRoom("VirtualRoom");
        
        newMeeting.loadParticipantData("participant.dat");
        
        newMeeting.allocateParticipants("C5");
        
        System.out.println(newMeeting.listAllBreakoutRooms());

        System.out.println("Done..");
    }
}
