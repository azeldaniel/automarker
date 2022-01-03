package out.Chrissanee_Abraham___James_657678_assignsubmission_file_;
/**
 Name:Chrissanee Abraham-James
 ID: 816000377
 Course: Object Oriented Programming
 Course Code: COMP 2603
 Assignment 1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class VirtualMeetingSystem
{
    private int roomNumber = 0;//tester int for no int param being sent
    private String[] parArray= new String[50];
    private String parfile;
    private Scanner in;
    private VirtualRoom VR ;
    private Scanner uin = new Scanner(System.in);
    
    
  
    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    public VirtualMeetingSystem(){
        int i;
        String parfile = new String("participant.dat");
        
    }
    
    public void loadParticipantData(String filename){ 
        //Read data from a file and loads the data into an array for allocation to breakout rooms
        int i=0;
        String data = new String("");
        
         try {
          //File infile = new File(filename);
          File infile = new File("participant.dat");
          Scanner in = new Scanner(infile);
          while (in.hasNextLine()) {
            data = in.nextLine();
            //System.out.println(data+"\n");
            parArray[i] = new String (data);
            //System.out.println(parArray[i]+"\n");
            i++;
          }
          //System.out.println("File loaded.\n");
          in.close();
        } 
        catch (FileNotFoundException e) {
          //System.out.println("File did not load.\n");
          e.printStackTrace();
        }
    }

    
    public void createVirtualRoom(String name)
    //Creates a virtual room with the supplied name, containing 5 breakout rooms
    {

        if (name.equals("")){
            name = uin.nextLine();
        }
        VR = new VirtualRoom(name);
        System.out.println("Room Made: "+ name);
        System.out.println("Breakroom Status Automatically set as Open.\n");
    }
    
    public void allocateParticipants(String code)//WORKS 
    //Allocates participants to the breakout rooms of a virtual room using a strategy determined by the supplied code
    {
        int roomNumber = 0;
        int limit = 5;
        int c = 0;
        int climit=10;
        
        while((!code.equals("C5"))&&(!code.equals("RR"))){
            System.out.println("Incorrect code. Please enter C5 or RR: ");
            code = uin.nextLine();
        }
        
        //limit = VR.getNumberOfBreakoutRooms( );
        
        
        switch(code) {
          case "C5":
            for(roomNumber=0;roomNumber<limit;roomNumber++){
                while(c<climit){
                    //System.out.println("u1.allocate "+parArray[c]+" room index "+ roomNumber);
                    addParticipant(parArray[c],roomNumber);
                    c++;
                }
                climit+=10;
                //System.out.println("Breakroom "+roomNumber+" Allocation Complete.");
            }
            System.out.println("C5 allocation complete.\n");
            break;
          case "RR":
            while(c<50){
                addParticipant(parArray[c],roomNumber);
                c++;
                roomNumber++;
                if(roomNumber>=5){
                    roomNumber = 0;
            }
            
            }
            System.out.println("RR allocation complete.\n");
            break;
         
            
        }
    }    
    
    public boolean addParticipant (String participantID, int roomNumber) //WORKS
    //Adds a new participant to the breakout room with the supplied room number if it exists
    {
        if((roomNumber<5)&&(roomNumber>=0)){
            //roomNumber lost 
        //System.out.println("u1. addp method.Participant: "+ participantID +" room index "+ roomNumber);
            if(VR.addParticipantToBreakoutRoom(participantID, roomNumber)){
                return true;
            }
        }
        return false;
    }
    
    public String listParticipants(int roomNumber)   //WORKS
    //Returns a list of the participants in the breakout room with the supplied room number if found, otherwise returns null
    {
        String details ="";
        if(VR.findBreakoutRoom(roomNumber)==null){
            details+= "No room found at that index.\n";
            return details;
        }
        details ="\n\nBreakoutRoom "+ roomNumber;
        details+=  VR.listParticipantsInBreakoutRoom(roomNumber);
        return details;
    }
    
    public String listAllBreakoutRooms( ) //WORKS
    //Returns a list of the breakout rooms managed by the virtual room
    {
        String details = "";
        details+= "All BreakoutRooms in "+VR.toString();
        details+= VR.listBreakoutRooms();
        return details;
    }

    public String listParticipantsInAllBreakoutRooms() //WORKS. has no output if all rooms are closed
    //Returns a list of all of the participants per breakoutroom managed by the virtual room, otherwisereturns null
    {
        String details ="";
        int i=0;
        
        for(i=0;i<(VR.getNumberOfBreakoutRooms());i++){

            details +="\n\nParticipants in -";
            details+=  VR.listParticipantsInBreakoutRoom(i);
        }
        return details;
    }

    public String findParticipantBreakoutRoom (String participantID)  //WORKS
    //Locates and returns the breakoutRoomID for the breakout room hosting the participant with the (valid) supplied ID, otherwise returns null
    {
        int i;
        String details ="";  
        String test ="";  
        for(i=0;i<(VR.getNumberOfBreakoutRooms());i++){
            test = VR.findParticipantBreakoutRoom (participantID);
            if(test==null){
                System.out.println( "\nParticipant not found.");
                return null;
            }
            if(test.equals(i+"")){
                details ="\nParticipant is located in BreakoutRoom "+i+".";
                return details;
                
            }
        }
     
        System.out.println( "\nParticipant not found.");
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber) //WORKS
    //Opens a breakout room with the supplied room number if it exists
    {
        boolean check;
        check = VR.openBreakoutRoom(roomNumber);
        
        return check;
    }
    
    public boolean closeBreakoutRoom(int roomNumber) //WORKS
    //Closes a breakout room with the supplied room number if it exists
    {
        boolean check;
        check = VR.closeBreakoutRoom(roomNumber);
        
        return check;
    }
}
         
    /*
       
  */
    

