package out.Shane_Beharry_657758_assignsubmission_file_;//Shane Beharry
//816023033
public class VirtualRunner
{
    public static void main(String arsgs[]){
        //I have no idea what is supposed to go in main. A menu probably? Document did not specify
        VirtualMeetingSystem sys1 = new VirtualMeetingSystem();
        sys1.loadParticipantData("participant.dat");
        
        sys1.createVirtualRoom("Workshop");
        
        sys1.allocateParticipants("RR");
        
        System.out.println(sys1.listParticipants(0));
        System.out.println(sys1.listParticipants(1));
        System.out.println(sys1.listParticipants(2));
        System.out.println(sys1.listParticipants(3));
        System.out.println(sys1.listParticipants(4));
        
        System.out.println(sys1.findParticipantBreakoutRoom("12103114"));
        System.out.println("\n");
        
        System.out.println(sys1.listParticipantsInAllBreakoutRooms());
        
        System.out.println(sys1.vRoom.listBreakoutRooms());
    }
}
