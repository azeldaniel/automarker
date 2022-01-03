package out.Brandon_Bissoon_657753_assignsubmission_file_;/**
 * Write a description of class VirtualRoom here.
 *
 *Student ID :- 816022435
 *Student Name :- Brandon Bissoon 
 */
  public class VirtualRoom
  {
       // instance variables - replace the example below with your own
        public String name;
        public int breakoutRoomLimit;    //This is used to return the number of break out rooms
        public BreakoutRoom[] breakoutRooms;
                
        /*
         * Constructor. Initialises the breakoutRoomLimit to 5�
           */
        /**
         * Constructor for objects of class VirtualRoom
         */
        public VirtualRoom(String name){
            // setting the breakout room limit andd breakout rooms to its new values;
            this.name = name;
            breakoutRoomLimit = 5;
            breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        } 
                      
        /*
         * Overloaded constructor. Initialises the
         * breakoutRoomLimit to the supplied limit�
           */
        /** 
         *Overloaded Constructor for objects of class VirtualRoom
         */
        public VirtualRoom(String name, int limit){
            // put your code here
            //intializing the breakoutRoomLimit to the supplied limit
            this.name = name;
            breakoutRoomLimit = limit;        
        }
        
        /*
         *Returns the total number of breakout rooms
         *managed by the virtual room� 
           */
        public int getNumberOfBreakoutRooms(){
            return breakoutRoomLimit;
        }
        
        /*
         *Creates new BreakoutRoom objects that fill the list
         *of breakout rooms� 
           */
        public void createBreakoutRooms(){
            int x;
            
            for( x = 0; x < breakoutRoomLimit; x = x + 1 ){
                breakoutRooms[x] = new BreakoutRoom(name);
            }
        } 
        
        /*
         *Locates and returns the breakout room with the
         *supplied room number, otherwise returns null� 
           */
        public BreakoutRoom findBreakoutRoom(int roomNumber){
            if(( roomNumber > 0) && ( roomNumber <= breakoutRoomLimit)){
                roomNumber = roomNumber - 1;
                return breakoutRooms[roomNumber];
            }
            else{
                return null;
            }
        }
        
        /*
         *Closes a breakout room with the supplied room
         *number if it exists� 
           */
        public boolean closeBreakoutRoom(int roomNumber){
            if(( roomNumber > 0) && ( roomNumber <= breakoutRoomLimit )){
                roomNumber = roomNumber - 1;
                breakoutRooms[roomNumber].closeBreakoutRoom();
                return true;
            }
            else{
                return false;
            }
        }  
        
        /*
         *Opens a breakout room with the supplied room
         *number if it exists� 
           */
        public boolean openBreakoutRoom(int roomNumber){
            if(( roomNumber > 0) && ( roomNumber <= breakoutRoomLimit )){
                roomNumber = roomNumber - 1;
                breakoutRooms[roomNumber].openBreakoutRoom();
                return true;
            }
            else{
                return false;
            }
        } 
        
        /*
         *Returns a list of the breakout rooms managed by
         *the virtual room with the virtual room name heading
         *the list on a separate line� 
           */
        public String listBreakoutRooms(){
            int count;
            String phrase = " The VirutalRoomId is :- " + name ; 
            
            for(count = 0; count < breakoutRoomLimit; count = count + 1){
                name = name + breakoutRooms[count].toString();                
            }
            return phrase;
        }
    
        /*
         *Returns a list of the participants in the breakout
         *room with the supplied room number if found,
         *otherwise returns null� 
           */
        public String listParticipantsInBreakoutRoom(int roomNumber){
            BreakoutRoom breakoutRooms;
            
            breakoutRooms = findBreakoutRoom(roomNumber);
            
            if( breakoutRooms != null){
                return breakoutRooms.listParticipants();
            }
            else{
                return null;
            }
        }  
        
        /*
         *Adds a new participant to the breakout room with
         *the supplied room number if it exists� 
           */   
        public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
            BreakoutRoom breakoutRooms;
        
            breakoutRooms = findBreakoutRoom(roomNumber);
        
            if( breakoutRooms != null){
                return breakoutRooms.addParticipant(participantID);
            }
            else{
                return false;
            }
        }
              
        /*
         *Locates and returns the breakoutRoomID for the
         *breakout room hosting the participant with the
         *(valid) supplied ID, otherwise returns null� 
           */  
        public String findParticipantBreakoutRoom(String participantID){
            int count;       
        
            for(count = 0; count < breakoutRoomLimit; count = count + 1){
                if(breakoutRooms[count].findParticipant(participantID) != null){
                return breakoutRooms[count].getBreakoutRoomID();
               }            
            }
            return null;
        }
}   

