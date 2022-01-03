package out.Tariq_Mohammed_657807_assignsubmission_file_;
/*
 Student ID: 816015043
 Name: Tariq Azard Mohammed
 VirtualRoom Class
 */

public class VirtualRoom
{
    // instance variables
    private String name;
    private final int breakoutRoomLimit;    // final ensures that breakoutRoomLimit cannot be overridden.
    private BreakoutRoom[] breakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        BreakoutRoom.resetNumBreakoutRooms();  // uses BreakoutRoom class method to reset the number of breakoutRooms when a new VirtualRoom is created.
    }
    
    // overloaded constructor specifying breakoutRoom limit:
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        BreakoutRoom.resetNumBreakoutRooms();  // uses BreakoutRoom class method to reset the number of breakoutRooms when a new VirtualRoom is created.
    }
    
    //accessors:
    public String getName(){
        return this.name;
    }
    
    public int getBreakoutRoomLimit(){
        return this.breakoutRoomLimit;
    }
    
    
    //methods:
    
    public int getNumberOfBreakoutRooms(){
        int count = 0;      // count keeps track of the number of breakoutRooms that exist (and are not null)
        
        count = BreakoutRoom.getNumBreakoutRooms();   // uses BreakoutRoom class method to obtain the current number of breakout rooms.
        
        return count;
    }
    
    public void createBreakoutRooms(){
        
        for(int i=0; i<breakoutRoomLimit; i++){

            BreakoutRoom br = new BreakoutRoom(this.name);
            breakoutRooms[i] = br;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        String findRoomID = this.name + roomNumber;     //breakoutRoomID consists of the name of the virtual room as well as the associated room number.
        String breakoutRoomID = "";
        
        // loop iterates through all the breakoutRooms in the VirtualRoom and compares their IDs against 'findRoomID', if found return the breakoutRoom.
        for(int i=0; i<breakoutRoomLimit; i++){
            breakoutRoomID = breakoutRooms[i].getBreakoutRoomID();
            
            if(breakoutRoomID.equals(findRoomID)){
                return breakoutRooms[i];
            }
        }
        
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);     // find breakoutRoom with corresponding roomNumber.
        
        if(br != null){
            br.closeBreakoutRoom();             // close breakoutRoom if it exists
            return true;
        }
        
        else{
            return false;
        }
        
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);     // find breakoutRoom with corresponding roomNumber.
        
        if(br != null){
            br.openBreakoutRoom();            // open breakoutRoom if it exists
            return true;
        }
        
        else{
            return false;
        }
    }
    
    public String listBreakoutRooms(){
        String result = "";
         
        
        result = result + "VirtualRoom: " + this.name + "\n";
        
        for(int i=0; i<breakoutRoomLimit; i++){
            result = result + breakoutRooms[i].toString() + "\n";
        }
        
        return result;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        String participants;
        
        if(br != null){
            participants = br.listParticipants();
            return participants;
        }
        
        else{
            return null;
        }
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        
        if(br != null){
            br.addParticipant(participantID);
            return true;
        }
        
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String breakoutRoom;
        
        for(int i=0; i<breakoutRoomLimit; i++){
            
            if( breakoutRooms[i].findParticipant(participantID) != null  ){
                breakoutRoom = breakoutRooms[i].getBreakoutRoomID();
                return breakoutRoom;
            }
        }
        
        return null; // return null if the breakoutRoom containing participant was not found.
    }
    
}
