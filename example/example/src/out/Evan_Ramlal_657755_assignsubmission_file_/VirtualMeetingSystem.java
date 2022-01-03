package out.Evan_Ramlal_657755_assignsubmission_file_;import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 *Evan Ramlal
 *813117763
 */
public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private String name;
    private VirtualRoom virtualRoom;
    private String[] people = new String[50];
    private int FileSize = 0;

    public String[] getPeople(){
        return people;
    }
    
    public int getFileSize(){
        return this.FileSize;
    }
    
    public VirtualRoom getVirtualRoom(){
        return this.virtualRoom;
    }

    public void loadParticipantData(String filename){
        try{ 
            int i = 0;
            File f1 = new File(filename);
            Scanner myReader = new Scanner(f1);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println("Participant: " + data + " loaded onto array!");
                people[i] = data;
                this.FileSize = i;
                i++;
            }
            myReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name){
        VirtualRoom virtualRoom = new VirtualRoom(this.name);
        virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int i = 1;
        int j = 1;
        
        if(code.equals("C5")){
            while(i < this.FileSize){
                if(j == 6){
                    j = 1;
                }
                for(int k = 1; k <= 5; k++){
                    this.virtualRoom.addParticipantToBreakoutRoom(this.people[i], j);
                    i++;
                    if(i == this.FileSize){
                        break;
                    }
                }
                j++;
            }
        }
        
        if(code.equals("RR")){
            for(int k = 1; k <= this.FileSize; k++){
                this.virtualRoom.addParticipantToBreakoutRoom(this.people[k], j);
                j++;
                if(j == 6){
                    j = 1;
                }
            }
        }

    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        VirtualRoom vr = new VirtualRoom(this.name);
        if(vr.addParticipantToBreakoutRoom(participantID, roomNumber)){
            return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber){
        VirtualRoom vr = new VirtualRoom(this.name);
        return vr.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        VirtualRoom vr = new VirtualRoom(this.name);
        if(vr.openBreakoutRoom(roomNumber)){
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        VirtualRoom vr = new VirtualRoom(this.name);
        if(vr.closeBreakoutRoom(roomNumber)){
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        VirtualRoom vr = new VirtualRoom(this.name);
        return vr.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        VirtualRoom vr = new VirtualRoom(this.name);
        return vr.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        VirtualRoom vr = new VirtualRoom(this.name);
        for(int i = 1; i <= vr.getNumberOfBreakoutRooms(); i++){
            return vr.listParticipantsInBreakoutRoom(i);
        }
        return " ";
    }
    
    
    public static void tester(){
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        VirtualRoom vr = new VirtualRoom("COMP");
        vms.loadParticipantData("participant.dat");
        
        
    }
    
    public static void main(String[] args){
        //tester();
    }
    
}
