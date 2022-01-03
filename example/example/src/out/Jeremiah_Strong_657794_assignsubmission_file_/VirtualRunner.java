package out.Jeremiah_Strong_657794_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (Jeremiah Strong)
 * @ID: 816023620
 */
public class VirtualRunner
{
    // instance variables - replace the example below with your own
    
    public static void main(String[] args)
    {
        String filename= "Participant.dat";
        VirtualMeetingSystem VMS= new VirtualMeetingSystem();
        
        System.out.println("Loading All Participants...");
        VMS.loadParticipantData(filename);
        
        VMS.createVirtualRoom("Workshop");
        
        System.out.println();
        String allBreakoutRooms= VMS.listAllBreakoutRooms( ); 
        System.out.println(allBreakoutRooms);
        
        System.out.println();
        VMS.openBreakoutRoom(1);
        
       System.out.println("Checking breakoutRooms for participants: before adding \n");
        String allRoomParticipants= VMS.listParticipantsInAllBreakoutRooms();
        System.out.println(allRoomParticipants);
       
        System.out.println("\nINVALID ID Test: \n");
        boolean check = VMS.addParticipant ("abcdefgh", 1); //Invalid ID test
        //check = VMS.addParticipant ("36892964", 1);
        //check = VMS.addParticipant ("32687155", 4);
        
        
        VMS.allocateParticipants("RR");
       // check = VMS.addParticipant ("36892964", 1);
       // check = VMS.addParticipant ("32687155", 4);
       // check = VMS.addParticipant ("12345678", 5);
        allRoomParticipants= VMS.listParticipantsInAllBreakoutRooms();
         
        System.out.println("\nChecking breakoutRooms for participants: AFTER adding\n");
        System.out.println(allRoomParticipants);
        
        String id= "12345678";
        String roomName= VMS.findParticipantBreakoutRoom(id);
        if(roomName==null)
            System.out.println(id + " does not exist in any breakout rooms.");
        
        else
            System.out.println(id + "was found in " + roomName);
        
        id= "1232323";  //Invalid Id test
        roomName= VMS.findParticipantBreakoutRoom(id);
        if(roomName==null)
            System.out.println(id + " does not exist in any breakout rooms.");
        
        else
            System.out.println(id + "was found in " + roomName);
       
        
        id= "32687155";  //Invalid Id test
        roomName= VMS.findParticipantBreakoutRoom(id);
        if(roomName==null)
            System.out.println(id + " does not exist in any breakout rooms.");
        
        else
            System.out.println(id + "was found in " + roomName);
            
            
        boolean check2 = VMS.closeBreakoutRoom(1);  
        check2 = VMS.closeBreakoutRoom(2);  
        check2 = VMS.closeBreakoutRoom(5);   
        
        //Tries adding participant ot a close room
        boolean check3 = VMS.addParticipant ("36892964", 1);
        check2 = VMS.openBreakoutRoom(1);  
        //adds to open room
        check3 = VMS.addParticipant ("36892964", 1);
        check3 = VMS.addParticipant ("36892964", 1);  //DUplicate test
        check3 = VMS.addParticipant ("36892933", 1);
        
        String info= VMS.listParticipants(1);
        System.out.println(info);
           
    }

    
}
