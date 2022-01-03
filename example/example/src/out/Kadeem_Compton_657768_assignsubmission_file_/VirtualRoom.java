package out.Kadeem_Compton_657768_assignsubmission_file_;//814002641

public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    private int numberOfBreakoutRooms;

    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        numberOfBreakoutRooms = 0;
    }

    public VirtualRoom( String name, int limit)
    {
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        numberOfBreakoutRooms = 0;
    }

    public int getNumberOfBreakoutRooms( )

    {
        return numberOfBreakoutRooms;
    }

    
    public void createBreakoutRooms()
    {
        for (int i=0; i < breakoutRoomLimit ; i++)
        {
            breakoutRooms[i] = new BreakoutRoom(name);
            numberOfBreakoutRooms++;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        if (roomNumber > numberOfBreakoutRooms || roomNumber < 1)
            return null;
        
        else
            return breakoutRooms[roomNumber-1];

        
    }

    public boolean closeBreakoutRoom(int roomNumber)
    {
        if (roomNumber > numberOfBreakoutRooms || roomNumber < 1)
            return false;
        
        else{
            breakoutRooms[roomNumber-1].closeBreakoutRoom();
            return true;
        }
    }

    public boolean openBreakoutRoom(int roomNumber)
    {
        if (roomNumber > numberOfBreakoutRooms || roomNumber < 1)
            return false;
        
        else{
            breakoutRooms[roomNumber-1].openBreakoutRoom();
            return true;
        }
    }


    public String listBreakoutRooms( ) 
    {
        String list = "Virtual Room: " + name + "\nBreakout rooms:\n" ;

        for (int i=0; i < numberOfBreakoutRooms ; i++)
        {
            list += breakoutRooms[i].toString() + "\n";
        }
        return list;
    }

    public String listParticipantsInBreakoutRoom(int roomNumber) 
    {
        if (roomNumber > numberOfBreakoutRooms || roomNumber < 1)
            return null;
        
        else 
            return breakoutRooms[roomNumber-1].listParticipants();

    }


    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        if (roomNumber > numberOfBreakoutRooms || roomNumber < 1)
            return false;
        
        else
        {
            breakoutRooms[roomNumber-1].addParticipant(participantID);
            return true;
        }
    }

    public String findParticipantBreakoutRoom(String participantID)
    {

        for (int i=0; i < numberOfBreakoutRooms ; i++)
        {
            Participant p = breakoutRooms[i].findParticipant(participantID);
            if (p != null)
                return "Participant found in " + breakoutRooms[i].getBreakoutRoomID();
        }

        return null;
    }
  
}
