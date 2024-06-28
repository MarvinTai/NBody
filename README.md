# NBody
**Context:** In 1687, Isaac Newton formulated the principles governing the motion of two particles under the influence of their mutual gravitational attraction in his famous Principia. However, Newton was unable to solve the problem for three particles. Indeed, in general, solutions to systems of three or more particles must be approximated via numerical simulations.
For a more complete understanding of the Physics you can reference [this document][Physics].

In this assignment, you will write a program to simulate the motion of _N_ objects in a plane, mutually affected by gravitational forces, and animate the results. Such methods are widely used in cosmology, semiconductors, and fluid dynamics to study complex physical systems. Ultimately, you will be creating a driver program `NBody.java` that draws an animation of bodies moving in space interacting with each other subject to interacting and mutual gravitational forces. These bodies are modeled by the class `CelestialBody.java` that you'll implement and test independently of the simulation.

Below you can expand to see an animation of a completed project running with some planets in our solar system. The animation repeats after one earth year, your program continues until the simulation completes.

### Example Simulation of Complete Project

<div align="center">
  <img width="500" height="500" src="p1-figures/planets.gif">
</div>

