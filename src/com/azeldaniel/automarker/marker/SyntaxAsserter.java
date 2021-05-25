/* Decompiler 253ms, total 374ms, lines 251 */
package com.azeldaniel.automarker.marker;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.Assert;

public class SyntaxAsserter {
   private Class<?> cls;
   private Marker marker;

   protected SyntaxAsserter(Class<?> cls, Marker marker) {
      this.cls = cls;
      this.marker = marker;
   }

   public void assertClassDefined(MarkableClass markableClass) {
      String cl = "class";
      if (markableClass.isInterface()) {
         cl = "interface";
      }

      this.marker.addLog("Check <" + markableClass.toString() + "> " + cl + " exists and defined properly");
      Assert.assertTrue(this.formatAssert(Commenter.comment(208), Commenter.meaning(208)),
            markableClass.getName().contains(this.cls.getSimpleName()));
      Assert.assertTrue(this.formatAssert(Commenter.comment(209), Commenter.meaning(209)),
            markableClass.isInterface() == this.cls.isInterface());
      if (markableClass.getSuperClass() != null) {
         Assert.assertTrue(this.formatAssert(Commenter.comment(210), Commenter.meaning(210)),
               markableClass.getSuperClass().equals(this.cls.getSuperclass()));
      }

   }

   public void assertAttributeDefined(Attribute attribute) {
      this.assertAttributeDefined(attribute, false);
   }

   public void assertHelperAttributeDefined(Attribute attribute) {
      this.assertAttributeDefined(attribute, true);
   }

   private void assertAttributeDefined(Attribute attribute, boolean indirect) {
      Field[] fields = this.cls.getDeclaredFields();
      String indirectText = "";
      if (indirect) {
         indirectText = "Is not testable because testing relies on the " + attribute.getName() + " attribute that ";
         this.marker.addLog("Check <" + attribute.repr() + "> attribute exists");
      } else {
         this.marker.addLog("Check <" + attribute.toString() + "> attribute exists and defined properly");
      }

      boolean defined = false;

      for (int i = 0; i < fields.length; ++i) {
         if (fields[i].getName().equals(attribute.getName())) {
            defined = true;
            Assert.assertEquals(
                  this.formatAssert(indirectText + Commenter.comment(110, indirect), Commenter.meaning(110)),
                  attribute.getType(), fields[i].getType());
            if (!indirect) {
               boolean flag = false;
               if (Arrays.asList(attribute.getModifiers()).contains("private")
                     && Arrays.asList(attribute.getModifiers()).contains("protected")) {
                  flag = true;
                  if (!Modifier.isPrivate(fields[i].getModifiers())
                        && !Modifier.isProtected(fields[i].getModifiers())) {
                     Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(150, indirect),
                           Commenter.meaning(150), attribute.getMarks() / 2.0D), false);
                  }
               }

               if (Arrays.asList(attribute.getModifiers()).contains("private")
                     && Arrays.asList(attribute.getModifiers()).contains("public")) {
                  flag = true;
               }

               if (Arrays.asList(attribute.getModifiers()).contains("protected")
                     && Arrays.asList(attribute.getModifiers()).contains("public")) {
                  flag = true;
               }

               if (!flag) {
                  if (Arrays.asList(attribute.getModifiers()).contains("private")
                        && !Modifier.isPrivate(fields[i].getModifiers())) {
                     Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(101, indirect),
                           Commenter.meaning(101), attribute.getMarks() / 2.0D), false);
                  }

                  if (Arrays.asList(attribute.getModifiers()).contains("public")
                        && !Modifier.isPublic(fields[i].getModifiers())) {
                     Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(103, indirect),
                           Commenter.meaning(103), attribute.getMarks() / 2.0D), false);
                  }

                  if (Arrays.asList(attribute.getModifiers()).contains("protected")
                        && !Modifier.isProtected(fields[i].getModifiers())) {
                     Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(102, indirect),
                           Commenter.meaning(102), attribute.getMarks() / 2.0D), false);
                  }

                  if (Arrays.asList(attribute.getModifiers()).contains("final")
                        && !Modifier.isFinal(fields[i].getModifiers())) {
                     Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(105, indirect),
                           Commenter.meaning(105), attribute.getMarks() / 2.0D), false);
                  }

                  if (!Arrays.asList(attribute.getModifiers()).contains("final")
                        && Modifier.isFinal(fields[i].getModifiers())) {
                     Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(1055, indirect),
                           Commenter.meaning(1055), attribute.getMarks() / 2.0D), false);
                  }
               }
            }

            if (Arrays.asList(attribute.getModifiers()).contains("static")
                  && !Modifier.isStatic(fields[i].getModifiers())) {
               Assert.assertTrue(
                     this.formatAssert(indirectText + Commenter.comment(106, indirect), Commenter.meaning(106)), false);
            }

            if (!Arrays.asList(attribute.getModifiers()).contains("static")
                  && Modifier.isStatic(fields[i].getModifiers())) {
               Assert.assertTrue(
                     this.formatAssert(indirectText + Commenter.comment(107, indirect), Commenter.meaning(107)), false);
            }
         }
      }

      Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(100, indirect), Commenter.meaning(100)),
            defined);
   }

   public void assertMethodDefined(Method method) {
      this.assertMethodDefined(method, false);
   }

   public void assertHelperMethodDefined(Method method) {
      this.assertMethodDefined(method, true);
   }

   private void assertMethodDefined(Method method, boolean indirect) {
      String indirectText = "";
      if (indirect) {
         indirectText = "Is not testable because testing relies on the " + method.getName() + " method that ";
         this.marker.addLog("Check <" + method.repr() + "> method exists and is accessible");
      } else {
         this.marker.addLog("Check <" + method.toString() + "> method exists and defined properly");
      }

      java.lang.reflect.Method[] methods = this.cls.getDeclaredMethods();
      boolean defined = false;

      for (int i = 0; i < methods.length; ++i) {
         if (methods[i].getName().equals(method.getName())
               && methods[i].getParameterTypes().length == method.getParameterTypes().length) {
            defined = true;
            if (method.isCheckReturnType())
               Assert.assertEquals(
                     this.formatAssert(indirectText + Commenter.comment(111, indirect), Commenter.meaning(111)),
                     method.getReturnType(), methods[i].getReturnType());
            Assert.assertArrayEquals(
                  this.formatAssert(indirectText + Commenter.comment(202, indirect), Commenter.meaning(202)),
                  method.getParameterTypes(), methods[i].getParameterTypes());
            if (!indirect) {
               boolean flag = false;
               if (Arrays.asList(method.getModifiers()).contains("private")
                     && Arrays.asList(method.getModifiers()).contains("protected")
                     && !Modifier.isPrivate(methods[i].getModifiers())
                     && !Modifier.isProtected(methods[i].getModifiers())) {
                  flag = true;
                  Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(150, indirect),
                        Commenter.meaning(150), method.getMarks() / 2.0D), false);
               }

               if (Arrays.asList(method.getModifiers()).contains("private")
                     && Arrays.asList(method.getModifiers()).contains("public")) {
                  flag = true;
               }

               if (Arrays.asList(method.getModifiers()).contains("protected")
                     && Arrays.asList(method.getModifiers()).contains("public")) {
                  flag = true;
               }

               if (!flag) {
                  if (Arrays.asList(method.getModifiers()).contains("private")
                        && !Modifier.isPrivate(methods[i].getModifiers())) {
                     Assert.assertTrue(
                           this.formatAssert(indirectText + Commenter.comment(101, indirect), Commenter.meaning(101)),
                           false);
                  }

                  if (Arrays.asList(method.getModifiers()).contains("public")
                        && !Modifier.isPublic(methods[i].getModifiers())) {
                     Assert.assertTrue(
                           this.formatAssert(indirectText + Commenter.comment(103, indirect), Commenter.meaning(103)),
                           false);
                  }

                  if (Arrays.asList(method.getModifiers()).contains("protected")
                        && !Modifier.isProtected(methods[i].getModifiers())) {
                     Assert.assertTrue(
                           this.formatAssert(indirectText + Commenter.comment(102, indirect), Commenter.meaning(102)),
                           false);
                  }
               }

               if (Arrays.asList(method.getModifiers()).contains("static")
                     && !Modifier.isStatic(methods[i].getModifiers())) {
                  Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(108, indirect),
                        Commenter.meaning(108), method.getMarks() / 2.0D), false);
               }

               if (!Arrays.asList(method.getModifiers()).contains("static")
                     && Modifier.isStatic(methods[i].getModifiers())) {
                  Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(109, indirect),
                        Commenter.meaning(109), method.getMarks() / 2.0D), false);
               }

               if (Arrays.asList(method.getModifiers()).contains("final")
                     && !Modifier.isFinal(methods[i].getModifiers())) {
                  Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(105, indirect),
                        Commenter.meaning(105), method.getMarks() / 2.0D), false);
               }

               if (!Arrays.asList(method.getModifiers()).contains("final")
                     && Modifier.isFinal(methods[i].getModifiers())) {
                  Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(1055, indirect),
                        Commenter.meaning(1055), method.getMarks() / 2.0D), false);
               }
            }
         }
      }

      Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(100, indirect), Commenter.meaning(100)),
            defined);
   }

   public void assertConstructorDefined(Constructor constructor) {
      this.assertConstructorDefined(constructor, false);
   }

   public void assertHelperConstructorDefined(Constructor constructor) {
      this.assertConstructorDefined(constructor, true);
   }

   private void assertConstructorDefined(Constructor constructor, boolean indirect) {
      String indirectText = "";
      if (indirect) {
         indirectText = "Is not testable because testing relies on a constructor that ";
         this.marker.addLog("Check <" + constructor.repr() + "> constructor exists and is accessible");
      } else {
         this.marker.addLog("Check <" + constructor.toString() + "> constructor exists and defined properly");
      }

      boolean defined = false;
      java.lang.reflect.Constructor[] constructors = null;

      try {
         constructors = this.cls.getDeclaredConstructors();
      } catch (NoClassDefFoundError var7) {
         Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(100, indirect), Commenter.meaning(100)),
               false);
      }

      for (int i = 0; i < constructors.length; ++i) {
         if (Arrays.equals(constructors[i].getParameterTypes(), constructor.getParameterTypes())) {
            defined = true;
            if (!indirect) {
               if (constructor.getModifier().equals("private") && !Modifier.isPrivate(constructors[i].getModifiers())) {
                  Assert.assertTrue(
                        this.formatAssert(indirectText + Commenter.comment(101, indirect), Commenter.meaning(101)),
                        false);
               }

               if (constructor.getModifier().equals("public") && !Modifier.isPublic(constructors[i].getModifiers())) {
                  System.out.println("Constructor error detected");
                  Assert.assertTrue(
                        this.formatAssert(indirectText + Commenter.comment(103, indirect), Commenter.meaning(103)),
                        false);
               }

               if (constructor.getModifier().equals("protected")
                     && !Modifier.isProtected(constructors[i].getModifiers())) {
                  Assert.assertTrue(
                        this.formatAssert(indirectText + Commenter.comment(102, indirect), Commenter.meaning(102)),
                        false);
               }
            }
         }
      }

      Assert.assertTrue(this.formatAssert(indirectText + Commenter.comment(100, indirect), Commenter.meaning(100)),
            defined);
   }

   public String formatAssert(String comment, String meaning) {
      return this.formatAssert(comment, meaning, 0.0D);
   }

   public String formatAssert(String comment, String meaning, double mark) {
      this.marker.updateMark(mark);
      return this.marker.getActual().repr() + "|" + this.marker.getActual().toString() + "|" + comment + "|" + meaning
            + "|" + this.marker.getMark() + "|" + this.marker.getActual().getMarks();
   }

   public Class<?> getCls() {
      return this.cls;
   }

   public void setCls(Class<?> cls) {
      this.cls = cls;
   }
}
