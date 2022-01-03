package out.Jardel_Davis_657684_assignsubmission_file_;
//816017045
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private VirtualRoom virtualRoom;
    private String[] array;

    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    public VirtualMeetingSystem()
    {
        array = new String[50];
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void loadParticipantData(String filename)
    {
        // put your code here
        int i = 0;
        try{
            File data = new File(filename);
            Scanner reader = new Scanner(data);
            while(reader.hasNextLine()){
               array[i] = reader.nextLine();
               i++;
            }
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name){
         virtualRoom = new VirtualRoom(name);
         virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int i=0;
        int roomNumber = 1;
        if(code.equals("C5")){
           while(i < 50){
               if(virtualRoom.addParticipantToBreakoutRoom(array[i],roomNumber)){
                   System.out.println("Participant added\n");
                   i++;
                }else{
                    System.out.println("Fail to add participant\n");
                    i++;
                }
               if((i)%5 == 0){
                   roomNumber++;
                }
               if(roomNumber%6 == 0){
                   roomNumber = 1;
                }
               
               
            }
        }
        
        if(code.equals("RR")){
            while(array[i] !=null){
                if(virtualRoom.addParticipantToBreakoutRoom(array[i], roomNumber)){
                    System.out.println("Participant added\n" + roomNumber);
                    i++;
                    roomNumber++;
                }else{
                    System.out.println("Fail to add participant\n");
                    i++;
                    roomNumber++;
                }
                
                if(roomNumber%6 == 0){
                    roomNumber = 1;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        if(virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber) == true){
            return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber){
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(virtualRoom.openBreakoutRoom(roomNumber) == true){
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(virtualRoom.closeBreakoutRoom(roomNumber) == true){
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return virtualRoom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int i = 1;
        String detail = "";
        while(virtualRoom.findBreakoutRoom(i) != null){
            detail += virtualRoom.findBreakoutRoom(i) + "\n" + 
            virtualRoom.listParticipantsInBreakoutRoom(i) + "______________________________________\n";
            i++;
        }
        return detail;
    }
}
