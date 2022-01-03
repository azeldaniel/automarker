package out.Rashad_Downes_657743_assignsubmission_file_;
/**
 * ID#: 816015845
 *
 * @author (Rashad Downes)
 * @version (Thursday, February 11th, 2021)
 */

public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private int numRooms;
    private boolean isOpen;

    private BreakoutRoom[] breakoutRooms = new BreakoutRoom[5];

    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit = 5;
        isOpen = true;
        numRooms = 0;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        isOpen = true;
        numRooms = 0;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }

    public void createBreakoutRooms(){
        while (numRooms < breakoutRoomLimit){
            BreakoutRoom room = new BreakoutRoom("Seminar");
            breakoutRooms[numRooms] = room;
            numRooms += 1;
        }
    }

    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(numRooms >= roomNumber)
            return breakoutRooms[roomNumber];
        return null;
    }

    public boolean closeBreakoutRoom(int roomNumber){
        if (breakoutRooms[roomNumber].getOpen() == true){
            breakoutRooms[roomNumber].closeBreakoutRoom(); // now closed
            return true; // success
        }else{
            return false; // already closed, no need to close
        }
    }

    public boolean openBreakoutRoom(int roomNumber){
        if (breakoutRooms[roomNumber].getOpen() == false){
            breakoutRooms[roomNumber].openBreakoutRoom(); // now opened
            return true; // success
        }else{
            return false; // already open, no need to open
        }
    }

    public String listBreakoutRooms(){
        if (numRooms == 0)
            return "No rooms to be listed";
        else{
            String details = "";
            for (int i=0; i<numRooms; i++)
                details += breakoutRooms[i].toString();

            return details;
        }
    }

    public String listParticipantsInBreakoutRoom(int roomNumber){
        if (breakoutRooms[roomNumber] == null)
            return "Room does not exist. No participants present.";
        else
            return breakoutRooms[roomNumber].listParticipants();
    }

    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        boolean wasAdded = false;
        if (breakoutRooms[roomNumber] == null)
            return wasAdded;
        else{ 
            wasAdded = breakoutRooms[roomNumber].addParticipant(participantID);   
            if (wasAdded == true)
                return wasAdded;
        }
        return wasAdded;
    }

    public String findParticipantBreakoutRoom (String participantID){
       for(int i=0; i<getNumberOfBreakoutRooms(); i++){
             breakoutRooms[i].findParticipant(participantID);
             if(breakoutRooms[i].findParticipant(participantID) != null)
                return breakoutRooms[i].getBreakoutRoomID();
        }
       return null;
    }

}
