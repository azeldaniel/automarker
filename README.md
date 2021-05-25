# Java AutoMarker

Intended for use by University of the West Indies tutors and teaching assistants.

## How to Use

Define a grading schema:

```java
private static class UWIUndergraduateGradeScheme implements GradeScheme {

        @Override
        public String getLetterGrade(double grade) {
            int[] gradeLowest = { 90, 80, 75, 70, 65, 60, 55, 50, 45, 40, 0 };
            String[] grades = { "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "F1", "F2", "F3" };
            for (int i = 0; i < gradeLowest.length; i++)
                if (grade >= gradeLowest[i])
                    return grades[i];
            return "F3";
        }
    }
```

Define and AutoMarker instance:

```java
AutoMarker marker = new AutoMarker();
```

Define other attributes used for testing:

```java
marker.setGrader(new UWIUndergraduateGradeScheme());
marker.setInstitution("The University of the West Indies, St. Augustine");
marker.setCourse("COMP 2603 Object Oriented Programming I");
marker.setAssessment("Assignment 1");
marker.setSemester("2020/2021 Semester 2");
marker.setSrcFolder("src/data/");
marker.setOutFolder("src/out/");
marker.setTestFolder("src/test");
marker.setImgFolder("src/img");
marker.setMarkChangesFile("src/changes.csv");
marker.setDataFiles(new String[] {});
marker.setCsvFileHeaders(new String[] { "ID number", "Assignment:Assignment 1 Submission Area (Real)" });
marker.setTestClasses(new String[] { "VirtualMeetingSystem", "VirtualRoom", "BreakoutRoom", "Participant" });
marker.notifyCorruptedSubmission("816018640");
marker.setVerbose(false);
marker.setDeleteDir(true);
marker.setShowGrades(false);
```

Then mark the submissions:

```java
marker.mark();
```