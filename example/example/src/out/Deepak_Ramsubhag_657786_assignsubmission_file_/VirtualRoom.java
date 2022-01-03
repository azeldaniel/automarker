package out.Deepak_Ramsubhag_657786_assignsubmission_file_;
/**
 Deepak Ramsubhag
 816016482
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
   
    public VirtualRoom(String name){
       breakoutRoomLimit=5;
       this.name=name;
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        
        for(int i=0; i<breakoutRoomLimit;i++){
            breakoutRooms[i] = new BreakoutRoom(name);
            breakoutRooms[i].openBreakoutRoom();
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){ 
        String breakoutRoomName = this.name + Integer.toString(roomNumber);
        for(int i=0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(breakoutRoomName)){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom room=findBreakoutRoom(roomNumber);
        if(room!=null){
            room.closeBreakoutRoom();
            if(room.getOpen()==false){
                return true;
            }
        }
       
        return false;
    }   
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom room=findBreakoutRoom(roomNumber);
        if(room!=null){
            room.openBreakoutRoom();
            if(room.getOpen()==true){
                return true;
            }
        }
        
        return false;
    }   
    
    public String listBreakoutRooms(){
        String details = name;
        for(int i=0;i<breakoutRooms.length;i++){
            details += "\n" + breakoutRooms[i].getBreakoutRoomID();
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom room = findBreakoutRoom(roomNumber);
        String details = room.listParticipants();
        return details;
    }
        
    public boolean addParticipantToBreakoutRoom(String participantID,int roomNumber){
        BreakoutRoom room=findBreakoutRoom(roomNumber);
        if(room!=null){
            if(room.addParticipant(participantID)==true){
                return true;
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){//*****************
        
        if(participantID.length()==8 ){
            for(int i=0;i<breakoutRooms.length;i++){
                if(breakoutRooms[i].findParticipant(participantID)!=null){
                    return breakoutRooms[i].getBreakoutRoomID();
                }
            }
        }
        return null;
    }
        
}
