package out.Amirah_Ali_657679_assignsubmission_file_;//816020184
public class VirtualRoom{
   // instance variables
   private String name;
   private int breakoutRoomLimit;
   private BreakoutRoom[] breakoutRooms;
   private String roomID;
   private static int numberOfBreakoutRooms = 0;
    
    // Constructors
   public VirtualRoom(String name){
       this.name = name;
       breakoutRoomLimit = 5;
       breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
   }
        
   public VirtualRoom(String name, int limit){
       this.name = name;
       this.breakoutRoomLimit = limit;
       breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
   }
           
   
   // Accessors and mutators
   public int getNumberOfBreakoutRooms(){
       return this.breakoutRoomLimit;
   }
     
   
   public void createBreakoutRooms(){
       for(int i=0; i<this.breakoutRoomLimit; i++){
           breakoutRooms[i] = new BreakoutRoom(name);
           this.numberOfBreakoutRooms++;
       }
   }
           
            
   public BreakoutRoom findBreakoutRoom(int roomNumber){
       roomID = this.name + roomNumber; 
       
       for (int i=0; i<this.breakoutRoomLimit; i++){
           if ((breakoutRooms[i].getBreakoutRoomID()).equals(roomID)){
               return breakoutRooms[i];
           }
       }
       return null;
   }
            
   // case: breakout room closed is in the middle of the array
   // print if null but specify that breakout room is emptpy or null
   // cant close a breakout room if it hasnt been created
   public boolean closeBreakoutRoom(int roomNumber){
       for (int i=0; i<this.breakoutRoomLimit; i++){
           if ((breakoutRooms[i].getOpen())){
               breakoutRooms[i].closeBreakoutRoom();
               return true;
           }
       }
       return false;
   }
            
   public boolean openBreakoutRoom(int roomNumber){
       for (int i=0; i<this.breakoutRoomLimit; i++){
           if ((!breakoutRooms[i].getOpen())){
               breakoutRooms[i].openBreakoutRoom();
               return true;
           }
       }
       return false;
   }
            
            
   public String listBreakoutRooms(){
       String breakoutRoomList = this.name;
       int i = 0;
                
       while ( i < this.getNumberOfBreakoutRooms()){
           breakoutRoomList +=  "\n" + breakoutRooms[i].getBreakoutRoomID();
           i++;
       }
       return breakoutRoomList;
   }
        
        
   public String listParticipantsInBreakoutRoom(int roomNumber){    
       if (findBreakoutRoom(roomNumber) == null){
           return "Breakout room not found!";
       }
            
       else{
           return findBreakoutRoom(roomNumber).listParticipants();
       }
    }
    
   
   public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
       if (findBreakoutRoom(roomNumber) != null && findBreakoutRoom(roomNumber).getOpen()){
           findBreakoutRoom(roomNumber).addParticipant(participantID);
           return true;
       }
       else{
           return false;
       }
    }
    
   
   public String findParticipantBreakoutRoom(String participantID){
       int i=0;
       
       while ( i < getNumberOfBreakoutRooms()){
           if (breakoutRooms[i].findParticipant(participantID) != null){
               return breakoutRooms[i].getBreakoutRoomID();
           }
           else{
               i++;
           }
       }
       return null;
   }
}
