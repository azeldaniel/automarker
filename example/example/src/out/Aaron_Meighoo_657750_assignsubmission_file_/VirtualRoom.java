package out.Aaron_Meighoo_657750_assignsubmission_file_;//Aaron Meighoo
//816000303
//A1
//VirtualRoom Class

public class VirtualRoom{
    
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    
    public VirtualRoom(String roomName){
        this.name = roomName;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5];
        //this.breakoutRooms = breakoutRooms;
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];
    }
    
    public BreakoutRoom[] getBreakoutRooms(){
        return breakoutRooms;
    }
    
    public String getVirtualRoomName(){
        return name;
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        breakoutRooms = new BreakoutRoom[getNumberOfBreakoutRooms()];
        for(int i = 0; i < breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        BreakoutRoom br = null;
        if((roomNumber >= 1) && (roomNumber < this.breakoutRoomLimit))
            br = breakoutRooms[roomNumber -1];
        return br;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if((roomNumber >= 1) && (roomNumber < breakoutRoomLimit)){
            breakoutRooms[roomNumber-1].closeBreakoutRoom();
            return true;
        }
        return false;
    }

    
    public boolean openBreakoutRoom(int roomNumber){
        if((roomNumber >= 1) && (roomNumber < breakoutRoomLimit)){
            breakoutRooms[roomNumber-1].openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String details = "VirtualRoom Name: " + getVirtualRoomName() + "/n";
        if (breakoutRoomLimit == 0)
            details += "No Virtual Rooms" + "\n";
        for(int i = 0; i < breakoutRoomLimit; i++)
            details += breakoutRooms[i].toString() + "\n";
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String listParticipantsInRoom= "";
        if((roomNumber -1 >= 0) && (roomNumber -1 < breakoutRoomLimit))
            listParticipantsInRoom = breakoutRooms[roomNumber -1].listParticipants();
        return listParticipantsInRoom;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        if (roomNumber-1 >= 0 && roomNumber-1 < breakoutRoomLimit){
            String toAdd = findParticipantBreakoutRoom(participantID);
            if (toAdd == null)
                return this.breakoutRooms[roomNumber-1].addParticipant(participantID); 
        }
        return this.breakoutRooms[roomNumber-1].addParticipant(participantID);
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String id="";
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                id = breakoutRooms[i].getBreakoutRoomID();
            }
            else 
                id="";
         
            }
        return id;
    }
}
