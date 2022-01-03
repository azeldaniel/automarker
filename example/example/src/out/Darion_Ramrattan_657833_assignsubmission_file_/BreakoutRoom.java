package out.Darion_Ramrattan_657833_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (816018746)
 * @version (a version number or a date)
 */
public class BreakoutRoom  
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID; // room name + room number 
    private static int breakoutRoomNumberCounter=0;
    private final  int breakoutRoomSize; 
    private Participant[] participants = new Participant [10]; 
    private int numberOfParticipants; 
    private boolean open; 
    
    public  BreakoutRoom (String name){ 
      this.breakoutRoomSize = 10; 
      breakoutRoomNumberCounter++; 
      numberOfParticipants= 0; 
      open = true; 
      breakoutRoomID= name + breakoutRoomNumberCounter; 
    
    }
    
   public String getBreakoutRoomID(){
        return breakoutRoomID;
   }
    
   public int getNumberOfParticipants(){
     return numberOfParticipants;
   }
   
   public boolean getOpen(){
     return open;  
    }
    
   
    public boolean addParticipant(String participantID) {
    //    boolean a = verifyID(participantID) ;
        Participant t = new Participant(participantID);
        if(t.verifyID(participantID)){ 
             
            if(numberOfParticipants != 10){
           // Participant p1 =  new Participant (participantID);
           // participants[numberOfParticipants] = null;
       //    System.out.println("Verify ID");
            participants[numberOfParticipants] = new Participant (participantID);
            numberOfParticipants++;
            return true; 
           }
          
        }
        
    return false;

    }
    
    public Participant findParticipant(String participantID){
        Participant find = new Participant(participantID); 
        String t = ""; 
        for(int i =0; i<breakoutRoomSize; i++){
            
            t=participants[i].getParticipantID(); 
           // System.out.println("Participant Found!");
            if((t).equals(participantID)){
                return find; 
      
            }
         
    } 
    return null;
    }

    public String listParticipants() { 
        String numparticipants=""; 
        String pID=""; 
        
        for(int i =0; i<breakoutRoomSize; i++){
          try{
            pID= participants[i].getParticipantID(); 
          
            numparticipants += pID + " "; 
        }
        catch(NullPointerException e){
           // System.out.println("NullPointerException !");
        }
        
    }
        return numparticipants; 
    } 
    
    public String toString(){
        String details =""; 
        String open = "Close";
        
        if(getOpen() == true){
            open = "Open";
        }
        details += breakoutRoomID +" " + open + " " + numberOfParticipants; 
        return details; 
    } 
    
    public void closeBreakoutRoom(){
        
        open= false; 
        
        for(int i =0; i<numberOfParticipants; i++){
            participants[i] = null; 
             
        }
        numberOfParticipants = 0; 
    } 
    
    public void openBreakoutRoom(){ 
        open = true; 
    } 
}