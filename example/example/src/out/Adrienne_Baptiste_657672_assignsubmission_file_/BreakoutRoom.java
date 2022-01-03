package out.Adrienne_Baptiste_657672_assignsubmission_file_;/**
ID: 816020784
 */
public class BreakoutRoom 
{
    // instance variables
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        breakoutRoomID=name+breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        breakoutRoomSize = 10;
        participants=new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open=true;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
   
    public void addOneParticipant(){
        numberOfParticipants++;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean addParticipant(String participantID){
        Participant p= new Participant(participantID);
        if (findParticipant(participantID)==null){
            if(open==true){
                if(getNumberOfParticipants()==breakoutRoomSize){
                    System.out.println("Room Full");
                    return false;
                }
                else{
                    participants[getNumberOfParticipants()]=p;
                    addOneParticipant();
                    return true;
                }     
            }
            else{
                System.out.println("Room is Closed");
                return false;
            } 
        }
        else{
            System.out.println("Participant already present in breakout room.");
            return false;
        }
    }
    
    public Participant findParticipant(String participantID){
        int curr;
        if(open==true){
            for(curr=0; curr<participants.length; curr++){
                if(participants[curr].verifyID(participantID)==true && participants[curr].getParticipantID()== participantID){
                    return participants[curr];
                }
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String outputString=new String();
        int curr;
        outputString= "\n" + getBreakoutRoomID() +"\n";
        for(curr=0; curr<participants.length;curr++){
            outputString= outputString +" "+ participants[curr].getParticipantID();
        }
        return outputString;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public String toString(){
        String info= new String();
        info=getBreakoutRoomID();
        if(open == true)
            info+= "  OPEN";
        else
            info+= "  CLOSED";
        return info;
    }
    
    public void closeBreakoutRoom(){
        open=false;
        participants=null;
        numberOfParticipants=0;
        breakoutRoomNumberCounter--;
    }
    
    public void openBreakoutRoom(){
        open=true;
    }
    
    
}
