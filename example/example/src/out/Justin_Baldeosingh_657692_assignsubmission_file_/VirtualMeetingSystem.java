package out.Justin_Baldeosingh_657692_assignsubmission_file_;/* Justin Baldeosingh
 * 816021226
 * COMP 2603 - OOP
 * Assignment 1
 */

//THE SYSTEM MUST BE RECOMPILED AFTER EACH RUN
//The static breakoutRoomNumberCounter does not reset if not recompiled.
//This problem does not occur on eclipse however.

//Imports libraries for input.
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//Virtual Meeting System Class
public class VirtualMeetingSystem {
    private VirtualRoom virtRoom;
    private String[] participantIDs = new String[50];
    private int numParticipants = 0;
    
    //Given a filename, loads the participant IDs from the file into a participantID string array.
    public void loadParticipantData(String filename){
        //Attempts to open the data file, read from the data file, and adds the read data to the array.
        try {
            //Sets the number of participants for the session to 0.
            int numParticipants = 0;
            //Declares a file object and points to the location of the file.
            File dataFile = new File(filename);
            //Creates a scanner object that will read from the dataFile object.
            Scanner fileReader = new Scanner(dataFile);
            
            //While the scanner has another line to read from the file, read the IDs into the data array.
            while(fileReader.hasNextLine()){
                //Creates a new string from the ID read from the file and stores it in the array at
                //the current position.
                participantIDs[numParticipants] = new String(fileReader.nextLine());
                //Increments to the next position in the participant ID array.
                numParticipants++;
            } 
            //Closes the file reading scanner.
            fileReader.close();
            //Outputs to the user that the file was successfully read.
            System.out.println("Successfully read data from data file!");
            this.numParticipants = numParticipants;
        }  catch(FileNotFoundException error) {
        //Otherwise, if the file is not found, notify the user and print the stack trace.
            System.out.println("Unexpected error when reading from data file!\n");
            error.printStackTrace();
        } 
    }
    
    //Given a room name, create a virtual room with the given name and creates the breakout rooms.
    public void createVirtualRoom(String name){
        //Creates a new virtual room.
        virtRoom = new VirtualRoom(name);
        //Creates the breakout rooms for the virtual room.
        virtRoom.createBreakoutRooms();
        //Inform the user of a successful operation.
        System.out.println("Succesfully created Virtual Room!");
    }
    
    //Given an allocation code, allocates participants in different orders.
    public void allocateParticipants(String code){
        int currentParticipant, currentRoom;
        boolean successfulAdd;
        try {
            //If the allocation method is C5, allocates in clusters of 5 to breakout rooms.
            if(code.equals("C5")){
                currentParticipant = 0;
                currentRoom = 0;
                //While the current participant is less than the number of participants that was loaded from the file,
                //Add the current participant from the participant array to one of the virtual room's breakout room.
                while(currentParticipant < this.numParticipants){
                    //Determines the room that the participant should be added to; in a cluster of 5.
                    currentRoom = ((currentParticipant / 5) % this.virtRoom.getNumberOfBreakoutRooms()) + 1;
                    //Adds the current participant to the current breakout room and stores the outcome.
                    successfulAdd = this.addParticipant(this.participantIDs[currentParticipant], currentRoom);
                    //If the outcome of the add operation was unsuccesful, inform the user and return immediately.
                    if(!successfulAdd){
                        System.out.println("Unable to allocate all participants to breakout room! Room too small/Not enough rooms!");
                        return;
                    }
                    //Increments to the next participant in the participant array.
                    currentParticipant++;     
                }
             } else if(code.equals("RR")){
             //If the allocation method is RR, allocates in a round robin way to breakout rooms.
                //Sets the current participant number to 0.
                currentParticipant = 0;
                
                //While the current participant is less than the number of participants that was loaded from the file,
                //Add the current participant from the participant array to one of the virtual room's breakout room.
                while(currentParticipant < this.numParticipants){
                    //Determines the room that the participant should be added to; in a round robin fashion.
                    currentRoom = currentParticipant % this.virtRoom.getNumberOfBreakoutRooms() + 1;
                    //Adds the current participant to the current breakout room and stores the outcome.
                    successfulAdd = this.addParticipant(this.participantIDs[currentParticipant], currentRoom);
                    //If the outcome of the add operation was unsuccesful, inform the user and return immediately.
                    if(!successfulAdd){
                        System.out.println("Unable to allocate all participants to breakout room! Room too small/Not enough rooms!");
                        return;
                    }
                    
                    //Increments to the next participant in the participant array.
                    currentParticipant++;
                }
            } else {
            //Otherwise inform the user that an invalid code was entered.
                System.out.println("Invalid code!");
            }
        } catch (Throwable e){
            System.out.println("Unable to allocate to breakout room. Please ensure that the virtual meeting room is initialized.");
        }
    }
    
    //Given a participant ID and a room number, returns the outcome of the participant being added to the corresponding room.
    public boolean addParticipant(String participantID, int roomNumber){
        try {
            return this.virtRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
        } catch (Throwable e){
            System.out.println("Unable to add participant! Please ensure that the virtual meeting room is initialized.");
        }
        return false;
    }
    
    //Given a room number, returns a string listing the participants of that breakout room.
    public String listParticipants(int roomNumber){
        try {
            return this.virtRoom.listParticipantsInBreakoutRoom(roomNumber);
        } catch (Throwable e){
            System.out.println("Please ensure that the virtual meeting room is initialized.");
        }
        return null;
    }
    
    //Given a room number, returns the outcome of the openRoom operation on the room number.
    public boolean openBreakoutRoom(int roomNumber){
        try {
            return this.virtRoom.openBreakoutRoom(roomNumber);
        } catch (Throwable e){
            System.out.println("Please ensure that the virtual meeting room is initialized.");
        }
        return false;
    }
    
    //Given a room number, returns the outcome of the closeRoom operation on the room number.
    public boolean closeBreakoutRoom(int roomNumber){
        try {
            return this.virtRoom.closeBreakoutRoom(roomNumber);
        } catch (Throwable e){
            System.out.println("Please ensure that the virtual meeting room is initialized.");
        }
        return false;
    }
    
    //Given an ID, returns a string with the breakout room ID containing the passed participant ID.
    public String findParticipantBreakoutRoom(String participantID){
        try {
            return this.virtRoom.findParticipantBreakoutRoom(participantID);
        } catch (Throwable e){
            System.out.println("Please ensure that the virtual meeting room is initialized.");
        }
        return null;
    }
    
    //Returns a string detailing the statuses of all of the breakout rooms.
    public String listAllBreakoutRooms(){
        try {
            return this.virtRoom.listBreakoutRooms();
        } catch (Throwable e){
            System.out.println("Please ensure that the meeting system is initialized.");
        }
        return null;
    }
    
    //Returns a list of all the participants in all of the breakout rooms.
    public String listParticipantsInAllBreakoutRooms(){
        //Attempts to iterate over the breakout rooms that exist and are open and store the participants in the breakout rooms.
        try {
            //Creates the header.
            String allParticipants = "Breakout Rooms Managed by System\n";
            //Iterates over all of the room numbers and gets the participants from the valid rooms.
            for(int i = 1; i <= this.virtRoom.getNumberOfBreakoutRooms(); i++){
                //Determine if the current breakout room exists and is open, and appends the participants of that room.
                if(this.virtRoom.findBreakoutRoom(i) != null && this.virtRoom.findBreakoutRoom(i).getOpen())
                    allParticipants += this.virtRoom.listParticipantsInBreakoutRoom(i);
            }
            
            //Returns the list of all participants in all of the breakout rooms.    
            return allParticipants;
        } catch(Exception e) {
        //If an error is encountered, inform the user.
            System.out.println("Please ensure that the virtual meeting room is initialized.");
        }
        
        //Otherwise return null.
        return null;

    }
}

/*
References:
GeeksforGeeks. "Java Create and Write To Files", (Unknown), https://www.w3schools.com/java/java_files_create.asp
*/
