package out.Michael_Rampersad_657747_assignsubmission_file_;

import com.azeldaniel.automarker.marker.Attribute;
import com.azeldaniel.automarker.marker.Constructor;
import com.azeldaniel.automarker.marker.Markable;
import com.azeldaniel.automarker.marker.Marker;
import com.azeldaniel.automarker.marker.Method;
import com.azeldaniel.automarker.utils.Runner;
import java.util.HashMap;
import org.hamcrest.core.IsEqual;
import org.hamcrest.text.IsEqualIgnoringWhiteSpace;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Runner.class)
public class ParticipantTest {
   private static Marker marker;
   private static HashMap<String, Object> values;

   @BeforeClass
   public static void setup() {
      marker = new Marker();
      values = new HashMap();
      values.put("validID", "12345678");
      values.put("invalidID", "1234");
      marker.add(new Attribute("participantID", String.class, 1.0D));
      marker.add(new Constructor(new Class[]{String.class}, 2.0D));
      marker.add(new Method("verifyID", Boolean.TYPE, new String[]{"static"}, new Class[]{String.class}, 2.0D));
      marker.add(new Method("getParticipantID", String.class, 1.0D));
      marker.add(new Method("toString", String.class, 2.0D));
      marker.validate(ParticipantTest.class, "Participant");
   }

   @AfterClass
   public static void breakdown() {
      marker.report();
   }

   @Test
   public void testParticipantID() {
      marker.start(marker.attribute("participantID"));
      marker.end();
   }

   @Test
   public void testParticipant() {
      marker.start(marker.constructor(new Class[]{String.class}));
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("validID")}, 1.0D);
      marker.attribute("participantID").assertMatches(IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace((String)values.get("validID")), 603, 1.0D);
      marker.end();
   }

   @Test
   public void testVerifyID() {
      marker.start(marker.method("verifyID"));
      marker.method("verifyID").assertReturns(new Object[]{values.get("validID")}, IsEqual.equalTo(true), 502, 1.5D);
      marker.method("verifyID").assertReturns(new Object[]{values.get("invalidID")}, IsEqual.equalTo(false), 503, 0.5D);
      marker.end();
   }

   @Test
   public void testGetParticipantID() {
      marker.start(marker.method("getParticipantID"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.attribute("participantID")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("validID")});
      marker.method("getParticipantID").assertReturnsValueEqualToAttribute("participantID", 401);
      marker.end();
   }

   @Test
   public void testToString() {
      marker.start(marker.method("toString"), new Markable[]{marker.constructor(new Class[]{String.class}), marker.attribute("participantID")});
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("validID")});
      marker.method("toString").assertReturnsStringContainingAttribute("participantID", 402, 1.5D);
      marker.method("toString").assertReturnsStringContainingAttributeInFormat("participantID", "Participant: {}", 403);
      marker.end();
   }
}
