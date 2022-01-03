package out.Terrel_Charles_657846_assignsubmission_file_;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRunner
{
    
     public static void main(String[] args)throws Exception {
        /*
         int op=0;
         do{
            
            if(op==1){
            VirtualMeetingSystem vms = new VirtualMeetingSystem();
            vms.loadParticipantData("/Users/charl/Downloads/participant.dat");
            }
            else if(op==2){
            vms.createVirtualRoom("Room");
            }
            
            else if(op==3){
            vms.allocateParticipants(
            }
            
            
            }
         
         
         */
        
         VirtualMeetingSystem vms = new VirtualMeetingSystem();
        vms.loadParticipantData("/Users/charl/Downloads/participant.dat");
          vms.createVirtualRoom("Room");
           vms.allocateParticipants("RR");
          //System.out.println("Listing all participants: "+vms.listParticipants(0));
       System.out.println("\n");
        System.out.println("Listing Rooms: ");
        System.out.println(vms.listAllBreakoutRooms());
        System.out.println("\n");
        System.out.println("Listing All Participants: ");
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
        
        

    }
}