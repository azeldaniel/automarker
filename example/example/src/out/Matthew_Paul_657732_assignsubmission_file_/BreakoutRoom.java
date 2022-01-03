package out.Matthew_Paul_657732_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
 */

//Matthew Paul 816018640


public class BreakoutRoom{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=1;
    private static int breakoutRoomSize=10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    
    public BreakoutRoom(String Name){
        breakoutRoomID=Name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter=breakoutRoomNumberCounter+1;
        participants=new Participant[breakoutRoomSize];
        numberOfParticipants=0;
        open=true;
    }
    
    public boolean addParticipant(String participantID){
        if(open==false){
            return false;
        }
        else{
        if(numberOfParticipants>=10){
            return false;
        }else{
            participants[numberOfParticipants]=new Participant(participantID);
            numberOfParticipants=numberOfParticipants+1;
        }
        }
        return true;
    }
    
    public Participant findParticipant(String participantID){
        for(int i=0;i<numberOfParticipants;i++){
            String partID=participants[i].getParticipantID();
            if(partID.equals(participantID)){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        if(open==false){
            return "Room Closed";
        }
        else if(participants==null){
            return "0 Participants";
        }
        else{
        String list=" ";
        list="BreakoutRoom ID : "+breakoutRoomID + "\n";
        for(int i=0;i<numberOfParticipants;i++){
            list=list+participants[i]+ "\n ";
        }
        return list;
       }
    }
    
    public String toString(){
        String details=" ";
        String state=" ";
        if(getOpen()==true){
            state="OPEN";
        }
        else{
            state="CLOSE";
        }
        details= breakoutRoomID + " " + state + " " + numberOfParticipants;   
        return details;
    
    }
    
    public  void closeBreakoutRoom(){
        if(open==true){
        open=false;
        participants=null;
        }
    }
    
    public void openBreakoutRoom(){
        if(open==false){
        open=true; 
        }
    }
    //accessors
    public String getbreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getnumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    
    
}
