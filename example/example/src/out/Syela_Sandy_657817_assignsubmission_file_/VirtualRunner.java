package out.Syela_Sandy_657817_assignsubmission_file_;
/**
 * Write a description of class VirtualRunner here.
 *
 * @Student ID: 816020390
 * @version (a version number or a date)
 */
public class VirtualRunner
{
    // instance variables - replace the example below with your own
    public static VirtualMeetingSystem virtualMeetingSystem;
    
    public static void main(String[] args){
        
           VirtualMeetingSystem vm = new VirtualMeetingSystem();
           
    
           vm.loadParticipantData("participant.dat");
    
           for(int i =0; i < vm.array.length; i++){
               System.out.println(vm.array[i]);
           }
    
           vm.createVirtualRoom("Seminar");
           vm.allocateParticipants("C5"); //allocates participants to breakout rooms in clusters of 5
           vm.openBreakoutRoom(1); //opens the breakout room according to room number
           boolean added = vm.addParticipant("81602039",1); //adds a new participant to the breakoutroom with the supplied room number
           System.out.println(added); //returns true if a participant was added
           vm.listParticipants(1); //displays the list of participants in breakoutroom 1
           vm.closeBreakoutRoom(1); //closes the breakout room No.1
           String roomNumber = vm.findParticipantBreakoutRoom("32687155");
           System.out.println(roomNumber); //prints the room number of the participantID
           vm.listAllBreakoutRooms(); //lists all the breakrooms managed by the system
           vm.listParticipantsInAllBreakoutRooms();//list of all breakout rooms managed by the system and the participants
    
            
    
    }
}
//Sources Used
/* https://www.thoughtco.com/converting-strings-to-numbers-and-vice-versa-2034313#:~:text=To%20make%20a%20number%20into%20a%20String%20follows,numberTwenty%20%3D%2020%3B%20String%20converted%20%3D%20String.valueOf%20%28numberTwenty%29%3B
https://www.youtube.com/watch?v=hQut8sCGcDw
https://www.javatpoint.com/how-to-generate-random-number-in-java
https://www.javatpoint.com/java-break
https://www.tutorialspoint.com/Check-if-a-string-contains-a-number-using-Java
https://www.w3schools.com/java/java_files_read.asp
https://www.thoughtco.com/converting-strings-to-numbers-and-vice-versa-2034313#:~:text=To%20make%20a%20number%20into%20a%20String%20follows,numberTwenty%20%3D%2020%3B%20String%20converted%20%3D%20String.valueOf%20%28numberTwenty%29%3B
*/
