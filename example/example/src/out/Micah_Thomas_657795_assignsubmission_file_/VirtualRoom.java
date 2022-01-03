package out.Micah_Thomas_657795_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private int breakoutRoomLimit;
    private String name;
    private BreakoutRoom[] breakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name){
        // initialise instance variables
        this.name = name;
        this.breakoutRoomLimit = 5;
        //this.breakoutRooms;
    }
    public VirtualRoom(String name, int limit){
        // initialise instance variables
        name = name;
        breakoutRoomLimit = limit;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getNumberOfBreakoutRooms(){
        return breakoutRooms.length;
    }
    
    public void createBreakoutRooms(){
        BreakoutRoom[] breakoutRooms = new BreakoutRoom[5];
        BreakoutRoom b1 = new BreakoutRoom();
        BreakoutRoom b2 = new BreakoutRoom();
        BreakoutRoom b3 = new BreakoutRoom();
        BreakoutRoom b4 = new BreakoutRoom();
        BreakoutRoom b5 = new BreakoutRoom();
    }
    
    private BreakoutRoom findBreakoutRoom(int roomNumber){
        BreakoutRoom[] breakoutRooms = new BreakoutRoom[5];
        for(int i=0; i<5; i++){
            if(breakoutRooms[i].getbreakoutRoomNumberCounter() == roomNumber){
                return breakoutRooms[i];
            }                            
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRooms = new BreakoutRoom();
        breakoutRooms = findBreakoutRoom(roomNumber);
        if(breakoutRooms.getOpen() == true){
            breakoutRooms.closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRooms = new BreakoutRoom();
        breakoutRooms = findBreakoutRoom(roomNumber);
        if(breakoutRooms.getOpen() == false){
            breakoutRooms.openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    private String listBreakoutRooms(){
        String list = name + " list of breakout rooms\n";
        for(int i=0; i<breakoutRooms.length; i++){
            list = list.concat(breakoutRooms[i].getbreakoutRoomID());
        }
        return list;
    }
    
    private String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRooms = new BreakoutRoom();
        breakoutRooms = findBreakoutRoom(roomNumber);
        return breakoutRooms.getListParticipants();
    }
    
    private boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        BreakoutRoom[] breakoutRooms = new BreakoutRoom[5];
        return breakoutRooms[roomNumber].getAddParticipant(participantID);
    }
    
    private String findParticipantBreakoutRoom (String participantID){
        BreakoutRoom[] breakoutRooms= new BreakoutRoom[5];
        for (int i=0; i<5; i++){
            if(breakoutRooms[i].getFindParticipant(participantID)==true){
                return breakoutRooms[i].getbreakoutRoomID();
            }
        }
        return null;
    }
    
    public boolean getaddParticipantToBreakoutRoom(String participantID, int roomNumber){
        return addParticipantToBreakoutRoom (participantID, roomNumber);
    }
    
    public String getListParticipants(int roomNumber){
        return listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public String getFindParticipantBreakoutRoom (String participantID){
        return findParticipantBreakoutRoom (participantID);
    }
    
    public String getListBreakoutRooms(){
        return listBreakoutRooms();
    }
    
}
