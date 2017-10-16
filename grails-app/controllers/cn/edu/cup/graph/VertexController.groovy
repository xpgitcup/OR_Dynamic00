package cn.edu.cup.graph

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VertexController {

    VertexService vertexService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vertexService.list(params), model:[vertexCount: vertexService.count()]
    }

    def show(Long id) {
        respond vertexService.get(id)
    }

    def create() {
        respond new Vertex(params)
    }

    def save(Vertex vertex) {
        if (vertex == null) {
            notFound()
            return
        }

        try {
            vertexService.save(vertex)
        } catch (ValidationException e) {
            respond vertex.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vertex.label', default: 'Vertex'), vertex.id])
                redirect vertex
            }
            '*' { respond vertex, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vertexService.get(id)
    }

    def update(Vertex vertex) {
        if (vertex == null) {
            notFound()
            return
        }

        try {
            vertexService.save(vertex)
        } catch (ValidationException e) {
            respond vertex.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vertex.label', default: 'Vertex'), vertex.id])
                redirect vertex
            }
            '*'{ respond vertex, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vertexService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vertex.label', default: 'Vertex'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vertex.label', default: 'Vertex'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
