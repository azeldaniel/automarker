/* Decompiler 283ms, total 397ms, lines 393 */
package com.azeldaniel.automarker.marker;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.StringContains;
import org.junit.Assert;

public class Method extends Markable {
   private Class<?> returnType;
   private String[] modifiers;
   private Class<?>[] parameterTypes;
   private Object ret;
   private String message;
   private boolean interrupted;
   private boolean invocationException;
   private boolean illegalAccessException;
   private boolean illegalArgumentException;
   private boolean checkReturnType = true;

   public boolean isCheckReturnType() {
      return checkReturnType;
   }

   public Method setCheckReturnType(boolean checkReturnType) {
      this.checkReturnType = checkReturnType;
      return this;
   }

   public Method(String name, double marks) {
      super(name, marks);
      this.message = "";
      this.interrupted = false;
      this.invocationException = false;
      this.illegalAccessException = false;
      this.illegalArgumentException = false;
      this.returnType = Void.TYPE;
      this.modifiers = new String[] { "public" };
      this.parameterTypes = new Class[0];
   }

   public Method(String name, Class<?> returnType, double marks) {
      this(name, marks);
      this.returnType = returnType;
   }

   public Method(String name, String[] modifiers, double marks) {
      this(name, marks);
      this.modifiers = modifiers;
      if (!Arrays.asList(modifiers).contains("public") && !Arrays.asList(modifiers).contains("private")
            && !Arrays.asList(modifiers).contains("protected")) {
         this.modifiers = this.addElement(modifiers, "public");
      }

   }

   public Method(String name, Class<?>[] parameterTypes, double marks) {
      this(name, marks);
      this.parameterTypes = parameterTypes;
   }

   public Method(String name, Class<?> returnType, String[] modifiers, double marks) {
      this(name, modifiers, marks);
      this.returnType = returnType;
   }

   public Method(String name, Class<?> returnType, Class<?>[] parameterTypes, double marks) {
      this(name, marks);
      this.returnType = returnType;
      this.parameterTypes = parameterTypes;
   }

   public Method(String name, Class<?> returnType, String[] modifiers, Class<?>[] parameterTypes, double marks) {
      this(name, modifiers, marks);
      this.returnType = returnType;
      this.parameterTypes = parameterTypes;
   }

   public Class<?> getReturnType() {
      return this.returnType;
   }

   public void setReturnType(Class<?> returnType) {
      this.returnType = returnType;
   }

   public String[] getModifiers() {
      return this.modifiers;
   }

   public void setModifiers(String[] modifiers) {
      this.modifiers = modifiers;
   }

   public Class<?>[] getParameterTypes() {
      return this.parameterTypes;
   }

   public void setParameterTypes(Class<?>[] parameterTypes) {
      this.parameterTypes = parameterTypes;
   }

   public String toString() {
      String details = "";
      String[] var5;
      int var4 = (var5 = this.getModifiers()).length;

      int var3;
      for (var3 = 0; var3 < var4; ++var3) {
         String mod = var5[var3];
         details = details + mod + " ";
      }

      details = details + this.getReturnType().getSimpleName() + " " + this.getName() + "(";
      Class[] var7;
      var4 = (var7 = this.getParameterTypes()).length;

      for (var3 = 0; var3 < var4; ++var3) {
         Class<?> param = var7[var3];
         details = details + param.getSimpleName() + ", ";
      }

      details = details + ")";
      return details.replace(", )", ")");
   }

   public String repr() {
      String details = this.getName() + "(";
      Class[] var5;
      int var4 = (var5 = this.getParameterTypes()).length;

      for (int var3 = 0; var3 < var4; ++var3) {
         Class<?> param = var5[var3];
         details = details + param.getSimpleName() + ", ";
      }

      details = details + ")";
      return details.replace(", )", ")");
   }

   private String[] addElement(String[] org, String added) {
      String[] newArray = new String[org.length + 1];
      System.arraycopy(org, 0, newArray, 1, org.length);
      newArray[0] = added;
      return newArray;
   }

   public <T> void assertRuns() {
      this.assertReturns(this.getName(), new Object[0], (Matcher) null, 501, 0.0D,
            !this.getMarker().getActual().equals(this), false);
   }

   public <T> void assertRuns(double marks) {
      this.assertReturns(this.getName(), new Object[0], (Matcher) null, 501, marks,
            !this.getMarker().getActual().equals(this), false);
   }

   public <T> void assertRuns(Object[] args) {
      this.assertReturns(this.getName(), args, (Matcher) null, 501, 0.0D, !this.getMarker().getActual().equals(this),
            false);
   }

   public <T> void assertRuns(Object[] args, double marks) {
      this.assertReturns(this.getName(), args, (Matcher) null, 501, marks, !this.getMarker().getActual().equals(this),
            false);
   }

   public <T> void assertReturns(Matcher<T> matcher, int comment) {
      this.assertReturns(this.getName(), new Object[0], matcher, comment, 0.0D,
            !this.getMarker().getActual().equals(this), false);
   }

   public <T> void assertReturns(Matcher<T> matcher, int comment, double marks) {
      this.assertReturns(this.getName(), new Object[0], matcher, comment, marks,
            !this.getMarker().getActual().equals(this), false);
   }

   public <T> void assertReturns(Object[] args, Matcher<T> matcher, int comment) {
      this.assertReturns(this.getName(), args, matcher, comment, 0.0D, !this.getMarker().getActual().equals(this),
            false);
   }

   public <T> void assertReturns(Object[] args, Matcher<T> matcher, int comment, double marks) {
      this.assertReturns(this.getName(), args, matcher, comment, marks, !this.getMarker().getActual().equals(this),
            false);
   }

   private <T> void assertReturns(String name, Object[] args, Matcher<T> matcher, int comment, double mark,
         boolean indirect, boolean alreadyLogged) {
      if (!alreadyLogged) {
         if (matcher == null) {
            if (args.length == 0) {
               this.getMarker().addLog("Check <" + this.repr() + "> method runs");
            } else {
               this.getMarker()
                     .addLog("Check <" + this.repr() + "> method runs with args <(" + this.getRepr(args) + ")>");
            }
         } else {
            String str = "<toString() error>";

            try {
               str = matcher.toString();
            } catch (Error | Exception var16) {
            }

            if (args.length == 0) {
               this.getMarker().addLog(
                     "Check <" + this.repr() + "> method returns <" + str.replace("<", "").replace(">", "") + ">");
            } else {
               this.getMarker().addLog("Check <" + this.repr() + "> method returns <"
                     + str.replace("<", "").replace(">", "") + "> with args <(" + this.getRepr(args) + ")>");
            }
         }
      }

      java.lang.reflect.Method m = this.getMarker().getMethod(name);
      String indirectText = "";
      if (indirect) {
         indirectText = "Cannot be further tested because testing relies on the " + name + " method that ";
      }

      this.ret = null;
      this.message = "";
      this.interrupted = false;
      this.invocationException = false;
      this.illegalAccessException = false;
      this.illegalArgumentException = false;
      Thread thread = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               ret = m.invoke(getMarker().getObject(), args);
            } catch (InvocationTargetException e) {
               invocationException = true;
               message = e.getTargetException().toString();
            } catch (IllegalAccessException e) {
               illegalAccessException = true;
               message = e.toString();
            } catch (IllegalArgumentException e) {
               illegalArgumentException = true;
               message = e.toString();
            }
         }
      });

      try {
         thread.start();
         Timer timer = new Timer();
         timer.schedule(new java.util.TimerTask() {
            @Override
            @SuppressWarnings("deprecation")
            public void run() {
               thread.stop();
               timer.cancel();
               interrupted = true;
            }
         }, 10000);
         thread.join();
         if (this.interrupted) {
            Assert.assertTrue(
                  this.formatAssert(indirectText + Commenter.comment(200, indirect), Commenter.meaning(200)), false);
            this.interrupted = false;
         }

         if (this.invocationException) {
            Assert.assertTrue(
                  this.formatAssert(indirectText + Commenter.comment(501, indirect) + ": produced " + this.message,
                        Commenter.meaning(501)),
                  false);
            this.invocationException = false;
         }

         if (this.illegalAccessException) {
            Assert.assertTrue(
                  this.formatAssert(indirectText + Commenter.comment(201, indirect), Commenter.meaning(201)), false);
            this.illegalAccessException = false;
         }

         if (this.illegalArgumentException) {
            Assert.assertTrue(
                  this.formatAssert(indirectText + Commenter.comment(202, indirect), Commenter.meaning(202)), false);
            this.illegalArgumentException = false;
         }

         if (matcher != null) {
            if (this.ret instanceof String) {
               this.ret = ((String) this.ret).trim();
            }

            try {
               MatcherAssert.assertThat(this.formatAssert(indirectText + Commenter.comment(comment, indirect),
                     Commenter.meaning(comment), mark), (T) this.ret, matcher);
            } catch (StackOverflowError | ClassCastException | NullPointerException var14) {
            }
         }
      } catch (InterruptedException var15) {
      }

   }

   public <T> void assertReturnsStringContainingAttribute(String attrName, int comment) {
      this.assertReturnsStringContainingAttribute(attrName, new Object[0], comment, 0.0D);
   }

   public <T> void assertReturnsStringContainingAttribute(String attrName, int comment, double mark) {
      this.assertReturnsStringContainingAttribute(attrName, new Object[0], comment, mark);
   }

   public <T> void assertReturnsStringContainingAttribute(String attrName, Object[] args, int comment) {
      this.assertReturnsStringContainingAttribute(attrName, args, comment, 0.0D);
   }

   public <T> void assertReturnsStringContainingAttribute(String attrName, Object[] args, int comment, double mark) {
      if (args.length == 0) {
         this.getMarker()
               .addLog("Check <" + this.repr() + "> method returns string containing attribute <" + attrName + ">");
      } else {
         this.getMarker().addLog("Check <" + this.repr() + "> method returns string containing attribute <" + attrName
               + "> with args <(" + this.getRepr(args) + ")>");
      }

      Object attr = this.getMarker().getAttribute(attrName);
      String str = "";
      if (attr != null) {
         if (attr.getClass().isArray()) {
            Object[] arr = (Object[]) attr;
            Object[] var12 = arr;
            int var11 = arr.length;

            for (int var10 = 0; var10 < var11; ++var10) {
               Object a = var12[var10];
               if (a != null) {
                  str = str + a.toString() + "\n";
               }
            }
         } else {
            str = attr.toString();
         }
      }

      this.assertReturns(this.getName(), args, StringContains.containsString(str.trim()), comment, mark, false, true);
   }

   public <T> void assertReturnsValueEqualToAttribute(String attrName, int comment) {
      this.assertReturnsValueEqualToAttribute(attrName, new Object[0], comment, 0.0D);
   }

   public <T> void assertReturnsValueEqualToAttribute(String attrName, int comment, double mark) {
      this.assertReturnsValueEqualToAttribute(attrName, new Object[0], comment, mark);
   }

   public <T> void assertReturnsValueEqualToAttribute(String attrName, Object[] args, int comment) {
      this.assertReturnsValueEqualToAttribute(attrName, args, comment, 0.0D);
   }

   public <T> void assertReturnsValueEqualToAttribute(String attrName, Object[] args, int comment, double mark) {
      if (args.length == 0) {
         this.getMarker()
               .addLog("Check <" + this.repr() + "> method returns value equal to attribute <" + attrName + ">");
      } else {
         this.getMarker().addLog("Check <" + this.repr() + "> method returns value equal to attribute <" + attrName
               + "> with args <(" + this.getRepr(args) + ")>");
      }

      Object attr = this.getMarker().getAttribute(attrName);
      this.assertReturns(this.getName(), args, IsEqual.equalTo(attr), comment, mark, false, true);
   }

   public <T> void assertReturnsStringContainingAttributeInFormat(String attrName, String format, int comment) {
      this.assertReturnsStringContainingAttributeInFormat(attrName, format, new Object[0], comment, 0.0D);
   }

   public <T> void assertReturnsStringContainingAttributeInFormat(String attrName, String format, int comment,
         double mark) {
      this.assertReturnsStringContainingAttributeInFormat(attrName, format, new Object[0], comment, mark);
   }

   private String formatAttrName(String attrName) {
      try {
         Object attr = this.getMarker().getAttribute(attrName);
         if (attr != null && attr.getClass().isArray()) {
            return "\"" + attrName.substring(0, attrName.length() - 1) + "_1.toString() \\n "
                  + attrName.substring(0, attrName.length() - 1) + "_2.toString() \\n ... "
                  + attrName.substring(0, attrName.length() - 1) + "_n.toString()\"";
         }
      } catch (Exception var3) {
      }

      return attrName;
   }

   public <T> void assertReturnsStringContainingAttributeInFormat(String attrName, String format, Object[] args,
         int comment, double mark) {
      if (args.length == 0) {
         this.getMarker().addLog("Check <" + this.repr() + "> method returns string containing attribute <" + attrName
               + "> in format <" + format.replace("{}", this.formatAttrName(attrName)) + ">");
      } else {
         this.getMarker()
               .addLog("Check <" + this.repr() + "> method returns string containing attribute <" + attrName
                     + "> in format <" + format.replace("{}", this.formatAttrName(attrName)) + "> with args <("
                     + this.getRepr(args) + ")>");
      }

      Object attr = this.getMarker().getAttribute(attrName);
      String str = "";
      if (attr != null) {
         if (attr.getClass().isArray()) {
            Object[] arr = (Object[]) attr;
            Object[] var13 = arr;
            int var12 = arr.length;

            for (int var11 = 0; var11 < var12; ++var11) {
               Object a = var13[var11];
               if (a != null) {
                  str = str + a + "\n";
               }
            }
         } else {
            str = "" + attr;
         }
      }

      String search = format.replace("{}", str.trim());
      this.assertReturns(this.getName(), args, StringContains.containsString(search), comment, mark, false, true);
   }

   private String getRepr(Object[] args) {
      String repr = "";
      Object[] var6 = args;
      int var5 = args.length;

      for (int var4 = 0; var4 < var5; ++var4) {
         Object o = var6[var4];
         String str = "<toString() error>";

         try {
            str = o.toString();
         } catch (Error | Exception var9) {
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
