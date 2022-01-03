package out.Celeste_Seegobin_657667_assignsubmission_file_;//Celeste Seegobin - 816019646
import java.util.Scanner;
import java.io.*;
public class VirtualRunner{
    
    public static void main(String [] args){
        VirtualMeetingSystem VM = new VirtualMeetingSystem();
        VM.loadParticipant("participant.dat");
        System.out.println("Participant Data");
        
        VM.createVirtualRoom("Workshops");
        
        VM.allocateParticipants("C5");
        
        VM.addParticipant("Add Participants", 1);
        
        System.out.println("List Participants");
        VM.listParticipant(1);
        
        System.out.println("List All Breakout Rooms");
        VM.listAllBreakoutRoom();
        
        System.out.println("List All Participants");
        VM.listParticipantAllBreakoutRooms();
        
        
        
        
 
    }
}