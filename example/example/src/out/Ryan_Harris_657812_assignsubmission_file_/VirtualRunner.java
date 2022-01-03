package out.Ryan_Harris_657812_assignsubmission_file_;import java.util.Scanner;
/*
 * 
 * ID: 816021062
 * Name: Ryan Harris
 * 
 */
public class VirtualRunner 
{
    private static VirtualMeetingSystem VirtualMeeting = new VirtualMeetingSystem();
    private static Scanner keyboard = new Scanner(System.in);
    private static String ID;
    private static int room;
    private static String code;
    
    public static void main (String[] args){

        VirtualMeeting.loadParticipantData("participant.dat");
        System.out.println("Enter the name of the Virtual Room");
        String name = keyboard.nextLine();
        VirtualMeeting.createVirtualRoom(name);
        
        while (true){
            menu();
            System.out.println("Enter your choice:");
            int option = keyboard.nextInt();
            keyboard.nextLine();
            
            switch(option){
                case 1: 
                    System.out.println("RR or C5");
                    //System.out.println("21");
                    code = keyboard.nextLine();
                    //System.out.println(code + "2");
                    VirtualMeeting.allocateParticipants(code);
                break;
                case 2:
                    System.out.println("ID");
                    ID = keyboard.nextLine();
                    System.out.println("Breakout Room");
                    room = keyboard.nextInt();
                    keyboard.nextLine();
                    VirtualMeeting.addParticipant(ID, room);
                break;
                case 3:
                    System.out.println("Breakout Room");
                    room = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println(VirtualMeeting.listParticipants(room));
                break;
                case 4:
                    System.out.println("Breakout Room");
                    room = keyboard.nextInt();
                    keyboard.nextLine();
                    if (VirtualMeeting.closeBreakoutRoom(room)){
                        System.out.println("Breakout Room Closed");
                    }else System.out.println("Breakout Room was already Closed");
                break;
                case 5:
                    System.out.println("Breakout Room");
                    room = keyboard.nextInt();
                    keyboard.nextLine();
                    if (VirtualMeeting.openBreakoutRoom(room)){
                        System.out.println("Breakout Room Open");
                    }else System.out.println("Breakout Room was already Openned");
                break;
                case 6:
                    System.out.println("ID");
                    ID = keyboard.nextLine();
                    String found = VirtualMeeting.findParticipantBreakoutRoom(ID);
                    if (!(found == null)){
                        System.out.println("BreakoutRoom: " + found);
                    }else{
                        System.out.println("No Breakout Room with that ID was found");
                    }
                break;
                case 7:
                    System.out.println(VirtualMeeting.listAllBreakoutRooms());
                break;
                case 8:
                    System.out.println(VirtualMeeting.listParticipantsInAllBreakoutRooms());
                break;
                default:
                    return;
            }
            
            
        }

        
    }
    
    private static void menu(){
        System.out.println(" 1. Allocate participants to breakout rooms");
        System.out.println(" 2. Add a new participant");
        System.out.println(" 3. Display a list of all participants in a breakout room");
        System.out.println(" 4. Close a Breakout Room");
        System.out.println(" 5. Open a Breakout Room");
        System.out.println(" 6. Find a Participant's breakout room");
        System.out.println(" 7. Display all breakout rooms");
        System.out.println(" 8. Display all participants in all breakout rooms");
        System.out.println(" Any other number will end program");
    }
        
}
