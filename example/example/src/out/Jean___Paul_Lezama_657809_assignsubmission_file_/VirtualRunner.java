package out.Jean___Paul_Lezama_657809_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRunner
{
    
    public static void main(String[] args){
        VirtualMeetingSystem VM = new VirtualMeetingSystem();
        //1
        VM.loadParticipantData("participant.dat");

        //2.
        VM.createVirtualRoom("Conferance");
        
        //3
        VM.allocateParticipants("C5");
       
       //5
       System.out.println("All participants in Conference: " +VM.listParticipants(3)); 
          
       //8
       System.out.println(VM.findParticipantBreakoutRoom("99880522"));
       System.out.println("");
       //9
       System.out.println(VM.listAllBreakoutRooms());
       //10
       System.out.println(VM.listParticipantsInAllBreakoutRooms());
           
       //6
       VM.closeBreakoutRoom(1);
       System.out.println(VM.listAllBreakoutRooms());
       
       //7
       VM.openBreakoutRoom(1);
       System.out.println(VM.listAllBreakoutRooms());
       
       
       //4
        System.out.println("Adding 69696969 to a breakout room..........");
        if(VM.addParticipant("69696969",1)){
        System.out.println("Added Successfully");
        }
        else
        System.out.println("Not added");
        
       
    }
}
