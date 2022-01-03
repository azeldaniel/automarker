package out.Daniel_Yorke_657808_assignsubmission_file_;/**
 * 816019400
 */
import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;
public class VirtualMeetingSystem{
    private String data[] = new String [1000];
    private int sizeOfData;
    private VirtualRoom v;
    public void loadParticipantData(String filename){
        try{
            sizeOfData = 0;
            File fr = new File(filename);
            Scanner fileReader = new Scanner(fr);
            while(fileReader.hasNextLine()){
                data[sizeOfData] = fileReader.nextLine();
                //System.out.println(data[sizeOfData]);
                sizeOfData++;
                //System.out.println(data);
                //System.out.println("sizeOfData ==" +sizeOfData);
                
            }
            //System.out.println("File read");
            //System.out.println(data[0]);
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    public void createVirtualRoom(String name){
      v = new VirtualRoom(name);
        
    }
    public void allocateParticipants(String code ){
        int i=0;
        int counter = 0;
        int room = 0;
        for(int y=0;y<5;y++){
            v.openBreakoutRoom(y);
        }
        //System.out.println("Code ==" +code);
        if(code.equals("C5")){
            //System.out.println("Code ==" +code);
            //System.out.println("sizeOfData ==" +sizeOfData);
            while(i<sizeOfData){
                //System.out.println("Test whitle");
                if(counter == 5){
                    counter = 0;
                    room++;
                }
                if(room == 5){
                    room = 0;
                }
                //v.openBreakoutRoom(room);
                //System.out.println("Adding p C5 -- VMS");
                v.addParticipantToBreakoutRoom(data[i],room);
                //System.out.println("Counter : "+ counter);
                counter++;
                //System.out.println("Counter : "+ counter);
                i++;
            }
        }
        if(code.equals("RR")){
            while(i<sizeOfData){
                if(room==5){
                room=0;
                //System.out.println("IFsadnasndasnoaisoi");
            }
            //v.openBreakoutRoom(room);
            //System.out.println("Adding p RR -- VMS");
            v.addParticipantToBreakoutRoom(data[i],room);
            i++;
            room++;
            }
        }
    }
    public boolean addParticipant(String participantID,int roomNumber){
      return v.addParticipantToBreakoutRoom(participantID,roomNumber);
    }
    public String listParticipants(int roomNumber){
      return v.listParticipantsInBreakoutRoom(roomNumber);
    }
    public boolean openBreakoutRoom(int roomNumber){
      return openBreakoutRoom(roomNumber);
    }
    public boolean closeBreakoutRoom(int roomNumber){
      return closeBreakoutRoom(roomNumber);
    }
    public String findParticipantBreakoutRoom(String participantID){
      return findParticipantBreakoutRoom(participantID);
    } 
    public String listAllBreakoutRooms( ){
        return v.listBreakoutRooms( );
    }
    public String listParticipantsInAllBreakoutRooms(){
        String format = new String();
        format = "";
        for(int i=0;i<5;i++){
            format = String.format("%s%s",format,v.listParticipantsInBreakoutRoom(i));
            format = format + "\n";
        }
        return format;
    }
}
