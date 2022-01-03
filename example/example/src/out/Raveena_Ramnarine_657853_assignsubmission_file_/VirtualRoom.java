package out.Raveena_Ramnarine_657853_assignsubmission_file_;//816022556
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    
    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5];
 
    }
    
    public VirtualRoom (String name, int limit){
        this.name=name;
        breakoutRooms=new BreakoutRoom[limit];
        breakoutRoomLimit=limit;
    }
    
   
     public int getNumberOfBreakoutRooms(){
         return breakoutRoomLimit;
        }
     
    
    public void createBreakoutRoom(){
        for(int y=0; y < breakoutRoomLimit; y=y+1){
           this.breakoutRooms[y]= new BreakoutRoom(name);
        }
 
          
        }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int u=1; u<=breakoutRoomLimit; u=u+1){
            if(roomNumber == u){
                return breakoutRooms[u];
        }
    }
    return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber].equals(findBreakoutRoom(roomNumber))){
            breakoutRooms[roomNumber].closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    
    public boolean openBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber].equals(findBreakoutRoom(roomNumber))){
            breakoutRooms[roomNumber].openBreakoutRoom();
            return true;
            
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String breakoutRoomList="Workshop ";
        for(int u=0; u<breakoutRoomLimit; u=u+1){
          breakoutRoomList += breakoutRooms[u].toString()+ "   "; 
        }
        return breakoutRoomList;
    }
    
    public String listParticipantInBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber].equals(findBreakoutRoom(roomNumber))){
            return breakoutRooms[roomNumber].listParticipants();
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        if(breakoutRooms[roomNumber].equals(findBreakoutRoom(roomNumber))){
            breakoutRooms[roomNumber].addParticipant(participantID);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
     for(int l=0;l<breakoutRoomLimit;l++){
        BreakoutRoom breakoutRooms= findBreakoutRoom(l);
        if(breakoutRooms.findParticipant(participantID)!=null){
            return breakoutRooms.getBreakoutRoomID();
        }
    } 
     return null;
}
    
    
}
//lecture notes,labs 
//Java Tutorial. https://www.w3schools.com/java/default.asp.