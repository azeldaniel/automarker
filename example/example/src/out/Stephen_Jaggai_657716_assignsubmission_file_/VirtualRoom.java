package out.Stephen_Jaggai_657716_assignsubmission_file_;// 816019082

public class VirtualRoom{
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom( String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = breakoutRooms;
    }
    
    public VirtualRoom( String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = breakoutRooms;
    }
    
    public int getNumberOfBreakoutRooms( ){
        int i;
        for (i=0; i<100; i++){
            if (breakoutRooms[i].breakoutRoomID != null){
                i++;
            }
        }
        return i;
    }
    
    public void createBreakoutRooms( ){
        BreakoutRoom breakoutroom = new BreakoutRoom (name);
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for (int i=1; i<=5; i++){
            if (breakoutRooms[i].uniqueId == roomNumber){
                return breakoutRooms[i];
            }
        }    
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        for (int i=1; i<=5; i++){
            if (breakoutRooms[i].uniqueId == roomNumber){
                return false;
            }
        }
        return true;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        for (int i=1; i<=5; i++){
            if (breakoutRooms[i].uniqueId == roomNumber){
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms( ){
        String listname = name + '\n';
        String listbreakoutrooms = new String();
        String list;
        for (int i=1; i<=5; i++){
            listbreakoutrooms = breakoutRooms[i].breakoutRoomID + ", ";
        }
        list = listname + listbreakoutrooms;
        return list;
    }
    
    public String listParticipantsInBreakoutRoom (int roomNumber){
        for (int i=1; i<=5; i++){
            if (breakoutRooms[i].uniqueId == roomNumber){
                String list = breakoutRooms[i].listParticipants();
                return list;
            }
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        for (int i=1; i<=5; i++){
            if (breakoutRooms[i].uniqueId == roomNumber){
                breakoutRooms[i].addParticipant (participantID);
                return true;
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        for (int i=1; i<=5; i++){
            breakoutRooms[i].findParticipant (participantID);
            return breakoutRooms[i].breakoutRoomID;
        }
        return null;
    }
}