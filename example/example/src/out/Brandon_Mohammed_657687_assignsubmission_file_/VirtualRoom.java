package out.Brandon_Mohammed_657687_assignsubmission_file_;//816018582
public class VirtualRoom
{
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] BOR;
        
    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit = 5;
        BOR = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        BOR = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getBreakoutRoomLimit(){
        return breakoutRoomLimit;
    }
    
    public int getNumberOfBreakoutRooms(){
        int i = 0;
        while(BOR[i].getNumberOfParticipants() != 0){
            i++;
        }
        return i;
    }
    
    public void createBreakoutRooms(){
        for (int i = 0; i < breakoutRoomLimit; i++){
            BreakoutRoom brTemp = new BreakoutRoom(name);
            BOR[i] = brTemp;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        
        for(int i = 0; i < breakoutRoomLimit;i++){
            if(BOR[i].getBreakoutRoomNumber() == roomNumber){
                return BOR[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom brTemp = findBreakoutRoom(roomNumber);
        if (brTemp != null){
            brTemp.closeBreakoutRoom();
            return true;
        }
        return false; 
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom brTemp = findBreakoutRoom(roomNumber);
        if (brTemp != null){
            brTemp.openBreakoutRoom();
            return true;
        }
        return false; 
    }
    
    public String listBreakoutRooms(){
        String list = "Virtual room name: " + name + "\n";
        
        for (int i = 0; i < breakoutRoomLimit;i++){
            list += BOR[i].getBreakoutRoomID() + "\n";
        }
        
        return list;  
    }
    
    public String listParticipantInBreakoutRoom(int roomNumber){
        String list = "";
        BreakoutRoom brTemp = findBreakoutRoom(roomNumber);
        
        if (brTemp != null){
            list += brTemp.listParticipants();
            return list;
        }
        
        return "The breakout room does not exist.";
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        
        BreakoutRoom brTemp = findBreakoutRoom(roomNumber);
        boolean added = false;
        
        if (brTemp != null){
            added = brTemp.addParticipant(participantID);
            if(added == true){
                return true;
            }
            
        }
        
        return false;
    }
    
    public String findParticiapntBreakoutRoom(String participantID){
        
        for(int i = 0; i < breakoutRoomLimit; i++){
            
            if(BOR[i].findParticipant(participantID) != null){
                return BOR[i].getBreakoutRoomID();
            }
        }
        
        return null;
    }
    
}
