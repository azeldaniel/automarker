package test;

import java.io.File;
import java.util.Scanner;

public class VirtualMeetingSystem {
   private String[] participants;
   private VirtualRoom vRoom;

   public void loadParticipantData(String filename) {
      try {
         File dataFile = new File(filename);
         Scanner fileReader = new Scanner(dataFile);
         this.participants = new String[50];

         for(int i = 0; fileReader.hasNextLine(); ++i) {
            String line = fileReader.nextLine();
            String[] linedata = line.split("\t");
            this.participants[i] = linedata[0];
         }

         fileReader.close();
      } catch (Exception var7) {
         System.out.println(var7.toString());
      }

   }

   public void createVirtualRoom(String name) {
      this.vRoom = new VirtualRoom(name);
      this.vRoom.createBreakoutRooms();
   }

   public void allocateParticipants(String code) {
      int numRooms = this.vRoom.getNumberOfBreakoutRooms();
      int numLearners = this.participants.length;
      int factor = numLearners / numRooms;
      int i;
      int roomID;
      if (code.equals("RR")) {
         for(i = 0; i < this.participants.length && this.participants[i] != null; ++i) {
            roomID = i % factor;
            if (roomID > 0 && roomID < 6) {
               this.vRoom.addParticipantToBreakoutRoom(this.participants[i], roomID);
            }

            if (roomID >= 6 || roomID <= 9) {
               this.vRoom.addParticipantToBreakoutRoom(this.participants[i], roomID - 5);
            }

            if (roomID == 0) {
               this.vRoom.addParticipantToBreakoutRoom(this.participants[i], roomID + 5);
            }
         }
      }

      if (code.equals("C5")) {
         for(i = 0; i < this.participants.length && this.participants[i] != null; ++i) {
            roomID = i / 5;
            this.vRoom.addParticipantToBreakoutRoom(this.participants[i], roomID + 1);
         }
      }

   }

   public boolean addParticipant(String participantID, int roomNumber) {
      return this.vRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
   }

   public String listParticipants(int roomNumber) {
      return this.vRoom.listParticipantsInBreakoutRoom(roomNumber);
   }

   public boolean openBreakoutRoom(int roomNumber) {
      return this.vRoom.openBreakoutRoom(roomNumber);
   }

   public boolean closeBreakoutRoom(int roomNumber) {
      return this.vRoom.closeBreakoutRoom(roomNumber);
   }

   public String findParticipantBreakoutRoom(String participantID) {
      return this.vRoom.findParticipantBreakoutRoom(participantID);
   }

   public String listAllBreakoutRooms() {
      return this.vRoom.listBreakoutRooms();
   }

   public String listParticipantsInAllBreakoutRooms() {
      return this.vRoom.listParticipantsInAllBreakoutRooms();
   }
}
