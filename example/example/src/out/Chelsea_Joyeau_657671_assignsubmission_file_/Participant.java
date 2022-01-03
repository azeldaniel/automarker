package out.Chelsea_Joyeau_657671_assignsubmission_file_;/**
 * Chelsea Joyeau ~ 816020515
 * Object Oriented Programming
 * Assignment 1.0 ~ Virtual Meeting
 */
public class Participant
{
    private String participantID;
    
    public Participant(String participantID)
    {
        this.participantID = participantID; 
    }
    
    /* Class method that validates that a non-null, participantID conforms to the required 
     * 8 digit format and returns true, otherwise false.
     */
    public static boolean verifyID(String participantID)
    {
       if ((participantID.length() == 8)){ // ParticipantID must conform to an 8 digit format
           try 
            { 
               Integer.parseInt(participantID); // Ensures the string contains only integers
               return true;
            }
            catch (NumberFormatException e) // ParticipantID is not valid
            { 
                System.out.println("\nThe Participant ID '" +participantID + "' Is Not Valid As It Contains Characters");
                return false;
            }      
       }
       else { // The participantID passed is not 8 digits in length
           System.out.println("\nThe Participant ID Must Be Of An 8-Digit Format");
           return false;
       }
    }
    
    public String getParticipantID()
    {
        return this.participantID;
    }
    
    public String toString()
    {
       String details = ("Participant: " +getParticipantID());
       return details;
    }
}
