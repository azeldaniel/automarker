package out.Danielle_Charles_657700_assignsubmission_file_;
/**
 * @author Danielle Charles 816017229
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    private static int numberOfBreakoutRooms = 0;
    
    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRooms = new BreakoutRoom[5];
        breakoutRoomLimit = 5;
    }

    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];
    }
    
    public int getNumberOfBreakoutRooms()
    {
        return numberOfBreakoutRooms;
    }
    
    public void createBreakoutRooms()
    {
        for(int i = 0; i<breakoutRoomLimit; i++)
        {
            breakoutRooms[i] = new BreakoutRoom(name);
            //breakoutRooms[i].openBreakoutRoom(); // automatically open breakout rooms
            numberOfBreakoutRooms++;
        }
        //System.out.println("br created");
        //System.out.println(numberOfBreakoutRooms);
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        if (numberOfBreakoutRooms == 0)
        {
            return null;
        }
        else
        {
            for(int i = 0; i<numberOfBreakoutRooms;i++)
            {
                if(i == roomNumber)
                {
                    return breakoutRooms[i-1];
                }
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        if (numberOfBreakoutRooms == 0)
        {
            return false;
        }
        else
        {
            for(int i = 0; i<=numberOfBreakoutRooms;i++)
            {
                if(i == roomNumber)
                {
                    breakoutRooms[i-1].closeBreakoutRoom();
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        if (numberOfBreakoutRooms == 0)
        {
            return false;
        }
        else
        {
            for(int i = 0; i<=numberOfBreakoutRooms;i++)
            {
                if(i == roomNumber)
                {
                    breakoutRooms[i-1].openBreakoutRoom();
                    return true;
                }
            }
        }
        return false;
    }
    
    public String listBreakoutRooms()
    {
        String breakoutRoomList = name;
    
        for(int i = 0; i < numberOfBreakoutRooms; i++)
        {
            breakoutRoomList = breakoutRoomList + "\n" + breakoutRooms[i].getBreakoutRoomID();
        }
        return breakoutRoomList;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        if( numberOfBreakoutRooms == 0)
        {
            return "hi";
        }
        else
        { 
           for(int i = 0; i<=numberOfBreakoutRooms;i++)
            {
                if(i == roomNumber)
                {
                    return breakoutRooms[i-1].listParticipants();
                }
            }
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID,int roomNumber)
    {
        if( numberOfBreakoutRooms == 0)
        {
            return false;
        }
        else
        { 
            for(int i = 1; i<=numberOfBreakoutRooms;i++)
            {
                if(i == roomNumber)
                {
                    //System.out.println(breakoutRooms[i-1].addParticipant(participantID));
                    return breakoutRooms[i-1].addParticipant(participantID);
                }
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        if( numberOfBreakoutRooms == 0)
        {
            return null;
        }
        else
        { 
            for(int i = 0; i<numberOfBreakoutRooms;i++)
            {
                if(breakoutRooms[i].findParticipant(participantID) != null)
                {
                    return breakoutRooms[i].getBreakoutRoomID();
                }
            }
        }
        return null;
    }
    
    /*public static void main(String[] args)
    {
        VirtualRoom vr = new VirtualRoom("Danielle");
        System.out.println(vr.name);
        //System.out.println(vr.breakoutRoomLimit);
        vr.createBreakoutRooms();
        //System.out.println(vr.breakoutRooms[1].toString());
        //System.out.println(vr.findBreakoutRoom(2));
        System.out.println(vr.openBreakoutRoom(2));
        //System.out.println(vr.findBreakoutRoom(3));
        //System.out.println(vr.getNumberOfBreakoutRooms());
        //System.out.println(vr.listBreakoutRooms());
        System.out.println(vr.addParticipantToBreakoutRoom("98765432", 2));
        System.out.println(vr.addParticipantToBreakoutRoom("87654321", 2));
        System.out.println(vr.listParticipantsInBreakoutRoom(1));
        System.out.println(vr.listParticipantsInBreakoutRoom(2));
        System.out.println(vr.findParticipantBreakoutRoom("8765431"));
    }*/
}
