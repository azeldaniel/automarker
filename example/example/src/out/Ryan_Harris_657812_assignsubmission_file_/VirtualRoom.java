package out.Ryan_Harris_657812_assignsubmission_file_;/*
 * 
 * ID: 816021062
 * Name: Ryan Harris
 * 
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    
    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit=5;
        breakoutRooms = new BreakoutRoom[5];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        for (int i = 0; i < breakoutRoomLimit; i++){
            breakoutRooms[i]= new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom (int roomNumber){
        String search = name + roomNumber;
        
        for (int i=0; i< breakoutRoomLimit; i++){
            if (search.equals(breakoutRooms[i].getBreakoutRoomID())){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        String result = "";
        BreakoutRoom found = findBreakoutRoom(roomNumber);
        if (found != null && found.getOpen()){{
                found.closeBreakoutRoom();
                return true;
            }
        }else return false;
        
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        String search = name + roomNumber;
        
        for (int i=0; i< breakoutRoomLimit; i++){
            if (search.equals(breakoutRooms[i].getBreakoutRoomID())){
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String listRooms = "";
        for (int i=0; i< breakoutRoomLimit; i++){
            listRooms+= breakoutRooms[i].getBreakoutRoomID() + " \n ";
        }
        return listRooms;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String result = "";
        BreakoutRoom found = findBreakoutRoom(roomNumber);
        if (found != null){
            result = "Breakout Room: " + found.getBreakoutRoomID() + "\n";
            if (found.getOpen()) result+= found.listParticipants();
            else result += "Room is closed";
        }else result = null;
        
        return result;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        String search = name + roomNumber;
        BreakoutRoom found = findBreakoutRoom(roomNumber);
        if (found != null && found.getOpen()){
            if (found.addParticipant(participantID)){
                //System.out.println("Participant Added");
                return true;
            }else{
                System.out.println("Error Occured with "+ participantID);
                return false;
            }
        
        }
        System.out.println("Breakout Room does not exist");
        return false;
                
            
    }
    
    public String findParticipantBreakoutRoom(String participantID){

        
        for (int i=0; i< breakoutRoomLimit; i++){
            if (breakoutRooms[i].findParticipant(participantID) != null){
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        System.out.println("Breakout Room with this ID does not exist");
        return null;
                
            
    }
    
    public int getBreakoutRoomLimit(){
        return breakoutRoomLimit;
    }
    
    public boolean isBreakoutRoomOpen(int room){
        String search = name + room;
        BreakoutRoom found = findBreakoutRoom(room);
        return found.getOpen();
        
    }
    
    public boolean testID(String participantID){
        return breakoutRooms[0].testID(participantID);
    }
    
    public boolean isFull(int room){
        BreakoutRoom found = findBreakoutRoom(room);
        
        return (found.getNumberOfParticipants() == found.getBreakoutRoomSize());
        
    }
    
}
