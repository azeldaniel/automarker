package out.Keron_Pierre_657814_assignsubmission_file_;//816022340
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=00;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        participants = new Participant[10];
        breakoutRoomID = name + breakoutRoomNumberCounter++;
        breakoutRoomSize = 10;
        numberOfParticipants = 0;
        open = true;
    }
    
    public boolean addParticipant(String participantID){
        Participant tempparticipant = new Participant(participantID);
        if(numberOfParticipants < breakoutRoomSize){
            if(tempparticipant.verifyID(participantID) && open){
                participants[numberOfParticipants] = tempparticipant;
                numberOfParticipants++;
                return true;
            }
        }
        return false;
    }
    
    //not sure if i was supposed to validate the id or if the id was already valid
    public Participant findParticipant(String participantID){ 
        for(int i=0; i<numberOfParticipants; i++){
            if(participants[i].getParticipantID() == participantID){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
       String participantsList =  breakoutRoomID ;
       for(int i=0; i<numberOfParticipants; i++){
           participantsList =  participantsList + "\n" + "participant_" + (i+1) +" "+ participants[i].getParticipantID();
        }
        return participantsList;
    }
    public String toString(){
        String roomName = breakoutRoomID + "\n Number of participants: "+numberOfParticipants;
        return roomName;
    }
    
    public void closeBreakoutRoom(){
        open = false;
        numberOfParticipants = 0;
        participants = null;
    }
    public void openBreakoutRoom(){
        open = true;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
}
