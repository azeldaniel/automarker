package out.Jiles_Ramjattan_657776_assignsubmission_file_;
/**
 * Write a description of class Participants here.
 *
 * @author (Jiles Tony Ramjattan-816008647)
 * @version (V.1a)
 */
public class VirtualRoom {

    String name;
    int breakoutRoomLimit;
    BreakoutRoom[] breakoutRooms;

    public VirtualRoom(String name){
        this.name=name;
        this.breakoutRoomLimit=5;
        this.breakoutRooms=new BreakoutRoom[breakoutRoomLimit];

    }
    public VirtualRoom(String name, int limit){
        this.name=name;
        this.breakoutRoomLimit=limit;
        this.breakoutRooms=new BreakoutRoom[breakoutRoomLimit];

    }

    public int getNumberOfBreakoutRooms(){

        int count=0;

        while(count<breakoutRoomLimit){
            if(breakoutRooms[count].getBreakoutRoomID()!=null){
                count++;
            }
            else
                return count;
        }
        return count;
    }

    public void createBreakoutRooms(){
        for(int x=0; x<breakoutRoomLimit; x++){
          this.breakoutRooms[x]=new BreakoutRoom(this.name);
        }
    }

    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int x=0; x<breakoutRoomLimit; x++){
            if(this.breakoutRooms[x].getBreakoutRoomID().equals(name+roomNumber)){
                return this.breakoutRooms[x];
            }
        }
        return null;
    }

    public boolean closeBreakoutRoom(int roomNumber){

        if(findBreakoutRoom(roomNumber)!=null) {
            findBreakoutRoom(roomNumber).closeBreakOutRoom();
            return true;
        }
        else return false;

    }

    public boolean openBreakoutRoom(int roomNumber){

        if(findBreakoutRoom(roomNumber)!=null){
            findBreakoutRoom(roomNumber).openBreakOutRoom();
            return true;
        }
        return false;
    }

    public  String listBreakoutRoom(){
        String aggregate="";
        for(int x=0; x<breakoutRoomLimit; x++){
            if(this.breakoutRooms[x]!=null){
                aggregate+=this.breakoutRooms[x].getBreakoutRoomID()+"\n";
            }
        }
        return aggregate;
    }

    public String listParticipantsInBreakoutRoom(int roomNumber){
        String aggregate="";

        if(findBreakoutRoom(roomNumber)!=null){
            aggregate+=findBreakoutRoom(roomNumber).listParticipants();
            return aggregate;
        }
        return  null;
    }

    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        for(int x=0; x<breakoutRoomLimit; x++){
            if(this.breakoutRooms[x].getBreakoutRoomID().contains(roomNumber+"")){
                if(this.breakoutRooms[x].getOpen()&&(this.breakoutRooms[x].getNumberOfParticipants()-1<this.breakoutRooms[x].getBreakoutRoomSize())){
                 return this.breakoutRooms[x].addParticipant(participantID);

                }
            }


        }
        return false;
    }

    public String findParticipantBreakoutRoom(String participantID){

        if(participantID.length()>8){
            return null;
        }
        for(int x=0; x<breakoutRoomLimit; x++){

            if(breakoutRooms[x].findParticipant(participantID)!=null){
                return this.breakoutRooms[x].getBreakoutRoomID();
            }

        }
        return null;
    }



    public String getName() {
        return name;
    }

    public BreakoutRoom[] getBreakoutRooms() {
        return breakoutRooms;
    }

    public int getBreakoutRoomLimit() {
        return breakoutRoomLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreakoutRoomLimit(int breakoutRoomLimit) {
        this.breakoutRoomLimit = breakoutRoomLimit;
    }

    public void setBreakoutRooms(BreakoutRoom[] breakoutRooms) {
        this.breakoutRooms = breakoutRooms;
    }

}