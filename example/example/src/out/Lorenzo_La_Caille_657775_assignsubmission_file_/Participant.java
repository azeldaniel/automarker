package out.Lorenzo_La_Caille_657775_assignsubmission_file_;//816015560
public class Participant
{
    
    private String participantID;

    
    public Participant(String participantID)
    {
        this.participantID=participantID;   
       
    }
    

    
    public static boolean verifyID(String participantID)
    {
        int data=participantID.length();
        if(data==8){
            return true;
        }else{
            return false;
        }
       
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String participantInfo = " Participant: " + participantID;
        return participantInfo;
    }
}
    