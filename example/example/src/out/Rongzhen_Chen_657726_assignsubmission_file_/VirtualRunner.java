package out.Rongzhen_Chen_657726_assignsubmission_file_;//816014227
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class VirtualRunner{
    
    public static void main(String[] args){
        
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        
        vms.loadParticipantData("participant.dat");
        
        vms.createVirtualRoom("Seminar", 10);
        //breakout room limit has to be set to 10 since 
        //there are 50 participants in the dat file and 
        //each room can only hold 5 for the C5 allocation.
        vms.allocateParticipants("C5");
        
        System.out.println(vms.listParticipantsInAllBreakoutRooms());

    }

}
