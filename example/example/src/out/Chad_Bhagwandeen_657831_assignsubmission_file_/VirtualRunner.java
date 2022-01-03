package out.Chad_Bhagwandeen_657831_assignsubmission_file_;//Student ID: 816002273
public class VirtualRunner
{
    VirtualMeetingSystem vMS;
    
    public static void main(String[] args)
    {
        VirtualMeetingSystem vMS= new VirtualMeetingSystem();
        vMS.loadParticipantData("participant.dat");
        vMS.createVirtualRoom("Automotive");
        vMS.allocateParticipant("C5");
        vMS.listAllBreakoutRooms();
        vMS.listParticipantsInAllBreakoutRooms();
    }
    

    
}
