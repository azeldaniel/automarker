package out.Andrei_Guevara_657703_assignsubmission_file_;/**816022711
 * Andrei Guevara
 * OwO - O3O
**/

public class BreakoutRoom{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private int temp;
    private final static int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    
    BreakoutRoom(){
        
        this.breakoutRoomID = null;
        
    }
    
    
    BreakoutRoom(String name){
        
        temp = breakoutRoomNumberCounter;
        this.breakoutRoomID = name + this.breakoutRoomNumberCounter++;
        this.participants = new Participant[this.breakoutRoomSize];
        this.numberOfParticipants = 0;
        this.openBreakoutRoom();
        
    }
    
    
    public boolean addParticipant(String participantID){

       if (this.findParticipant(participantID) == null && this.numberOfParticipants < this.breakoutRoomSize){
            
           participants[numberOfParticipants] = new Participant();
       
           if (this.participants[numberOfParticipants].verifyID(participantID)){
               
                participants[numberOfParticipants].setParticipantID(participantID);
                numberOfParticipants++;
                
            }
       
           return true;
         
       }

       return false;
       
    }
    
    
    public Participant findParticipant(String participantID){
        
        if (open == false)
        
            return null;
            
        for (int t = 0; t < this.numberOfParticipants; t++){
            
            if (this.participants[t].getParticipantID().equals(participantID))
                
                return this.participants[t];
            
        }
        
        return null;
        
    }
    
    
    public String listParticipants(){
        
        String list = "Room ID: " + breakoutRoomID + "\nParticipants:\n";
        
        int count = 0;
        
        for (; count < numberOfParticipants; count++){
            
            list += participants[count].toString();
            
            if (count != numberOfParticipants-1)
            
                list += "\n";
            
        }
        
        if (count == 0)
        
           list += "Room empty";
        
        
        return list;
        
    }
    
    
    public String toString(){
        
        String string = breakoutRoomID;
        
        if (this.open)
        
            string += " OPEN ";
            
        else
        
            string += " CLOSED ";
            
        string += this.numberOfParticipants;
        
        return string;
        
    }
    
    public void closeBreakoutRoom(){
        
        if (this.open == false)
        
            return;
        
        for (int x=0; x < this.breakoutRoomSize; x++)
        
            this.participants[x] = null;
            
        this.numberOfParticipants = 0;
        this.open = false;
        
    }
    
    
    public void openBreakoutRoom(){
        
        if (this.open)
        
            return;
            
        this.open = true;
        
    }

    
    public int getBreakoutRoomNumberCounter(){
        
        return this.temp;
        //return ((int)breakoutRoomID.charAt((breakoutRoomID.length()-1))) - '0';
        
    }
    
    
    public String getBreakoutRoomID(){
        
        return breakoutRoomID;
        
    }
    
    
    public boolean getOpen(){
        
        return open;
        
    }
    
    
    public int getNumberOfParticipants(){
     
        return numberOfParticipants;
        
    }
    
    
    public int getBreakoutRoomSize(){
        
        return breakoutRoomSize;
        
    }
    
    
    public Participant[] getParticipants(){
        
        return participants;
        
    }
    
    public void breakoutRoomNumberFixer(){
    
        breakoutRoomNumberCounter = 1;
        
    }
    
    /*public static void main(String[] args){
        
        BreakoutRoom br = new BreakoutRoom("Room");
        BreakoutRoom br2 = new BreakoutRoom("Seminar");
        
        br.addParticipant("23851110");
        
        if (br.findParticipant("23851110") != null)
        
            System.out.println("Participant found.");
            
        else
        
            System.out.println("Paticipant not found.");
        
        System.out.println(br.listParticipants());
            
        System.out.println(br.toString());
        
        br.closeBreakoutRoom();
        
        System.out.println(br.listParticipants());
        
        System.out.println(br.toString());
        
        br .openBreakoutRoom();
        
        System.out.println(br.listParticipants());
        
        System.out.println(br.toString());
        
        
    }
    */
   
   /*public static void main(String[] args){
   
       BreakoutRoom br = new BreakoutRoom("Room");
       BreakoutRoom br2 = new BreakoutRoom("Meeting");
       
       System.out.println(br.getBreakoutRoomNumberCounter());
       System.out.println(br2.getBreakoutRoomNumberCounter());
       
   }*/
}