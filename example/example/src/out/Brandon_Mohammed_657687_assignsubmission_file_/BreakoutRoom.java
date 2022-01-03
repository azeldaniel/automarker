package out.Brandon_Mohammed_657687_assignsubmission_file_;//816018582
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private static int breakoutRoomSize = 10;
    private Participant[] participant;
    private int numberOfParticipants;
    private boolean open;
    private int breakoutRoomNumber;
    
    public BreakoutRoom(String name){
        breakoutRoomNumberCounter = breakoutRoomNumberCounter + 100;
        breakoutRoomNumber = breakoutRoomNumberCounter;
        breakoutRoomID = name +" "+ breakoutRoomNumberCounter;
        this.participant = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants; 
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID; 
    }
          
    public boolean getOpen(){
        return open; 
    }
    
    public int getBreakoutRoomNumber(){
        return breakoutRoomNumber;
    }
    
    public boolean addParticipant(String participantID){
        if(Participant.verifyID(participantID) == true){//Verifying the ID
            for (int i =0;i<breakoutRoomSize;i++){//checking for duplicates
                if(participant[i] != null && participant[i].getParticipantID().equals(participantID)){//looking for double IDs
                    System.out.println("This participant is already in this room.\n");
                    return false;
                }
            }
            
            if(numberOfParticipants <= breakoutRoomSize){//ensuring that the room has space
                participant[numberOfParticipants] = new Participant(participantID); 
            }else{
                System.out.println("There is no space in the room\n");
                return false;
            }
            numberOfParticipants++;
            return true;
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){
        int i = 0;
        if((Participant.verifyID(participantID) == true)&&(open == true)){
            while(participant[i] != null){
                if(participant[i].getParticipantID().equals(participantID)){
                    return participant[i];
                }
                i++;
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String list = "Breakout Room ID: " +  breakoutRoomID+ "\n";
        int i = 0;
        while(participant[i] != null){
            list += participant[i].getParticipantID() + "\n";
            i++;
        }
        
        return list;   
    }
    
    public String toString(){
        String detail = "Breakour Room ID: "+breakoutRoomID;
        detail += "\nBreakout Room Number Count: " + breakoutRoomNumberCounter;
        detail += "\nBreakout Room Size: " + breakoutRoomSize;
        detail += "\nNumber Of Participants: " + numberOfParticipants;
        detail += "Open: " + open;
        return detail;
    }
    
    public void closeBreakoutRoom(){
        open = false;
        for(int i = 0; i < breakoutRoomSize; i++){
            participant[i] = null;
        }
        
        numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom(){
        open = true;
        
        for(int i = 0; i < breakoutRoomSize; i++){
            Participant pTemp = new Participant();
            participant[i] = pTemp;
        }
        
    }
    
}
