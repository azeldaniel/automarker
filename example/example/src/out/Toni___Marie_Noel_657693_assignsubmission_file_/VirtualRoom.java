package out.Toni___Marie_Noel_657693_assignsubmission_file_;
/**
 * The VirtualRoom class models a virtual room in the virtual
 * meeting system. A virtual room creates and manages a certain 
 * number of breakout rooms.
 *
 * @ Toni-Marie Noel - 816017238
 * @ Jan 31, 2021 
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
        breakoutRoomLimit = 5; 
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit]; 
        this.name = name;
        createBreakoutRooms();
        breakoutRooms[0].reset(); 
    }
   
    //overload
    public VirtualRoom(String name, int limit){
        breakoutRoomLimit= limit;
        breakoutRooms = new BreakoutRoom[limit];
        this.name = name; 
        createBreakoutRooms();
        breakoutRooms[0].reset();
    }
    
    
    public int getNumberOfBreakoutRooms()
     {
        int numBreakoutRoom = 0; 
        for(int i =0 ; i<breakoutRoomLimit; i++)
        {
            if(breakoutRooms[i]!=null)
            numBreakoutRoom++; 
          
        }
        return numBreakoutRoom;
    }
    
      public void createBreakoutRooms(){
        for(int i=0; i<breakoutRoomLimit; i++){
            
            breakoutRooms[i] = new BreakoutRoom(name); 
            
        }
    }
    
     
   public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit; i++)
        {
        if(roomNumber == breakoutRooms[i].getBreakoutRoomNumberCounter())
        return breakoutRooms[i]; 
        }
            return null; 
    }
    
    
   public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber)!=null)
       {
            // find the room
            for(int i=0; i<breakoutRoomLimit; i++)
            {
                if(i+1==roomNumber)
                {
                    breakoutRooms[i].closeBreakoutRoom();
                    return true; 
                }
            }
        } 
        return false; 
    }
    
    
   public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber)!=null)
       {
            // find the room
            for(int i=0; i<breakoutRoomLimit; i++)
            {
                if(i+1==roomNumber)
                {
                    breakoutRooms[i].openBreakoutRoom();
                    return true; 
                }
            }
        } 
        return false; 
    }
    
    
   public String listBreakoutRooms(){
     String list = "";
     list = "Virtual Room: " + name + "\n"; 
     
     for(int i=0; i<breakoutRoomLimit; i++){
        list = list+ breakoutRooms[i].getBreakoutRoomID() + "\n"; 
     }
      
     return list; 
        
    }
    
    
   public String listParticipantsInBreakoutRoom(int roomNumber){
       // find the room
       String list=""; 
       if(findBreakoutRoom(roomNumber)!=null) 
      {
          list= breakoutRooms[roomNumber-1].listParticipants(); 
          return list;
      }
       //list the peeps
       return null; 
    }
    
   
   public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        
        boolean added=false;
        // find the room 
        if(findBreakoutRoom(roomNumber)!=null){
            
          added=breakoutRooms[roomNumber-1].addParticipant(participantID);
        
        }
        return added; 
    }
    
    
   public String findParticipantBreakoutRoom(String participantID){
       // find the participant in the breakout room
       String breakoutID= ""; 
       
       for(int i=0; i<getNumberOfBreakoutRooms(); i++){
           
           if(breakoutRooms[i].findParticipant(participantID)!=null)
           {
               breakoutID = breakoutRooms[i].getBreakoutRoomID();         
               return breakoutID;
            }
           
        }
       return null;
    }
   
    
    // accessor
    public BreakoutRoom[] getBreakoutRoom(){
        return breakoutRooms; 
    }
    
    public int getBreakoutRoomLimit(){
        return breakoutRoomLimit;
    }

    public static void println(Object line) {
    System.out.println(line);
    }
    
    public static void main(String[] args){
        
        VirtualRoom vrChat = new VirtualRoom("VR Chat");
        VirtualRoom vrChat2 = new VirtualRoom("FunHouse",10);
        
        println(vrChat.getNumberOfBreakoutRooms());
        println(vrChat2.getNumberOfBreakoutRooms());
        
        println(vrChat.listBreakoutRooms());
        println(vrChat2.listBreakoutRooms());
        
        int e=0;
        
        while(e < vrChat2.getNumberOfBreakoutRooms()){
            
            if(vrChat2.addParticipantToBreakoutRoom("12324680",e+1))
                println(vrChat2.listParticipantsInBreakoutRoom(e+1));
            
            e++;
        }
            
            
        println(vrChat2.findBreakoutRoom(1));    
        
        if(vrChat2.closeBreakoutRoom(1))
            println("Closed");
        if(vrChat2.addParticipantToBreakoutRoom("12324680",1))
                println(vrChat2.listParticipantsInBreakoutRoom(1));
                
        println(vrChat2.findBreakoutRoom(1));
        if(vrChat2.openBreakoutRoom(1))
            println("Open");
            
        println(vrChat2.findBreakoutRoom(1));
       
        println(vrChat2.listParticipantsInBreakoutRoom(1));
        
        println(vrChat2.findParticipantBreakoutRoom("12324680"));
            
            
    }
    
   
    
}
