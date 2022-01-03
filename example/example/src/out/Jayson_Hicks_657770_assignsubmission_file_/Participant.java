package out.Jayson_Hicks_657770_assignsubmission_file_;//Student ID:816000935
public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;
    
    
    Participant(String participantID){
        
        this.participantID = participantID;
        
    }
    
    Participant(){
        
        
        
    }
    public static boolean verifyID(String participantID){
        if (participantID == null){
            return false;
        }
        else if (participantID.length()==8){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getParticipantID(){
        return participantID;
                
    }
    @Override
    public String toString(){
        return "Participant: "+participantID;
        
    }
}