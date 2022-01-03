package out.Karsten_Lange_657828_assignsubmission_file_; import java.util.*;
public class VirtualRoom{
        private String name;
        private final int breakoutRoomLimit;
        private BreakoutRoom[] breakoutRooms;
    
    //Constructor
    public VirtualRoom(String name){
        
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5];
    }
    
    
    //Overloaded Constructor
    public VirtualRoom(String name, int limit){
        
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[5];
    }
    
    
    //Accessor for Number of Breakout Rooms
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
        
    }
    
    public void createBreakoutRooms(){
        for(int i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom( int roomNumber){
        String roomToLocate = name + String.valueOf(roomNumber);
        String temp;
        for(int i=0; i<breakoutRoomLimit; i++){
            temp = breakoutRooms[i].getBreakoutRoomID();
            if(roomToLocate.compareTo(temp) == 0){
                return breakoutRooms[i];
            }
            
        }
        return null;
    }
    
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){
            findBreakoutRoom(roomNumber).closeBreakoutRoom();
            return true;
        }
        
        return false;
    }
    
    
    
    public boolean openBreakoutRoom(int roomNumber){
        
        if(findBreakoutRoom(roomNumber) != null){
            findBreakoutRoom(roomNumber).openBreakoutRoom();
            return true;
        }
        
        return false;
        
    }
    
    
    public String listBreakoutRooms(){
        String  list;
        
        list = name;
        list += "\n";
        for(int i=0; i<breakoutRoomLimit; i++){
            
            list +=breakoutRooms[i].getBreakoutRoomID() + "\n";
            
        }
        return list;
    }
    
    
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String list;
        
        if(findBreakoutRoom(roomNumber) != null){
            list = findBreakoutRoom(roomNumber).listParticipants();
            return list ;
        }
        
        return null;
    }
    

    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){
            findBreakoutRoom(roomNumber).addParticipant(participantID);
            return true ;
        }
        
        return false;
    }

    
    public String findParticipantBreakoutRoom(String participantID){
        for (int i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        
        return "";
        
    }
                              
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}