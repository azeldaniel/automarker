package out.Brandon_Bissoon_657753_assignsubmission_file_;import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
/**
 * Write a description of class VirutalMeetingSystem here.
 *
 *Student ID :- 816022435
 *Student Name :- Brandon Bissoon 
 */
public class VirtualMeetingSystem
{
   //initiliazing vairables
   VirtualRoom virtualRoom;
   public String[] partData = new String[50];
   public int partamt = 0;
   
   
   /*
    * Learnt the file reading formula from w3schools site
    * Link :- https://www.w3schools.com/java/java_files_read.asp
    * The orignal code from the site has been slightly altered in order
    * for it to be used from the main;
      */
   public void loadParticipantData(String filename){
       try{
                File myObj = new File(filename);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()){
                    partData[partamt] = myReader.nextLine();
                    partamt = partamt + 1;
                }
                myReader.close();
            } catch (FileNotFoundException e){
                System.out.println("This File Cannot Be Found.");
                e.printStackTrace();
       } 
    }
   
   /*
    * Creates a virtual room with the supplied name,
    * containing 5 breakout rooms
      */
   public void createVirtualRoom(String name){
       virtualRoom = new VirtualRoom(name);
    }
    
   /*
    * Allocates participants to the breakout rooms of a 
    * virtual room using a strategy determined by the 
    * supplied code�
      */ 
   public void allocateParticipants(String code){
    virtualRoom.createBreakoutRooms(); 
        
    //initiliazing vairables
    //this is use to kep count of the participants
    int participantcount;
    //this is used to keep count of the amt of participants
    int participantamt;  
    //this is used to keep count of the room
    int roomcount; 
    //this is used to kep count of the clusters/groups of participantsID
    int group;  
    //keeps count of the number of breakoutrooms
    int amountofbreakoutrooms;   
        
    participantcount = 0;
    participantamt = 0;
    roomcount = 1;
    group = 0;
       
    //This is used to return the number of breakout rooms
    amountofbreakoutrooms = virtualRoom.getNumberOfBreakoutRooms();
        
    if (code == "C5"){
       while (participantcount < partamt ){
           if (group == 5 ){
               group = 0;
               roomcount = roomcount + 1;
           }
                
           if(roomcount > amountofbreakoutrooms){
              roomcount = 1;
           }
            
           virtualRoom.addParticipantToBreakoutRoom(partData[participantcount],roomcount);
           participantcount = participantcount + 1;
           group = group +1;
                                
       }            
       }
       else{
            System.out.println(" There Is An Error ");
        }        
    }
    
    /*
     * Adds a new participant to the breakout room with
     * the supplied room number if it exists�
       */
    public boolean addParticipant(String participantID,int roomNumber){
        if(virtualRoom.findBreakoutRoom(roomNumber) != null){
            virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber);
            return true;
        }
        else{
            return false;
        }
    }
    
    /*
     * Returns a list of the participants in the breakout
     * room with the supplied room number if found,
     * otherwise returns null�
       */
    public String listParticipants(int roomNumber){
        if(virtualRoom.findBreakoutRoom(roomNumber) != null){
            return (virtualRoom.listParticipantsInBreakoutRoom(roomNumber));            
        }
        else{
            return null;
        }
    }
    
    /*
     *Opens a breakout room with the supplied room
     *number if it exists� 
       */
    public boolean openBreakoutRoom(int roomNumber){
        if(virtualRoom.findBreakoutRoom(roomNumber) != null){
            return (virtualRoom.openBreakoutRoom(roomNumber));            
        }
        else{
            return false;
        }
    }
    
    /*
     * Closes a breakout room with the supplied room
     * number if it exists�
       */
      public boolean closeBreakoutRoom(int roomNumber){
        if(virtualRoom.findBreakoutRoom(roomNumber) != null){
            return (virtualRoom.openBreakoutRoom(roomNumber));            
        }
        else{
            return false;
        }
    }
    
    /*
     * Locates and returns the breakoutRoomID for the
     * breakout room hosting the participant with the
     * (valid) supplied ID, otherwise returns null�
       */
    public String findParticipantBreakoutRoom(String participantID){
        return (virtualRoom.findParticipantBreakoutRoom(participantID));
    }  
    
    /*
     * Returns a list of the breakout rooms managed by
     * the virtual room�
       */
    public String listAllBreakoutRooms(){
        return (virtualRoom.listBreakoutRooms());
    }
   
    /*
     * Returns a list of all of the participants per breakout
     * room managed by the virtual room, otherwise
     * returns null�
       */
    public String listParticipantsInAllBreakoutRooms()
    {
       int count;
       int amountofbreakoutrooms;
       String phrase = "";
        
       amountofbreakoutrooms = virtualRoom.getNumberOfBreakoutRooms();
       
       for(count = 1; count <= amountofbreakoutrooms; count = count + 1){
            phrase = phrase + virtualRoom.listParticipantsInBreakoutRoom(count) + "\n";
        }
       return phrase;
    }   
}
