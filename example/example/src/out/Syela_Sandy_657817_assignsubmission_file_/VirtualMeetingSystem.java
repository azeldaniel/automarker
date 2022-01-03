package out.Syela_Sandy_657817_assignsubmission_file_;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @Student ID: 816020390
 * @version (a version number or a date)
 */
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;

public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private VirtualRoom virtualroom;
    public String[] array = new String[50];


    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    public VirtualMeetingSystem()
    {
      
    }
    
    public void loadParticipantData(String filename){

                      int i=0;
                      try {

                        File file = new File(filename);
                        Scanner scan = new Scanner(file);
                        while (scan.hasNextLine()) {
                          String data = scan.nextLine();
                          array[i] = data;
                          i++;
                        }
                        scan.close();
                      } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                      }
           
    }
    
    
    public void createVirtualRoom(String name){
    
         virtualroom = new VirtualRoom(name);
         virtualroom.createBreakoutRooms();
    
    }
    
    public void allocateParticipants(String code){ 
                    
           if(code.equals("C5")){
                     
                      int x = 5;
                      String y = "";
                      int k = 0;
                  
                      for(int i=0; i < virtualroom.getbreakoutRoomLimit(); i++){
                          
                        openBreakoutRoom(i);
                       for(int j=0; j < 10; j++){
                         
                           if(i == x){
                               
                              x = x + 5;
                              //breaking the loop
                              break;
                           }
    
                          y = array[k];
                          //virtualroom.getbreakoutRooms(i).getParticipant(j).addParticipant(y);
                          virtualroom.getbreakoutRooms(i).addParticipant(y);
                          k++;
                          
                          //Arrays.copyOfRange(array, x, y);
                       }
                      }
                  }
                  else{ 
                        System.out.println("This is an invalid code");
                  }
     
                             
    }
    
    public boolean addParticipant(String participantID, int roomNumber){

       return virtualroom.addParticipantToBreakoutRoom(participantID, roomNumber);

    }
    
    public String listParticipants(int roomNumber){
  
        return virtualroom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){

        return virtualroom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){

        return virtualroom.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID){

        return virtualroom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){

        return virtualroom.listBreakoutRooms();

    }
    
    public String listParticipantsInAllBreakoutRooms(){

        return virtualroom.ParticipantsInAllBreakoutRooms();

    }
    
  
}
