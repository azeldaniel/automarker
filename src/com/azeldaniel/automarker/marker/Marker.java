/* Decompiler 416ms, total 562ms, lines 458 */
package com.azeldaniel.automarker.marker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class Marker {
   private SyntaxAsserter syntax = new SyntaxAsserter((Class) null, this);
   private HashMap<String, List<JSONObject>> logs = new HashMap();
   private HashMap<String, Markable> markables = new HashMap();
   private Class<?> thisClass;
   private Markable markable;
   private Object object;
   private double mark;
   private double lastMark;

   public void add(Markable markable) {
      this.markables.put(markable.getName(), markable);
   }

   public MarkableClass cls() {
      Iterator var2 = this.markables.values().iterator();

      while (var2.hasNext()) {
         Markable m = (Markable) var2.next();
         if (m instanceof MarkableClass) {
            return (MarkableClass) m;
         }
      }

      return null;
   }

   public void validate(Class<?> testClass, String className) {
      double total = 0.0D;

      Markable markable;
      for (Iterator var6 = this.markables.values().iterator(); var6.hasNext(); total += markable.getMarks()) {
         markable = (Markable) var6.next();
      }

      try {
         Class<?> cls = Class.forName(testClass.getPackage().toString().replace("package ", "") + "." + className);
         this.thisClass = cls;
         this.syntax.setCls(cls);
         this.markables.forEach((key, markablex) -> {
            markablex.setMarker(this);
            if (markablex instanceof Constructor) {
               ((Constructor) markablex).setCls(cls);
            }

            if (markablex instanceof MarkableClass) {
               markablex.setName(cls.getSimpleName());
            }

         });
      } catch (ClassNotFoundException var7) {
         Assert.assertTrue(className + "|Class not found|Class not found|Could not find the " + className
               + " class or your submission did not compile properly|0|" + total, false);
      }

   }

   public void startBonus(Markable actual, Markable[] helpers) {
      actual.setBonus(true);
      this.start(actual, helpers, true);
   }

   public void start(Markable actual) {
      this.start(actual, new Markable[0], false);
   }

   public void start(Markable actual, Markable[] helpers) {
      this.start(actual, helpers, false);
   }

   private void start(Markable actual, Markable[] helpers, boolean isBonus) {
      if (!isBonus) {
         actual.setBonus(false);
      }

      this.markable = actual;
      this.mark = 0.0D;
      this.lastMark = 0.0D;
      this.logs.put(actual.repr(), new ArrayList());
      Markable[] var7 = helpers;
      int var6 = helpers.length;

      for (int var5 = 0; var5 < var6; ++var5) {
         Markable helper = var7[var5];
         if (helper instanceof Constructor) {
            this.syntax.assertHelperConstructorDefined((Constructor) helper);
         }

         if (helper instanceof Method) {
            this.syntax.assertHelperMethodDefined((Method) helper);
         }

         if (helper instanceof Attribute) {
            this.syntax.assertHelperAttributeDefined((Attribute) helper);
         }
      }

      if (actual instanceof MarkableClass) {
         this.syntax.assertClassDefined((MarkableClass) actual);
      }

      if (actual instanceof Constructor) {
         this.syntax.assertConstructorDefined((Constructor) actual);
      }

      if (actual instanceof Method) {
         this.syntax.assertMethodDefined((Method) actual);
      }

      if (actual instanceof Attribute) {
         this.syntax.assertAttributeDefined((Attribute) actual);
      }

   }

   public void end() {
      this.end(-1.0D);
   }

   public void end(double bonus) {
      this.mark = 0.0D;
      this.lastMark = 0.0D;
      this.markable.setBonus(false);
      ((List) this.logs.get(this.markable.repr())).replaceAll((obj) -> {
         ((JSONObject) obj).put("result", "Pass");
         return obj;
      });
      if (bonus < 0.0D) {
         this.assertOK();
      } else {
         this.assertBonus(bonus);
      }

   }

   protected void addLog(String log) {
      ((List) this.logs.get(this.markable.repr())).replaceAll((objx) -> {
         ((JSONObject) objx).put("result", "Pass");
         return objx;
      });
      if (((List) this.logs.get(this.markable.repr())).size() != 0 && this.lastMark != 0.0D) {
         JSONObject last = (JSONObject) ((List) this.logs.get(this.markable.repr()))
               .get(((List) this.logs.get(this.markable.repr())).size() - 1);
         last.put("log", last.get("log").toString() + " +" + this.lastMark);
      }

      HashMap<String, Object> obj = new HashMap();
      obj.put("log", log);
      obj.put("result", "Fail");
      ((List) this.logs.get(this.markable.repr())).add(new JSONObject(obj));
   }

   protected void updateMark(double mark) {
      this.mark += this.lastMark;
      this.lastMark = mark;
   }

   public SyntaxAsserter syntax() {
      return this.syntax;
   }

   public Attribute attribute() {
      Attribute a = new Attribute("", Void.TYPE, 0.0D);
      a.setMarker(this);
      return a;
   }

   public Attribute attribute(String name) {
      return (Attribute) this.markables.get(name);
   }

   public Method method(String name) {
      return (Method) this.markables.get(name);
   }

   public Constructor constructor() {
      return this.constructor(new Class[0]);
   }

   public Constructor constructor(Class<?>[] parameterTypes) {
      Iterator var3 = this.markables.values().iterator();

      Markable m;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         m = (Markable) var3.next();
      } while (!(m instanceof Constructor) || !Arrays.equals(((Constructor) m).getParameterTypes(), parameterTypes));

      return (Constructor) m;
   }

   public void report() {
      ArrayList<JSONObject> objects = new ArrayList();
      this.logs.forEach((key, obj) -> {
         HashMap<String, Object> obj2 = new HashMap();
         obj2.put("testName", key);
         obj2.put("testResult", obj);
         objects.add(new JSONObject(obj2));
      });
      Assert.assertTrue(JSONArray.toJSONString(objects), false);
   }

   protected Markable getActual() {
      return this.markable;
   }

   protected void setActual(Markable markable) {
      this.markable = markable;
   }

   public void assertOK() {
      Assert.assertTrue(
            this.getActual().repr() + "|" + this.getActual().toString() + "|" + Commenter.comment(0) + "|"
                  + Commenter.meaning(0) + "|" + this.getActual().getMarks() + "|" + this.getActual().getMarks(),
            false);
   }

   public Class<?> assertOtherClassDefined(Class<?> testClass, String className) {
      this.addLog("Check that " + className + " class exists");
      Class<?> clazz = getClass(testClass, className);
      if (clazz == null) {
         Assert.assertTrue(this.getActual().repr() + "|" + this.getActual().toString() + "|"
               + Commenter.comment(212, true) + "|" + Commenter.meaning(212) + "|0|" + this.getActual().getMarks(),
               false);
      }

      return clazz;
   }

   public void assertError(int comment, boolean partial) {
      Assert.assertTrue(
            this.getActual().repr() + "|" + this.getActual().toString() + "|" + Commenter.comment(comment, partial)
                  + "|" + Commenter.meaning(comment) + "|0|" + this.getActual().getMarks(),
            false);
   }

   public void assertBonus(double marks) {
      Assert.assertTrue(this.getActual().repr() + "|" + this.getActual().toString() + "|" + Commenter.comment(0) + "|"
            + Commenter.meaning(0) + "|" + marks + "|" + 0, false);
   }

   public Object getObject() {
      return this.object;
   }

   protected void setObject(Object object) {
      this.object = object;
   }

   public Object getAttribute(String name) {
      Field[] fields = this.object.getClass().getDeclaredFields();

      for (int i = 0; i < fields.length; ++i) {
         if (fields[i].getName().equals(name)) {
            try {
               boolean isPrivate = fields[i].canAccess(this.object);
               fields[i].setAccessible(true);
               Object obj = fields[i].get(this.object);
               if (isPrivate) {
                  fields[i].setAccessible(false);
               }

               return obj;
            } catch (IllegalAccessException | IllegalArgumentException var6) {
               return null;
            }
         }
      }

      return null;
   }

   public static boolean setClassAttribute(Class<?> testClass, String className, String name, Object value) {
      try {
         Class<?> cls = Class.forName(testClass.getPackage().toString().replace("package ", "") + "." + className);
         Field[] fields = cls.getDeclaredFields();

         for (int i = 0; i < fields.length; ++i) {
            if (fields[i].getName().equals(name)) {
               try {
                  boolean isPrivate = !fields[i].isAccessible();
                  fields[i].setAccessible(true);
                  fields[i].set((Object) null, value);
                  if (isPrivate) {
                     fields[i].setAccessible(false);
                  }

                  return true;
               } catch (IllegalAccessException | NullPointerException | IllegalArgumentException var8) {
                  return false;
               }
            }
         }
      } catch (ClassNotFoundException var9) {
      }

      return false;
   }

   public boolean setAttribute(String name, Object value) {
      Field[] fields = this.object.getClass().getDeclaredFields();

      for (int i = 0; i < fields.length; ++i) {
         if (fields[i].getName().equals(name)) {
            try {
               boolean isPrivate = !fields[i].canAccess(this.object);
               fields[i].setAccessible(true);
               fields[i].set(this.object, value);
               if (isPrivate) {
                  fields[i].setAccessible(false);
               }

               return true;
            } catch (IllegalAccessException | NullPointerException | IllegalArgumentException var6) {
               return false;
            }
         }
      }

      return false;
   }

   public String getFirstAttributeName(Class<?> type) {
      Field[] fields = this.object.getClass().getDeclaredFields();

      for (int i = 0; i < fields.length; ++i) {
         if (fields[i].getType().equals(type)) {
            return fields[i].getName();
         }
      }

      return null;
   }

   public java.lang.reflect.Method getMethod(String name) {
      java.lang.reflect.Method[] methods;
      if (this.object == null) {
         methods = this.thisClass.getDeclaredMethods();
      } else {
         methods = this.object.getClass().getDeclaredMethods();
      }

      for (int i = 0; i < methods.length; ++i) {
         if (methods[i].getName().equals(name)) {
            return methods[i];
         }
      }

      return null;
   }

   public static java.lang.reflect.Constructor<?> getConstructor(Class<?> cls, Class<?>[] args) {
      java.lang.reflect.Constructor[] constructors = cls.getDeclaredConstructors();

      for (int i = 0; i < constructors.length; ++i) {
         if (Arrays.equals(constructors[i].getParameterTypes(), args)) {
            return constructors[i];
         }
      }

      return null;
   }

   public double getMark() {
      return this.mark;
   }

   private static Object convert(Class<?> target, String s) {
      if (target != Object.class && target != String.class && s != null) {
         if (target != Character.class && target != Character.TYPE) {
            if (target != Byte.class && target != Byte.TYPE) {
               if (target != Short.class && target != Short.TYPE) {
                  if (target != Integer.class && target != Integer.TYPE) {
                     if (target != Long.class && target != Long.TYPE) {
                        if (target != Float.class && target != Float.TYPE) {
                           if (target != Double.class && target != Double.TYPE) {
                              if (target != Boolean.class && target != Boolean.TYPE) {
                                 throw new IllegalArgumentException("Don't know how to convert to " + target);
                              } else {
                                 return Boolean.parseBoolean(s);
                              }
                           } else {
                              return Double.parseDouble(s);
                           }
                        } else {
                           return Float.parseFloat(s);
                        }
                     } else {
                        return Long.parseLong(s);
                     }
                  } else {
                     return Integer.parseInt(s);
                  }
               } else {
                  return Short.parseShort(s);
               }
            } else {
               return Byte.parseByte(s);
            }
         } else {
            return s.charAt(0);
         }
      } else {
         return s;
      }
   }

   public static <T> T instantiate(Class<?> clazz, List<String> args) throws Exception {
      java.lang.reflect.Constructor[] var5;
      int var4 = (var5 = clazz.getConstructors()).length;

      for (int var3 = 0; var3 < var4; ++var3) {
         java.lang.reflect.Constructor<?> ctor = var5[var3];
         Class[] paramTypes = ctor.getParameterTypes();
         if (args.size() == paramTypes.length) {
            Object[] convertedArgs = new Object[args.size()];

            for (int i = 0; i < convertedArgs.length; ++i) {
               convertedArgs[i] = convert(paramTypes[i], (String) args.get(i));
            }

            return (T) ctor.newInstance(convertedArgs);
         }
      }

      throw new IllegalArgumentException("Don't know how to instantiate ");
   }

   public static Class<?> getClass(Class<?> clazz, String name) {
      try {
         return clazz.getClassLoader().loadClass(clazz.getPackage().toString().replace("package ", "") + "." + name);
      } catch (ClassNotFoundException var3) {
         return null;
      }
   }

   public Object createInstance(Class<?> testClazz, String name, Class<?>[] parameterTypes, Object[] args) {
      Class<?> clazz = getClass(testClazz, name);
      if (args.length == 0) {
         this.addLog("Check <" + name + "> constructor creates instances");
      } else {
         this.addLog(
               "Check <" + name + "> constructor creates instances with args <(" + Constructor.getRepr(args) + ")>");
      }

      try {
         return getConstructor(clazz, parameterTypes).newInstance(args);
      } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NullPointerException
            | InstantiationException var7) {
         this.assertError(409, true);
         return null;
      }
   }
}
