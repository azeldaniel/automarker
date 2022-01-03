package out.Brittney_Cupen_657790_assignsubmission_file_;//Brittney Cupen 816022438

public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        openBreakoutRoom();
        
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
    
    public boolean addParticipant(String participantID){
        if(numberOfParticipants < breakoutRoomSize){
            if(Participant.verifyID(participantID)){
                Participant p = findParticipant(participantID);
                if(p==null){
                    participants[numberOfParticipants] = new Participant(participantID);
                    numberOfParticipants++;
                    System.out.println("Participant added");
                    return true; //successful
                }
                else{
                    System.out.println("Participant already present");
                }
            }
            else{
                System.out.println("Invalid ID entered");
            }
        }
        else{
            System.out.println("Room is full");
        }
        return false; //unsuccessful
    }
    
    public Participant findParticipant(String participantID){
        if(!open){
            System.out.println("Room is closed.");
            return null;
        }
        if(Participant.verifyID(participantID)){
            for(int i=0; i<numberOfParticipants; i++){
                if(participants[i].getParticipantID().equals(participantID)){
                    return participants[i];
                }
            }
            System.out.println("No such participant found");
        }
        else{
            System.out.println("Invalid ID entered.");
        }
        return null;
    }
    
    public String listParticipants(){
        String list = breakoutRoomID + "\n";
        for(int i=0; i<numberOfParticipants-1; i++){
            list += (participants[i].getParticipantID() +"\n");
        }
        list = list.substring(0, list.length()-1);
        return list;
    }
    
    public String toString(){
        String state = breakoutRoomID + " ";
        if(open){
            state += "OPEN ";
        }
        else{
            state += "CLOSED ";
        }
        state += numberOfParticipants;
        return state;
    }
    
    public void closeBreakoutRoom(){
        open = false;
        for(int i=0; i<numberOfParticipants; i++){
            participants[i] = null;
        }
        numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom(){
        open = true;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
    }
}
