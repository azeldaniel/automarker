/* Decompiler 98ms, total 206ms, lines 237 */
package com.azeldaniel.automarker.marker;

public class Commenter {
   public static final int OK = 0;
   public static final int NOT_DEFINED = 100;
   public static final int NOT_PRIVATE = 101;
   public static final int NOT_PRIVATE_NOR_PROTECTED = 150;
   public static final int NOT_PROTECTED = 102;
   public static final int NOT_PUBLIC = 103;
   public static final int NOT_FINAL = 105;
   public static final int NOT_VARIABLE = 1055;
   public static final int NOT_CLASS_ATTR = 106;
   public static final int NOT_INSTANCE_ATTR = 107;
   public static final int NOT_CLASS_METHOD = 108;
   public static final int NOT_INSTANCE_METHOD = 109;
   public static final int ATTR_INCORRECT_TYPE = 110;
   public static final int METHOD_INCORRECT_RETURN_TYPE = 111;
   public static final int METHOD_TIMEOUT = 200;
   public static final int METHOD_INACCESSIBLE = 201;
   public static final int METHOD_INCORRECTLY_DEFINED = 202;
   public static final int CLASS_NAME_INCORRECTLY_DEFINED = 208;
   public static final int INTERFACE_INCORRECTLY_DEFINED = 209;
   public static final int SUB_CLASS_INCORRECTLY_DEFINED = 210;
   public static final int ABSTRACT_CLASS_INCORRECTLY_DEFINED = 211;
   public static final int ERROR_ANOTHER_CLASS_NOT_DEFINED = 212;
   public static final int RETURNS_NULL = 400;
   public static final int RETURNS_INVALID_VALUE = 401;
   public static final int RETURNS_INCOMPLETE_VALUE = 404;
   public static final int RETURNS_INCORRECT_VALUE = 402;
   public static final int RETURNS_INCORRECT_FORMAT = 403;
   public static final int ERROR_CONSTRUCTOR = 500;
   public static final int ERROR_ANOTHER_CONSTRUCTOR = 409;
   public static final int ERROR_METHOD = 501;
   public static final int ERROR_VALID_INPUT = 502;
   public static final int ERROR_INVALID_INPUT = 503;
   public static final int CONSTRUCTOR_INCOMPLETE = 603;
   public static final int METHOD_INCORRECTLY_ALTERS_STATE = 605;
   public static final int ABSTRACT_CLASS_INSTANTIATION = 900;

   public static String comment(int code) {
      return comment(code, "value");
   }

   public static String comment(int code, boolean partial) {
      if (partial) {
         String string = comment(code, "value");
         return Character.toLowerCase(string.charAt(0)) + string.substring(1);
      } else {
         return comment(code, "value");
      }
   }

   protected static String comment(int code, String name) {
      String comment = "";
      switch(code) {
      case 0:
         comment = "Ok";
         break;
      case 100:
         comment = "Is not defined";
         break;
      case 101:
         comment = "Does not have private access";
         break;
      case 102:
         comment = "Does not have protected access";
         break;
      case 103:
         comment = "Does not have public access";
         break;
      case 105:
         comment = "Does not have final modifier";
         break;
      case 106:
         comment = "Is not a class attribute";
         break;
      case 107:
         comment = "Is not an instance attribute";
         break;
      case 108:
         comment = "Is not a class method";
         break;
      case 110:
         comment = "Does not have anticipated type";
         break;
      case 111:
         comment = "Does not return anticipated type";
         break;
      case 150:
         comment = "Does not have private nor protected access";
         break;
      case 200:
         comment = "Takes too long to execute";
         break;
      case 201:
         comment = "Is not accessible by the tester";
         break;
      case 202:
         comment = "Does not accept required arguments";
         break;
      case 208:
         comment = "Does have the anticipated name";
         break;
      case 209:
         comment = "Does have the anticipated interface modifiers";
         break;
      case 210:
         comment = "Does have the anticipated super type";
         break;
      case 211:
         comment = "Does have the anticipated abstract modifier";
         break;
      case 212:
         comment = "Another class is not defined";
         break;
      case 400:
         comment = "Returns null";
         break;
      case 401:
         comment = "Returns abnormal values";
         break;
      case 402:
         comment = "Returns incorrect values";
         break;
      case 403:
         comment = "Returns correct information in an incorrect format";
         break;
      case 404:
         comment = "Returns some values but not all";
         break;
      case 409:
         comment = "Another constructor does not create instances successfully";
         break;
      case 500:
         comment = "Does not create instances successfully";
         break;
      case 501:
         comment = "Does not work as anticipated";
         break;
      case 502:
         comment = "Does not work as anticipated for valid inputs";
         break;
      case 503:
         comment = "Does not work as anticipated for invalid inputs";
         break;
      case 603:
         comment = "Does not initialize the {} attribute";
         break;
      case 605:
         comment = "Does not alter the {} attribute as it should";
         break;
      case 900:
         comment = "Class is abstract thus its constructor cannot be invoked";
         break;
      case 1055:
         comment = "Should not have final modifier ";
         break;
      default:
         comment = "Something went wrong";
      }

      return comment.replace("{}", name);
   }

   public static String meaning(int code) {
      switch(code) {
      case 0:
         return "Your code is defined and behaved as anticipated";
      case 100:
         return "We expect your attribute, method or constructor to be defined in a particular way, but yours isn't or not defined at all";
      case 101:
         return "We expect your attribute, method or constructor to have the private keyword indicating that it has private access, but yours doesn't";
      case 102:
         return "We expect your attribute, method or constructor to have the protected keyword indicating that it has protected access, but yours doesn't";
      case 103:
         return "We expect your attribute, method or constructor to have the public keyword indicating that it has public access, but yours doesn't";
      case 105:
         return "We expect your attribute or method to have the final keyword indicating that it is a constant attribute or an un-overridable method, but yours doesn't";
      case 106:
         return "We expect your attribute to be defined with the static keyword indicating that it is a class attribute, but yours isn't";
      case 107:
         return "We expect your attribute to be defined without the static keyword indicating that it is an instance attribute, but yours isn't";
      case 108:
         return "We expect your method to be defined with the static keyword indicating that it is an class method, but yours isn't";
      case 110:
         return "We expect your attribute to be defined with a particular type, but yours isn't";
      case 111:
         return "We expect your method to be defined with a particular return type, but yours isn't";
      case 150:
         return "We expect your attribute, method or constructor to have the private or protected keyword indicating that it has private or protected access, but yours doesn't";
      case 200:
         return "We expect your method to run within a reasonable amount of time, but yours didn't; it may contain infinite loops or other functionality that makes it take an unreasonable time to run";
      case 201:
         return "We expect your method to be public so that we can test it from an outside folder, but yours isn't";
      case 202:
         return "We expect your method to be defined with the particular argument types in a particular order, but yours isn't";
      case 208:
      case 209:
      case 210:
      case 211:
         return "We expect your class to be defined with the particular name, super type, interfaces or access modifiers, but yours isn't";
      case 212:
         return "We expect another class to be defined with a particular name, but yours isn't.";
      case 400:
         return "We expect your method to return an object, but instead yours returns null";
      case 401:
         return "We expect your method to return a particular value, but instead yours returns a value that is not feasible nor valid";
      case 402:
         return "We expect your method to return a particular value, but instead yours returns another incorrect one";
      case 403:
         return "We expect your method to return a particular value in a given format, but instead yours returns the value in another format";
      case 404:
         return "We expect your method to return a set of values, but instead yours returns only some";
      case 409:
         return "We expect a constructor from another class to create objects without problems, but instead that constructor contains bad code that creates problems";
      case 500:
         return "We expect your constructor to create objects without problems, but instead yours contains bad code that creates problems";
      case 501:
         return "We expect your method to run without problems, but instead yours contains bad code that creates problems";
      case 502:
         return "We expect your method to work in a particular way (and possibly return an anticipated value) when given valid inputs, but yours doesn't";
      case 503:
         return "We expect your method to work in a particular way (and possibly return an anticipated value) when given bad inputs, but yours doesn't";
      case 603:
         return "We expect your constructor to initialize a particular set of instance attributes, but yours doesn't";
      case 605:
         return "We expect your method to change the values of a particular set of instance attributes, but yours doesn't, or it does it in an unanticipated way";
      case 900:
         return "We expect your class to be concrete, but instead yours is abstract and its constructor cannot be invoked";
      case 1055:
         return "We expect your attribute or method to be defined without the final keyword, but yours is";
      default:
         return "Something went wrong";
      }
   }
}
