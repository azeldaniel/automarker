/* Decompiler 75ms, total 172ms, lines 156 */
package com.azeldaniel.automarker.marker;

import java.lang.reflect.InvocationTargetException;
import org.junit.Assert;

public class Constructor extends Markable {
   private String modifier;
   private Class<?> cls;
   private Class<?>[] parameterTypes;

   private Constructor(double marks) {
      super("Constructor()", marks);
      this.modifier = "public";
      this.parameterTypes = new Class[0];
   }

   public Constructor(String modifier, double marks) {
      this(marks);
      this.modifier = modifier;
   }

   public Constructor(Class<?>[] parameterTypes, double marks) {
      this(marks);
      this.setName(this.generateName(parameterTypes));
      this.parameterTypes = parameterTypes;
   }

   public Constructor(String modifier, Class<?>[] parameterTypes, double marks) {
      this(marks);
      this.setName(this.generateName(parameterTypes));
      this.modifier = modifier;
      this.parameterTypes = parameterTypes;
   }

   public String getModifier() {
      return this.modifier;
   }

   public void setModifier(String modifier) {
      this.modifier = modifier;
   }

   public Class<?>[] getParameterTypes() {
      return this.parameterTypes;
   }

   public void setParameterTypes(Class<?>[] parameterTypes) {
      this.parameterTypes = parameterTypes;
   }

   public Class<?> getCls() {
      return this.cls;
   }

   public void setCls(Class<?> cls) {
      this.cls = cls;
      this.setName(this.generateName(this.parameterTypes));
   }

   private String generateName(Class<?>[] parameterTypes) {
      String details;
      if (this.cls != null) {
         details = this.cls.getSimpleName() + "(";
      } else {
         details = "Constructor(";
      }

      Class[] var6 = parameterTypes;
      int var5 = parameterTypes.length;

      for (int var4 = 0; var4 < var5; ++var4) {
         Class<?> cls2 = var6[var4];
         if (cls2 != null) {
            details = details + cls2.getSimpleName() + ", ";
         } else {
            details = details + "<Missing Class>, ";
         }
      }

      if (details.endsWith(", ")) {
         details = details.substring(0, details.length() - 2);
      }

      return details + ")";
   }

   public String toString() {
      return this.getModifier() + " " + this.getName();
   }

   public String repr() {
      return this.getName();
   }

   public void assertCreates() {
      this.assertCreates(new Object[0], 0.0D);
   }

   public void assertCreates(Object[] args) {
      this.assertCreates(args, 0.0D);
   }

   public void assertCreates(Object[] args, double mark) {
      if (args.length == 0) {
         this.getMarker().addLog("Check <" + this.getName() + "> constructor creates instances");
      } else {
         this.getMarker().addLog(
               "Check <" + this.getName() + "> constructor creates instances with args <(" + getRepr(args) + ")>");
      }

      String message = "";

      this.getMarker();
      java.lang.reflect.Constructor<?> c = Marker.getConstructor(this.cls, this.getParameterTypes());
      Assert.assertNotNull(
            this.formatAssert("Is not testable as the class's constructor " + Commenter.comment(100, true),
                  Commenter.meaning(100), mark),
            c);

      try {
         this.getMarker().setObject(c.newInstance(args));
      } catch (InvocationTargetException e) {
         message = e.getTargetException().toString();
         Assert.assertTrue(this.formatAssert(
               "Is not testable as the class's constructor " + Commenter.comment(501, true) + ": produced " + message,
               Commenter.meaning(501), mark), false);
      } catch (IllegalAccessException e) {
         message = e.toString();
         Assert.assertTrue(this.formatAssert(
               "Is not testable as the class's constructor " + Commenter.comment(103, true) + ": produced " + message,
               Commenter.meaning(103), mark), false);
      } catch (IllegalArgumentException e) {
         message = e.toString();
         Assert.assertTrue(this.formatAssert(
               "Is not testable as the class's constructor " + Commenter.comment(202, true) + ": produced " + message,
               Commenter.meaning(202), mark), false);
      } catch (InstantiationException e) {
         message = e.toString();
         Assert.assertTrue(
               this.formatAssert("Is not testable as the " + Commenter.comment(900, true) + ": produced " + message,
                     Commenter.meaning(900), mark),
               false);
      }

   }

   public static String getRepr(Object[] args) {
      String repr = "";
      Object[] var5 = args;
      int var4 = args.length;

      for (int var3 = 0; var3 < var4; ++var3) {
         Object o = var5[var3];
         String str = "<toString() error>";

         try {
            str = o.toString();
         } catch (Error | Exception var8) {
         }

         if (o instanceof String) {
            repr = repr + "\"" + str + "\", ";
         } else {
            repr = repr + str + ", ";
         }
      }

      if (repr.endsWith(", ")) {
         repr = repr.substring(0, repr.length() - 2);
      }

      return repr;
   }
}
