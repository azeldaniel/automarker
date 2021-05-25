package com.azeldaniel.automarker;

import com.azeldaniel.automarker.document.DocumentHelper;
import com.azeldaniel.automarker.document.TableHelper;
import com.azeldaniel.automarker.marker.GradeScheme;
import com.azeldaniel.automarker.utils.Compiler;
import com.azeldaniel.automarker.utils.Extractor;
import com.azeldaniel.automarker.utils.TestResult;
import com.azeldaniel.automarker.utils.TestRunner;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AutoMarker {
    public static boolean DEBUG = false;
    private GradeScheme grader;
    private String institution;
    private String course;
    private String assessment;
    private String semester;
    private String srcFolder;
    private String outFolder;
    private String testFolder;
    private String[] testClasses;
    private String[] dataFiles;
    private String[] csvFileHeaders;
    private String imgFolder = null;
    private boolean deleteDir = true;
    public static boolean verbose;
    private boolean showGrades;
    private List<String> records;
    private List<String> corruptedSubmissions;

    public AutoMarker() {
        verbose = false;
        this.showGrades = true;
        this.csvFileHeaders = new String[0];
        this.corruptedSubmissions = new ArrayList<String>();
    }

    public void mark() {
        this.mark(10000L);
    }

    public void mark(long timeout) {
        ArrayList<String[]> output = Extractor.extract(this.srcFolder, this.outFolder, this.testFolder, this.dataFiles);
        Compiler.compileAll(output, verbose);

        try {
            System.out.println("Waiting on file indexing...");
            Thread.sleep(timeout);
        } catch (InterruptedException var21) {
            Thread.currentThread().interrupt();
            var21.printStackTrace();
        }

        System.out.println("Running tests...");

        try {
            PrintWriter masterWriter = new PrintWriter(new File(this.outFolder + File.separator + "Master.csv"));

            try {
                StringBuilder masterSb = new StringBuilder();
                String headers = "";
                String[] var12;
                int var11 = (var12 = this.csvFileHeaders).length;

                String sub;
                for (int var10 = 0; var10 < var11; ++var10) {
                    sub = var12[var10];
                    headers = headers + sub + ",";
                }

                masterSb.append(headers.substring(0, headers.length() - 1) + "\n");
                output.forEach((student) -> {
                    try {
                        String id = student[0];
                        String folder = student[1];
                        System.out.println("\n" + folder);
                        String[] b = id.split("_");
                        List<String[]> deductions = this.getMarkChanges(b[b.length - 2]);

                        String f_a = folder.substring(0, folder.lastIndexOf('/'));
                        String f_b = folder.substring(folder.lastIndexOf('/'));
                        f_b = f_b.replaceFirst("_", " ");
                        File directory = new File((f_a + f_b).replace("___", "-"));
                        if (!directory.exists()) {
                            directory.mkdir();
                        }

                        PdfWriter writer = new PdfWriter(
                                new File((f_a + f_b).replace("___", "-") + File.separator + b[b.length - 2] + ".pdf"));
                        PdfDocument pdf = new PdfDocument(writer);
                        Document document = new Document(pdf, PageSize.LETTER);
                        document.setTextAlignment(TextAlignment.CENTER);
                        PdfFont font = PdfFontFactory.createFont("Helvetica");
                        PdfFont fontHeader = PdfFontFactory.createFont("Helvetica-Bold");
                        FontProvider provider = new FontProvider();
                        provider.addStandardPdfFonts();
                        document.setFontProvider(provider);
                        DocumentHelper documentHelper = new DocumentHelper(document, font);
                        Image img = null;
                        ImageData imageData = ImageDataFactory.create(this.imgFolder + File.separator + "logo.png");
                        img = (new Image(imageData)).setMarginBottom(20.0F);
                        img.scaleAbsolute(45.0F, 57.0F);
                        String nId = id.split("_")[0] + " " + id.split("_")[1] + " (" + id.split("_")[2] + ")";
                        Paragraph header = (Paragraph) ((Paragraph) (new Paragraph(this.institution + "\n" + this.course
                                + "\n" + this.assessment + " Grade Sheet\n" + this.semester)).setFont(fontHeader))
                                        .setMarginTop(10.0F);
                        TableHelper summaryTable = new TableHelper((String) null, font,
                                new String[] { "Criteria", "Mark" }, new float[] { 4.0F, 1.0F },
                                new TextAlignment[] { TextAlignment.LEFT, TextAlignment.CENTER });
                        double tMark = 0.0D;
                        double tTotal = 0.0D;
                        HashMap<String, TestResult> testResults = new HashMap();
                        HashMap<String, List<String>> testMap = new HashMap();
                        List<String> blackList = new ArrayList();
                        String[] var33;
                        int var32 = (var33 = this.testClasses).length;

                        double mark;
                        int passed;
                        String text;
                        for (int var31 = 0; var31 < var32; ++var31) {
                            String testx = var33[var31];
                            String result = TestRunner.test(folder, testx);
                            testMap.put(testx, new ArrayList());

                            try {
                                JSONArray arr = (JSONArray) (new JSONParser()).parse(result);
                                mark = 0.0D;
                                double total = 0.0D;
                                Object[] var43;
                                passed = (var43 = arr.toArray()).length;

                                for (int var41 = 0; var41 < passed; ++var41) {
                                    Object o = var43[var41];
                                    JSONObject obj = (JSONObject) o;
                                    if (obj.containsKey("name")) {
                                        text = obj.get("name").toString();

                                        try {
                                            if (Double.parseDouble(obj.get("total").toString()) != 0.0D) {
                                                mark += Double.parseDouble(obj.get("mark").toString());
                                                total += Double.parseDouble(obj.get("total").toString());
                                            }
                                        } catch (NullPointerException | NumberFormatException var60) {
                                        }

                                        if (Double.parseDouble(obj.get("total").toString()) == 0.0D) {
                                            blackList.add(testx + ":" + text + "Bonus");
                                            deductions.add(new String[] { b[b.length - 2],
                                                    "Question Bonus: " + obj.get("name").toString(),
                                                    "+" + obj.get("mark").toString() });
                                        } else {
                                            ((List) testMap.get(testx)).add(testx + ":" + text);
                                            String mark2 = obj.get("mark").toString();
                                            String comment = obj.get("comment").toString();
                                            String total2 = obj.get("total").toString();
                                            testResults.put(testx + ":" + text, new TestResult());
                                            ((TestResult) testResults.get(testx + ":" + text)).setName(text);
                                            ((TestResult) testResults.get(testx + ":" + text))
                                                    .setDefinition(obj.get("definition").toString());
                                            ((TestResult) testResults.get(testx + ":" + text))
                                                    .setMark(Double.valueOf(mark2));
                                            ((TestResult) testResults.get(testx + ":" + text)).setComment(comment);
                                            ((TestResult) testResults.get(testx + ":" + text))
                                                    .setCommentMeaning(obj.get("meaning").toString());
                                            ((TestResult) testResults.get(testx + ":" + text))
                                                    .setTotal(Double.valueOf(total2));
                                        }
                                    }

                                    if (obj.containsKey("log")) {
                                        JSONArray log = (JSONArray) obj.get("log");
                                        Object[] var49;
                                        int var90 = (var49 = log.toArray()).length;

                                        for (int var89 = 0; var89 < var90; ++var89) {
                                            Object object = var49[var89];
                                            JSONObject obj4 = (JSONObject) object;
                                            if (obj4.containsKey("testName")) {
                                                String testName = (String) obj4.get("testName");
                                                JSONArray arr2 = (JSONArray) (new JSONParser())
                                                        .parse(obj4.get("testResult").toString());
                                                if (!testResults.containsKey(testx + ":" + testName)
                                                        && !blackList.contains(testx + ":" + testName)) {
                                                    testResults.put(testx + ":" + testName, new TestResult());
                                                }

                                                Object[] var56;
                                                int var55 = (var56 = arr2.toArray()).length;

                                                for (int var54 = 0; var54 < var55; ++var54) {
                                                    Object o2 = var56[var54];
                                                    JSONObject obj2 = (JSONObject) o2;
                                                    String log2 = (String) obj2.get("log");
                                                    String result2 = (String) obj2.get("result");
                                                    if (!blackList.contains(testx + ":" + testName)) {
                                                        ((TestResult) testResults.get(testx + ":" + testName))
                                                                .getTestResult().add(new String[] { log2, result2 });
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                tMark += mark;
                                tTotal += total;
                                if (this.showGrades) {
                                    summaryTable.addRow(new String[] { testx, String.valueOf(mark) });
                                }
                            } catch (Exception var61) {
                                System.out.println("Cannot add info to table");
                                if (verbose) {
                                    var61.printStackTrace();
                                }
                            }
                        }

                        List<Table> changeTables = new ArrayList();
                        boolean hasChanges = false;
                        int var39;
                        if (deductions.size() != 0) {
                            TableHelper bonusTable = new TableHelper("Bonuses", font, new float[] { 4.0F, 1.0F },
                                    new TextAlignment[] { TextAlignment.LEFT, TextAlignment.CENTER });
                            TableHelper deductionsTable = new TableHelper("Deductions", font,
                                    new float[] { 4.0F, 1.0F },
                                    new TextAlignment[] { TextAlignment.LEFT, TextAlignment.CENTER });
                            double lostMarks = 0.0D;
                            mark = 0.0D;
                            Object[] var79;
                            int var77 = (var79 = deductions.toArray()).length;

                            for (var39 = 0; var39 < var77; ++var39) {
                                Object deduction = var79[var39];
                                String[] d = (String[]) deduction;
                                if (Double.valueOf(d[2]) <= 0.0D) {
                                    if (!d[1].toLowerCase().contains("bonus")) {
                                        if (Double.valueOf(d[2]) > -1.0D) {
                                            double pc = -1.0D;
                                            if (Double.valueOf(d[2]) != 0.0D) {
                                                pc = Double.valueOf(d[2]);
                                            }

                                            double ls = pc * tTotal;
                                            lostMarks += ls;
                                            if (this.showGrades)
                                                deductionsTable.addRow(new String[] {
                                                        d[1] + " (" + (int) Math.ceil(pc * 100.0D) + "%)",
                                                        String.format("%.1f", ls) });
                                            else
                                                deductionsTable.addRow(new String[] { d[1], "-" });
                                        } else {
                                            lostMarks += Double.valueOf(d[2]);
                                            if (this.showGrades)
                                                deductionsTable.addRow(new String[] { d[1], d[2] });
                                            else
                                                deductionsTable.addRow(new String[] { d[1], "-" });
                                        }
                                    }
                                } else {
                                    mark += Double.valueOf(d[2]);
                                    bonusTable.addRow(new String[] { d[1], "+" + Double.valueOf(d[2]) });
                                }
                            }

                            Table cTable;
                            if (mark != 0.0D) {
                                summaryTable.addRow(new String[] { "Bonuses", "+" + String.valueOf(mark) }, font);
                                cTable = bonusTable.getTable();
                                cTable.setWidth(UnitValue.createPercentValue(100.0F));
                                changeTables.add(cTable);
                                hasChanges = true;
                            }

                            if (lostMarks != 0.0D) {
                                summaryTable.addRow(new String[] { "Deductions", String.format("%.1f", lostMarks) },
                                        font);
                                cTable = deductionsTable.getTable();
                                cTable.setWidth(UnitValue.createPercentValue(100.0F));
                                changeTables.add(cTable);
                                hasChanges = true;
                            }

                            tMark += lostMarks;
                            tMark += mark;
                        }

                        tMark = Math.max(Math.min(tTotal, tMark), 0.0D);
                        double grade = tMark / tTotal * 100.0D;
                        Paragraph p = (Paragraph) (new Paragraph((Text) (new Text(nId)).setFont(font)))
                                .setMarginTop(20.0F);
                        if (this.showGrades) {
                            summaryTable.addRow(new String[] { "Total (out of " + String.valueOf(tTotal) + ")",
                                    String.format("%.1f", tMark) }, fontHeader);
                            p = (Paragraph) (new Paragraph(
                                    (Text) (new Text(nId + "\n" + String.format("%.2f", grade) + "%")).setFont(font)))
                                            .setMarginTop(20.0F);
                        }

                        Paragraph p2 = new Paragraph(
                                (Text) (new Text(this.grader.getLetterGrade(grade))).setFont(fontHeader));
                        Table sTable = summaryTable.getTable();
                        ((Table) sTable.setWidth(UnitValue.createPercentValue(50.0F)))
                                .setHorizontalAlignment(HorizontalAlignment.CENTER);
                        if (this.showGrades) {
                            documentHelper.addCoverPage(new IBlockElement[] { (new Paragraph()).add(img), header, p, p2,
                                    (IBlockElement) (new Div()).setMarginTop(20.0F), sTable });
                        } else {
                            documentHelper.addCoverPage(new IBlockElement[] { (new Paragraph()).add(img), header, p,
                                    (IBlockElement) (new Div()).setMarginTop(20.0F) });
                        }

                        if (hasChanges) {
                            documentHelper.addNewPage("Grade Changes",
                                    "Observe any deductions or bonuses that you have incurred or earned.");
                            Iterator var75 = changeTables.iterator();

                            while (var75.hasNext()) {
                                Table t = (Table) var75.next();
                                documentHelper.getDocument().add(t);
                                document.add((IBlockElement) (new Div()).setMarginTop(6.0F));
                            }
                        }

                        String[] var78;
                        var39 = (var78 = this.testClasses).length;

                        for (int var76 = 0; var76 < var39; ++var76) {
                            String test = var78[var76];
                            List<String> tRes = (List) testMap.get(test);
                            Collections.sort(tRes, new Comparator<String>() {
                                public int compare(String lhs, String rhs) {
                                    TestResult l = (TestResult) testResults.get(lhs);
                                    TestResult r = (TestResult) testResults.get(rhs);
                                    if (l.getMark() == l.getTotal() && r.getMark() != r.getTotal()) {
                                        return -1;
                                    } else if (l.getMark() != l.getTotal() && r.getMark() == r.getTotal()) {
                                        return 1;
                                    } else if (l.getType() == "Attribute" && r.getType() == "Constructor") {
                                        return -1;
                                    } else if (l.getType() == "Attribute" && r.getType() == "Method") {
                                        return -1;
                                    } else if (l.getType() == "Constructor" && r.getType() == "Method") {
                                        return -1;
                                    } else if (l.getType() == "Constructor" && r.getType() == "Attribute") {
                                        return 1;
                                    } else if (l.getType() == "Method" && r.getType() == "Constructor") {
                                        return 1;
                                    } else if (l.getType() == "Method" && r.getType() == "Attribute") {
                                        return 1;
                                    } else {
                                        double lPer = l.getMark() / l.getTotal();
                                        double rPer = r.getMark() / r.getTotal();
                                        if (lPer < rPer) {
                                            return -1;
                                        } else {
                                            return lPer == rPer ? 0 : 0;
                                        }
                                    }
                                }

                            });
                            passed = 0;
                            int partial = 0;
                            int totalx = 0;
                            Iterator var88 = tRes.iterator();

                            while (var88.hasNext()) {
                                text = (String) var88.next();
                                if (!blackList.contains(text)) {
                                    if (((TestResult) testResults.get(text))
                                            .getMark() == ((TestResult) testResults.get(text)).getTotal()) {
                                        ++passed;
                                    } else if (((TestResult) testResults.get(text)).getMark() != 0.0D) {
                                        ++partial;
                                    }

                                    ++totalx;
                                }
                            }

                            text = "";
                            if (passed != 0) {
                                text = text + "Passed " + passed + "/" + totalx + "; ";
                            }

                            if (partial != 0) {
                                text = text + "Partially passed " + partial + "/" + totalx + "; ";
                            }

                            if (passed + partial != totalx) {
                                text = text + "Failed " + (totalx - passed - partial) + "/" + totalx + "; ";
                            }

                            if (text.length() == 0) {
                                documentHelper.addNewPage(test + " Class", "");
                            } else {
                                documentHelper.addNewPage(test + " Class", text.substring(0, text.length() - 2) + ".");
                            }

                            tRes.forEach((tx) -> {
                                if (!blackList.contains(tx)) {
                                    documentHelper.addTestResult((TestResult) testResults.get(tx), this.showGrades);
                                }

                            });
                        }

                        documentHelper.getDocument().close();
                        masterSb.append(b[b.length - 2] + "," + String.format("%.2f", grade) + "\n");
                    } catch (Exception var62) {
                        if (verbose) {
                            var62.printStackTrace();
                        }

                        System.out.println("Error parsing info to add to pdf");
                    }

                });
                Iterator var25 = this.corruptedSubmissions.iterator();

                while (var25.hasNext()) {
                    sub = (String) var25.next();
                    masterSb.append(sub + "\n");
                }

                masterWriter.write(masterSb.toString());
                if (this.deleteDir) {
                    Extractor.deleteDir(new File(this.outFolder));
                }

                System.out.println("Done");
            } finally {
                if (masterWriter != null) {
                    masterWriter.close();
                }

            }
        } catch (Exception var24) {
            if (verbose) {
                var24.printStackTrace();
            }

            System.out.println("Error in writing pdf");
        }

    }

    public void notifyCorruptedSubmission(String id) {
        this.corruptedSubmissions.add(id + ",0");
    }

    public void setGrader(GradeScheme grader) {
        this.grader = grader;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setSrcFolder(String srcFolder) {
        this.srcFolder = srcFolder;
    }

    public void setOutFolder(String outFolder) {
        this.outFolder = outFolder;
    }

    public void setTestFolder(String testFolder) {
        this.testFolder = testFolder;
    }

    public void setTestClasses(String[] testClasses) {
        this.testClasses = testClasses;
    }

    public void setDataFiles(String[] dataFiles) {
        this.dataFiles = dataFiles;
    }

    public void setCsvFileHeaders(String[] csvFileHeaders) {
        this.csvFileHeaders = csvFileHeaders;
    }

    public void setImgFolder(String imgFolder) {
        this.imgFolder = imgFolder;
    }

    public void setDeleteDir(boolean deleteDir) {
        this.deleteDir = deleteDir;
    }

    public void setVerbose(boolean verbose) {
        AutoMarker.verbose = verbose;
    }

    public void setShowGrades(boolean showGrades) {
        this.showGrades = showGrades;
    }

    public void setMarkChangesFile(String deductionFile) {
        this.records = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(deductionFile));

            String line;
            try {
                while ((line = br.readLine()) != null) {
                    this.records.add(line.trim());
                }
            } finally {
                if (br != null) {
                    br.close();
                }

            }
        } catch (Exception var14) {
        }

    }

    private List<String[]> getMarkChanges(String id) {
        List<String[]> deductions = new ArrayList();
        this.records.forEach((str) -> {
            if (str.contains(id)) {
                String[] d = str.split(",");
                deductions.add(d);
            }

        });
        return deductions;
    }

}
