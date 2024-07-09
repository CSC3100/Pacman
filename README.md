![Static Badge](https://img.shields.io/badge/author-javiergs-orange)
![GitHub repo size](https://img.shields.io/github/repo-size/CSC3100/Pacman)
![GitHub Release](https://img.shields.io/github/v/release/CSC3100/Pacman)
[![License: CC BY-NC 4.0](https://img.shields.io/badge/License-CC%20BY--NC%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-nc/4.0/)

# Pacman
This program demonstrates multithreading concepts using a Pacman game example. A Timer object manages the Maze panel's repaint cycle at 10 frames per second. Both Pacman and the ghost are implemented as runnable threads, allowing their positions to update automatically. Pacman also utilizes key listeners, enabling user interaction to change its direction dynamically.
<br>

## User Interface

<p align="center">
<IMG SRC="https://github.com/CSC3100/Pacman/assets/3814755/95668dee-27bd-4226-b4e7-6a65fca38a77" WIDTH=600>
</p>
<br>

## Class Diagram
Notice <code>Runnable</code>, <code>Thread</code>, and <code>Timer</code>. Timer refresh the Maze 10 frames per second while the Pacman and Ghost runnables keep updating their positions.
