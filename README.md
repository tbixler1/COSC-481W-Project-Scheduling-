# COSC-481W-Project-Scheduling-
Scheduling software being developed for the Eastern Michigan Math Lab

These files implement the final .xls output. Ultimately they will take input from the GUI.
3 sheets are currently active in the main workbook:
  Sheet 0: the "master", which will show all the names of the tutors and what times they work.
  Sheet 1: the "tutors", which will show each tutor's schedule individually on a row
  Sheet 2: the "courses", which is identical to "tutors" except it contains that info for the courses.
A second master sheet can be added if necessary to show when all the courses are being tutoreed.

Requires a free, 3rd party library to create and manipulate the .xls files, which can be found here:
  http://sourceforge.net/projects/jexcelapi/files/
