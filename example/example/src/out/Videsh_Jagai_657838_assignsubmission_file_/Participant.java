package out.Videsh_Jagai_657838_assignsubmission_file_;
/**
 * Name: Videsh Jagai..
 *
 * Student ID: 816014860..
 * 
 * 
 */

public class Participant{
    // instance variables - replace the example below with your own
    private String participantID;
    
    public Participant(String participantID)
    {
        this.participantID = participantID;
    }
    
    // Class method that validates that a non-null,participantID conforms to the required 8 digit
    //format and returns true, otherwise false..
    public static boolean verifyID(String participantID)
    {
        // Base scenarios of verrifying participant ID 
      int lenParID = participantID.length();  
      if(participantID == null || lenParID!=8)
       {
       return false;
       }
     
       
        for ( int j=0; j<lenParID;j++)
       { // isDigit in bulit-function checks whether the respective string meets the requirements.
          if(Character.isDigit(participantID.charAt(j)))   
          {
          return true; 
          } 
       
       }
      return false;
      
    }
    
    // Accessor for a participant’s ID
    public String getParticipantID()
    {
        return participantID;
    }
    
    //Returns a String representation of the state of a 
    // the state of a Participant formatted as follows: 
    // Participant: participantID
    
    public String toString()
    {
        String PartIDDetails= "ParticipantID: "+ participantID; 
        
        return PartIDDetails;     
    }
}
