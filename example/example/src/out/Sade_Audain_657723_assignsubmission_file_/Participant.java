package out.Sade_Audain_657723_assignsubmission_file_;/*
COMP 2603 Object Oriented Programming 1
Assignment 1
2020/2021 Semester 2

STUDENT NAME: Sade Audain
ID: 816013000
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

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   
    //Method that check to make sure participantID is 8 digit
    public static boolean verifyID(String participantID){
        //Check to make sure participantID is 8 digit
        
        if (participantID == null){
                return false;
            }
       
        if (participantID.length() != 8) {
            return false;
        }

        for(int i=0; i<participantID.length(); i++){
            if(Character.isDigit(participantID.charAt(i))==true){
                return true;
            }
        }
        return false;
    }
    
    //Accessor for a participant's ID
    public String getParticipantID(){
        return participantID;
    }
    
    // Returns participant ID
    public String toString(){
        String details = "Participant: " + participantID;
        return details;
    }
}
//Resources:https://www.tutorialspoint.com/check-if-the-string-contains-only-unicode-letters-or-digits-in-java#:~:text=To%20check%20whether%20a%20String,a%20letter%20or%20a%20digit.