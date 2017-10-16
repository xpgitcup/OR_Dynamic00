package cn.edu.cup.graph

class Vertex {

    String name

    static belongsTo = [graph: Graph]

    static constraints = {
    }

    String toString() {
        return "${name}"
    }

}
