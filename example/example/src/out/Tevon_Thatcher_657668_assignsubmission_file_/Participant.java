package out.Tevon_Thatcher_657668_assignsubmission_file_;/**
 * @Tevon Thatcher - 816019492
 */

public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        // initialise instance variables
        this.participantID = participantID;
    }
   
    
    public static boolean verifyID(String participantID)
    {
        char[] charArr = new char[50];
        if(participantID != null && participantID.length() <= 8){
            char participant[] = participantID.toCharArray();
            for(int i=0; i < participantID.length();i++){
                charArr = participantID.toCharArray();
                if(charArr[i] < '0' || charArr[i] > '9')
                    return false;
            }
            return true;
        }
        else{
            return false;
        }
    }

    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
        String returnString = "Participant: " + participantID;
        return returnString;
    }
    
    public static void main(String args[]){
        Participant p = new Participant("1010");
        System.out.println(p.toString());
        
    }
}
