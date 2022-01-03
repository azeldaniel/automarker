package out.Sade_Audain_657723_assignsubmission_file_;
/*
COMP 2603 Object Oriented Programming 1
Assignment 1
2020/2021 Semester 2

STUDENT NAME: Sade Audain
ID: 816013000
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    private int number;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variable
        numberOfParticipants = 0;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        breakoutRoomNumberCounter++;
        number = breakoutRoomNumberCounter;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        open = true;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getBreakoutRoomID(){
        //Accessor for a breakout room ID

        return this.breakoutRoomID;
    }

    public int getRoomNumber(){
        return number;
    }

    public int getBreakroomNumberCounter(){
        return breakoutRoomNumberCounter;
    }

    public int getNumberOfParticipants(){
        //Accessor for number of participant

        return this.numberOfParticipants;
    }

    public boolean getOpen(){
        //Accessor for open
        return open;
    }
    
     public boolean verifyParticipantID(String participantID) {
        return Participant.verifyID(participantID);
    }
    
    public boolean addParticipant(String participantID){
        //check for duplicates

        if(participantID == null){
            return false;
        }
         if (verifyParticipantID(participantID) == false) {
            return false;
        }
        
        if (numberOfParticipants >= breakoutRoomSize) {
            return false;
        }

        for(int i =0; i < numberOfParticipants; i++){

            if(participants[i].getParticipantID().equals(participantID)){
                return false;
            }
        }
        
        if(numberOfParticipants < breakoutRoomSize && open ==true){
            Participant participant = new Participant(participantID);
            participants[numberOfParticipants] = participant;
            numberOfParticipants++;
            System.out.println(participantID + " added to " + breakoutRoomID);
            return true;

        }
        return false;
    }

    public Participant findParticipant(String participantID){
        // Check for participant
        int i;
        if(Participant.verifyID(participantID) == true){
            for(i = 0; i < breakoutRoomSize; i++){

                if(open == true && participants[i].getParticipantID().equals(participantID)){
                    return participants[i];
                }
            }
        }
        return null;
    }

    public String listParticipants(){
        //Returns a list of participant
        System.out.println("\n");
        int i;
        String breakoutRoomDetails ="";
        breakoutRoomDetails += "Breakout Room ID: "+breakoutRoomID + "\n";
        for(i =0; i < numberOfParticipants; i++){
            breakoutRoomDetails += participants[i]+ "\n";

        }
        return breakoutRoomDetails;
    }

    public String toString(){
        //Return information on breakoutRoom
        String breakoutRoomDetails = "";
        breakoutRoomDetails += breakoutRoomID;
        if (getOpen() == true) {
            breakoutRoomDetails += " OPEN ";
        } else {
            breakoutRoomDetails += " CLOSED ";
        }
        breakoutRoomDetails += numberOfParticipants + "\n";
        return breakoutRoomDetails;
    }

    public void closeBreakoutRoom(){
        //Reset participant and close breakout room

        numberOfParticipants = 0;
        open = false;
        System.out.println(breakoutRoomID + " has been closed successfully.");
    }

    public void openBreakoutRoom(){
        //Open breakout room

        open = true;
        System.out.println(breakoutRoomID + " has been opened successfully.");
    }

}

