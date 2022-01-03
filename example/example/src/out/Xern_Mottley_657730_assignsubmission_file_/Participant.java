package out.Xern_Mottley_657730_assignsubmission_file_;
//816019358
public class Participant
{
    private String participantID;

    
    public Participant(String participantID)
    {
        this.participantID=participantID;
    }
    
    public static boolean verifyID(String participantID){
        int length;
        if(participantID!=null){
            length= participantID.length();
            if(length!=8){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String details= "Participant: "+participantID  ;
        return details;
    }
}
