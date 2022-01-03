package out.Shane_Beharry_657758_assignsubmission_file_;//Shane Beharry
//816023033
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        //breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        for(int i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
            breakoutRooms[i].openBreakoutRoom();
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(roomNumber>=breakoutRoomLimit){
            System.out.println("Room not found");
            return null;
        }
        else if(breakoutRooms[roomNumber] == null){
            System.out.println("Room not found");
            return null;
        }
        return breakoutRooms[roomNumber];
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) == null){
            return false;
        }
        else{
            breakoutRooms[roomNumber].closeBreakoutRoom();
            return true;
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber)==null){
            return false;
        }
        else{
            breakoutRooms[roomNumber].openBreakoutRoom();
            return true;
        }
    }
    
    public String listBreakoutRooms(){
        String toReturn = "";
        toReturn+= name + "\n";
        for(int i=0; i<breakoutRoomLimit; i++){
            toReturn+= breakoutRooms[i].toString() + " \n";
        }
        return toReturn;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String toReturn = "";
        BreakoutRoom temp = new BreakoutRoom("Temp");
        temp = findBreakoutRoom(roomNumber);
        
        if(temp != null){
            toReturn = temp.listParticipants();
            if(toReturn==null){
                return "Room empty";
            }
            return toReturn;
        }
        else{
            return null;
        }
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom temp = new BreakoutRoom("Temp");
        temp = findBreakoutRoom(roomNumber);
        if(temp == null){
            return false;
        }
        else{
            boolean check = temp.addParticipant(participantID);
            if(check == false){
                return false;
            }
            else{
                return true;
            }
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String roomID = name;
        
        for(int i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                return name + (i);
            }
        }
        return null;
    }
}








