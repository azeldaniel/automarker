package out.Darius_Seales_657852_assignsubmission_file_;

import com.azeldaniel.automarker.marker.Attribute;
import com.azeldaniel.automarker.marker.Constructor;
import com.azeldaniel.automarker.marker.Markable;
import com.azeldaniel.automarker.marker.Marker;
import com.azeldaniel.automarker.marker.Method;
import com.azeldaniel.automarker.utils.Runner;
import java.lang.reflect.Array;
import java.util.HashMap;
import org.hamcrest.beans.HasPropertyWithValue;
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
public class VirtualRoomTest {
   private static Marker marker;
   private static HashMap<String, Object> values;

   @BeforeClass
   public static void setup() {
      marker = new Marker();
      values = new HashMap<>();
      values.put("roomName", "VirtualRoom");
      values.put("validParticipantID", "12345678");
      values.put("limit", 10);
      values.put("defaultLimit", 5);
      Class<?> breakoutRoomClass = VirtualRoomTest.class;

      breakoutRoomClass = Marker.getClass(VirtualRoomTest.class, "BreakoutRoom");

      marker.add(new Attribute("name", String.class, 1.0D));
      marker.add(new Attribute("breakoutRoomLimit", Integer.TYPE, new String[] { "private", "final" }, 1.0D));
      marker.add(new Attribute("breakoutRooms", Array.newInstance(breakoutRoomClass, 0).getClass(), 1.0D));
      marker.add(new Constructor(new Class[] { String.class }, 2.0D));
      marker.add(new Constructor(new Class[] { String.class, Integer.TYPE }, 2.0D));
      marker.add(new Method("getNumberOfBreakoutRooms", Integer.TYPE, 1.0D));
      marker.add(new Method("createBreakoutRooms", 2.0D));
      marker.add(new Method("findBreakoutRoom", breakoutRoomClass, new Class[] { Integer.TYPE }, 2.0D));
      marker.add(new Method("closeBreakoutRoom", Boolean.TYPE, new Class[] { Integer.TYPE }, 2.0D));
      marker.add(new Method("openBreakoutRoom", Boolean.TYPE, new Class[] { Integer.TYPE }, 2.0D));
      marker.add(new Method("listBreakoutRooms", String.class, 2.0D));
      marker.add(new Method("listParticipantsInBreakoutRoom", String.class, new Class[] { Integer.TYPE }, 2.0D));
      marker.add(
            new Method("addParticipantToBreakoutRoom", Boolean.TYPE, new Class[] { String.class, Integer.TYPE }, 2.0D));
      marker.add(new Method("findParticipantBreakoutRoom", String.class, new Class[] { String.class }, 2.0D));
      marker.validate(VirtualRoomTest.class, "VirtualRoom");
      Assert.assertFalse(VirtualRoomTest.class.equals(breakoutRoomClass));
   }

   @AfterClass
   public static void breakdown() {
      marker.report();
   }

   @Before
   public void resetBreakoutRoomIDCounter() {
      Marker.setClassAttribute(VirtualRoomTest.class, "BreakoutRoom", "breakoutRoomNumberCounter", 0);
   }

   @Test
   public void testName() {
      marker.start(marker.attribute("name"));
      marker.end();
   }

   @Test
   public void testBreakoutRoomLimit() {
      marker.start(marker.attribute("breakoutRoomLimit"));
      marker.end();
   }

   @Test
   public void testBreakoutRooms() {
      marker.start(marker.attribute("breakoutRooms"));
      marker.end();
   }

   @Test
   public void testConstructor() {
      marker.start(marker.constructor(new Class[] { String.class }));
      marker.constructor(new Class[] { String.class }).assertCreates(new Object[] { values.get("roomName") }, 0.5D);
      marker.attribute("name").assertMatches(IsEqual.equalTo(values.get("roomName").toString()), 603, 0.5D);
      marker.attribute("breakoutRoomLimit")
            .assertMatches(IsEqual.equalTo(Integer.valueOf(values.get("defaultLimit").toString())), 603, 0.5D);
      marker.attribute("breakoutRooms").assertMatches(
            IsArrayWithSize.arrayWithSize(Integer.valueOf(values.get("defaultLimit").toString())), 603, 0.5D);
      marker.end();
   }

   @Test
   public void testOverloadedConstructor() {
      marker.start(marker.constructor(new Class[] { String.class, Integer.TYPE }));
      marker.constructor(new Class[] { String.class, Integer.TYPE })
            .assertCreates(new Object[] { values.get("roomName"), values.get("limit") }, 0.5D);
      marker.attribute("name").assertMatches(IsEqual.equalTo(values.get("roomName").toString()), 603, 0.5D);
      marker.attribute("breakoutRoomLimit")
            .assertMatches(IsEqual.equalTo(Integer.valueOf(values.get("limit").toString())), 603, 0.5D);
      marker.attribute("breakoutRooms")
            .assertMatches(IsArrayWithSize.arrayWithSize(Integer.valueOf(values.get("limit").toString())), 603, 0.5D);
      marker.end();
   }

   @Test
   public void testGetNumberOfBreakoutRooms() {
      marker.start(marker.method("getNumberOfBreakoutRooms"),
            new Markable[] { marker.constructor(new Class[] { String.class }), marker.attribute("breakoutRoomLimit") });
      marker.constructor(new Class[] { String.class }).assertCreates(new Object[] { values.get("roomName") });
      marker.method("getNumberOfBreakoutRooms").assertReturnsValueEqualToAttribute("breakoutRoomLimit", 401);
      marker.end();
   }

   @Test
   public void testCreateBreakoutRooms() {
      marker.start(marker.method("createBreakoutRooms"),
            new Markable[] { marker.constructor(new Class[] { String.class }), marker.attribute("breakoutRooms") });
      marker.constructor(new Class[] { String.class }).assertCreates(new Object[] { values.get("roomName") });
      marker.method("createBreakoutRooms").assertRuns(1.0D);
      marker.attribute("breakoutRooms").assertMatches(IsNot.not(IsArrayContaining.hasItemInArray(IsNull.nullValue())),
            605, 1.0D);
      marker.end();
   }

   @Test
   public void testFindBreakoutRoom() {
      marker.start(marker.method("findBreakoutRoom"),
            new Markable[] { marker.constructor(new Class[] { String.class }), marker.method("createBreakoutRooms") });
      marker.constructor(new Class[] { String.class }).assertCreates(new Object[] { values.get("roomName") });
      marker.method("createBreakoutRooms").assertRuns();
      marker.method("findBreakoutRoom").assertReturns(new Object[] { 1 }, IsNull.notNullValue(), 502);
      marker.end();
   }

   @Test
   public void testCloseBreakoutRoom() {
      marker.start(marker.method("closeBreakoutRoom"),
            new Markable[] { marker.constructor(new Class[] { String.class }), marker.method("createBreakoutRooms"),
                  marker.attribute("breakoutRooms") });
      marker.constructor(new Class[] { String.class }).assertCreates(new Object[] { values.get("roomName") });
      marker.method("createBreakoutRooms").assertRuns();
      marker.method("closeBreakoutRoom").assertRuns(new Object[] { 1 }, 1.0D);
      marker.attribute("breakoutRooms").assertMatches(
            IsArrayContaining.hasItemInArray(HasPropertyWithValue.hasProperty("open", IsEqual.equalTo(false))), 605,
            1.0D);
      marker.end();
   }

   @Test
   public void testOpenBreakoutRoom() {
      marker.start(marker.method("openBreakoutRoom"),
            new Markable[] { marker.constructor(new Class[] { String.class }), marker.method("createBreakoutRooms"),
                  marker.method("closeBreakoutRoom"), marker.attribute("breakoutRooms") });
      marker.constructor(new Class[] { String.class }).assertCreates(new Object[] { values.get("roomName") });
      marker.method("createBreakoutRooms").assertRuns();
      marker.method("closeBreakoutRoom").assertRuns(new Object[] { 1 });
      marker.method("openBreakoutRoom").assertRuns(new Object[] { 1 }, 1.0D);
      marker.attribute("breakoutRooms").assertMatches(
            IsArrayContaining.hasItemInArray(HasPropertyWithValue.hasProperty("open", IsEqual.equalTo(true))), 605,
            1.0D);
      marker.end();
   }

   @Test
   public void testListBreakoutRooms() {
      marker.start(marker.method("listBreakoutRooms"),
            new Markable[] { marker.constructor(new Class[] { String.class }), marker.method("createBreakoutRooms") });
      marker.constructor(new Class[] { String.class }).assertCreates(new Object[] { values.get("roomName") });
      marker.method("createBreakoutRooms").assertRuns();
      marker.method("listBreakoutRooms").assertReturnsStringContainingAttribute("name", 402, 1.5D);
      marker.method("listBreakoutRooms").assertReturnsStringContainingAttributeInFormat("breakoutRooms", "{}", 403,
            0.5D);
      marker.end();
   }

   @Test
   public void testListParticipantsInBreakoutRoom() {
      marker.start(marker.method("listParticipantsInBreakoutRoom"),
            new Markable[] { marker.constructor(new Class[] { String.class }), marker.method("createBreakoutRooms"),
                  marker.method("addParticipantToBreakoutRoom") });
      marker.constructor(new Class[] { String.class }).assertCreates(new Object[] { values.get("roomName") });
      marker.method("createBreakoutRooms").assertRuns();
      marker.method("listParticipantsInBreakoutRoom").assertReturns(new Object[] { 1 }, IsNull.notNullValue(), 502,
            1.0D);
      marker.method("listParticipantsInBreakoutRoom").assertReturnsStringContainingAttribute("name", new Object[] { 1 },
            402, 0.5D);
      marker.method("openBreakoutRoom").assertRuns(new Object[] { 1 });
      marker.method("addParticipantToBreakoutRoom").assertRuns(new Object[] { values.get("validParticipantID"), 1 });
      marker.method("listParticipantsInBreakoutRoom").assertReturns(new Object[] { 1 },
            StringContains.containsString(values.get("validParticipantID").toString()), 605, 0.5D);
      marker.end();
   }

   @Test
   public void testAddParticipantToBreakoutRoom() {
      marker.start(marker.method("addParticipantToBreakoutRoom"),
            new Markable[] { marker.constructor(new Class[] { String.class }), marker.method("createBreakoutRooms"),
                  marker.method("listParticipantsInBreakoutRoom") });
      marker.constructor(new Class[] { String.class }).assertCreates(new Object[] { values.get("roomName") });
      marker.method("createBreakoutRooms").assertRuns();
      marker.method("openBreakoutRoom").assertRuns(new Object[] { 1 });
      marker.method("addParticipantToBreakoutRoom").assertReturns(new Object[] { values.get("validParticipantID"), 1 },
            IsEqual.equalTo(true), 502, 1.0D);
      marker.method("listParticipantsInBreakoutRoom").assertReturns(new Object[] { 1 },
            StringContains.containsString(values.get("validParticipantID").toString()), 605, 1.0D);
      marker.end();
   }

   @Test
   public void testFindParticipantBreakoutRoom() {
      marker.start(marker.method("findParticipantBreakoutRoom"),
            new Markable[] { marker.constructor(new Class[] { String.class }), marker.method("createBreakoutRooms"),
                  marker.method("listParticipantsInBreakoutRoom"), marker.method("addParticipantToBreakoutRoom") });
      marker.constructor(new Class[] { String.class }).assertCreates(new Object[] { values.get("roomName") });
      marker.method("createBreakoutRooms").assertRuns();
      marker.method("openBreakoutRoom").assertRuns(new Object[] { 1 });
      marker.method("addParticipantToBreakoutRoom").assertRuns(new Object[] { values.get("validParticipantID"), 1 });
      marker.method("findParticipantBreakoutRoom").assertReturns(new Object[] { values.get("validParticipantID") },
            IsNull.notNullValue(), 502);
      marker.end();
   }
}
