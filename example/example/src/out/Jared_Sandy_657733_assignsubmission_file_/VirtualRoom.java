package out.Jared_Sandy_657733_assignsubmission_file_;    
// 816018721
public class VirtualRoom {
        private String name;
        private static int breakoutRoomLimit;
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
            for(int i = 0; i <= breakoutRoomLimit; i++)
              if(i==roomNumber)
                  return breakoutRooms[roomNumber -1];
            return null;
        }
        
        public boolean closeBreakoutRoom(int roomNumber){
          
        for(int i = 0; i <= breakoutRoomLimit; i++){
                if( i == roomNumber )
                 breakoutRooms[i].closeBreakoutRoom();
                 return true;
            }
            return false;
    
        }
    
        public boolean openBreakoutRoom(int roomNumber){
           
         for(int i = 0; i <= breakoutRoomLimit; i++){
            if( i == roomNumber )
                 breakoutRooms[i-1].openBreakoutRoom();
                 return true;
            }
            return false;
        }
        
        public String listBreakoutRooms( ){
            String details = "Virtual room name :" + name + "\n";
            for(int i = 0; i < breakoutRoomLimit; i++){
                details += breakoutRooms[i].toString() + "\n";
            }
            return details;
        }
    
        public String listParticipantsInBreakoutRoom(int roomNumber){
            BreakoutRoom room = findBreakoutRoom(roomNumber);
            if (room != null)
                return room.listParticipants( );
            return null; 
        }
    
        public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
            BreakoutRoom room = findBreakoutRoom(roomNumber);
            if (room != null)
                return room.addParticipant(participantID);
            return false; 
        }
    
        public String findParticipantBreakoutRoom(String participantID){ 
            for(int i = 0; i < getNumberOfBreakoutRooms(); i++)
                if (breakoutRooms[i].findParticipant(participantID) != null)
                    return breakoutRooms[i].getBreakoutRoomID();
            return null;
        }
    }   

