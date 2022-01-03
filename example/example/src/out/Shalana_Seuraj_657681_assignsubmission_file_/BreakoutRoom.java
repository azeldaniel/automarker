package out.Shalana_Seuraj_657681_assignsubmission_file_;/*
 * 816021684
 */
 
public class BreakoutRoom{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize;
    private Participant[] participants = new Participant[10];
    private int numberOfParticipants;
    private boolean open;
    
    //Constructor
    public BreakoutRoom(String name){
        this.breakoutRoomSize = 10;
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        this.numberOfParticipants = 0;
        this.open = true;
    }
    
    public boolean addParticipant(String participantID){      
        Participant p = new Participant(participantID);//Creates a participant object
        String pID = p.getParticipantID();
        boolean foundID = false;
        
        if(p.verifyID(pID)==true){//if ParticipantID is valid ID
            if(this.open==true){//if the room is open
                if(this.numberOfParticipants<10){//if room is not filled
                    for(int i=0;i<this.numberOfParticipants;i++){//check if ID already in breakoutroom                        
                        if(foundID==false){                            
                            if(participants[i]!=null){                                
                                String pID2 = participants[i].getParticipantID();//get ID of the participant in array                                
                                if(pID2.equals(pID)){//ID already exists in array                                        
                                    foundID=true;
                                    return true;                                        
                                }                                     
                            }                           
                        }
                    }                    
                    if(foundID==false){//ID not present in array                        
                        participants[numberOfParticipants] = p;
                        numberOfParticipants++;
                        return true;//participant was added to the breakout room successfully                        
                    }                       
                }
            }
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){        
        if(this.open==true){
            for(int j=0;j<numberOfParticipants;j++){
                if(participants[j]!=null){
                    String pID2 = participants[j].getParticipantID();
                    if(pID2.equals(participantID)){                        
                        return participants[j];
                    }                
                }                
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String listP = "";
        listP += this.breakoutRoomID + " (Breakout Room Name)\n";
        for(int a=0;a<numberOfParticipants;a++){
            if(participants[a]!=null){
                listP += this.breakoutRoomID + " - " + participants[a].getParticipantID() + "\n";                
            }
        }
        return listP;        
    }
    
    public String toString(){
        boolean state = this.getOpen();
        String stringState;
        if(state==true){
            stringState = "OPEN";
        }
        else{
            stringState = "CLOSE";
        }
        String stateBreakoutRoom = this.breakoutRoomID + " " + stringState + " " + this.numberOfParticipants;
        return stateBreakoutRoom;
    }
    
    public void closeBreakoutRoom(){
        this.open = false;
        for(int count=0;count<this.numberOfParticipants;count++){
            participants[count] = null;
        }
        this.numberOfParticipants = 0;
    }
   
    public void openBreakoutRoom(){
        this.open = true;
    }
    
    public String getBreakoutRoomID(){
        return this.breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return this.numberOfParticipants;
    }
    
    public boolean getOpen(){
        return this.open;
    }
}