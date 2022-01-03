package out.Jamie_Mahabir_657666_assignsubmission_file_;
/**
 * VirtualRoomClass
 * 
 * 816019893
 */
public class VirtualRoom 
{
    //attributes
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms= new BreakoutRoom[50];
 
    
    //methods
    
    public VirtualRoom(String name){
    
            this.name=name;
            this.breakoutRoomLimit=5;
            this.breakoutRooms = new BreakoutRoom[5];
    }
    
    
    public VirtualRoom(String name, int limit){
    
        this.name=name;
        this.breakoutRoomLimit=limit;
        this.breakoutRooms = new BreakoutRoom[10];
        
    }
    
    
    public int getNumberOfBreakoutRooms(){
        
        return breakoutRoomLimit;
    }
    
    
    public void createBreakoutRooms(){
    
        int i=0;
        for(i=0; i<getNumberOfBreakoutRooms(); i++){
           breakoutRooms[i] = new BreakoutRoom(name);
        }
    
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
    
        int i=0;
        for(i=0; i<getNumberOfBreakoutRooms();i++){
            
            if (breakoutRooms[i]==breakoutRooms[roomNumber]){
                return breakoutRooms[i];
            }
            
        }
        
       return null; 
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
    
        BreakoutRoom closeRoom=findBreakoutRoom(roomNumber);
        
        if(closeRoom==null){
            return false;
        }
        else{
            closeRoom.closeBreakoutRoom();
            return true; //close room
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
    
        BreakoutRoom openRoom=findBreakoutRoom(roomNumber);
        
        if(openRoom==null){
            return false;
        }
        else{
            openRoom.openBreakoutRoom();
            return true; //open room;
        }
    }
    
    
    public String listBreakoutRooms(){
        
        int i=0;
        String name;
        
        name=this.name;
        name+="\n";
        
        for(i=0; i<getNumberOfBreakoutRooms(); i++){
            name+=breakoutRooms[i].toString();
            name+="\n";
            
        }
        
        return name;
      
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
    
        BreakoutRoom found=findBreakoutRoom(roomNumber);
        String listOfFound;
        
        if(found==null){
            return null;
        }
        else{
            listOfFound=found.listParticipants();
            
            return listOfFound;
        }
    
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int  roomNumber){
    
           boolean addNew=false;
           
           BreakoutRoom addNewParticipant=findBreakoutRoom(roomNumber);
           
           if(addNewParticipant==null){
               return false;
            }
            else{
                addNew=addNewParticipant.addParticipant(participantID);
           }
           
            return addNew;
    
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        
        
        
        BreakoutRoom locateBreakoutRoom;
        
        String found;
        
        int i=0;
        
        for(i=0; i<getNumberOfBreakoutRooms();i++){
            if(breakoutRooms[i].findParticipant(participantID)!=null){
                return breakoutRooms[i].toString();
            }
        }
        found="Participant not found.";
        
        return found;
    }
    
}
