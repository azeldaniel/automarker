package out.Sade_Audain_657723_assignsubmission_file_;/*
COMP 2603 Object Oriented Programming 1
Assignment 1
2020/2021 Semester 2

STUDENT NAME: Sade Audain
ID: 816013000
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

   
    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];

    }
    public VirtualRoom(String name,int limit)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];

    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    public int getNumberOfBreakoutRooms(){
        //Returns total number of breakout room managed by virtual room
         return breakoutRoomLimit;
    }

    public void createBreakoutRooms(){
        //Create a new breakout room
        int i;
        for(i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }

    public BreakoutRoom findBreakoutRoom(int roomNumber){
        //Return breakout romm with room number
        if(roomNumber >=1 && roomNumber <= breakoutRoomLimit){
            return breakoutRooms[roomNumber - 1];
        }
        return null;
    } 

    public boolean closeBreakoutRoom(int roomNumber){
        //Close breakout room with room number
        if(roomNumber >=1 && roomNumber <= breakoutRoomLimit){
            breakoutRooms[roomNumber - 1].closeBreakoutRoom();
            return true;
        }
        return false;
    }

    public boolean openBreakoutRoom(int roomNumber){
        //Open breakout room with room number
        if(roomNumber >=1 && roomNumber <= breakoutRoomLimit){
            breakoutRooms[roomNumber - 1].openBreakoutRoom();
            return true;
        }
        return false;
    }

    public String listBreakoutRooms(){
        //Return list of breakout room
        int i;
        String virtualRoomDetails = "";
        virtualRoomDetails = "Virtual Room Name: "+ name+ "\n";
        for(i =0; i < breakoutRoomLimit; i++){
            virtualRoomDetails += breakoutRooms[i].toString()+ "\n";
        }
        return virtualRoomDetails;

    }

    public String listParticipantsInBreakoutRoom(int roomNumber){
        //Return a list of participant in breakout room
        BreakoutRoom r;
        r = findBreakoutRoom(roomNumber);
        String virtualRoomDetails = "";

        if(r != null){
            virtualRoomDetails = r.listParticipants();
            return virtualRoomDetails;
        }

        return null;
    }

    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        //Add a new participant to breakout room
        BreakoutRoom r;
        r = findBreakoutRoom(roomNumber);
        //System.out.println("HERE" + r.toString());
        if(r != null){
            return r.addParticipant(participantID);
        }

        return false;

    }

    public String findParticipantBreakoutRoom(String participantID){
        //Return breakout room ID with valid participant ID
        int i;
        for(i =0; i < getNumberOfBreakoutRooms(); i++){
            if(breakoutRooms[i].findParticipant(participantID)!= null){
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        return null;
    }

}
