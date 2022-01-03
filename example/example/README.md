# Use cases of AutoMarker

Data files are placed at the root. RUNNING MAY TAKE up to 10 mins AND SOME MANUAL INPUT FROM SOME STUDENTS' CODE MAY BE NEEDED.

Will not recognize rar files or files with incorrect naming formats.

Must be in format `FirstName_LastName_8160XXXXX_A1.zip`.

## Sample Test Case setup

```java
@RunWith(Runner.class)
public class ParticipantTest {
    // Setting up the marker instance
   private static Marker marker;

   // Optional hashmap to hold test values
   private static HashMap<String, Object> values;

    // Necessary setup method that must be run
   @BeforeClass
   public static void setup() {
       //creating the marker instance
      marker = new Marker();
      // populating the optional values hashmap
      values = new HashMap();
      values.put("validID", "12345678");
      values.put("invalidID", "1234");

      // Declaring the markable items we want to test.
      // First item is an attribute names participantID that is a string 
      // and carries 1 mark for declaring it properly (private access is implied)
      marker.add(new Attribute("participantID", String.class, 1.0D));

      // Second item is a constructor that accepts a string, 2 marks if defined properly
      marker.add(new Constructor(new Class[]{String.class}, 2.0D));

      // Third item is a method verifyID that returns a boolean and takes a string argument, 
      // it also has a static type (public access is implied)
      marker.add(new Method("verifyID", Boolean.TYPE, new String[]{"static"}, new Class[]{String.class}, 2.0D));
      marker.add(new Method("getParticipantID", String.class, 1.0D));
      marker.add(new Method("toString", String.class, 2.0D));

      // This is done to ensure that students actually define the class
      marker.validate(ParticipantTest.class, "Participant");
   }

    // This must be done to report grades properly
   @AfterClass
   public static void breakdown() {
      marker.report();
   }

    // Sample test case for testing an attribute
    // We only test that it exists and is defined properly
   @Test
   public void testParticipantID() {
       // we must call start and end at the beginning and end of each test case.
       // The start call must include the markable item we want to test.
      marker.start(marker.attribute("participantID"));
      marker.end();
   }

    // Sample test case for constructor
   @Test
   public void testParticipant() {
      marker.start(marker.constructor(new Class[]{String.class}));
      marker.constructor(new Class[]{String.class}).assertCreates(new Object[]{values.get("validID")}, 1.0D);
      marker.attribute("participantID").assertMatches(IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace((String)values.get("validID")), 603, 1.0D);
      marker.end();
   }

    // Sample test case for a method
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

```