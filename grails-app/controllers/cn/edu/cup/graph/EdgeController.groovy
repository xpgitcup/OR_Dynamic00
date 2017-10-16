package cn.edu.cup.graph

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EdgeController {

    EdgeService edgeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond edgeService.list(params), model:[edgeCount: edgeService.count()]
    }

    def show(Long id) {
        respond edgeService.get(id)
    }

    def create() {
        respond new Edge(params)
    }

    def save(Edge edge) {
        if (edge == null) {
            notFound()
            return
        }

        try {
            edgeService.save(edge)
        } catch (ValidationException e) {
            respond edge.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'edge.label', default: 'Edge'), edge.id])
                redirect edge
            }
            '*' { respond edge, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond edgeService.get(id)
    }

    def update(Edge edge) {
        if (edge == null) {
            notFound()
            return
        }

        try {
            edgeService.save(edge)
        } catch (ValidationException e) {
            respond edge.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'edge.label', default: 'Edge'), edge.id])
                redirect edge
            }
            '*'{ respond edge, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        edgeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'edge.label', default: 'Edge'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'edge.label', default: 'Edge'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
