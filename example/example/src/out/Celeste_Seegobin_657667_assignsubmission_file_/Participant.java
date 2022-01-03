package out.Celeste_Seegobin_657667_assignsubmission_file_;//Celeste Seegobin - 816019646
public class Participant{
    private String participantID;
    
    //Constructor 
    public Participant(String participantID){
        //ID must be of a 8 digit format.Therefore we must verify;
        this.participantID = participantID;
        int ID;
        boolean verify = false;
        verify = verifyID(participantID);
        if(verify == true){
            //Changing ParticipantID to integer value;
            ID = Integer.parseInt(participantID);
        
    }
}
    
public static boolean verifyID(String participantID){
        int length = participantID.length();
        if(length>=8){
            for(int i=0; i<=length; i++){
                    return false;
                }
                return true;
            }
            return false;
  }
    
public String getParticipant(){
        return participantID;
 }
    
public String toString(){
        String details = "Participant"+participantID;
        return details;
    }
    
public String getparticipantID(){
        return participantID;
}
}
        
        
    
    
