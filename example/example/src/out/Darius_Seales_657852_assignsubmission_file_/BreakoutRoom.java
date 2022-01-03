package out.Darius_Seales_657852_assignsubmission_file_;

/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private Participant participants[];
    private int numberOfParticipants;
    private boolean open;
    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        this.breakoutRoomSize = 10;
        this.numberOfParticipants = 0;
        this.open = false;
        this.participants = new Participant[breakoutRoomSize];
        this.breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1;
    }
    public String getbreakoutRoom(){
        return this.breakoutRoomID;
    }
    public int getNumberofParticipant(){
        return this.numberOfParticipants;
    }
    public boolean Status(){
        return open = false;
    }
    public boolean addParticipant(String participantID){
        Participant newParticipant = new Participant(participantID);
        if(newParticipant.verifyID(participantID) && numberOfParticipants < 10 && this.Status()){
            participants[numberOfParticipants] = newParticipant;
            numberOfParticipants = numberOfParticipants + 1;
            return true;
        }
        return false;
    }
    public Participant findParticipant(String participantID){
        for(int a = 0; a < numberOfParticipants; a = a + 1){
            if(participants[a].getParticipant() == participantID)
                return participants[a];
        }
        return null;
    }
    public String listParticipants(){
        String list = "Breakout Room ID: " + breakoutRoomID + "\n";
        for(int x = 0; x < numberOfParticipants; x+=1){
            list = list + x+". "+ participants[x].getParticipant()+"\n";
        }
     
        return list;
    }
    
    public String toString(){
        String room = this.listParticipants();
        room = room + "Max Participants: " + breakoutRoomSize + "\n";
        room = room + "Room State: ";
        if(this.Status())
            room += "Open";
        else
            room += "Closed";
        room += "\n";
        return room;
    }
    
    public void closeBreakoutRoom(){    
        for (int a = 0; a < numberOfParticipants; a=a+1)
            participants[a] = null;
        this.open = false;
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }
    
}
