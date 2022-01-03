package out.Jonathan_Hoyte_657737_assignsubmission_file_;
// 816013096
public class Participant
{
    
    private String participantID;
    
    public Participant(String participantID)
    {
        setParticipantID(participantID);
    }
    
    public void setParticipantID(String particpantID){
     this.participantID = participantID;
    }
    
    public boolean verifyID(String participantID){ 
        if(participantID != "" && participantID.length()<9 &&participantID.length()>7){
        return true;
     }else{return false;
      }
    }
    
    public String getParticipant(){
    return participantID;
    }
    
    public String toString(){
    return "Participant :" + participantID;
    }
} 
