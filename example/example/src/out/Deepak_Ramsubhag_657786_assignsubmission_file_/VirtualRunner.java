package out.Deepak_Ramsubhag_657786_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 Deepak Ramsubhag
 816016482
 */
public class VirtualRunner
{
    public static void main(String[] args) throws FileNotFoundException{
        
        VirtualMeetingSystem virtMeetSys = new VirtualMeetingSystem();
       
        virtMeetSys.loadParticipantData("participant.dat");
        
        virtMeetSys.createVirtualRoom("Lecture");
        
        virtMeetSys.allocateParticipants("C5");
        
        System.out.println(virtMeetSys.listParticipantsInAllBreakoutRooms());
        
        
        System.out.println(virtMeetSys.listParticipants(1) +"\n");
        
        
        System.out.println(virtMeetSys.closeBreakoutRoom(1) + "\n");
        
        
        System.out.println(virtMeetSys.listParticipants(1)+ "\n");
        
        System.out.println(virtMeetSys.openBreakoutRoom(1) + "\n");
        
        virtMeetSys.addParticipant("12345678",1);
        
        virtMeetSys.allocateParticipants("C5");
        
        System.out.println(virtMeetSys.listParticipants(1)+ "\n");
        
        System.out.println(virtMeetSys.findParticipantBreakoutRoom("12345678") + "\n");
        
        System.out.println(virtMeetSys.listAllBreakoutRooms());
        
        

       
    }
}
