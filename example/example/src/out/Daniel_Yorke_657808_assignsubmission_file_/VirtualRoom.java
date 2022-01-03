package out.Daniel_Yorke_657808_assignsubmission_file_;/**
 * 816019400
 */

public class VirtualRoom {
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[ ] breakoutRooms;
    
    VirtualRoom(String name){
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom [breakoutRoomLimit];
        this.name = name;
        createBreakoutRooms( );
        
    }
    public int getNumberOfBreakoutRooms( ){
        int total=0;
        for(int i = 0; i<breakoutRoomLimit;i++){
            total += breakoutRooms[i].breakoutRoomNumberCounter;
        }
        return total;
    }
    public void createBreakoutRooms( ){
        for(int i = 0; i<breakoutRoomLimit;i++){
            breakoutRooms[i] = new BreakoutRoom(String.format("%s%d",name,i+1));
            //System.out.println(" Creaate breakout romm VMS : "+String.format("%s%d",name,i+1));
        }
    }
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        try{
        String key = new String();
        key = String.format("%s%d",name,roomNumber+1);
        //System.out.println("key "+key);
        for(int i=0;i<breakoutRoomLimit;i++){
            //System.out.println("Search for breakrooms --- "+ breakoutRooms[i].breakoutRoomID);
            if(breakoutRooms[i].breakoutRoomID.equals(key)){
                return breakoutRooms[i];
            }
        }
        return null;
        }catch(Exception e){
            System.out.println("Null");
            return null;
        }
    }
    public boolean closeBreakoutRoom(int roomNumber){
        if(!breakoutRooms[roomNumber].open){
            return true;
        }
        breakoutRooms[roomNumber].closeBreakoutRoom();
        return false;
    }
    public boolean openBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber].open){
            return true;
        }
        breakoutRooms[roomNumber].openBreakoutRoom();
        return false;
    }
    public String listBreakoutRooms( ){
        String format = new String();
        format = String.format("%s\n",name);
        for(int i=0;i<breakoutRoomLimit;i++){
            format = format + String.format("%s%d",name,i+1);
        }
        return format;
    }
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom b = findBreakoutRoom(roomNumber);
        if(b == null){
            return null;
        }
        String format = new String();
        format = b.listParticipants();
        return format;
    }
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom b =findBreakoutRoom(roomNumber);
        if(b == null){
            return false;
        }
        //System.out.println("Found breakRoom adding participant -VR");
        return b.addParticipant(participantID);
    }
    public String findParticipantBreakoutRoom(String participantID){
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i].findParticipant(participantID)!= null){
                return breakoutRooms[i].breakoutRoomID;
            }
        }
        return null;
    }
}
