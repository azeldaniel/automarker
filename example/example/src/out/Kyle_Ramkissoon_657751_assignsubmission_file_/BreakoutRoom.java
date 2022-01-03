package out.Kyle_Ramkissoon_657751_assignsubmission_file_;//[816019715]
public class BreakoutRoom{

    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    public BreakoutRoom(String name){

        this.participants = new Participant[10];
        this.numberOfParticipants = 0;
        this.breakoutRoomID = name + breakoutRoomNumberCounter++;
        this.open = true;
    }

    public boolean getOpen(){
    	return this.open;
    }

    public String getBreakoutRoomID(){
    	return breakoutRoomID;
    }

    public int getNumberOfParticipants(){
    	return numberOfParticipants;
    }


    public boolean addParticipant(String participantID){
        if (!this.open){

            System.out.println("Breakout Room is closed: " + this.breakoutRoomID);
            return false;
        }


        else if (this.numberOfParticipants >= this.breakoutRoomSize){
            System.out.println("Breakout Room is full: " + this.breakoutRoomID);
            return false;
        }


        if (findParticipant(participantID) != null) {
            System.out.println("ID already exist in: " + this.breakoutRoomID);
            return false;
        }



        Participant p1 = new Participant(participantID);
        if(!p1.verifyID(participantID)){

            System.out.println("ID is invlaid, cannot be added to: " + this.breakoutRoomID);
            return false;
        }
        this.participants[numberOfParticipants++] = p1;
        System.out.println(p1.getParticipantID() + " was added to " + this.breakoutRoomID);
        return true;
    }


    public Participant findParticipant(String participantID){
        if (!this.open){

            System.out.println("Breakout Room is closed: " + this.breakoutRoomID);
            return null;
        }


        for (int i = 0; i < this.numberOfParticipants; i++){

            if (this.participants[i].getParticipantID().equals(participantID)){
                System.out.println("ID already exist in: " );
                return this.participants[i];
            }
        }

        return null;
    }


    public String listParticipants(){
        String val = breakoutRoomID + "\n" + "\n";

        for (int i = 0; i < this.numberOfParticipants; i++){
            val += this.participants[i].toString() + "\n";
        }

        return val;
    }

    public String toString(){
        String stat = this.breakoutRoomID + "CLOSE";
        if (this.open){
            stat = this.breakoutRoomID + "OPEN";
        }

        return this.breakoutRoomID + " is " + stat + " and contains " + this.numberOfParticipants + " participant[s]" + "\n";
        }

    public void closeBreakoutRoom(){
        for (int i = 0; i < this.numberOfParticipants; i++) {
            this.participants[i] = null;
        }
        this.numberOfParticipants = 0;
        System.out.println("Breakout Room Closed: " + this.breakoutRoomID + "\n");
        this.open = false;
    }

    public void openBreakoutRoom(){
        System.out.println("Breakout Room Open: " + this.breakoutRoomID + "\n");
        this.open = true;
    }

}
