package out.Kemeisha_Wilson_657772_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner;
/**
 * @author (Kemeisha Wilson 816020815)
 * @version (03/02/2021)
 */
public class VirtualMeetingSystem
{
    private static String name;
    private boolean open;
    private int bRoomlimit;
    private int count;
    private String participantID[];
    VirtualRoom virtualRoom;
    public VirtualMeetingSystem()
    {
        bRoomlimit=0;
        name=null;
        participantID=new String[50];
        open=false;
        count=0;
    }
    public void loadParticipantData(String filename)
    {
        try{
            File file= new File(filename);
            Scanner keys= new Scanner(file);
            while(keys.hasNextLine())
            {
                String data= keys.nextLine();
                participantID[count]=data;
                count++;
                }
            keys.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File was not found.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name){
        virtualRoom= new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
    }

    public void allocateParticipants(String code){
        int check=count;
        int limit=5,start=0;
        boolean added=false;
        if(code.equals("C5")){
            virtualRoom= new VirtualRoom("Workshop");
            virtualRoom.createBreakoutRooms();
            for(int x=0;x<limit;x++){
                open=virtualRoom.openBreakoutRoom(x);
                for(int i=start;i<check;i++) {
                    added=virtualRoom.addParticipantToBreakoutRoom(participantID[i],x);
                    count++;
                    if (count == 5) {
                        count = 0;
                        break;
                    }
                }
                start+=10;
            }
        }
        else if(code.equals("RR")){
            start=0;
            limit=check/10;
            virtualRoom= new VirtualRoom("Workshop",10);
            virtualRoom.createBreakoutRooms();
            for(int x=0;x<10;x++){
                open=virtualRoom.openBreakoutRoom(x);
                for(int i=start;i<limit;i++){
                    added=virtualRoom.addParticipantToBreakoutRoom(participantID[i],x);
                }
                if(added==false){
                    System.out.println("Room not found");
                }
                start+=5;
                limit+=5;
            }
        }
    }
    public boolean addParticipant(String participantID, int roomNumber){
        boolean added=false;
        added=virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber);
        if(added==false){
            System.out.println("Room not found");
        }
        return added;
    }

    public String listParticipants(int roomNumber){
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }

    public boolean openBreakoutRoom(int roomNumber){
        return virtualRoom.openBreakoutRoom(roomNumber);
    }

    public boolean closeBreakoutRoom(int roomNumber){
        return virtualRoom.closeBreakoutRoom(roomNumber);
    }

    public String findParticipantBreakoutRoom(String participantID){
        if(virtualRoom==null){
            System.out.println("Virtual Room not created");
            return null;
        }
        String s=virtualRoom.findParticipantBreakoutRoom(participantID);
        if(s==null)
            System.out.println("Participant not found");
        return s;
    }

    public String listAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }
    public String listParticipantsInAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }

}
