package out.Christine_Ramdhanie_657773_assignsubmission_file_;//ID: 816018588
//NAME: CHRISTINE RAMDHANIE
//COMP 2603 - ASSIGNMENT 1 
 
public class Participant {
    private String participantID;
    public static int counter;
    
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        counter = Integer.parseInt(participantID);
        if ((counter >= 10000000 ) && (counter <= 99999999 ))
            return true;
            else  
            return false;
    }
    
    //Accessor
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String participantDetails= " ";
        participantDetails = "Participant: " + participantID;
        return participantDetails;
    }
}

/*Integer.parseInt was used to convert a String to integer to check
the number of digits within the ID.
The source used was: https://www.javatpoint.com/java-string-to-int
*/
