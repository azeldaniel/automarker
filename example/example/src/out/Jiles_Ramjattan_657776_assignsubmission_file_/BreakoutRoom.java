package out.Jiles_Ramjattan_657776_assignsubmission_file_;
/**
 * Write a description of class Participants here.
 *
 * @author (Jiles Tony Ramjattan-816008647)
 * @version (V.1a)
 */
import java.util.Random;

public class BreakoutRoom  {

    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    public BreakoutRoom(String name){
        Random rand= new Random();
        breakoutRoomNumberCounter= rand.nextInt(100);
        this.breakoutRoomID=name.concat(breakoutRoomNumberCounter+"")  ;
        this.breakoutRoomSize=10;
        this.participants=new Participant[breakoutRoomSize];
        for(int x=0; x<breakoutRoomSize; x++){
            participants[x]=new Participant("");
        }
        this.numberOfParticipants=0;
        this.open=true;

    }

    public int getBreakoutRoomNumberCounter() {
        return breakoutRoomNumberCounter;
    }
    public String getBreakoutRoomID() {
        return breakoutRoomID;
    }
    public int getBreakoutRoomSize() {
        return breakoutRoomSize;
    }
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }
    public boolean getOpen(){
        return this.open;
    }

    public void setBreakoutRoomID(String breakoutRoomID) {
        this.breakoutRoomID = breakoutRoomID;
    }
    public void setBreakoutRoomNumberCounter(int breakoutRoomNumberCounter) {
        this.breakoutRoomNumberCounter = breakoutRoomNumberCounter;
    }
    public void setBreakoutRoomSize(int breakoutRoomSize) {
        this.breakoutRoomSize = breakoutRoomSize;
    }
    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean addParticipant(String participantID){

        if(numberOfParticipants<breakoutRoomSize){

            if(participants[numberOfParticipants].verifyID(participantID)&&open){
            this.participants[numberOfParticipants]= new Participant(participantID);

            numberOfParticipants++;

            }

            return true;

        }

        return false;
    }

    public Participant findParticipant(String participantID){

        for (int x=0; x<numberOfParticipants; x++){
            if(participants[x].getParticipantID().equals(participantID)){
                return participants[x];
            }
        }
        return null;
    }

    public String listParticipants(){
        String aggregate="";
        for(int x=0; x<numberOfParticipants; x++){
            aggregate+=participants[x].toString()+" ";
        }
        return aggregate;
    }

    public String toString(){
        String aggregate = this.breakoutRoomID;
        if(open){
            aggregate+=" OPEN";
        }
        else{
            aggregate+=" CLOSE";
        }
        aggregate+="\t"+numberOfParticipants;

        return aggregate;
    }

    public void closeBreakOutRoom(){
        this.open=false;
        this.numberOfParticipants=0;
        this.participants=new Participant[breakoutRoomSize];

    }

    public void openBreakOutRoom(){
        this.breakoutRoomSize=10;
        this.participants=new Participant[breakoutRoomSize];
        for(int x=0; x<breakoutRoomSize; x++){
            participants[x]=new Participant("");
        }
        this.numberOfParticipants=0;
        this.open=true;
    }



}
