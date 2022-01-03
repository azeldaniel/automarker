package out.Derwin_Jack_657816_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (Derwin Jack 816022295)
 * @version (14/02/2021)
 */
public class VirtualRoom
{
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom (String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom (String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms(){
        int count = 0;
        for(int i=0; i< breakoutRoomLimit; i++){
            if(breakoutRooms[i] != null){
                count++;
            }
        }
        return count;
    }
    
    public void createBreakoutRooms(){
        for(int i=0; i< breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);

        }
    }
 
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        int nobr;
        nobr = getNumberOfBreakoutRooms();
        for(int i = 0 ; i < nobr; i++){
            if((breakoutRooms[i].getBreakoutRoomID()).contains(String.valueOf(roomNumber ))){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    

    public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){
             breakoutRooms[roomNumber].closeBreakoutRoom();
             return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){
             breakoutRooms[roomNumber].openBreakoutRoom();
             return true;
        }
        return false;
    }
    
    
    public String listBreakoutRooms(){
        String listBR = "";
        listBR += this.name;
        for(int i =0 ; i < breakoutRoomLimit; i++){
            listBR += "\n";
            listBR += breakoutRooms[i].toString(); 
            listBR += "\n";
        }
        
        return listBR;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){
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
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                return breakoutRooms[i].getBreakoutRoomID();
            }
            
        }
        return null;
    }
}
    

