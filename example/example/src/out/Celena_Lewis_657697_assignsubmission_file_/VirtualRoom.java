package out.Celena_Lewis_657697_assignsubmission_file_;//Celena Lewis
//816019582
//Assignment One COMP 2603 

import java.util.Scanner;

public class VirtualRoom
{  
    private String name; //name of room;
    private final int breakoutRoomLimit; //limit of breakoutroom
    private BreakoutRoom[] breakoutRooms; // list of the breakout rooms managed by the virtual room

   public VirtualRoom(String name){
      this.name = name; 
      this.breakoutRoomLimit = 5; //sets limit of breakout room to 5;
      this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];//creates a new breakoutroom object with a limit 
    }
    //Constructor for VirtualRoom class
    public VirtualRoom(String name,int limit){
        this.name = name;
        this.breakoutRoomLimit = limit; //sets limit of breakout room to supplied limit;
        this.breakoutRooms = new BreakoutRoom[limit]; //creates a new breakoutroom object with a limit 
    }
    //overloaded constructor
    //Initializes the breakoutRoomLimit to the supplied limit
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    //accessor for the number of breakoutrooms 
    
    public void createBreakoutRooms(){
        String breakoutRoomName = " "; //name of breakout room
       Scanner keyboard = new Scanner(System.in);
     
       for(int i=0;i<breakoutRoomLimit;i=i+1){
           System.out.println("Please enter the name of the breakout room"); //prompt user for a breakout room name
           System.out.println("\n");
           name = keyboard.nextLine();
           breakoutRooms[i] = new BreakoutRoom(breakoutRoomName);
           //refer to breakoutroom in breakoutroom class 
           //create a breakout room with the name given from prompt
           System.out.println(breakoutRooms[i].toString());
           //use of toString method given in the breakout room class
        }
        //return;
    }
    //creates new BreakoutRoom objects that fill the list of breakout rooms
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i=0;i<breakoutRoomLimit;i=i+1){
           if(i==roomNumber){ //starts from 0
               return breakoutRooms[i];
             }
    }
    
    System.out.println("Room cannot be found...");
    return null;
}
    //locates and returns the breakout room with the supplied room number
    
     public boolean closeBreakoutRoom(int roomNumber){
       breakoutRooms[roomNumber].closeBreakoutRoom();      
       System.out.println(breakoutRooms[roomNumber].toString());       
       return true;
    } 
    //closes a breakout room with the supplied room number if it exists

    public boolean openBreakoutRoom(int roomNumber){
        breakoutRooms[roomNumber].openBreakoutRoom();
        System.out.println(breakoutRooms[roomNumber].toString());
        return true;
    }
    //opens a breakout room with the supplied room number if it exists
    
    public String listBreakoutRooms(){
        String breakoutRoomList = " " ; //initialization
        int i = 0;
        
        breakoutRoomList+= "Virtual Room:" + " " + name;
        //System.out.println("Virtual Room Name:" + " " + name + "\n");
        for(i=0;i<breakoutRoomLimit;i++){
            breakoutRoomList +=breakoutRooms[i].toString() + "\n";
        }
        return breakoutRoomList;
        
    }
    //Returns a list of the breakout rooms managed by
    //the virtual room with the virtual room name heading
    //the list on a separate line
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        //System.out.println(listBreakoutRooms());
        //print a list of the breakout rooms by calling method above
        String partblist="";
        /*
        partblist = partblist + "Breakout room:" + " " + roomNumber + "\n";
        partblist += "Room ID: " + " " + breakoutRooms[roomNumber].getbreakoutRoomID() + "\n"; //accessor in the breakout room class
        partblist += "Participants: " + breakoutRooms[roomNumber].listParticipants() + "\n";
        //access the list of participants using the listParticipants method
       */
        //partblist = partblist + "BreakoutRoom Number: " + " " + roomNumber + "\n";
        partblist+= "BreakoutRoom name: " + name + "\n"; 
        //partblist = partblist + "BreakoutRoom Number: " + " " + roomNumber + "\n";
        partblist += breakoutRooms[roomNumber].listParticipants() + "\n";       
        return partblist;  
        //return null;
    }
    //Returns a list of the participants in the breakout
    //room with the supplied room number if found,
    //otherwise returns null
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        /*
         * BreakoutRoom b = findBreakoutRoom(roomNumber);
        boolean isAdded = false;
        if(b!=null){
            isAdded = b.addParticipant(participantID);
        }
        return isAdded;
        //participant has been added to the breakout room
        */
        BreakoutRoom b = findBreakoutRoom(roomNumber);
        //creates a breakoutroom object with a given name
        //finds a particular breakoutroom
        
        boolean findp;
        //accesses the findBreakoutRoom method in class
        //boolean findp = breakoutRooms[roomNumber].addParticipant(participantID);
        if(b!=null){
            findp = b.addParticipant(participantID);
            if(findp==true){
                return true;
            }
        }
        return false;
    }
    //Adds a new participant to the breakout room with
    //the supplied room number if it exists
    
    public String findParticipantBreakoutRoom(String participantID){
        String list = " ";
        int j = 0;
        for(j=0;j<breakoutRoomLimit;j=j+1){
            if(breakoutRooms[j].findParticipant(participantID)!=null){
                //locate a participant given their participantID in a particular breakout room
                return breakoutRooms[j].toString();
            }
        }
       return null;
    }
    //Locates and returns the breakoutRoomID for the
    //breakout room hosting the participant with the
    //(valid) supplied ID, otherwise returns null
}
//VirtualRoom class

