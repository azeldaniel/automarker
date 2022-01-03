package out.Amrik_Boodoo_657780_assignsubmission_file_;
/**
 * 
 *
 * Amrik Boodoo 816018329
 * 
 */
public class VirtualRunner 
{
    public static void main (String[] args){
       VirtualMeetingSystem VMS= new VirtualMeetingSystem();

       VMS.loadParticipantData("C:\\Users\\amrik\\Desktop\\participant.dat");
       VMS.createVirtualRoom("Workshop");
       VMS.allocateParticipants("c5");
       
       VMS.addParticipant("12345678",1);
       
       
       System.out.println(VMS.listParticipants(1));
       VMS.closeBreakoutRoom(1);
       VMS.openBreakoutRoom(1);
       
       System.out.println("Participant Found in BreakoutRoom: "+VMS.findParticipantBreakoutRoom("24721757"));
       System.out.println("\n");
       System.out.println("Breakout Rooms: \n"+ VMS.listAllBreakoutRooms());
       System.out.println("\n");
       System.out.println(VMS.listParticipantsInAllBreakoutRooms());
       //No participants for wokshop 1 will appear in the above list as Workshop 1 was closed and re-opened
       
   
        
    
    
    }    
}
