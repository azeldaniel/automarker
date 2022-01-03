package out.Justin_Baldeosingh_657692_assignsubmission_file_;/* Justin Baldeosingh
 * 816021226
 * COMP 2603 - OOP
 * Assignment 1
 */

//Virtual Room Class
public class VirtualRoom{
    //Virtual Room Variables
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    //Virtual Room Constructor takes a name and initializes the breakout room with the name.
    public VirtualRoom(String name){
        //Sets the breakout room name to the passed name.
        this.name = name;
        //Sets the breakout room limit to a default of 5.
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    //Virtual Room Constructor takes a name and limit, and initializes the breakout room with the name and limit.
    public VirtualRoom(String name, int limit){
        //Sets the breakout room name to the passed name.
        this.name = name;
        //Sets the breakout room limit to the passed limit.
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    //Returns the number of breakout rooms in a virtual room.
    public int getNumberOfBreakoutRooms(){
        //Returns the breakout room limit.
        return this.breakoutRoomLimit;
    }
    
    //Creates the breakout rooms for the virtual room.
    public void createBreakoutRooms(){
        //Iterates over the breakout rooms up to the limit.
        for(int i = 0; i < this.breakoutRoomLimit; i++)
            //Creates the breakout room for the current array location.
            this.breakoutRooms[i] = new BreakoutRoom(this.name);
    }
    
    //Given a room number, finds the breakout room and returns the breakout room object.
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        //Iterates over all the breakout rooms in the virtual room and finds and returns the corresponding breakout room.
        for(int i = 0; i < this.breakoutRoomLimit; i++){
            //If the breakout room at the current location matches the breakout room with the number passed,
            //return the breakout room.
            if(this.breakoutRooms[i].getBreakoutRoomID().equals(this.name + roomNumber))
                return this.breakoutRooms[i];
        }
        
        //Returns null if the breakout room cannot be found.
        return null;
    }
    
    //Given a room number, performs a close operation on the corresponding room.
    public boolean closeBreakoutRoom(int roomNumber){
        //Finds and stores the breakout room object that corresponds with the passed roomNumber.
        BreakoutRoom keyBreakoutRoom = this.findBreakoutRoom(roomNumber);
        
        //If the breakout room exists, close the breakout room and return true.
        if(keyBreakoutRoom != null){
            keyBreakoutRoom.closeBreakoutRoom();
            return true;
        }
        
        //Otherwise, return false.
        return false;
    }
    
    //Given a room number, performs an open operation on the corresponding room.
    public boolean openBreakoutRoom(int roomNumber){
        //Finds and stores the breakout room object that corresponds with the passed roomNumber.
        BreakoutRoom keyBreakoutRoom = this.findBreakoutRoom(roomNumber);
        //If the breakout room exists, open the breakout room and return true.
        
        if(keyBreakoutRoom != null){
            keyBreakoutRoom.openBreakoutRoom();
            return true;
        }
        
        //Otherwise, return false.
        return false;
    }
    
    //Returns a string list of the breakout rooms in the virtual room.
    public String listBreakoutRooms(){
        //Stores the header of the virtual room's list of breakout rooms.
        String breakoutRoomList = name + "\n";
        
        //If the number of breakout rooms in the virtual room is not empty, iterates and appends the
        //status of each breakout room to the breakout room list.
        if(this.getNumberOfBreakoutRooms() > 0){
            //Iterates over the breakout rooms and appends the breakout room statuses.
            for(int i = 0; i < this.getNumberOfBreakoutRooms(); i++)
                breakoutRoomList += this.breakoutRooms[i].toString() + "\n";    
        } else 
        //Otherwise, there are no breakout rooms in the virtual room.
            breakoutRoomList += "No breakout rooms in current virtual room!\n";
        
        //Returns the breakout room list.
        return breakoutRoomList;
    }
    
    //Given a room number, returns a String containing the list of participant IDs in the breakout room.
    public String listParticipantsInBreakoutRoom(int roomNumber){
        //Finds and stores the breakout room object that corresponds with the passed roomNumber.
        BreakoutRoom keyBreakoutRoom = this.findBreakoutRoom(roomNumber);
        
        //If the key breakout room exists, return the list of its participants.
        if(keyBreakoutRoom != null)
            return(keyBreakoutRoom.listParticipants());
        else 
        //Otherwise, return null.
            return(null);
        
    }
    
    //Given a participant ID and a room number, adds the validated participant to the breakout room if it exists.
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        //Finds the breakout room that will be used to add the participant.
        BreakoutRoom keyBreakoutRoom = this.findBreakoutRoom(roomNumber);
        
        //if the breakout room is valid, add the participant to the breakout room and returns the outcome.
        if(keyBreakoutRoom != null){
            //Stores and returns the outcome of the participant being added to the breakout room.
            boolean outcome = keyBreakoutRoom.addParticipant(participantID);
            return outcome;
        }
        
        //Returns false otherwise.
        return false;        
    }
    
    //Given a participant ID, finds and returns the participant's breakout room ID if it exists.
    public String findParticipantBreakoutRoom(String participantID){
        //Iterates over the breakout rooms and searches the participants of each room for the passed ID.
        for(int i = 0; i < this.getNumberOfBreakoutRooms(); i++){
            //If the current breakout room contains the participant, return the breakout room ID.
            if(this.breakoutRooms[i].findParticipant(participantID) != null)
                return this.breakoutRooms[i].getBreakoutRoomID();
        }
        
        //Returns null if the participant breakout room cannot be found.
        return null;
    }
    
}
