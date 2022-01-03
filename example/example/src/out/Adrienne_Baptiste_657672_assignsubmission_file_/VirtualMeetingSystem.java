package out.Adrienne_Baptiste_657672_assignsubmission_file_;/**
 ID:816020784     Reference-> https://www.w3schools.com/ was used as reference for code to read file and to declare and traverse linked lists
 */
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.LinkedList;

public class VirtualMeetingSystem{
    VirtualRoom v;
    LinkedList<String> dataList = new LinkedList<String>();
    public void loadParticipantData(String filename){
            System.out.println("Start");
            try{
                File f = new File(filename);
                Scanner fileReader = new Scanner(f);
                int count=-1;
                while (fileReader.hasNextLine()) {
                        String pData = fileReader.nextLine();
                        dataList.add(pData);
                        count++;
                        System.out.println(dataList.get(count));
                }
                fileReader.close();
            } 
            catch (FileNotFoundException e) {
                System.out.println("ERROR!");
                e.printStackTrace();
            }
    }
    
    public void createVirtualRoom(String name){
        v= new VirtualRoom(name);
        v.createBreakoutRooms();
        
    }
    
    public void allocateParticipants(String code) {
        String data;
        boolean wasAdded;
        if(code=="C5"){
           for (int i = 0; i < dataList.size(); i=i+5) {
                for(int j=1; j<=v.getNumberOfBreakoutRooms();j++){
                    for(int k=i; k<i+5; k++){
                        data=dataList.get(k);
                        if(addParticipant (data,j)==true)
                            System.out.println("ID: "+ data + "ADDED to Room" + j);
                        else
                            System.out.println("ID: "+ data + "NOT ADDED to Room" + j);
 
                    }
                }
           }
          }
          if (code=="RR"){
            int j=1;
            for (int i = 0; i < dataList.size(); i++) {
                if(j>v.getNumberOfBreakoutRooms())
                    j=1;
                data=dataList.get(i);
                if(addParticipant (data,j)==true)
                   System.out.println("ID: "+ data + "ADDED to Room" + j);
                   else
                   System.out.println("ID: "+ data + "NOT ADDED to Room" + j);
                j++;
            }
            
          }
    }
    
    public boolean addParticipant (String participantID,int roomNumber){
        return v.addParticipantToBreakoutRoom(participantID,roomNumber);
         
    }
    
    public String listParticipants(int roomNumber){
        return v.listParticipantInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return v.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber) {
        return v.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID) {
     return v.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        return v.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms() {
        String outputString="All Participants\n" ;
        int curr, length=v.breakoutRoomLimit;
        for(curr=1; curr<=length;curr++){
            outputString= "\n "+ v.listParticipantInBreakoutRoom(curr);
        }
        return outputString; 
    
    }
    
}