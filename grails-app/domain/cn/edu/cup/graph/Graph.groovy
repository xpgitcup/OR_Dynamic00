package cn.edu.cup.graph

class Graph {

    String name

    static hasMany = [vertex: Vertex]

    static constraints = {
    }

    String toString() {
        return "${name}"
    }

}
