package out.Jonathan_Hoyte_657737_assignsubmission_file_;// 816013096
public class VirtualRoom
{
    private String name = "";
    private int breakoutRoomLimit;
    private BreakoutRoom[] BR;
    private int counter;
    private int roomNumber = 0;
   
  public VirtualRoom(String name)
    { setName(name);
    }
    
  public VirtualRoom(String name, int breakoutRoomLimit){
        setName(name);
        breakoutRoomLimit=5;
        createBreakoutRooms();
    }
    
   public void setName(String name){
    this.name=name;
  }
    public int getNumberOfBreakoutRooms(){
    return 5;
  } 
   
   public void createBreakoutRooms(){
       String nam;
       BR = new BreakoutRoom[breakoutRoomLimit];
       for(int y =0; y<breakoutRoomLimit; y++){
           nam = name + Integer.toString(y+1);
           BR[y]= new BreakoutRoom(nam);
    }
    }
    
   public BreakoutRoom findBreakoutRoom(int roomNumber){
       int Less = roomNumber -1;
       if (BR[Less] == null){
        return null;
    } else{
       return BR[Less];
    }   
   }
    
   public boolean closeBreakoutRoom(int roomNumber){
       int less = roomNumber -1;
       if(findBreakoutRoom(roomNumber) == null){
        return false;
    }
       else{BR[less].closeBreakoutRoom();
         return true;}
    }
   
   public boolean openBreakoutRoom(int roomNumber){
       int less = roomNumber -1;
       if(findBreakoutRoom(roomNumber) == null){
        return false;
    }
       else{BR[less].openBreakoutRoom();
       return true;}
    }
   
   public String listBreakoutRooms(){
       String listo = "";
       String nam = "";
       for(int u=0; u<breakoutRoomLimit; u++){
           nam = Integer.toString(u+1);
           listo += BR[u].getName(nam);
           listo += "\n ";
        }
    return listo;
   }
   
   public String listParticipantsInBreakoutRoom(int roomNumber){
      String perps = "";
      int less = roomNumber -1;
      if(BR[less].listParticipants()==null){return null;}
      perps = BR[less].listParticipants();
    return perps;
   }
   
   public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
       int less = roomNumber-1;
       boolean decision=false;
       decision=BR[less].addParticipant(participantID);
       if(decision==false)
         return false; 
       return true;
   }
   
   public String findParticipantBreakoutRoom(String participantID){
    String Breaks = "";
    String p = "";
    for(int t =0; t<breakoutRoomLimit;t++){
        if(BR[t].findParticipant(participantID)!=null){
            p=Integer.toString(t+1);
        return " Participant: "+ participantID + BR[t].getName(p);
      }
    }
    return null;
   }
}
