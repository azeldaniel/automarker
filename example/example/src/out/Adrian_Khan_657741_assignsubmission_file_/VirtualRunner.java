package out.Adrian_Khan_657741_assignsubmission_file_;
/*
 * StudentID: 816020488
 */
public class VirtualRunner 
{
    public static void main(String[] args) {
        VirtualMeetingSystem v1 = new VirtualMeetingSystem();
        
        v1.loadParticipantData("participant.dat"); //1
        System.out.println("1. Data loaded");
        System.out.println("---\n");

        System.out.println("2. Creating Virtual Rooms");
        v1.createVirtualRoom("Friends"); //2
        System.out.println("---\n");
        
        System.out.println("3. Allocating Participants");
        v1.allocateParticipants("C5"); //3
        System.out.println("---\n");
        
        System.out.println("4. Adding a participant to a breakoutRoom");
        v1.addParticipant("11111111",1); //4
        System.out.println("---\n");

        System.out.println("5. Listing Participants in a breakoutRoom");
        v1.listParticipants(1); //5
        System.out.println("---\n");
        
        /*

        System.out.println("7. Closing the breakoutRoom");
        v1.closeBreakoutRoom(1); //7
        System.out.println("---\n");

        System.out.println("6. Opening the breakoutRoom");
        v1.openBreakoutRoom(1); //6
        System.out.println("---\n");
        */
       
        System.out.println("8. Opening the breakoutRoom");
        v1.findParticipantBreakoutRoom("84528887"); //8
        System.out.println("---\n");
        
        System.out.println("9. Opening the breakoutRoom");
        v1.listAllBreakoutRooms(); //9
        System.out.println("---\n");

        System.out.println("10. Listing All Participants In All BreakoutRooms: ");
        v1.listParticipantsInAllBreakoutRooms(); //10

    }
}