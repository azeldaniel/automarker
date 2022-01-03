package out.Chantel_Lewis_657735_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author 816011391
 * @version 14/02/2021
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class VirtualRunner
{
    //Constructor for objects of class VirtualRunner
    public VirtualRunner()
    {
        
    }

    public static void main(String[] args)
    {
       VirtualMeetingSystem vMS = new VirtualMeetingSystem();
       vMS.loadParticipantData("participant.dat");
       
       vMS.createVirtualRoom("Information Security Seminar");
       
       //vMS.allocateParticipants("C5");
       //vMS.allocateParticipants("RR");
       
       vMS.addParticipant("12345678", 1);
       
       System.out.println("Participants of Information Security Seminar: " + "\n" + 
        vMS.listParticipants(4));
       
       System.out.println(vMS.listAllBreakoutRooms());
       System.out.println(vMS.listParticipantsInAllBreakoutRooms());
       
       vMS.openBreakoutRoom(1);
       System.out.println(vMS.listAllBreakoutRooms());
       
       vMS.closeBreakoutRoom(1);
       System.out.println(vMS.listAllBreakoutRooms());
       
       System.out.println(vMS.findParticipantBreakoutRoom("22927494") + "");
       //Participant[] participants = new Participant[10];
       //BreakoutRoom[] breakoutRooms = new BreakoutRoom[5];
    }

}
