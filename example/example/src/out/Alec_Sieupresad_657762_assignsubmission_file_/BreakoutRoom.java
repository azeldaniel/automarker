package out.Alec_Sieupresad_657762_assignsubmission_file_;// Student ID: 816022470
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom{
    private String breakoutRoomID;
    public static int breakoutRoomNumberCounter=1;
    private int breakoutRoomSize;
    private Participant[] participants = new Participant[10];
    private int numberOfParticipants;
    private boolean open; 
    private int roomID; 
     
    public BreakoutRoom (String name){
        breakoutRoomID= name + breakoutRoomNumberCounter;
        roomID = breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        breakoutRoomSize = 10;
        numberOfParticipants = 0;
        open = true; //by default 
        
        
    }
    
    public boolean addParticipant (String participantID){
        Participant partic = new Participant(participantID);
        
        if(! partic.verifyID(participantID)){
            return false;
        }
        
        if (this.participants == null){
            this.participants[this.numberOfParticipants] = partic;
            this.numberOfParticipants += 1;
            return true;
        }
        else{
            if(this.numberOfParticipants <= 10 && this.findParticipant(participantID) == null){
                this.participants[this.numberOfParticipants] = partic;
                this.numberOfParticipants += 1;
                return true;
            }
            else{
                this.open = false;
                return false;
            }
        }

    }
    
    public Participant findParticipant (String participantID){
        
        if(this.numberOfParticipants == 0){
            return null;
        }
        
        for(int i = 0; i< numberOfParticipants; i++){
            if(participantID == this.participants[i].getParticipantID()){
                return this.participants[i];
            }
        }
        return null;            
    }
    
   
    public String listParticipants ( ) {
        
        String listString = "";
   
        for(int i = 0; i< numberOfParticipants; i++){
            String id = this.participants[i].getParticipantID();
            listString += id;
            listString += "\n";
        }
        
        return(this.breakoutRoomID + "\n" + listString);
    }
    
    public String toString(){
        String state = "";
        if(this.open == true){
            state = "OPEN";
        }
        else{
            state = "CLOSE";
        }
        return (this.breakoutRoomID +this.breakoutRoomNumberCounter +" "+ state + " " + (this.numberOfParticipants));
    }
    
    public void closeBreakoutRoom( ){
        this.open = false;
        this.participants = null;
        this.numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom( ){
        this.open = true;
    }
    
    
    public int getRoomID(){
        return this.roomID;
    }
    
    public String getBreakoutRoomID(){
        return this.breakoutRoomID;
    }
}

