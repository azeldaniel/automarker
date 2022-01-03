package out.Xern_Mottley_657730_assignsubmission_file_;//816019358
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    private int numberOfBreakoutRooms=0;
    
    public VirtualRoom( String name){
        this.name=name;
        breakoutRoomLimit=5;
        breakoutRooms= new BreakoutRoom[breakoutRoomLimit];
    }
    public VirtualRoom( String name, int limit){
        this.name=name;
        breakoutRoomLimit=limit;
        breakoutRooms= new BreakoutRoom[breakoutRoomLimit];
    }
    public int getNumberOfBreakoutRooms(){
        numberOfBreakoutRooms=0;
        for(int i=0; i< breakoutRoomLimit; i++){
            if(breakoutRooms[i]!=null){
                numberOfBreakoutRooms++;
            }else{
                break;
            }        
        }
        return numberOfBreakoutRooms;
    }
    
    public void createBreakoutRooms(){
        for(int i=0; i<breakoutRoomLimit; i++){
             breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(roomNumber>breakoutRoomLimit || roomNumber<1){
            return null;
        }else{
            return breakoutRooms[roomNumber-1];
        }
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(roomNumber>breakoutRoomLimit || roomNumber<1){
            return false;
        }else{
            breakoutRooms[roomNumber-1].closeBreakoutRoom();
        }
        return true;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(roomNumber>breakoutRoomLimit || roomNumber<1){
            return false;
        }else{
            breakoutRooms[roomNumber-1].openBreakoutRoom();
        }
        return true;
    }
    
    public String listBreakoutRooms(){
        String list= name+"\n";
        for(int i=0; i< breakoutRoomLimit; i++){
            list+= breakoutRooms[i].getBreakoutRoomID()+"\n";
        }
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String List;
        if(roomNumber>breakoutRoomLimit || roomNumber<1){
            return null;
        }else{
            List= breakoutRooms[roomNumber-1].listParticipants();
        }
        return List;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        if(roomNumber>breakoutRoomLimit || roomNumber<1){
            return false;
        }else{
            breakoutRooms[roomNumber-1].addParticipant(participantID);
        }
        return true;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        int i;
        for( i=0; i<breakoutRoomLimit; i++){         
            if(breakoutRooms[i].findParticipant(participantID)!=null){
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        return null;
    }
            
            
        
  
}
