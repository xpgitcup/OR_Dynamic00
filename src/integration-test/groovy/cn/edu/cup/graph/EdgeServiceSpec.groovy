package cn.edu.cup.graph

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EdgeServiceSpec extends Specification {

    EdgeService edgeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Edge(...).save(flush: true, failOnError: true)
        //new Edge(...).save(flush: true, failOnError: true)
        //Edge edge = new Edge(...).save(flush: true, failOnError: true)
        //new Edge(...).save(flush: true, failOnError: true)
        //new Edge(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //edge.id
    }

    void "test get"() {
        setupData()

        expect:
        edgeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Edge> edgeList = edgeService.list(max: 2, offset: 2)

        then:
        edgeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        edgeService.count() == 5
    }

    void "test delete"() {
        Long edgeId = setupData()

        expect:
        edgeService.count() == 5

        when:
        edgeService.delete(edgeId)
        sessionFactory.currentSession.flush()

        then:
        edgeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Edge edge = new Edge()
        edgeService.save(edge)

        then:
        edge.id != null
    }
}
