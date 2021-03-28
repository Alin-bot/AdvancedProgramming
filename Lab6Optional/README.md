Download JavaFX: https://openjfx.io/ Download IntelliJ

New Project -> Java FX -> Next -> name -> Finish -> Ctrl + Alt + Shift + S -> Libraries -> + -> lib directory from JavaFX file that you downloaded -> OK -> Ok -> Apply -> OK

Run -> EditConfiguration -> Modify options -> Add VM options -> VM options: "--module-path /path/to/javafx/sdk --add-modules javafx.controls,javafx.fxml" (giving the path of the lab from the JavaFX file)


  We start in main where we launch our application MainFrame.
  In MainFrame we initialize our Panels by creating new objects of our classes and than adding them, in order, in a BorderPane so we can arrange them in the structure 
that we need. Styling a little bit using CSS and then making our scene using the BorderPane. Our stage gets the scene and then we display it.
  ConfigPanel makes up our top part of the BorderPane, which is a HBox, and is consisting of 2 Labels and 2 TextFields, where we pass the size and the sides of
polygons. A menu is made so that we can check which color we want to use for our shapes. All of that being added to or HBox and then aling in the center.
  DrawingPanel makes up our canvas, center part, which in that case is a AnchorPane, with a color, which will be changed depending on the color from ConfiPanel. A string,
which represent the shape that we need to draw, is present in our DrawingPanel too, and can be modified by ShapePanel. Whenever the mouse is pressed, a shape will be drawn, and when the secondary button of the mouse is pressed, the shape will be deleted.
  In ControlPanel we have 4 buttons, Save which is saving our canvas using a DirectoryChooser and saving it at the path that we will give. The load button is loading a photo that is given in the FileChooser and adapted to the sizes of the canvas. Reset button is clearing the children of the canvas and Exit button will close the main stage.
  In the ShapePanel we just make 2 buttons which will change the shape that the DrawingPanel is drawing.
  RegularPolygon class is just a class that is making a Polygon object and transforms it to the sides, size and color that we give to it.
