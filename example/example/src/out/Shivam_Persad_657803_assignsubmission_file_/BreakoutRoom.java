package out.Shivam_Persad_657803_assignsubmission_file_;/** COMP2603 Assignment1
 *  Name: Shivam Persad
 *  ID: 816016854
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    //CONSTRUCTOR
    public BreakoutRoom(String name){
        this.breakoutRoomID=name+(breakoutRoomNumberCounter+1);
        this.breakoutRoomSize=10;
        this.open=false;
        this.participants = new Participant[breakoutRoomSize];
        this.numberOfParticipants=0;
        breakoutRoomNumberCounter++;
    }
    
    //METHODS
    public boolean addParticipant(String participantID){
        Participant p = new Participant(participantID);
        if(this.open==true && this.numberOfParticipants<this.breakoutRoomSize&&findParticipant(participantID)==null&&p.verifyID(participantID)){
            this.participants[this.numberOfParticipants]=p;
            this.numberOfParticipants++;
            return true;
        }
        return false;
    }
    public Participant findParticipant(String participantID){
        if(this.open){
            for(int i=0;i<this.numberOfParticipants;i++){
                if(this.participants[i].getParticipantID()==participantID){
                    return this.participants[i];
                }
            }
        }
        return null;
    }
    public String listParticipants(){
        if(this.numberOfParticipants==0)
            return "No participants found";
        String pList=this.breakoutRoomID + "\n-=-=-=-=-=-=-=-=-=-\n";
        for(int i=0;i<this.numberOfParticipants;i++){
            pList+=participants[i].toString()+"\n";
        }
        pList+="\n";
        return pList;
    }
    public String toString(){
        String state;
        if(this.open) state=" OPEN";
        else state=" CLOSED";
        String total=" "+this.numberOfParticipants+"/10";
        return this.breakoutRoomID + state + total;
    }
    public void closeBreakoutRoom(){
        this.open=false;
        this.participants = new Participant[this.breakoutRoomSize];
        this.numberOfParticipants=0;
    }
    public void openBreakoutRoom(){
        this.open=true;
    }
    
}
