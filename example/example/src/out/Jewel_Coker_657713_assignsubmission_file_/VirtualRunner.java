package out.Jewel_Coker_657713_assignsubmission_file_;// ID : 816014352

import java.util.Scanner;
import java.util.Random;
public class VirtualRunner
{
    
    public VirtualRunner()
    {
      
    }
    
    public static void main(String[] args){

     String[] allocationCode = {"C5","RR"};
     String[] virtualRoomNames = {"FST Meeting Room","DCIT Room","INFO Meeting","Technology Department Room"};
     String[] participants={"98462","3265435","1092397879"};
     int[] breakoutRooms={1,2,3,4,5};
     Random r1 = new Random();
     Random r2 = new Random();
     Random r3 = new Random ();
     Random r4 = new Random ();
     int codeGenerated = r1.nextInt(2);
     int nameGenerated= r2.nextInt(4);
     int participantGenerated = r3.nextInt(3);
     int roomGenerated = r4.nextInt(5);
     
    VirtualMeetingSystem virtualMeetingSystem = new VirtualMeetingSystem();
    virtualMeetingSystem.loadParticipantData("participant.dat");
       
    
     virtualMeetingSystem.createVirtualRoom(virtualRoomNames[nameGenerated]);
     virtualMeetingSystem.allocateParticipants(allocationCode[codeGenerated]);
     virtualMeetingSystem.addParticipant(participants[participantGenerated],1); // random participant added to room 1
    
     
    virtualMeetingSystem.listParticipants(breakoutRooms[roomGenerated]);
    virtualMeetingSystem.closeBreakoutRoom(breakoutRooms[roomGenerated]);
    virtualMeetingSystem.openBreakoutRoom(breakoutRooms[roomGenerated]);
    virtualMeetingSystem.findParticipantBreakoutRoom("17996398");
    System.out.println(virtualMeetingSystem.listAllBreakoutRooms());
    System.out.println(virtualMeetingSystem.listParticipantsInAllBreakoutRooms());
}
    
   
}
