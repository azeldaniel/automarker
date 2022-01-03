
import com.azeldaniel.automarker.AutoMarker;
import com.azeldaniel.automarker.marker.GradeScheme;

public class MarkA1 {
    private static class UWIUndergraduateGradeScheme implements GradeScheme {
        private UWIUndergraduateGradeScheme() {
        }

        public String getLetterGrade(double grade) {
            int[] gradeLowest = new int[] { 90, 80, 75, 70, 65, 60, 55, 50, 45, 40, 0 };
            String[] grades = new String[] { "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "F1", "F2", "F3" };

            for (int i = 0; i < gradeLowest.length; ++i) {
                if (grade >= (double) gradeLowest[i]) {
                    return grades[i];
                }
            }

            return "F3";
        }
    }

    public static void main(String[] args) {
        AutoMarker marker = new AutoMarker();
        marker.setGrader(new UWIUndergraduateGradeScheme());
        marker.setInstitution("The University of the West Indies, St. Augustine");
        marker.setCourse("COMP 2603 Object Oriented Programming I");
        marker.setAssessment("Assignment 1");
        marker.setSemester("2020/2021 Semester 2");
        marker.setSrcFolder("src/data/");
        marker.setOutFolder("src/out/");
        marker.setMarkChangesFile("src/changes.csv");
        marker.setTestFolder("src/test");
        marker.setImgFolder("img");
        marker.setDataFiles(new String[0]);
        marker.setCsvFileHeaders(new String[] { "ID number", "Assignment:Assignment 1 Submission Area (Real)" });
        marker.setTestClasses(new String[] { "VirtualMeetingSystem", "VirtualRoom", "BreakoutRoom", "Participant" });
        marker.notifyCorruptedSubmission("816020695");// corrupted zip file
        marker.setVerbose(false);
        marker.setDeleteDir(false);
        marker.setShowGrades(true);
        marker.mark(30000L);
    }
}
