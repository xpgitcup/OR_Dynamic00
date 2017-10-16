package cn.edu.cup.graph

class Edge {

    Vertex start
    Vertex end
    int edgeLength

    static constraints = {
    }

    String toString() {
        return "${start}-${end}"
    }
}
