package out.Jewel_Coker_657713_assignsubmission_file_;// ID : 816014352
public class BreakoutRoom
{
    private String breakoutRoomID; 
    private static int breakoutRoomNumberCounter=1; 
    private final int breakoutRoomSize=10;
    private Participant [] participants = new Participant[breakoutRoomSize];
    private int numberOfParticipants = 0;
    private boolean open=true; 
    
    public BreakoutRoom(String name)
    {
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
       
        breakoutRoomNumberCounter ++;
       
    }
    
    public boolean addParticipant(String participantID){
        if(this.open==true && Participant.verifyID(participantID  )==true){
           if(numberOfParticipants == breakoutRoomSize  ){
               
            return false;
           }
           
            participants[numberOfParticipants] = new Participant(participantID);
            numberOfParticipants ++;
            return true;
        }
       
       return false;
    }
    
    public Participant findParticipant(String participantID){
        String foundParticipantId;
        for (int i = 0; i < numberOfParticipants ; i++){
          if(open==true){
            foundParticipantId = participants[i].getParticipantID();  
            if(foundParticipantId.equals(participantID)){
                return participants[i];
            }
         }
          
        }
         return null; 
    }
    
    public String listParticipants(){
        String participantList = "Breakout Room: "+ breakoutRoomID +"\n";
        for(int x=0; x< numberOfParticipants; x++){
             participantList+= participants[x].toString() + "\n";
         
          }
        return participantList;
        }
       
    public int getNumberOfParticipants(){
       return this.numberOfParticipants;
    }
        
        
      public String toString(){
       if(open==true){
        return "Breakoutroom"+this.breakoutRoomID +"hosting "+numberOfParticipants+ " participants and currently open";
        } 
        return "Breakoutroom"+this.breakoutRoomID+" currently closed, no participants";
       }
       
       public void closeBreakoutRoom(){
        this.open= false;
        this.numberOfParticipants=0;
       
        }
        
        public void openBreakoutRoom(){
            this.open=true;
        }
        
        public boolean getOpen(){
            boolean open=false;
            if(this.open==true){
                open=true;
            }
            return open;
        }
        
        public String getBreakoutRoomID(){
            
            return this.breakoutRoomID;
        }
}
