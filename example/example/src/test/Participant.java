package test;

public class Participant {
   private String participantID;

   public Participant(String participantID) {
      this.participantID = participantID;
   }

   public String getParticipantID() {
      return this.participantID;
   }

   public String toString() {
      return "Participant: " + this.getParticipantID();
   }

   public static boolean verifyID(String ID) {
      return ID != null && ID.length() == 8 && ID.matches("\\d{8}");
   }
}
