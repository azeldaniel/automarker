package out.Chrissanee_Abraham___James_657678_assignsubmission_file_;
/**
 Name:Chrissanee Abraham-James
 ID: 816000377
 Course: Object Oriented Programming
 Course Code: COMP 2603
 Assignment 1
 */
public class VirtualRoom{
    private String name = new String("");
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms= new BreakoutRoom[5];
    
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        int i = 0;  
        
        //System.out.println("Room Name: "+name+"\nBreakoutRoom Limit: "+breakoutRoomLimit);
        createBreakoutRooms();
    }
    
    public VirtualRoom( String name, int limit) {
        //Overloaded constructor. Initialises the breakoutRoomLimit to the supplied limit
        this.name = name;
        this.breakoutRoomLimit = limit;
        
        BreakoutRoom[] breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        createBreakoutRooms();
        
    }
    
    public int getNumberOfBreakoutRooms( ) { //Returns the total number of breakout rooms managed by the virtual room
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){ 
    //Creates new BreakoutRoom objects that fill the list of breakout rooms
        
        String output = new String ("");
        int i = 0;  
            
        String name = new String("Workshop ");
        for(i=0;i<5;i++){
            breakoutRooms[i] = new BreakoutRoom(name + (i+1));
            
        }
    
    }
    
    public String toString( ) {
        //Returns a String representation of the aggregated state of the VirtualRoom
        String output = new String ("");
        
        output+= "VirtualRoom "+name;
        output+= "\nBreakoutRooms in VirtualRoom: "+breakoutRoomLimit;
        
        //System.out.println(output);
        return output;
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber) { //WORKS
    //Locates and returns the breakout room with the supplied room number, otherwise returns null
        if(roomNumber>=breakoutRoomLimit||roomNumber<0){
            return null;
        }
        //System.out.println("\nBreakoutRoom n: "+roomNumber);
        return breakoutRooms[roomNumber];
        
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){ //WORKS
    //Adds a new participant to the breakout room with the supplied room number if it exists
        boolean check;
        int i = roomNumber;
        String str = participantID;
        //System.out.println("Null pointer thrown, cannot resolve.");
        if(findBreakoutRoom(roomNumber).equals(null)){
            return false;
        }
        
        if(breakoutRooms[i].addParticipant(participantID)){
            return true;
        }else{
            return false;
        }
    }
    
    public String listBreakoutRooms( ) {
        //Returns a list of the breakout rooms managed by the virtual room with the virtual room name heading the list on a separate line
        int c=0;
        int i=getNumberOfBreakoutRooms( );
        String output = new String("");   
        
        for(c=0;c<i;c++){
            if(findBreakoutRoom(c)==null){
                output+= "No room found at that index.\n";
            }
            if(!breakoutRooms[c].getOpen()){
                output+= "No Breakout Room "+c+" exists.\n";
            }
            
            output+= breakoutRooms[c].toString()+"\n";
        }
        
        
        return output;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){ //WORKS
        //Returns a list of the participants in the breakout room with the supplied room number if found, otherwise returns null
        int c=0;
        String output = "";
        String out = "";
        if(findBreakoutRoom(roomNumber)==null){
            output+= "\nNo room found at that index.\n";
            return output;
        }
        //output+= breakoutRooms[roomNumber].getBreakoutRoomID()+" "+breakoutRooms[roomNumber].getOpen;
        output+= breakoutRooms[roomNumber].listParticipants( );
        output+= "\nNumber of Participants present: "+breakoutRooms[roomNumber].getNumberOfParticipants();
        
        return output;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){ //WORKS
        //Closes a breakout room with the supplied room number if it exists
        if(roomNumber<0 || roomNumber>breakoutRoomLimit){
            System.out.println("Invalid Room Index.");
            return true;
        }
        breakoutRooms[roomNumber].closeBreakoutRoom( );
        return false;
    }

    public boolean openBreakoutRoom(int roomNumber){ //WORKS
        //Opens a breakout room with the supplied room number if it exists
        
        if(roomNumber<0 || roomNumber>breakoutRoomLimit){
            System.out.println("Invalid Room Index.");
            return false;
        }
        breakoutRooms[roomNumber].openBreakoutRoom( );
        return true;
    }
    
    public String findParticipantBreakoutRoom (String participantID){ //WORKS
        //Locates and returns the breakoutRoomID for the breakout room hosting the participant with the (valid) supplied ID, otherwise returns null
        
        int i;
        String details ="";  
        String test =new String("");
        
        for(i=0;i<(getNumberOfBreakoutRooms());i++){
            test=breakoutRooms[i].listParticipants( );
            if(test.contains(participantID)){
                details += i;
                return details;
            }
        }
        return null;
         
    }
    
    
}
