package out.Daniel_Herbert_657791_assignsubmission_file_;//816021155
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private int count = 0;
    private BreakoutRoom[] breakout = new BreakoutRoom[5];
    private String list;
    
    
    public VirtualRoom(String name)
    {
       breakoutRoomLimit = 5;
       this.name = name;
    }
    
    public VirtualRoom(String name, int limit)
    {
       this.breakoutRoomLimit = limit;
       this.name = name;
    }
    
    public int getNumberOfBreakoutRooms(){
        return count;
    }
    
    public void createBreakoutRooms(){
        for(int i = 0; i < 5; i++){
            breakout[i] = new BreakoutRoom(this.name);//this.name or name? come back
            count++;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(roomNumber > 0 &&  roomNumber < 5)
            return breakout[roomNumber - 1];
            
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRoom = new BreakoutRoom(this.name);//this.name or name? come back
        breakoutRoom = findBreakoutRoom(roomNumber);
        if(breakoutRoom != null){
            breakoutRoom.closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRoom = new BreakoutRoom(this.name);//this.name or name? come back
        breakoutRoom = findBreakoutRoom(roomNumber);
        if(breakoutRoom != null){
            breakoutRoom.openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String details = "Virtual Room: " + this.name + "\n";
        for(int i = 0; i < count; i++)
            details += breakout[i].getbreakoutRoomID() + "\n";
            
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRoom = new BreakoutRoom(this.name);//this.name or name? come back
        breakoutRoom = findBreakoutRoom(roomNumber);
        
        if(breakoutRoom != null){
            list = breakoutRoom.listParticipants();
            return list;
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        boolean check;
        if(findBreakoutRoom(roomNumber) != null){
            check = findBreakoutRoom(roomNumber).addParticipant(participantID);
            if(check == true)
                return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakout[i]!=null){
            String Temp=breakout[i].findParticipant(participantID).getParticipantID();
                if(participantID.equals(Temp) && Temp!=null)
                    return breakout[i].toString();
                
            }
        }
        return null;
    }
}
