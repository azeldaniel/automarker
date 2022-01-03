package out.Dhanesh_Sankar_657707_assignsubmission_file_;/**
Dhanesh Sankar
816020350
 */
import java.util.Scanner;
public class VirtualRoom
{
    private String name; 
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;  
    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name){
      this.name = name; 
      this.breakoutRoomLimit = 5; 
      this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];  
    }
    
    /**
     * Overloaded Constructor
     */
    public VirtualRoom(String name,int limit){
        this.name = name;
        this.breakoutRoomLimit = limit; 
        this.breakoutRooms = new BreakoutRoom[limit];  
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public String getVirtualRoomName(String name){
        return this.name; 
    }
    
    public void createBreakoutRooms(){
        String NewbreakoutRoom = " "; 
        Scanner keyboard = new Scanner(System.in);     
        for(int i=0; i<breakoutRoomLimit; i++){
           System.out.println("Enter breakout room name.");
           System.out.println("\n");
           name = keyboard.nextLine();
           breakoutRooms[i] = new BreakoutRoom(NewbreakoutRoom);
           System.out.println(breakoutRooms[i].toString());
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){ 
        for(int roomID=0; roomID<breakoutRoomLimit;roomID++){            
           if(roomID == roomNumber){
               return breakoutRooms[roomID];
             }         
        }    
        System.out.println("Room not found");
        return null;
    }

    
    public boolean closeBreakoutRoom(int roomNumber){
       breakoutRooms[roomNumber].closeBreakoutRoom();      
       System.out.println(breakoutRooms[roomNumber].toString());       
       return true;
    } 

    public boolean openBreakoutRoom(int roomNumber){
        breakoutRooms[roomNumber].openBreakoutRoom();
        System.out.println(breakoutRooms[roomNumber].toString());
        return true;
    }

    public String listBreakoutRooms(){
        String RoomList = " " + "\n";        
        RoomList+= "Virtual Room Name:" + " " + name + "\n";
        for(int num=0; num<breakoutRoomLimit; num++){
           RoomList +=breakoutRooms[num].toString() + "\n";
        }
        return RoomList;       
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String breakoutRoomlist=" "+ "\n";        
        breakoutRoomlist = breakoutRoomlist + "BreakoutRoom Number: " + " " + roomNumber + "\n";
        //breakoutRoomlist+= "BreakoutRoom ID: " + VirtualRoom.this.name + roomNumber+ "\n"; 
        breakoutRoomlist += breakoutRooms[roomNumber].listParticipants() + "\n";       
        return breakoutRoomlist;  
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom newRoom = new BreakoutRoom("New Room");
        newRoom = findBreakoutRoom(roomNumber);
        boolean checkParticipant; 

        if(newRoom!=null){
            checkParticipant = newRoom.addParticipant(participantID);
            if(checkParticipant==true){
                return true;
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int num=0; num<breakoutRoomLimit;num++){
            if(breakoutRooms[num].findParticipant(participantID)!=null){
                return breakoutRooms[num].toString();
            }
        } 
        return null;
    }
}