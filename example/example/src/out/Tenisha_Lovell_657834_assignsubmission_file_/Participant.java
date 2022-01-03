package out.Tenisha_Lovell_657834_assignsubmission_file_;/*816008740 Tenisha Lovell*/
public class Participant{
    
    private String participantID;
    
    public Participant(String participantID){
            this.participantID = participantID;
    }

    public static boolean verifyID(String participantID){
      /*  if(participantID.length() == 8)
            return true;
        else
            return false;*/
    if(participantID.length() != 8 || participantID == null) 
     return false;
    
    if(participantID.length() == 8){
        for(int i=0; i<participantID.length(); i++){
           // System.out.println("1");
            if(Character.isLetter(participantID.charAt(i)))
                return false;
        }
    }
    return true;
    
}
    
    
    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
        return "Participant: " + participantID;
    }
} 