package out.Kadeem_Compton_657768_assignsubmission_file_;//814002641

public class VirtualRunner
{
   
    public static void main(String[] args)
    {
        VirtualMeetingSystem VSM = new VirtualMeetingSystem();
        VSM.loadParticipantData("participant.dat");
        VSM.createVirtualRoom("Workshop");
        System.out.println(VSM.listAllBreakoutRooms());
        VSM.openBreakoutRoom(1);
        VSM.openBreakoutRoom(2);
        VSM.openBreakoutRoom(3);
        VSM.openBreakoutRoom(4);
        VSM.openBreakoutRoom(5);
        System.out.println(VSM.listAllBreakoutRooms());
        System.out.println("\n\n");
        VSM.allocateParticipants("C5");
        System.out.println(VSM.listAllBreakoutRooms());
        System.out.println (VSM.listParticipantsInAllBreakoutRooms());
        //VSM.closeBreakoutRoom(3);
        System.out.println(VSM.listAllBreakoutRooms());
        System.out.println (VSM.listParticipantsInAllBreakoutRooms());
        System.out.println(VSM.findParticipantBreakoutRoom("78606510"));
    }
     
    
}
