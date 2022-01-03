package out.Stephen_Jaggai_657716_assignsubmission_file_;// 816019082

public class BreakoutRoom{
    public String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private Participant[ ] participants;
    private int numberOfParticipants;
    public boolean open;
    
    int uniqueId = 0;
    private int getUniqueId(){
        return uniqueId++;
    }
    
    int i = 0;
    
    public BreakoutRoom (String name){
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        this.breakoutRoomNumberCounter = getUniqueId();
        this.breakoutRoomSize = 10;
        this.participants = participants;
        this.numberOfParticipants = 0;
        this.open = false;
    }
    
    public boolean addParticipant( String participantID){
        if (open==true && participants[i].verifyID(participantID)==true){
            participants[i].participantID = participantID;
            numberOfParticipants++;
            i++;
            return true;
        }
        return false;
    }
    
    public Participant findParticipant( String participantID){
        if (participants[i].verifyID(participantID)==true && open==true){
            return participants[i];
        }
        return null;
    }
    
    public String listParticipants( ){
        String listbreakoutroomid = breakoutRoomID + '\n';
        String listparticipants = new String();
        String list;
        for (int i=1; i<100; i++){
            listparticipants = participants[i].participantID + ", ";
        }
        list = listbreakoutroomid + listparticipants;
        return list;
    }
    
    public String toString( ){
        String b;
        b = "CLOSED";
        if (open==true){
            b = "OPEN";
        }
        String details = breakoutRoomID + b + numberOfParticipants;
        return details;
    }
    
    public void closeBreakoutRoom( ){
        this.breakoutRoomID = null;
        this.breakoutRoomNumberCounter = 0;
        this.uniqueId = 0;
        this.breakoutRoomSize = 10;
        this.participants = null;
        this.numberOfParticipants = 0;
        this.open = false;
    }
    
    public void openBreakoutRoom( ){
        open=true;
    }
}