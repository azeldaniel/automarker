package out.Adrienne_Baptiste_657672_assignsubmission_file_;
/**
ID:816020784
 */
public class VirtualRoom
{
    // instance variables 
    private String name;
    protected final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name){
       this.name=name;
       breakoutRoomLimit=5;
       breakoutRooms= new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit){
       this.name=name;
       breakoutRoomLimit=limit;
       breakoutRooms= new BreakoutRoom[breakoutRoomLimit];
    }

    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
      }
    
    public void createBreakoutRooms(){
        int index= getNumberOfBreakoutRooms();
        if (index == breakoutRoomLimit)
            System.out.println("Limit reached");
        else{
            for(int i=0; i<breakoutRoomLimit; i++){
                breakoutRooms[i]=new BreakoutRoom(name);
            }
        }
    }
    
    public BreakoutRoom findBreakoutRooms(int roomNumber){
        int i=0;
        String ID= new String();
        ID=name + roomNumber;
            while(i!=breakoutRoomLimit){
                if(breakoutRooms[i].getBreakoutRoomID().equals(ID))
                
                    return breakoutRooms[i];
                i++;
            }
        
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        int i=0;
        String ID = name+ roomNumber;
        if (breakoutRooms[0]==null)
            return false;
        else{
            while(breakoutRooms[i]!=null){
                if(breakoutRooms[i].getBreakoutRoomID().equals(ID)){
                    breakoutRooms[i].closeBreakoutRoom();
                    return true;
                }
                i++;
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        int i=0;
        String ID= name + roomNumber;
        if (breakoutRooms[0]==null)
            return false;
        else{
            while(breakoutRooms[i]!=null){
                if(breakoutRooms[i].getBreakoutRoomID().equals(ID)){
                    breakoutRooms[i].openBreakoutRoom();
                    return true;
                }
                i++;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String outputString=new String();
        outputString= name;
        int curr;
        for(curr=0; curr<breakoutRoomLimit;curr++){
            outputString= "\n" + outputString +" "+ breakoutRooms[curr].getBreakoutRoomID();
        }
        return outputString;
    }
    
    public String listParticipantInBreakoutRoom(int roomNumber){
        BreakoutRoom b= findBreakoutRooms(roomNumber);
        if (b==null)
            return null;
        else
        return b.listParticipants();
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom b= new BreakoutRoom(null);
        b= findBreakoutRooms(roomNumber);
        return b.addParticipant(participantID);
    }
  
    public String findParticipantBreakoutRoom(String participantID){
        for(int curr=0; curr<breakoutRoomLimit;curr++){
            if(breakoutRooms[curr].findParticipant(participantID)!= null)
                return breakoutRooms[curr].getBreakoutRoomID();
        }
        return null;
    }
}
