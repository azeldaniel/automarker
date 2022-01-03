package out.Videsh_Jagai_657838_assignsubmission_file_;

/**
 * 
 * Name: Videsh Jagai...
 * Student ID: 816014860..
 * 
 * 
 */


public class VirtualRunner
{    // VirtualRunner class running the according method function for tVirtulMeeting System in the main
     // 
    public static void main(String[] args)
    {
        String filename = "participant.dat"; 
        // accesing the distinction methid functions assiging the VMSys object to the VirtualMeetingSystem..
        VirtualMeetingSystem VMSys = new VirtualMeetingSystem();
        
        VMSys.loadParticipantData(filename);
        // passing String Name ;SEMINAR into the method function: Creates a virtual room with the supplied name containing 5 breakout rooms
        VMSys.createVirtualRoom("SEMINAR");
        // passing String code: C5 into thr method function: Allocates participants to the breakout rooms of a
        //virtual room using a strategy determined by the supplied code 
        VMSys.allocateParticipants("C5");
        // passing the necessary participantID: "82391732",roomNumber:3), addParticipants: Adds a new participant to the breakout room with
        //the supplied room number if it exists
        VMSys.addParticipant("82391732", 3);
        // passing the roomNumber 3:Returns a list of the participants in the breakoutroom with the supplied room number if found,
        //otherwise returns null
        System.out.println(VMSys.listParticipants(3));
        
        VMSys.closeBreakoutRoom(3);
           
        VMSys.openBreakoutRoom(3);
             
        System.out.println(VMSys.findParticipantBreakoutRoom("85700729"));
                
        System.out.println(VMSys.listAllBreakoutRooms());
             
        System.out.println(VMSys.listParticipantsInAllBreakoutRooms());


    }
}
