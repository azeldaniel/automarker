package out.Joshua_Aird_657797_assignsubmission_file_;
public class BreakoutRoom 
{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0;
    private final int breakoutRoomSize;
    private  Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    
    public BreakoutRoom(String name)
    {
       breakoutRoomID=name + breakoutRoomNumberCounter;
       breakoutRoomNumberCounter++;
       breakoutRoomSize=10;
       participants = new Participant[breakoutRoomSize];
       numberOfParticipants=0;
       open=true;

        
    }

    
    public boolean addParticipant (String participantID)
    {
        if(numberOfParticipants==10){
            return false;
        }
        if( this.open=true ){
        if(numberOfParticipants<10 && verifyID(participantID)){
            participants[numberOfParticipants]=new Participant(participantID);
           numberOfParticipants++;
          
           return true;
        }
    }
        return false;
    }
    
    
    public Participant findParticipant(String participantID)
    {
        if(verifyID(participantID)==true && this.open){
            for(int i=0; i<numberOfParticipants; i++){
                if(participantID.equals(participants[i].getParticipantID())){
                    return participants[i];
                }
            }
        }
        return null;
    }
    
    public String listParticipants()
    {
        String details= "Breakout Room: " + breakoutRoomID + "\n";
        for(int i=0; i<numberOfParticipants; i++){
                details += participants[i].toString();
            }
            return details;
    }
   
    public String toString() {
        String details = breakoutRoomID + " " + "BreakRoom NumberCounter:" +  breakoutRoomNumberCounter + " " + "Number of Participant:" + numberOfParticipants
       + " " +"OPEN:" +  this.open + "\n" ;
       return details;
    }
    
    public void closeBreakoutRoom(){
        this.open=false;
        for (int i=0; i<numberOfParticipants; i++)
            participants[i]=null;
        numberOfParticipants=0;
       
        
    }
    
    
    public void openBreakoutRoom(){
        this.open=true;
        
    }
    
    public boolean verifyID(String participantID){
       int length= participantID.length();
       if(length!=8){
         return false;   
        }
        else {
        return true;
        }
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public int getNumberOfParticipants(){
        return  numberOfParticipants;
     }
        
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    
}
