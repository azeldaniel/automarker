package out.Dexter_Singh_671780_assignsubmission_file_;//816009215
public class VirtualRunner
{
    public static void main(String[] args){
        //2.create virtual room
        VirtualMeetingSystem system = new VirtualMeetingSystem("Workshop");
        
        //1.load participant data
        system.loadParticipantData("participant.dat");
        
        //3.allocate participants C5
        system.allocateParticipants("C5");
        
        //3.allocate participants RR
        /*participants need to be removed before allocating again so C5 method stays until breakout 
         rooms are closed*/
        system.allocateParticipants("RR");
                
        //4. add new participant to a breakout room
        if(system.addParticipant("80001111", 6))
            System.out.println("Participant sucessfully added");
        else 
            System.out.println("Participant NOT added. Room is either FULL or DOES NOT EXIST");
         
        //5. Display a list of all participants in a breakout room
        if(system.listParticipants(0)==null)
            System.out.println("No participants found");
        else
            System.out.println(system.listParticipants(0));
         
        //6. Close a breakout room based on a room number
        if(system.openBreakoutRoom(3))
            System.out.println("Workshop3 opened");
        
        //7. Open a breakout room based on a room number
        if(system.closeBreakoutRoom(1))
            System.out.println("Workshop1 closed");
      
        //8. Find a participant’s breakout room number
        System.out.println("Room found for 84528887:" + system.findParticipantBreakoutRoom("84528887"));      
       
        //9. Display a list of all breakout rooms managed by the system
        System.out.println(system.listAllBreakoutRooms());
                
        //10. Display a list of all breakout rooms managed by the system and the participants in each room
        if(system.listParticipantsInAllBreakoutRooms()==null)
            System.out.println("Error.... no participants found");
        else
            System.out.println(system.listParticipantsInAllBreakoutRooms());//if a room/workshop was removed so it should print as null
        
    }
}
