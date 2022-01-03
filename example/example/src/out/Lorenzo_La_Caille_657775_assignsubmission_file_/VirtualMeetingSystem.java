package out.Lorenzo_La_Caille_657775_assignsubmission_file_;//816015560
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class VirtualMeetingSystem
{
    private VirtualRoom virtualRoom;
    private String[] participantId=new String[100];

    
    public VirtualMeetingSystem()
    {
  
       
    }

   
    public void loadParticipantData(String filename)
    {
        
        int i=0;
        try{
            File fileName = new File(filename);
            Scanner fileRead =new Scanner(fileName);
            
            while(fileRead.hasNextLine()){
                
                participantId[i]=fileRead.nextLine();
                System.out.println(participantId[i]);
                i++;
            }
            fileRead.close();
        }catch(FileNotFoundException e){
            System.out.println("There was an error that has occured.");
            e.printStackTrace();
        }
        
    }
    
    public void createVirtualRoom(String name){
            VirtualRoom virtualRoom=new VirtualRoom(name);
            virtualRoom.createBreakoutRooms();
            
        }
        
    public void allocateParticipants(String code){
        if(code.equals("C5")){
            int j=1;
            int count=0;
            for(int i=0;i<participantId.length;i++){
                if(count==5){
                    j++;
                    count=0;
                }
                virtualRoom.addParticipantBreakoutRoom(participantId[i],j);
                count++;
            }
        }
        if(code.equals("RR")){
            int j=1;
            for(int i=0;i<participantId.length;i++){
                if(j==6){
                    j=1;
                }
                virtualRoom.addParticipantBreakoutRoom(participantId[i],j);
                j++;
            }
        }
    }
    
    public boolean addParticipant(String participantID,int roomNumber){
        String list;
        list=virtualRoom.listParticipantInBreakoutRoom(roomNumber);
        if(list==null){
            return false;
        }
        virtualRoom.addParticipantBreakoutRoom(participantID,roomNumber);
        return true;
    }
    
    public String listParticipants(int roomNumber){
        String list;
        list=virtualRoom.listParticipantInBreakoutRoom(roomNumber);
        if(list==null){
            return null;
        }
        else{
            return list;
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        
        boolean test=virtualRoom.openBreakoutRoom(roomNumber);
        if(test==true){
            return true;
        }else {
                return false;
        }
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        
        boolean test=virtualRoom.closeBreakoutRoom(roomNumber);
        if(test==true){
            return true;
        }else {
                return false;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String list=virtualRoom.findParticipantBreakoutRoom(participantID);
        return list;
    }
    
    public String listAllBreakoutRooms(){
        String list=virtualRoom.listBreakoutRooms();
        return list;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String list="";
        for(int i=0;i<5;i++){
            list=list+virtualRoom.listParticipantInBreakoutRoom(i);
        }
        return list;
    }
}


