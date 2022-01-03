package out.Cleopatra_Arrindell___Walker_657673_assignsubmission_file_;import java.io.IOException;
import java.util.Scanner;
import java.io.File;
/**
 * @author (813001054)
 */
public class VirtualRunner
{
 
    
    public static void main(String[] args)throws IOException{
        VirtualMeetingSystem v = new VirtualMeetingSystem();
       
        v.loadParticipantData("src/test/resources/participant.dat");
        v.createVirtualRoom("Virtual Room");
        v.allocateParticipants("1");
        v.addParticipant("00000001", 1);
        System.out.println(v.listParticipants(1));
        System.out.println( v.closeBreakoutRoom(1));
        v.openBreakoutRoom(1);
        System.out.println( v.findParticipantBreakoutRoom("00000001"));
        System.out.println(v.listAllBreakoutRooms());
        System.out.println(v.listParticipantsInAllBreakoutRooms().toString());
        
       
        
       
        
        
    }  
      
}
