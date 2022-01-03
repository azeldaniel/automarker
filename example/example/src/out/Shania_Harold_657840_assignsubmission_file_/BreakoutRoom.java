package out.Shania_Harold_657840_assignsubmission_file_;// 816006213

public class BreakoutRoom{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0; // Breakout room ID
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants = 0; // Number of participants | Array 0 - 9
    private boolean open = false;
    private int breakoutRoomCount = 0; // Number of breakout rooms | Array 0 - 9
    
    public BreakoutRoom(String name){
        this.breakoutRoomNumberCounter++;
        this.breakoutRoomSize = 10;
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        participants = new Participant[breakoutRoomSize];
        this.breakoutRoomCount++;
    }
    
    // Accessors
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    public boolean getOpen(){
        return open;
    }
    public int getBreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
    public int getBreakoutRoomCount(){
        return breakoutRoomCount;
    }
    
    public boolean addParticipant(String participantID){
        boolean valid = Participant.verifyID(participantID);
        
        Participant participant = new Participant(participantID);
        //participants[numberOfParticipants] = participant;
        
        //System.out.println(numberOfParticipants);
        //System.out.println(participants[0]);
        /*if (participants[0] == null){
            while (numberOfParticipants < 10 && valid == true){
                participants[numberOfParticipants] = participant;
                //Participant participant = new Participant(participantID);
                //participants[numberOfParticipants] = participant;
                //System.out.println("Added");
                //participants[numberOfParticipants].setParticipantID(participantID);
                //System.out.println(participants[numberOfParticipants]);
                //System.out.println(numberOfParticipants);
                numberOfParticipants++;
                return true;
            }
        } else {
            for (int i = 0; i < participants.length; i++){ // For loop may have to go in while loop
                //System.out.println("Hi");
                if (participants[i].getParticipantID() == participantID){
                    //System.out.println("Not added");
                    return false;
                }
            }
        }*/
        
        if (valid == true && open == true){
            for (int i = 0; i < 10; i++){ // i = 0
                //System.out.println("Hi");
                if ((participants[i] != null) && (participants[i].getParticipantID() == participantID)){
                    //System.out.println("Not added");
                    return false;
                }
            }
            if (numberOfParticipants < 10){
                participants[numberOfParticipants] = participant;
            }
            //System.out.println("# " + numberOfParticipants);
            numberOfParticipants++;
            return true;
        }
        
        
        //Participant participant = new Participant(participantID);
        //participants[numberOfParticipants] = participant;
        
        //System.out.println(numberOfParticipants);
        
        return false;
        
        /*if (numberOfParticipants < breakoutRoomSize){
                participants[numberOfParticipants] = new Participant(participantID);
                //Participant participant = new Participant(participantID);
                //participants[numberOfParticipants] = participant;
                numberOfParticipants++;
                return true;
        }
        return false;*/
    }
    
    public Participant findParticipant(String participantID){
        for (int i = 0; i < numberOfParticipants; i++){
            if (participants[i].getParticipantID() == participantID){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){ // Assuming I am to use the toString() method in the Participant class
        String details = this.breakoutRoomID + "\n";
        //System.out.println(numberOfParticipants);
        if (numberOfParticipants == 0){
            return "There is no one in this room";
        } else {
            //System.out.println(numberOfParticipants);
            for (int i = 0; i < numberOfParticipants; i++){
                //System.out.println(numberOfParticipants);
                //System.out.println("i " + i);
                details += participants[i].toString() + " ";
            }
            return details;
        }
        //return details;
    }
    
    public String toString(){
        String room = getBreakoutRoomID(); // breakout room name
        String state;
        
        if (this.open == true){
            state = "OPEN";
        } else {
            state = "NOT OPEN";
        }
        // Removed breakoutRoomNumberCounter from below
        return room + " " + state + " " + numberOfParticipants;
    }
    
    public void closeBreakoutRoom(){
        if (open == true){
            //breakoutRoomSize = 0;
            participants = new Participant[breakoutRoomSize];
            open = false;
            breakoutRoomCount -= 1;
            numberOfParticipants = 0;
        } else {
            System.out.println("Breakout room not open");
        }
    }
    
    public void openBreakoutRoom(){
        if (open == false){
            this.open = true;
        } else {
            System.out.println("Breakout room already open");
        }
    }
    
    /*public static void main(String[] args){
        BreakoutRoom b1 = new BreakoutRoom("French");
        b1.openBreakoutRoom();
        //System.out.println(b1.getBreakoutRoomNumberCounter());
        System.out.println(b1.addParticipant("00000000"));
        //System.out.println(b1.addParticipant("12345678"));
        //System.out.println(b1.addParticipant("12345678"));
        //b1.addParticipant("12345679");
        System.out.println(b1.findParticipant("00000000"));
        //System.out.println(b1.breakoutRoomCount);
        //System.out.println(b1.listParticipants());
        //System.out.println(b1.toString());
    }*/
}