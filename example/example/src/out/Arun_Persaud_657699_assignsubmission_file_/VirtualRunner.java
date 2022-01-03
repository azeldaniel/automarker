package out.Arun_Persaud_657699_assignsubmission_file_;//Arun Persaud 816019788
import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 
    
  public  class VirtualRunner{ 
      public static void main(String[] args) throws FileNotFoundException{
          VirtualMeetingSystem vms = new VirtualMeetingSystem("Workshop");
          
          vms.loadParticipantData("participant.dat");
           
          vms.createVirtualRoom("Workshop");
          
          vms.allocateParticipants("C5");
         
          vms.addParticipant("20003010",1);
          
          System.out.println("num1 ");
          System.out.println(vms.listParticipants(1));
          
          vms.closeBreakoutRoom(5);
          
          vms.openBreakoutRoom(3);
          
          System.out.println("Participant BreakoutRoom:" + vms.findParticipantBreakoutRoom("84528887"));
          System.out.println();
          System.out.println(vms.listAllBreakoutRooms());
          //System.out.println(vms.listPariticipantsInAllBreakoutRooms());
          
          
          
      } 
 }
