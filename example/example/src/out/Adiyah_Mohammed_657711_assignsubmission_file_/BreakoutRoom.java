package out.Adiyah_Mohammed_657711_assignsubmission_file_;
/**
 816014197
 */
public class BreakoutRoom 
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private  final int breakoutRoomSize;
    private int numberOfParticipants;
    private boolean open;
    private Participant[ ] participants;
    private int i;
   
    public BreakoutRoom(String name)
    {
      breakoutRoomID= "";
      breakoutRoomNumberCounter=0;
      breakoutRoomSize=10;
      numberOfParticipants=0;
      open= false;
      participants= new Participant[1000];
      i=0;
    }

    public boolean addParticipant( String participantID){
        Participant p = new Participant(participantID);
        
               
    for ( i=0; i<=numberOfParticipants; i++){
      if((participants[i].equals(participantID))&&(!p.verifyID(participantID))){
              return false;
      }  
      if(participants[i].equals(null) ){
           participants[numberOfParticipants+1]= p;  
      }
    } 
    return true;
           
  }
    
    public Participant findParticipant( String participantID){
         for( i=0; i<=breakoutRoomSize; i++){
               if(participants[i].equals(participantID)){
                    return participants[i];
                }
            }
        
          return null;
        
    }
    
    
    public String listParticipants( ){
        String participant=" ";
        for( i=0; i<=breakoutRoomSize; i++){
          participant=participant + participants[i];
                
            }
            return breakoutRoomID + participant;
    }
    
    public String toString( ) {
        
        return  breakoutRoomID + open + numberOfParticipants ;
    }
    
    public void closeBreakoutRoom( ){
        for( i=0; i<=breakoutRoomSize; i++){
               participants[i]= null;
                   
        }
        
            open = false;
        
    }
     public void openBreakoutRoom( ){
        if(open){
            open = true;
        }
    }
}
