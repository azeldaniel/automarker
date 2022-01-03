package out.Nickal_Winter_657706_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRunner
{
    // instance variables - replace the example below with your own
    public static void main (String[] args){
    VirtualMeetingSystem vm = new VirtualMeetingSystem();
    vm.loadParticipantData("participant.dat");
    vm.createVirtualRoom("VirtualRoom");
    ///CC
    vm.openBreakoutRoom(0);
    vm.openBreakoutRoom(1);
    vm.openBreakoutRoom(2);
    vm.openBreakoutRoom(3);
    vm.openBreakoutRoom(4);
    vm.allocateParticipants();
    vm.addParticipant("11112222",2);
    System.out.println();
    System.out.println(vm.listAllBreakoutRooms());
    System.out.println();
    System.out.println(vm.listParticipants(0));
    System.out.println();
    System.out.println(vm.listParticipants(1));
    System.out.println();
    System.out.println(vm.listParticipants(2));
    System.out.println();
    System.out.println(vm.listParticipants(3));
    System.out.println();
    System.out.println(vm.listParticipants(4));
    System.out.println();
    System.out.println(vm.listParticipantsInAllBreakoutRooms());
    System.out.println();
    
    
    
}
}
