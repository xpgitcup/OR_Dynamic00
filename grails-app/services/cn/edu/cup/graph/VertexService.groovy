package cn.edu.cup.graph

import grails.gorm.services.Service

@Service(Vertex)
interface VertexService {

    Vertex get(Serializable id)

    List<Vertex> list(Map args)

    Long count()

    void delete(Serializable id)

    Vertex save(Vertex vertex)

}