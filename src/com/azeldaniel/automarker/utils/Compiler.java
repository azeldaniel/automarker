/* Decompiler 111ms, total 256ms, lines 88 */
package com.azeldaniel.automarker.utils;

import com.azeldaniel.automarker.AutoMarker;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import me.tongfei.progressbar.ProgressBar;

public class Compiler {
   private static JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

   public static void compileAll(ArrayList<String[]> output, boolean verbose) {
      ArrayList<String> log = new ArrayList();
      Iterator var4 = ProgressBar.wrap(output, "Compiling Files").iterator();

      while (true) {
         String[] student;
         File folderFile;
         String[] paths;
         do {
            if (!var4.hasNext()) {
               var4 = log.iterator();

               while (var4.hasNext()) {
                  String s = (String) var4.next();
                  System.out.println(s);
               }

               return;
            }

            student = (String[]) var4.next();
            folderFile = new File(student[1]);
            paths = folderFile.list();
         } while (paths == null);

         ArrayList<String> studentList = new ArrayList();
         ArrayList<String> testList = new ArrayList();

         int jErr = 0;
         for (jErr = 0; jErr < paths.length; ++jErr) {
            paths[jErr] = student[1] + File.separator + paths[jErr];
            if (!paths[jErr].contains("._") && paths[jErr].contains(".java")) {
               if (paths[jErr].contains("Test.java")) {
                  testList.add(paths[jErr]);
               } else {
                  studentList.add(paths[jErr]);
               }
            }
         }

         if (verbose) {
            jErr = compiler.run((InputStream) null, (OutputStream) null, (OutputStream) null,
                  (String[]) studentList.toArray(new String[studentList.size()]));
         } else {
            jErr = compiler.run((InputStream) null, (OutputStream) null, OutputStream.nullOutputStream(),
                  (String[]) studentList.toArray(new String[studentList.size()]));
         }

         if (jErr != 0) {
            if (!AutoMarker.DEBUG) {
               Iterator var11 = studentList.iterator();

               while (var11.hasNext()) {
                  String s = (String) var11.next();
                  File currentFile = new File(s);
                  currentFile.delete();
               }
            }

            log.add("Compilation error with: " + folderFile);
         }

         int tErr = 0;
         if (verbose) {
            tErr = compiler.run((InputStream) null, (OutputStream) null, (OutputStream) null,
                  (String[]) testList.toArray(new String[testList.size()]));
            System.out.println("Compiled: " + student[1] + " " + jErr + " " + tErr);
         } else {
            tErr = compiler.run((InputStream) null, (OutputStream) null, OutputStream.nullOutputStream(),
                  (String[]) testList.toArray(new String[testList.size()]));
         }
      }
   }
}
