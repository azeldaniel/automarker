package out.Joshua_Davis_657702_assignsubmission_file_;/*
    Student ID: 816022176
*/


public class BreakoutRoom {
    private final static int DEFAULT_BREAKOUT_ROOM_SIZE = 10;
    
    private static int breakoutRoomNumberCounter = 1;
    private static int nextBreakoutRoomNumber(){
        return breakoutRoomNumberCounter++;
    }
    
    private String breakoutRoomID;
    private final int breakoutRoomNumber;

    // private int breakoutRoomNumberCounter;// moved to virtual room

    private final int breakoutRoomSize;
    private Participant[] participants;

    private int numberOfParticipants;

    private boolean open;

    public BreakoutRoom(String name){
        breakoutRoomNumber = nextBreakoutRoomNumber();
        breakoutRoomID = name + breakoutRoomNumber;

        breakoutRoomSize = DEFAULT_BREAKOUT_ROOM_SIZE;

        participants = new Participant[breakoutRoomSize];

        numberOfParticipants = 0;

        // open = false;
        open = true;
    }

    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    public int getBreakoutRoomNumber(){
        return breakoutRoomNumber;
    }

    public int getBreakoutRoomSize(){
        return breakoutRoomSize;
    }
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    // public boolean isOpen(){
    //     return open;
    // }
    public boolean getOpen(){
        return open;
    }
    public boolean addParticipant(String participantID){
        Participant participant = findParticipant(participantID);
        if (participant != null){
            return true;//already added
        }else{
            if (numberOfParticipants < breakoutRoomSize){
                participant = new Participant(participantID);
                participants[numberOfParticipants ++ ] = participant;
                return true;
            }else{
                return false;
            }
        }
    }
    public Participant findParticipant(String participantID){
        for (int i = 0; i < numberOfParticipants; i++){
            if (participants[i].getParticipantID().equals(participantID)){
                return participants[i];
            }
        }
        return null;
    }
    public String[] listParticipantsArray(){
        String[] participantIDs = new String[numberOfParticipants];
        for (int i =0; i < numberOfParticipants; i++){
            participantIDs[i] = participants[i].getParticipantID();
        }
        return participantIDs;
    }
    public String listParticipants(){
        String participantListString;
        participantListString = breakoutRoomID;
        for (int i = 0; i < numberOfParticipants; i++){
            participantListString += "\n" + participants[i].toString();
        }
        return participantListString;
        
        // if (numberOfParticipants >= 1){
        //     participantListString = participants[0].getParticipantID();
        //     for (int i = 1; i < numberOfParticipants; i++){
        //         participantListString += ", " + participants[i].getParticipantID();
        //     }
        // }else{
        //     participantListString = "";
        // }
        // return "" 
        //     + "breakoutRoomID: " + breakoutRoomID +"\n"
        //     + "participants: [" + participantListString + "]"
        // ;
    }
    public String toString(){
        // return "BreakoutRoom{"
        //     + "\'" + breakoutRoomID + "\'"
        //     + ", " + (open ? "OPEN": "FALSE")
        //     + ", size: " + breakoutRoomSize
        //     + ", numberOfPariticpants:  " + numberOfParticipants
        //     + "}"
        // ;

        return breakoutRoomID + " " + (open ? "OPEN": "FALSE") + " " + numberOfParticipants;
    }

    public void closeBreakoutRoom(){
        if (!getOpen()) return;
        open = false;
        for (int i =0; i < numberOfParticipants; i++){
            participants[i] = null;
        }
        numberOfParticipants = 0;
    }

    public void openBreakoutRoom(){
        if (getOpen()) return;
        open = true;
    }
}
