package out.Shalana_Seuraj_657681_assignsubmission_file_;/*
 * 816021684
 */

public class VirtualRunner{
    public static void main(String[] args){
       VirtualMeetingSystem vMS = new VirtualMeetingSystem();
       vMS.loadParticipantData("participant.dat");
       System.out.println("The participant data has been loaded from the file");
       vMS.createVirtualRoom("Ruby");
       System.out.println("The virtual room has been created");
       vMS.allocateParticipants("C5");
       System.out.println("The participants have been allocated to the breakout rooms");
       
       boolean pAdded = vMS.addParticipant("81602168", 1);
       if(pAdded==true){
           System.out.println("Participant ID 81602168 has been added to the room number 1");
       }
       else{
           System.out.println("Participant ID 81602168 could not be added to room number 1");
       }
       System.out.println("\n");
       System.out.println(vMS.listParticipants(1));
       System.out.println(vMS.listParticipants(2));
       System.out.println(vMS.listParticipants(3));
       System.out.println(vMS.listParticipants(4));
       System.out.println(vMS.listParticipants(5));
       
       boolean roomClosed = vMS.closeBreakoutRoom(2);
       if(roomClosed==true){
           System.out.println("Room number 2 has been closed...");
       }
       else{
           System.out.println("Room number 2 has not been closed...");
       }
       
       boolean roomOpened = vMS.openBreakoutRoom(2);
       if(roomOpened==true){
           System.out.println("Room number 2 has been opened...");
       }
       else{
           System.out.println("Room number 2 has not been opened...");
       }
       
       boolean pAdded2 = vMS.addParticipant("81602168", 2);
       if(pAdded2==true){
           System.out.println("Participant ID 81602168 has been added to the room number 2");
       }
       else{
           System.out.println("Participant ID 81602168 could not be added to room number 2");
       }
       
       boolean pAdded3 = vMS.addParticipant("81701149", 2);
       if(pAdded3==true){
           System.out.println("Participant ID 81701149 has been added to the room number 2");
       }
       else{
           System.out.println("Participant ID 81701149 could not be added to room number 2");
       }     
              
       String participantFound = vMS.findParticipantBreakoutRoom("81701149");
       if(participantFound==null){
           System.out.println("Breakout room hosting participant 81701149 could not be found");
       }
       else{
           System.out.println(participantFound + " is the breakout room that is hosting participant 81701149");
       }
       
       System.out.println("\n");
       System.out.println(vMS.listAllBreakoutRooms());
       System.out.println(vMS.listParticipantsInAllBreakoutRooms());
       
    }
}
