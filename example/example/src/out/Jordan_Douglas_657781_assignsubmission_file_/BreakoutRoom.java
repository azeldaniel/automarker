package out.Jordan_Douglas_657781_assignsubmission_file_;// Name: Jordan Douglas ID: 816022324

public class BreakoutRoom{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=1;
    private final  int breakoutRoomSize;
    private Participant []participants; 
    private int numberOfParticipants; 
    private boolean open;
    
    public BreakoutRoom(String name){
       breakoutRoomID= name + breakoutRoomNumberCounter;
       breakoutRoomNumberCounter++;
        breakoutRoomSize=10;
        participants= new Participant[breakoutRoomSize];
        numberOfParticipants=0;
        open=true;
    }
    
    public boolean addParticipant(String participantID){
        if(Participant.verifyID(participantID)== false){
            return false; 
        }
        if(numberOfParticipants>0){
        for(int i =0;i<numberOfParticipants;i++){
            if(participants[i].getParticipantID().equals(participantID)){
                return false;            }
        }
    }
        if(open==false){
            return false;
        }
        
        if(numberOfParticipants==10){
            return false;
        }
        Participant p= new Participant(participantID);
        participants[numberOfParticipants]= p;
        numberOfParticipants++;
       
        return true; 
    }
    public Participant findParticipant(String participantID){
        if(Participant.verifyID(participantID)== false||open==false){
            return null; 
        }
        else{
            for(int i=0;i<numberOfParticipants; i++){
                if(participants[i].getParticipantID().equals(participantID)){
                    return participants[i];
                }
                
            }
        }
        return null;
    }
    public String listParticipants(){
        String list="Room ID; "+breakoutRoomID+ "\n";
        
        for(int i=0;i<numberOfParticipants;i++){
            list+= participants[i].getParticipantID() + "\n";
        }
        list+= "____________________________________ \n";
        return list; 
    }
    
    public String toString(){
        String state= "Breakout Room ID: " + breakoutRoomID;
        state +="\nCounter: " + breakoutRoomNumberCounter;
        state +="\nRoom Size: " + breakoutRoomSize;
        state +="\nNumber of participants: " + numberOfParticipants;
        state +="\nOpen: " + open;
        return state; 

    }
  public void closeBreakoutRoom(){
      this.open= false;
      for(int i =0;i<numberOfParticipants;i++){
        participants[i]=null; 
        }
      this.numberOfParticipants=0;
      
      
    }
  public void openBreakoutRoom(){ 
    this.open=true;
    
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
    }