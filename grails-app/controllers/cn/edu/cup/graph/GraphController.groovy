package cn.edu.cup.graph

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class GraphController {

    GraphService graphService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond graphService.list(params), model:[graphCount: graphService.count()]
    }

    def show(Long id) {
        respond graphService.get(id)
    }

    def create() {
        respond new Graph(params)
    }

    def save(Graph graph) {
        if (graph == null) {
            notFound()
            return
        }

        try {
            graphService.save(graph)
        } catch (ValidationException e) {
            respond graph.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'graph.label', default: 'Graph'), graph.id])
                redirect graph
            }
            '*' { respond graph, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond graphService.get(id)
    }

    def update(Graph graph) {
        if (graph == null) {
            notFound()
            return
        }

        try {
            graphService.save(graph)
        } catch (ValidationException e) {
            respond graph.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'graph.label', default: 'Graph'), graph.id])
                redirect graph
            }
            '*'{ respond graph, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        graphService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'graph.label', default: 'Graph'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'graph.label', default: 'Graph'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
