package out.Stephen_Jaggai_657716_assignsubmission_file_;// 816019082

public class VirtualRunner {
    public static void main(String[] args) {
        String filename = "participant.dat";
        String name = "Workshop";
        String code = "C5";
        String participantID = "88888888";
        int roomNumber = 1;
        
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        
        vms.loadParticipantData(filename);
        vms.createVirtualRoom (name);
        vms.allocateParticipants(code);
        vms.addParticipant (participantID, roomNumber);
        System.out.println (vms.listParticipants(roomNumber));
        vms.closeBreakoutRoom(roomNumber);
        vms.openBreakoutRoom(roomNumber);
        System.out.println (vms.findParticipantBreakoutRoom (participantID));
        System.out.println (vms.listAllBreakoutRooms());
        System.out.println (vms.listParticipantsInAllBreakoutRooms());
    }
}