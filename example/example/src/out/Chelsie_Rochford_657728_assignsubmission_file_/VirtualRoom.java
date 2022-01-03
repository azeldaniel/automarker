package out.Chelsie_Rochford_657728_assignsubmission_file_;/**
 *816000366
 */

import java.io.*; 
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        System.out.println(this.name + " created\n"); //test
    }

    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        System.out.println(this.name + " created\n"); //created
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRooms.length;
    }
    
    public void createBreakoutRooms(){
        for (int i=0; i<breakoutRoomLimit; i++){
          breakoutRooms[i] = new BreakoutRoom(name);
          System.out.println(breakoutRooms[i].getBreakoutRoomID());
           
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for (int i=1; i<=breakoutRoomLimit; i++){
            if(roomNumber == i) return breakoutRooms[i-1];
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        for (int i=1; i<=breakoutRoomLimit; i++)
            if(roomNumber == i) {
                breakoutRooms[i-1].closeBreakoutRoom();
                return true;
            }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
         for (int i=1; i<=breakoutRoomLimit; i++)
            if(roomNumber == i) {
                if (breakoutRooms[i-1].getOpen()) return true;
                breakoutRooms[i-1].openBreakoutRoom();
                return true;
            }
        return false;
    }
    
    public String listBreakoutRooms(){
        String list = name + "\n";
        for (int i=0; i<breakoutRoomLimit; i++){
            list+= breakoutRooms[i].getBreakoutRoomID();
            list+= breakoutRooms[i].toString();
            list+= "\n";
        }
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String list = "";
        int j=roomNumber-1;
        if(breakoutRooms[j]!=null){  
            list+= "\n";
            list+= breakoutRooms[j].getBreakoutRoomID();
            list+= "\n";
            list+= breakoutRooms[j].listParticipants();
         
            return list;
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        for (int i=1; i<=breakoutRoomLimit; i++){
            if (roomNumber==i){
                if (breakoutRooms[i-1].addParticipant(participantID))
                    return true;
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        if (participantID.length()!=8) return null;
        
        for (int i=0; i<breakoutRoomLimit; i++){
           if (breakoutRooms[i].findParticipant(participantID)!=null)
             return breakoutRooms[i].getBreakoutRoomID();
        }
         
        return null;
    }
    
}
