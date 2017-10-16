package cn.edu.cup.graph

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class GraphServiceSpec extends Specification {

    GraphService graphService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Graph(...).save(flush: true, failOnError: true)
        //new Graph(...).save(flush: true, failOnError: true)
        //Graph graph = new Graph(...).save(flush: true, failOnError: true)
        //new Graph(...).save(flush: true, failOnError: true)
        //new Graph(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //graph.id
    }

    void "test get"() {
        setupData()

        expect:
        graphService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Graph> graphList = graphService.list(max: 2, offset: 2)

        then:
        graphList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        graphService.count() == 5
    }

    void "test delete"() {
        Long graphId = setupData()

        expect:
        graphService.count() == 5

        when:
        graphService.delete(graphId)
        sessionFactory.currentSession.flush()

        then:
        graphService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Graph graph = new Graph()
        graphService.save(graph)

        then:
        graph.id != null
    }
}
