/* Decompiler 15ms, total 117ms, lines 45 */
package com.azeldaniel.automarker.document;

import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import java.io.IOException;

public class HeaderFooterPageEvent implements IEventHandler {
   private PdfFont font = PdfFontFactory.createFont("Helvetica");
   private PdfFormXObject template;
   private String VERSION;

   public HeaderFooterPageEvent(String version, PdfFormXObject template) throws IOException {
      this.VERSION = version;
      this.template = template;
   }

   public void handleEvent(Event event) {
      PdfDocumentEvent docEvent = (PdfDocumentEvent)event;
      PdfPage page = docEvent.getPage();
      int pageNum = docEvent.getDocument().getPageNumber(page);
      PdfCanvas canvas = new PdfCanvas(page);
      canvas.beginText();
      canvas.setFontAndSize(this.font, 12.0F);
      canvas.beginMarkedContent(PdfName.Artifact);
      canvas.moveText(30.0D, 20.0D);
      canvas.showText("AutoMarker");
      canvas.moveText((double)(docEvent.getDocument().getDefaultPageSize().getWidth() / 2.0F), 20.0D);
      canvas.showText(String.format("Page %d", pageNum));
      canvas.moveText((double)(docEvent.getDocument().getDefaultPageSize().getWidth() - 30.0F), 20.0D);
      canvas.showText(this.VERSION);
      canvas.endText();
      canvas.stroke();
      canvas.addXObjectAt(this.template, 0.0F, 0.0F);
      canvas.endMarkedContent();
      canvas.release();
   }
}
