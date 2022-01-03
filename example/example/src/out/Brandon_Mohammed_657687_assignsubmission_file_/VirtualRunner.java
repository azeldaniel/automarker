package out.Brandon_Mohammed_657687_assignsubmission_file_;//816018582
import java.util.Scanner;
public class VirtualRunner
{    
    
    public static void createVirtualRoom(VirtualMeetingSystem vms){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the name of the virtual room that you want to create?");
        System.out.println("Name of virtual room: ");
        String name = scan.nextLine();
        vms.createVirtualRoom(name);
    }
    
    public static void main(){
        Scanner scan = new Scanner(System.in);
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        String choice = " ";
        
        
        System.out.println("Good day, what is the name of the file that you want to load in?");
        System.out.print("Name of file: ");
        String fileName = scan.nextLine();
        vms.loadParticipantData(fileName);
        
        createVirtualRoom(vms);
        
        allocateParticipants(vms);
        
        addParticipant(vms);
        
        listParticipants(vms);
        
        openBreakoutRoom(vms);
        
        closeBreakoutRoom(vms);
        
        findParticipantBreakoutRoom(vms);
        
        listAllBreakoutRooms(vms);
        
        listParticipantsInAllBreakoutRooms(vms);
             
    }
     

    public static void allocateParticipants(VirtualMeetingSystem vms){
        Scanner scan = new Scanner(System.in);        
        System.out.println("How would you like to allocate participants?(C5)");
        System.out.print("Allocation time: ");
        String code = scan.nextLine();
        vms.allocateParticipants(code);
    }
    
    public static void addParticipant(VirtualMeetingSystem vms){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the participant ID that you would like to add?");
        System.out.print("Participant Id: ");
        String participantID = scan.nextLine();
        System.out.println("What is the room number that you would like to add the participant to?");
        System.out.print("Room Number: ");
        int roomNumber = scan.nextInt();
        boolean added = vms.addParticipant(participantID,roomNumber);
        System.out.println("Added: " + added);
    }
    
    public static void listParticipants(VirtualMeetingSystem vms){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the room number that you would like to list the participants off?");
        System.out.print("Room Number: ");
        int roomNumber = scan.nextInt();
        System.out.println(vms.listParticipants(roomNumber));
    }
    
    public static void openBreakoutRoom(VirtualMeetingSystem vms){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the room number that you would like to open?");
        System.out.print("Room Number: ");
        int roomNumber = scan.nextInt();
        System.out.println("Status: " + vms.openBreakoutRoom(roomNumber));
    }
    
    public static void closeBreakoutRoom(VirtualMeetingSystem vms){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the room number that you would like to close?");
        System.out.print("Room Number: ");
        int roomNumber = scan.nextInt();
        System.out.println("Status: " + vms.closeBreakoutRoom(roomNumber));
    }
    
    public static void findParticipantBreakoutRoom(VirtualMeetingSystem vms){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the participant Id that you would like to search for?");
        System.out.print("Participant ID: ");
        String participantID = scan.nextLine();
        System.out.println("Breakout Room: " + vms.findParticipantBreakoutRoom(participantID));
    }
   
    public static void listAllBreakoutRooms(VirtualMeetingSystem vms){
        System.out.println("All virtual rooms: ");
        System.out.println(vms.listAllBreakoutRooms());
    }
    
    public static void listParticipantsInAllBreakoutRooms(VirtualMeetingSystem vms){
        System.out.println("All Participants in breakout rooms: ");
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
    }
    
}
