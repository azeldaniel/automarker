package out.Alexis_Pitypaul_657694_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (Alexis Pitypaul - 816020068)
 * @version (1)
 */
public class VirtualRoom
{
    String name;
    int breakoutRoomLimit;
    BreakoutRoom[] breakoutRooms;
    
    public String getName(){
        return name;
    }
    public VirtualRoom (String name){
        breakoutRoomLimit = 5;
        this.name = name;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    public VirtualRoom(String name, int limit){
        breakoutRoomLimit = limit;
        this.name = name;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    public int getNumberOfBreakoutRooms(){
        int num = 0;
        for(int a = 0; a < breakoutRoomLimit; a++){
            if(!breakoutRooms[a].getBreakoutRoomID().equals("\0"))
                num = num + 1;
            else
                num = num;
        }
        return num;
    }
    public void createBreakoutRooms(){
        int a = 0;
        while(a < breakoutRoomLimit){
            breakoutRooms[a] = new BreakoutRoom(name);
            a = a + 1;
        }
    }
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        int a = 0;
        String ID = this.name + roomNumber;
        BreakoutRoom bRoom = new BreakoutRoom(name);
        boolean found = false;
        
        while(a < breakoutRoomLimit && found == false){
            if(breakoutRooms[a].getBreakoutRoomID().equals(ID)){
                bRoom = breakoutRooms[a];
                found = true;
            }
            a =  a + 1;
        }
        if(found)
            return bRoom;
        else
            return null;
    }
    public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){ //checks if room exists
            findBreakoutRoom(roomNumber).closeBreakoutRoom();
            return true;
        }else{
            return false;
        }
    }
    public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){ //checks if room exists
            findBreakoutRoom(roomNumber).openBreakoutRoom();
            return true;
        }else{
            return false;
        }
    }
    public String listBreakoutRooms(){
        String v = "Virtual Room Name: " + name + "\n";
        for(int a = 0; a < breakoutRoomLimit; a++){
            v += "Breakout Room: " + breakoutRooms[a].getBreakoutRoomID() + "\n";
        }
        return v;
    }
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String pList = null;
        if(findBreakoutRoom(roomNumber) != null){ //checks if room exists
            pList += findBreakoutRoom(roomNumber).listParticipants();
            return pList;
        }else{
            return null;
        }
    }
    
    /* https://javarevisited.blogspot.com/2016/10/how-to-check-if-string-
    contains-another-substring-in-java-indexof-example.html#axzz6mUMhnp00 */
    public boolean addParticipantToBreakoutRoom(String participantID,
        int roomNumber){
            int a = 0;
            while(a < breakoutRoomLimit){
                if(breakoutRooms[a].getBreakoutRoomID().contains(roomNumber+"")){ //checks if room ID contains the room number as part of the ID
                    if(breakoutRooms[a].getOpen() && breakoutRooms[a].getNumberOfParticipants()
                        < breakoutRooms[a].getBreakoutRoomSize()){ //if breakoutRoom is open and has space
                            return breakoutRooms[a].addParticipant(participantID);
                    }
                }
                a++;
            }
            return false;
    }
    public String findParticipantBreakoutRoom(String participantID){
        if(participantID.length() > 8 || participantID.length() < 8){ //if ID is valid
            return null;
        }
        for(int a = 0; a < breakoutRoomLimit; a++){
            if(breakoutRooms[a].findParticipant(participantID) != null){ //ID exists
                return breakoutRooms[a].getBreakoutRoomID();
            }
        }
        return null;
    }
}
