package out.Alec_Sieupresad_657762_assignsubmission_file_;// Student ID: 816022470
    /**
     * Write a description of class VirtualRoom here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    public class VirtualRoom{
        private String name;
        private int breakoutRoomLimit;
        private BreakoutRoom[] breakoutRooms;
        
        
        public VirtualRoom (String name){
           breakoutRoomLimit=5;
           breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        }
        
        public VirtualRoom (String name, int limit){
            breakoutRoomLimit = limit;  
        }
        
        public int getNumberOfBreakoutRooms( ){
            return this.breakoutRooms.length;
        }
        
        public void createBreakoutRooms (){
            for(int i =0; i < this.breakoutRoomLimit; i++){
                this.breakoutRooms[i] = new BreakoutRoom(this.name);
            }
        }
        
        public BreakoutRoom findBreakoutRoom (int roomNumber){
            if(roomNumber == 0){
                return null;
            }
            for(int i =0; i < this.breakoutRoomLimit; i++){
                if(breakoutRooms[i].getRoomID() == roomNumber){
                    return breakoutRooms[i];
                }
            }
             
            return null;
            
        }
        
        public boolean closeBreakoutRoom (int roomNumber){
            if(roomNumber == 0){
                return false;
            }
            
            for(int i =0; i < this.breakoutRoomLimit; i++){
                if(breakoutRooms[i].getRoomID() == roomNumber){
                    breakoutRooms[i].closeBreakoutRoom();
                    return true;
                }
            }
             
            return false;
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        if(roomNumber == 0){
            return false;
        }
        
        for(int i =0; i < this.breakoutRoomLimit; i++){
            if(breakoutRooms[i].getRoomID() == roomNumber){
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
         
        return false;
        
    }
    
    public String listBreakoutRooms ( ){
        
         String roomList = "";
        for(int i =0; i < this.breakoutRoomLimit; i++){
            roomList += breakoutRooms[i].toString() + "\n";
        }
        return roomList;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
         if(roomNumber == 0){
            return null;
        }
        
        for(int i =0; i < this.breakoutRoomLimit; i++){
            if(breakoutRooms[i].getRoomID() == roomNumber){
                return breakoutRooms[i].listParticipants();
            }
        }
        
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        
        boolean key = false; 
        
        if(roomNumber == 0){
            return false;
        }
        
        for(int i =0; i < this.breakoutRoomLimit; i++){
            if(breakoutRooms[i].getRoomID() == roomNumber){
                 key = breakoutRooms[i].addParticipant(participantID);
            }
        }
        
        if(key == false){
            System.out.print("ID provided is not suitable, the Participant already exists in this room OR the room ID does not exist");
            return key;
        }
        else{
            System.out.print("The participant has been added to the room");
            return key;
        }
        
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        
                
        boolean key = false; 
        
        for(int i =0; i < this.breakoutRoomLimit; i++){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                 return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        
        return null;
        
    }
}
