package out.Jeremy_De_Freitas_657820_assignsubmission_file_;//816018479
import java.util.Scanner;

public class VirtualRoom{  
    private String name; 
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms; 
  

   public VirtualRoom(String name)
   {
      breakoutRoomLimit = 5;
      this.name = name; 
      this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
  
   }
    
   public VirtualRoom(String name, int limit)
    {//Constructor
        breakoutRoomLimit = limit;
        this.name = name;
        this.breakoutRooms = new BreakoutRoom[limit];
    }
   
    
   public int getNumberOfBreakoutRooms()
   {
      return breakoutRooms.length; 
      
    }
    
    
    public void createBreakoutRooms(){ 
       Scanner keyboard = new Scanner(System.in);
       String Name;
       int count = 0;
       
       while (count < breakoutRoomLimit)
        {
           
           System.out.println("Enter a name for the BreakOut room: "); 
           System.out.println("\n");
           Name = keyboard.nextLine();
        
           breakoutRooms[count] = new BreakoutRoom(Name);
           System.out.println(breakoutRooms[count].toString());
           count++;
        }
        }
    
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
  
        int count = 0;
        while (count < breakoutRoomLimit)
        {
            if(count == roomNumber){
               return breakoutRooms[count];
            }
            count++;
        }
    System.out.println("Room not found!");     
    return null; 
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
       breakoutRooms[roomNumber].closeBreakoutRoom();
       System.out.println(breakoutRooms[roomNumber].toString());
       return true;
            
    }


    public boolean openBreakoutRoom(int roomNumber)
    {
      breakoutRooms[roomNumber].openBreakoutRoom();
      System.out.println(breakoutRooms[roomNumber].toString());
       
      return true;
    }
    
    
    public String listBreakoutRooms()
    {
        String list;
        list = " " ; 
        list = list +  name + "\n";
        int count = 0;
        
        while (count < breakoutRoomLimit)
        {
            list = list + breakoutRooms[count].toString() + "\n";
            count++;
        }
         return list; 
    }
    
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        String participantlist; 
        participantlist = "";

        participantlist = "BreakOut room: " + roomNumber + "\n";
        participantlist += "BreakOut room ID: " + VirtualRoom.this.name + roomNumber + "\n"; 
        participantlist += "Number of Participants: " + breakoutRooms[roomNumber].getNumberOfParticipants() + "\n";
        participantlist += breakoutRooms[roomNumber].listParticipants() + "\n";
        return participantlist;  
    }


    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        
        BreakoutRoom brRoom = new BreakoutRoom("BreakOut room name");
        brRoom = findBreakoutRoom(roomNumber);
        boolean findParticipant;
 
        if(brRoom != null){
          findParticipant = brRoom.addParticipant(participantID);
          
        if(findParticipant==true){
          return true;
        }
    }
        return false;
        }
        

    public String findParticipantBreakoutRoom(String participantID)
{
        int count = 0;
        while (count < breakoutRoomLimit)
        {
            if(breakoutRooms[count].findParticipant(participantID)!=null)
            {
            return breakoutRooms[count].toString();
            }
            count++;
        }
        return null;
   }
}
