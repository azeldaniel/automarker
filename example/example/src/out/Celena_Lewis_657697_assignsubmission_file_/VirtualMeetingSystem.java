package out.Celena_Lewis_657697_assignsubmission_file_;
//Celena Lewis
//816019582
// Assignment One COMP 2603
import java.util.Scanner; //scanner object
import java.io.File; //file library
import java.io.FileNotFoundException;

public class VirtualMeetingSystem{
    private VirtualRoom newRoom; //virtual room 
    private String[] fID = new String[50]; //size of the participants.dat file
    private int numberOfParticipants;
    
    public void loadParticipantData(String filename) throws Exception{
        int count = 0; //arrary counter for the string array
        //String array creation
        boolean fexists = false;
        String newpath = " ";
        String originalpath = " ";
        //String fID;
        //File file= new FileInputStream(filename);
        File f= new File(filename); //participants.dat file
        //File f = new File("participants.dat");
        //https://www.journaldev.com/864/java-open-file
        //int count = 0; 
        //initialize counter variable
        //opens new file
        //Scanner keyboard = new Scanner();
        Scanner keyboard = new Scanner(f);
        //originalpath = f.getPath();
        //System.out.println("Original path of file:" + " " + originalpath);
        newpath = f.getAbsolutePath();
        //https://www.baeldung.com/java-path
        //newpath = f.getAbsolutePath(); 
        System.out.println("File being read from:" + " " + newpath);
        fexists = f.exists();
        if(fexists == false){
            System.out.println("The file cannot be found in the directory");
            //System.out.println("");    
            return;
        }
    
        while(keyboard.hasNextLine()){
            //input
            fID[count]= keyboard.nextLine();
            System.out.println("ID: " + fID[count] + "\n");
            count = count + 1; 
            //incrementing 
        }
        keyboard.close();
    }
    //reads participant data and loads in a data array
    
    public void createVirtualRoom(String name){
        newRoom = new VirtualRoom(name);
        newRoom.createBreakoutRooms();
        //creates virtual room object with the given name
        //return;
    }
    //creates virtual room with supplied name containing 5 breakout rooms
        
    public void allocateParticipants(String code){
        //int size = fID.length;
        //finds the size of the array
        boolean valid;
        int total=0;
        total = newRoom.getNumberOfBreakoutRooms();
        //accessor in virtual room class
        int count = 0;
        int j = 0;
        int k = 0;
        int i=0;
        //C5 CODE 
        if(code.equals("C5")){
            while(count<total){
                //newRoom.openBreakoutRoom(count-1);
                    for(j=0;j<10;j=j+1){
                        newRoom.addParticipantToBreakoutRoom(fID[i], count);
                        //if(i<10){ //0 to 9 in array
                            //newRoom.closeBreakoutRoom(count);
                        //}
                        i=i+1;
                        
                    }
                    j = 0; //reset counter variable
                count = count + 1;
            }
        }
        //RR code
        if(code.equals("RR")){
        //createVirtualRoom("Name");
            //creates a virtual room by accessing method in virtual room class
            int counter = 0; 
            //int k = 0;
            //i = 0;
            count = 0;
            //j = 0;
            //reset variables declared above
            int size = fID.length;
            //returns the length of the array
            while(count<total){
                //access method to open the breakout room
                    while(k<10){
                        newRoom.addParticipantToBreakoutRoom(fID[j], count);
                        //the participant is added based on the room number
                        counter = size/2 + j;
                        newRoom.addParticipantToBreakoutRoom(fID[counter],count);
                        j = j + 1;
                        k = k + 2;
                    }
                k = 0;
                count = count + 1;
                //reset variables for loop
            }
        }
        System.out.println("No more participants can be allocated to a breakout room");
        return;
        } 
    //allocate participants to a breakout room using C5 and RR methods

    public boolean addParticipant(String participantID,int roomNumber){
        //BreakoutRoom b = findBreakoutRoom(roomNumber);
        //finds a particular breakoutroom
        //boolean findp = breakoutRooms[roomNumber].addParticipant(participantID);
        boolean findp = newRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
        //if the breakoutroom exists with a particular room number,
        //the participant with participantID can be added to the breakoutroom
        if(findp==true){
            //if the room exists and the participant has been added the breakout room
            return true;
        }
        //else{
        return false;
            //otherwise the participant cannot be added to the room because
            //the room does not exist
        //}
        //return true;
    }
    //adds a new participant to the breakout room
    
    public String listParticipants(int roomNumber){
        String list = " ";
        list += newRoom.listParticipantsInBreakoutRoom(roomNumber);
        //access the method in the virtual room class
        //list all the participants in a breakout room with a supplied room number
        //System.out.println("Participants in Breakout room:" + " " + roomNumber + "are:" + " ");
        //System.out.println("\n");
        System.out.println(list);
        //System.out.println("\n");
        return list;
    }
    //returns a list of participants in a breakout room
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean openRoom = newRoom.openBreakoutRoom(roomNumber);
        if(openRoom==true){
            //System.out.println("The breakout room has been opened");
            return true;
        }
        else{
            System.out.println("The room was already opened... cannot be opened again");
            return false;
        }
        /*
        boolean valid = newRoom.openBreakoutRoom(roomNumber);
        //opens the breakout room by accessing the method in the virtual room class
        if(valid){
             System.out.println("The room has been opened");
            return true;
        //room is now opened so return true
        }
        else{
            Sytem.out.println("The room was already opened....");
            return false;
            //room already opened so return false
        }
        */
    }
    //opens a breakout room with the supplied room number if it exists
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean valid = newRoom.closeBreakoutRoom(roomNumber);
        //closes the breakout room by accessing the method in the virtual room class
        if(valid == true){
            //System.out.println("The breakout room is closed...");
            return true;
            //room is now closed so return true
        }
        else{
            System.out.println("The room is already closed... cannot be closed again");
            return false;
            //room is already closed so return false
        }
    }
    //closes a breakout room with the supplied room number if it exists
    
    public String findParticipantBreakoutRoom(String participantID){
        String findp = " ";
        findp = findp + newRoom.findParticipantBreakoutRoom(participantID);
        //access method in the virtual room class
        //find a participant based on their participant ID
        //System.out.println(findp);
        //System.out.println("Participant breakout room:" + " " + findp + "\n" );
        return findp;
    }
    //locates and returns the breakoutRoomID for the breakout room
    //hosting the participant with the (valid) supplied ID
    
    public String listAllBreakoutRooms(){
        String list = "Virtual Room:" + "\n";
        list+= newRoom.listBreakoutRooms();
        //access method in the virtual room class
        //System.out.println("List of Breakout Rooms:" + " " + list + "\n");
        System.out.println(list);
        return list;
    }
    //returns a list of the breakout rooms managed by the virtual room 
    
    public String listParticipantsInAllBreakoutRooms(){
        int totalRooms = 0;
        String partblist = " ";
       
        totalRooms = newRoom.getNumberOfBreakoutRooms();
        //use the accessor method from virtual room class
        System.out.println("The total number of Breakout rooms are:" + " " +  totalRooms);
        System.out.println("\n");
        //the total number of breakout rooms are
        int count;
        for(count=0;count<totalRooms;count=count+1){
       
          partblist += newRoom.listParticipantsInBreakoutRoom(count) + "\n"; 
        }
        
        System.out.println(partblist);
        return partblist;
        
    }
    //returns a list of all the participants per breakout room
    //managed by the virtual room
}
//VirtualMeetingSystem class (invoked by Virtual Runner class)