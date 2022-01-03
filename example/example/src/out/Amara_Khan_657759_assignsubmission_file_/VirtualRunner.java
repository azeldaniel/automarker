package out.Amara_Khan_657759_assignsubmission_file_;//816004460

public class VirtualRunner
{
    
    public static void main(String[] args){
        VirtualMeetingSystem VMS = new VirtualMeetingSystem();
        
        VMS.loadParticipantData("participant.dat");

        
        VMS.createVirtualRoom("Conferance");
        
        
        VMS.allocateParticipants("C5");
       
       
       System.out.println("All participants in the Conference: " +VMS.listParticipants(3)); 
          
       
       System.out.println(VMS.findParticipantBreakoutRoom("99880522"));
       System.out.println("");
       
       System.out.println(VMS.listAllBreakoutRooms());
       
       System.out.println(VMS.listParticipantsInAllBreakoutRooms());
           
       
       VMS.closeBreakoutRoom(1);
       System.out.println(VMS.listAllBreakoutRooms());
       
       
       VMS.openBreakoutRoom(1);
       System.out.println(VMS.listAllBreakoutRooms());
       
       
       
        System.out.println("Adding 12345678 to a breakout room..........");
        if(VMS.addParticipant("12345678",1)){
        System.out.println("Added Successfully");
        }
        else
        System.out.println("Did not add");
        
       
    }
}