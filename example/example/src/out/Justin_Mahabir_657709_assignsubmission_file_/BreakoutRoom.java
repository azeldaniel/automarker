package out.Justin_Mahabir_657709_assignsubmission_file_;//ID: 816000496
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author Justin Mahabir
 * @version (a version number or a date)
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
    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        participants = new Participant[10];
        breakoutRoomNumberCounter++;
        breakoutRoomSize = 10;
        numberOfParticipants = 0;
        open = true;
        breakoutRoomID = name + breakoutRoomNumberCounter;
    }
    public int getNumberOfParticipants(){
        return this.numberOfParticipants;
    }
    public boolean getOpen(){
        return this.open;
    }
    public boolean addParticipant(String participantID)
    {
        if(this.open == false){
            return false;
        }
        if(this.numberOfParticipants == 10){
            return false;
        }
        else{
            Participant search;
            search = findParticipant(participantID);
            if(search == null){
                this.participants[this.numberOfParticipants] = new Participant(participantID);
                this.numberOfParticipants++;
                return true;
            }
            return false;
        }
        
    }
    public Participant findParticipant(String participantID){
        Participant ref;
        for(int i = 0; i < this.numberOfParticipants;i++){
            if(this.participants[i].getParticipantID() == participantID){
               ref = participants[i];
               return ref;
            }
        }
        return null;
    }
    public String listParticipants(){
        String list="";
        String IDs="";
        list = "\n"+ breakoutRoomID +":\n";
        if(numberOfParticipants == 0){
            if(this.open == false){
                IDs = "Closed and Empty Room";
            }
            else{
               IDs = "Open and Empty room."; 
            }
            list +=IDs;
        }
        else{
            int x = 0;
            IDs += participants[x].getParticipantID();
            IDs += "\n";
            x++;
            while(x < numberOfParticipants){
                IDs += participants[x].getParticipantID();
                IDs += "\n";
                x++;
            }
            list += IDs;
        }
        
        return list;
    }
    public String toString(){
        String result = "";
        result = result + this.breakoutRoomID +" ";
        if(this.open == true){
            result += "OPEN " + this.numberOfParticipants;
        }
        else{
            result += "CLOSED "+ this.numberOfParticipants;
        }
        
        return result;
    }
    public void closeBreakoutRoom(){
        this.open = false;
        for(int x = 0; x < this.numberOfParticipants;x++){
            this.participants[x] = null;
        }
        this.numberOfParticipants = 0;
    }
    public void openBreakoutRoom(){
        this.open = true;
    }
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
}
