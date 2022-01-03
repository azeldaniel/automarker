package out.Casidy_Mohamed_657801_assignsubmission_file_;//816013169

public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
   
    private int x;
    private int y;
    private boolean state;
    private int num;
    private String list;
    private BreakoutRoom br;
    
    public VirtualRoom (String name)
    {
        this.name=name;
        breakoutRoomLimit=5;
        breakoutRooms=new BreakoutRoom[breakoutRoomLimit];
        
        x=0;
        y=0;
        num=0;
        list="";
        state=false;
        
        for(x=0;x<5;x++)
        {
            breakoutRooms[x]=new BreakoutRoom(name);
        }
       
    }
    
    public VirtualRoom(String name, int limit)
    {
        this.name=name;
        breakoutRoomLimit=limit;
        breakoutRooms=new BreakoutRoom[breakoutRoomLimit];
        
        x=0;
        y=0;
        num=0;
        list="";
        state=false;
         for(x=0;x<5;x++)
        {
            breakoutRooms[x]=new BreakoutRoom(name);
        }
    }
    
    public int getNumberOfBreakoutRooms()
    {
       return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms()
    {
        for(x=0;x<breakoutRoomLimit;x++)
        {
            br=new BreakoutRoom(name);
            breakoutRooms[x]=br;
        } 
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
          x=roomNumber;
          if(x<1 || x>5)
              return null;
          else
              return breakoutRooms[x-1];
    }
     
   
    public boolean closeBreakoutRoom(int roomNumber)
    {
       br=findBreakoutRoom(roomNumber);
        
        if(br==null)
            return false;
        else
        {
            br.closeBreakoutRoom();
            return true;
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        br=findBreakoutRoom(roomNumber);
        
        if(br==null)
            return false;
        else
        {
            br.openBreakoutRoom();
            return true;
        }
    }
    
    public String listBreakoutRooms()
    {
        list="";
        
        for(x=0;x<breakoutRoomLimit;x++)
        {
            list=list+ breakoutRooms[x].getBreakoutRoomID() + "\n";
        }
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        br=findBreakoutRoom(roomNumber);
        list="";
        
        if (br != null){
            list = list + br.listParticipants();
            return list;
        }
        System.out.println("Sorry, the breakout room does not exist");
        return null;
    }
    
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        br=findBreakoutRoom(roomNumber);
        
        if(br==null)
        {
            System.out.println("Sorry, this breakout room does not exist");
            return false;
        }
        else
        {
            state= br.addParticipant(participantID);
            if(state==true)
                return true;
        }
        return false;
    }
    
   
    public String findParticipantBreakoutRoom(String participantID)
    {
        for(x=0;x<breakoutRoomLimit;x++)
        {
            if(breakoutRooms[x].findParticipant(participantID)!=null)
            {
                return breakoutRooms[x].getBreakoutRoomID();
            }
        }
        return null;
    }
        
    public int getBreakoutRoomLimit()
    {
        return breakoutRoomLimit;
    }
   
}
               