# Mice-Cheese
Exploring concurrent programming using a mice and cheese problem.

Mice want to search for cheese in a 8 X 8 grid. Each grid contains a box. Only one box contains a lump of cheese. 
The leader of the mice wants to understand the benefits of having more than one mouse simultaneously search the grid 
and devises this experiment involving 1, 4, and 8 mice. The dependent variable is the time it takes to find the box with cheese.
The location of the box containing the cheese will be systematically varied along the diagonal of the grid i.e. 
(0,0), (1,1), (2,2),...(7,7). So for each group of mice performing the search task, eight times will be reported, 
one for each of these locations. Mice search systematically left to right (along a row) and top to bottom (down rows). 
A mouse is responsible for searching particular rows: searches do not overlap. It takes 100 milliseconds for a mouse to 
open a box to check if cheese is inside. The first sub-experiment involves a single mouse starting at (0,0) 
who is responsible for searching the entire grid. The second sub-experiment involves four mice responsible for simultaneously
searching respectively: rows 0 through 1, rows 2 through 3, rows 4 through 5, and rows 6 through 7. The third sub-experiment 
involves 8 mice, each responsible for simultaneously searching a separate row of the grid. The leader of the mice wants to be 
sure of how things work by keeping track of the number of boxes that are opened. Each time a mouse opens a box, the mouse 
increments a shared counter by 1. In the first instance, the shared counter is unsynchronised while making the timing measurements. 
After conducting the first three experiments, we protect the shared counter making use of a semaphore. We then re- run the experiment
for the 4 and 8 mice condition.
