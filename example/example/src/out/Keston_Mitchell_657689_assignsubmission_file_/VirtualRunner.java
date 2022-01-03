package out.Keston_Mitchell_657689_assignsubmission_file_;public class VirtualRunner
{

    public static void main(String[] args){

        VirtualMeetingSystem VM = new VirtualMeetingSystem();

        VM.loadParticipantData("participant.dat");

        VM.createVirtualRoom("Conference");

        VM.allocateParticipants("C10");

       System.out.println("All participants in Conference: " + VM.listParticipants(10));

       System.out.println(VM.findParticipantBreakoutRoom("10000000"));

       System.out.println("");

       System.out.println(VM.listAllBreakoutRooms());

       System.out.println(VM.listParticipantsInAllBreakoutRooms());

       VM.closeBreakoutRoom(1);

       System.out.println(VM.listAllBreakoutRooms());


       VM.openBreakoutRoom(1);

       System.out.println(VM.listAllBreakoutRooms());

       System.out.println("Adding 100000 to a breakout room..........");

       if(VM.addParticipant("100000",1)){
        System.out.println("Added successfully");
        }
        else
        System.out.println("Did not add successfully");
    }
}
