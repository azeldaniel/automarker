package out.Jordan_Douglas_657781_assignsubmission_file_;
// Name: Jordan Douglas ID: 816022324
import java.io.*; 
import java.util.*;

public class VirtualMeetingSystem
{
    public String [] participants= new String[50];
    int numParticipants=0;
    public VirtualRoom r1;
    public void loadParticipantData (String fileName){
        try{
        File f1= new File(fileName);
        Scanner reader= new Scanner(f1);
        int i =0;
        while(reader.hasNextLine()){
            participants[i]= reader.nextLine(); 
            numParticipants++;
            i++;
        }
        reader.close();
    }
    
    catch(Exception e){
        System.out.println("File not found");
    }
   
    }
    
    public void createVirtualRoom(String name){
        r1= new VirtualRoom(name,5);
        r1.createBreakoutRooms();
        
    }
    
    public void allocateParticipants(String code){
        int count=0;
        
        if(code.equals("C5")){
            
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                 r1.addParticipantToBreakoutRoom(participants[count],i);
                 count++;
                }
            }
        
            
    }
    else if(code.equals("RR")){
        int j= (numParticipants/2)-1;
            
        
            for(int i=0;i<5;i++){
                if(j>=numParticipants){
                    break; 
                }
                r1.addParticipantToBreakoutRoom(participants[count],i);
                r1.addParticipantToBreakoutRoom(participants[j],i);
                j++;
                count++;
            }
        
    }
    }
    public boolean addParticipant(String participantID,int roomNumber){
        roomNumber= roomNumber-1;
        boolean found= r1.addParticipantToBreakoutRoom(participantID,roomNumber);
        if(found==true){
            return true;
        }
        return false; 
    }
    public String listParticipants(int roomNumber){
        String list = r1.listParticipantsInBreakoutRoom(roomNumber);
        return list;
    }
 public boolean closeBreakoutRoom(int roomNumber){
    return r1.closeBreakoutRoom(roomNumber);
}
public boolean openBreakoutRoom(int roomNumber){
    return r1.openBreakoutRoom(roomNumber);
}

public String findParticipantBreakoutRoom(String participantID){
    if(r1.findParticipantBreakoutRoom(participantID)==null){
        System.out.println("Participant was not found");
        return null;
    }
    System.out.println("Participant was found in room "+ r1.findParticipantBreakoutRoom(participantID)+"\n");
    return r1.findParticipantBreakoutRoom(participantID);
    
}
public String listAllBreakoutRooms(){
    return r1.listBreakoutRooms();
}
public String listParticipantsInAllBreakoutRooms(){
    String list= "";
    for(int i =1;i<=5;i++){
        list+= r1.listParticipantsInBreakoutRoom(i);
    }
    return list;
}
}





