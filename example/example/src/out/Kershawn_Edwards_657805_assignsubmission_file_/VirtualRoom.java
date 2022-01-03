package out.Kershawn_Edwards_657805_assignsubmission_file_;//816016050

public class VirtualRoom{

    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    private int count;
    private String breakoutRoomList;
    
    public VirtualRoom(String name){
    
        this.name = name;
        breakoutRoomLimit = 5;
        count = 0;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit){
    
        this.name = name;
        breakoutRoomLimit = limit;
        count = 0;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    public int getBreakoutRoomLimit(){
    
        return breakoutRoomLimit;
    }
    public int getNumberOfBreakoutRooms(){
        count = 0;
        for(int x = 0; x < breakoutRoomLimit; x++){
        
            if(breakoutRooms[x]!= null){
                count++;
                
            }  
        }
        //System.out.println(count+ "\n");
        return count;
    }
    
    public void createBreakoutRooms(){
        breakoutRooms[getNumberOfBreakoutRooms()] = new BreakoutRoom(this.name);
        
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber -1] != null)
            return breakoutRooms[roomNumber -1];
        
        else 
            return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if((roomNumber <= breakoutRoomLimit) && (roomNumber >= 0)){
            if(breakoutRooms[roomNumber -1] != null){
        
                breakoutRooms[roomNumber -1].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if((roomNumber <= breakoutRoomLimit) && (roomNumber >= 0)){
            if(breakoutRooms[roomNumber -1] != null){
        
                breakoutRooms[roomNumber -1].openBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms(){
    
        breakoutRoomList = this.name + "\n";
        
        for(int x=0; x < breakoutRoomLimit; x++){
        
            if(breakoutRooms[x]!= null){
            
                breakoutRoomList += breakoutRooms[x].getBreakoutRoomID() + "\n";
            }
            
        }
        
        return breakoutRoomList;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
    
        if(breakoutRooms[roomNumber -1] != null){
        
           return breakoutRooms[roomNumber -1].listParticipants();
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
    
        if(breakoutRooms[roomNumber -1] != null){
        
           return breakoutRooms[roomNumber -1].addParticipant(participantID);
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
    
        for(int x =0;x < breakoutRoomLimit;x++){
            if(breakoutRooms[x].findParticipant(participantID) != null)
                return breakoutRooms[x].getBreakoutRoomID();
        }
        
        return null;
    }
    
    public static void main(String args[]){
        VirtualRoom vm = new VirtualRoom("OOP");
        vm.createBreakoutRooms();
        BreakoutRoom br = vm.findBreakoutRoom(1);
        System.out.println(br.getBreakoutRoomID());
        
    }
}

