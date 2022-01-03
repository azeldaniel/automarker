package out.Kc_Mentor___Alexis_657777_assignsubmission_file_;//816018833
public class VirtualRunner
{   
    public static void main(String args[]){
      
      VirtualMeetingSystem VMS= new VirtualMeetingSystem();
      
      //Load Participants
      VMS.loadParticipantData("participant.dat");
      System.out.println("loadParticipantData: Sucessfully loaded data from file \n");
      
      //Create Virtual Rooms with name
      VMS.createVirtualRoom("Longue");
      System.out.println("createVirtualRoom: Sucessfully created virtually rooms with name hardcoded \n");
      
      //Allocate participants to breakout rooms using code C5 or RR(hardcoded))
      VMS.allocateParticipants("C5");
      System.out.println("allocateParticipants: Sucesfully allocated participants using hardcoded method C5 or RR...change accordingly in VirtrualRunner Class \n");
      
      //Adds participant to breakout room (variables passed in hardcoded)
      System.out.println("addParticipant: Beginning test to add participant to breakoutRoom variables hardcode by user - ID,Room number \n");
      if(VMS.addParticipant("12345678",1) == true){
          System.out.println("Addded Sucessfully");
      }
      else
      System.out.println("Fail to add \n");
      System.out.println("addParticipant: Test Finished \n");
     
     //Test to ensure participants in selected breakout room is printed variables passed are hardcoded in Virtual Runner
     System.out.println("listParticipants: Test commencing to list participant in selected breakoutRoom \n");
     System.out.println(VMS.listParticipants(1));
     System.out.println("listParticipants: Test Finished \n");
     
     //Test to find participant in virtualroom.
     System.out.println("findParticipantBreakoutRoom: Test commencing to find participant \n");
     String found =VMS.findParticipantBreakoutRoom("99804103");
     if(found != null){
         System.out.println("Found: " + found);
     }
     else
        System.out.println("Not found");
     System.out.println("findParticipantBreakoutRoom: Test Finished \n");   
        
     //test to ensure room can be closed
     System.out.println("closeBreakoutRoom: Test commencing to close breakout room \n");
     if(VMS.closeBreakoutRoom(5)){
         System.out.println("Closed Sucessfully");
     }
     else
        System.out.println("Failed to Closed");
        
     System.out.println("closeBreakoutRoom: Test Finished \n");   
     
     //test to ensure room can be opened; if it prints below that room number (number hardcoded)  is open but has 0 participant test success!
     System.out.println("openBreakoutRoom: Test commencing to open breakout room \n");
     if(VMS.openBreakoutRoom(5)){
         System.out.println("Open Sucessfully");
     }
     else
        System.out.println("Failed to Open");
     System.out.println("openBreakoutRoom: Test Finished \n");
     
     //test to list all breakout rooms;
     System.out.println("listAllBreakoutRooms: Test commencing to list all breakout rooms\n");
     System.out.println("---Listing all Breakout Rooms---");
     String breakOutRooms = VMS.listAllBreakoutRooms();
     System.out.println(breakOutRooms);
     System.out.println("listAllBreakoutRooms: Test Finished \n");
     
     System.out.println("listParticipantsInAllBreakoutRooms: Test commencing to list all participants in each breakout room \n");
     System.out.println("---Listing all participants in each breakout room---\n");
     System.out.println(VMS.listParticipantsInAllBreakoutRooms());
     System.out.println("listParticipantsInAllBreakoutRooms: Test Finished \n");
    }
    
 
}
  