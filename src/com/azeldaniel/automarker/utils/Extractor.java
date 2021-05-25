/* Decompiler 217ms, total 395ms, lines 178 */
package com.azeldaniel.automarker.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import me.tongfei.progressbar.ProgressBar;

public class Extractor {
   public static ArrayList<String[]> extract(String src, String dest, String testSrc, String[] dataFiles) {
      File submissionFolder = new File(src);
      String[] submissionPaths = submissionFolder.list();
      File directory = new File(dest);
      if (!directory.exists()) {
         directory.mkdir();
      }

      String errorLog = "";
      ArrayList<String[]> outputFolders = new ArrayList();
      Iterator var10 = ProgressBar.wrap(Arrays.asList(submissionPaths), "Extracting Files").iterator();

      while(var10.hasNext()) {
         String path = (String)var10.next();
         String name = path.split(File.separator)[path.split(File.separator).length - 1].replace(" ", "_").replace("-", "___");
         String packageName = "package " + (dest + name).replace(File.separator, ".").replace("src.", "").replace("..", ".").replace(" ", "_").replace("-", "_") + ";";
         File destDir = new File(dest + File.separator + name);
         byte[] buffer = new byte[1024];

         try {
            String id = "";
            String[] fs = (new File(src + File.separator + path)).list();
            if (fs != null) {
               String[] var20 = fs;
               int var19 = fs.length;

               for(int var18 = 0; var18 < var19; ++var18) {
                  String fName = var20[var18];
                  if (fName.toString().contains(".zip")) {
                     id = fName;
                  }
               }

               ZipInputStream zis = new ZipInputStream(new FileInputStream(src + File.separator + path + File.separator + id));

               for(ZipEntry zipEntry = zis.getNextEntry(); zipEntry != null; zipEntry = zis.getNextEntry()) {
                  File newFile = newFile(destDir, zipEntry);
                  if (zipEntry.getName().contains(".java")) {
                     if (zipEntry.isDirectory()) {
                        if (!newFile.isDirectory() && !newFile.mkdirs()) {
                           throw new IOException("Failed to create directory " + newFile);
                        }
                     } else {
                        File parent = newFile.getParentFile();
                        if (!parent.isDirectory() && !parent.mkdirs()) {
                           throw new IOException("Failed to create directory " + parent);
                        }

                        FileOutputStream fos = new FileOutputStream(newFile);

                        int len;
                        while((len = zis.read(buffer)) > 0) {
                           fos.write(buffer, 0, len);
                        }

                        fos.close();
                        Path p = newFile.toPath();
                        String content = new String(Files.readAllBytes(p), StandardCharsets.UTF_8);
                        if (Pattern.matches("[.\\s\\S]*package ([A-Za-z0-9.]+)(;)?[.\\s\\S]*", content)) {
                           content = content.replaceFirst("package ([A-Za-z0-9.]+)(;)?", packageName);
                        } else {
                           content = packageName + content;
                        }

                        Files.write(p, content.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
                     }
                  }
               }

               zis.closeEntry();
               zis.close();
               copyTestFiles(testSrc, dest + File.separator + name, packageName, dataFiles);
               outputFolders.add(new String[]{id.replace(".zip", ""), dest + File.separator + name, path});
            }
         } catch (Exception var25) {
            errorLog = errorLog + name + "\n";
         }
      }

      if (!errorLog.equals("")) {
         System.out.println("Error extracting folders for the following students:\n" + errorLog);
      }

      return outputFolders;
   }

   private static void copyTestFiles(String src, String dest, String packageName, String[] dataFiles) {
      File testFolder = new File(src);
      String[] testFilePaths = testFolder.list();
      String[] var9 = testFilePaths;
      int var8 = testFilePaths.length;

      for(int var7 = 0; var7 < var8; ++var7) {
         String testFilePath = var9[var7];
         String testFileName = testFilePath.split(File.separator)[testFilePath.split(File.separator).length - 1];
         boolean include = false;

         for(int i = 0; i < dataFiles.length; ++i) {
            if (testFileName.contains(dataFiles[i])) {
               include = true;
            }
         }

         if (testFileName.contains("Test") || include) {
            try {
               Files.copy((new File(src + File.separator + testFilePath)).toPath(), (new File(dest + File.separator + testFileName)).toPath(), StandardCopyOption.REPLACE_EXISTING);
               Path path = Paths.get(dest + File.separator + testFileName);
               String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
               if (Pattern.matches("[.\\s\\S]*package ([A-Za-z0-9.]+)(;)?[.\\s\\S]*", content)) {
                  content = content.replaceFirst("package ([A-Za-z0-9.]+)(;)?", packageName);
               } else {
                  content = packageName + content;
               }

               Files.write(path, content.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
            } catch (Exception var14) {
               System.out.println("Something went wrong while copying test files");
               var14.printStackTrace();
            }
         }
      }

   }

   public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
      String name = zipEntry.getName().split(File.separator)[zipEntry.getName().split(File.separator).length - 1];
      File destFile = new File(destinationDir, name);
      String destDirPath = destinationDir.getCanonicalPath();
      String destFilePath = destFile.getCanonicalPath();
      if (!destFilePath.startsWith(destDirPath + File.separator)) {
         throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
      } else {
         return destFile;
      }
   }

   public static void deleteDir(File file) {
      File[] contents = file.listFiles();
      if (contents != null) {
         File[] var5 = contents;
         int var4 = contents.length;

         for(int var3 = 0; var3 < var4; ++var3) {
            File f = var5[var3];
            if (!Files.isSymbolicLink(f.toPath())) {
               deleteDir(f);
            }
         }
      }

      if (!file.getName().contains(".csv") && !file.getName().contains(".pdf")) {
         file.delete();
      }

   }
}
