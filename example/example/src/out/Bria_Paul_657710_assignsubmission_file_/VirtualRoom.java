package out.Bria_Paul_657710_assignsubmission_file_;
/**
 * 816018930
 * @author Bria Paul
 * A virtual room creates and manages up to a certain number of breakout rooms.
 * @version 01/02/200
 */

import java.util.Scanner;

public class VirtualRoom{
    // instance variables
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    /** Constructor for objects of class VirtualRoom */
    public VirtualRoom(String name){
        // initialise instance variables
        this.name=name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    /** Overloaded constructor. Initialises the breakoutRoomLimit to the supplied limit */
    public VirtualRoom(String name, int limit){
        // initialise instance variables
        this.name=name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[limit];
    }
    
    /** Returns the total number of breakout rooms managed by the virtual room */
    public int getNumberOfBreakoutRooms( ){
        return breakoutRoomLimit;
    }
    
    /*** Creates new BreakoutRoom objects that fill the list of breakout rooms */
    public void createBreakoutRooms(){
        String name;
        
        Scanner input = new Scanner(System.in);
        
        for(int i = 0; i < breakoutRoomLimit; i++){
             System.out.println("Enter the name of this breakout room ... \n");
             name=input.nextLine();
             breakoutRooms[i] = new BreakoutRoom(name);
             breakoutRooms[i].openBreakoutRoom();
             System.out.println(breakoutRooms[i].toString());
        }
        return;
    }
    
    //Locates and returns the breakout room with the supplied room number, otherwise returns null
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        String ID = "";
        
        for(int i=0; i<breakoutRoomLimit; i++){
               ID=breakoutRooms[i].getBreakoutRoomID();
            if( ID.equals(String.valueOf(roomNumber))){
                return breakoutRooms[i];
          }
       }
    
       System.out.println("Breakout room not found!");
       return null;
    }

    /** Closes a breakout room with the supplied room number if it exists */
    public boolean closeBreakoutRoom(int roomNumber){
       BreakoutRoom locateRoom = new BreakoutRoom("TemporaryRoom");       
       locateRoom=findBreakoutRoom(roomNumber);
       
       if(locateRoom != null){
            if(locateRoom.getOpen() == true){
           locateRoom.closeBreakoutRoom();
           System.out.println(locateRoom.toString());
           return true;
        }
        else{
               System.out.println("Breakout room already closed.");
               System.out.println(locateRoom.toString());
               return false;
            }
      }
       
      System.out.println("Room has not been closed!");
      
      return false;
    }            
    
    /** Opens a breakout room with the supplied room number if it exists */
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom locateRoom = new BreakoutRoom("TemporaryRoom");       
        locateRoom=findBreakoutRoom(roomNumber);
        
        if(locateRoom != null){
            if(locateRoom.getOpen() == false){
            locateRoom.openBreakoutRoom();
            System.out.println(locateRoom.toString());
            return true;
           }
           else{
               System.out.println("Breakout room already open.");
               System.out.println(locateRoom.toString());
               return false;
            }
        }
        
        System.out.println("Room has not been opened!");
        return false;
    }


    /*** Returns a list of the breakout rooms managed by the virtual room with the virtual room name heading
      the list on a separate line **/
      
      public String listBreakoutRooms(){
          String list="";
          
          list="Virtual Room Name: " + name + "\n";
         for(int i=0; i<breakoutRoomLimit; i++){
            list += "Breakout Room # " + i + "  " + breakoutRooms[i].toString() + "\n";
      }
      return list;
    }
      
    /** Returns a list of the participants in the breakout room with the supplied */
      
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom locateRoom = findBreakoutRoom(roomNumber);
        String list="";
        
        if(locateRoom != null){
         list = locateRoom.listParticipants() + "\n";
         return list;
        } 
        
        return null;
    }

    /** Adds a new participant to the breakout room with the supplied room number if it exists */

    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        boolean newParticipant;
        BreakoutRoom locateRoom = findBreakoutRoom(roomNumber);;
       
        if(locateRoom != null){
           newParticipant=locateRoom.addParticipant(participantID);
           if(newParticipant == true){
           return true;
        }
        
        }
        return false;
    }
    
    /** Locates and returns the breakoutRoomID for the breakout room hosting the participant with the
    * (valid) supplied ID, otherwise returns null */
 
    public String findParticipantBreakoutRoom(String participantID){ 
        String locateParticipant="";
        
        locateParticipant = "Participant found in breakout room: ";
        
        for(int i=0; i<breakoutRoomLimit; i++){
            
            if(breakoutRooms[i].findParticipant(participantID) != null){
                locateParticipant = locateParticipant + breakoutRooms[i].getBreakoutRoomID();
                return locateParticipant;
            }
            
        }
        
        return null;
    }
}