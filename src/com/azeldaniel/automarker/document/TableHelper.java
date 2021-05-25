/* Decompiler 114ms, total 215ms, lines 174 */
package com.azeldaniel.automarker.document;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.BorderRadius;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import java.util.stream.Stream;

public class TableHelper {
   private String[] headers;
   private PdfFont font;
   private String title;
   private Table table;
   private TextAlignment[] alignments;
   private float[] weights;
   private int i;

   public TableHelper(String title, PdfFont font, float[] weights) {
      this.i = 0;
      this.font = font;
      this.title = title;
      this.table = new Table(UnitValue.createPercentArray(weights));
      this.table.setBorderRadius(new BorderRadius(4.0F, 4.0F));
      this.alignments = new TextAlignment[0];
      this.weights = weights;
      if (title != null) {
         this.addHeaderWithOnlyTitle();
      }

   }

   public TableHelper(String title, PdfFont font, float[] weights, TextAlignment[] alignments) {
      this(title, font, weights);
      this.alignments = alignments;
   }

   public TableHelper(String title, PdfFont font, String[] headers, float[] weights) {
      this.i = 0;
      this.headers = headers;
      this.font = font;
      this.title = title;
      this.table = new Table(UnitValue.createPercentArray(weights));
      this.table.setBorderRadius(new BorderRadius(4.0F, 4.0F));
      this.alignments = new TextAlignment[0];
   }

   public TableHelper(String title, PdfFont font, String[] headers, float[] weights, TextAlignment[] alignments) {
      this(title, font, headers, weights);
      this.alignments = alignments;
      if (headers != null) {
         if (title == null) {
            this.addHeader();
         } else {
            this.addHeaderWithTitle();
         }
      }

   }

   private void addHeader() {
      this.i = 0;
      Stream.of(this.headers).forEach((columnTitle) -> {
         Cell header = new Cell();
         header.add((IBlockElement)((Paragraph)(new Paragraph(columnTitle)).setFont(this.font)).setFontSize(11.0F));
         header.setPaddings(5.0F, 7.0F, 5.0F, 7.0F);
         header.setVerticalAlignment(VerticalAlignment.MIDDLE);
         header.setBorderTopLeftRadius(new BorderRadius(4.0F, 4.0F));
         header.setBorderTopRightRadius(new BorderRadius(4.0F, 4.0F));
         if (this.alignments.length == 0) {
            header.setTextAlignment(TextAlignment.CENTER);
         } else {
            header.setTextAlignment(this.alignments[this.i]);
         }

         header.setBackgroundColor(new DeviceRgb(245, 247, 249));
         header.setBorder(new SolidBorder(new DeviceRgb(229, 231, 233), 1.0F));
         this.table.addCell(header);
         ++this.i;
      });
   }

   private void addHeaderWithOnlyTitle() {
      Cell h = new Cell(1, this.weights.length);
      h.add((IBlockElement)((Paragraph)(new Paragraph(this.title)).setFont(this.font)).setFontSize(11.0F));
      h.setPaddings(5.0F, 7.0F, 5.0F, 7.0F);
      h.setVerticalAlignment(VerticalAlignment.MIDDLE);
      h.setTextAlignment(TextAlignment.CENTER);
      h.setBorder(Border.NO_BORDER);
      h.setBackgroundColor(new DeviceRgb(245, 247, 249));
      h.setBorder(new SolidBorder(new DeviceRgb(229, 231, 233), 1.0F));
      this.table.addCell(h);
   }

   private void addHeaderWithTitle() {
      Cell h = new Cell(1, this.headers.length);
      h.add((IBlockElement)((Paragraph)(new Paragraph(this.title)).setFont(this.font)).setFontSize(11.0F));
      h.setPaddings(5.0F, 7.0F, 5.0F, 7.0F);
      h.setVerticalAlignment(VerticalAlignment.MIDDLE);
      h.setTextAlignment(TextAlignment.CENTER);
      h.setBorder(Border.NO_BORDER);
      h.setBackgroundColor(new DeviceRgb(245, 247, 249));
      h.setBorder(new SolidBorder(new DeviceRgb(229, 231, 233), 1.0F));
      this.table.addCell(h);
      this.i = 0;
      Stream.of(this.headers).forEach((columnTitle) -> {
         Cell header = new Cell();
         header.add((IBlockElement)((Paragraph)(new Paragraph(columnTitle)).setFont(this.font)).setFontSize(11.0F));
         header.setPaddings(5.0F, 7.0F, 5.0F, 7.0F);
         header.setVerticalAlignment(VerticalAlignment.MIDDLE);
         if (this.alignments.length == 0) {
            header.setTextAlignment(TextAlignment.CENTER);
         } else {
            header.setTextAlignment(this.alignments[this.i]);
         }

         header.setBackgroundColor(new DeviceRgb(245, 247, 249));
         header.setBorder(new SolidBorder(new DeviceRgb(229, 231, 233), 1.0F));
         this.table.addCell(header);
         ++this.i;
      });
   }

   public void addCell(String value, int rowSpan, int column) {
      Cell c1 = new Cell(rowSpan, 1);
      c1.setPaddings(5.0F, 7.0F, 5.0F, 7.0F);
      if (this.alignments.length == 0) {
         c1.setTextAlignment(TextAlignment.CENTER);
      } else {
         c1.setTextAlignment(this.alignments[column]);
      }

      c1.add((IBlockElement)((Paragraph)(new Paragraph(value)).setFont(this.font)).setFontSize(11.0F));
      c1.setVerticalAlignment(VerticalAlignment.MIDDLE);
      c1.setBorder(new SolidBorder(new DeviceRgb(229, 231, 233), 1.0F));
      this.table.addCell(c1);
   }

   public void addRow(String[] values) {
      this.addRow(values, this.font);
   }

   public void addRow(String[] values, PdfFont font) {
      for(int i = 0; i < values.length; ++i) {
         String value = values[i];
         Cell c1 = new Cell();
         c1.add((IBlockElement)((Paragraph)(new Paragraph(value)).setFont(font)).setFontSize(11.0F));
         c1.setPaddings(5.0F, 7.0F, 5.0F, 7.0F);
         if (this.alignments.length == 0) {
            c1.setTextAlignment(TextAlignment.CENTER);
         } else {
            c1.setTextAlignment(this.alignments[i]);
         }

         c1.setVerticalAlignment(VerticalAlignment.MIDDLE);
         c1.setBorder(new SolidBorder(new DeviceRgb(229, 231, 233), 1.0F));
         this.table.addCell(c1);
      }

   }

   public Table getTable() {
      this.table.setNextRenderer(new TableBorderRenderer(this.table));
      return this.table;
   }
}
