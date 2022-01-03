package out.Shane_Beharry_657758_assignsubmission_file_;//Shane Beharry
//816023033
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open = false;
    
    public boolean getOpen(){
        return open;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public void openBreakoutRoom(){
        boolean check = getOpen();
        if(check == false){
            open = true;
        }
    }
    
    public BreakoutRoom(String name){
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        participants = new Participant[10];
        numberOfParticipants = 0;
        this.open = true;
    }
    
    public boolean addParticipant(String participantID){
        if(open = false){
            return false;
        }
        if(numberOfParticipants == 10){ // since this num as 9 means there are 10 participants(started counting at 0)
            return false;
        }
        Participant temp = new Participant(participantID);
        if(temp.verifyID(participantID) == false){
            return false;
        }
        if(numberOfParticipants>0){
            for(int i=0; i<numberOfParticipants; i++){
                String check = participants[i].getParticipantID();
                if(check.equals(participantID)){
                    return false;
                }
            }
        }
        participants[numberOfParticipants] = temp;
        numberOfParticipants++;
        return true;
    }
    
    public Participant findParticipant(String participantID){
        for(int i=0; i<numberOfParticipants; i++){
            String check = participants[i].getParticipantID();
            if(check.equals(participantID)){
                return participants[i];
            }
        }
        
        return null;
    }
    
    public String listParticipants(){
        String toReturn = "";
        toReturn+= breakoutRoomID + "\n";
        if(numberOfParticipants == 0){
            return null;
        }
        for(int i=0; i<numberOfParticipants; i++){
            String id = participants[i].toString();
            toReturn+= id + " \n";
        }
        return toReturn;
    }
    
    public String toString(){
        String toReturn = "";
        String check = "";
        //toReturn+= breakoutRoomID;
        //toReturn+= numberOfParticipants;
        if(this.open == true){
            check = "OPEN";
        }
        if(this.open == false){
            check =  "CLOSED";
        }
        toReturn+= breakoutRoomID + " " + check + " " + numberOfParticipants;
        return toReturn;
    }
    
    public void closeBreakoutRoom(){
        boolean check = getOpen();
        if(check == true){
               participants = null;
            open = false;
            numberOfParticipants = 0;
        }
    }
    
}













