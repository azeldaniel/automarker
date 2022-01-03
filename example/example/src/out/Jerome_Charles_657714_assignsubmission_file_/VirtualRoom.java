package out.Jerome_Charles_657714_assignsubmission_file_;
/*
Jerome Charles 816021939
Assignment 1
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    
    private final int breakoutRoomLimit=5;
    private String name;
    private BreakoutRoom[] breakoutRooms=new BreakoutRoom[breakoutRoomLimit];
    public void setname(String name){
    this.name=name;
    }
    public String getname(){
    return name;
    }
    public BreakoutRoom[] getbreakoutRooms(){
    return breakoutRooms;
    }

    public VirtualRoom(String name)
    {
     //breakoutRoomLimit=5;   
     this.name=name;   
    }
    
    public VirtualRoom(String name,int limit)
    {
     //breakoutRoomLimit=limit;
     this.name=name;
    }

    public int getNumberOfBreakoutRooms(){
    int count=0;    
    for(int i=0;i<5;i++){
        if(breakoutRooms[i].getopen()==true){
            count++;
        }
    } 
    return count;
    }
    
   
    
    public void createBreakoutRooms(){
   //breakoutRoomLimit=5;
   //breakoutRooms=new BreakoutRoom[breakoutRoomLimit];
    
    for(int i=0;i<5;i++){
        String holder=(name+(i+1));
        //System.out.println("createBreakoutRooms-"+holder);
        breakoutRooms[i]=new BreakoutRoom(holder);
        //breakoutRooms[i].setbreakoutRoomID(holder);
        
        //System.out.println(breakoutRooms[i].getbreakoutRoomID());
    }
    }
    
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
    String fullname=(name+roomNumber);
    
    for(int i=0;i<5;i++){
    if(breakoutRooms[i].getbreakoutRoomID().equals(fullname)){
        //System.out.println("found room");
        return breakoutRooms[i];}
        
    }
    return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
    String fullname=(name+roomNumber);
    for(int i=0;i<5;i++){
    if(breakoutRooms[i].getbreakoutRoomID().equals(fullname)){ 
        breakoutRooms[i].closeBreakoutRoom();
        System.out.println("Room has been closed");
        return true;
    }
        
    }
    System.out.println("Room was not found");
    return false;
    }
    
    
    public boolean openBreakoutRoom(int roomNumber){
    String fullname=(name+roomNumber);
    for(int i=0;i<5;i++){
    if(breakoutRooms[i].getbreakoutRoomID().equals(fullname)){ 
        breakoutRooms[i].openBreakoutRoom();
        //System.out.println("Room has been opened");
        return true;
    }
        
    }
    System.out.println("Room was not found");
    return false;
    }
    
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
    
    String fullname=(name+roomNumber);
    for(int i=0;i<5;i++){
    if(breakoutRooms[i].getbreakoutRoomID().equals(fullname) && breakoutRooms[i].getopen()==true){ 
       return breakoutRooms[i].listParticipants(); 
    }
   
    }
    
    return null;
}
    
 public boolean addParticipantToBreakoutRoom(String participantID,int roomNumber){
     //System.out.println(participantID+" "+roomNumber);
     
     String fullname=(name+roomNumber);
    for(int i=0;i<5;i++){
    if(breakoutRooms[i].getbreakoutRoomID().equals(fullname)){ 
     findBreakoutRoom(roomNumber).addParticipant(participantID);
     return true;
    }
    }   
    return false;
}
    
    
 public String findParticipantBreakoutRoom(String participantID){
  
     for(int i=0;i<5;i++){
        
        if(breakoutRooms[i].findParticipant(participantID)!=(null)){
        return breakoutRooms[i].getbreakoutRoomID();}
 
        }
    
    
  return null;  
 }   
    
     
    
}
