package cn.edu.cup.graph

import grails.gorm.services.Service

@Service(Graph)
interface GraphService {

    Graph get(Serializable id)

    List<Graph> list(Map args)

    Long count()

    void delete(Serializable id)

    Graph save(Graph graph)

}