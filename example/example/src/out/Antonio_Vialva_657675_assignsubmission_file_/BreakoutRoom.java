package out.Antonio_Vialva_657675_assignsubmission_file_;/*
 816004121
 */

/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    String breakoutRoomID;
    int breakoutRoomNumberCounter;
    static int breakoutRoomSize;
    Participant[] participants;
    int numberOfParticipants;
    boolean open;
    
    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        this.breakoutRoomID = name;
        this.breakoutRoomNumberCounter = 0;
        this.breakoutRoomSize = 10;
        this.numberOfParticipants = 0;
        this.open = false;
    }

    public String getbreakoutRoomID(){
        return this.breakoutRoomID;
    }
    
    public int getbreakoutRoomNumberCounter(){
        return this.breakoutRoomNumberCounter;
    }
    
    public int getbreakoutRoomSize(){
        return this.breakoutRoomSize;
    }
    
    public Participant[] getparticipants(){
        return this.participants;
    }
    
    public int getnumberOfParticipants(){
        return this.numberOfParticipants;
    }
    
    public boolean getopen(){
        return this.open;
    }
    
    public String toString(){
        String details = "" + this.breakoutRoomID;
        details = " " + this.breakoutRoomNumberCounter;
        details = " " + this.breakoutRoomSize;
        details = " " + participants;
        details = " " + this.numberOfParticipants;
        details = " " + this.open;
        return details;
    }
    
    public boolean addParticipant( String participantID){
        Participant p = new Participant(participantID);
        int i=0;
        while(i != this.getnumberOfParticipants()){
            if(participantID.equals(this.participants[i].getParticipantID())){
                System.out.println("Data already entered");
                return false;
            }
            else{
                if(p.verifyID(participantID) == true && this.open == true && this.numberOfParticipants <10){
                numberOfParticipants++;
                breakoutRoomSize++;
                this.participants[numberOfParticipants] = p;
                return true;
                }
            }
            i++;
            }  
        return false;     
    }
   
    public Participant findParticipant( String participantID){
        Participant p = new Participant(participantID);
        if(this.open == true && p.verifyID(participantID) == true){ 
            for(int i= 0; i<=this.numberOfParticipants;i++){
                if(this.participants[i].getParticipantID() == participantID){
                    return p;
                }
            }
        }
        return null;
     }
    
    public String listParticipants( ){
        String list = "" + this.breakoutRoomID;  
        
        for(int i= 0; i<= numberOfParticipants; i++){
            list = list + "\n " + this.participants[i].getParticipantID();
        }
        return list;
    }
    
    public void closeBreakoutRoom( ){
        if(this.open == true){
            this.open = false;
        }
        this.breakoutRoomID = null;
        this.breakoutRoomNumberCounter = 0;
        this.participants = null;
        this.numberOfParticipants = 0;
        this.open = false;
    }
    
    public void openBreakoutRoom( ){
        if(this.open == false){
            this.open = true;
        }
        this.breakoutRoomNumberCounter++;
    }
}
