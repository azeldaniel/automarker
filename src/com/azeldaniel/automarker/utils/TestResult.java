/* Decompiler 65ms, total 159ms, lines 120 */
package com.azeldaniel.automarker.utils;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
   private String name;
   private double mark;
   private double total;
   private String definition;
   private String comment;
   private String commentMeaning;
   private List<String[]> testResult;
   private String type;

   public TestResult() {
      this.name = "";
      this.mark = 0.0D;
      this.total = 0.0D;
      this.definition = "";
      this.comment = "";
      this.commentMeaning = "";
      this.testResult = new ArrayList();
   }

   public TestResult(String name, double mark, double total, String definition, String comment, String commentMeaning, List<String[]> testResult) {
      this.name = name;
      this.mark = mark;
      this.total = total;
      this.definition = definition;
      this.comment = comment;
      this.commentMeaning = commentMeaning;
      this.testResult = testResult;
      if (this.name.contains("(")) {
         this.type = "Attribute";
      } else if (!this.definition.replace(this.name, "").replace("public", "").replace("private", "").replace("protected", "").trim().equals("")) {
         this.type = "Constructor";
      } else {
         this.type = "Method";
      }

   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getMark() {
      return this.mark;
   }

   public void setMark(double mark) {
      this.mark = mark;
   }

   public double getTotal() {
      return this.total;
   }

   public void setTotal(double total) {
      this.total = total;
   }

   public String getDefinition() {
      return this.definition;
   }

   public void setDefinition(String definition) {
      this.definition = definition;
      if (!this.name.contains("(")) {
         if (Character.isUpperCase(this.name.charAt(0))) {
            this.type = "Class";
         } else {
            this.type = "Attribute";
         }
      } else if (this.definition.replace(this.name, "").replace("public", "").replace("private", "").replace("protected", "").trim().equals("")) {
         this.type = "Constructor";
      } else {
         this.type = "Method";
      }

   }

   public String getComment() {
      return this.comment;
   }

   public void setComment(String comment) {
      this.comment = comment;
   }

   public String getCommentMeaning() {
      return this.commentMeaning;
   }

   public void setCommentMeaning(String commentMeaning) {
      this.commentMeaning = commentMeaning;
   }

   public List<String[]> getTestResult() {
      return this.testResult;
   }

   public void setTestResult(List<String[]> testResult) {
      this.testResult = testResult;
   }

   public String getType() {
      return this.type;
   }

   public void setType(String type) {
      this.type = type;
   }
}
