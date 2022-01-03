package out.Brandon_Noray_657718_assignsubmission_file_;import java.io.*;
import java.util.*;
/**
* Write a description of class VirtualRunner here.
*
* @author (816018360 | Brandon Noray)
* @version (v1.6.9)
*/
public class VirtualRunner
{
    
    public static void main(String[] args)
    {
        //test
        String tag = "[SYSTEM]: ";
        System.out.println(tag + "Started");//Starting
        VirtualMeetingSystem system = new VirtualMeetingSystem();
        system.loadParticipantData("participant.dat");
        system.createVirtualRoom("Workshop");
        System.out.println(tag + "Virtual Room Created");
        
        System.out.println(tag + "Listing all breakout rooms");
        System.out.println(system.listAllBreakoutRooms());
        
        System.out.println(tag + "Opening all breakout rooms");
        for(int i=1; i<=5; i++)
            system.openBreakoutRoom(i);
        System.out.println("");
        
        System.out.println(tag + "Allocating participants to breakout rooms");
        String code = "RR";
        system.allocateParticipants(code);
        System.out.println("Participants where allocated with Code: " + code);
        System.out.println("");
        
        System.out.println(tag + "Listing participants in all breakout rooms");
        System.out.println(system.listParticipantsInAllBreakoutRooms());
        
        System.out.println(tag + "Testing search function");
        System.out.println("Searching for random Participant's Breakout Room");
        Random randNum = new Random(); //Random number for search
        String id = system.id[randNum.nextInt(system.id.length)];
        System.out.println("Looking for Participant ID: " + id);
        String room = system.findParticipantBreakoutRoom(id);
        if(room == null) System.out.println("Participant not found");
        else System.out.println("Participant found in " + room);
        System.out.println("");
        
        System.out.println(tag + "Closing all breakout rooms");
        for(int i=1; i<=5; i++)
            system.closeBreakoutRoom(i);
        System.out.println("");
            
        System.out.println(tag + "Re-Listing participants in all breakout rooms now that they were closed");
        System.out.println(system.listParticipantsInAllBreakoutRooms());
        System.out.println("");
        
        System.out.println(tag + "Finished");//Closing
        
    } 

}
