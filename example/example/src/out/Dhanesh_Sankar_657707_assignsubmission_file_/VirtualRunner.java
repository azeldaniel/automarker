package out.Dhanesh_Sankar_657707_assignsubmission_file_;/**
Dhanesh Sankar
816020350
 */
import java.util.Scanner;
public class VirtualRunner
{
    /**
     * Main
     */    
   public static void main(String[] args) throws Exception{
        //1 read file
        VirtualMeetingSystem NewSystem = new VirtualMeetingSystem();
        String file;
        System.out.println("Enter file name.");
        Scanner keyboard = new Scanner(System.in);
        file = keyboard.nextLine();
        NewSystem.loadParticipantData(file);       
       
       //2 new virtual room
       String VirtualRoomName; 
       System.out.println("Enter the name of the new Vitrual Room");
       VirtualRoomName = keyboard.nextLine();
       NewSystem.createVirtualRoom(VirtualRoomName);
       System.out.println("New Virtual room created.");
       
       //3 allocate participants to breakoutrooms
       String participantAllocation = " ";
       System.out.println("Please enter C5");
       participantAllocation = keyboard.nextLine();
       NewSystem.allocateParticipants(participantAllocation);
       System.out.println(NewSystem.listParticipantsInAllBreakoutRooms());
       
       //8 find a participant's breakout room number
       String searchID = " ";
       System.out.println("Enter participant ID to find corresponding room. ");
       searchID = keyboard.nextLine();
       System.out.println(NewSystem.findParticipantBreakoutRoom(searchID));

       //4 Add a new participant to a breakoutroom
       String IDtoAdd = " ";
       int roomnum = 0;
       System.out.println("Enter participantID to be added to different Breakout Room.");
       IDtoAdd = keyboard.nextLine();
       System.out.println("Enter Breakout Room Number for participant ID shift.");
       roomnum = keyboard.nextInt();
       NewSystem.addParticipant(IDtoAdd,roomnum);
        
       //5 display the list of participants in a breakoutroom
       int roomNumber = 0;
       String Roomlist = " ";
       System.out.println("Enter a room number 0-4 to list its participants");
       roomNumber = keyboard.nextInt();
       Roomlist = NewSystem.listParticipants(roomNumber);       
       
       //6 close a breakoutroom based on the room number
       System.out.println("Enter any room number, 0-4 to close the room.");
       boolean toClose;
       int inputRoomToClose = 0;
       inputRoomToClose = keyboard.nextInt();
       toClose = NewSystem.closeBreakoutRoom(inputRoomToClose);
       if(toClose == true){
           System.out.println("The breakout room is closed");
        }
       
       //7 open a breakoutroom based on the room number
       System.out.println("Enter any room number, 0-4 to open the room.");
       boolean toOpen;
       int inputRoomToCose= 0;
       inputRoomToClose = keyboard.nextInt();
       toOpen = NewSystem.openBreakoutRoom(inputRoomToClose);
       if(toOpen== true){
           System.out.println("The breakoutroom is now open");
        }  
     
       //9 display a list of all breakout rooms managed by the system
       System.out.println("List of all breakout rooms managed by the system: " + "\n");
       NewSystem.listAllBreakoutRooms();
        
       //10 display a list of all the breakout rooms managed by the system
       //and the participants in each room
       System.out.println(NewSystem.listParticipantsInAllBreakoutRooms());                     
    }    
}