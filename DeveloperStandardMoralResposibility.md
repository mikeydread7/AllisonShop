
## Moral Ethics of a Developer:-  Self govern Developer with a universal regards for mankind.
* [https://jeremiahflaga.github.io/memorabilia/videos/expecting-professionalism-by-uncle-bob-martin/] 
* Quotes from Uncle Bob -  Robert C. Martin author of books like Clean Code ,Clean Architecture. 
* Software should be easy to change the behavior of our hardware. If we make it hard to understand, we have done harm. 
1. I will not write harmful code. Release any known defect, make it hard to understand by other developers. 
2. The Code I produce will always be my best work, I will not release code that is not good in behavior or structure. 
3. I will make or provide a sure easy and repeatable proof that the code work as it should. test that delivers the client request. 
4. I will make timely and many frequent releases so as to not impede my fellow developers – no big merge. 
5. Fearlessly and relentlessly improve the code I will not make the code worst. 
6. Keep productivity of the team high. 
7. I will continuously ensure others can cover for me and I can cover for others  - knowledge share, my responsibility I am not the only team member with knowledge, pair programming. 
8. Produce estimate that are honest in size and precision, never ever don’t make false promises or promises without certainty else your lying – make boundaries… like, if all goes well perfectly then it will take 2 days but if it goes as they usually do then 5 days.. 
9. I will never stop learning and improving my craft, we should improve lives. 
* Tools  1.PMD- program mistake Detection   2. SonarJava  Rule  3. JavaAntiPattern. 
* Take to heart the understanding that my contribution to life as it exist and the writing of software as being the most important thing in today’s world

## The Inspiring Developer and one that cares about the code they write
1. Separation of concerns. Divide your application into distinct features with as little overlap in functionality as possible. ... 
2. Single Responsibility principle. ... 
3. Principle of Least Knowledge (also known as the Law of Demeter or LoD). ...  
4. Don't repeat yourself (DRY). ...  
5. Minimize upfront design. 

## Some simple Code standard -

1. Code layout and implementation , like declarations and body properties should stay together 

   * imports... 
   * static 
   * varaibles 
   * constructors 
   * public methods 
   * private methods 
   * @Test 
   * Documenting the interface signitures is a good thing for javadoc generation
   * all public signiture declaration are pulic by default its usless to say public again unless its java 8 some are defaults  
   * enums by default have private constructor no need to say private 
   * don't throw exception where its not thrown AKA jisis is thrown like crazy in our code base annoying 
  
2. use single (, remove usless brace
3. remove unused imports
4. smaller or refactor out logic into a private methods that define the intent
5. Try to move away from null checks
6. Try to remove all warnings when possible use the sonar guide and the blaring yello marks in the side of file
7. Take advantage of the Spell checker of the IDE
8. No Need for explicit if else logic to return a simple true or false just return the results of the check logic
9. Code smell, passing a boolean to a method violates the single resposibility rule and leads to bugs,
   mutations and all kinds of unexpected results.
   don't sleep unnecessarily wasting cpu usage/cycle try find an alternative way to wait  lock, thread...
10. Reduce your test to a single unit for controllable and predictable results. Single responsibility rule.
11. Use the IDE code formatter or shortcut keys
12. Be responsible in taking pride in our craft, Joy and respect. We are Geniuss and Gods.

## Development standards
Naming
* Express what the class/varaibles/Method  clearly doe as possible in the name it should not be obscure or misleading
* Make the name as long as you need. You have 244 charracter for identeifiers in java.
Consistent levels of abstraction (SLAP)
*	If the responsibility of a method is simple enough, implement it in the method with no calls to dependencies
*	If the responsibility of a method requires sending a message to a dependency, everything the method does should send a message to a dependency.
Single responsibility
*	A class should do one thing.  If it is in danger of doing more than one thing, defer to a dependency.
*	Collaboration is responsibility.
Method length
*	A method should be 5 lines or fewer, with no line breaks.  If you feel the urge to add a blank line consider breaking the code into multiple methods or extract classes.
*	If your method goes above 5 lines consider decomposing it into multiple methods or classes.
One control structure per method
*	Only have one if/for/while/case statement per method.  Any code that can branch or run in a non-linear mode is a source of complexity.
One executable line per control structure
*	Within the body of a control structure only allow a single executable statement.  If you need more than one extract methods or classes.  This is especially true if you next a control structure.
Clear intent
*	Whenever possible make the code clearly express what it does.  The name of class/method/variable should never be allowed to mislead the reader.
Favor immutability
*	If a class needs a dependency to perform its function add it as constructor argument.
*	Do not share dependencies or allow them to be modified outside of the class that owns the dependencies.

# Testing standards
Naming
*	Test name should describe what is being tested
*	Test name should include description of expected outcome
*	Test name does not need to begin or end with “Test”
Arrange, Act, Assert
*	Separate each section with a single blank line
Should test one thing
*	If you need to use the word “and” to describe what the test is doing break it into multiple tests
*	If you are asserting and verifying in a single test consider breaking it into multiple tests
Mock out dependencies we own
*	Mock out anything we have the power to change (code in our repositories)
*	Do not mock out third party dependencies.  Instead, create an adapter layer on top of it and mock that.
Create integration tests for dependencies we don’t own

*	If you create an adapter for a third party dependency, write an integration test if needed.
*	Consider fakes for dependencies that are slow to communicate (database, rest services, remote file system)

  



