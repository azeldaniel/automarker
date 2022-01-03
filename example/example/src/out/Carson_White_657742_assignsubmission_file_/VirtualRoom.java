package out.Carson_White_657742_assignsubmission_file_;//816020150
import java.util.Scanner;
public class VirtualRoom{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name,int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms(){
        int count = 0;
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i] != null){
                count++;
            }
        }
        return count;
    }
    
    public void createBreakoutRooms(){
        Scanner input = new Scanner(System.in);
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i] == null){
               System.out.println("Please enter the name of the Breakout Room: ");
               String name = input.nextLine(); 
               breakoutRooms[i] = new BreakoutRoom(name);
               return;
            }
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(roomNumber<=breakoutRoomLimit && roomNumber>(-1)){
            return breakoutRooms[roomNumber - 1];
        }else{
            return null;
        }
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(roomNumber>=breakoutRoomLimit){
            return  false;
        }
        if(breakoutRooms[roomNumber]!=null){
            breakoutRooms[roomNumber].closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(roomNumber>=breakoutRoomLimit){
            return  false;
        }
        if(breakoutRooms[roomNumber]!=null){
            breakoutRooms[roomNumber].openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String output = name + "\n";
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i]==null){
                break;
            }
             output += breakoutRooms[i].toString() + "\n";
        }
        return output;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber]!=null){
            return breakoutRooms[roomNumber].listParticipants();
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        if(breakoutRooms[roomNumber]!=null){
            if(breakoutRooms[roomNumber].addParticipant(participantID)==true){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        for(int i=0;i<breakoutRoomLimit;i++){
            if(breakoutRooms[i]!=null){
            try{String Temp=breakoutRooms[i].findParticipant(participantID).getParticipantID();
                if(participantID.equals(Temp) && Temp!=null){
                    return breakoutRooms[i].toString();
                }
            }catch(Exception e){
            }
            }
        }
        return null;
    }
}