package cn.edu.cup.graph

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VertexServiceSpec extends Specification {

    VertexService vertexService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vertex(...).save(flush: true, failOnError: true)
        //new Vertex(...).save(flush: true, failOnError: true)
        //Vertex vertex = new Vertex(...).save(flush: true, failOnError: true)
        //new Vertex(...).save(flush: true, failOnError: true)
        //new Vertex(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vertex.id
    }

    void "test get"() {
        setupData()

        expect:
        vertexService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vertex> vertexList = vertexService.list(max: 2, offset: 2)

        then:
        vertexList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vertexService.count() == 5
    }

    void "test delete"() {
        Long vertexId = setupData()

        expect:
        vertexService.count() == 5

        when:
        vertexService.delete(vertexId)
        sessionFactory.currentSession.flush()

        then:
        vertexService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vertex vertex = new Vertex()
        vertexService.save(vertex)

        then:
        vertex.id != null
    }
}
