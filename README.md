# hero-adventures
A hero adventures himself in a dangerous world fighting is way through the dark woods.

# Description
The exercise aims to reproduce the movements of the hero on a map.


# Build
mvn install

# Run
java -jar hero-adventures-1.0.jar

#Rule
The map is modelled using characters in a text file in UTF-8 format.
'#' impenetrable woods
' ' (space character): box where the hero can move

The movements of the hero are defined by a file with the following characteristics:
	encoding: UTF-8
	First line:
	Contains the initial coordinates of the hero in the form "x, y"
	The coordinates (0,0) correspond to the upper left corner of the map
	Second line:
	Movement of the hero defined as a succession of characters representing the cardinal directions (N, S, E and O, note that O accounts for West)
	Each character corresponds to the displacement of a box

The hero cannot go beyond the edges of the map.
The hero cannot go on the squares occupied by the impenetrable woods.

# Game
Enter to the console full path to the map file and to the hero file and see results

INFO: Enter file path of MAP:
<full_path_to_the_map_file>
INFO: Enter file path of HERO:
<full_path_to_the_map_file>