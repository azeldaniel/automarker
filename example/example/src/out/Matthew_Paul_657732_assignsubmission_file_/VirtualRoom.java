package out.Matthew_Paul_657732_assignsubmission_file_;/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

//Matthew Paul 816018640
public class VirtualRoom{
    private String name;
    private int breakOutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    
    public VirtualRoom(String name){
        this.name=name;
        breakOutRoomLimit=5;
    }
    
    public VirtualRoom(String name,int limit){
        this.name=name;
        breakOutRoomLimit=limit;
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakOutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        breakoutRooms=new BreakoutRoom[breakOutRoomLimit];
        for(int i=0;i<breakOutRoomLimit;i++){
            breakoutRooms[i]=new BreakoutRoom(name);
        }
    }
    
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        String id="";
        int length=0;
        char num=(char)(roomNumber+'0');
        for(int i=0;i<breakOutRoomLimit;i++){
            id=breakoutRooms[i].getbreakoutRoomID();
            char[] chars=id.toCharArray();
        
            for(char c:chars){
                if(Character.isDigit(c)){
                    if(c==num){
                        return breakoutRooms[i];
                    }
                }
            }
            
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom foundRoom;
        foundRoom=findBreakoutRoom(roomNumber);
        if(foundRoom!=null){
            foundRoom.closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom foundRoom;
        foundRoom=findBreakoutRoom(roomNumber);
        if(foundRoom!=null){
            foundRoom.openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String details=" ";
        details=name + "\n";
        for(int i=0;i<breakOutRoomLimit;i++){
            details=details + breakoutRooms[i].getbreakoutRoomID() + " "; 
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom foundRoom;
        foundRoom=findBreakoutRoom(roomNumber);
        if(foundRoom!=null){
        String details="VirtualRoom: "+name + "\n" + foundRoom.listParticipants();
        return details;
        }
        return null;
    } 
    
    //Error with this function "java.lang.NullPointerExceptions"
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom foundRoom;
        foundRoom=findBreakoutRoom(roomNumber);
        if(foundRoom!=null){
            boolean added=foundRoom.addParticipant(participantID);
            if(added==true){
            return true;
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int i=0;i<breakOutRoomLimit;i++){
            if(breakoutRooms[i].findParticipant(participantID)!=null){
                return breakoutRooms[i].getbreakoutRoomID();
            }
        }
        return null;
    }
}
