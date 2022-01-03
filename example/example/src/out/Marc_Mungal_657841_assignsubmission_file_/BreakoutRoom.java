package out.Marc_Mungal_657841_assignsubmission_file_;//816018788
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    private String participantID;
    private String name;
    private int i;
    
    public BreakoutRoom(String name){
        this.name= name;
        this.breakoutRoomNumberCounter= breakoutRoomNumberCounter;
        this.breakoutRoomSize= 5;
        this.numberOfParticipants= numberOfParticipants;
        participants= new Participant[50];
    }
    
    public boolean addParticipant(String participantID, Participant total){
        if(numberOfParticipants<5){
            participants[numberOfParticipants]= total;
            numberOfParticipants+=1;
            return true;
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){
        if(participantID.length()==8){
            for(i=0;i<numberOfParticipants;i++){
                participantID= participants[i].toString();
            }
            return participants[i];
        }
        else{
            return null;
        }
    }
    
    public String listParticipants(){
        return "BreakoutRoom: " + breakoutRoomID +"      " + "participants: " + name + "    " + participantID;
    }
    
    public String toString(){
        return breakoutRoomID + "    " + name + "    " + participantID;
    }
    
        public void closeBreakoutRoom(){
        if (open==true){
            open=false;
        }
    }
    
    public void openBreakoutRoom(){
        if(open==false){
            open=true;
        }
    }
}
