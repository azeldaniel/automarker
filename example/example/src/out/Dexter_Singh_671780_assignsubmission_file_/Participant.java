package out.Dexter_Singh_671780_assignsubmission_file_;
// 816009215 
public class Participant
{
    private String participantID;
    
    public Participant(String participantID)
    {
       this.participantID = participantID;
    }
    
    //methods-behaviours
    public boolean verifyID(String participantID){
        return (String.valueOf(participantID).length() == 8); 
        // calls participantID and finds the length before determining if it is 8 digits 
        //thus should be a valid ID if length == 8 
    }
    
    //Accessor
    public String getParticipantID(){
        return this.participantID;
    }

    public String toString(){
        return "Participant:" + this.participantID;
    }   
    
}

/*Sources:
  Number of Digits in an Integer in Java: https://www.baeldung.com/java-number-of-digits-in-int
  Lecture Notes
   */
