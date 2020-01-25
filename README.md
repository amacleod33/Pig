
# Project 1

For the first programming assignment, you will write a program called Pig. 
The directions for Pig are at [Pig Game](<https://en.wikipedia.org/wiki/Pig_(dice_game)>)

Read above link and this entire README assignment prior to starting to code!

This is a two part assignment.
1) Flow/logic digram (due 31-Jan)
2) Working code (due 7-Feb)


 
## Details about the code

The Application Programming Interface (API) that you should implement is here: 
[Pig API](https://www.pcs.cnu.edu/~lambert/Pig/Pig.html)

The API defines the specific methods you must create, including method name, 
return type, and parameters.



### Fields

You will need to have 3 fields. Fields are variables that are declared outside of any method. So, your class declaration should look like:
<pre>
public class Pig
{
    /**  proper javadoc  */ 
    static final String YES = "Y";

    /**  proper javadoc */
    static final String NO  = "N";

    /**  proper javadoc  */
    static Random randGen;

  //  ... the rest of the code with all of your methods...
  //      including main( )
  
  }
</pre>
The advantage of having the constant YES and NO is to avoid "magic" constants, 
which is bad programming practice 
( [Magic_number_(programming)](<https://en.wikipedia.org/wiki/Magic_number_(programming)>)
, look at the unnamed constants section).

The randGen object will be used to generate random numbers throughout the program as described in Zybooks, section 1.6.

We will discussed the modifiers `static` and `final` in detail later in CPSC 255.  For now, `static` means that the 
field is shared among all *instances* of the class.  The `final` modifier means that this value is a 
*constant* that cannot be changed by the program.  By default, since we did not declare these variables `public`, 
they are `private` and cannot be used outside of this class.

Write the smaller methods (that are called by the other methods first). You can use this main:
<pre>
   public static void main(String[] args)
   {
       Scanner kbd = new Scanner(System.in);
       randGen = new Random();
       playGame(kbd);
       String answer = getYNAnswer(kbd, "Do you want to play again?");
       while (answer.contentEquals(YES))
       {
           playGame(kbd);
           answer = getYNAnswer(kbd, "\n\nDo you want to play again?");
       }
       System.out.println("Thank you for playing. Good bye.");
       kbd.close();
   }
</pre>

## Flow chart/logic 

*Prior* to starting to code, you must think through the requirements and generate either:
 1) Flow chart showing logic and loop flow 
 2) Pseudo code
 
 This should include decision points (e.g. loop conditions, if-else), and 
 identify major API methods that will be called.
 Include the `main` logic given above.
 
 This, either neatly hand written and presented as scanned PDF or image, or as 
 a prepared Word Doc/PowerPoint slide, must be submitted to Scholar *before* you 
 start coding.  
 
 This design phase is the most important part of programming.  
 Always, think *before* you put fingers on the keyboard!
 
 Submit this program logic requirements on Scholar *before* you start to code!

 

## Partners

For this first project, you may choose to have a programming partner or not. 
If you do, I recommend that you choose one repo as the working repository. 

Do your pushes to that repository only.

If you and partner agree to work together, then one of you Email me your partners name
 and be sure to cc (carbon copy) your partner on the email.

Each time you work on the program,
*git pull* it from that repository, then *git push* your changes when you
are done.  Your partner then *git pull*, edit, *git push*, and the cycle repeats.
You must work together and coordinate your pushes and pulls.

Partners should show a comparable amount of git commits with meaningful comments.

One partner maintain the repo, should add the other 
partner as a "developer" under this project (*not the group*)!

Each partner submit their own copy of the flow diagram to scholar.  
If joint effort, put both names on document.

## Suggestions

Carefully workout the logic design first.

Then, write one method per day and test.  Use you logic/flow diagram to determine 
which methods you should write first; e.g. if method A calls method B, then write B first and test, 
so that you can immediately test A when you write it.
 
As you write each method, make sure your methods pass all unit tests. 
**Push your changes at the end of every session.**

## Progress

You should make significant progress on the project early on. 
10 points of the program will be consistent, significant pushes 
(at least one working method at least 2 times/week).

## Sample Run

I recommend that you run your program outside of Eclipse to get a better idea of how the program runs. 
Here is a link to sample game output:
[Sample Game](https://www.pcs.cnu.edu/~lambert/Pig/SampleRun.html)


Your output does not have to match mine, but should be descriptive. 
You should be able to play the program outside of Eclipse, and 
I recommend that you do because the small console window in Eclipse 
does not allow you to see how the user and computer are accruing points.

## Due Date

Pig.java is due Monday *February 3 at 11:59pm*. 

You only need to turn the flow chart in to scholar by 31-Jan.

All other submissions are to GitLab/WebCAt.  Make sure that your 
tests pass on WebCat and that you use proper style as graded by WebCAt. 

I will clone your repository and manually grade portions of the code.

## Rubric  (100 points total)

 * Flow chart   ( 10 points - due on scholar before any commits)
 * Style        ( 20 points WebCAT)
 * JUnit tests  ( 20 points WebCAT)
 * Code Quality ( 20 points instructor review)
 * Game play    ( 20 points instructor review)
 * Git usage    ( 10 points - reasonable git log, with both partners committing)
 