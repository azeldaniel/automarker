package out.Micah_Thomas_657795_assignsubmission_file_;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem{
    private static String filename="participant.dat";
    //private String name;
    //private String code;
    //private String participantID;
    //private int roomNumber;
 
    public VirtualMeetingSystem()
    {
        // initialise instance variables
        
    }

    public void loadParticipantData(String filename){
        String[] arr= new String[50];
        int i=0;
        try{
            File myObj=new File(filename);
            Scanner myReader=new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data=myReader.nextLine();
                arr[i]=data;
                i++;
                System.out.println(data);
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.println(arr[0]);
    }
    
    public void createVirtualRoom(String name){
        VirtualRoom virtualRoom= new VirtualRoom(name);   
        virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        VirtualRoom virtualRoom= new VirtualRoom("Workshop");
        String name;
        if(code.equals("C5")){
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    name = "Workshop"+String.valueOf(i); 
                    virtualRoom.getaddParticipantToBreakoutRoom(name, i);
                }
            }
        }
        if(code.equals("RR")){
            for(int i=0; i<5; i++){
                for(int j=0; j<2; j++){
                    name = "Workshop"+String.valueOf(i); 
                    virtualRoom.getaddParticipantToBreakoutRoom(name, i);
                }
            }
        }else{
            System.out.println("An error occurred.");
        }        
    }
    
    public boolean addParticipant (String participantID, int roomNumber){
        VirtualRoom virtualRoom= new VirtualRoom("Workshop");
        return virtualRoom.getaddParticipantToBreakoutRoom(participantID, roomNumber);
    } 
    
    public String listParticipants(int roomNumber){
        VirtualRoom virtualRoom= new VirtualRoom("Workshop");
        return virtualRoom.getListParticipants(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        VirtualRoom virtualRoom= new VirtualRoom("Workshop");
        return virtualRoom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        VirtualRoom virtualRoom= new VirtualRoom("Workshop");
        return virtualRoom.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        VirtualRoom virtualRoom= new VirtualRoom("Workshop");
        return virtualRoom.getFindParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        VirtualRoom virtualRoom= new VirtualRoom("Workshop");
        return virtualRoom.getListBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        VirtualRoom virtualRoom= new VirtualRoom("Workshop");
        String list=null;
        for(int i=0; i<5; i++){
            list= list.concat(listParticipants(i));
        }
        return list;
    }
}
