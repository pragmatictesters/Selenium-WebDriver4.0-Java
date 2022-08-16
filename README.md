# Java for Software Testers 
Java essentials training program for test automation engineers. 
This project is created to share Java Essentials training project with the Pragmatic testsers.

## Prerequisites 


### Software  
We need following Software for the training
1. [IntelliJ IDEA community edition](https://www.jetbrains.com/idea/download)
2. [JDK 18 LTS](https://www.oracle.com/java/technologies/downloads/)


## Course Content 
1. Getting started 
   1. Installing JDK 
   2. Installing IntelliJ IDEA 
   3. Creating a Maven project 
   4. Take a tour of IntelliJ IDEA 
   5. Java syntax and compilation 
   6. Using Java API documentation 

2. Working with Java variables 
   1. Naming convention 
   2. Working with primitive variables
   3. Working with boolean values 
   4. Java operators 
   5. String objects 
   6. Concatenate string values 
   7. Compare string values 
   8. Parse string values 
   
3. Managing program flows 
   1. Evaluating conditions with if-else
   2. Evaluating conditions with switch-case 
   3. Creating loops 
   4. Creating reusable code with methods
   
4. Using data collections 
   1. Using simple arrays
   2. Working with ArrayList 
   3. Looping through collections with for-each
   
5. Working with Java Classes 
   1. Naming convention 
   2. Creating packages
   3. Creating and instantiating custom classes 
   4. Instance variables
   5. Instance and static methods 
   6. Using static variables as constants 
   7. Extending classes
   
6. Working with IntelliJ IDEA 
   1. 
   
7. Working with third-party libraries 
   1. Java-faker for generating random data 
   2. Managing files with Apache commons 
   3. Log4j2 for logging 
   


# Location Strategies 
Locating web element 
1. Locate element by XPath 
2. Locate element by ID
3. Locate element by Name 
4. Locate element by className 
5. Locate element by tagName 
6. Locate element by CSS 
7. Locate element by linkText 
8. Locate element by partialLinkText 
9. Locate element by ID or name 
10. Locate elements relative to other elements 
11. YOU CAN CREATE YOUR OWN (CUSTOM) LOCATORS


# Mastering CSS

<input class="input_error form_input" 
placeholder="Username" type="text" data-test="username" id="user-name" name="user-name" 
autocorrect="off" autocapitalize="none" value="">

1. Locating elements with ID
     #ID
     #user-name

2. With tag name and ID <br>
   <tagName>#<ID>
   input#user-name

3. Locating elements with Classname
   .<className>
   .submit-button

4. Locating element with tag name and a classname 
   <tagName>.<className>
   input.submit-button

5. Locating elements with multiple class names 
   .<className1>.<className2>[.<className3>]
   .submit-button.btn_action
   
6. Locating elements with multiple class names and the tag name
   <tagName>.<className1>.<className2>[.<className3>]
   input.submit-button.btn_action

7. Locating elements with an attribute only
   [<attributeName>]
   [placeholder]

8. Locating elements with an attribute and associated value 
   [<attributeName>='<attributeValue>']
   [placeholder='Username']

9. Locating element with a tag name , attribute and it's value
   <tagName>[<attributeName>='<attributeValue>']
   input[placeholder='Username']

10. Absolute path [NEVER USE THIS. THIS IS BRITTLE AND LONGER]
    html > body>div>div>div:nth-child(2)>div>div>div>form>div>input

Locate the elements with dynamic attribute values

11. Locating elements with attribute's value prefix
    [<attributeName>^='<attributeValue>']
    [placeholder^='User']

12. Locating element with attribute value's suffix 

   [<attributeName>$='<attributeValue>']
   <tagName>[<attributeName>$='<attributeValue>']

   [placeholder$='name']
   input[placeholder$='name']

13. Locating element with attribute value's substring
    [<attributeName>*='<attributeValue>']
    <tagName>[<attributeName>*='<attributeValue>']

    input[class~='form_input']

14. Locating the elements with multiple attributes 

   [<attribute1>=<value1>][<attribute2>='<value2>']
   [id='user-name'][type='text']

15. Locate the first child from siblings 
   <css-of-element>:first-child
  .inventory_list>div:first-child

16. Locate the immediate following sibling 
   <css-of-element> + *
    <css-of-element> + <css-of-following-element>

18. Locate the all following sibling
    <css-of-element> ~ <css-of-following-element> 




























## References 
