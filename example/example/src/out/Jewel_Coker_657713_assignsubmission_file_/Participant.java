package out.Jewel_Coker_657713_assignsubmission_file_;// ID : 816014352
public class Participant
{
   private String participantID;
   
    public Participant(String participantID)
    {
        this.participantID = participantID;
    }
    
    public static  boolean verifyID(String participantID){
        if(participantID!=null){
            if(participantID.length()==8){
               
                return true;
            }
        }
        return false;
    }
   
    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
    return "Participant: " + participantID;
    }
}
