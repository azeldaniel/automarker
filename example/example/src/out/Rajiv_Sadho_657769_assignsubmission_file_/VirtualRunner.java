package out.Rajiv_Sadho_657769_assignsubmission_file_;
/**
 * 816022655
 * BlueJ version 4.2.2
 * Java version 11.0.2
 * JavaFX version 11.0.2+1
 * Virtual machine: OpenJDK 64-Bit Server VM 11.0.2+9 (Oracle Corporation)
 * Running on: Windows 10 10.0 (amd64)
 */
public class VirtualRunner {
    public static void main(String[] args) {
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        vms.loadParticipantData("participant.dat");
        vms.createVirtualRoom("test");
        vms.allocateParticipants("RR");
        System.out.println(vms.addParticipant("12345678", 4));
        System.out.println(vms.listParticipants(2));
        System.out.println(vms.openBreakoutRoom(2));
        System.out.println(vms.closeBreakoutRoom(2));
        System.out.println(vms.findParticipantBreakoutRoom("23123211"));
        System.out.println(vms.listAllBreakoutRooms());
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
    }
}
