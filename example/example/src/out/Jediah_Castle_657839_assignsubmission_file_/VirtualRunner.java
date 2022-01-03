package out.Jediah_Castle_657839_assignsubmission_file_;import java.util.Scanner; 

public class VirtualRunner{
    private VirtualMeetingSystem VRM = new VirtualMeetingSystem();
   
      public  void menu(){
        int opt = 0 ;
    
        System.out.println("1.Loading participants from file");
        System.out.println("2.Create a new virtual room");
        System.out.println("3. Allocate participants to breakout rooms");
        System.out.println("4. Add a new participant to a breakout room");
        System.out.println("5. Display a list of all participants in a breakout room");
        System.out.println("6. Close a breakout room based on a room number");
        System.out.println("7. Open a breakout room based on a room number");
        System.out.println("8. Find a participant’s breakout room number");
        System.out.println("9. Display a list of all breakout rooms managed by the system");
        System.out.println("10. Display a list of all breakout rooms managed by the system and the participants in each room");
        System.out.println("11. Exit");
        System.out.println("Pick an option");
        Scanner keyboard = new Scanner(System.in);
        while( opt != 11){
          opt = keyboard.nextInt();
        
          if(opt == 1){
              opt1();
           }
          else if(opt == 2){
              opt2();
          }
          else if(opt == 3){
              opt3();
          }
          else if(opt == 4){
              opt4();
          }
          else if(opt == 5){
              opt5();
          }
          else if(opt == 6){
              opt6();
          }
          else if(opt == 7){
              opt7();
          }
          //option 8 is incomplete 
          else if(opt == 9){
              opt9();
          }
          else if(opt == 10){
              opt10();
          }
          System.out.println("Pick an option");
        }
     }
     
      public  void  opt1(){
        System.out.println("1.Loading participants from file");
        Scanner  keyboard = new Scanner(System.in);
        System.out.println("Enter filename (Ensure virtural room is created): ");
        String filename = keyboard.nextLine();
        VRM.loadParticipantData(filename);
        
     }
     
     public  void  opt2(){ 
         Scanner  keyboard = new Scanner(System.in);
         System.out.println("2.Create a new virtual room");
         System.out.println("Enter name for virtural room: ");
         String name = keyboard.nextLine();
         VRM.createVirtualRoom(name);
        
     } 
      
     public void  opt3(){ 
         Scanner  keyboard = new Scanner(System.in);
         System.out.println("3. Allocate participants to breakout rooms");
         System.out.println("Enter code: ");
         String code = keyboard.nextLine();
         VRM.allocateParticipants(code);
        
     } 
     
     public  void  opt4(){ 
         Scanner  keyboard = new Scanner(System.in);
         System.out.println("4. Add a new participant to a breakout room");
         System.out.println("Enter ParticipantID: ");
         String participantID = keyboard.nextLine();
         System.out.println("Enter RoomNumber: ");
         int RN = keyboard.nextInt();
         VRM.addParticipant(participantID,RN);
        
     } 
    
     public  void  opt5(){ 
         Scanner  keyboard = new Scanner(System.in);
         System.out.println("3. Allocate participants to breakout rooms");
         System.out.println("Enter Room Number: ");
         int RN = keyboard.nextInt();
         System.out.println(VRM.listParticipants(RN));
        
     } 
     
     public  void  opt6(){ 
         Scanner  keyboard = new Scanner(System.in);
         System.out.println("6. Close a breakout room based on a room number");
         System.out.println("Enter Room Number: ");
         int RN = keyboard.nextInt();
         VRM.closeBreakoutRoom(RN);
        
     } 
     
     public  void  opt7(){ 
         Scanner  keyboard = new Scanner(System.in);
         System.out.println("7. Open a breakout room based on a room number");
         System.out.println("Enter Room Number: ");
         int RN = keyboard.nextInt();
         VRM.openBreakoutRoom(RN);
        
     } 
     /*
     public static void  opt8(){ 
         Scanner  keyboard = new Scanner(System.in);
         System.out.println("8. Find a participant’s breakout room number");
         System.out.println("Enter Participant ID: ");
         String participantID = keyboard.nextLine();
         VRM.findParticipantBreakoutRoom(participantID);
        
     } 
     */
     public void  opt9(){ 
        Scanner  keyboard = new Scanner(System.in);
        System.out.println("9. Display a list of all breakout rooms managed by the system");
        System.out.println(VRM.listAllBreakoutRooms( ));
     
     } 
     
     public void  opt10(){ 
         Scanner  keyboard = new Scanner(System.in);
         System.out.println("10. Display a list of all breakout rooms managed by the system and the participants in each room");
         System.out.println(VRM.listParticipantsInAllBreakoutRooms());
         
        
     } 
     
}
