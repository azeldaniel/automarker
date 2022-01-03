package out.Darion_Ramrattan_657833_assignsubmission_file_;import java.util.Scanner;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (816018746)
 * @version (a version number or a date)
 */
public class VirtualRunner
{
    
    
    
    // instance variables - replace the example below with your own
    public static void main (String[] args){
    String op5=""; 
    String op8=""; 
    String op9="";
    String op10=""; 
    String name = "participant.dat"; 
    String roomname="VirtualRoom";   
    VirtualMeetingSystem vms1 = new VirtualMeetingSystem(); 
   
    //1 
     System.out.println("1. Load Participants");
    vms1.loadParticipantData(name);     
 
    //2
    System.out.println("2. Create VirtualRoom");
    vms1.createVirtualRoom(roomname); 
    
    //3
    System.out.println("3. Allocate Participants");
    vms1.allocateParticipants(roomname);
    //4
    
   
    System.out.println("4.Add Participants");
    vms1.addParticipant("00000001", 1); 
    
    //5
 
    op5= vms1.listParticipants(1); 
    System.out.println("5. List Participants \n" + op5);

    //6

    vms1. closeBreakoutRoom(1); 


    //7

  
    vms1.openBreakoutRoom(1); 

    //8 
    vms1.addParticipant("00000001", 1); 
    op5= vms1.listParticipants(1); 
    System.out.println("5.part 2 List Participants \n" + op5);
    
    op8=vms1.findParticipantBreakoutRoom("11905916"); 
    System.out.println("8. Find Participant \n" + op8);

    //9 
    op9= vms1.listAllBreakoutRooms(); 
    System.out.println("9. List all Breakout Rooms \n " + op9);

    //10
    op10=vms1.listParticipantsInAllBreakoutRooms(); 
    System.out.println("10. List all Participants \n " + op10);

}
}