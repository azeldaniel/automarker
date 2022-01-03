package test;

public class BreakoutRoom {
   public static int breakoutRoomNumberCounter = 0;
   private final int breakoutRoomSize = 10;
   private String breakoutRoomID;
   private Participant[] participants;
   private int numberOfParticipants;
   private boolean open;

   public BreakoutRoom(String name) {
      this.breakoutRoomID = name + ++breakoutRoomNumberCounter;
      this.participants = new Participant[10];
      this.numberOfParticipants = 0;
      this.open = true;
   }

   public String getBreakoutRoomID() {
      return this.breakoutRoomID;
   }

   public int getNumberOfParticipants() {
      return this.numberOfParticipants;
   }

   public boolean addParticipant(String ID) {
      if (Participant.verifyID(ID) && this.numberOfParticipants < 10 && this.open && this.findParticipant(ID) == null) {
         this.participants[this.numberOfParticipants++] = new Participant(ID);
         return true;
      } else {
         return false;
      }
   }

   public Participant findParticipant(String ID) {
      if (Participant.verifyID(ID) && this.open) {
         for(int i = 0; i < this.numberOfParticipants; ++i) {
            if (this.participants[i].getParticipantID().equals(ID)) {
               return this.participants[i];
            }
         }
      }

      return null;
   }

   public String listParticipants() {
      String list = this.breakoutRoomID + "\n";

      for(int i = 0; i < this.numberOfParticipants; ++i) {
         list = list + this.participants[i].toString() + "\n";
      }

      return list;
   }

   public void closeBreakoutRoom() {
      this.open = false;
      this.participants = new Participant[10];
      this.numberOfParticipants = 0;
   }

   public void openBreakoutRoom() {
      this.open = true;
   }

   public boolean getOpen() {
      return this.open;
   }

   private String openState() {
      return this.open ? "OPEN" : "CLOSED";
   }

   public String toString() {
      return this.getBreakoutRoomID() + " " + this.openState() + " " + this.getNumberOfParticipants();
   }
}
