package out.Justin_Mahabir_657709_assignsubmission_file_;//ID: 816000496
/**
 * Write a description of class VirtualRunner here.
 *
 * @author Justin Mahabir
 * @version (a version number or a date)
 */
public class VirtualRunner
{
  public static void main(String[] args){
       VirtualMeetingSystem UWI = new VirtualMeetingSystem();
       System.out.println("\nTesting Requirements 1,2,3,9 & 10:");
       UWI.loadParticipantData("C:\\Users\\Justin Mahabir\\Desktop\\Justin_Mahabir_816000496_A1\\participant.dat");
       UWI.createVirtualRoom("Chemistry");
       //Change code below to test C5 method.
       UWI.allocateParticipants("c5");
       System.out.println(UWI.listAllBreakoutRooms());
       System.out.println(UWI.listParticipantsInAllBreakoutRooms());
       System.out.println("\nTesting Requirement 5:");
       System.out.println(UWI.listParticipants(4));
       System.out.println("\nTesting Requirements 6 & 7:");
       UWI.closeBreakoutRoom(3);
       System.out.println(UWI.listParticipantsInAllBreakoutRooms());
       UWI.openBreakoutRoom(3);
       //System.out.println(UWI.listParticipantsInAllBreakoutRooms());
       //System.out.println("\nTesting Requirement 4:");
       //UWI.addParticipant("10493421" , 3);
       //System.out.println(UWI.listParticipantsInAllBreakoutRooms());
       //System.out.println("\nTesting Requirement 8:");
       //System.out.println(UWI.findParticipantBreakoutRoom("10493421"));
   }  
}
