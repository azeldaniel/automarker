package out.Shane_Beharry_657758_assignsubmission_file_;//Shane Beharry
//816023033
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    String[] parData = new String[50];
    VirtualRoom vRoom;
    int dataCount = 0;
    
    public void loadParticipantData(String filename){
        try{
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                parData[dataCount] = data;
                //System.out.println(parData[dataCount]);
                dataCount++;
            }
            myReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error occured in reading file. :(");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name){
        vRoom = new VirtualRoom(name, 5);
        vRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        if(code == "C5"){
            //vRoom.addParticipantToBreakoutRoom("12344567",0);
            int i=0, j=0;
            for(int p=0; p<(dataCount/(vRoom.getNumberOfBreakoutRooms() * 5)); p++){
                for(i=0; i<vRoom.getNumberOfBreakoutRooms(); i++){
                    for(int k=0; k<5; k++){
                        vRoom.addParticipantToBreakoutRoom(parData[j], i);
                        j++;
                    }
                }
            }
        }
        else if(code=="RR"){
            int j=0;
            for(int i=0; i<(dataCount/vRoom.getNumberOfBreakoutRooms()); i++){
                for(int k=0; k<vRoom.getNumberOfBreakoutRooms(); k++){
                    vRoom.addParticipantToBreakoutRoom(parData[j], k);
                    j++;
                }
            }
        }
        else{
            System.out.println("Wrong code");
        }
    }
    
    public String listParticipants(int roomNumber){
        String x = vRoom.listParticipantsInBreakoutRoom(roomNumber);
        
        if(x == null){
            return null;
        }
        else{
            return x;
        }
        
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        if((vRoom.findBreakoutRoom(roomNumber)) == null){
            return false;
        }
        else{
            vRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            return true;
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean check = vRoom.openBreakoutRoom(roomNumber);
        if(check ==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean check = vRoom.closeBreakoutRoom(roomNumber);
        if(check ==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String x = vRoom.findParticipantBreakoutRoom(participantID);
        return x;
        
    }
    
    public String listAllBreakoutRooms(){
        return vRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String x = "";
        
        for(int i=0; i<vRoom.getNumberOfBreakoutRooms(); i++){
            x+=vRoom.listParticipantsInBreakoutRoom(i);
            x+="\n";
        }
        return x;
    }
}







