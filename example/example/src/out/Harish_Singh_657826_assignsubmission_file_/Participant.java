package out.Harish_Singh_657826_assignsubmission_file_;//ID#816117713
public class Participant{
    private String participantID;
    
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        if(participantID.matches("[0-9]+") && participantID.length() == 8){
            return true;
    }else{
        return false;
    }
 }
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String participantDetails = "Participant: " + participantID; 
        return participantDetails;
    }
}
