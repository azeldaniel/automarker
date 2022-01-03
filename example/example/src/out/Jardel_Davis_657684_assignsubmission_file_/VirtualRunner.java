package out.Jardel_Davis_657684_assignsubmission_file_;
//816017045
import java.util.*;
public class VirtualRunner
{
    public static void main(String arg[]){
        VirtualMeetingSystem system = new VirtualMeetingSystem();
        
        system.loadParticipantData("participant.dat");
        system.createVirtualRoom("Comp2603");
        //system.allocateParticipants("C5");
        //System.out.println(system.listParticipantsInAllBreakoutRooms());
        //System.out.println(system.listParticipants(1));
        System.out.println(system.listAllBreakoutRooms());
        //if(system.addParticipant("12345678", 1) == true){
        //    System.out.println("ADDED");
        //}
        //System.out.println(system.findParticipantBreakoutRoom("12345678"));
        //System.out.println(system.closeBreakoutRoom(1));
        //System.out.println(system.openBreakoutRoom(1));
        //if(system.addParticipant("12345678", 1) == true){
        //    System.out.println("ADDED");
        //}else{System.out.println("Fail to add participant");}
        //System.out.println(system.findParticipantBreakoutRoom("12345678"));
        //System.out.println(system.listParticipants(1));
        
        
    }
}
