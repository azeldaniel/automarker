package out.Adrian_Khan_657741_assignsubmission_file_;
/*
 * StudentID: 816020488
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
        if(participantID == null){
            return false;
        } else if(participantID.length() == 8){
            for(int i = 0; i <= participantID.length(); i++){
                if(participantID.charAt(i) >= '0' && participantID.charAt(i) <= '9'){
                    return true;
                }
            } 
        } else {
            System.out.println(participantID + " is invalid!");            
            return false;
        }
        return false;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public String getParticipantID()
    {
        return participantID;
    }
    
    public String toString()
    {
        String details = "Participant: " + participantID;
        return details;
    }    
}
//Sources: 
//Lab 2
//https://www.w3schools.com/java/ref_string_length.asp
//https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/
//https://howtodoinjava.com/java/string/always-use-length-instead-of-equals-to-check-empty-string-in-java/
