package out.Hansel_Charles_657854_assignsubmission_file_;
/*
 * HANSEL CHARLES
 * ID: 816011166
 */
public class VirtualRunner{
    public static void main(String[] args){
        VirtualMeetingSystem virtualRooms = new VirtualMeetingSystem();
        
        //1
        virtualRooms.loadParticipantData("participant.dat");
        
        //2
        virtualRooms.createVirtualRoom("CAMP");
        
        //3 
        virtualRooms.allocateParticipants("C5");
        
        //4
        /*System.out.println("\nAdd Participant to Breakout Room");
        System.out.println(virtualRooms.addParticipant("12345678", 1));*/
           
        //5
        System.out.println("\nParticipant in Breakout Room");
        System.out.println(virtualRooms.listParticipants(1));
        
        //6
        virtualRooms.openBreakoutRoom(1);
        
        //7
        virtualRooms.closeBreakoutRoom(1);
        
        //8
        /*System.out.println("\nFinding Participants Breakout Room");
        System.out.println(virtualRooms.findParticipantBreakoutRoom("19147829"));*/
            
        //9
        System.out.println("\nAll Breakout Rooms");
        System.out.println(virtualRooms.listAllBreakoutRooms());
           
        //10
        System.out.println("\nAll Breakout Rooms with Participants \n");
        System.out.println(virtualRooms.listParticipantsInAllBreakoutRooms());
    }
}

