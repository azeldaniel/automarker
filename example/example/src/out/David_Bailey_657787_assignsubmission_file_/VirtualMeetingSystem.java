package out.David_Bailey_657787_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;
public class VirtualMeetingSystem{
    VirtualRoom vr1;
    private String[] dataArr;
    public void loadParticipantData(String filename){//this method was sourced from https://www.w3schools.com/java/java_files_read.asp
        dataArr = new String[50];
        int i = 0;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                dataArr[i] = myReader.nextLine();
                //System.out.println(dataArr[i]);
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public  void createVirtualRoom(String name){
        this.vr1 = new VirtualRoom(name);
        vr1.createBreakoutRooms(); 
    }
    
    public void allocateParticipants(String code){
       boolean isAdded;
       int roomNumber = 1;
       int sIndex,eIndex;
       if(code.equals("C5")){
           for(int k = 0; k < dataArr.length; k++){
               if(k%5 == 0){
                   sIndex = k;
                   eIndex = k + 5;
                   for(int i = sIndex; i < eIndex; i++){
                       isAdded = vr1.addParticipantToBreakoutRoom(dataArr[i],roomNumber);
                    }
                    roomNumber++;
                    //resets roomNumber
                    if( roomNumber > 5){
                        roomNumber = 1;
                    }
                
                }   
            }
        }
       else if(code.equals("RR")){
           for(int k = 0; k < dataArr.length; k++){
               isAdded = vr1.addParticipantToBreakoutRoom(dataArr[k],roomNumber);
               roomNumber++;
                    if( roomNumber > 5){
                        roomNumber = 1;
                    }
            }
        }
    }
    public void listBreakoutRooms(){
        System.out.println(vr1.listParticipantsInBreakoutRoom(1));
    }
    public boolean addParticipant(String participantID, int roomNumber){
        boolean added;
        added = vr1.addParticipantToBreakoutRoom(participantID, roomNumber);
        return added;
    }
    
    public String listParticipants(int roomNumber){
        return vr1.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean isOpen = vr1.openBreakoutRoom(roomNumber);
        return isOpen;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean isClose = vr1.closeBreakoutRoom(roomNumber);
        return isClose;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String room = vr1.findParticipantBreakoutRoom(participantID);
        return room;
    }
    
    public String listAllBreakoutRooms(){
        return vr1.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String list = new String();
        String listedPart;
        for(int i = 1; i <= 5 ; i++){
            listedPart = vr1.listParticipantsInBreakoutRoom(i);
            list += listedPart;
    }
    return list;
    }
}

