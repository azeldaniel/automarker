package out.Sameir_Ali_657691_assignsubmission_file_;//Student ID#: 816022840
public class BreakoutRoom{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0; 
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants = 0;
    private boolean open = false;
    
    public BreakoutRoom(String name){
        breakoutRoomNumberCounter++;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        this.participants = new Participant[10];
    }
    
    public boolean addParticipant(String participantID){
        if(numberOfParticipants == breakoutRoomSize || open == false || Participant.verifyID(participantID) == false)
            return false;
        for(int i = 0; i< numberOfParticipants; i++){
            if(participantID.equals(this.participants[i].getParticipantID()))
                return false;
        }
        this.participants[numberOfParticipants] = new Participant(participantID); 
        numberOfParticipants++;
        return true;
    }
    
    public Participant findParticipant(String participantID){
        if(open == false || Participant.verifyID(participantID) == false)
            return null;
        for(int i = 0; i< numberOfParticipants; i++){
            if(participantID.equals(participants[i].getParticipantID()))
                return participants[i];
        }
        return null;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public String listParticipants(){
        String list = "";
        for(int i =0; i< numberOfParticipants; i++){
            list += participants[i].getParticipantID() + "\n";
        }
        return list;
    }
    
    public String toString(){
        String info = breakoutRoomID + " ";
        if(open == true)
            info += "OPEN";
        else
            info += "CLOSE";
        return info;
    }
    
    public void closeBreakoutRoom(){
        numberOfParticipants = 0;
        open = false;
    }
    
    public void openBreakoutRoom(){               
        open = true;
    }
}

//Resources used for this class:
//Lecture notes