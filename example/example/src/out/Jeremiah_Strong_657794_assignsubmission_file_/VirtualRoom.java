package out.Jeremiah_Strong_657794_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (Jeremiah Strong)
 * @ID: 816023620
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
    {   //Constructor 
        // initialise instance variables
       this.name = name;
       this.breakoutRoomLimit = 5;
       this.breakoutRooms = new BreakoutRoom[this.breakoutRoomLimit];
    }
    
    
    public VirtualRoom ( String name , int limit){
        this.name = name;
       breakoutRoomLimit = limit;
       breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public String getVRName(){
        return this.name;
    }
    
    public int getNumberOfBreakoutRooms(){
        return this.breakoutRooms.length; 
    }
    
    
    public void createBreakoutRooms(){
        String name = this.name;
        int numRooms= getNumberOfBreakoutRooms();
        for(int i=0; i<numRooms; i++){
            
            this.breakoutRooms[i]= new BreakoutRoom(name);
        }
        
    }

    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        int numRooms= getNumberOfBreakoutRooms();
        String id;
        String RoomID= this.name + roomNumber;
        for(int i=0; i<numRooms; i++){
            id=breakoutRooms[i].getBreakoutRoomID(); 
            if(id.equals(RoomID) )
                return breakoutRooms[i];
        }
        return null;
    }
    
    public boolean isPresent(int roomNumber){
        BreakoutRoom b= findBreakoutRoom( roomNumber);
        if(b==null)
            return false;
        else
            return true;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        int numRooms= getNumberOfBreakoutRooms();
        String id;
        String RoomID= this.name + roomNumber;
        for(int i=0; i<numRooms; i++){
            id=breakoutRooms[i].getBreakoutRoomID(); 
            if(id.equals(RoomID) ){
                breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
        }
        
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        int numRooms= getNumberOfBreakoutRooms();
        //System.out.println(" Number of Rooms: " + numRooms);
        String id;
        String RoomID= this.name + roomNumber;
        for(int i=0; i<numRooms; i++){
            id=breakoutRooms[i].getBreakoutRoomID(); 
            if( id.equals(RoomID) ){
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
        
        return false;
    }
    
    public String listBreakoutRooms( ){
        String details="Virtual Room Name: " + this.name;
        details+= "\nBreakoutRoom IDs: ";
        int numRooms= getNumberOfBreakoutRooms();
        
        for( int i=0; i<numRooms; i++){
            details+= breakoutRooms[i].getBreakoutRoomID();
            if(i+1 !=numRooms)
                details+="\n ";
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String RoomName= this.name + roomNumber;
        String info= "";
        int numRooms= getNumberOfBreakoutRooms();
        
        for( int i=0; i<numRooms; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(RoomName) ){
                info+= breakoutRooms[i].listParticipants();
                return info;
            }
        }
        
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        String RoomName= this.name + roomNumber;
        int numRooms= getNumberOfBreakoutRooms();
        
        
        for( int i=0; i<numRooms; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(RoomName) ){
                
                if(breakoutRooms[i].isFull()){
                    System.out.println(breakoutRooms[i].getBreakoutRoomID() 
                    + " is full.");
                    
                    return false;
                }
               
                breakoutRooms[i].addParticipant(participantID);
                return true;
            }
        
        }
    return false;
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        String length= "" + participantID.length();
        if(length.equals("8") && participantID!= null){
           String id;
           int numRooms= getNumberOfBreakoutRooms();
        
           for( int i=0; i<numRooms; i++){
               id= breakoutRooms[i].getParticipantID(participantID);
                if(id!=null)
                    return breakoutRooms[i].getBreakoutRoomID();
           } 
        }
     
        return null;
    }
    
    public boolean fullBreakoutRoom(int roomNumber){
        int numRooms= getNumberOfBreakoutRooms();
        String id;
        String RoomID= this.name + roomNumber;
        for(int i=0; i<numRooms; i++){
            id=breakoutRooms[i].getBreakoutRoomID(); 
            if(id.equals(RoomID) ){ //finds the breakoutRoom
                if( breakoutRooms[i].isFull() )
                    return true;
                else 
                    return false; 
            }
                
        }
        System.out.println("Breakout Room " + roomNumber + " could not be found.");
        return false;
    }
    
}
