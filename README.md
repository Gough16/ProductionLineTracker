# Production Line Tracker
## Object-Oriented Programming(OOP) Project

This program is software for a media player production facility.
I am programming this as my first object oriented project in my junior year at Florida Gulf Coast University.

## Demonstration 
### Adding a product 
![Gif Demonstration of adding a product](https://media.giphy.com/media/gM0e1yIwNe6RLSwXhO/giphy.gif)

### Producing a product
![Gif Demonstration of producing a product](https://media.giphy.com/media/SpolCZ9n00FJ9sE33M/giphy.gif)

### Displaying employee information
![Gif Demonstration of employee information](https://media.giphy.com/media/fwndSWSOcNXh7gqHOf/giphy.gif)

### Handling errors
![Gif Demonstration of error handling](https://media.giphy.com/media/lOm0hNxnsRG1poMRVI/giphy.gif)

## Documentation 

### Sprint 1 

During this sprint, in the development of the media player production, 
I implement Gui into the project by adding buttons, a comboBox and text fields. 
This sprint also involves connecting to a database for the first time, inserting values 
and displaying those values to the console.

### Sprint 2

During sprint 2, I began by setting up an enum that would store information for the Item type.
I then set up an interface that would force all classes to implement certain methods that were 
contained within that interface. Then, I implemented constructors, methods, and to strings to return
values to the user. Classes Multimedia control, AudioPlayer, MonitorType, ScreenSpec, Screen and 
Movie Player were created in this sprint, but are not implemented in the UI. Instead, we test these 
classes with a class named testMultimedia. testMultimedia will test these classes constructor, methods 
and to strings by getting using test values. These test values get printed on the console at the
beginning of the program. Also, I created a class ProductionRecord with accessors and mutator for all 
of the fields within the class. In the productionRecord class, I have a default and overloaded constructor
that I use to set the instance variable. The ProductionRecord class is used for our textarea and 
productionRecord database. This allows us to print the product to the text area with a to string and 
display the products that have been produced. 

### Sprint 3

During sprint 3, I implemented adding products to the database by accepting user input. Once I accepted 
the users information, I was able to add that information to the DB with methods that inserted the 
information to the db. Once we have information in the db, we can use that information to select the items
from the database and display that information to the user. I have also added an employee tab in this 
sprint that allows the user to enter in their information into text fields and displays their 
username, password, email, and temporary password to a list view (does not store the information, but 
could be implemented later on). This sprint includes handling error, that eliminates the user from  
accidentally adding in blank values for product that could cause problems in the database and flow of 
the overall program.

## Diagrams

## Getting Started -> Software needed

In order to get this project running, on your local computer for demonstration/testing, 
you must have Intellij (IDE) installed on your computer. 
Once you have that installed, you will get the link to this repository and pull it to you
intellij program to get it running.

## Built With

* IDE's Used:
    * Intellij
    * SceneBuilder
    
## Author

Michael Gough

## License

This project is licensed under the MIT License.

## Author

Michael Gough

## Acknowledgments

* Professor Scott Vanselow
* Stacked overflow -> styling css (listView)
* GeeksForGeeks -> method overloading 
* Oracle
* Regex 101 -> regular expression 
* https://giphy.com -> creation of gif

## History

This program was last updated on 12/13/2019

## Key Programming Concepts Utilized

In this program, I utilized the concepts that I learned in Java in my Object Oriented Programming class.
I've used scene builder to help me build my program environment, and a css file to create a custom 
look to the environment. I've connected to the database and inserted values to it.
