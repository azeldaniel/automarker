/* Decompiler 101ms, total 208ms, lines 144 */
package com.azeldaniel.automarker.marker;

public class MarkableClass extends Markable {
   private String[] modifiers;
   private Class<?>[] interfaces;
   private Class<?> superClass;
   private Class<?> cls;
   private boolean isInterface;

   private MarkableClass(double marks) {
      super("Class()", marks);
      this.isInterface = false;
      this.modifiers = new String[]{"public"};
   }

   public MarkableClass(boolean isInterface, double marks) {
      super("Interface()", marks);
      this.isInterface = false;
      this.modifiers = new String[]{"public"};
      this.isInterface = isInterface;
   }

   public MarkableClass(String[] modifiers, double marks) {
      this(marks);
      this.modifiers = modifiers;
   }

   public MarkableClass(Class<?>[] interfaces, double marks) {
      this(marks);
      this.interfaces = interfaces;
      this.setName(this.generateName(interfaces));
   }

   public MarkableClass(String[] modifiers, Class<?>[] interfaces, double marks) {
      this(marks);
      this.modifiers = modifiers;
      this.interfaces = interfaces;
      this.setName(this.generateName(interfaces));
   }

   public MarkableClass(Class<?> superClass, String[] modifiers, Class<?>[] interfaces, double marks) {
      this(marks);
      this.superClass = superClass;
      this.modifiers = modifiers;
      this.interfaces = interfaces;
      this.setName(this.generateName(interfaces));
   }

   public Class<?> getCls() {
      return this.cls;
   }

   public void setCls(Class<?> cls) {
      this.cls = cls;
      this.setName(this.generateName(this.interfaces));
   }

   private String generateName(Class<?>[] interfaces) {
      String details = "";
      int var4;
      int var5;
      if (this.modifiers.length != 0) {
         String[] var6;
         var5 = (var6 = this.modifiers).length;

         for(var4 = 0; var4 < var5; ++var4) {
            String modifier = var6[var4];
            details = details + modifier + " ";
         }
      }

      if (this.cls != null) {
         details = details + this.cls.getSimpleName() + " ";
      } else {
         details = details + "Class ";
      }

      if (this.superClass != null) {
         details = details + "extends " + this.superClass.getSimpleName() + " ";
      }

      if (interfaces.length != 0) {
         details = details + "implements ";
         Class[] var8 = interfaces;
         var5 = interfaces.length;

         for(var4 = 0; var4 < var5; ++var4) {
            Class<?> cls2 = var8[var4];
            if (cls2 != null) {
               details = details + cls2.getSimpleName() + ", ";
            } else {
               details = details + "<Missing Class>, ";
            }
         }

         if (details.endsWith(", ")) {
            details = details.substring(0, details.length() - 2);
         }
      }

      return details;
   }

   public String toString() {
      return this.getName();
   }

   public String repr() {
      return this.getName();
   }

   public String[] getModifiers() {
      return this.modifiers;
   }

   public void setModifiers(String[] modifiers) {
      this.modifiers = modifiers;
   }

   public Class<?>[] getInterfaces() {
      return this.interfaces;
   }

   public void setInterfaces(Class<?>[] interfaces) {
      this.interfaces = interfaces;
   }

   public Class<?> getSuperClass() {
      return this.superClass;
   }

   public void setSuperClass(Class<?> superClass) {
      this.superClass = superClass;
   }

   public boolean isInterface() {
      return this.isInterface;
   }

   public void setInterface(boolean isInterface) {
      this.isInterface = isInterface;
   }
}
