package out.Carson_White_657742_assignsubmission_file_;import java.util.Scanner;
//816020150
public class VirtualRunner{
    public static void main(String args[]){
        VirtualMeetingSystem T = new VirtualMeetingSystem();
        Scanner input = new Scanner(System.in);
        T.loadParticipantData("participant.dat");
        System.out.println("Please enter the name of virtual room");
        T.createVirtualRoom(input.nextLine());
        System.out.println(T.addParticipant("13245678",1));
        System.out.println(T.addParticipant("13245678",1));
        T.openBreakoutRoom(1);
        T.openBreakoutRoom(2);
        T.openBreakoutRoom(3);

        T.openBreakoutRoom(5);
        T.openBreakoutRoom(4);
        T.closeBreakoutRoom(4);
        System.out.println(T.addParticipant("13245678",1));
        System.out.println("Please enter the code");
        T.allocateParticipants(input.nextLine());
        System.out.println(T.findParticipantBreakoutRoom("13245678"));
        
        System.out.println(T.listAllBreakoutRooms());
        System.out.println(T.listParticipantsInAllBreakoutRooms());
    }
}