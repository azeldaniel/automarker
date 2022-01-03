package out.Zion_Haye_657855_assignsubmission_file_;/*
 Student ID : 816020871
*/
public class VirtualRoom{
 
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom (String name){
        this.name = name;
        breakoutRoomLimit = 5;
        createBreakoutRooms();
    }
    
    public VirtualRoom (String name , int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        createBreakoutRooms();
    }
    
    public int getNumberOfBreakoutRooms(){
        
        return breakoutRoomLimit;
        
    }
    
    public void createBreakoutRooms(){
        
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        
        for(int x =0 ;  x < breakoutRoomLimit ; x++){
            
            breakoutRooms[x] = new BreakoutRoom(name);
            
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
         
        BreakoutRoom breakoutRoom;
        String breakoutRoomName;
        String breakoutRoomID;
        
        breakoutRoomName = name + roomNumber;
        
        for(int x =0 ;  x < breakoutRoomLimit ; x++){
            
            breakoutRoom = breakoutRooms[x];
            breakoutRoomID = breakoutRoom.getBreakoutRoomID();
            
            if(breakoutRoomName.equals(breakoutRoomID)){
               return breakoutRoom;
            }
            
        }
        
        
        return null;
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        
        BreakoutRoom breakoutRoom;
        String breakoutRoomName;
        String breakoutRoomID;
        
        breakoutRoomName = name + roomNumber;
        
        if(roomNumber > breakoutRoomLimit){
            System.out.println("Invalid Room Number.");   
            return false;
        }
        
        
        
        for ( int x = 0 ; x  < breakoutRoomLimit ; x++){
            
            breakoutRoom = breakoutRooms[x];
            breakoutRoomID = breakoutRoom.getBreakoutRoomID();
            
            if(breakoutRoomName.equals(breakoutRoomID)){
               
                if(breakoutRoom.getOpen() == false){
                    return true;
                }
                else {
                    breakoutRoom.closeBreakoutRoom();
                   return true;
                }
            }
            
            
        }
        
        
        return false;
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        
        BreakoutRoom breakoutRoom;
        String breakoutRoomName;
        String breakoutRoomID;
        
        breakoutRoomName = name + roomNumber;
        
        if(roomNumber > breakoutRoomLimit){
            System.out.println("Invalid Room Number.");   
            return false;
        }
        
        for ( int x = 0 ; x  < breakoutRoomLimit ; x++){
            
            breakoutRoom = breakoutRooms[x];
            breakoutRoomID = breakoutRoom.getBreakoutRoomID();
            
            if(breakoutRoomName.equals(breakoutRoomID)){
                
                if(breakoutRoom.getOpen() == true){
                    return true;
                }
                else {
                   breakoutRoom.openBreakoutRoom();
                   return true;
                }
            }
            
            
        }
        
                
        return false;
    }
    
    public String listBreakoutRooms(){
        
        String listOfBreakoutRooms;
        String breakoutRoomID;
        BreakoutRoom breakoutRoom;
        
        
        listOfBreakoutRooms = "Virtual Room :" + name + "\n";
        
        for (int x = 0 ; x < breakoutRoomLimit ; x++){
            breakoutRoom = breakoutRooms[x];
            listOfBreakoutRooms += breakoutRoom.toString();
            
            listOfBreakoutRooms += "\n";
            
        }
        
        return listOfBreakoutRooms;
    }
    
    public String listParticipantsInBreakoutRoom (int roomNumber){
        
        BreakoutRoom breakoutRoom;
        String breakoutRoomName;
        String breakoutRoomID;
        String listOfParticipants;
        
        breakoutRoomName = name + roomNumber;
        
        for(int x =0 ; x < breakoutRoomLimit ; x++){
            
            breakoutRoom = breakoutRooms[x];
            breakoutRoomID =  breakoutRoom.getBreakoutRoomID();
            
            if(breakoutRoomName.equals(breakoutRoomID)){
                  listOfParticipants = breakoutRoom.listParticipants();
                  return listOfParticipants;
            }
            
        }
        
        System.out.println("Breakout Room Not Found.");
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID , int roomNumber){
        
        BreakoutRoom breakoutRoom;
        String breakoutRoomName;
        String breakoutRoomID;
        boolean isSuccessful;
        int flag;
        
        isSuccessful = false;
        flag = 0;
        breakoutRoom = null;
        
        breakoutRoomName = name + roomNumber;
        
        for ( int x = 0 ; x < breakoutRoomLimit ; x++){
            breakoutRoom = breakoutRooms[x];
            breakoutRoomID = breakoutRoom.getBreakoutRoomID();
            
            if(breakoutRoomName.equals(breakoutRoomID)){
               flag = 1;
               isSuccessful = breakoutRoom.addParticipant(participantID);
                
            }
        }
        
        if(flag==0){
             System.out.println("Room Not Found");   
        }
        
        return isSuccessful;
        
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        
        BreakoutRoom breakoutRoom;
        BreakoutRoom breakoutRoomParticipant;
        String breakoutRoomID;
        boolean isFound;
        
        for (int x = 0 ; x < breakoutRoomLimit ; x++){
            breakoutRoom = breakoutRooms[x];        
            
            if(breakoutRoom.findParticipant(participantID)!= null){
                breakoutRoomID = breakoutRoom.getBreakoutRoomID();
                return breakoutRoomID;
            } 
        }
        
        return null;
        
    }
        
        
    
}