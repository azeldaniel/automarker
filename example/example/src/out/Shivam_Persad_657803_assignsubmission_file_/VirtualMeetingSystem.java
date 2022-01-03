package out.Shivam_Persad_657803_assignsubmission_file_;
/** COMP2603 Assignment1
 *  Name: Shivam Persad
 *  ID: 816016854
 */

import java.io.File;
import java.util.Scanner;
import java.io.*;


public class VirtualMeetingSystem
{
    public String[] ID;
    public void loadParticipantData(String filename){
        Scanner file=null;
        try{
            file=new Scanner(new File(filename));
        }catch(IOException e){
            System.out.println("[CONSOLE]:ERROR FILE NOT FOUND");
        }
        if(file==null) return;
        
        int count=0;
        this.ID=new String[100];
        while(file.hasNext()){
            this.ID[count]=file.next();
            count++;
        }
    }
    
    VirtualRoom VRoom;
    public void createVirtualRoom(String name){
        this.VRoom = new VirtualRoom(name);
        this.VRoom.createBreakoutRooms();
        for(int i=1;i<=this.VRoom.getNumberOfBreakoutRooms();i++){
            this.VRoom.openBreakoutRoom(i);
        }
    }
    
    public void allocateParticipants(String code){
        int y=1,x=1;
        if(code.equals("C5")){
           x=5; 
        }
        for(int i=0;i<this.ID.length;i++){
            this.VRoom.addParticipantToBreakoutRoom(this.ID[i],y);
            if(i%x==0) y++;
            if(i%x==0&&x==5) y--;
            if(y>this.VRoom.getNumberOfBreakoutRooms()) y=1;
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        if(this.VRoom.addParticipantToBreakoutRoom(participantID,roomNumber)){
            return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber){
        return (this.VRoom.listParticipantsInBreakoutRoom(roomNumber));
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean state=this.VRoom.openBreakoutRoom(roomNumber);
        return state;
    }
    public boolean closeBreakoutRoom(int roomNumber){
        boolean state=this.VRoom.closeBreakoutRoom(roomNumber);
        return state;
    }
    public String findParticipantBreakoutRoom(String participantID){
        return this.VRoom.findParticipantBreakoutRoom(participantID);
    }
    public String listAllBreakoutRooms(){
        return this.VRoom.listBreakoutRooms();
    }
    public String listParticipantsInAllBreakoutRooms(){
        String output="All Participants:\n";
        int limit=5;
        for(int i=1;i<=limit;i++){
            output+=this.VRoom.listParticipantsInBreakoutRoom(i);
        }
        return output;
    }
}
