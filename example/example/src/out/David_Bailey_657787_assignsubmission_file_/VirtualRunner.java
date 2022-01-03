package out.David_Bailey_657787_assignsubmission_file_;public class VirtualRunner{
    public static void main(String[] args){
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        //1.)Load participant data from a data file
        vms.loadParticipantData("participant.dat");
        
        //2.)Create a new virtual room
        vms.createVirtualRoom("TestRoom");
        
        //3.)Allocate participants to breakout rooms
        vms.allocateParticipants("RR");// change parameters to C5 for next allocation 
        
        //6.)Close a breakout room based on a room number
        boolean close = vms.closeBreakoutRoom(3);
        
        //9.)Display a list of all breakout rooms managed by the system
        String breakoutRooms = vms.listAllBreakoutRooms();
        System.out.println(breakoutRooms);
        
        //7.) Open a breakout room based on a room number�
        boolean open = vms.openBreakoutRoom(3);
        String breakoutRoomsAllOpen = vms.listAllBreakoutRooms();
        System.out.println(breakoutRoomsAllOpen);
        
        //4.Add a new participant to a breakout room
        boolean isAdded = vms.addParticipant("12345678",3);// can be seen in the allParticipants list
        
        
        //10.) Display a list of all breakout rooms managed by the system and the participants in each room
        String allParticipants = vms.listParticipantsInAllBreakoutRooms();
        System.out.println(allParticipants);
        //8.) Find a participant’s breakout room number
        String respectiveRoom = vms.findParticipantBreakoutRoom("12345678"); // why does this return test room one instead of test room3 ? 
        System.out.println(respectiveRoom + "\n");
    }
}
