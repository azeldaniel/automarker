package out.Brandon_James_657851_assignsubmission_file_;
/**
 * 
 *
 * @815006970 (ID)
 * 
 */
public class VirtualRunner
{
    // instance variables
    private static VirtualMeetingSystem testSystem = new VirtualMeetingSystem();

    
    public VirtualRunner()
    {
        // initialise instance variables
    }

    
    public static void main(String[] args)
    {   
        String roomName = "testRoom";
        String filename = "participant.dat";
        String code = "RR";
        testSystem.createVirtualRoom(roomName);
        testSystem.loadParticipantData(filename);
        testSystem.allocateParticipants(code);
        String testData = "";
        //testData = testSystem.findParticipantBreakoutRoom("47790583");
        testData = testSystem.listParticipantsInAllBreakoutRooms();
        System.out.println("Test Data:"); System.out.println(testData);
        
    }
}
