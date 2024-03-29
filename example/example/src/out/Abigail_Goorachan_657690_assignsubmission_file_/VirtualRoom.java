package out.Abigail_Goorachan_657690_assignsubmission_file_;/**
 * 816007500
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms(){
        int num=0;
        for(int i=0; i<breakoutRooms.length; i++){
            if(breakoutRooms[i] != null){
                num = num + 1;
            }
        }
        return num;
    }
    
    public void createBreakoutRooms(){
        for(int i=0; i<breakoutRooms.length; i++){
            String nameBR = "BreakoutRoom";
            breakoutRooms[i] = new BreakoutRoom(nameBR);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRooms.length; i++){
            if(breakoutRooms[i].getBreakoutRoomNumberCounter() == roomNumber){
                return breakoutRooms[i];
            }
            else{
                return null;
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        while(findBreakoutRoom(roomNumber) != null){
            findBreakoutRoom(roomNumber).closeBreakoutRoom();
            return true; //breakout room successfully closed
        }
        return false; //breakout room was not closed. perhaps it does not exist
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        while(findBreakoutRoom(roomNumber) != null){
            findBreakoutRoom(roomNumber).openBreakoutRoom();
            return true; //breakout room successfully opened
        }
        return false; //breakout room was not opened. perhaps it does not exist
    }
    
    public String listBreakoutRooms(){
        System.out.println("Virtual Room Name: " + name + "\n");
        for(int i=0; i<breakoutRooms.length; i++){
            return breakoutRooms[i].toString();
        }
        return null;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        while(findBreakoutRoom(roomNumber) != null){
            return findBreakoutRoom(roomNumber).listParticipants();
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        while(findBreakoutRoom(roomNumber) != null){
            findBreakoutRoom(roomNumber).addParticipant(participantID);
            return true; //participant successfully added to breakout room
        }
        return false; //participant was not added to breakout room. perhaps room does not exist or participant is already in room or the ID is not valid
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int i=0; i<breakoutRooms.length; i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                return breakoutRooms[i].getBreakoutRoomID();
            }
            else{
                return null;
            }
        }
        return null;
    }
    
    //https://stackoverflow.com/questions/4441099/how-do-you-count-the-elements-of-an-array-in-java 
}
