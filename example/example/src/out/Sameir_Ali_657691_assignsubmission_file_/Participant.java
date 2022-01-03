package out.Sameir_Ali_657691_assignsubmission_file_;//Student ID#: 816022840
public class Participant{
    private String participantID;
    
    public Participant(String participantID){
        if(Participant.verifyID(participantID) == true)
            this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        if(participantID != null && participantID.length() == 8)
            return true;
        return false;
    }
    
    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
        return("Participant: " + this.participantID);
    }
}

//Resources used for this class: 
//Lecture notes