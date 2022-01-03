package out.Videsh_Jagai_657838_assignsubmission_file_;
/**
 * 
 *
 * Name: Videsh Jagai..
 * Student ID: 816014860
 */

  public class VirtualRoom
  {
        // instance variables - replace the example below with your own
        private String name; // The name of the virtual room
        private  int breakoutRoomLimit;// Specifies the maximum number of breakout rooms allowed for a virtual room..
        private BreakoutRoom[] breakoutRooms; // //A list of breakout rooms managed by the virtual room..
        // created passing the String name setting these such VirtualRoom 
         public VirtualRoom(String name)
        {
            this.name = name; 
            
            this.breakoutRoomLimit = 5; //Initialises the breakoutRoomLimit to 5...
            
            breakoutRooms = new BreakoutRoom[breakoutRoomLimit]; // BreakoutRoom objects that fill the list of breakout rooms
                                                            
        }
         // Overloaded constructor. Initialises the breakoutRoomLimit to the supplied limit..
        public VirtualRoom(String name, int limit)
        {
            BreakoutRoom breakoutRooms;
            this.name = name;
            if( breakoutRoomLimit  == 10) // Check breakoutRoomLimit attribute equals 10
            breakoutRoomLimit = limit; // passing the limit and assigning it to the brekoutRoomLimit...

        }                                           
        
        public int getNumberOfBreakoutRooms()
        {
            
             return breakoutRoomLimit; // getting the value of the breakoutLimit..
            
        }
        //Creates new BreakoutRoom objects that fill the listof breakout rooms...
       
        public void createBreakoutRooms()
        {
            for(int i = 0; i < breakoutRoomLimit; i++)
            {
               breakoutRooms[i] = new BreakoutRoom(name); // From the above Virtual Room class, BreakoutRoom objects that fill the list of breakout rooms
            }                                              // passing along the String name...
        }
        //Locates and returns the breakout room with the
        //supplied room number, otherwise returns null
        public BreakoutRoom findBreakoutRoom(int roomNumber) 
        {   // utilising the roomNumber as the actual position within the respective array within the index range of the breakoutLimit....
            while((roomNumber > 0) && (roomNumber <= breakoutRoomLimit))
            {
                return breakoutRooms[roomNumber-1]; // return the room number within the position of the array... 
            }
                
            return null; // otherwise return null..
        }
        
        // Closes a breakout room with the supplied roomnumber if it exists
        public boolean closeBreakoutRoom(int roomNumber)
        {
            while((roomNumber > 0 )&& (roomNumber <= breakoutRoomLimit)) 
            {   // if the number (roomNum) within the array doesn't exist corresponding to the position it consequently closes..
                breakoutRooms[roomNumber-1].closeBreakoutRoom();
                return true;  // hence returning true..
            }
            
                return false; // otherwsie returning false...
        }
        
        public boolean openBreakoutRoom(int roomNumber)
        {
           while((roomNumber > 0) && (roomNumber <= breakoutRoomLimit))
           {
                // if the number(roomNum) within the array does exist corresponding to the position it consequently open..
                breakoutRooms[roomNumber-1].openBreakoutRoom();
                return true;
            }
               return false;         
        }
        // Returns a list of the breakout rooms managed bythe virtual room with the virtual room name heading
        //the list on a separate line

        public String listBreakoutRooms()
        {
            String  ParDet = "VIRTUAL ROOM :" + name;
            
            for(int j = 0; j < breakoutRoomLimit; j++)
            {
                 ParDet+= breakoutRooms[j].toString() + "\n";
            }
            return ParDet;
        }
    
        //Returns a list of the participants in the breakout
        //room with the supplied room number if found,
        //otherwise returns null...
      
        public String listParticipantsInBreakoutRoom(int roomNumber)
        {
            BreakoutRoom breakoutRooms; // Declaration of the object breakRooms
             // assigning the breakoutRoom class to the breakout room with supplied room number...
            breakoutRooms = findBreakoutRoom(roomNumber); 
            // recalling the findBreakoutRoom function: Locates and returns the breakout room with the
            //supplied room number...
            
            while (  breakoutRooms != null )
            {    // Returns a list of the participants (ID and name) in the breakout room with the breakout room ID 
                return breakoutRooms.listParticipants();
            }     
            return null;  // otherwise return null..
        }
        
        // Adds a new participant to the breakout room with the supplied room number if it exists 
        public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
        {
            BreakoutRoom breakoutRooms; //Declaration of the object breakRooms
            // Returns a list of the participants (ID and name) in the breakout room with the breakout room ID 
            breakoutRooms = findBreakoutRoom(roomNumber);
            // assigning the breakoutRoom class to the breakout room with supplied room number...
            if (breakoutRooms != null)
            {   
                return breakoutRooms.addParticipant(participantID);
            }
                
            return false; 
        }
    
        
        // Locates and returns the breakoutRoomID for the breakout room hosting the participant with the 
        // (valid) supplied ID, otherwise returns null...
        
        public String findParticipantBreakoutRoom(String participantID)
        { 
            // incrementing until the breakoutLimit..
            for(int j = 0; j < breakoutRoomLimit; j++)
            {
                // recalling the findParticipant function; Locates and returns a participant based on a
                //supplied (valid) ID...
                if (breakoutRooms[j].findParticipant(participantID) != null)
                {
                    return breakoutRooms[j].getBreakoutRoomID(); //recalling the accessor getbreakoutRoomID toreturn the 
                }                                                // according breakoutRoomID..
                    
            }
            return null;  // otherwise return null...
        }
    }   

