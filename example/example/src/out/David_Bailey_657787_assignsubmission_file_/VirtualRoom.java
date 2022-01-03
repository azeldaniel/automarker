package out.David_Bailey_657787_assignsubmission_file_; 
public class VirtualRoom{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom [] breakoutRooms;
    
    public VirtualRoom(String name){
       this.name = name;
       breakoutRoomLimit = 5;
       breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    public VirtualRoom(String name, int limit){
       this.name = name;
       this.breakoutRoomLimit = limit;
       breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRooms.length;
    }
    
    public void createBreakoutRooms(){
        for( int i = 0; i < breakoutRoomLimit; i++){
            BreakoutRoom addRoom = new BreakoutRoom (name);
            breakoutRooms[i] = addRoom;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i = 0; i < breakoutRoomLimit; i++){
            if (i == roomNumber)
                return breakoutRooms[i];
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean isClose;//returns true when breakout is closed and false if room doesnt exist
        if (roomNumber <= breakoutRoomLimit){
            breakoutRooms[roomNumber - 1].closeBreakoutRoom();
            isClose = true;
            return isClose;
        }
        else{
            isClose = false;
            return isClose;
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean isOpen;
        if (roomNumber <= breakoutRoomLimit){
            breakoutRooms[roomNumber- 1].openBreakoutRoom();
            isOpen = true;
            return isOpen;
        }
        else{
            isOpen = false;
            return isOpen;
        }
    }
    
    public String listBreakoutRooms(){
        String list = name += "\n";
        String vPart;
        for (int i = 0; i < breakoutRoomLimit; i++){
            vPart = breakoutRooms[i].toString();
            list += vPart += "\n";
        }
        
        return list;
    }
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String participantList;
        if(roomNumber <= breakoutRoomLimit){
            participantList = breakoutRooms[roomNumber-1].listParticipants();
            return participantList;
        }
        else
            return null;
            
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        boolean isAdded;
        if(roomNumber <= breakoutRoomLimit){
            isAdded = breakoutRooms[roomNumber - 1].addParticipant(participantID);// subtracted 1 so the breakout room counter is the same as the breakoutroom array index
            return isAdded;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        BreakoutRoom temp = null;
            for(int i = 0; i < breakoutRoomLimit; i++){
                temp = breakoutRooms[i];
                if(temp.findParticipant(participantID) != null){
                    return temp.getBreakoutRoomID();
                }
            }
            return null;
        }
   
    }
    
    
    
    
    
    
    
    

