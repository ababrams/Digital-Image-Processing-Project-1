Program written in Java/Eclipse. 

It can be ran through Eclipse with Browser.java holding the main class for configuration. If it doesn't already, eclipse needs opencv added as a User Library.

Running through command line.

cd to src file where Browser.java is located
/project-1/Project1.1/src

To compile:

javac -cp /C:/... file path to open cv jar:. Browser.java

example: (personal using Ubuntu)
javac -cp /home/corwin/opencv_build/opencv/build/bin/opencv-440.jar:. Browser.java

To run:

java -cp /C:/ ... file path to open cv jar:. -Djava.library.path=/C:/ ... path to open cv library Browser

example: (personal using Ubuntu)
java -cp /home/corwin/opencv_build/opencv/build/bin/opencv-440.jar:.  -Djava.library.path=/home/corwin/opencv_build/opencv/build/lib/ Browser

The GUI is completely usable to define the directory and the size of the columns and rows. These can also be set through command line arguments.
