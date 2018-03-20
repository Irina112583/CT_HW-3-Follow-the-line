## Lego mindstorm robot following the line

---

### Description of the project

In this project my task was to implement the algorithm, that makes lego mindstorm robot follow the line.

---

### Description of the work process, explanation of the result values

For the implementation I've chosen Java programming language.

So first of all I created SD card with LeJos(is a firmware replacement for Lego Mindstorms programmable bricks). 

Then, of course, I built a robot, wrote a program and started to find suitable coefficients.

From the very beginning I started with only one sensor, but that was not enough to find out what way should the robot turn, so I added one more sensor.

After I got the satisfying result on smooth lines, I started to select the coefficients, suitable for more steep turns
There are the results I got:

Kp = 300;

This value shows, that for every 1 unit change in the error we will increase the power of one motor by Kp.

Ki = 0.3;

Ki is the running sum of the error. It is perfect for fixing small errors.

Kd = 30;

If the current error is worse than the previous error then Kd tries to correct the error. If he current error is better than the previous error then Kd tries to stop the controller from correcting the error.

To get this results I used the table that shows, how each of the coefficient influences rise time, overshoot, settling time.

---

### Why do I think this values are the best

First of all I used only Kp coefficient, value of it was 100, and other two were zeros, but it wasn't enough for car to follow more steep turns. Then I added Ki and Kd, the issue was to find a proportionality between them. I think the results I got are the best, because I had really long testing period and I found that with other coefficients car oscillates or behaves unpredictably, but with this results it smoothly follows the line. I don't want to say, that they are unique, but proportion between them is accurate enough.

---

### Link to youtube video
https://youtu.be/pBWnlNOORG4

