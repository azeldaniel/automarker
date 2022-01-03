package out.Shania_Harold_657840_assignsubmission_file_;// 816006213

public class VirtualRunner{
    public static void main(String[] args) throws Exception{
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        vms.loadParticipantData("participant.dat");
        vms.createVirtualRoom("Chem");
        vms.allocateParticipants("C5");
        //vms.allocateParticipants("RR");
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
    }
}