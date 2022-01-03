package out.Brandon_James_657851_assignsubmission_file_;
/**
 *
 * @815006970 (ID)
 */
public class VirtualRoom
{
    private String name;
    private BreakoutRoom[] breakoutRooms = new BreakoutRoom[10];
    private final int breakoutRoomLimit;
    private int brIndex = 0; //breakoutRooms Index used to create rooms
    private int numOfRooms = 0;
    

    /**
     * Constructors for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRoomLimit = 5;
        createBreakoutRooms();
    }
    
    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        this.breakoutRoomLimit = limit;
        createBreakoutRooms();
    }
    
    /**
     * Methods
     */
    public int getNumberOfBreakoutRooms( )
    {
        return numOfRooms;
    }
    
    public void createBreakoutRooms()
    {
        while(brIndex<breakoutRoomLimit){
            breakoutRooms[brIndex] = new BreakoutRoom(name);
            numOfRooms++;
            brIndex++;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(numOfRooms<roomNumber){
            System.out.println("Room not created yet");
            return null;
        }else {
            return breakoutRooms[roomNumber-1];
        }
        
    }
   
    public boolean closeBreakoutRoom(int roomNumber){
        if(numOfRooms<roomNumber){
            System.out.println("Room not created yet.");
            return false;
        }else {
            breakoutRooms[roomNumber-1].closeBreakoutRoom();
            return true;
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(numOfRooms<roomNumber){
            System.out.println("Room not created yet.");
            return false;
        }else {
            breakoutRooms[roomNumber-1].openBreakoutRoom();
            return true;
        }
    }
    
    public String listBreakoutRooms(){
        String newline = "\n";
        String list = "Virtual Room: "+name +newline;
        if(numOfRooms==0){
            list += "No Rooms";
        }else {
            for(int i=0; i<numOfRooms; i++){
            list += breakoutRooms[i].toString() + ", ";
            }
        }
        list += ".";
    return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String listP = "";
        if(numOfRooms<roomNumber){
            System.out.println("Room not created yet.");
            return null;
        }else{
            listP = breakoutRooms[roomNumber].listParticipants();
        }
        return listP;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        if(numOfRooms<roomNumber){
            System.out.println("Room not created yet.");
            return false;
        } else {
            breakoutRooms[roomNumber].addParticipant(participantID);
            return true;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        //iterate though listparticipants() in all breakout rooms, store first line for breakoutRoomID
        String breakoutRoomFound = "";
        String participantList = "";
        String[] lines = new String[100];
        for(int j=0; j<numOfRooms; j++){ //iterate rooms
            participantList = breakoutRooms[j].listParticipants();
            lines = participantList.split("\\n");
            int count = 1;
            int arrLength = lines.length - 1;
            while(count<arrLength){ //iterate participants in room
                if(lines[count] == participantID){ 
                    breakoutRoomFound = lines[0];
                    return "Participant" + participantID + "is located at " + breakoutRoomFound;
                }
            }
        }
        return null;
    }
}
/* Sources:
 * https://stackoverflow.com/questions/9384559/how-to-read-second-line-from-a-string-in-java
 * https://www.techiedelight.com/print-newline-java/
 */