package out.Aleksi_Olivier_657749_assignsubmission_file_;/**
 * Write a description of class BreakoutRoom here.
 * All classes originally written in VS code
 * @author (ALEKSI OLIVIER 816023287)
 * @version (a version number or a date)
 */
public class VirtualRunner {
    public static void main(String[] args) {
        //all methods work. Originally written in vs Code 
        VirtualMeetingSystem test = new VirtualMeetingSystem(); 
        test.createVirtualRoom("Seminar");
        test.loadParticipantData("participant.dat");        
        test.allocateParticipants("c5");
        //System.out.println(test.listParticipants(5)); 
        //System.out.println(test.findParticipantBreakoutRoom("47790583")); //this is fine
        //System.out.println(test.listAllBreakoutRooms()); 
        //System.out.println(test.listParticipantsInAllBreakoutRooms()); 
        test.closeBreakoutRoom(2);
        test.openBreakoutRoom(2);
        test.addParticipant("12345678", 2);
        //test.listParticipants(5);
        System.out.println(test.listParticipantsInAllBreakoutRooms()); 
        System.out.println(test.listAllBreakoutRooms());
    }
}

