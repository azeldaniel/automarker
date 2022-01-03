package out.Makaela_Wallace_657818_assignsubmission_file_;/*
 * Name: Makaela Wallace
 * ID: 816018659
*/

import java.util.*; 
import java.io.*;

public class VirtualRunner
{
    
    
    public static void main (String[] args){
        
        //TESTS RAN TO ENSURE ACCURACY
        String fileName = "participant.dat";
        VirtualMeetingSystem meetingSys = new VirtualMeetingSystem();
       
        
       
        meetingSys.loadParticipantData(fileName);
        meetingSys.createVirtualRoom("Lecture");
        
        //meetingSys.test();
        
        System.out.println ("5\n" + meetingSys.listParticipants(1));
        meetingSys.allocateParticipants("RR");
        System.out.println (meetingSys.listAllBreakoutRooms( ));
        meetingSys.addParticipant("12345678", 1);
        System.out.println ("3-4\n" + meetingSys.listParticipantsInAllBreakoutRooms());
        
        System.out.println ("5\n" + meetingSys.listParticipants(1));
        
        meetingSys.closeBreakoutRoom(2);
        meetingSys.openBreakoutRoom(2);
        System.out.println ("3-4\n" + meetingSys.listParticipantsInAllBreakoutRooms());
        
        System.out.println  ("8\n" + meetingSys.findParticipantBreakoutRoom("12345678"));
        meetingSys.listParticipantsInAllBreakoutRooms(); 
        System.out.println ("9-10\n" + meetingSys.listAllBreakoutRooms());
    }
    
    
    
    
}
