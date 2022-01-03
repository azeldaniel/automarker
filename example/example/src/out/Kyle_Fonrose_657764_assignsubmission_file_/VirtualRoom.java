package out.Kyle_Fonrose_657764_assignsubmission_file_;//NAME: KYLE E. FONROSE
//ID: 816002546
//TITLE: ASSIGNMENT 1


public class VirtualRoom{
   
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    //constructor
    public VirtualRoom(String name){
        // initialise instance variables
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[5];
        
    }
    
    //overloaded constructor
    public VirtualRoom(String name, int limit){
        // initialise instance variables
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[10];
    }

    public int getNumberOfBreakoutRooms(){
        //System.out.println(breakoutRooms.length);
        return breakoutRooms.length;
    }
    
    public void createBreakoutRooms(){

        for(int i=0; i<breakoutRoomLimit; i++){   
             breakoutRooms[i] = new BreakoutRoom(name);
             System.out.println("Breakout RoomID: " + breakoutRooms[i].getBreakoutRoomID());
             
        }
       
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
     String roomNum = name + Integer.toString(roomNumber);
   
     for(int i=0; i<getNumberOfBreakoutRooms(); i++){
       
        if(breakoutRooms[i].getBreakoutRoomID().equals(roomNum)){
        System.out.println("FOUND " + breakoutRooms[i].getBreakoutRoomID());
        return breakoutRooms[i];
        }
     }
    
     return null;
    }
    
    
    public boolean closeBreakoutRoom(int roomNumber){
     String roomNum = name+ Integer.toString(roomNumber);
    
     for(int i=0; i<getNumberOfBreakoutRooms(); i++){
       if(breakoutRooms[i].getBreakoutRoomID().equals(roomNum)){
            breakoutRooms[i].closeBreakoutRoom();
            System.out.println(breakoutRooms[i].getBreakoutRoomID() + ": Room Closed");
            return true;
        }
     }
    
     return false; 
    }
    
    public boolean openBreakoutRoom(int roomNumber){
     String roomNum = name + Integer.toString(roomNumber);
    
     for(int i=0; i<getNumberOfBreakoutRooms(); i++){
       if(breakoutRooms[i].getBreakoutRoomID().equals(roomNum)){
            breakoutRooms[i].openBreakoutRoom();
            return true;
        }
     }
     return false; 
    }
    
    
    public String listBreakoutRooms(){
       String list= name + "\n";
        for(int i=0; i<getNumberOfBreakoutRooms(); i++){
           list += breakoutRooms[i].toString() + "\n";
        }
        return list;
       }
    
       
    public String listParticipantsInBreakoutRoom(int roomNumber){
     String roomNum = name + Integer.toString(roomNumber); 
     
      for(int i=0; i<getNumberOfBreakoutRooms(); i++){
       if(breakoutRooms[i].getBreakoutRoomID().equals(roomNum)){  
           String list = (breakoutRooms[i].listParticipants());
           return list;    
       }
      }
       return null;
     }
     
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
     String roomNum = name + Integer.toString(roomNumber);  
     int numParticipants;
     boolean added = false;
     
     for(int i=0; i<getNumberOfBreakoutRooms(); i++){  
       numParticipants = (breakoutRooms[i].getNumberOfParticipants());
       if(numParticipants < 10){
        if(breakoutRooms[i].getBreakoutRoomID().equals(roomNum)){
           added = breakoutRooms[i].addParticipant(participantID);
           //System.out.println(breakoutRooms[i].getbreakoutRoomID() + ": Adding Participant to room");   
         if(added == true){
           return true;
           }
  
        }
       }
       
      }
     return false;
    }
    
    
    public String findParticipantBreakoutRoom(String participantID){
        String getBreakoutRoomID = "";
        
        for(int i=0; i<getNumberOfBreakoutRooms(); i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
              System.out.println("Found participant in " + breakoutRooms[i].getBreakoutRoomID());
              getBreakoutRoomID  = breakoutRooms[i].getBreakoutRoomID();
              return getBreakoutRoomID ;
            }
            
        }
      
        return null;
    }
    
    
}
    
