package out.Karsten_Lange_657828_assignsubmission_file_;public class VirtualRunner{
    //ID:816014018
    
    public static void main(String[] args){
        
        
        
        VirtualMeetingSystem virtualSystem = new VirtualMeetingSystem();
        
        virtualSystem.loadParticipantData("participant.dat");
        
        virtualSystem.createVirtualRoom("Seminar");
        
        
        virtualSystem.allocateParticipants("C5");
        
        /*
        boolean checkAdd = virtualSystem.addParticipant("89765432", 5);
        
        System.out.println(checkAdd);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        //VirtualRoom clas testing....
        //BreakoutRoom b = new BreakoutRoom("temp");
        VirtualRoom room = new VirtualRoom("SeminarRoom", 5);
        
        room.createBreakoutRooms();
        
        
        BreakoutRoom b=room.findBreakoutRoom(2);
        
        //BreakoutRoom z = room.findBreakoutRoom(1);
        
        System.out.println(b.getBreakoutRoomID());
        
        System.out.println(b.toString());
        
        b = room.findBreakoutRoom(3);
      
        System.out.println(b.getBreakoutRoomID());
        
        System.out.println(b.toString());
        
        //room.closeBreakoutRoom(3);
        
        System.out.println(b.toString());
        
        //room.openBreakoutRoom(3);
        
        System.out.println(b.toString());
        
        System.out.println(room.listBreakoutRooms());
        
        System.out.println(room.listParticipantsInBreakoutRoom(4));
        room.addParticipantToBreakoutRoom("11111111", 1);
        
        room.addParticipantToBreakoutRoom("99999999", 4);
        
        room.addParticipantToBreakoutRoom("12345678", 4);
        
        room.addParticipantToBreakoutRoom("12346678", 4);
        
        room.addParticipantToBreakoutRoom("77777777", 4);
        
        
        
        System.out.println(room.addParticipantToBreakoutRoom("00000000",4));
        
        System.out.println(room.listParticipantsInBreakoutRoom(4));
        
        
        System.out.println(room.findParticipantBreakoutRoom("11111111"));
        
       
       
       
       
       
       
       
       
        
        /*
        //BreakoutRoom class testing....
        BreakoutRoom b = new BreakoutRoom("Seminar1");
        b.addParticipant("00000000");
        b.addParticipant("99999999");
        b.addParticipant("12345678");
        System.out.println("Implementing toString method...");
        System.out.println(b.toString());
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("Implementing ListParticipants method... ");
        System.out.println(b.listParticipants());
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("Implementing b.findParticipant() method... ");
        Participant p = new Participant("88888888");
        p = b.findParticipant("99999999");
        System.out.println(p.toString());
        System.out.println(" ");
        System.out.println(" ");
        
        
        System.out.println("Afer implementing b.closeBreakoutRoom.....");
        b.closeBreakoutRoom();
        System.out.println(b.toString());
        System.out.println(" ");
        System.out.println(" ");
        
        
        
        b.openBreakoutRoom();
        System.out.println("Afer implementing b.openBreakoutRoom.....");
        System.out.println(b.toString());
        System.out.println(" ");
        
        
        System.out.println("After adding back Participants and Implementing ListParticipants... ");
        b.addParticipant("00000001");
        b.addParticipant("99999992");
        b.addParticipant("23456783");
        System.out.println(b.listParticipants());
        System.out.println(" ");
        
       
        
        System.out.println("Implementing toString method.... ");
        System.out.println(b.toString());
        
        
        
       
       
       
       
       
        
        
        /*
        Participant class testing....
        Participant p = new Participant("87456321");
        Participant p1 = new Participant("00000000");
        Participant p2 = new Participant("99999999");
        Participant p3 = new Participant("1234567");
        Participant p4 = new Participant("123456789");
        System.out.println(p.toString());
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
        
         
        System.out.println(p.verifyID("87456321"));
        System.out.println(p1.verifyID("00000000"));
        System.out.println(p2.verifyID("99999999"));
        System.out.println(p3.verifyID("1234567"));
        System.out.println(p4.verifyID("123456789"));
        */
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}