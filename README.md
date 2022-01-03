# DCIT Java AutoMarker

Intended for use by UWI STA tutors, teaching assistants and lecturers in Computer Science.

## How to Use

Define a file (e.g. A1.java) with the following contents. This will be used to run your code.

### Step 1

Define the UWI Undergraduate (or other) grading schema like below. This can be done in the same main java file.

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

### Step 2

Define and AutoMarker instance in the main method like below. This instance has several methods such as ```mark()``` and other to set some pdf properties.

```java
AutoMarker marker = new AutoMarker();
```

### Step 3

Define attributes for the generated pdf headers:

```java

marker.setInstitution("The University of the West Indies, St. Augustine");
marker.setCourse("COMP 2603 Object Oriented Programming I");
marker.setAssessment("Assignment 1");
marker.setSemester("2021/2022 Semester 2");
```

### Step 4

Define the important folders that we will use during marking.

#### Data Folder
This will be used to get the student's submissions. The submissions must be had directly from myElearning. The folder should contain any amount of folders, each with exactly **1 zip file** inside. The zip file must be named in the format **firstName_lastName_IDNumber_A#.zip** e.g. John_Doe_816000000_A1.zip. Their submissions can only contain .java files, all other files will be ignored.

```java
marker.setSrcFolder("src/data/");
```

#### Test Folder and Test Cases

This will be used to inject test files into each of the students' submissions. You are expected to put your fully working solution files e.g. Pilot.java along with its corresponding test file e.g. PilotTest.java. You can place as many test files in this folder as you like. You must indicate to the the AutoMarker which test files to consider using the `setTestClasses()` function (excluding the Test suffix).

```java
marker.setTestFolder("src/test");
marker.setTestClasses(new String[] { "Pilot", "Plane" });
```

#### Output Folder

This is where the extracted student files will temporarily be placed. The generated pdfs and final mark scheme will also be placed here.

```java
marker.setOutFolder("src/out/");
```

#### Data Files (optional)
If you have any data files that must be used the students' submissions e.g reading plane data from a file, you have to specify the name of those files. The file will be copied by the AutoMarker before marking each submission.

```java
marker.setDataFiles(new String[] {"planes.tst"});
```

#### Other Options

All other options are optional.

Method | Description
--- | ---
`setImgFolder("src/img")` | Sets the image directory to look for a `logo.png` file.
`marker.setMarkChangesFile("src/changes.csv")` | Sets a grade modification file. This file can be used to give students a zero (0), deduct marks (-1, -2, -0.5 for 50% etc), award bonuses (5, 10, .1 for +10% etc)
`setCsvFileHeaders(new String[] { "ID number", "Assignment:Assignment 1 Submission Area (Real)" })` | Used to set the csv headers for myElearning. This will change based on the name of your submission box.
`notifyCorruptedSubmission("816000000")` | Used to tell the marker that there is a submission that isn't worth marking e.g. compilation issues, too many missing files etc.
`marker.setVerbose(false)` | Tells the marker whether to spam you with console logs ;)
`marker.setDeleteDir(true)` | Tells the marker whether to delete the compiled student submissions. Do not delete if you want to peruse student code in the temp folder.
`marker.setShowGrades(false)` | Tells the marker whether to show the grades to the students. Perfect for first draft results released to students.

### Step 5

You can then mark the submissions like below.

```java
marker.setGrader(new UWIUndergraduateGradeScheme());
marker.mark();
```

## Example

See the example folder for a past assignment from the COMP 2603 course. *Please use discretion when accessing student submissions.*