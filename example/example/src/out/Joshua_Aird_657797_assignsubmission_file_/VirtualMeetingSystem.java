package out.Joshua_Aird_657797_assignsubmission_file_;
import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException; 
public class VirtualMeetingSystem
{
    
    private String[] PArray= new String [50];
    protected VirtualRoom virtualroom;
    private int num;

  

    
    public void loadParticipantData(String filename){
    try{
        File fil = new File(filename);
       Scanner myReader = new Scanner(fil);
       num=0;
       while(myReader.hasNextLine()){
           String data=myReader.nextLine();
          
           PArray[num]=data;
           
           num++;
           
           
        }
    }catch (FileNotFoundException e) {
        System.out.println("An error occurrred");
        e.printStackTrace();
    }
    System.out.println(num);
}

    public void createVirtualRoom(String name){
        virtualroom=new VirtualRoom(name);
        virtualroom.createBreakoutRooms();
        System.out.println(name);
        
    }
    
    public void allocateParticipants(String code){
        int j=0;
        int incre=5;
        if(code.equals("C5")){
            for(int i=0;i<5;i++){
                while(j<incre){
          virtualroom.addParticipantToBreakoutRoom(PArray[j],i);
          j++;
        }
        incre=incre+5;
        
        }
        for(int i=0;i<5;i++){
                while(j<incre){
          virtualroom.addParticipantToBreakoutRoom(PArray[j],i);
          j++;
        }
        incre=incre+5;
        
        }
        }
        else if(code.equals("RR")){
            int p=0;
         for(int i=0;i<num;i++){
             p=0;
             while(p<5){
                virtualroom.addParticipantToBreakoutRoom(PArray[i],p);
                p++;
            }
        }
        
    }   
    }
    
    public boolean addParticipant(String participantID,int roomNumber){
        return virtualroom.addParticipantToBreakoutRoom(participantID,roomNumber);
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
        String par=" " ;
        for(int i=0;i<5;i++){
         par += virtualroom.listParticipantsInBreakoutRoom(i);
    }
    return par; 
    }
}
