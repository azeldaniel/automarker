package out.Brandon_Rampersad_657676_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author 816019037
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomId;
    private static int breakoutRoomNumberCounter = 1;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        breakoutRoomId = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1;
        breakoutRoomSize = 10;
        participants = new Participant [10];
        numberOfParticipants = 0;
        open = true;
        
        
    }
    
    public String getbreakoutRoomId(){
        return this.breakoutRoomId;
    }
    
    public int getnumberOfParticipants(){
        return this.numberOfParticipants;
    }
    
    public boolean getopen(){
        return open;
    }
    
    public boolean addParticipant(String participantID){
        if (this.open = true){
            Participant p = new Participant(participantID);
            int x = 0;
            boolean found = false;
            while (x<numberOfParticipants){
                if (participants[x].equals(p)){
                    found = true;
                    break;
                }
                else{
                    x++;
                }
            }
            
            if ((found = false)&&(p.verifyID(participantID)== true)){
                int a = numberOfParticipants;
                this.participants[a] = p;
                numberOfParticipants++;
                return true;
              
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }        
}

public Participant findParticipant(String participantID){
    if (this.open = true){
         int x = 0;
         boolean found = false;
            while (x<breakoutRoomSize){
                if (participants[x].getparticipantID().equals(participantID)){
                    found = true;
                    break;
                }
                else{
                    x++;
                }
            }
            if (found = true) {
                return participants[x];
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
}

public String listParticipants(){
    String list = "Breakout Room:  " + breakoutRoomId + "\n\n";
    int x = 0;
    while (x < numberOfParticipants){
        list += participants[x].getparticipantID() + "\n";
    }
    return list;
}
        
public String toString(){
    String room;
    room = breakoutRoomId;
    if (getopen() == true){
        room += " OPEN ";
    }
    else{
        room+= " CLOSED ";
    }
    room += " Participants: " + numberOfParticipants;
    
    return room;
}

public void openBreakoutRoom(){
    open = true;
}

public void closeBreakoutRoom(){
    open = false;
    for (int x =0; x<numberOfParticipants; x++){
        participants[x]= null;
    }
    numberOfParticipants = 0;
}
    

 
}
