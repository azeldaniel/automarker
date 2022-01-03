package out.Carson_White_657742_assignsubmission_file_;//816020150
import java.io.*;
import java.util.Scanner;
public class VirtualMeetingSystem{
    private String [] data;
    private VirtualRoom virtualRoom;
    private int size;
    public void loadParticipantData(String filename){
            try{
                File myfile = new File(filename);
                Scanner tempFile = new Scanner(myfile);
                int i=0;
                
                    while(tempFile.hasNextLine()){
                        tempFile.nextLine();
                        size++;
                    
                }
                data = new String[size];
                tempFile.close();
                myfile = new File(filename);
                tempFile = new Scanner(myfile);
                while(tempFile.hasNextLine()){
                    data[i]=tempFile.nextLine();
                    
                    i++;
                }
                tempFile.close();
              }catch(FileNotFoundException excep){
                    System.out.println("An error occurred.");
                    excep.printStackTrace();
          }
    }

   
    public void createVirtualRoom(String name){
        virtualRoom = new VirtualRoom(name);
        for(int i=0;i<5;i++){
            virtualRoom.createBreakoutRooms();
        }
    }
    
    public void allocateParticipants(String Code){
        if(Code.equals("RR") || Code.equals("C5")){
            int i=0;
            if(Code.equals("C5")){
               while(i!=size){
                   for(int j=0;j<5;j++){
                       for(int n=0;n<5;n++){
                           virtualRoom.addParticipantToBreakoutRoom(data[i],j);
                           i++;
                        }
                    }
               }
            }else{
                while(i!=size){
                   for(int j=0;j<5;j++){
                       virtualRoom.addParticipantToBreakoutRoom(data[i],j);
                       i++;
                    }
               }
            }
        }else{
            System.out.println("Invalid Code");
        }
    }
    
    public boolean addParticipant (String participantID, int roomNumber){
        return virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber-1);
    }
    
    public String listParticipants(int roomNumber){
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber-1);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return virtualRoom.openBreakoutRoom(roomNumber-1);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return virtualRoom.closeBreakoutRoom(roomNumber-1);
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return virtualRoom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
            return virtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String output="";
        for(int i=0;i<5;i++){
            output+=virtualRoom.listParticipantsInBreakoutRoom(i);
        }
        return output;
    }
}
