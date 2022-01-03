package out.Jonathan_Gray_657823_assignsubmission_file_;// StudentID: 816022996
// Student Name: Jonathan Gray

public class VirtualRunner{
    public static void main(String[] args){
        VirtualMeetingSystem virtualSystem = new VirtualMeetingSystem();
        
        String fileName = "participant.dat";
        virtualSystem.loadParticipantData(fileName);
         
        // Creates and adds 5 breakoutrooms to a virtualRoom Object
        virtualSystem.createVirtualRoom("Workshop");
        virtualSystem.createBreakoutRooms();
        
        //Allocates participants
        virtualSystem.allocateParticipants("RR");
        
        // Add a participant to a breakoutRoom
        boolean check;
        //check = virtualSystem.addParticipant("12345678", 1);
        //System.out.println("Participant added: " + check);
        
        String listOfParticipants;
        listOfParticipants = virtualSystem.listParticipants(1);
        //System.out.println(listOfParticipants);
        
        //System.out.println(virtualSystem.listAllBreakoutRooms());
        
        boolean openedRoom;
        openedRoom = virtualSystem.openBreakoutRoom(1);
        //System.out.println(openedRoom);
        
        // Returns the breakoutRoomID of a specified participant
        String roomID = new String();
        roomID = virtualSystem.findParticipantBreakoutRoom("36892964");
        //System.out.println("The Participant BreakoutRoomID: " + roomID);

        // Lists all breakout rooms of a virtual room
        String allBreakoutRoomsInfo = new String();
        allBreakoutRoomsInfo = virtualSystem.listAllBreakoutRooms();
        //System.out.println(allBreakoutRoomsInfo);
        
        //System.out.println(virtualSystem.listParticipants(1));
        
        // Lists ALL participants in ALL breakoutRoom
        String participantsInBreakoutRooms = new String();
        participantsInBreakoutRooms = virtualSystem.listParticipantsInAllBreakoutRooms();
        //System.out.println(participantsInBreakoutRoom);
        
        // Closes a breakoutRoom
        boolean isClosed;
        //isClosed = virtualSystem.closeBreakoutRoom(1);
        //System.out.println("BreakoutRoom Closed Successfully: " + isClosed);
        
        //System.out.println(virtualSystem.getBreakoutRoomOpen(0));
        
        boolean isOpened;
        isOpened = virtualSystem.openBreakoutRoom(1);
        //System.out.println("BreakoutRoom Opened Successfully: " + isOpened);
        
        //System.out.println(virtualSystem.listAllBreakoutRooms());
        
        // Returns the number of BreakoutRooms managed by a VirtualRoom
        int numberOfBreakoutRoomsInVirtualRoom = virtualSystem.getNumberOfBreakoutRooms();
        //System.out.println(numberOfBreakoutRoomsInVirtualRoom);
    }
}