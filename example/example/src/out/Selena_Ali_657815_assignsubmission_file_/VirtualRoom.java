package out.Selena_Ali_657815_assignsubmission_file_;// 816017254
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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
        this.name= name;
        breakoutRoomLimit= 5;
        breakoutRooms= new BreakoutRoom[5];
    }

    public VirtualRoom (String name, int limit){
        this.name= name;
        breakoutRoomLimit= limit;
        BreakoutRoom[] breakoutRooms= new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRoom(){
        for (int i=0; i<breakoutRoomLimit; i++){
            this.breakoutRooms[i]= new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom (int roomNumber){
        int x= 0;
        String ID = name + roomNumber;
        
        while (x != breakoutRoomLimit){
                if (breakoutRooms[x].getBreakoutRoomID().equals(ID))
                return breakoutRooms[x];
                
                x++;
        }
        
        return null;
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        int x= 0;
        String ID= name + roomNumber;
        
        if (breakoutRooms[x] == null)
        return false;
        
        else{
            while (breakoutRooms[x] != null){
                if (breakoutRooms[x].getBreakoutRoomID() == ID){
                    breakoutRooms[x].closeBreakoutRoom();
                    return true;
                }
                
                x++;
            }
        }
        
        return false;
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        if (breakoutRooms[roomNumber].equals(findBreakoutRoom(roomNumber))){
            breakoutRooms[roomNumber].openBreakoutRoom();
            return true;
        }
        
        return false;
    }
    
    public String listBreakoutRooms(){
        String output;
        output= name + "\n";
        
        int length= breakoutRooms.length;
        
        if (length == 0){
            output= output + "No breakout rooms open";
            return output;
        }
        
        for (int i= 0; i<length; i++){
            output= output + " " + breakoutRooms[i].getBreakoutRoomID();
        }
        
        return output;
    }
    
    public String listParticipantsInBreakoutRoom (int roomNumber){
        BreakoutRoom br= findBreakoutRoom(roomNumber);
        
        if (br == null)
        return null;
        
        else 
        return br.listParticipants();
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        String ID= name + roomNumber;
        
        for (int i= 0; i<breakoutRooms.length; i++){
            if (breakoutRooms[i].getBreakoutRoomID() == ID){
                if (breakoutRooms[i].addParticipant(participantID) == true)
                    return true;
                
                else
                    return false;
            }
        }
        
        return false;
    } 
    
    public String findParticipantBreakoutRoom (String participantID){
        for (int i=0; i<breakoutRooms.length; i++){
            if (breakoutRooms[i].findParticipant(participantID) != null)
                return breakoutRooms[i].getBreakoutRoomID();
        }
            
            return null;
    }
}
