package out.Melika_Ogarro_657708_assignsubmission_file_;
/**
 *
 * @authorID (816002233)
 * @version (13.02.2021)
 */
public class VirtualRunner
{
    public static void main(String[] args){
        System.out.println("\t\t\t****TEST 1****\n\n");
        System.out.println("Loading participant data from a data file...\n");
        String filename = "participant.dat";
        VirtualMeetingSystem v = new VirtualMeetingSystem();
        v.loadParticipantData(filename);
        System.out.println("\n\n");
        System.out.println("Creating virtual room 'VirtualRoom'... \n");
        v.createVirtualRoom("VirtualRoom");
        System.out.println("Allocating participants to a breakout room using RR... \n");
        v.allocateParticipants("rr");
        System.out.println("Printing breakout room number 1... \n");
        System.out.println(v.listParticipants(1));
        System.out.println("Closing breakout room number 1... \n");
        if(v.closeBreakoutRoom (1))
            System.out.println("room 1 was closed successfully");
        else
            System.out.println("room 1 is still open");
           
        if (v.listParticipants(1) == null)
            System.out.println("VirtualRoom1 is empty");
        else
            System.out.println(v.listParticipants(1));

        System.out.println("Opening and adding 00000301 to breakout room number 1... \n");
        v.addParticipant("00000301", 1);
        
        System.out.println("Opening and adding 00000001 to breakout room number 1... \n");
        v.addParticipant("00000001", 1);
        
        System.out.println("\nListing Participants in breakout room number 2... \n\n" + v.listParticipants(2)); 
        String s;
        s = v.findParticipantBreakoutRoom("00000001");
        if (s==null)
            System.out.println("\n participant's breakout room not found \n");
        else {
            System.out.println("participant's breakout room number is " + s.replaceAll("[^0-9]", ""));
        }
        //String roomNumber= s.replaceAll("[^0-9]", "");
        //System.out.println("Breakout room number of participant 99880522 is " + roomNumber + "\n\n");
        
        System.out.println("List of all breakout rooms managed by the system: \n" + v.listAllBreakoutRooms());
        System.out.println("\n\nList of all breakout rooms managed by the system and the participants in each room: \n" + v.listParticipantsInAllBreakoutRooms());
        
       
        
    }
}
