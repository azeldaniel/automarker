package out.Chelsie_Rochford_657728_assignsubmission_file_;/**
 *816000366
 */

import java.util.Scanner;

public class VirtualRunner
{
    public static void main (String[] args)
    {
       
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        vms.createVirtualRoom("Workshop");
        vms.loadParticipantData("participant.dat");
        vms.allocateParticipants("C5");
        System.out.println(vms.listParticipants(2));
        vms.closeBreakoutRoom(2);
        System.out.println(vms.listAllBreakoutRooms());
        //vms.openBreakoutRoom(2);
        //vms.addParticipant("12345678",2);
        //System.out.println(vms.listParticipants(2));
        System.out.println(vms.findParticipantBreakoutRoom("85700729"));
        //System.out.println(vms.listAllBreakoutRooms());
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
    }

    
}
