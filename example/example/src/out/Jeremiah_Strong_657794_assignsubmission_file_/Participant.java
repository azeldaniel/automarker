package out.Jeremiah_Strong_657794_assignsubmission_file_;//* @author (Jeremiah Strong)
// * @ID: 816023620


public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;
    
    public Participant(String ID)
    {
        participantID= ID;
    }
    
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        int d = Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
    }
    
    public static boolean verifyID(String ID){
        
        String length="" + ID.length();
        boolean numericCheck = isNumeric(ID);
        
        if( numericCheck==false){
            System.out.println("Invalid ID. The ID, '" + ID + "' does not consist of only digits.");
            return false;
        }
        
        
        if(length.equals("8") && ID!= null){
            
            return true;
        }
        else{
            
            System.out.println("Participant ID, " + ID +", is invalid.");
            return false;
        }
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String info= " Participant: " + participantID;
        return info;
    }

    
}
