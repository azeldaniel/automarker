package out.Jeremy_De_Freitas_657820_assignsubmission_file_;//816018479
public class Participant
{
    private String participantID;
  
    public Participant(String participantID) //constructor
    {
       this.participantID = participantID; 
    }
    
     public String getParticipantID()
     { //Accessor for a participant’s ID
         String ID = this.participantID;
        return ID;
    }
    
    public static boolean verifyID(String participantID)
    {
        int strlen;
        strlen = String.valueOf(participantID).length(); 

            if(participantID != null && strlen == 8){ 
                    return true;
            }
            System.out.println("Invalid ID. Please make sure ID is of size 8.");
            return false;
            
    }
    
        public String toString(){
        String participantDetails;
        if(verifyID(participantID)!=true){
            return participantDetails=("ID is invalid...");
        }
        else{
            participantDetails = "Participant: "+ participantID;
            return participantDetails;
        }
    }

}    
