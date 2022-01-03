package out.Dexter_Singh_671780_assignsubmission_file_;//816009215
public class VirtualRoom
{
 private String name;
 private int breakoutRoomLimit; 
 private BreakoutRoom[] breakoutRooms;
 
 //constructors-overloaded
 public VirtualRoom(String name){
    this.name = name;
    breakoutRoomLimit = 5;
    breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    
    for(int i =0; i < breakoutRoomLimit; i++)
        breakoutRooms[i] = null;
 }
 
 public VirtualRoom(String name, int limit){
    this.name = name;
    breakoutRoomLimit = limit;
    breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    
    for(int i =0; i < breakoutRoomLimit; i++)
        breakoutRooms[i] = null;
 }
 
 //methods-mutators-accessors-behaviours
 public int getNumberOfBreakoutRooms(){
    int rooms = 0;
    while (rooms < breakoutRoomLimit )
        rooms++;
    return rooms;
 }
 
 public void createBreakoutRooms(){
    for(int i =0; i < breakoutRoomLimit; i++)
        breakoutRooms[i] = new BreakoutRoom(name + String.valueOf(i));
 }
 
 public BreakoutRoom findBreakoutRoom(int roomNumber){
    if(getNumberOfBreakoutRooms() > 0){
       int room = 0;
       while(room < breakoutRoomLimit && room <= roomNumber){
           if(room == roomNumber)
            return breakoutRooms[room];
           room++;
       }
    }
    return null;
 }
 
 public boolean closeBreakoutRoom(int roomNumber){
     if(findBreakoutRoom(roomNumber)!=null){
        breakoutRooms[roomNumber].closeBreakoutRoom();
        return true;
     }
     return false;
 }
 
 public boolean openBreakoutRoom(int roomNumber){
     if(findBreakoutRoom(roomNumber)!=null){
         breakoutRooms[roomNumber].openBreakoutRoom();
         return true;
     }
     return false;
 }
 
 public String listBreakoutRooms(){
     String list = name + "\nBreakoutRooms:";
     if(getNumberOfBreakoutRooms() > 0){
         int room = 0;
         while(room < breakoutRoomLimit){
            list = list + " " + name + String.valueOf(room) + " ";
            room++;
        }
     }
     return list;
 }
 
 public String listParticipantsInBreakoutRoom(int roomNumber){
     if(breakoutRooms[roomNumber].numberOfParticipants > 0)
        return breakoutRooms[roomNumber].listParticipants();
     return null;
 }
 
 public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
     if(findBreakoutRoom(roomNumber)!=null){
            if(breakoutRooms[roomNumber].addParticipant(participantID))
                return true;
     }
     return false;
 }
 
 public String findParticipantBreakoutRoom(String participantID){
     int room = 0;
     while (room < breakoutRoomLimit){
        if(breakoutRooms[room].findParticipant(participantID)!=null)
            return name + String.valueOf(room);
        room++;
     }
     return null;
 }
 

}
/*
 * Lecture Notes
 * Null finding methods: https://www.delftstack.com/howto/java/java-check-if-object-is-null/#:~:text=To%20check%20if%20it%20is,the%20passed%20object%20is%20null.
 * Recursive error: https://www.educative.io/edpresso/how-to-resolve-the-javalangstackoverflowerror-in-java
 */