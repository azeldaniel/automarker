package out.Keron_Pierre_657814_assignsubmission_file_;//816022340
public class VirtualRoom
{
    //declaring variables
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    //constructor to initialize private variables
    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    //overloaded constructor incase someone needs a higher limit
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];
    }
    //used to retrun the number of breakout rooms in a class
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    //used to create a list of breakoutrooms in a specified virtual room
    public void createBreakoutRooms(){
        BreakoutRoom temp = new BreakoutRoom(name);
        for(int i=0; i<breakoutRoomLimit;i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    //used to find a specified room number in the array of breakout rooms
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit;i++){
            if(i+1 == roomNumber){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom temp = findBreakoutRoom(roomNumber);
        if(temp != null){
            temp.closeBreakoutRoom();
            return true;
        }
        else if(temp == null){
            System.out.println("BreakoutRoom does not Exist"); 
        return false;
       }
       return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom temp = findBreakoutRoom(roomNumber);
        if(temp != null){
            temp.openBreakoutRoom();
            return true;
        }
        else if(temp == null){
            System.out.println("Not a valid breakout room");
            return false;
        }
        return false;
    }
    
    public String ListBreakoutRooms(){
        String roomList = name + "\n";
        
        for(int i=0; i<breakoutRoomLimit; i++){
            roomList = roomList + breakoutRooms[i].toString() + ",";
        }
        return roomList;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String partList = "";
        if(findBreakoutRoom(roomNumber) != null){
            partList = breakoutRooms[roomNumber-1].listParticipants() + "\n";
        }
        return partList;
    }
    
    public boolean addParticipanttoBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom temp = findBreakoutRoom(roomNumber);
        
        if(temp != null){
            breakoutRooms[roomNumber-1].addParticipant(participantID);
            return true;
        }
        else if(temp == null){
            System.out.println("Not a valid breakout room");
            return false;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        
        for(int i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].findParticipant(participantID).getParticipantID() == participantID){
                return breakoutRooms[i].toString();
            }
        }
        return null;
    }
}



































