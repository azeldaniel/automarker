/* Decompiler 19ms, total 123ms, lines 67 */
package com.azeldaniel.automarker.utils;

import com.azeldaniel.automarker.AutoMarker;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static String test(String folder, String file) {
      String packageName = folder.replace(File.separator, ".").replace("..", ".").replace(" ", "_").replace("-", "_").replace("src.", "");
      HashMap<String, Object> obj = new HashMap();
      obj.put("name", "Error testing file");
      obj.put("mark", 0);
      obj.put("total", getTotal(file));
      obj.put("definition", file);
      obj.put("desc", "Test error --- query if this statement is shown");
      obj.put("comment", "Test error --- query if this statement is shown");
      boolean flag = false;
      if (!(new File(folder + File.separator + file + ".java")).exists()) {
         flag = true;
         if (AutoMarker.verbose) {
            System.out.println("Files could not compile due student error " + file);
         }

         obj.put("desc", "Student Code Compilation Error");
         obj.put("comment", "Testing cannot be done because your code did not compile");
      } else if (!(new File(folder + File.separator + file + "Test.java")).exists()) {
         flag = true;
         if (AutoMarker.verbose) {
            System.out.println("Files could not compile due to test compile error ");
         }

         obj.put("desc", "Test code compilation error");
         obj.put("comment", "Testing cannot be done because your code does not provide the requisite methods");
      }

      try {
         URL[] urls = new URL[]{(new File(folder + File.separator + file + ".class")).toURI().toURL(), (new File(folder + File.separator + file + "Test.class")).toURI().toURL()};
         ClassLoader classLoader = URLClassLoader.newInstance(urls);
         Class<?> junitTest = Class.forName(packageName + "." + file + "Test", true, classLoader);
         JUnitCore junit = new JUnitCore();
         Result result = junit.run(new Class[]{junitTest});
         return ((Failure)result.getFailures().get(0)).getException().getMessage();
      } catch (Exception var10) {
         if (!flag && AutoMarker.verbose) {
            System.out.println("Error in running test files");
            var10.printStackTrace();
         }

         ArrayList<JSONObject> objects = new ArrayList();
         objects.add(new JSONObject(obj));
         return JSONArray.toJSONString(objects);
      }
   }

   private static int getTotal(String file) {
      return 10;
   }
}
