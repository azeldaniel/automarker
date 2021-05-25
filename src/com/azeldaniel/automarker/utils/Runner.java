/* Decompiler 140ms, total 233ms, lines 175 */
package com.azeldaniel.automarker.utils;

import com.azeldaniel.automarker.AutoMarker;
import com.azeldaniel.automarker.marker.Commenter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;

public class Runner extends BlockJUnit4ClassRunner {
   private Class<?> testClass;

   public Runner(Class<?> testClass) throws InitializationError {
      super(new TestClass(testClass));
      this.testClass = testClass;
   }

   public Description getDescription() {
      return Description.createTestDescription(this.testClass, "My runner description");
   }

   public void run(RunNotifier notifier) {
      ArrayList objects = new ArrayList();

      try {
         Object testObject = this.testClass.getDeclaredConstructor().newInstance();
         Method[] var7;
         int var6 = (var7 = this.testClass.getMethods()).length;

         Method method;
         int var5;
         String message;
         for(var5 = 0; var5 < var6; ++var5) {
            method = var7[var5];
            if (method.isAnnotationPresent(BeforeClass.class)) {
               try {
                  method.invoke(testObject);
               } catch (Exception var21) {
                  if (AutoMarker.verbose) {
                     var21.printStackTrace();
                  }

                  HashMap<String, Object> obj = new HashMap();
                  message = var21.getCause().getMessage();
                  obj.put("name", message.split("\\|")[0]);
                  obj.put("definition", message.split("\\|")[1]);
                  obj.put("comment", message.split("\\|")[2]);
                  obj.put("meaning", message.split("\\|")[3]);
                  obj.put("mark", message.split("\\|")[4]);
                  obj.put("total", message.split("\\|")[5]);
                  objects.add(new JSONObject(obj));
                  throw new Exception();
               }
            }
         }

         var6 = (var7 = this.testClass.getMethods()).length;

         for(var5 = 0; var5 < var6; ++var5) {
            method = var7[var5];
            Method[] var11;
            int var29 = (var11 = this.testClass.getMethods()).length;

            Method method2;
            int var28;
            for(var28 = 0; var28 < var29; ++var28) {
               method2 = var11[var28];
               if (method2.isAnnotationPresent(Before.class)) {
                  method2.invoke(testObject);
               }
            }

            if (method.isAnnotationPresent(Test.class)) {
               HashMap obj = new HashMap();

               try {
                  obj.put("name", "Should not be printed");
                  obj.put("definition", "Should not be printed");
                  obj.put("meaning", "Should not be printed");
                  obj.put("comment", "Should not be printed");
                  obj.put("mark", 0);
                  obj.put("total", 1);
                  notifier.fireTestStarted(Description.createTestDescription(this.testClass, method.getName()));
                  method.invoke(testObject);
                  notifier.fireTestFinished(Description.createTestDescription(this.testClass, method.getName()));
                  obj.put("comment", Commenter.comment(0));
                  obj.put("pass", true);
               } catch (IllegalAccessException var22) {
                  obj.put("comment", "Method Inaccessible");
               } catch (IllegalArgumentException var23) {
                  obj.put("definition", "Method Not Properly Defined");
               } catch (InvocationTargetException var24) {
                  if (var24.getTargetException() != null && var24.getTargetException() instanceof AssertionError) {
                     message = var24.getTargetException().getMessage();
                     if (message == null) {
                        message = "||||";
                     } else if (message.contains("expected")) {
                        message = message.substring(0, message.indexOf("expected")).trim();
                     } else if (message.contains("Expected:")) {
                        message = message.substring(0, message.indexOf("Expected:"));
                     }

                     obj.put("name", message.split("\\|")[0]);
                     obj.put("definition", message.split("\\|")[1]);
                     obj.put("comment", message.split("\\|")[2]);
                     obj.put("meaning", message.split("\\|")[3]);
                     obj.put("mark", message.split("\\|")[4]);
                     String total = message.split("\\|")[5];
                     if (total.contains(":")) {
                        total = total.substring(0, total.indexOf(":"));
                     }

                     obj.put("total", total);
                  } else {
                     var24.printStackTrace();
                     System.out.println("Def should not be printed");
                  }
               } finally {
                  if (obj.get("total").toString().contains("+")) {
                     obj.put("total", 0);
                  }

                  objects.add(new JSONObject(obj));
               }
            }

            var29 = (var11 = this.testClass.getMethods()).length;

            for(var28 = 0; var28 < var29; ++var28) {
               method2 = var11[var28];
               if (method2.isAnnotationPresent(After.class)) {
                  method2.invoke(testObject);
               }
            }
         }

         var6 = (var7 = this.testClass.getMethods()).length;

         for(var5 = 0; var5 < var6; ++var5) {
            method = var7[var5];
            if (method.isAnnotationPresent(AfterClass.class)) {
               try {
                  method.invoke(testObject);
               } catch (InvocationTargetException var20) {
                  JSONArray arr = (JSONArray)(new JSONParser()).parse(var20.getCause().getMessage());
                  HashMap<String, Object> obj = new HashMap();
                  obj.put("log", arr);
                  objects.add(new JSONObject(obj));
               }
            }
         }

         throw new RuntimeException(JSONArray.toJSONString(objects));
      } catch (Exception var26) {
         if (AutoMarker.verbose) {
            var26.printStackTrace();
         }

         throw new RuntimeException(JSONArray.toJSONString(objects));
      }
   }
}
