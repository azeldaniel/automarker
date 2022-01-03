package out.Toni___Marie_Noel_657693_assignsubmission_file_;

import com.azeldaniel.automarker.marker.Attribute;
import com.azeldaniel.automarker.marker.Constructor;
import com.azeldaniel.automarker.marker.Markable;
import com.azeldaniel.automarker.marker.Marker;
import com.azeldaniel.automarker.marker.Method;
import com.azeldaniel.automarker.utils.Runner;
import java.lang.reflect.Array;
import java.util.HashMap;
import org.hamcrest.collection.IsArrayWithSize;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Runner.class)
public class BreakoutRoomTest {
   private static Marker marker;
   private static HashMap<String, Object> values;
   private static Class<?> participantClass;

   @BeforeClass
   public static void setup() {
      marker = new Marker();
      values = new HashMap<String, Object>();
      values.put("roomName", "Room1");
      values.put("validParticipantIDs", new String[]{"10000000", "00000001", "00000002", "00000003", "00000004", "00000005", "00000006", "00000007", "00000008", "00000009", "00000010"});
      participantClass = Marker.getClass(BreakoutRoomTest.class, "Participant");
      marker.add(new Attribute("breakoutRoomID", String.class, 1.0D));
      marker.add(new Attribute("breakoutRoomNumberCounter", Integer.TYPE, new String[]{"private", "static"}, 1.0D));
      marker.add(new Attribute("breakoutRoomSize", Integer.TYPE, new String[]{"private", "final"}, 1.0D));
      marker.add(new Attribute("participants", Array.newInstance(participantClass, 0).getClass(), 1.0D));
      marker.add(new Attribute("numberOfParticipants", Integer.TYPE, 1.0D));
      marker.add(new Attribute("open", Boolean.TYPE, 1.0D));
      marker.add(new Constructor(new Class[]{String.class}, 3.0D));
      marker.add(new Method("addParticipant", Boolean.TYPE, new Class[]{String.class}, 2.0D));
      marker.add(new Method("findParticipant", participantClass, new Class[]{String.class}, 2.0D));
      marker.add(new Method("listParticipants", String.class, 2.0D));
      marker.add(new Method("closeBreakoutRoom", 1.0D));
      marker.add(new Method("openBreakoutRoom", 1.0D));
      marker.add(new Method("getBreakoutRoomID", String.class, 1.0D));
      marker.add(new Method("getNumberOfParticipants", Integer.TYPE, 1.0D));
      marker.add(new Method("getOpen", Boolean.TYPE, 1.0D));
      marker.add(new Method("toString", String.class, 2.0D));
      marker.validate(BreakoutRoomTest.class, "BreakoutRoom");
      Assert.assertNotNull(participantClass);
   }

   @AfterClass
   public static void breakdown() {
      marker.report();
   }

   @Test
   public void testBreakoutRoomID() {
      marker.start(marker.attribute("breakoutRoomID"));
      marker.end();
   }

   @Test
   public void testBreakoutRoomNumberCounter() {
      marker.start(marker.attribute("breakoutRoomNumberCounter"));
      marker.end();
   }

   @Test
   public void testBreakoutRoomSize() {
      marker.start(marker.attribute("breakoutRoomSize"));
      marker.end();
   }

   @Test
   public void testParticipants() {
      marker.start(marker.attribute("participants"));
      marker.end();
   }

   @Test
   public void testNumberOfParticipants() {
      marker.start(marker.attribute("numberOfParticipants"));
      marker.end();
   }

   @Test
   public void testOpen() {
      marker.start(marker.attribute("open"));
      marker.end();
   }

   @Test
   public void testBreakoutRoom() {
      marker.start(marker.constructor(new Class[]{String.class}));
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("roomName")}, 1.0D);
      marker.attribute("breakoutRoomID").assertMatches(IsNull.notNullValue(), 603, 0.5D);
      marker.attribute("breakoutRoomSize").assertMatches(IsEqual.equalTo(10), 603, 0.5D);
      marker.attribute("participants").assertMatches(IsArrayWithSize.arrayWithSize(10), 603, 1.0D);
      marker.attribute("numberOfParticipants").assertMatches(IsEqual.equalTo(0), 603, 0.5D);
      marker.attribute("open").assertMatches(IsEqual.equalTo(true), 603, 0.5D);
      marker.end();
   }

   @Test
   public void testAddParticipant() {
      marker.start(marker.method("addParticipant"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.method("openBreakoutRoom")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("roomName")});
      marker.method("openBreakoutRoom").assertRuns();
      marker.method("addParticipant").assertReturns(new Object[]{((String[])values.get("validParticipantIDs"))[0]}, IsEqual.equalTo(true), 503);
      marker.end();
   }

   @Test
   public void testFindParticipant() {
      marker.start(marker.method("findParticipant"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.method("addParticipant"), marker.method("openBreakoutRoom")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("roomName")});
      marker.method("openBreakoutRoom").assertRuns();
      marker.method("addParticipant").assertRuns(new Object[]{((String[])values.get("validParticipantIDs"))[0]});
      marker.method("findParticipant").assertReturns(new Object[]{((String[])values.get("validParticipantIDs"))[0]}, IsNull.notNullValue(), 502);
      marker.end();
   }

   @Test
   public void testListParticipants() {
      marker.start(marker.method("listParticipants"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.method("addParticipant"), marker.method("openBreakoutRoom"), marker.attribute("breakoutRoomID")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("roomName")});
      marker.method("openBreakoutRoom").assertRuns();
      marker.method("addParticipant").assertRuns(new Object[]{((String[])values.get("validParticipantIDs"))[0]});
      marker.method("listParticipants").assertReturnsStringContainingAttribute("breakoutRoomID", 402, 1.0D);
      marker.method("listParticipants").assertReturnsStringContainingAttributeInFormat("participants", "\n{}", 403, 1.0D);
      marker.end();
   }

   @Test
   public void testToString() {
      marker.start(marker.method("toString"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.attribute("breakoutRoomID"), marker.attribute("numberOfParticipants")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("roomName")});
      marker.method("openBreakoutRoom").assertRuns();
      marker.method("toString").assertReturnsStringContainingAttribute("breakoutRoomID", 404, 0.5D);
      marker.method("toString").assertReturnsStringContainingAttribute("numberOfParticipants", 404, 0.5D);
      marker.method("toString").assertReturnsStringContainingAttributeInFormat("breakoutRoomID", "{} OPEN", 403, 0.5D);
      marker.method("toString").assertReturnsStringContainingAttributeInFormat("numberOfParticipants", "OPEN {}", 403, 0.5D);
      marker.end();
   }

   @Test
   public void testCloseBreakoutRoom() {
      marker.start(marker.method("closeBreakoutRoom"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.attribute("open"), marker.attribute("numberOfParticipants")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("roomName")});
      marker.method("closeBreakoutRoom").assertRuns(0.5D);
      marker.attribute("open").assertMatches(IsEqual.equalTo(false), 605);
      marker.attribute("numberOfParticipants").assertMatches(IsEqual.equalTo(0), 605, 0.5D);
      marker.end();
   }

   @Test
   public void testOpenBreakoutRoom() {
      marker.start(marker.method("openBreakoutRoom"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.method("closeBreakoutRoom"), marker.attribute("open")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("roomName")});
      marker.method("openBreakoutRoom").assertRuns(0.5D);
      marker.attribute("open").assertMatches(IsEqual.equalTo(true), 605, 0.5D);
      marker.end();
   }

   @Test
   public void testGetBreakoutRoomID() {
      marker.start(marker.method("getBreakoutRoomID"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.attribute("breakoutRoomID")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("roomName")});
      marker.method("getBreakoutRoomID").assertReturnsValueEqualToAttribute("breakoutRoomID", 401);
      marker.end();
   }

   @Test
   public void testGetNumberOfParticipants() {
      marker.start(marker.method("getNumberOfParticipants"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.attribute("numberOfParticipants")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("roomName")});
      marker.method("getNumberOfParticipants").assertReturnsValueEqualToAttribute("numberOfParticipants", 401);
      marker.end();
   }

   @Test
   public void testGetOpen() {
      marker.start(marker.method("getOpen"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.attribute("open")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("roomName")});
      marker.method("getOpen").assertReturnsValueEqualToAttribute("open", 401);
      marker.end();
   }
}
