package out.Joshua_Davis_657702_assignsubmission_file_;/*
    Student ID: 816022176
*/

public class VirtualRoom {
    private String name;
    private final int breakoutRoomLimit;
    
    
    private BreakoutRoom[] breakoutRooms;

    


    public VirtualRoom(String name){
        this(name, 5);
    }
    public VirtualRoom(String name, int limit){
        breakoutRoomLimit = limit;
        this.name = name;
        
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }

    public void createBreakoutRooms(){
        // breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        for (int i =0; i < breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    public boolean breakoutRoomsCreated(){
        return breakoutRooms != null;
    }

    public BreakoutRoom findBreakoutRoom(int roomNumber){
        String breakoutRoomID = name + roomNumber;
        for (int i =0; i < breakoutRoomLimit; i++){
            if (breakoutRooms[i].getBreakoutRoomID().equals(breakoutRoomID)){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRoom = findBreakoutRoom(roomNumber);
        if (breakoutRoom != null){
            breakoutRoom.closeBreakoutRoom();
            return true;
        }
        return false;
    }
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRoom = findBreakoutRoom(roomNumber);
        if (breakoutRoom != null){
            breakoutRoom.openBreakoutRoom();
            return true;
        }
        return false;
    }
    public String listBreakoutRooms(){
        String breakoutRoomListString;

        breakoutRoomListString = name;
        for (int i = 0; i < breakoutRoomLimit; i++){
            breakoutRoomListString += "\n" + breakoutRooms[i].toString();
        }

        return breakoutRoomListString;
        
        // if (breakoutRoomLimit >= 1){
        //     breakoutRoomListString = breakoutRooms[0].getBreakoutRoomID();
        //     for (int i = 1; i < breakoutRoomLimit; i++){
        //         breakoutRoomListString += ", " + breakoutRooms[i].getBreakoutRoomID();
        //     }
        // }else{
        //     breakoutRoomListString = "";
        // }

        // return "" 
        //     + "roomName: " + name +"\n"
        //     + "breakoutRooms: [" + breakoutRoomListString + "]"
        // ;
    }
    public int[] listBreakoutRoomNumbersArray(){
        int[] breakoutRoomNumbers = new int[breakoutRoomLimit];
        for (int i =0; i < breakoutRoomLimit; i++){
            breakoutRoomNumbers[i] = breakoutRooms[i].getBreakoutRoomNumber();
        }
        return breakoutRoomNumbers;
    }

    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom breakoutRoom = findBreakoutRoom(roomNumber);
        if (breakoutRoom == null) return null;

        return breakoutRoom.listParticipants();
    }

    public String[] listParticipantsInBreakoutRoomArray(int roomNumber){
        BreakoutRoom breakoutRoom = findBreakoutRoom(roomNumber);
        if (breakoutRoom == null) return null;

        return breakoutRoom.listParticipantsArray();
    }
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom breakoutRoom = findBreakoutRoom(roomNumber);
        if (breakoutRoom == null) return false;
        return breakoutRoom.addParticipant(participantID);
    }
    public String findParticipantBreakoutRoom(String participantID){
        for (int i = 0; i < breakoutRoomLimit; i++){
            if (breakoutRooms[i].findParticipant(participantID) != null){
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        return null;
    }
}