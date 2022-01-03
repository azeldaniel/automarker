package out.Jonathan_Gray_657823_assignsubmission_file_;// StudentID: 816022996
// Student Name: Jonathan Gray

import java.util.Random;

public class BreakoutRoom{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private int roomNumber;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        breakoutRoomNumberCounter += 1;
        roomNumber = breakoutRoomNumberCounter;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;
    }
    
    public boolean verifyParticipantID(String participantID){
        return Participant.verifyID(participantID);
    }

    public boolean addParticipant(String participantID){
        if(getBreakoutRoomIsOpen() && Participant.verifyID(participantID)){
            if(duplicateParticipants(participantID)){
               return false;
            }   
            //System.out.println("Number of participants: " + numberOfParticipants);
            //System.out.println("The breakout room size is: " + breakoutRoomSize + "\n");
            for(int i = 0; i < breakoutRoomSize; i++){
                if(participants[i] == null){
                    participants[i] = new Participant(participantID);
                    numberOfParticipants += 1;
                    if(numberOfParticipants == 10){
                        open = false;
                    }
                    return true;
                }
            }   
        }
        return false;
    }
    
    public boolean duplicateParticipants(String participantID){
        for(int i = 0; i < numberOfParticipants; i++){
            if(participants[i] == null){
                return false;
            }
            if(participants[i].getParticipantID().equals(participantID)){
                return true;
            }
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){
        if(Participant.verifyID(participantID) == true && getBreakoutRoomIsOpen()){
            for(int i = 0; i < numberOfParticipants; i++){
                if(participants[i].getParticipantID().equals(participantID)){
                    return participants[i];
                }
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String participantIDList = new String();

        if(numberOfParticipants == 0){
            //return " ---> BreakoutRoom '" + breakoutRoomID + "' does NOT have any participants yet.\n\n";
            return null;
        }

        participantIDList += "\t\t" + breakoutRoomID + "\n\n";
        
        for(int i = 0; i < numberOfParticipants; i++){
            participantIDList += participants[i].getParticipantID() + "\n";
        }
        return participantIDList;
    }
    
    public String toString(){
        String state;
        
        state = "\nBreakoutRoomID: " + breakoutRoomID  + "\nOpen: " + open + "\nBreakoutRoomNumberOfParticipants: "
            + numberOfParticipants + "\nBreakout Room Number: " + breakoutRoomNumberCounter +
            "\nBreakoutRoom Size: " + breakoutRoomSize;
           
        return state;
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }
    
    public void closeBreakoutRoom(){
        this.open = false;
        
        // An alternative to the following loop, although I believe it will just create new memory, leaving the old... 
        // ... locations on the stack which is wasteful of memory resources:
        // participants = new Participant[breakoutRoomSize];
        for(int i = 0; i < numberOfParticipants; i++){
            participants[i] = null;
        }
        numberOfParticipants = 0;
    }
    
    public int getBreakoutRoomNumber(){
        return roomNumber;
    }
    
    public int getBreakoutRoomSize(){
        return breakoutRoomSize;
    }
    
    public Participant getParticipant(int participantIndex){
        return participants[participantIndex];
    }

    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getBreakoutRoomIsOpen(){
        return open;
    }
    
    public String getParticipantID(int indexOfParticipant){
        return participants[indexOfParticipant].getParticipantID();
    }
}
    