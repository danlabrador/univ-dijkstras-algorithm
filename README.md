# Java Graph Implementation with Dijkstra's Algorithm

## Description

This Java project implements a graph data structure with support for both directed and undirected graphs. It includes functionalities to create graphs from text files, add vertices and edges, and apply Dijkstra's algorithm to find the shortest paths in the graph. The project is structured into several classes, each serving a specific role in the graph implementation.

## Table of Contents

1. [Files and Their Roles](#files-and-their-roles)
2. [How to Run](#how-to-run)
3. [Notes](#notes)
4. [Contributing](#contributing)

## Files and Their Roles

- `CS2135WeightedGraph.java`: Creates weighted graphs from file input, supporting directed and undirected graphs.
- `Dijkstra.java`: Implements Dijkstra's algorithm to find the shortest paths between nodes in a graph.
- `Edge.java`: Represents an edge in the graph, with fields for start and end vertices and weight.
- `Graph.java`: Core class for representing a graph, allows adding vertices and edges.
- `QueueVertex.java`: Represents a vertex with priority, for use in priority queues within Dijkstra's algorithm.
- `Vertex.java`: Represents a vertex in the graph, with functionalities to add and remove edges.
- `graph.txt`: Sample text file used as input for creating graphs. Lists vertices and weighted edges.
- `Main.java`: The entry point of the project. Manages the overall program flow, including graph creation and algorithm execution.

## How to Run

1. Ensure Java is installed on your system.
2. Compile the Java files using your preferred Java compiler.
3. Run `Main.java`.
4. The program will read from `graph.txt` to create a graph and then apply Dijkstra's algorithm to find shortest paths.

## Notes

- `graph.txt` can be modified to represent different graphs. Ensure the format is consistent with the sample provided.
- The `Main.java` file includes checks for the maximum number of vertices and edges. Adjust these as needed for larger graphs.

## Contributing

Contributions to enhance functionalities, improve efficiency, or extend the capabilities of the graph implementation are welcome. Please ensure code readability and comment your changes for easy understanding.
