package out.Kershawn_Edwards_657805_assignsubmission_file_;public class VirtualRunner{

    public static void main(String args[]){
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        
        vms.createVirtualRoom("OOP");
        //System.out.println(vms.openBreakoutRoom(1));
        //System.out.println(vms.addParticipant("22222222",2));
        //System.out.println(vms.addParticipant("22222222",1));
        vms.loadParticipantData("participant.dat");
        vms.allocateParticipants("RR");
        System.out.println(vms.listParticipantsInAllBreakoutRooms());//All participants are displayed in their breakout rooms
        vms.closeBreakoutRoom(2);//close breakout room 2
        System.out.println(vms.listParticipantsInAllBreakoutRooms());//this shows that the room has been closed
        vms.openBreakoutRoom(2);//Opens breakout room 2
        vms.addParticipant("12345678",2);//adds the supplied particiapnt ID to breakout room 2
        
        System.out.println(vms.findParticipantBreakoutRoom("36892964"));//This was the 6th ID entered. The breakout Room 1 shoudl be returned when using RR.
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
        System.out.println(vms.listAllBreakoutRooms());
    
    }

}
