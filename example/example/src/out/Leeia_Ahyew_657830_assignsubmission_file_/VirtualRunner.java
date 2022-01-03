package out.Leeia_Ahyew_657830_assignsubmission_file_;//816016640

public class VirtualRunner
{
    
    public static void main(String[] args){
        VirtualMeetingSystem VirtualMeet = new VirtualMeetingSystem();
      
        VirtualMeet.loadParticipantData("participant.dat");

        VirtualMeet.createVirtualRoom("Conferance");
        
       
        VirtualMeet.allocateParticipants("C3");
        
       
    }
}
