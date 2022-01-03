package out.Daniel_Herbert_657791_assignsubmission_file_;//816021155
public class VirtualRunner
{
    
    public static void main(String args[]){
        /*
      BreakoutRoom vms = new BreakoutRoom("work");
      vms.addParticipant("81602115");
      System.out.println(vms.toString());
      vms.closeBreakoutRoom();
      System.out.println(vms.toString());
      vms.openBreakoutRoom();
      vms.addParticipant("81602116");
      vms.addParticipant("81602117");
      vms.addParticipant("81602118");
      vms.addParticipant("81602119");
      vms.addParticipant("81602110");
      System.out.println(vms.listParticipants());
        */
       
       /*
       VirtualRoom vms = new VirtualRoom("work");
        vms.createBreakoutRooms();
        System.out.println(vms.listBreakoutRooms());
        vms.addParticipantToBreakoutRoom("81602115", 3);
        */
        
        
      VirtualMeetingSystem vms = new VirtualMeetingSystem();
      vms.loadParticipantData("participant.dat");
      vms.createVirtualRoom("Seminar");
      System.out.println(vms.listAllBreakoutRooms());
      
      
    }
}
