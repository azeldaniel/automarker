package out.Madeenah_Salamat_657821_assignsubmission_file_;// ID: 816020303

import java.util.Scanner;

public class VirtualRoom{
    private String name; //name of the room
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    //constructor
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    //overloaded constructor
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    //methods
    public int getNumberOfBreakoutRooms(){
        return breakoutRooms.length;
    }
    
    public void createBreakoutRooms(){
        Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i < breakoutRoomLimit; i++){
            System.out.println("Please enter Breakout Room name: ");
            String name = keyboard.nextLine();
            breakoutRooms[i] = new BreakoutRoom(name);
            System.out.println(breakoutRooms[i].toString());
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for (int i = 0; i < breakoutRoomLimit; i++){
            if ( i == roomNumber){
                System.out.println("Room found!");
                return breakoutRooms[i];
            }
        }
        return null;
    } 

    public boolean closeBreakoutRoom(int roomNumber){
        VirtualRoom newVR = new VirtualRoom("TestRoom");
        BreakoutRoom newBR = new BreakoutRoom("testRoom");
        newBR = newVR.findBreakoutRoom(roomNumber);
        if(newBR != null){
            newBR.closeBreakoutRoom();
            newBR.toString();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        VirtualRoom newVR = new VirtualRoom("TestRoom");
        BreakoutRoom newBR = new BreakoutRoom("testRoom");
        newBR = newVR.findBreakoutRoom(roomNumber);
        if(newBR != null){
            newBR.openBreakoutRoom();
            newBR.toString();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String listOfBreakoutRooms = "Virtual Room Name: " + this.name + "\n";
        for (int i = 0; i < breakoutRoomLimit; i++){
            listOfBreakoutRooms += breakoutRooms[i].toString() +"\n";
        }
        return listOfBreakoutRooms;
    }
  
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String listOfPInBR = "Participants in Breakout Room" + "\n";
        for (int i = 0; i < breakoutRoomLimit; i++){
            listOfPInBR += breakoutRooms[i].listParticipants() + "\n";
        }
        return listOfPInBR;
    }

    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        //VirtualRoom newVR = new VirtualRoom("TestRoom");
        //BreakoutRoom newBR = new BreakoutRoom("testRoom");
        //newBR = newVR.findBreakoutRoom(roomNumber);
        //boolean added = newBR.addParticipant(participantID);
        boolean added = breakoutRooms[roomNumber].addParticipant(participantID);
        if(added == true){
            return true;
        }
        return false;
    }
    
    /*
    public String findParticipantBreakoutRoom(String participantID){
        Participant participantLoc;
        BreakoutRoom[] breakoutRooms = new BreakoutRoom[]{};
        BreakoutRoom BRLoc;
        for(int i = 0; i < breakoutRooms.length; i++){
            participantLoc = breakoutRooms[i].findParticipant(participantID);
            
            if (participantLoc != null){
                return breakoutRooms[i].breakoutRoomID();
            }
        }
        return null;
    }
    */
    
    /* public static void main(){
        Scanner cin = new Scanner(System.in);
        
        System.out.println("Enter name of VR!");
        String name = cin.nextLine();
        VirtualRoom TestVR = new VirtualRoom(name);
        
        TestVR.createBreakoutRooms();
        System.out.println(TestVR.listBreakoutRooms());
        String ID=""; 
        int rNum=0;
        System.out.println("Enter ID ... room #");
        ID = cin.nextLine();
        rNum = cin.nextInt();
        TestVR.addParticipantToBreakoutRoom(ID, rNum);
        
        System.out.println("Enter ID ... room #");
        ID = cin.nextLine();
        rNum = cin.nextInt();
        TestVR.addParticipantToBreakoutRoom(ID, rNum);
        
        System.out.println(TestVR.listBreakoutRooms());
        System.out.println(TestVR.listParticipantsInBreakoutRoom(0));
     
        rNum = cin.nextInt();
        boolean isClosed = TestVR.closeBreakoutRoom(rNum);
        
    } */
}