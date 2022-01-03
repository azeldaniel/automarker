package out.Brandon_Bharath_657792_assignsubmission_file_;//816020909 Brandon Bharath
public class VirtualRunner
{
   public static void main(String[] args)
   {
       VirtualMeetingSystem v = new VirtualMeetingSystem();
       
       v.loadParticipantData("participant.dat");
       
       v.createVirtualRoom("Workshop");
      
       v.allocateParticipants("C5");
       
       System.out.println(v.listParticipants(1));
       
       System.out.println("\nClosing Breakout Room 5");
       v.closeBreakoutRoom(5);
       System.out.println(v.listAllBreakoutRooms());
       
       System.out.println("\nOpening Breakout Room 5");
       v.openBreakoutRoom(5);
       System.out.println(v.listAllBreakoutRooms());
       
       System.out.println(v.findParticipantBreakoutRoom("22927494") + "\n");
       
       System.out.println(v.listParticipantsInAllBreakoutRooms());
       
       v.addParticipant("00000001", 5);
       System.out.println(v.listParticipantsInAllBreakoutRooms());
       System.out.println(v.findParticipantBreakoutRoom("00000001"));
   }
}
