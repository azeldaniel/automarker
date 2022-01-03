package out.Dexter_Cain_657793_assignsubmission_file_;/* The University of the West Indies St. Augustine Campus
    COMP2603 2021 S2
    Assignment1
    NAME: Dexter Cain
    ID: 816021817 
    
    SUBMISSION #2
    
    PLEASE WATCH DEMO VIDEO: https://drive.google.com/file/d/17CVyw-Nj3GWwAEHrx-DkVL_CRC5LAxaN/view?usp=sharing
*/

public class BreakoutRoom {
    private String breakoutRoomID; // Unique identifier for a breakout room in the virtual system formed by the
                                   // combination of the virtual room name and a unique room number
    private static int breakoutRoomNumberCounter = 0; // A class variable for producing unique integer values used in
                                                      // creating breakoutRoomID values
    private final int breakoutRoomSize; // A constant that specifies the maximum number (10) of participants
                                                    // allowed in a breakout room
    private Participant[] participants; // A list of participants who have been added to the breakout room
    private int numberOfParticipants; // Keeps track of the number of participants in the breakout room
    private boolean open; // A flag for tracking whether the breakout room’s state is open or closed
    private int breakoutRoomNumber; // Used to hold the breakoutRoom number in each breakoutroom instance

    /*
    // empty constructor created for BreakoutRoom
    public BreakoutRoom() {

   }
   */

    // constructor created for BreakoutRoom
    public BreakoutRoom(String name) {
        numberOfParticipants = 0;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        breakoutRoomNumberCounter++;
        breakoutRoomNumber = breakoutRoomNumberCounter;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        open = true;
    }

    // Accessor for the breakoutRoomNumberCounter
    public int getBreakoutRoomNumberCounter() {
        return breakoutRoomNumberCounter;
    }

    // Accessor for the breakoutRoomNumber
    public int getBreakoutRoomNumber() {
        return breakoutRoomNumber;
    }

    // Accessor for the breakoutRoomID
    public String getBreakoutRoomID() {
        return breakoutRoomID;
    }

    // Accessor for the numberOfParticipants
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    // Accessor for open boolean variable
    public boolean getOpen() {
        return open; // return whether or not room is open
    }

    // Method invokes the verifyID static method in the Participant class
    public boolean verifyParticipantID(String participantID) {
        return Participant.verifyID(participantID);
    }

    // Adds a new participant (no duplicates) with a valid ID to the (open) breakout
    // room if the room is not filled and then returns true, otherwise returns false
    public boolean addParticipant(String participantID) {
        if (participantID == null) {
            System.out.println("Error...participant ID is null.");
            return false;
        }

        // check to ensure that supplied participantID doesn't already exist
        for (int i = 0; i < numberOfParticipants; i++) {
            if (participants[i].getParticipantID().equals(participantID)) {
                System.out.println("Error...the supplied participant ID already exists.");
                return false;
            }

        }

        // verify the participantID conforms to a 8 digit format
        if (verifyParticipantID(participantID) == false) {
            System.out.println("The supplied participant ID is invalid.");
            return false;
        }

        // check number of participants in breakout room to ensure that it not full
        if (numberOfParticipants >= 10) {
            System.out.println("Breakout room is full...this participant cannot be added to room.");
            return false;
        }

        // add participant if the breakout room is open
        if ((getOpen() == true)) {
            participants[numberOfParticipants] = new Participant(participantID);
            System.out.println("Added " + participants[numberOfParticipants].toString());
            numberOfParticipants++;
            return true;

        }

        return false;
    }

    // Locates and returns a participant based on a supplied (valid) ID if present
    // in the (open) breakout room, otherwise returns null.
    public Participant findParticipant(String participantID) {
        if ((getOpen() == true) && (Participant.verifyID(participantID) == true)) {
            for (int i = 0; i < breakoutRoomSize; i++) {
                if ((participants[i].getParticipantID() != null) &&participantID.equals(participants[i].getParticipantID())) {
                    return participants[i];
                }

            }
        }

        return null;
    }

    // Returns a list of the participants (ID) in the breakout room with the
    // breakout room ID heading the list on a separate line
    public String listParticipants() {
        String details = "";
        details += "Breakout room ID: " + breakoutRoomID + "\n";

        if (numberOfParticipants == 0) {
            details += "There is no participant in this breakout room." + "\n";
        }

        for (int i = 0; i < numberOfParticipants; i++) {
            details += participants[i].toString() + "\n";
        }
        return details;
    }

    // Returns a String representation of the aggregated state of a BreakoutRoom
    public String toString() {
        String details = "";
        details += breakoutRoomID;
        if (getOpen() == true) {
            details += " OPEN ";
        } else {
            details += " CLOSED ";
        }
        details += numberOfParticipants;
        return details;
    }

    // Closes the breakout room, clears the participant list and resets any relevant
    // state of the breakout room
    public void closeBreakoutRoom() {
        numberOfParticipants = 0;
        open = false;
        System.out.println(breakoutRoomID + " is now CLOSED.");
    }

    // Opens the breakout room and sets the state as open
    public void openBreakoutRoom() {
        open = true;
        System.out.println(breakoutRoomID + " is now OPEN.");
    }

}
