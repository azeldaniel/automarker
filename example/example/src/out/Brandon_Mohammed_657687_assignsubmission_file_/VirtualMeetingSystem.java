package out.Brandon_Mohammed_657687_assignsubmission_file_;//816018582
import java.io.*;
public class VirtualMeetingSystem
{
    private VirtualRoom vr;
    private static int numberOfParticipantsFromFile = 0;
    private static int startpoint = 0;
    private static int midpoint = 0;
    private String[] p;
    public VirtualMeetingSystem(){
        
    }
    
    public void loadParticipantData(String filename){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String s;
            numberOfParticipantsFromFile = 0;
            p = new String[100];
            
            while((s = br.readLine()) != null){
                p[numberOfParticipantsFromFile] = s;
                numberOfParticipantsFromFile++;
                //System.out.println(p[numberOfParticipantsFromFile-1]);
            }
            br.close();
        }catch(Exception ex){
            return;
        } 
        System.out.println(numberOfParticipantsFromFile);
    }
    
    public void createVirtualRoom(String name){       
        this.vr = new VirtualRoom(name);
    }
    
    //Can dod round robin by 1, 1+i, etc and can alternate to 1+i, 1
    private void roundRobin(){
        boolean added = false;
        int roomNumber = 100;
        
        
        while (startpoint <numberOfParticipantsFromFile){
            for(int i = 0; i < vr.getBreakoutRoomLimit(); i++){
                if (vr.findBreakoutRoom(roomNumber) != null){
                    while(added == false && startpoint < numberOfParticipantsFromFile){//ensures that a particiapnt is allocated and that there are to allocate
                        added = vr.addParticipantToBreakoutRoom(p[startpoint], roomNumber);//attemps to add the participant
                        startpoint++;
                    }
                    
                    added = false;
                    
                    while(added == false && midpoint < numberOfParticipantsFromFile && startpoint != midpoint){//ensures that a particiapnt is allocated and that there are to allocate
                        added = vr.addParticipantToBreakoutRoom(p[midpoint], roomNumber);//attemps to add the participant
                        startpoint++;
                    }
                    
                    roomNumber++;
                }
            }
        }
    }
    
    private void C5(){
        boolean added = false;
        int roomNumber = 100;
        for(int i = 0; i < vr.getBreakoutRoomLimit(); i++){//loops through the breakout rooms
            if(startpoint < numberOfParticipantsFromFile){//ensures that there are participants to allocate
                if (vr.findBreakoutRoom(roomNumber) != null){//ensures that the breakout room exists
                    for(int j=0; j < 5;j++){//ensures 5 participants are allocated                        
                        while(added == false && startpoint < numberOfParticipantsFromFile){//ensures that a particiapnt is allocated and that there are to allocate
                            added = vr.addParticipantToBreakoutRoom(p[startpoint], roomNumber);//attemps to add the participant
                            startpoint++;
                        }
                        added = false;
                    }
                }
                added = false;//ensures that another participant can be added
                roomNumber = roomNumber + 100;//goes to the next breakout room
            }
        }
    }
    
    public void allocateParticipants(String code){
        //create breakout room    
        vr.createBreakoutRooms();
        //add participants
        if(code.equals("C5")){//checks the code
            C5();
        }else if (code.equals("RR")){
            roundRobin();
        }
        
    }
    
    public boolean addParticipant(String participantID,int roomNumber){
        
        boolean added = false;
        
        if (vr.findBreakoutRoom(roomNumber) == null){
            System.out.println("The room does not exist.\n");
        }else{
            added = vr.addParticipantToBreakoutRoom(participantID, roomNumber);
            if(added == false){
                System.out.println("The ID supplied is not valid.\n");
            }else{
                return true;
            }
        }
        
        return false;
    }
    
    public String listParticipants(int roomNumber){
        if(vr.findBreakoutRoom(roomNumber)!= null){
            return vr.listParticipantInBreakoutRoom(roomNumber);
        }
        
        return "That room does not exist";
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(vr.findBreakoutRoom(roomNumber)!= null){
            vr.openBreakoutRoom(roomNumber);
            return true;
        }
        
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(vr.findBreakoutRoom(roomNumber)!= null){
            vr.closeBreakoutRoom(roomNumber);
            return true;
        }
        
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        if(vr.findParticiapntBreakoutRoom(participantID)!= null){
           return vr.findParticiapntBreakoutRoom(participantID);
        }
        return null;
    }
    
    public String listAllBreakoutRooms(){
        return vr.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        
        String list = new String();
        int roomNumber = 100;
        for(int i = 0; i < vr.getBreakoutRoomLimit(); i++){
            list += vr.listParticipantInBreakoutRoom(roomNumber)+ "\n";
            roomNumber = roomNumber + 100;
        }
        
        if (list != null){
            return list;
        }
        return null;
    }
}
