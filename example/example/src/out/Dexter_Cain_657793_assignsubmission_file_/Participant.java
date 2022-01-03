package out.Dexter_Cain_657793_assignsubmission_file_;/* The University of the West Indies St. Augustine Campus
    COMP2603 2021 S2
    Assignment1
    NAME: Dexter Cain
    ID: 816021817
    
    SUBMISSION #2
    
    PLEASE WATCH DEMO VIDEO: https://drive.google.com/file/d/17CVyw-Nj3GWwAEHrx-DkVL_CRC5LAxaN/view?usp=sharing
*/

public class Participant {
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */

    // Empty constructor
    public Participant() {
    }

    // Overloaded constructor
    public Participant(String participantID) {
        this.participantID = participantID;
    }

    // Class method that validates that a non-null, participantID conforms to the
    // required 8 digit format and returns true, otherwise false.
    public static boolean verifyID(String participantID) {

        if (participantID == null) {
            return false;
        }
        int idLength = participantID.length();
        if (idLength != 8) {
            return false;
        }

        for (int i = 0; i < idLength; i++) {
            if (Character.isDigit(participantID.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // Accessor for a participant’s ID
    public String getParticipantID() {
        // System.out.println("Returning "+ participantID);
        return participantID;
    }

    // Returns a String representation of the state of a Participant formatted as
    // follows: Participant: participantID
    public String toString() {
        String participantState = "";
        participantState += "Participant: " + participantID + "\n";

        return participantState;
    }

}
/*
 * REFERENCES
 * https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/
 * 
 */
