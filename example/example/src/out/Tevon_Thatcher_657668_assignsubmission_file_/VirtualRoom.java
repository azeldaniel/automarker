package out.Tevon_Thatcher_657668_assignsubmission_file_;/**
 * @Tevon Thatcher - 816019492
 */

public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name=name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5];
    }
    /**
     * Overloaded constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit=limit;
        breakoutRooms = new BreakoutRoom[limit];
    }
     
    
    public int getNumberOfBreakoutRooms()
    {   
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        for(int i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(name+roomNumber)){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(name+roomNumber)){
                breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(name+roomNumber)){
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String returnString = "";
        for(int i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].getOpen())
                returnString += breakoutRooms[i].getBreakoutRoomID() + "\n";
        }
        return returnString;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(name+roomNumber)){
                return breakoutRooms[i].listParticipants();
            }
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){      
        for(int i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(name+roomNumber) && breakoutRooms[i].getNumberOfParticipants() < 10){
                breakoutRooms[i].addParticipant(participantID);
                return true;
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                return "Participant found in : " + breakoutRooms[i].getBreakoutRoomID() + "\n";
            }
                
        }
        return "Participant not found\n";
    }
}
