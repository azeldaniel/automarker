package out.Kemeisha_Wilson_657772_assignsubmission_file_;import java.util.Scanner;
/**
 * @author (Kemeisha Wilson 816020815)
 * @version (12/02/2021)
 */
public class VirtualRunner
{
    public static void main(String[] args)
    {
        String ID;
        int room=0;
        VirtualMeetingSystem virtualMeetingSystem;
        virtualMeetingSystem= new VirtualMeetingSystem();
        Scanner keys= new Scanner(System.in);
        int choice=0;
        while(choice!=11) {
            menu();
            choice= keys.nextInt();
            keys.nextLine();
            switch(choice) {
                case 1:
                    virtualMeetingSystem.loadParticipantData("participant.txt");
                    System.out.println("Participants are added");
                    break;
                case 2:
                    virtualMeetingSystem.createVirtualRoom("Workshop");
                    System.out.println("Virtual Room name is Workshop");
                    break;
                case 3:
                    String code;
                    System.out.print("Enter the RR or C5: ");
                    code=keys.nextLine();
                    virtualMeetingSystem.allocateParticipants(code);
                    break;
                case 4:
                    System.out.println("Enter participant ID you wish to add: ");
                    ID=keys.nextLine();
                    System.out.println("Enter room number you wish to add participant to: ");
                    room= keys.nextInt();
                    virtualMeetingSystem.addParticipant(ID,room);
                    break;
                case 5:
                    System.out.print("Enter the room number: ");
                    room=keys.nextInt();
                    keys.nextLine();
                    String list;
                    list=virtualMeetingSystem.listParticipants(room);
                    System.out.println(".....................List Of Participants.......................");
                    System.out.println(list);
                    break;
                case 6:
                    boolean closed=false;
                    System.out.print("Enter room number that you wish to close: ");
                    room=keys.nextInt();
                    closed=virtualMeetingSystem.closeBreakoutRoom(room);
                    break;
                case 7:
                    boolean opened=false;
                    virtualMeetingSystem.createVirtualRoom("Workshop");
                    System.out.print("Enter room number that you wish to open: ");
                    room=keys.nextInt();
                    opened=virtualMeetingSystem.openBreakoutRoom(room);
                    break;
                case 8:
                    System.out.print("Enter participantID that you wish to find: ");
                    ID=keys.nextLine();
                    String breakoutroom;
                    breakoutroom=virtualMeetingSystem.findParticipantBreakoutRoom(ID);
                    if(breakoutroom!=null)
                        System.out.println("The Breakout room that "+ID+"is in is "+breakoutroom);
                    break;
                case 9:
                    System.out.println("....................Breakout Rooms.....................");
                    System.out.println(virtualMeetingSystem.listAllBreakoutRooms());
                    break;
                case 10:
                    int limit=0;
                    System.out.println("Virtual Room(Workshop)");
                    limit= virtualMeetingSystem.virtualRoom.getNumberOfBreakoutRooms();
                    for(int x=0;x<limit;x++){
                        list=virtualMeetingSystem.listParticipants(x);
                        System.out.println(".....................List Of Participants.......................");
                        System.out.println(list);
                    }
                    //System
                    break;
                case 11:
                    System.out.println("End of Program.");
                    break;
                default:
                    System.out.println("Invalid choice entered.");
            }
        }
        keys.close();
    }

    public static void menu(){
        System.out.println("****************************************************************************************************************");
        System.out.println("1. Load participant data from a data file");
        System.out.println("2. Create a new virtual room");
        System.out.println("3. Allocate participants to breakout rooms");
        System.out.println("4. Add a new participant to a breakout room ");
        System.out.println("5. Display a list of all participants in a breakout room ");
        System.out.println("6. Close a breakout room based on a room number ");
        System.out.println("7. Open a breakout room based on a room number ");
        System.out.println("8. Find a participant’s breakout room number ");
        System.out.println("9. Display a list of all breakout rooms managed by the system ");
        System.out.println("10. Display a list of all breakout rooms managed by the system and the participants in each room");
        System.out.println("To end enter '11'");
        System.out.println("Enter a number: ");
    }
}
