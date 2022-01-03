package out.Andrei_Guevara_657703_assignsubmission_file_;import java.util.Scanner;
public class VirtualRunner{
    
    public static void main(String[] args){
        
       VirtualMeetingSystem vms = new VirtualMeetingSystem();
       VirtualMeetingSystem vms2 = new VirtualMeetingSystem();
       
       String fileName = "participant.dat";
       String roomName = "Meeting";
       
       vms.loadParticipantData(fileName);
       vms.createVirtualRoom(roomName);
       vms.allocateParticipants("RR");
       
       vms2.createVirtualRoom("Hell");
       
       System.out.println(vms.listParticipantsInAllBreakoutRooms());
       System.out.println();
       //System.out.println(vms.getVirtualRoom().listBreakoutRooms());
       //System.out.println("testing testing 123");
       //System.out.println(vms2.listParticipantsInAllBreakoutRooms());
       /*
       System.out.println(vms.listParticipantsInAllBreakoutRooms());
       
       System.out.println(vms.listAllBreakoutRooms());
       
       System.out.println("Participant was found in " + vms.findParticipantBreakoutRoom("24721757"));
       
       vms.closeBreakoutRoom(3);
       
       System.out.println(vms.listParticipantsInAllBreakoutRooms());
       
       System.out.println("Participant was found in " + vms.findParticipantBreakoutRoom("85700729"));
       
       int counter=0;
       while (counter < vms.getVirtualRoom().getBreakoutRoomLimit())
            System.out.println(vms.getVirtualRoom().getBreakoutRooms()[counter++]);
       
            vms.addParticipant("00000000",3);
            
       
       System.out.println(vms.listParticipantsInAllBreakoutRooms());
       */
    }
}