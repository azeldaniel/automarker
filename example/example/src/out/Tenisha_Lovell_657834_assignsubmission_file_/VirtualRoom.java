package out.Tenisha_Lovell_657834_assignsubmission_file_;/* 816008740
 */

public class VirtualRoom{
    
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5; 
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        //BreakoutRoom[] data = {null, null, null, null, null};
        /*for(int i=0; i<breakoutRoomLimit; i=i+1)
            breakoutRooms[i] = null;*/
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
      /*  for(int i=0; i<breakoutRoomLimit; i=i+1)
            breakoutRooms[i] = null;*/
    }

    public int getNumberOfBreakoutRooms(){
        int count = 0;
        boolean isNull = false;
        int i = 0;
        while((i < breakoutRoomLimit) && (isNull == false)){
            if(breakoutRooms[i] != null){ 
                count = count + 1;
            }
            else
                isNull = true;
            i = i + 1;
        } 
        return count;
    }
    
    public void createBreakoutRooms(){
    
        for(int i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(this.name);
           // System.out.println(breakoutRooms[i].toString());
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
       // boolean isFound = false;
        int i = 0;
        String compare = this.name + roomNumber; 
        while(breakoutRooms[i] != null && (i < breakoutRoomLimit-1)){
          //  System.out.println("found" + i);
            if(breakoutRooms[i].getBreakoutRoomID().equals(compare)){
               // isFound = true;
                return breakoutRooms[i];
            }
            i = i + 1;
        }
        if(breakoutRooms[4] != null){
             if(breakoutRooms[4].getBreakoutRoomID().equals(compare)){
               // isFound = true;
                return breakoutRooms[i];
            }
        }
        return null;   
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean isFound = false;
        int i = 0;
        String compare = this.name + roomNumber; 
        while((isFound == false) && (i < breakoutRoomLimit)){
            if(breakoutRooms[i] != null){
                if(breakoutRooms[i].getBreakoutRoomID().equals(compare)){
                    isFound = true;
                    breakoutRooms[i].closeBreakoutRoom();
                    return true;
                }
        }
            i = i + 1;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean isFound = false;
        int i = 0;
        String compare = this.name + roomNumber; 
        while((isFound == false) && (i < breakoutRoomLimit)){
            if(breakoutRooms[i] != null){
                if(breakoutRooms[i].getBreakoutRoomID().equals(compare)){
                    isFound = true;
                    breakoutRooms[i].openBreakoutRoom();
                    return true;
                }
        }
            i = i + 1;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String list;
        list = this.name + "\n";
        for(int i=0; i<breakoutRoomLimit; i=i+1){
            if(breakoutRooms[i]!=null)
                list = list + breakoutRooms[i].getBreakoutRoomID() + " ";
        }
        return list;
    }
       public String testView(){
        String list;
        list = this.name + "\n";
        for(int i=0; i<breakoutRoomLimit; i=i+1){
            if(breakoutRooms[i]!=null)
                breakoutRooms[i].testPart();
        }
        return list;
    }
    
   
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom b = findBreakoutRoom(roomNumber);
        if(b != null){
            return b.listParticipants();
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom b = findBreakoutRoom(roomNumber);
       
        if(b != null){
            b.addParticipant(participantID);
            return true;
        }
        
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
      //  boolean isFound = false;
        String partRoomID;
        int i = 0;
        while(breakoutRooms[i] != null && (i<breakoutRoomLimit)){
            if(breakoutRooms[i].findParticipant(participantID) != null){
                //isFound = true;
                partRoomID = breakoutRooms[i].getBreakoutRoomID();
                return partRoomID;
            }
        i = i + 1;
        }
        return null;
    }
}