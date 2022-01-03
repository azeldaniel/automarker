package out.Jayson_Hicks_657770_assignsubmission_file_;//Student ID:816000935
public class VirtualRoom extends BreakoutRoom
{
    // instance variables - replace the example below with your own

    private String name;
    private final int breakoutRoomLimit = 5;
    private BreakoutRoom[] breakoutRooms;
   
    
    VirtualRoom(){       
        
                
    }
    
    VirtualRoom(String name){ 
        this.name = name; // sets local to global
        //breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
                
    }
    
    VirtualRoom(String name, int limit){
        this.name = name;
        //this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];
    }
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
        
    }
    public void createBreakoutRooms(){
        
        for (int i=0; i<breakoutRoomLimit;i++){
           BreakoutRoom room = new BreakoutRoom(name + (i+1));
           breakoutRooms[i] = room;
           
        }
        
    }
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if ((roomNumber > breakoutRoomLimit)|| (roomNumber <= 0)){
            return null;
        }
        return breakoutRooms[roomNumber-1];
    }
        
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom found = findBreakoutRoom(roomNumber);
        if(found==null){
            
         return false;
        }
        found.closeBreakoutRoom();
        return true;
    }    
    public boolean openBreakoutRoom(int roomNumber){
         BreakoutRoom found = findBreakoutRoom(roomNumber);
        if(found==null){
            return false;
        }
        found.openBreakoutRoom();
        return true;
    }
    public String listBreakoutRooms(){
        String RoomList= "";
        
        for (int i=0; i<breakoutRoomLimit;i++){
            RoomList += name + (i+1)+ ", ";
        }
        return name +"\n" + RoomList;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom found = findBreakoutRoom(roomNumber);
        if (found == null){
            return null;
        }
        else{
            return found.listParticipants();
            
        }
    }
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom found = findBreakoutRoom(roomNumber); 
        if (found == null){
            return false;
        }
        else
            
            return found.addParticipant(participantID);
    }    
    public String findParticipantBreakoutRoom(String participantID){
        String FoundRoom = "";
        int count=0;

        for (int i=0; i<breakoutRoomLimit;i++){
            Participant found = breakoutRooms[i].findParticipant(participantID); 
            if(found ==null){
                count++;
                
            }else{
            
            FoundRoom+=(name + (i+1));
            break;
            
            }
        }
        
        return FoundRoom;
    }
}

    

