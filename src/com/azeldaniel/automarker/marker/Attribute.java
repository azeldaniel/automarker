/* Decompiler 65ms, total 177ms, lines 92 */
package com.azeldaniel.automarker.marker;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;

public class Attribute extends Markable {
   private Class<?> type;
   private String[] modifiers;

   private Attribute(String name, double marks) {
      super(name, marks);
      this.modifiers = new String[]{"private"};
   }

   public Attribute(String name, Class<?> type, double marks) {
      this(name, marks);
      this.type = type;
   }

   public Attribute(String name, Class<?> type, String[] modifiers, double marks) {
      this(name, marks);
      this.type = type;
      this.modifiers = modifiers;
   }

   public Class<?> getType() {
      return this.type;
   }

   public void setType(Class<?> type) {
      this.type = type;
   }

   public String[] getModifiers() {
      return this.modifiers;
   }

   public void setModifiers(String[] modifiers) {
      this.modifiers = modifiers;
   }

   public String toString() {
      String details = "";
      String[] var5;
      int var4 = (var5 = this.getModifiers()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         String mod = var5[var3];
         details = details + mod + " ";
      }

      details = details + this.getType().getSimpleName() + " " + this.getName();
      return details;
   }

   public String repr() {
      return this.getName();
   }

   public <T> void assertMatches(Matcher<T> matcher, int comment) {
      this.assertAttribute(this.getName(), matcher, comment, 0.0D, !this.getMarker().getActual().equals(this));
   }

   public <T> void assertMatches(Matcher<T> matcher, int comment, double mark) {
      this.assertAttribute(this.getName(), matcher, comment, mark, !this.getMarker().getActual().equals(this));
   }

   public <T> void assertFirstOfTypeMatches(Class<?> type, Matcher<T> matcher, int comment, double mark) {
      if (this.getMarker() != null) {
         this.getMarker().addLog("Check first attribute with type <" + type.getSimpleName() + "> equals <" + matcher.toString().replace("<", "").replace(">", "") + ">");
      }
      String name = this.getMarker().getFirstAttributeName(type);
      if (name == null) {
         Assert.assertTrue(this.formatAssert(Commenter.comment(Commenter.ATTR_INCORRECT_TYPE), Commenter.meaning(Commenter.ATTR_INCORRECT_TYPE), mark), false);
      }

      this.assertAttribute(name, matcher, comment, mark, false);
   }

   protected <T> void assertAttribute(String name, Matcher<T> matcher, int comment, double mark, boolean indirect) {
      if (this.getMarker() != null) {
         this.getMarker().addLog("Check <" + name + "> attribute equals <" + matcher.toString().replace("<", "").replace(">", "") + ">");
      }

      Object attribute = this.getMarker().getAttribute(name);
      String indirectText = "";
      if (indirect && comment != 603) {
         indirectText = "Cannot be further tested because testing relies on another method that ";
      }

      MatcherAssert.assertThat(this.formatAssert(indirectText + Commenter.comment(comment, name), Commenter.meaning(comment), mark), (T)attribute, matcher);
   }
}
