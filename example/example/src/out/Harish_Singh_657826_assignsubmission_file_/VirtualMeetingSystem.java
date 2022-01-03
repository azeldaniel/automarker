package out.Harish_Singh_657826_assignsubmission_file_;//ID#816117713
import java.io.*;
import java.util.Scanner;

public class VirtualMeetingSystem{
    
    private String[] data = new String[50];
    private VirtualRoom vR; 
    private String VrName;
    private int  numP = 0;
    
    public void loadParticipantData(String filename){
        
        try{
        File file = new File(filename);
        Scanner fin = new Scanner(file);
        
        while(fin.hasNextLine()){
            
            data[numP] = fin.nextLine();
            numP = numP + 1;
       }
    }catch(FileNotFoundException e){
        System.out.println("Error");
        e.printStackTrace();
    
    }
    
}
    public void createVirtualRoom(String name){
        vR = new VirtualRoom(name);
        VrName = name;
        for(int i=1;i<=5;i++){
            vR.createBreakoutRooms();
        }
    }
    
    public void allocateParticipants(String code){
        int x = vR.getNumberOfBreakoutRooms();
        int limit = x*10;
        int y= 1;
        if(code == "C5"){
           
            for(int i=0;i<limit;i++){
                if(data[i]!=null){
                    if(vR.addParticipantToBreakoutRoom(data[i],y)==false){
                        y=y+1;
                        vR.addParticipantToBreakoutRoom(data[i],y);
                    }
    
                }
            }
        
    }
        if(code=="RR"){
            
            int roomNum = 1;
            for(int i=0;i<limit;i++){
                if(roomNum==x){
                   vR.addParticipantToBreakoutRoom(data[i],roomNum);
                   roomNum = 1;
                }else{
                    vR.addParticipantToBreakoutRoom(data[i],roomNum);
                    roomNum++;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        return vR.addParticipantToBreakoutRoom(participantID,roomNumber);
    }
    
    public String listParticipants(int roomNumber){
        return vR.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return vR.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return vR.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        int x = vR.getNumberOfBreakoutRooms();
        
        for(int i=1;i<=x;i++){
            String List = vR.listParticipantsInBreakoutRoom(i);
            
            if(List.contains(participantID)==true){
                return VrName + i;
            }
            
        }
            return null;
                                       
    }
    
    public String listAllBreakoutRooms(){
        return vR.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int x = vR.getNumberOfBreakoutRooms();
        String List ="";
        
        for(int i=1;i<=x;i++){
            List+=vR.listParticipantsInBreakoutRoom(i);
        }
        
        return List;
        
        
    } 
    
        
}