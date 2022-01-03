package out.Jonathan_Gray_657823_assignsubmission_file_;// StudentID: 816022996
// Student Name: Jonathan Gray

public class VirtualRoom{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    // Constructor 
    public VirtualRoom(String name){
        breakoutRoomLimit = 5;
        this.name = name;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    // Overloaded Constructor 
    public VirtualRoom(String name, int limit){
        breakoutRoomLimit = limit;
        this.name = name;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    public void createBreakoutRooms(){
        for(int i = 0; i < breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name + "_");
            //System.out.println(breakoutRooms[i].breakoutRoomID);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(name + "_" + roomNumber)){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomNumber() == roomNumber){
                breakoutRooms[i].openBreakoutRoom();                
                return true;
            }
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){        
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomNumber() == roomNumber){
                breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String roomsList = new String();
        roomsList += "\n\t\t   <-> " + name + " <->\n";
        for(int i = 0; i < breakoutRoomLimit; i++){
             roomsList += "\n\n\t{breakoutRoom_" + (i+1) + "}\n" + breakoutRooms[i] + "\n";
        }
        return roomsList;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String allParticipants = new String();
        boolean flag = true;
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomNumber() == roomNumber){
                flag = false;
                return breakoutRooms[i].listParticipants();
            }
        }
        // If flag remains true, the breakoutRoom does not exist.
        if(flag == true){
            return null;
        }
        return allParticipants;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
      int check;
      
      if(breakoutRooms[0].verifyParticipantID(participantID)){
            for(int i = 0; i < breakoutRoomLimit; i++){
                 //System.out.println((i+1) + ". " + breakoutRooms[i].breakoutRoomNumberCounter);
                 if(breakoutRooms[i].getBreakoutRoomNumber() == roomNumber &&
                    breakoutRooms[i].getBreakoutRoomIsOpen())
                 {
                       breakoutRooms[i].addParticipant(participantID);
                       return true;
                 }
           }
      }
      return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int i = 0; i < breakoutRoomLimit; i++){
            for(int y = 0; y < breakoutRooms[i].getNumberOfParticipants(); y++){
                if(breakoutRooms[i].findParticipant(participantID) != null){
                    return breakoutRooms[i].getBreakoutRoomID();
                }
            }
       }
        
       return null; 
    }
    
    public String getBreakoutRoomID(int index){
        return breakoutRooms[index].getBreakoutRoomID();
    }
    
    public String getParticipantID(int indexOfBreakoutRoom, int indexOfParticipant){
        return breakoutRooms[indexOfBreakoutRoom].getParticipantID(indexOfParticipant);
    }
    
    public int getBreakoutRoomNumber(int index){
        for(int y = 0; y < breakoutRoomLimit; y++){
            for(int i = 0; i < breakoutRooms[y].getBreakoutRoomSize(); i++){
                if(breakoutRooms[i].getBreakoutRoomNumber() == breakoutRooms[index].getBreakoutRoomNumber()){
                    return breakoutRooms[i].getBreakoutRoomNumber();
                }
            }
        }
        return -1;
    }
    
    public int getBreakoutRoomSize(int index){
        if(breakoutRooms[index] != null){
           return breakoutRooms[index].getBreakoutRoomSize();
        }
        else return -1;
    }
    
    public int getBreakoutRoomLimit(){
        return breakoutRoomLimit;
    }
    
    public String getVirtualRoomName(){
        return name;
    }
    
    // Accessor to get number of breakout rooms.
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public boolean getBreakoutRoomIsOpen(int breakoutRoomIndex){
        return breakoutRooms[breakoutRoomIndex].getBreakoutRoomIsOpen();
    }
    
    public int getNumberOfParticipants(int breakoutRoomIndex){
        return breakoutRooms[breakoutRoomIndex].getNumberOfParticipants();
    }
}