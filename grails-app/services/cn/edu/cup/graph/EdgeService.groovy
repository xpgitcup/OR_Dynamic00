package cn.edu.cup.graph

import grails.gorm.services.Service

@Service(Edge)
interface EdgeService {

    Edge get(Serializable id)

    List<Edge> list(Map args)

    Long count()

    void delete(Serializable id)

    Edge save(Edge edge)

}