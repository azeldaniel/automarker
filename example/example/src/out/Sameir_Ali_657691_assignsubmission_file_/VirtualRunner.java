package out.Sameir_Ali_657691_assignsubmission_file_;//Student ID#: 816022840
public class VirtualRunner{
    public static void main(String [] args){
     boolean status;
     VirtualMeetingSystem V = new VirtualMeetingSystem(); 
     V.loadParticipantData("participant.dat");
     V.createVirtualRoom("VirtualRoom");
     status = V.openBreakoutRoom(1);
      if(status == true)
         System.out.println("Open works");
     else
         System.out.println("Open does not work");
     status = V.addParticipant("00000001",1);
     if(status == true)
         System.out.println("Participant Added");
     else
         System.out.println("Participant not added");
     System.out.print(V.listParticipants(1));    
     if(V.findParticipantBreakoutRoom("00000001") != null)
         System.out.println("Find works");
     else
         System.out.println("Find does not work");
     System.out.print(V.listParticipantsInAllBreakoutRooms());
     System.out.println(V.listAllBreakoutRooms());
     status = V.closeBreakoutRoom(1);
     if(status == true)
         System.out.println("Close Works");
     else
         System.out.println("Close does not work");
    
     V.allocateParticipants("C5");
     System.out.println(V.listParticipantsInAllBreakoutRooms());
     
     System.out.println(V.listAllBreakoutRooms());
    }
}

//Resources used for this class:
//Lecture Notes