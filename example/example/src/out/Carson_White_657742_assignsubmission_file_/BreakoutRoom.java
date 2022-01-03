package out.Carson_White_657742_assignsubmission_file_;//816020150
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize ;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    
    public BreakoutRoom(String breakoutRoom){
        breakoutRoomNumberCounter++;
        this.breakoutRoomID = breakoutRoom +" "+ breakoutRoomNumberCounter;
        breakoutRoomSize = 10;  
        participants = new Participant[breakoutRoomSize];
        open = false;
    }
    
    
    public boolean addParticipant(String participantID){
       boolean check = false;
       Participant tester = new Participant(participantID);
       if(tester.verifyID(participantID) && numberOfParticipants!=breakoutRoomSize && open ){
           for(int i=0;i<numberOfParticipants;i++){
            if(participantID.equals(participants[i].getParticipantID())){
                check = true;
            }
          }
           if(check == false){
            if(participants[numberOfParticipants]==null){
            participants[numberOfParticipants] = new Participant(participantID);
            numberOfParticipants++;
            return true;
            }
          }
        }else{
            tester = null;
            return false;
        }
       tester = null;
       return false;
    }
    
    public Participant findParticipant(String participantID){
        Participant tester = new Participant(participantID);
        if(tester.verifyID(participantID)){
            for(int i=0;i<numberOfParticipants;i++){
                if(participantID.equals(participants[i].getParticipantID())){
                    return participants[i];
                }
            }
        }
        tester = null;
        return null;
    }
    
    public String listParticipants(){
        String Output = breakoutRoomID + "\n" + "-------------------" + "\n";
        for(int i=0;i<numberOfParticipants;i++){
            Output += (participants[i].getParticipantID() + "\n");
        }
        return Output+="\n";
    }
    
    public String toString(){
        String output= "BreakoutRoom: "+ breakoutRoomID + " ";
        output += ("Open: "+ open + "\n");
        return output;
    }
    
    public void closeBreakoutRoom( ){
         numberOfParticipants = 0;
         open=false;
        }
    public void openBreakoutRoom( ){
         open = true;
    }
}
