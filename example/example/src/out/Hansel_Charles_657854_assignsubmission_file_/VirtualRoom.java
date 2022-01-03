package out.Hansel_Charles_657854_assignsubmission_file_;    
/*
 * HANSEL CHARLES
 * ID: 816011166
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom [] breakoutRooms;
    
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms(){
        int numberOfBr = 0;
        for(int i=0; i< breakoutRoomLimit; i++){
            if(!breakoutRooms[i].equals(null)){
                numberOfBr++;
            }
        }
        return numberOfBr;
    }
    
    public void createBreakoutRooms(){
        /*
        BreakoutRoom b1 = new BreakoutRoom(name);
        BreakoutRoom b2 = new BreakoutRoom(name);
        BreakoutRoom b3 = new BreakoutRoom(name);
        BreakoutRoom b4 = new BreakoutRoom(name);
        BreakoutRoom b5 = new BreakoutRoom(name);
        
        BreakoutRoom [] br = {b1,b2,b3,b4,b5};
        */
        for(int i=0; i < breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
        
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        
        for(int i=0; i < breakoutRoomLimit; i++){
            if((breakoutRooms[i].getBreakoutRoomID()).contains(String.valueOf(roomNumber))){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        
        if(findBreakoutRoom(roomNumber)!=null){
            if(findBreakoutRoom(roomNumber).getOpen()){
                findBreakoutRoom(roomNumber).closeBreakoutRoom();
            }
            return true;  
        }else{
            return false;
        }
        
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        
        if(findBreakoutRoom(roomNumber)!=null){ 
            if(!findBreakoutRoom(roomNumber).getOpen()){
                findBreakoutRoom(roomNumber).openBreakoutRoom();
            }
            return true;  
        }else{
            return false;
        }
            
    }
    
    public String listBreakoutRooms(){
        String details = "";
        details+= this.name;
        
        for(int i=0; i < breakoutRoomLimit; i++){
            details +="\n" + breakoutRooms[i].toString();
              
        }
        
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        
        if(findBreakoutRoom(roomNumber)!=null){
            return findBreakoutRoom(roomNumber).listParticipants();
        }   
            
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        
        if(!findBreakoutRoom(roomNumber).equals(null)){
            breakoutRooms[roomNumber].addParticipant(participantID);
            return true;
        }
        
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        
        for(int i=0; i< breakoutRoomLimit; i++){
            //if(!breakoutRooms[i].findParticipant(participantID).equals(null)){
            if(breakoutRooms[i].findParticipant(participantID)!= null){
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        return null;
    }   
    
}


