package out.Casidy_Mohamed_657801_assignsubmission_file_;//816013169

public class VirtualRunner
{
    private static VirtualMeetingSystem vms;
    private static String filename="participant.dat";
    private static String list="null";
    private static boolean add;
   
     public static void main(String args[])
     {
      /*1
        vms=new VirtualMeetingSystem();
        vms.loadParticipantData(filename);
      */
        
       /*2
        vms= new VirtualMeetingSystem();
        vms.createVirtualRoom("Meeting");
       */
       
      /* 3
        vms= new VirtualMeetingSystem();
        vms.loadParticipantData(filename);
        vms.createVirtualRoom("Meeting");
        vms.allocateParticipants("C5");
        */
       
       
       /*4
       vms= new VirtualMeetingSystem();
       vms.createVirtualRoom("Meeting");
       vms.addParticipant("12345678", 3);
       */
      
      
      /*5
       vms= new VirtualMeetingSystem();
       vms.createVirtualRoom("Meeting");
       vms.addParticipant("18283278", 1);
       vms.addParticipant("00000001", 1);
       System.out.println(vms.listParticipants(1));
       */
       
      /* 6
       vms= new VirtualMeetingSystem();
       vms.createVirtualRoom("Meeting");
       vms.closeBreakoutRoom(1);
       */
      
      /* 7
       vms= new VirtualMeetingSystem();
       vms.createVirtualRoom("Meeting");
       vms.closeBreakoutRoom(1);
       vms.openBreakoutRoom(1);
      */
      
       /*/8 overwriting in participants array
       vms= new VirtualMeetingSystem();
       vms.createVirtualRoom("Meeting");
       vms.addParticipant("12345678", 1);
       vms.addParticipant("12345679", 1);
       System.out.println(vms.findParticipantBreakoutRoom("12345678"));
      */
       
      /*9
       vms= new VirtualMeetingSystem();
       vms.createVirtualRoom("Meeting");
       //vms.listAllBreakoutRooms();
       System.out.println(vms.listAllBreakoutRooms());
      */
     
       /*/ 10  fix last line
        vms= new VirtualMeetingSystem();
        vms.loadParticipantData(filename);
        vms.createVirtualRoom("Meeting");
        vms.allocateParticipants("C5");
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
       */
     }
}