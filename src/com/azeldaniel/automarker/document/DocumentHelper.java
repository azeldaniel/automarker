package com.azeldaniel.automarker.document;

import com.azeldaniel.automarker.utils.TestResult;
import com.itextpdf.io.font.otf.Glyph;
import com.itextpdf.io.font.otf.GlyphLine;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.ILeafElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.Property;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.layout.splitting.DefaultSplitCharacters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DocumentHelper {
   private Document document;
   private PdfFont font;
   private PdfFont symbolFont;
   private PdfFont codeFont;
   private int numSections = 0;

   public DocumentHelper(Document document, PdfFont font) {
      this.document = document;
      this.font = font;

      try {
         this.symbolFont = PdfFontFactory.createFont("ZapfDingbats");
         this.codeFont = PdfFontFactory.createFont("Courier");
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   public void addCoverPage(IBlockElement[] elements) {
      Table outerTable = new Table(1);
      outerTable.setWidth(UnitValue.createPercentValue(100.0F));
      Cell cell = new Cell();
      cell.setBorder(Border.NO_BORDER);
      cell.setMinHeight(this.document.getPdfDocument().getDefaultPageSize().getHeight() - 140.0F);
      cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
      IBlockElement[] var7 = elements;
      int var6 = elements.length;

      for(int var5 = 0; var5 < var6; ++var5) {
         IBlockElement element = var7[var5];
         cell.add(element);
      }

      outerTable.addCell(cell);
      this.document.add(outerTable);
      this.document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
   }

   public void addNewPage(String title, String subtitle) {
      if (this.numSections != 0) {
         this.document.add((IBlockElement)((Paragraph)(new Paragraph()).add((ILeafElement)((Text)((Text)(new Text(title)).setFont(this.font)).setBold()).setFontSize(12.0F)).setMarginTop(40.0F)).setTextAlignment(TextAlignment.CENTER));
      } else {
         this.document.add((IBlockElement)(new Paragraph()).add((ILeafElement)((Text)((Text)(new Text(title)).setFont(this.font)).setBold()).setFontSize(12.0F)).setTextAlignment(TextAlignment.CENTER));
      }

      this.document.add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph()).add((ILeafElement)((Text)(new Text(subtitle.replace(" 0 ", " none "))).setFont(this.font)).setFontSize(11.0F)).setTextAlignment(TextAlignment.CENTER)).setMarginTop(8.0F)).setMarginBottom(18.0F));
      ++this.numSections;
   }

   private Cell createCell(int colspan) {
      return (Cell)((Cell)((Cell)((Cell)(new Cell(1, colspan)).setBorder(Border.NO_BORDER)).setPadding(5.0F)).setFont(this.font)).setFontSize(11.0F);
   }

   private Cell createCell() {
      return (Cell)((Cell)((Cell)((Cell)(new Cell()).setBorder(Border.NO_BORDER)).setPadding(5.0F)).setFont(this.font)).setFontSize(11.0F);
   }

   public void addTestResult(TestResult result, boolean showGrades) {
      Table t = new Table(UnitValue.createPercentArray(new float[]{1.0F, 1.0F, 1.0F, 6.0F, 1.0F, 1.0F, 1.0F}));
      t.setWidth(UnitValue.createPercentValue(100.0F));
      t.setMaxWidth(UnitValue.createPercentValue(100.0F));
      t.setMinWidth(UnitValue.createPercentValue(100.0F));
      t.setTextAlignment(TextAlignment.CENTER);
      double percentage = result.getMark() / result.getTotal();
      String left = "";
      String middle = result.getName();
      String right = "- / -";
      if (showGrades) {
         right = result.getMark() + " / " + result.getTotal();
      }

      if (!result.getDefinition().equals("Class not found")) {
         left = result.getType();
      }

      Border border = new SolidBorder(new DeviceRgb(229, 231, 233), 1.0F);
      t.addCell(((Cell)((Cell)((Cell)((Cell)this.createCell(3).setBorderLeft(border)).setBorderTop(border)).setBorderBottom(border)).setBackgroundColor(new DeviceRgb(245, 247, 249))).add((IBlockElement)((Paragraph)(new Paragraph(new Text(left))).setFontColor(new DeviceRgb(149, 151, 153))).setTextAlignment(TextAlignment.LEFT)));
      t.addCell(((Cell)((Cell)((Cell)this.createCell().setBorderTop(border)).setBorderBottom(border)).setBackgroundColor(new DeviceRgb(245, 247, 249))).add((IBlockElement)((Paragraph)((Paragraph)((Paragraph)(new Paragraph(new Text(middle))).setFont(this.codeFont)).setBold()).setFontSize(10.0F)).setTextAlignment(TextAlignment.CENTER)));
      t.addCell(((Cell)((Cell)((Cell)((Cell)this.createCell(3).setBorderRight(border)).setBorderTop(border)).setBorderBottom(border)).setBackgroundColor(new DeviceRgb(245, 247, 249))).add((IBlockElement)(new Paragraph((Text)(new Text(right)).setFontColor(this.getColor(percentage)))).setTextAlignment(TextAlignment.RIGHT)));
      if (result.getMark() < result.getTotal()) {
         t.addCell((Cell)((Cell)this.createCell(7).setPadding(7.0F)).add(new Paragraph(result.getComment() + ". " + result.getCommentMeaning() + ".")).setTextAlignment(TextAlignment.LEFT));
         ArrayList<Cell> cells = new ArrayList<Cell>();
         Iterator var12 = result.getTestResult().iterator();

         while(var12.hasNext()) {
            String[] test = (String[])var12.next();
            Paragraph p = (Paragraph)((Paragraph)(new Paragraph()).setPaddings(0.0F, 7.0F, 0.0F, 2.0F)).setTextAlignment(TextAlignment.LEFT);
            p.setProperty(Property.SPLIT_CHARACTERS, new CustomSplitCharacters());
            int i = 0;
            int j = test[0].indexOf("<");

            while(j != -1) {
               p.add((ILeafElement)((Text)(new Text(test[0].substring(i, j))).setFont(this.font)).setFontSize(11.0F));
               i = j + 1;
               j = test[0].indexOf(">", i);
               p.add((ILeafElement)((Text)(new Text(test[0].substring(i, j))).setFont(this.codeFont)).setFontSize(10.0F));
               i = j + 1;
               j = test[0].indexOf("<", i);
               if (j == -1) {
                  p.add((ILeafElement)((Text)(new Text(test[0].substring(i))).setFont(this.font)).setFontSize(11.0F));
               }
            }

            cells.add(this.createCell(6).add(p));
            if (test[1].equals("Pass")) {
               cells.add(((Cell)this.createCell(1).setVerticalAlignment(VerticalAlignment.MIDDLE)).add((IBlockElement)((Paragraph)(new Paragraph((Text)(new Text("3")).setFont(this.symbolFont))).setTextAlignment(TextAlignment.RIGHT)).setPaddings(0.0F, 2.0F, 0.0F, 7.0F)));
            } else {
               cells.add(((Cell)this.createCell(1).setVerticalAlignment(VerticalAlignment.MIDDLE)).add((IBlockElement)((Paragraph)((Paragraph)(new Paragraph((Text)(new Text("5")).setFont(this.symbolFont))).setTextAlignment(TextAlignment.RIGHT)).setFontColor(new DeviceRgb(255, 0, 0))).setPaddings(0.0F, 2.0F, 0.0F, 7.0F)));
            }
         }

         if (result.getTestResult().size() != 0) {
            var12 = cells.iterator();

            while(var12.hasNext()) {
               Cell cell = (Cell)var12.next();
               t.addCell(cell);
            }

            t.addCell((Cell)this.createCell(7).setPadding(3.0F));
         }
      }

      t.setNextRenderer(new TableBorderRenderer(t));
      this.document.add(t);
      this.document.add((IBlockElement)(new Div()).setMarginTop(6.0F));
   }

   private DeviceRgb getColor(double percentage) {
      if (percentage < 0.5D) {
         percentage *= 2.0D;
         return new DeviceRgb(255, (int)(165.0D * percentage), 0);
      } else if (percentage == 0.5D) {
         return new DeviceRgb(255, 165, 0);
      } else {
         percentage = (percentage - 0.5D) * 2.0D;
         return new DeviceRgb((int)(255.0D * (1.0D - percentage)), (int)(165.0D * (1.0D - percentage)), 0);
      }
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document document) {
      this.document = document;
   }

   private static class CustomSplitCharacters extends DefaultSplitCharacters {
      @Override
      public boolean isSplitCharacter(GlyphLine text, int glyphPos) {
          if (!text.get(glyphPos).hasValidUnicode()) {
              return false;
          }
          boolean baseResult = super.isSplitCharacter(text, glyphPos);
          boolean myResult = false;
          Glyph glyph = text.get(glyphPos);
          if (glyph.getUnicode() == '_') {
              myResult = true;
          }
          return myResult || baseResult;
      }
  }
}
