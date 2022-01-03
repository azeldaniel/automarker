package out.Brandon_James_657851_assignsubmission_file_;
/**
 *
 * @815006970 (ID)
 */
public class Participant
{
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        this.participantID = participantID;
    }

    
    public static boolean verifyID(String participantID)
    {
       if(participantID == null){
            System.out.println("participantID is null!");
            return false;
       }
       if(participantID.length() != 8){
            System.out.println("participantID must be 8 digits long.");
            return false;
       }
       if(isNumber(participantID) == false){
            System.out.println("participantID is not a number!");

       }    
       return true;
    }
    //Accessor
    public String getParticipantID(){
        return participantID;
    }
   
    public String toString(){
        String s = "Participant: "+participantID + "\n";
        return s;
    }

    //checks if string is parsable as integer
    public static boolean isNumber(String s){
        try {
            int x = Integer.parseInt(s);
        } catch (NumberFormatException e) { //does nothing with exception message
            return false;
        }
        return true;
    }
    
} //end of class
/* Sources:
 * https://www.baeldung.com/java-check-string-number
 *   
*/
