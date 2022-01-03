package out.Kemeisha_Wilson_657772_assignsubmission_file_;/**
 * @author (Kemeisha Wilson 816020815)
 * @version (10/02/2021)
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom breakoutRooms[];
    
    public VirtualRoom(String name)
    {
        this.name=name;
        breakoutRoomLimit=5;
        breakoutRooms=new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit){
        breakoutRoomLimit=limit;
        this.name=name;
        breakoutRooms=new BreakoutRoom[breakoutRoomLimit];
    }
    public int getNumberOfBreakoutRooms(){
      return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms()
    {
        int i=1;
        String ID=name;
        for(int x=0;x<breakoutRoomLimit;x++){
            breakoutRooms[x]= new BreakoutRoom(name);
            name=ID;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        if(roomNumber>breakoutRoomLimit){
            System.out.println("Breakout room does not exist");
            return null;
        }
        for(int x=0;x<breakoutRoomLimit;x++){
            if(roomNumber==x)
                return breakoutRooms[roomNumber];
        }
        System.out.println("Breakout room not found");
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        if(findBreakoutRoom(roomNumber)!=null){
            breakoutRooms[roomNumber].closeBreakoutRoom();
            return true;
        }
        else
            return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        if(findBreakoutRoom(roomNumber)!=null){
            breakoutRooms[roomNumber].openBreakoutRoom();
            return true;
        }
        else
            return false;
    }
    
    public String listBreakoutRooms()
    {
        String details=" ";
        for(int x=0;x<breakoutRoomLimit;x++){
            details+=breakoutRooms[x].getBreakoutRoomID()+"\n";
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        String details;
        if(findBreakoutRoom(roomNumber)!=null){
            details=breakoutRooms[roomNumber].listParticipants();
            return details;
        }
        details=null;
        return details; 
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        boolean added = false;
        if(findBreakoutRoom(roomNumber)!=null){
            added=breakoutRooms[roomNumber].addParticipant(participantID);
            return added;
        }
        else {
            return added;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        String ID = null;
        int x=0;
        boolean check=true;
        boolean open=false;
        int limit=getNumberOfBreakoutRooms();
        while(check) {
            open=breakoutRooms[x].getOpen();
            if(open){
                if(breakoutRooms[x].findParticipant(participantID)!=null) {
                    return ID = breakoutRooms[x].getBreakoutRoomID();
                }
                else{
                    x++;
                    open=false;
                    if(x==limit)
                        return ID;
                }
            }
        }
        return ID;
    }
}
