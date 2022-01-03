package out.Harish_Singh_657826_assignsubmission_file_; //ID#816117713
public class BreakoutRoom{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private int numberOfParticipants;
    private final int breakoutRoomSize = 10;
    private Participant[] participants = new Participant[breakoutRoomSize];
    private boolean open;
    
    public BreakoutRoom(String name){
        this.breakoutRoomID = name;
        openBreakoutRoom();
        
    }
    
    public boolean addParticipant(String participantID){
        Participant x = new Participant(participantID);
        int count=0;
        int index;
        for(int i = 0;i<participants.length;i++){
            if(participants[i]!=null){
                count++;
            }
          }
        if(count==participants.length){
          return false;
        }else{
            index = count;
        }
        
        for(int o=0;o<numberOfParticipants;o++){
            if(participants[o].getParticipantID()==participantID){
                return false;
            }
        }
        
        if(Participant.verifyID(x.getParticipantID())==true && open == true){
            participants[index] = x;
            numberOfParticipants = numberOfParticipants+1;
            return true;
        }else{
            return false;
        }
        
    }
    
    public Participant findParticipant(String participantID){
        if(Participant.verifyID(participantID)==true && open == true ){
            for(Participant x : participants){
                if(x.getParticipantID() == participantID){
                    return x;
                }
        }
    }
            return null;
   }
   
   public String listParticipants(){
       String list = breakoutRoomID + "\n";
       
       for(Participant x : participants){
           if(x!=null){
               list += x.getParticipantID() + "\n";
               
        }
    }
       return list;
       
    }
   
    
    public String toString(){
        String state;
        int numP=0;
        if(open==true){
            state = "OPEN"; 
        }else
            state ="CLOSE";
        for(Participant x : participants ){
            if(x!=null){
                numP+=1;
            }
        }
        return(breakoutRoomID + " " + state + " "+ numP );
    }
    
    public void closeBreakoutRoom(){
        this.open = false;
        participants = new Participant[breakoutRoomNumberCounter];
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }
    
    public String getBreakoutRoomID(){
        return this.breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return this.numberOfParticipants;
    }
    
    public boolean getOpen(){
        return this.open;
    }
    
    
    
       
}

    
    
    
    
    
                
