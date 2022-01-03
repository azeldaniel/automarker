package out.Jeremy_De_Freitas_657820_assignsubmission_file_;//816018479
import java.util.Scanner;

public class VirtualRunner
{
    public static void main(String[] args) throws Exception
    {

        VirtualMeetingSystem newVirtualSystem = new VirtualMeetingSystem();
        System.out.println("Please enter the name of the file you want to read from: ");
        Scanner keyboard = new Scanner(System.in);
        newVirtualSystem.loadParticipantData(keyboard.nextLine());


       System.out.println("Please enter the name of the Virtual Room: ");

       newVirtualSystem.createVirtualRoom(keyboard.nextLine());
       System.out.println("\n");
       System.out.println("Virtual Room created!");



       String Default = "C5";//code
       newVirtualSystem.allocateParticipants(Default);
       newVirtualSystem.listParticipantsInAllBreakoutRooms();
       
       System.out.println("Please enter the participant's ID to find their BreakOut Room: ");
       System.out.println(newVirtualSystem.findParticipantBreakoutRoom(keyboard.nextLine()));


       String ID;
       int brID;
       System.out.println("Please enter the participant ID for the participant you'd like to add to the BreakOut Room: ");
       ID = keyboard.nextLine();
       System.out.println("Please enter the BreakOut Room number (0-4) for BreakOut Room that the participant will be added to: ");
       brID = keyboard.nextInt();
       newVirtualSystem.addParticipant(ID, brID);



       System.out.println("Please enter the BreakOut Room number (0-4) to list the participants of that BreakOut Room: ");
       String partlist;
       partlist = newVirtualSystem.listParticipants(keyboard.nextInt());


       
       System.out.println("Please enter the BreakOut Room number you would like to close: ");
       
       if(newVirtualSystem.closeBreakoutRoom(keyboard.nextInt()))
       {
         
       }
 
       System.out.println("Please enter the ID of the BreakOut room you want to open: ");
       
       if(newVirtualSystem.openBreakoutRoom(keyboard.nextInt()))
       {
         
        }
       
       

       
       System.out.println("BreakOut Rooms managed by the Virtual Meeting System: " + "\n");
       newVirtualSystem.listAllBreakoutRooms();
       

  
       newVirtualSystem.listParticipantsInAllBreakoutRooms();
          
    }
}
