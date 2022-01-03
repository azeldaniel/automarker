package out.Tamia___Ashley_Tuitt_657761_assignsubmission_file_;/**
 * Student ID: 816021561
 */
import java.util.Scanner;
import java.lang.*;

public class VirtualRunner
{
    public static void main(String[] args){
    
        VirtualMeetingSystem VMS = new VirtualMeetingSystem();
        //1
        System.out.println("Enter filename: ");
        Scanner screen=new Scanner(System.in);
        String filename=screen.nextLine();
        System.out.println("1.Loading Participant data from paricipant.dat");
        try{
        VMS.loadParticipantData(filename);
        }
        catch(Exception e){}
        
        System.out.println("Enter Integer Choice From Below:");
        System.out.println("2.Create a new Virtual Room:");
        System.out.println("3.Allocate Participants to Breakout Rooms:");
        System.out.println("4.Add a New Participant to a Breakout Room");
        System.out.println("5.Display a list of all Participants in a Breakout Room");
        System.out.println("6.Close a Breakout Room based on a room Number");
        System.out.println("7.Open a Breakout Room based on a room Number");
        System.out.println("8.Find a participant’s breakout room number");
        System.out.println("9.Display a list of all breakout rooms managed by the system"); 
        System.out.println("10.Display a list of all breakout rooms managed by the system and the participants in each room");
        System.out.println("0.Exit:");
        int choice = screen.nextInt();
        screen.nextLine();
        int roomNumber; 
        String pID;
        
    while(choice!=0){
        //2
        if(choice==2){
        System.out.println("2.Create a new Virtual Room:");
        System.out.println("Enter Virtual Room Name");
        String VRName = screen.nextLine();
        VMS.createVirtualRoom(VRName);
       }
        
        //3
        if(choice==3){
        System.out.println("3.Allocate Participants to Breakout Rooms:");
        System.out.println("Enter Code to Allocate Participants");
        String code = screen.nextLine();
        VMS.allocateParticipants(code);
        System.out.println(VMS.listAllBreakoutRooms());
        System.out.println(VMS.listParticipantsInAllBreakoutRooms());
       }
        //4
       if(choice==4){
        System.out.println("Add a New Participant to a Breakout Room");
        System.out.println("Enter Participant ID to add");
        pID = screen.nextLine();
        System.out.println("Enter Breakout Room Number");
        roomNumber = screen.nextInt();
        screen.nextLine();
        if(VMS.addParticipant(pID,roomNumber)==false){
        System.out.println("Error Adding Participant");
        System.out.println("Possible Errors Include: ");
        System.out.println("-Breakout Room Full");
        System.out.println("-Duplicate Participant ID");
        System.out.println("-Invalid Participant ID");
        System.out.println("-Breakout Room Closed");
        }
       }
        //5
       if(choice==5){
        System.out.println("Display a list of all Participants in a Breakout Room");
        System.out.println("Enter Breakout Room Number");
        roomNumber = screen.nextInt();
        screen.nextLine();
        System.out.println(VMS.listParticipants(roomNumber));
       }
        //6
       if(choice==6){
        System.out.println("Close a Breakout Room based on a room Number");
        System.out.println("Enter Breakout Room Number");
        roomNumber = screen.nextInt();
        screen.nextLine();
        VMS.closeBreakoutRoom(roomNumber);
       } 
        //7
       if(choice==7){
        System.out.println("Open a Breakout Room based on a room Number");
        System.out.println("Enter Breakout Room Number");
        roomNumber = screen.nextInt();
        screen.nextLine();
        VMS.openBreakoutRoom(roomNumber);
       }
        //8
       if(choice==8){
        System.out.println("Find a participant’s breakout room number");
        System.out.println("Enter Participant ID to find");
        pID = screen.nextLine();
        System.out.println("Participant is in " +VMS.findParticipantBreakoutRoom(pID));
       } 
        //9
       if(choice==9){
        System.out.println("Display a list of all breakout rooms managed by the system");
        System.out.println(VMS.listAllBreakoutRooms());
       }
        //10
       if(choice==10){
        System.out.println("Display a list of all breakout rooms managed by the system and the participants in each room");
        System.out.println(VMS.listParticipantsInAllBreakoutRooms());
       
       }
       
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Enter Integer Choice From Below:");
        System.out.println("2.Create a new Virtual Room:");
        System.out.println("3.Allocate Participants to Breakout Rooms:");
        System.out.println("4.Add a New Participant to a Breakout Room");
        System.out.println("5.Display a list of all Participants in a Breakout Room");
        System.out.println("6.Close a Breakout Room based on a room Number");
        System.out.println("7.Open a Breakout Room based on a room Number");
        System.out.println("8.Find a participant’s breakout room number");
        System.out.println("9.Display a list of all breakout rooms managed by the system"); 
        System.out.println("10.Display a list of all breakout rooms managed by the system and the participants in each room");
        System.out.println("0.Exit:");
        System.out.println("------------------------------------------------------------------------------------------------");
        choice = screen.nextInt();
        screen.nextLine();
     }
        
      System.exit(0);
    }
}
