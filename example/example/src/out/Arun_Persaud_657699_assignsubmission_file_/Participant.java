package out.Arun_Persaud_657699_assignsubmission_file_;//Arun Persaud 816019788
public class Participant{
    private String participantID;
    private int pcount; 
    
    public Participant(String participantID){
      this.participantID = participantID; 
    }    
 
    public boolean verifyID(String participantID){
       pcount = participantID.length();
       if(pcount == 8){
           return true;
        }else{
           return false;
        }
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String details = "Participant: " + participantID;
        return details;
    }
}
