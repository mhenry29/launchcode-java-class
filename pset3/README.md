PSET 3
======

Here are some good references to check out before/while you work on this pset:

* [What is an interface?](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html)
* [Java documentation for interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
* [Interfaces vs. Inheritance] (http://stackoverflow.com/questions/8531292/why-to-use-interfaces-multiple-inheritance-vs-interfaces-benefits-of-interface)
* [Java Exception Lesson](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
* [Exceptions tutorial](http://www.tutorialspoint.com/java/java_exceptions.htm)

#Netflix

Your task for this problem set is to create your own version of Netflix. Netflix consists of different movies and TV shows that can be watched on demand.

Your first task is to create a `Watchable` interface. Consider what movies and TV Shows have in common, then define the interface. In particular, your interface should be able to answer the following questions:

* Is this a TV show or a movie?
* What is the running time of this show/movie?
* When was it created?
* Who is responsible for creating it?

#Implementing your interface

Once you are satisfied with your interface, you should implement it. Create a `TVShow` class and a `Movie` class that implements your interface. For `TVShow` you should make sure to include the following functionality:

* How many episodes are there?
* How many episodes have I watched?

Write tests for your classes to ensure that they behave in the way you expect. Hint: implementing a `toString()` method in your classes will make the next part a lot easier!

#Putting it all together

Create a `Netflix` class that contains a set of TV Shows and movies for people to watch. You should also include an user interface that allows users to select TV Shows and Movies that they want to watch. It might look something like this:

========

Welcome to Netflix! Please make a selection:

1. See a list of TV Shows.<br>
2. See a list of Movies.<br>
3. See a list of all TV Shows and Movies that you have watched.<br>
4. Exit.<br>

Please make a selection:

=========

The user at this point could enter a menu selection. If they select to see a list of Movies, for example, the menu would then display all of the movies that are in the system and allow the user to select one that they would like to watch.

Use data validation to make sure the user selects an appropriate value. If they select an option that doesn't exist (or worse, give you an option that isn't even a number), prompt them to enter a different value until they give you one that is acceptable. Test this piece thoroughly to make sure that it can handle various incorrect inputs without crashing.

#Extra stuff

Consider the `Movie` class. Movies actually come in to primary forms: documentaries and narratives (which include comedies, dramas, etc.). How would this design change if you wanted to incorporate these two types of movies into your program? Implement and test your design.