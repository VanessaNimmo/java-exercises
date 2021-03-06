# Conways Game of Life

## Running the Program

From the terminal, navigate to out/production/conways2 and run the following:

```java com.ness.conways.ConwaysApp <max-grid-size> <number-of-ticks> <time-between-ticks-in-ms> <setup-filename>```


e.g.

```java com.ness.conways.ConwaysApp 56 20 500 setup10.txt```

## Input File Format

First line defines width and height of the world.
Subsequent lines define x and y coordinates for the world, as taken from the top left corner.

width height<br>
x y<br>
x y<br>
x y<br>
x y<br>

## Invalid Input Data

If the input file is incorrectly formatted, the program will print an error message and then exit. It will also do this if the grid size defined in the setup file is larger than the maximum grid size allowed (which is also supplied by the user). 

If the locations of the live cell pairs are incorrectly formatted or outside the defined grid size, the program will ignore them.

Max Grid Size: The size of 56 is chosen as this is the maximum number of the chosen display emoji that fits on the demo screen. Feel free to choose a different size as appropriate for your screen.