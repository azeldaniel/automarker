package out.Brandon_Rampersad_657676_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author 816019037
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = null;
    }
    
     public VirtualRoom(String name, int limit)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = null;
    }
    
    public int getNumberOfBreakoutRooms(){
        int x=0;
        while (breakoutRooms[x] != null){
            x++;
        }
        return x;
    }
    
    public void createBreakoutRooms(){
        BreakoutRoom B = new BreakoutRoom(name);
        int num = getNumberOfBreakoutRooms();
        breakoutRooms[num] = B;
    }
    
    public BreakoutRoom findBreakoutRoom (int roomNumber){
        for (int x=0;x<breakoutRoomLimit;x++){
            if(breakoutRooms[x].getbreakoutRoomId().equals(roomNumber)){
                return breakoutRooms[x];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        for (int x =0; x<breakoutRoomLimit;x++){
            if(x == roomNumber){
                breakoutRooms[x].closeBreakoutRoom();
                return true;
            }
        }
        return false;       
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        for (int x =0; x<breakoutRoomLimit;x++){
            if(x == roomNumber){
                breakoutRooms[x].openBreakoutRoom();
                return true;
            }
        }
        return false;     
    }
    
    public String listBreakoutRooms(){
        String list = "Virtual Room:  " + name + "\n\n";
    int x = 0;
    while (x < breakoutRoomLimit){
        list += breakoutRooms[x].getbreakoutRoomId() + "\n";
        x++;
    }
    return list;
    }
    
    public String listParticipantsInBreakoutRoom (int roomNumber){
        String list;
        list = breakoutRooms[roomNumber].listParticipants();
        return list;
            }
        

    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
            for (int x =0; x<breakoutRoomLimit;x++){
            if(x == roomNumber){
                breakoutRooms[x].addParticipant(participantID);
                return true;
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
         for (int x =0; x<breakoutRoomLimit;x++){
            if((breakoutRooms[x].findParticipant(participantID)).equals(participantID)){
                return breakoutRooms[x].getbreakoutRoomId();
            }
        }
        return null;
    }
        
    
    
    

    
    
    
    

            
            
            

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     *
    public int sampleMethod(int y)
    {
        // put your code here
       
    }*/
}
