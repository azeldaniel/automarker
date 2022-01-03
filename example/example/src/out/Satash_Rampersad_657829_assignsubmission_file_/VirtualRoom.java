package out.Satash_Rampersad_657829_assignsubmission_file_;    
    /**
     * 816020134
     */
    public class VirtualRoom {
        private String name;
        private final int breakoutRoomLimit;
        private BreakoutRoom[] breakoutRooms;
        
        public VirtualRoom(String name){
            this.name = name;
            breakoutRoomLimit = 5;
            breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        }
        
        public VirtualRoom(String name, int limit){
            this.name = name;
            breakoutRoomLimit = limit;
            breakoutRooms = new BreakoutRoom[limit];
        }
        
        public int getNumberOfBreakoutRooms( ){
            int count = 0;
            for (int i = 0; i < breakoutRoomLimit; i++){
                if (breakoutRooms[i] != null) 
                    count++;
            }
            return count;
        }
        
        public void createBreakoutRooms( ){
            for(int i = 0; i < breakoutRoomLimit; i++){
                breakoutRooms[i] = new BreakoutRoom(name);
            }
        }
        
        public BreakoutRoom findBreakoutRoom(int roomNumber){
            if(roomNumber >= 1 && roomNumber <= breakoutRoomLimit)
                return breakoutRooms[roomNumber - 1];
            return null;
        }
        
        public boolean closeBreakoutRoom(int roomNumber){
            if(roomNumber >= 1 && roomNumber <= breakoutRoomLimit) {
                breakoutRooms[roomNumber - 1].closeBreakoutRoom();
                return true;
            }
            else
                return false;
        }
        
        public boolean openBreakoutRoom(int roomNumber){
           if(roomNumber >= 1 && roomNumber <= breakoutRoomLimit) {
                breakoutRooms[roomNumber - 1].openBreakoutRoom();
                return true;
            }
            else
                return false;
                   
        }
        
        public String listBreakoutRooms( ){
            String details = name + "\n";
            for(int i = 0; i < breakoutRoomLimit; i++){
                details += breakoutRooms[i].toString() + "\n";
            }
            return details;
        }
    
        public String listParticipantsInBreakoutRoom(int roomNumber){
            BreakoutRoom curr;
            String details = name + "\n";
            curr = findBreakoutRoom(roomNumber);
            if (curr != null)
                return details + curr.listParticipants( );
            return null; 
        }
    
        public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
            BreakoutRoom curr;
            curr = findBreakoutRoom(roomNumber);
            if (curr != null)
                return curr.addParticipant(participantID);
            return false; 
        }
    
        public String findParticipantBreakoutRoom(String participantID){ 
            
            for(int i = 0; i < getNumberOfBreakoutRooms(); i++){
                if (breakoutRooms[i].findParticipant(participantID) != null)
                    return breakoutRooms[i].getBreakoutRoomID();
            }
            return null;
        }
    }   

