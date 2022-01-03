package out.Christine_Ramdhanie_657773_assignsubmission_file_;//ID: 816018588
//NAME: CHRISTINE RAMDHANIE
//COMP 2603 - ASSIGNMENT 1 

public class VirtualRoom{
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[ ] breakoutRooms;
    
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit=5;
    }
    
    public VirtualRoom(String name, int limit){
       this.breakoutRoomLimit= breakoutRoomLimit;
    }
    
    //Methods 
    public int getNumberOfBreakoutRooms(){
        int numBreakoutRooms = 0;
        int count = 0;
        while (breakoutRoomLimit >= count){
            if (breakoutRooms[count].getBreakoutRoomID() !=null)
            numBreakoutRooms= numBreakoutRooms + 1;
            else 
            numBreakoutRooms= numBreakoutRooms;
            count++;
        }
        return numBreakoutRooms;
    }
    
    public void createBreakoutRooms() {
        int count= 0;
        while (this.breakoutRoomLimit > count){
        BreakoutRoom full = new BreakoutRoom("Fill");
        count++;
       }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        BreakoutRoom find= null;
        int count = 0;
        boolean helper= false;
        while (count < breakoutRoomLimit) {
            if(breakoutRooms[count].getbreakoutRoomNumberCounter() ==roomNumber){
             helper = true;
             break;                     
        }
        else 
        count++;
       }
       if (helper= true)
       return breakoutRooms[count];
       else
       return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if (findBreakoutRoom(roomNumber) == null)
            return false; 
        else {
        breakoutRooms[roomNumber].closeBreakoutRoom();
        return true;
    }
}
    
     public boolean openBreakoutRoom(int roomNumber){
        if (findBreakoutRoom(roomNumber) == null)
        return false;
        else {
           breakoutRooms[roomNumber].openBreakoutRoom();
           return true; 
        }
    }
    
    public String listBreakoutRooms( ) {
        String roomDetails = " ";
        int count = 0;
        while(count <breakoutRoomLimit){
            roomDetails = "Breakout Rooms : " + breakoutRooms[count].getBreakoutRoomID() + "\r\n";
            count ++;
        }
        return  "Virtual Room Name: " + name + "\r\n" + roomDetails;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String listOfParticipants = " ";
        if( findBreakoutRoom(roomNumber) == null)
        return null;
        else 
        {
            listOfParticipants = "List:" + breakoutRooms[roomNumber].listParticipants();
            return listOfParticipants;
        }
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
       return breakoutRooms[roomNumber].addParticipant(participantID);
    }

    public String findParticipantBreakoutRoom(String participantID){
        int count = 0 ;
        boolean helper=false;
        while (breakoutRoomLimit >count){
            if(breakoutRooms[count].findParticipant(participantID) !=null){ 
                helper = true;
                break;                     
        }
        else 
        count++;
       }
       if (helper= true)
       return breakoutRooms[count].getBreakoutRoomID();
       else
       return null;
    }
}
