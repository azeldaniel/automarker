package out.Madeenah_Salamat_657821_assignsubmission_file_;// ID: 816020303

public class Participant{
    //attributes
    private String participantID;
    
    //constructor
    public Participant(String participantID){
        this.participantID = participantID;   
    }
    
    //methods
    public boolean verifyID(String participantID){
        int count = 0;
        
        for (int i = 0; i < participantID.length(); i++){
            count++;
        }
        
        if (count == 8){
            return true; //if the ID has 8 digits
        }
        else{
            return false; //if the ID does not have 8 digits
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