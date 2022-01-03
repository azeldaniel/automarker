package out.Dhanesh_Sankar_657707_assignsubmission_file_;/**
Dhanesh Sankar
816020350
 */
public class Participant
{
    //an 8 digit binary format
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String ParticipantID){
        this.participantID = ParticipantID;
    }
    
     public String getParticipantID(){    
        return this.participantID;
    }
    
    public static boolean verifyID(String participantID){
        int IDlength=0;
        
        IDlength = String.valueOf(participantID).length();
        
        if((participantID!=null) && (IDlength==8)){
            return true;
            //ID is valid
        }            
        System.out.println("ID is invalid.");
        return false;            
            //ID is invalid
    }
    
    /**
     * Returns a String representation of the state of a
     * Participant formatted as follows:
     * Participant: participantID
     */
    public String toString(){
        String participantDetails;
        if(verifyID(participantID)!=true){
            return participantDetails=("ID invalid.");
        }
        else{
            participantDetails = "Participant: "+ participantID;
            return participantDetails;
        }
    }
}