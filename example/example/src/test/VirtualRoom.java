package test;

public class VirtualRoom {
   private String name;
   private final int breakoutRoomLimit;
   private BreakoutRoom[] breakoutRooms;

   public VirtualRoom(String name) {
      this.name = name;
      this.breakoutRoomLimit = 5;
      this.breakoutRooms = new BreakoutRoom[this.breakoutRoomLimit];
   }

   public VirtualRoom(String name, int limit) {
      this.name = name;
      this.breakoutRoomLimit = limit;
      this.breakoutRooms = new BreakoutRoom[this.breakoutRoomLimit];
   }

   public int getNumberOfBreakoutRooms() {
      return this.breakoutRoomLimit;
   }

   public void createBreakoutRooms() {
      for(int i = 0; i < this.breakoutRoomLimit; ++i) {
         this.breakoutRooms[i] = new BreakoutRoom(this.name);
      }

   }

   public BreakoutRoom findBreakoutRoom(int roomNumber) {
      for(int i = 0; i < this.breakoutRoomLimit; ++i) {
         if (this.breakoutRooms[i].getBreakoutRoomID().equals(this.name + roomNumber)) {
            return this.breakoutRooms[i];
         }
      }

      return null;
   }

   public boolean closeBreakoutRoom(int roomNumber) {
      BreakoutRoom room = this.findBreakoutRoom(roomNumber);
      if (room == null) {
         return false;
      } else {
         room.closeBreakoutRoom();
         return true;
      }
   }

   public boolean openBreakoutRoom(int roomNumber) {
      BreakoutRoom room = this.findBreakoutRoom(roomNumber);
      if (room == null) {
         return false;
      } else {
         room.openBreakoutRoom();
         return true;
      }
   }

   public String listBreakoutRooms() {
      String list = this.name + "\n";

      for(int i = 0; i < this.breakoutRoomLimit; ++i) {
         list = list + this.breakoutRooms[i].toString() + "\n";
      }

      return list;
   }

   public String listParticipantsInBreakoutRoom(int roomNumber) {
      BreakoutRoom room = this.findBreakoutRoom(roomNumber);
      return room != null ? room.listParticipants() : null;
   }

   public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber) {
      BreakoutRoom room = this.findBreakoutRoom(roomNumber);
      return room != null ? room.addParticipant(participantID) : false;
   }

   public String findParticipantBreakoutRoom(String participantID) {
      for(int i = 0; i < this.breakoutRoomLimit; ++i) {
         if (this.breakoutRooms[i].findParticipant(participantID) != null) {
            return this.breakoutRooms[i].getBreakoutRoomID();
         }
      }

      return null;
   }

   public String listParticipantsInAllBreakoutRooms() {
      String list = "";

      for(int i = 0; i < this.breakoutRoomLimit; ++i) {
         list = list + this.breakoutRooms[i].getBreakoutRoomID() + "\n" + this.breakoutRooms[i].listParticipants() + "\n";
      }

      return list;
   }
}
