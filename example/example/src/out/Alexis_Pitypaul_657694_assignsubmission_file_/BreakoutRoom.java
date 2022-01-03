package out.Alexis_Pitypaul_657694_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (Alexis Pitypaul - 816020068)
 * @version (1)
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    public int getBreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
    public int getBreakoutRoomSize(){
        return breakoutRoomSize;
    }
    public Participant[] getParticipants(){
        participants = new Participant[breakoutRoomSize];
        return participants;
    }
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    public boolean getOpen(){
        return open;
    }
    
    public BreakoutRoom(String name){
        int num = getBreakoutRoomNumberCounter();
        breakoutRoomID = (name + num);
        breakoutRoomNumberCounter++;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        int a = 0;
        while(a < breakoutRoomSize){
            participants[a] = new Participant(" ");
            a = a + 1;
        }
        numberOfParticipants = 0;
        open = true;
    }
    public boolean addParticipant(String participantID){
        boolean canAdd = true;
        if(participants[numberOfParticipants].verifyID(participantID)){//check if ID is valid
            if(numberOfParticipants < breakoutRoomSize && open){ //check if room has space and is open
                canAdd = true;
                participants[numberOfParticipants] = new Participant(participantID);
                numberOfParticipants = numberOfParticipants + 1;
            } else {
                canAdd = false;
            }
        }else{
            canAdd = false;
        }
        return canAdd;
    }
    public Participant findParticipant(String participantID){
        int b = 0;
        boolean found = false;
            while(b < numberOfParticipants && found == false){
                if(participants[b].getParticipantID().equals(participantID)){//checks if ID matches the IDs in the room
                    return participants[b];
                }
                b = b + 1;
            }
            return null;
    }
    public String listParticipants(){
        String p = "Breakout Room ID: " + getBreakoutRoomID() + "\n";
        for(int a = 0; a < breakoutRoomSize; a++){
            p += "Participant " + a + ": " + participants[a].getParticipantID() + "\n";
        }
        return p;
    }
    public String toString(){
        String state = "OPEN";
        if(!open)
            state = "CLOSE ";
        else
            state = "OPEN ";
        String seminar = breakoutRoomID + " " + state + numberOfParticipants + "\n";
        return seminar;
    }
    public void closeBreakoutRoom(){
        open = false;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
    }
    public void openBreakoutRoom(){
        open = true;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        int a = 0;
        while(a < breakoutRoomSize){
            participants[a] = new Participant(" ");
            a = a + 1;
        }
        numberOfParticipants = 0;
    }
}
