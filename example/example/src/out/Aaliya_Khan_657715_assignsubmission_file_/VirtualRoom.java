package out.Aaliya_Khan_657715_assignsubmission_file_;
/**
 * Student ID - 816019696
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[5];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[10];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit; //idk
    }
    
    public void createBreakoutRooms(){
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++){
            BreakoutRoom b = new BreakoutRoom(name);
            breakoutRooms[i] = b;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++){
            if(breakoutRooms[i] == breakoutRooms[roomNumber]){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom b = findBreakoutRoom(roomNumber);
        
        if(breakoutRooms[roomNumber].getOpen() == false){
            return true;
        }
        
        if(b != null){
            b.closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom b = findBreakoutRoom(roomNumber);
        
        if(breakoutRooms[roomNumber].getOpen() == true){
            return true;
        }
        
        if(b != null){
            b.openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String list;
        
        list = this.name;
        list += "\r\n";
        
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++){
            list += breakoutRooms[i].toString();
            list += "\n";
        }
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom b = findBreakoutRoom(roomNumber);
        String list;
        
        if(b != null){
            list = b.listParticipants();
            list += "\r\n";
            return list;
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom b = findBreakoutRoom(roomNumber);
        boolean add = false;
        
        if(b != null){
            add = b.addParticipant(participantID);
        }
        return add;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                return breakoutRooms[i].toString();
            }        
        }
        return null;
    }
    
}
