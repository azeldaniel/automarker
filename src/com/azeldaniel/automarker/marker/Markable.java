/* Decompiler 74ms, total 169ms, lines 65 */
package com.azeldaniel.automarker.marker;

public abstract class Markable {
   private String name;
   private double marks;
   private Marker marker;
   private boolean bonus;

   protected Markable(String name, double marks) {
      this.name = name;
      this.marks = marks;
   }

   public double getMarks() {
      return this.bonus ? 0.0D : this.marks;
   }

   public void setMarks(double marks) {
      this.marks = marks;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public abstract String repr();

   public Marker getMarker() {
      return this.marker;
   }

   public void setMarker(Marker marker) {
      this.marker = marker;
   }

   public void setBonus(boolean bonus) {
      this.bonus = bonus;
   }

   public boolean isBonus() {
      return this.bonus;
   }

   protected String formatAssert(String comment, String meaning) {
      return this.formatAssert(comment, meaning, 0.0D);
   }

   protected String formatAssert(String comment, String meaning, double mark) {
      if (this.marker == null) {
         return "||" + comment + "|" + meaning + "|" + mark + "|" + mark;
      } else {
         this.marker.updateMark(mark);
         return this.marker.getActual().repr() + "|" + this.marker.getActual().toString() + "|" + comment + "|" + meaning + "|" + this.marker.getMark() + "|" + this.marker.getActual().getMarks();
      }
   }

   public boolean equals(Object o) {
      return this.toString().equals("" + o);
   }
}
