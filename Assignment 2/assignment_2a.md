# QUESTION 1
Dewei Yu  
**1)**  
|Test case    |Test Sceranio|Test steps  |Test data    |Expected result|
|:----------- |:----------- |:-----------|:-----------|:--------------| 
|TC1          |Check if the assert email ID comform to be the standarad format|1. Go to site<br>2.Go to the login website<br>3.Enter email<br>4. Click submit|Email: Just ``ID`` has entered|``id@domain``|
|TC2          |Check if the assert email ID comform to be the standarad format|1. Go to site<br>2.Go to the login website<br>3.Enter email<br>4. Click submit|Email: Just ``@`` has entered|``id@domain``|
|TC3          |Check if the assert email ID comform to be the standarad format|11. Go to site<br>2.Go to the login website<br>3.Enter email<br>4. Click submit|Email: Just ``domain`` has entered|``id@domain``|
|TC4          |Check if the assert email ID comform to be the standarad format|1. Go to site<br>2.Go to the login website<br>3.Enter email<br>4. Click submit|Email: NO ``id``,just ``@`` and ``domain`` has entered|``id@domain``|
|TC5         |Check if the assert email ID comform to be the standarad format|1. Go to site<br>2.Go to the login website<br>3.Enter email<br>4. Click submit| Email: NO ``@``, just ``id`` and ``domain`` has entered|``id@domain``|
|TC6         |Check if the assert email ID comform to be the standarad format|1. Go to site<br>2.Go to the login website<br>3.Enter email<br>4. Click submit|Email: NO ``domain``, just ``id`` and ``@`` has entered|``id@domain``|


**2)** 
O: ordering  
All ECE courses are prerequisites for any SENG course
|Test case    |Test Sceranio|Test steps  |Test data    |Expected result|
|:----------- |:----------- |:-----------|:-----------|:--------------| 
|TC1          |Check student eligibility to registrate courses|1. Go to site <br>2.enter email ID <br>3.enter password <br>4.Select registration page <br>5. selecting courses<br> 6.Click Submit|Select 2 ECE course in term 1, taking 2 SENG course in term 2 | Student should taking all ECE courses before taking any SENG courses
|TC2          |Check student eligibility to registrate courses|1. Go to site <br>2.enter email ID <br>3.enter password <br>4.Select registrationn page <br>5.Selecting courses <br>6.Click Submit|Select one ECE course in term 1, taking 2 SENG course in term 2 and 1 ECE course in term 3| Student should taking all ECE courses before taking any SENG courses
|TC3          |Check student eligibility to registrate courses|<br>1. Go to site <br>2.enter email ID <br>3.enter password <br>4.Select registration page <br>5. selecting courses <br>6.Click Submit|Select 2 seng course in term 1, taking 2 ECE course in term 2 | Student should taking all ECE courses before taking any SENG courses
|TC4          |Check student eligibility to registrate courses|1. Go to site <br>2.enter email ID <br>3.enter password <br>4.Select registration page <br>5.Selecting courses <br>6.Click Submit|Select 1 seng course and 2 ECE Course in term 1, taking 1 SENG course in term 2 | Student should taking all ECE courses before taking any SENG courses
|TC5          |Check student eligibility to registrate courses|<br>1.Go to site <br>2.enter email ID <br>3.enter password <br>4.Select registration page <br>5.selecting courses<br>6.Click Submit|Select 2 ECE course and 2 SENG course in erm 1 | Student should taking all ECE courses before taking any SENG courses

**3)**   
Range: Age should always between 15 and 70(15 and 70 include) 
|Test case    |Test Sceranio|Test steps  |Test data    |Expected result|
|:----------- |:----------- |:-----------|:-----------|:--------------| 
|TC1          |Check if the student age is whitin the limit|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Select age<br>5.Type age<br>6.Click Submit|age is 14| Student age is not inside the limit
|TC2          |Check if the student age is whitin the limit|1. Go to site<br>2.enter email ID<br>3.enter password<br>4.Select age<br>5.Type age<br>6.Click Submit|age is 15| Student age is inside the limit
|TC3          |Check if the student age is whitin the limit|1. Go to site<br>2.enter email ID<br>3.enter password<br>4.Select age <br>5. Type age <br>6.Click Submit|age is 25| Student age is inside the limit
|TC4          |Check if the student age is whitin the limit|1. Go to site<br>2.enter email ID<br>3.enter password<br>4.Select age<br>5. Type age 6.Click Submit|age is 70| Student age is inside the limit
|TC5         |Check if the student age is whitin the limit|1. Go to site<br>2.enter email ID<br>3.enter password<br>4.Select age <br>5.Type age<br>6.Click Submit|age is 71| Student age is not inside the limit

**4)**
Reference:  
The student enter the correct user ID amd password to be consider given the correct credential to access the register website  

|Test case    |Test Sceranio|Test steps  |Test data    |Expected result|
|:----------- |:----------- |:-----------|:-----------|:--------------| 
|TC1          |Check if the student enter the correct credentials|1.Go to site<br>2.enter email ID<br>3.enter password<br>5.Click Submit|Students enter the correct ID and password| The student get acess when they enter the credentials(i.e the correct email ID and password)
|TC2          |Check if the student enter the correct credentials|1.Go to site<br>2.enter email ID<br>3.enter password<br>5.Click Submit|Students enter the wrong ID but the correct password| The student get acess when they enter the credentials(i.e the correct email ID and password)
|TC3          |Check if the student enter the correct credentials|1.Go to site<br>2.enter email ID<br>3.enter password<br>5.Click Submit|Students enter the wrong ID and password| The student get acess when they enter the credentials(i.e the correct email ID and password)
|TC4          |Check if the student enter the correct credentials|1.Go to site<br>2.enter email ID<br>3.enter password<br>5.Click Submit|Students enter the correct ID and wrong password| The student get acess when they enter the credentials(i.e the correct email ID and password)

**5)**  
Existence- When one registers for the courses, they are checked in the database to make sure they are being offered in that term and thus they exist in the particular term table in the database. Write test cases for that

|Test case    |Test Sceranio|Test steps  |Test data    |Expected result|
|:----------- |:----------- |:-----------|:-----------|:--------------| 
|TC1          |Check if the course offered in the term|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Go to registration website<br>5.selcting term 5.enter the course name<br>6. click submit|Student enter the wrong course name| The course is offered in the term
|TC2          |Check if the course offered in the term|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Go to registration website<br>5.selcting term 5.enter the course name<br>6. click submit|Student select a particular course| The course is not offered in the term


**6)**
Cardinarity
|Test case    |Test Sceranio|Test steps  |Test data    |Expected result|
|:----------- |:----------- |:-----------|:-----------|:--------------| 
|TC1          |Check if student select any course|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Go to registration website<br>5.selcting term<br>6.select course<br>7. click submit|Students  not select any courses| A Messages display at least one course has to be selected|
|TC2          |Check if student can enroll to a course|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Go to registration website<br>5.selcting term<br>6.select course<br>7. click submit|Students  select 1 ECE course| 1 course has been selected|
|TC3         |Check if student can enroll to a course|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Go to registration website<br>5.selcting term<br>6.select course<br>7. click submit|Students select 2 ECE courses| A listed created showing 2 ECE course has been selected|
|TC4         |Check if student can enroll to a course|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Go to registration website<br>5.selcting term<br>6.select course<br>7. click submit|Students select 1 SENG course| Course cannot be enrolled because of the prerequisite
|TC5         |Check if student can enroll to a course|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Go to registration website<br>5.selcting term<br>6.select course<br>7. click submit|Students  select 1 SENG and 1 ECE course| Course cannot be enrolled beccause of have to take all ece course before taken any of SENG course
|TC6         |Check if student can enroll to a course|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Go to registration website<br>5.selcting term<br>6.select course<br>7. click submit|Students  select 2 SENG courses| Course cannot be enrolled 

**7)**    
Test cases to timeout a test if connection to the database
cannot be made because of network or other issues

|Test case    |Test Sceranio|Test steps  |Test data    |Expected result|
|:----------- |:----------- |:-----------|:-----------|:--------------| 
|TC1          |Check if there is a timeout|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Go to registration website<br>5.selcting term<br>6.enter the course name<br>7. click submit|The database has been offline|Connection to the database cannot be made because of network or other issues
|TC2          |Check if there is a timeout|1.Go to site<br>2.enter email ID<br>3.enter password<br>4.Go to registration website<br>5.selcting term<br>6.Enter the course name<br>7. click submit|There is network failure to connect to the database| Connection to the database cannot be made because of network or other issues
