package out.Kymberly_Byanile_657778_assignsubmission_file_;

/* Student ID: 814117667 */ 
public class VirtualRoom
{
   private static int breakoutRoomLimit;
   private String name;
   private BreakoutRoom[] breakoutRooms;
   
   
   public VirtualRoom(String name){
    this.name = name;
    breakoutRooms = new BreakoutRoom[5];
    this.breakoutRoomLimit = 5;
   }
   
   public VirtualRoom(String name, int limit){
    this.name = name;
    this.breakoutRoomLimit = limit;
    breakoutRooms = new BreakoutRoom[limit];
   }
   
   public int getNumberOfBreakoutRooms( ){
     return this.breakoutRoomLimit;
   } 
   
   public void createBreakoutRooms( ){ 
     int capacity = getNumberOfBreakoutRooms();
     if (capacity < breakoutRoomLimit){
        for (int i =0; i<this.breakoutRoomLimit; i++){
            this.breakoutRooms[i] = new BreakoutRoom(this.name);
        }
        }
     else {
        System.out.println("The maximum number of rooms have been created for this Virtual Room.");
        }
     }  
   
   public BreakoutRoom findBreakoutRoom(int roomNumber){
   
       int i = 0;
       while (i < breakoutRoomLimit){   
        
           //code to extract the integers from a BreakoutRoomID
        String breakRoomNumberExtract = breakoutRooms[i].breakoutRoomID;
        breakRoomNumberExtract = breakRoomNumberExtract.replaceAll("[^0-9]+", " ");
        int roomNum = Integer.parseInt(breakRoomNumberExtract);
        
        
            if (roomNum == roomNumber){
            return this.breakoutRooms[i];
            }
        i+=1;
        } 
  
   return null;
   
    }  
   
       public boolean closeBreakoutRoom(int roomNumber){
    
        BreakoutRoom tempRoom = findBreakoutRoom(roomNumber);
        if (tempRoom != null){
        tempRoom.closeBreakoutRoom();
        return true;
        }
        //if a matching open room does not exist:
        return false;
        }
    
        public boolean openBreakoutRoom(int roomNumber){
        
        BreakoutRoom tempRoom = findBreakoutRoom(roomNumber);
        
        if (tempRoom != null){
        tempRoom.openBreakoutRoom();
        return true;
        }
        
        return false;
        }
        
         public String listBreakoutRooms( ){
    
        String listOfRooms = null;
        
        //name of virtual room 
        listOfRooms = name + " ";
        
        for (int i = 0; i < breakoutRoomLimit; i++){
        listOfRooms += this.breakoutRooms[i].toString()+ " ";
        }
        
        return listOfRooms;
        
        } 
        
        public String listParticipantsInBreakoutRoom(int roomNumber){
        //code to extract the integers from a BreakoutRoomID
        
        
        BreakoutRoom tempRoom = findBreakoutRoom(roomNumber);
        String breakRoomNumberExtract = tempRoom.breakoutRoomID;
        int roomNum = Integer.parseInt(breakRoomNumberExtract);
        breakRoomNumberExtract = breakRoomNumberExtract.replaceAll("[^0-9]+", " "); 
        
        int i  = 0;
        while (i < breakoutRoomLimit){
            if (roomNum == roomNumber){
             String list = tempRoom.listParticipants();
             return list;
            }
               
        }
        
        return null;
        
       } 
       
       public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
       
        //code to extract the integers from a BreakoutRoomID
        BreakoutRoom tempRoom = findBreakoutRoom(roomNumber);
        String breakRoomNumberExtract = tempRoom.breakoutRoomID;
        int roomNum = Integer.parseInt(breakRoomNumberExtract);
        breakRoomNumberExtract = breakRoomNumberExtract.replaceAll("[^0-9]+", " ");  
        
        for (int i = 0; i < breakoutRoomLimit; i++){
            
            //adds new participant if and only if room exists and has room; will not create a new one.
            if (roomNum == roomNum && tempRoom.numberOfParticipants < tempRoom.breakoutRoomSize){
              tempRoom.addParticipant(participantID);  
              return true;
            }
        
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom (String participantID){   
         for (int i = 0; i < breakoutRoomLimit; i++){
           BreakoutRoom tempRoom = findBreakoutRoom(i);
           
           if(tempRoom != null){
               
               if (tempRoom.findParticipant(participantID) != null){
                return tempRoom.breakoutRoomID;
                
               }  
           }
       
       } 
       
       return null;
      }
}