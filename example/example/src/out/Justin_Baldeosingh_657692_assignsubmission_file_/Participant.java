package out.Justin_Baldeosingh_657692_assignsubmission_file_;/* Justin Baldeosingh
 * 816021226
 * COMP 2603 - OOP
 * Assignment 1
 */

//Partcipant Class
public class Participant{
    //Declares a string variable to store the participant ID of a participant object.
    private String participantID;
    
    //The Participant Construction takes a participant ID and initializes a new Participant instance
    //with that ID.
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    //Class method that is used to determine if a Participant ID meets its validated criteria.
    public static boolean verifyID(String participantID){
        //Ensures that the participant ID is non null.
        if(participantID == null){
            System.out.println("ID is null!");
            return false;
        }
        //Determines if the length of the participant's ID is 8 characters long.
        if(participantID.length() == 8){
            //Iterates over each of the characters in the ID and ensures that they are all digits.
            for(int i = 0; i < 8; i++){
                //If the character at the current iterating position is not a digit, return false.
                if(!(Character.isDigit(participantID.charAt(i)))){
                    return false;
                }   
            }
            //Otherwise, return true as they were all validated as digits.
            return true;
        } else {
        //If the length of the participant's ID is not 8 characters long, return false.
            return false;
        }
    }
    
    //Gets and returns the participant's ID.
    public String getParticipantID(){
        return this.participantID;
    }
    
    //Returns the details of the Participant.
    public String toString(){
        return "Participant: " + this.participantID;
    }
}

/*
References:
GeeksforGeeks. "How to check if string contains only digits in Java", (July 2020), https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/
*/