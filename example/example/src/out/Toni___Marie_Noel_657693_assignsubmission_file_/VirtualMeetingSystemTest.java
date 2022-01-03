package out.Toni___Marie_Noel_657693_assignsubmission_file_;

import com.azeldaniel.automarker.marker.Constructor;
import com.azeldaniel.automarker.marker.Markable;
import com.azeldaniel.automarker.marker.Marker;
import com.azeldaniel.automarker.marker.Method;
import com.azeldaniel.automarker.utils.Runner;
import java.lang.reflect.Array;
import java.util.HashMap;
import org.hamcrest.collection.IsArrayContaining;
import org.hamcrest.collection.IsArrayWithSize;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.hamcrest.core.StringContains;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Runner.class)
public class VirtualMeetingSystemTest {
   private static Marker marker;
   private static HashMap<String, Object> values;
   private static Class<?> virtualRoomClass;

   @BeforeClass
   public static void setup() {
      marker = new Marker();
      values = new HashMap<>();
      values.put("filename", "src/a1/test/resources/participant.dat");
      values.put("virtualRoomName", "VirtualRoom");
      values.put("validParticipantID", "12345678");
      values.put("code", "C5");
      values.put("code2", "RR");
      virtualRoomClass = Marker.getClass(BreakoutRoomTest.class, "VirtualRoom");
      marker.add(new Constructor("public", 0.0D));
      marker.add(new Method("loadParticipantData", new Class[]{String.class}, 5.0D));
      marker.add(new Method("createVirtualRoom", new Class[]{String.class}, 2.0D));
      marker.add(new Method("allocateParticipants", new Class[]{String.class}, 10.0D));
      marker.add(new Method("addParticipant", Boolean.TYPE, new Class[]{String.class, Integer.TYPE}, 2.0D));
      marker.add(new Method("listParticipants", String.class, new Class[]{Integer.TYPE}, 3.0D));
      marker.add(new Method("openBreakoutRoom", Boolean.TYPE, new Class[]{Integer.TYPE}, 2.0D));
      marker.add(new Method("closeBreakoutRoom", Boolean.TYPE, new Class[]{Integer.TYPE}, 2.0D));
      marker.add(new Method("findParticipantBreakoutRoom", String.class, new Class[]{String.class}, 2.0D));
      marker.add(new Method("listAllBreakoutRooms", String.class, 2.0D));
      marker.add(new Method("listParticipantsInAllBreakoutRooms", String.class, 2.0D));
      marker.validate(VirtualMeetingSystemTest.class, "VirtualMeetingSystem");
      Assert.assertNotNull(virtualRoomClass);
   }

   @AfterClass
   public static void breakdown() {
      marker.report();
   }

   @Before
   public void resetBreakoutRoomIDCounter() {
      Marker.setClassAttribute(VirtualMeetingSystemTest.class, "BreakoutRoom", "breakoutRoomNumberCounter", 0);
   }

   @Test
   public void testLoadParticipantData() {
      marker.start(marker.method("loadParticipantData"), new Markable[]{marker.constructor()});
      marker.constructor().assertCreates();
      marker.method("loadParticipantData").assertRuns(new Object[]{values.get("filename")}, 3.0D);
      marker.attribute().assertFirstOfTypeMatches(Array.newInstance(String.class, 0).getClass(), IsArrayWithSize.arrayWithSize(50), 605, 1.0D);
      marker.attribute().assertFirstOfTypeMatches(Array.newInstance(String.class, 0).getClass(), IsNot.not(IsArrayContaining.hasItemInArray(IsNull.nullValue())), 605, 1.0D);
      marker.end();
   }

   @Test
   public void testCreateVirtualRoom() {
      marker.start(marker.method("createVirtualRoom"), new Markable[]{marker.constructor()});
      marker.constructor().assertCreates();
      marker.method("createVirtualRoom").assertRuns(new Object[]{values.get("virtualRoomName")}, 1.0D);
      marker.attribute().assertFirstOfTypeMatches(virtualRoomClass, IsNull.notNullValue(), 605, 1.0D);
      marker.end();
   }

   @Test
   public void testAllocateParticipants() {
      marker.start(marker.method("allocateParticipants"), new Markable[]{marker.constructor(), marker.method("loadParticipantData"), marker.method("createVirtualRoom")});
      marker.constructor().assertCreates();
      marker.method("loadParticipantData").assertRuns(new Object[]{values.get("filename")});
      marker.method("createVirtualRoom").assertRuns(new Object[]{values.get("virtualRoomName")});
      marker.method("allocateParticipants").assertRuns(new Object[]{values.get("code")});
      marker.end();
   }

   @Test
   public void testAllocateParticipantBonus() {
      marker.startBonus(marker.method("allocateParticipants"), new Markable[]{marker.constructor(), marker.method("loadParticipantData"), marker.method("createVirtualRoom")});
      marker.constructor().assertCreates();
      marker.method("loadParticipantData").assertRuns(new Object[]{values.get("filename")});
      marker.method("createVirtualRoom").assertRuns(new Object[]{values.get("virtualRoomName")});
      marker.method("allocateParticipants").assertRuns(new Object[]{values.get("code2")});
      marker.end(5.0D);
   }

   @Test
   public void testAddParticipant() {
      marker.start(marker.method("addParticipant"), new Markable[]{marker.constructor(), marker.method("loadParticipantData"), marker.method("createVirtualRoom"), marker.method("openBreakoutRoom")});
      marker.constructor().assertCreates();
      marker.method("loadParticipantData").assertRuns(new Object[]{values.get("filename")});
      marker.method("createVirtualRoom").assertRuns(new Object[]{values.get("virtualRoomName")});
      marker.method("openBreakoutRoom").assertRuns(new Object[]{1});
      marker.method("addParticipant").assertReturns(new Object[]{values.get("validParticipantID"), 1}, IsEqual.equalTo(true), 502);
      marker.end();
   }

   @Test
   public void testListParticipants() {
      marker.start(marker.method("listParticipants"), new Markable[]{marker.constructor(), marker.method("createVirtualRoom"), marker.method("openBreakoutRoom"), marker.method("addParticipant")});
      marker.constructor().assertCreates();
      marker.method("createVirtualRoom").assertRuns(new Object[]{values.get("virtualRoomName")});
      marker.method("openBreakoutRoom").assertRuns(new Object[]{1});
      marker.method("addParticipant").assertRuns(new Object[]{values.get("validParticipantID"), 1});
      marker.method("listParticipants").assertReturns(new Object[]{1}, StringContains.containsString(values.get("virtualRoomName").toString()), 404, 2.0D);
      marker.method("listParticipants").assertReturns(new Object[]{1}, StringContains.containsString(values.get("validParticipantID").toString()), 404, 1.0D);
      marker.end();
   }

   @Test
   public void testOpenBreakoutRoom() {
      marker.start(marker.method("openBreakoutRoom"), new Markable[]{marker.constructor(), marker.method("createVirtualRoom")});
      marker.constructor().assertCreates();
      marker.method("createVirtualRoom").assertRuns(new Object[]{values.get("virtualRoomName")});
      marker.method("openBreakoutRoom").assertRuns(new Object[]{1});
      marker.end();
   }

   @Test
   public void testCloseBreakoutRoom() {
      marker.start(marker.method("closeBreakoutRoom"), new Markable[]{marker.constructor(), marker.method("createVirtualRoom")});
      marker.constructor().assertCreates();
      marker.method("createVirtualRoom").assertRuns(new Object[]{values.get("virtualRoomName")});
      marker.method("closeBreakoutRoom").assertRuns(new Object[]{1});
      marker.end();
   }

   @Test
   public void testFindParticipantBreakoutRoom() {
      marker.start(marker.method("findParticipantBreakoutRoom"), new Markable[]{marker.constructor(), marker.method("createVirtualRoom"), marker.method("openBreakoutRoom"), marker.method("addParticipant")});
      marker.constructor().assertCreates();
      marker.method("createVirtualRoom").assertRuns(new Object[]{values.get("virtualRoomName")});
      marker.method("openBreakoutRoom").assertRuns(new Object[]{1});
      marker.method("addParticipant").assertRuns(new Object[]{values.get("validParticipantID"), 1});
      marker.method("findParticipantBreakoutRoom").assertReturns(new Object[]{values.get("validParticipantID")}, IsNull.notNullValue(), 502);
      marker.end();
   }

   @Test
   public void testListAllBreakoutRooms() {
      marker.start(marker.method("listAllBreakoutRooms"), new Markable[]{marker.constructor(), marker.method("createVirtualRoom")});
      marker.constructor().assertCreates();
      marker.method("createVirtualRoom").assertRuns(new Object[]{values.get("virtualRoomName")});
      marker.method("listAllBreakoutRooms").assertReturns(StringContains.containsString(values.get("virtualRoomName").toString()), 404);
      marker.end();
   }

   @Test
   public void testListParticipantsInAllBreakoutRooms() {
      marker.start(marker.method("listParticipantsInAllBreakoutRooms"), new Markable[]{marker.constructor(), marker.method("createVirtualRoom"), marker.method("openBreakoutRoom"), marker.method("addParticipant")});
      marker.constructor().assertCreates();
      marker.method("createVirtualRoom").assertRuns(new Object[]{values.get("virtualRoomName")});
      marker.method("openBreakoutRoom").assertRuns(new Object[]{1});
      marker.method("addParticipant").assertRuns(new Object[]{values.get("validParticipantID"), 1});
      marker.method("listParticipantsInAllBreakoutRooms").assertReturns(StringContains.containsString(values.get("validParticipantID").toString()), 404);
      marker.end();
   }
}
