package out.Sameir_Ali_657691_assignsubmission_file_;//Student ID#: 816022840
public class VirtualRoom{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom [] breakoutRooms;
    public VirtualRoom(String name){
        breakoutRoomLimit = 5;
        this.name = name;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        for(int i = 0; i<breakoutRoomLimit; i++)
            breakoutRooms[i] = new BreakoutRoom(name);
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){    
        if(roomNumber <= breakoutRoomLimit && roomNumber > 0 && breakoutRooms[roomNumber-1] != null )
            return breakoutRooms[roomNumber-1];
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){
            breakoutRooms[roomNumber-1].closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){
            breakoutRooms[roomNumber-1].openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String list = name + ": \n";
        for(int i = 0; i < breakoutRoomLimit; i++)
            list += breakoutRooms[i].toString() + "\n";
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        if( findBreakoutRoom(roomNumber) == null)
            return null;
        String list = this.name+roomNumber +" Participants: \n";
        list += breakoutRooms[roomNumber-1].listParticipants() + "\n";                            
        return list;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        boolean addStatus;
        if( findBreakoutRoom(roomNumber) != null){
            addStatus = breakoutRooms[roomNumber-1].addParticipant(participantID);
            return addStatus;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){   
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++){
            if(breakoutRooms[i].findParticipant(participantID) != null)
                return (this.name + (i+1));
        }
        return null;
    }    
}

//Resources used for this class:
//Lecture notes