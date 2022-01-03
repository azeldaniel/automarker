package out.Antonio_Vialva_657675_assignsubmission_file_;/*
 816004121
 */
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private int breakoutRoomLimit;
    BreakoutRoom [] breakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        this.name = name;
        this.breakoutRoomLimit = 5;
    }

    public VirtualRoom(String name,int limit)
    {
        this.breakoutRoomLimit = limit;
        this.name = name;
    }

    public String toString(int number){
        String details = "" + number;
        return details;
    }
    
    public int getNumberOfBreakoutRooms(){
        int count = 0;
        for(int i= 0; i< this.breakoutRoomLimit; i++){
            if(this.breakoutRooms[i].getbreakoutRoomID() != null){
                count++;
            }
            
        }
        return count;
    }
    
    public void createBreakoutRooms(){
        int counter = this.breakoutRooms[1].getbreakoutRoomNumberCounter();
        for(int i= 0; i< this.breakoutRoomLimit; i++){
            BreakoutRoom room = new BreakoutRoom(toString(counter++));
            this.breakoutRooms[i] = room;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        BreakoutRoom b = new BreakoutRoom(toString(roomNumber));
        for(int i= 0; i< getNumberOfBreakoutRooms(); i++){
            if(this.breakoutRooms[i].getbreakoutRoomID().equals(toString(roomNumber))){
                return b;
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        int i=0;
        while(i < this.breakoutRoomLimit){
            if(this.breakoutRooms[i].getbreakoutRoomID().equals(roomNumber)){
                this.breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
            i++;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) == null){
            return false;
        }
        else{
            int i = 0;
            while(i < this.breakoutRoomLimit){
                if(this.breakoutRooms[i].getbreakoutRoomID().equals(roomNumber)){
                    this.breakoutRooms[i].openBreakoutRoom();
                    return true;
                }
            }
        }
        return false;
    }
    
    public String listBreakoutRooms( ){
        String details = "Virtual Room: " + this.name;
        for(int i= 0; i< getNumberOfBreakoutRooms(); i++){
            details = details + "\n" + this.breakoutRooms[i].getbreakoutRoomID();
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber) {
        String list = "";
        list = list + "\n " + this.breakoutRooms[roomNumber].listParticipants();
        return list;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        if(findBreakoutRoom(roomNumber) == null){
            return false;
        }
        int i = 0;
        while(i < this.breakoutRoomLimit){
            if(this.breakoutRooms[i].getbreakoutRoomID().equals(roomNumber)){
                this.breakoutRooms[i].addParticipant(participantID);
                return true;
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        int i=0;
        while(i < this.breakoutRoomLimit){
            if(this.breakoutRooms[i].findParticipant(participantID) != null){
                this.breakoutRooms[i].participants[1].verifyID(participantID);
                return this.breakoutRooms[i].getbreakoutRoomID();
            }
        }  
        return null;
    }
}
