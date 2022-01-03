package out.Arun_Persaud_657699_assignsubmission_file_;//Arun Persaud 816019788
public class VirtualRoom
{
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
 
    
    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[5];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        BreakoutRoom br1 = new BreakoutRoom("1");
        BreakoutRoom br2 = new BreakoutRoom("2");
        BreakoutRoom br3 = new BreakoutRoom("3");
        BreakoutRoom br4 = new BreakoutRoom("4");
        BreakoutRoom br5 = new BreakoutRoom("5");
        
        breakoutRooms[0] = br1;
        breakoutRooms[1] = br2;
        breakoutRooms[2] = br3;
        breakoutRooms[3] = br4;
        breakoutRooms[4] = br5;
        
    }
    
    public BreakoutRoom findBreakoutRooms(int roomNumber){
        for(int i=0;i<breakoutRoomLimit;i++){
            if((breakoutRooms[i].getBreakoutRoomID()) 
            == roomNumber){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        for(int i=0;i<breakoutRoomLimit;i++){
            if((breakoutRooms[i].getBreakoutRoomID()) 
            == roomNumber){
                breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        for(int i=0;i<breakoutRoomLimit;i++){
            if((breakoutRooms[i].getBreakoutRoomID()) 
            == roomNumber){
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String details = "";
        System.out.println(name);
        
        for(int i=0; i < breakoutRoomLimit;i++){
          details += "Workshop " + breakoutRooms[i].getStringBreakoutRoomID() + "\n";
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String details = "";
            
            for(int i=0;i<breakoutRoomLimit;i++){
                details += breakoutRooms[roomNumber].getParticipants(i) + "\n" ;
            }
        
        return details;
    }
    
    
    public boolean addParticipantToBreakoutRoom(String participantID, 
    int roomNumber){
        for(int i=0;i<breakoutRoomLimit;i++){
            if((breakoutRooms[i].getBreakoutRoomID()) 
            == roomNumber){
                breakoutRooms[i].addParticipant(participantID);
                return true;
            }
        }
        return false;
    }
    
    
    public String findParticipantBreakoutRoom(String participantID){
        String data;
        for(int i=0;i<5;i++){
            if((breakoutRooms[i].findParticipant(participantID)) == null){
                data = breakoutRooms[i].getStringBreakoutRoomID();
                return data;
            }
        }   
         
       return null;
    } 
}
