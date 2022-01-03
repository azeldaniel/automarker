package out.Jardel_Davis_657684_assignsubmission_file_;
//816017045
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
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit)
    {
        // initialise instance variables
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

      
    public int getNumberOfBreakoutRooms()
    {
        // put your code here
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        for(int i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit; i++){
            if(i+1 == roomNumber){
                return breakoutRooms[i];
            }
        }
        
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit; i++){
            if(i+1 == roomNumber){
                breakoutRooms[i].closeBreakoutRoom();
                
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit; i++){
            if(i+1 == roomNumber){
                breakoutRooms[i].openBreakoutRoom();
                
            }
        }
        return true;
    }
    
    public String listBreakoutRooms(){
        String details = name + "\n";
        for(int i=0; i<breakoutRoomLimit; i++){
            details+=name + "_" + (i+1) + "\n";
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String details="";
        for(int i=0; i<breakoutRoomLimit; i++){
            if(i+1 == roomNumber){
                details+= breakoutRooms[i].listParticipants()+"\n";
                return details;
            }
            
        }
        
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        boolean flag=false;
        for(int i=0; i<breakoutRoomLimit; i++){
            if(i+1 == roomNumber){
                flag = breakoutRooms[i].addParticipant(participantID);
            }
        }
        return flag;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        int i = 0;
        while(i < breakoutRoomLimit){
            if(breakoutRooms[i].findParticipant(participantID).getParticipantID().equals(participantID)){
                return breakoutRooms[i].getBreakoutRoomID();
            }
            i++;
        }
        return null;
    }
}
