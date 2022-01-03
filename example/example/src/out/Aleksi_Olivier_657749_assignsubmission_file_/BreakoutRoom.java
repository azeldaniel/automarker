package out.Aleksi_Olivier_657749_assignsubmission_file_;/**
 * Write a description of class BreakoutRoom here.
 * All classes originally written in VS code
 * @author (ALEKSI OLIVIER 816023287)
 * @version (a version number or a date)
 */
public class BreakoutRoom {
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants = 0;
    private boolean open;

    public BreakoutRoom(String name){
        breakoutRoomNumberCounter++;
        breakoutRoomID = name + breakoutRoomNumberCounter; //this is supposed to concatenate the 2 variables as one string e.g ROOM + 2 = ROOM2
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;
    }

    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }

    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }

    public boolean getOpen(){
        if(open)
            return true;
        return false;
    }

    public boolean addParticipant(String participantID){
        if(numberOfParticipants < breakoutRoomSize){
            participants[numberOfParticipants] = new Participant(participantID);
            if(participants[numberOfParticipants].verifyID(participantID)){
                numberOfParticipants++;
                return true;
            }
        }
        return false;
    }

    public Participant findParticipant(String participantID){
        for(int i=0; i<numberOfParticipants; i++){
            if(participantID.equals(participants[i].getParticipantID()) && this.open){
                    return participants[i];
            }
        }
        return null;
    }

    public String listParticipants(){ 
        String details = "\n";
        for(int i= 0; i<numberOfParticipants;i++){
            details += participants[i].getParticipantID() + "\n";
        }
        return breakoutRoomID + details;
    }

    public void closeBreakoutRoom(){
            open = false;
            numberOfParticipants = 0;
            for(int i=0; i<breakoutRoomSize; i++){
                participants[i] = null;
            }
    }

    public void openBreakoutRoom(){
            open = true;
    }


    public String toString(){
        String status;
        if(open){
            status = "OPEN";
        }else{
            status = "CLOSED";
        }
        return "ID: " +breakoutRoomID+ " " +status+ "\nSize: "+ breakoutRoomSize+ " \nNumber of Participants: "
        +numberOfParticipants+ "\n\n";
    }



}



