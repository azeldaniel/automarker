package out.Rayann_Bristol_657696_assignsubmission_file_;
/**
 * Rayann Britsol
 * 816013958
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private  final int breakoutRoomLimit;
    private int numberOfBreakoutRooms;
    private BreakoutRoom[] breakoutRooms;

    
    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = 5;
        //breakoutRooms = new BreakoutRoom [5];
    }

    public VirtualRoom(String name,int limit)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom [10];
    }
    
    public int getNumberOfBreakoutRooms(){
        numberOfBreakoutRooms = getBreakoutRoomLimit();
        return numberOfBreakoutRooms;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setBreakoutRoomLimit(int limit)
    {
        limit = breakoutRoomLimit;
    }
    
    public int getBreakoutRoomLimit()
    {
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        BreakoutRoom[] breakoutRooms = new BreakoutRoom [5];
        for(int i = 0; i<numberOfBreakoutRooms;i++){
            BreakoutRoom br = new  BreakoutRoom(name +i);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int k = 0;k<numberOfBreakoutRooms;k++){
            if(breakoutRooms[k].getBreakoutRoomID().equals(roomNumber)){
                return breakoutRooms[k];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        int k = 0;
        while(k<numberOfBreakoutRooms){
           if(findBreakoutRoom(roomNumber).equals(roomNumber)){
                breakoutRooms[k].closeBreakoutRoom();//closed the room
                return true;//successfull
           }
           k++;  
        } 
        return false;//room was unsuccessfully closed
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber).equals(roomNumber)){
            breakoutRooms[roomNumber].openBreakoutRoom();//opened the room
            return true;//successfull
        }
        return false;//room was unsuccessfully opened
    }
    
    public String listBreakoutRooms(){
        String details = " ";
        details += "Virtual Room: "+name + "\n";
        details += breakoutRooms.toString();
              
        return details;
        
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber).equals(roomNumber)){
          String details = " ";
          details += "Participants In Breakout Room Number: "+roomNumber + "\n";
          details += breakoutRooms[roomNumber].listParticipants().toString();
          
          return details;
        }else{
          return "There are not participants in this breakout room.";
        }
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
       if(findBreakoutRoom(roomNumber).equals(roomNumber)){
           breakoutRooms[roomNumber].addParticipant(participantID);
           return true;
       }else{
            return false;
       }
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int k = 0;k<numberOfBreakoutRooms;k++){
            if(breakoutRooms[k].findParticipant(participantID).equals(participantID)){
              String details = " ";
              details += "Breakout Room ID: "+breakoutRooms[k].getBreakoutRoomID();
              
              return details;
            } 
        }
        return null;
    }
    
}
