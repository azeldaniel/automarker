package out.Josie_Lewis_657720_assignsubmission_file_;
/**
 * Josie Lewis 816020986
 */
public class VirtualRoom
{
    
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRoom;
    private BreakoutRoom Obj;
    
    public VirtualRoom(String name)
    {
        this.name= name;
        breakoutRoomLimit = 5;
        breakoutRoom = new BreakoutRoom[breakoutRoomLimit];
    }

    public VirtualRoom( String name, int limit) {
        this.name= name;
        breakoutRoomLimit = limit;
        breakoutRoom = new BreakoutRoom[breakoutRoomLimit];
        
    }
    
    public int getNumberOfBreakoutRooms( ) {
        int i = 0;
        int count =0;
         while (i< breakoutRoomLimit) { 
             if (breakoutRoom[i]!=null){
             count++;
            }
        }
        return count;
    }
    
    public void createBreakoutRooms( ) {
        int i = 0;
        String temp;
        while (i< breakoutRoomLimit) { 
            temp = "";
            temp += breakoutRoom[i];
             if (breakoutRoom[i]==null){
             breakoutRoom[i]=new BreakoutRoom(name);
            }
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber) {
        int i = 0;
        String temp;
        while (i< breakoutRoomLimit) { 
            temp = "";
            temp += breakoutRoom[i];
             if (roomNumber==i){
             return breakoutRoom[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber) {
        int i=0;
        while (i< breakoutRoomLimit) {
            if (breakoutRoom[roomNumber]==breakoutRoom[i]) {
              breakoutRoom[roomNumber].closeBreakoutRoom();
              return true;
            }
            i++;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber) {
        int i=0;
        while (i< breakoutRoomLimit) {
            if (breakoutRoom[roomNumber]==breakoutRoom[i]) {
              breakoutRoom[roomNumber].openBreakoutRoom();
              return true;
            }
            i++;
        }
        return false;
        
    }
    
    public String listBreakoutRooms( ) {
        int i=0;
        String temp="";
        
        while (i<breakoutRoomLimit) { 
            
            if (breakoutRoom[i] != null){
                temp += breakoutRoom[i] + " "  ;
            }
            i++;
        }               
          return temp; 
        
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber) {
        return breakoutRoom[roomNumber].listParticipants( );
        
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber) {
        if (breakoutRoom[roomNumber] != null) {
            return Obj.addParticipant(participantID);
        }
           return false; 
    }
    
    public String findParticipantToBreakoutRoom(String participantID, int roomNumber) {
         String temp = "";
        if (breakoutRoom[roomNumber] != null) {
            temp += Obj.findParticipant(participantID);
            return temp;
        }
        return null;
    }
}
