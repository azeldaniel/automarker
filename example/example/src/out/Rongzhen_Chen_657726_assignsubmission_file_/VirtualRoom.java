package out.Rongzhen_Chen_657726_assignsubmission_file_;//816014227
public class VirtualRoom{
    
    private String name;
    private BreakoutRoom[] breakoutRooms;
    private final int breakoutRoomLimit;
    
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];
    }
    
    public String getVirtualRoomName(){
        return name;
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        for(int i=0;i<breakoutRoomLimit;i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i].getBreakoutRoomNumber() == roomNumber){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i].getBreakoutRoomNumber() == roomNumber){
                breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i].getBreakoutRoomNumber() == roomNumber){
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String details = name + System.lineSeparator();
        
        int i = 0;
        while(i<breakoutRoomLimit){
            details += breakoutRooms[i] + System.lineSeparator();
            i++;
        }
        return details;
    }
        
    public String listParticipantsInBreakoutRoom(int roomNumber){
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i].getBreakoutRoomNumber() == roomNumber){
                String details = breakoutRooms[i].listParticipants();
                return details;
            }
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i].getBreakoutRoomNumber() == roomNumber){
                breakoutRooms[i].addParticipant(participantID);
                return true;
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        return null;
    }
    

}
