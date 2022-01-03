package out.Tariq_Mohammed_657807_assignsubmission_file_;
/*
 Student ID: 816015043
 Name: Tariq Azard Mohammed
 COMP 2603 (Object Oriented Programming 1) - Assignment 1
 VirtualRunner
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class VirtualRunner
{
    public static void main(String args[]){
        
        //1. loadParticipantData
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        
        String filename = "participant.dat";
        
        vms.loadParticipantData(filename);

        System.out.println();
        
        
        //2. create a new virtual room
        vms.createVirtualRoom("MeetingRoom");
        
        //7. open breakoutRooms based on roomNumber (need to open rooms before participants can be allocated)
        vms.openBreakoutRoom(1);
        vms.openBreakoutRoom(2);
        vms.openBreakoutRoom(3);
        vms.openBreakoutRoom(4);
        vms.openBreakoutRoom(5);
        
        
        //3. allocation of participants based on either C5 or RR strategy 
        vms.allocateParticipants("C5");
        
        
        //4. adding a participant to a specific breakoutRoom (This would not be assigned as the breakoutRoom is already filled (10 participants))
        vms.addParticipant("12345678",1);
        System.out.println();
        
        
        //5. display list of all participants in a specific breakoutRoom
        String participants1 = vms.listParticipants(1);
        System.out.println(participants1);
        System.out.println();
        
        
        
        
        //8. determine the breakoutRoomID which contains a specified participant
        String breakoutRoom = vms.findParticipantBreakoutRoom("84528887");
        System.out.println(breakoutRoom);
        System.out.println();
        
        //9. displays a list of all the breakoutRooms
        String allBreakoutRooms = vms.listAllBreakoutRooms();
        System.out.println(allBreakoutRooms);
        
        //10. displays a list of all breakoutRooms as well as the participants allocated to each room
        String participantBreakoutRooms = vms.listParticipantsInAllBreakoutRooms();
        System.out.println(participantBreakoutRooms);
        
        
        //6. closes the breakoutRooms based on a specified roomNumber.
        vms.closeBreakoutRoom(1);
        vms.closeBreakoutRoom(2);
        vms.closeBreakoutRoom(3);
        vms.closeBreakoutRoom(4);
        vms.closeBreakoutRoom(5);
        
        allBreakoutRooms = vms.listAllBreakoutRooms();
        System.out.println(allBreakoutRooms);
    }
}
