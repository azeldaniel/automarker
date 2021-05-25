/* Decompiler 13ms, total 104ms, lines 44 */
package com.azeldaniel.automarker.document;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.renderer.DrawContext;
import com.itextpdf.layout.renderer.IRenderer;
import com.itextpdf.layout.renderer.TableRenderer;

public class TableBorderRenderer extends TableRenderer {
   public TableBorderRenderer(Table modelElement) {
      super(modelElement);
   }

   public IRenderer getNextRenderer() {
      return new TableBorderRenderer((Table)this.modelElement);
   }

   protected void drawBorders(DrawContext drawContext) {
      Rectangle rect = this.getOccupiedAreaBBox();
      PdfPage currentPage = drawContext.getDocument().getPage(this.getOccupiedArea().getPageNumber());
      PdfCanvas aboveCanvas = new PdfCanvas(currentPage.newContentStreamAfter(), currentPage.getResources(), drawContext.getDocument());
      float lineWidth = 1.0F;
      rect.applyMargins(lineWidth, lineWidth, lineWidth, lineWidth, false);
      aboveCanvas.saveState().setLineWidth(lineWidth).setStrokeColor(new DeviceRgb(255, 255, 255)).rectangle(rect).stroke().restoreState();
      aboveCanvas.saveState().setLineWidth(lineWidth).setStrokeColor(new DeviceRgb(229, 231, 233)).roundRectangle((double)rect.getLeft(), (double)rect.getBottom(), (double)rect.getWidth(), (double)rect.getHeight(), 5.0D).stroke().restoreState();
      super.drawBorders(drawContext);
   }

   public void drawChildren(DrawContext drawContext) {
      Rectangle rect = this.getOccupiedAreaBBox();
      float lineWidth = 0.5F;
      rect.applyMargins(lineWidth, lineWidth, lineWidth, lineWidth, false);
      PdfCanvas canvas = drawContext.getCanvas();
      canvas.saveState();
      canvas.roundRectangle((double)rect.getLeft(), (double)rect.getBottom(), (double)rect.getWidth(), (double)rect.getHeight(), 5.0D);
      canvas.clip().endPath();
      super.drawChildren(drawContext);
      canvas.restoreState();
   }
}
