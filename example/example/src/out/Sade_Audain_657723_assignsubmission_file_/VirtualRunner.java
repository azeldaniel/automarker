package out.Sade_Audain_657723_assignsubmission_file_;
/*
COMP 2603 Object Oriented Programming 1
Assignment 1
2020/2021 Semester 2

STUDENT NAME: Sade Audain
ID: 816013000
 */
public class VirtualRunner
{
    public static void main(String[] args){
        String filename = "participant.dat"; 
        
        VirtualMeetingSystem meetingSystem = new VirtualMeetingSystem();
        meetingSystem.loadParticipantData(filename);
        meetingSystem.createVirtualRoom("Seminar");
        
        meetingSystem.allocateParticipants("C5");
        meetingSystem.addParticipant("00000001", 1);
        System.out.println(meetingSystem.listParticipants(2));
               meetingSystem.openBreakoutRoom(0);
               meetingSystem.closeBreakoutRoom(0);
               System.out.println(meetingSystem.findParticipantBreakoutRoom("00000001"));
               System.out.println(meetingSystem.listAllBreakoutRooms());
               System.out.println(meetingSystem.listParticipantsInAllBreakoutRooms());


    }
}
