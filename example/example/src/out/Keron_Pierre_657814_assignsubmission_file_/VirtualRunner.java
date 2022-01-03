package out.Keron_Pierre_657814_assignsubmission_file_;//816022340
import java.io.*;
public class VirtualRunner
{
    public static void main(String args []){
        VirtualMeetingSystem test = new VirtualMeetingSystem();
        
        //loading the participant IDs into the array
        try{
            test.loadParticipantData("participant.dat");
            System.out.println("Your data has been loaded");
        } catch(Exception e){
            System.out.println("Data could not be imported");
            e.printStackTrace();
        }
        
        //creating virtual room and checking if breakout rooms are being outputted properly
        test.createVirtualRoom("Workshop");
        String list = test.listAllBreakoutRooms();
        System.out.println(list + "\n");
        
        //testing allocateparticipants and list participants in all breakout rooms
        test.allocateParticipants("C5");
        String participantList = test.listParticipantsInAllBreakoutRooms();
        System.out.println(participantList);
        
        //testing addParticipant and listparticipants
        test.addParticipant("12345678", 3);
        String partList = test.listParticipants(3);
        System.out.print(partList);
        
        //testing open and close breakoutrooms
        if(test.openBreakoutRoom(3)){
            System.out.println("Room 3 has been opened");
        }
        if(test.closeBreakoutRoom(3)){
            System.out.println("Room 3 has been Closed");
        }
    }
}
