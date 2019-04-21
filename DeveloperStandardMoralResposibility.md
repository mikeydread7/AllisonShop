
## Moral Ethics of a Developer:-  Self govern Developer with a universal regards for mankind.
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

