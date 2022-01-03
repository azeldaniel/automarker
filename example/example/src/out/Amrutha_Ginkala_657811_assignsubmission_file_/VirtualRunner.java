package out.Amrutha_Ginkala_657811_assignsubmission_file_;/**
 *
 *816117625
 *
 */

/**
 * The VirtualRunner class invokes the VirtualMeetingSystem class.
 *
 * @author (Amrutha Ginkala (816117625))
 * @version (11/02/2021)
 */
public class VirtualRunner
{


    public static void main(String[] args) throws Exception {

        VirtualMeetingSystem virtualMeetingSystem = new VirtualMeetingSystem();

        // 1. Load participant data from a data file
        try {
            virtualMeetingSystem.loadParticipantData("src/test/resources/participant.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /** Cluster Based Allocation Example **/

        // 2. Create the virtual room. It creates breakoutrooms internally.
        virtualMeetingSystem.createVirtualRoom("VirtualRoom");

        // Display a list of all breakout rooms managed by the system
        String breakOutRooms = virtualMeetingSystem.listAllBreakoutRooms();
        System.out.println(breakOutRooms);

        // Allocate Participants in Cluster Method. You can define cluster size after
        // the character C. Example C3, C5
        String clusterSize = "C5";
        System.out.println(clusterSize + " Allocations:");
        virtualMeetingSystem.allocateParticipants(clusterSize);

        // Display a list of all breakout rooms managed by the system and the
        // participants in each room
        String allParticipants = virtualMeetingSystem.listParticipantsInAllBreakoutRooms();
        System.out.println(allParticipants);

        /** Round Robin based Allocation Example **/
        // Allocate Participants in Round Robin Method.
        virtualMeetingSystem.allocateParticipants("RR");

        // Display a list of all breakout rooms managed by the system and the
        // participants in each room
        allParticipants = virtualMeetingSystem.listParticipantsInAllBreakoutRooms();
        System.out.println(allParticipants);
        
        //Here we provide invalid room number and check method return null or not
        String participants = virtualMeetingSystem.listParticipants(8);
        System.out.println("Participants in Breakout room 8 :" + participants);
        
        //Here we provide invalid participant ID and check if returns null
        // if that participant is not present in any breakOutRoom
        String breakoutRoom = virtualMeetingSystem.findParticipantBreakoutRoom("200");
        System.out.println("Participant 200 found in breakout room: " + breakoutRoom);

    }


}
