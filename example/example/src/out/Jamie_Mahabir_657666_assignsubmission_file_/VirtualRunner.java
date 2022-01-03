package out.Jamie_Mahabir_657666_assignsubmission_file_;
/**
 *  VirtualRunner 
 *  
 *  816019893
 */


public class VirtualRunner 
{
    
    public static void main(String[] args){
        
        VirtualMeetingSystem system= new VirtualMeetingSystem();
        
        //1.
        system.loadParticipantData("participant.dat");
        System.out.println("Participant data loaded");
        
        
        //2.
        system.createVirtualRoom("Workshop");
        System.out.println("New virtual room created");
        
        
        //3.
        system.allocateParticipants("C5");
        System.out.println("Participant allocated successfully");
        
        
        //4.
        boolean addNewParticipant;
        addNewParticipant=system.addParticipant("025",4);
        
        if(addNewParticipant==true){
            System.out.println("New participant added");
        }
        else{
            System.out.println("Sorry, room is full");
        }
        
        
        //5.
        String allParticipants;
        allParticipants=system.listParticipants(2);
        System.out.println(allParticipants);
        
        
        //6.
        boolean closeRoom;
        closeRoom=system.closeBreakoutRoom(3);
        
        if(closeRoom==true){
            System.out.println("Breakout Room closed");
        }
        else{
            System.out.println("Breakout Room was not closed");
        }
        
        
        //7.
        boolean openRoom;
        openRoom=system.openBreakoutRoom(1);
        
        if(openRoom==true){
            System.out.println("Breakout Room opened");
        }
        else{
            System.out.println("Breakout Room was not opened");
        }
        
        
        //8.
        String participantBreakoutRoom;
        participantBreakoutRoom=system.findParticipantBreakoutRoom("02131235");
        System.out.println("Participant's break out room number: "+participantBreakoutRoom);
        
        
        //9.
        String breakoutRoomList;
        breakoutRoomList=system.listAllBreakoutRooms();
        System.out.println("List of breakout rooms: \n");
        System.out.println(breakoutRoomList);
        
        
        //10.
        String participantList;
        participantList=system.listParticipantsInAllBreakoutRooms();
        System.out.println("List of participants: \n");
        System.out.println(participantList);
      
    
    }
    
    
    
}
