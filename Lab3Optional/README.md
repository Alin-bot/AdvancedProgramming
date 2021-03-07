  Firstly I made a city named "Iasi". Then I made all the classes from the problem, some with ranking, those who can have ranking, some with prices for the tickets, and some with opening and closing hours.
The Restaurant class has the default hours of 9:30 and 20:00, aquired by calling, for each location, a method from Visitable interface, and the class Location will atribute
the respective hours with the help of a construcor. Location implements Visitable because, in my opinion, each Location has a timetable, therefore each location should be visitable.
  In the class City I made a method which is going thru all the curent locations of the city and is checking if The locations are Visitable and not Payable. After that an override
in the Location class is made for the toCompare method so that our list will be sorted by openingTime. (isFreeToVisit)
  To print out the time that a location is opened (the time between opening and closing time) we will use a method which takes an object and makes the diference between those
2 times with Duration.between, and the parameters opening time and closing time of that object. To acces it we'll use Visitable.getVisitedDuration(v), v being the object.
  In TravelPlan class we will make an array of integers which will store the preference number for each location and new instance city. With the help of an constructor and
by taking as parameter the city, we will copy that city with all the locations in it and go thru all of them, asking the user the preference number of each location, so that
we can store them in our preference array.
