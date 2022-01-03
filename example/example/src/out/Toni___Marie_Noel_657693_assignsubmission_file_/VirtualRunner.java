package out.Toni___Marie_Noel_657693_assignsubmission_file_;
/**
 * This runs the entire program
 *
 * @ Toni-Marie Noel- 816017238 
 * @ Jan 30, 2021 
 */


public class VirtualRunner
{
     public static void println(Object line) {
    System.out.println(line);
    }
    
    public static void main(String[] args){
       
        //Virtual Room
        VirtualMeetingSystem virtualMeeting = new VirtualMeetingSystem();
       
        virtualMeeting.loadParticipantData("participant.dat"); 
        virtualMeeting.createVirtualRoom("VR CHAT");
        virtualMeeting.allocateParticipants("RR");
        println(virtualMeeting.listParticipantsInAllBreakoutRooms());
        
       
        
           
           
           
    }
    
        
}
