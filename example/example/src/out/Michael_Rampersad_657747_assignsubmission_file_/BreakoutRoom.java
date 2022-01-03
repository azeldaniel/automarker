package out.Michael_Rampersad_657747_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom
{ 
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private Participant participants[];
    private int numberOfParticipants;
    private boolean open;

    
    public BreakoutRoom(String name){
        this.breakoutRoomID = name;
    }
    
    public boolean addParticipant(String participantID){
       
           
        
        return true;
    }
    
   // public Participant findParticipant(String participantID){
   
    //    return blank;
   // }
    
  // public String listparticipants(){
   //    
   //}
    
   // public String toString(){
   // }
    
    public void closeBreakoutRoom(){
     this.open = false;
   }
    
    public void openBreakoutRoom(){
     this.open = true;
    }
    
    
}

