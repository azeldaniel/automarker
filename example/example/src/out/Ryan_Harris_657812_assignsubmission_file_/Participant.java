package out.Ryan_Harris_657812_assignsubmission_file_;/*
 * 
 * ID: 816021062
 * Name: Ryan Harris
 * 
 */
public class Participant
{
    
    private String participantID;
    
    public boolean verifyID(){
        if (participantID == null) return false;
        if (participantID.length() != 8) return false;
        if (!participantID.matches("[0-9]+")) return false;
        return true;
    } 
    
    public boolean verifyID(String participantID){
        
        if (participantID == null) {System.out.println("null"); return false;}
        if (participantID.length() != 8) {System.out.println("null"); return false;}
        if (!participantID.matches("[0-9]+")) {System.out.println("null"); return false;}
        return true;
    }                
               
    public Participant (String participantID){
        if (verifyID(participantID)){
            this.participantID = participantID;
            //System.out.println("Participant HTIWEDN" + this.participantID);
        }else{
            //System.out.println("Non-Verified ID: " + participantID);
            this.participantID = null;
        }
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String str = "Participant: " + participantID;
        return str;
    }
    
}
