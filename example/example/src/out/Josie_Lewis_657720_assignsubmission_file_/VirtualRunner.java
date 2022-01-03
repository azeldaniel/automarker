package out.Josie_Lewis_657720_assignsubmission_file_;import java.util.*;
/**
 * Josie Lewis 816020986
 */

public class VirtualRunner

{
     
      public VirtualMeetingSystem Obj;
      static Scanner s = new Scanner(System.in);
   public static void main(String[] arg) {
       String key;
       System.out.println("Menu");
       System.out.println("1. Load participant data from a data file");
       System.out.println("2. Create a new virtual room");
       System.out.println("3. Allocate participants to breakout rooms ");
       System.out.println("4. Add a new participant to a breakout room");
       System.out.println("5. Display a list of all participants in a breakout room");
       System.out.println("6. Close a breakout room based on a room number");
       System.out.println("7. Open a breakout room based on a room number");
       System.out.println("8. Find a participant’s breakout room number");
       System.out.println("9. Display a list of all breakout rooms managed by the system");
       System.out.println("10. Display a list of all breakout rooms managed by the system and the participants in each room");
       System.out.println("Please enter a number");
       key = s.nextLine();
       
       
    }
    
    public void choice(String key) {
        
        if (key=="1") {
           Obj.loadParticipantData("participant");
        }
        else if (key=="2") {
            System.out.println("Enter Virtual Room Name");
            String name = s.nextLine();
            Obj.createVirtualRoom(name);
            
        }
        else if (key=="3") {
            System.out.println("Enter Code");
            String code = s.nextLine();
            Obj.allocateParticipants(code);
            
        }
        else if (key=="4") {
            
            
        }
        else if (key=="5") {
            
        }
        else if (key=="6") {
            
        }
        else if (key=="7") {
            
        }
        else if (key=="8") {
            
        }
        else if (key=="9") {
            
        }
        else if (key=="10") {
            
        }
    }
}
