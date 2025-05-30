package com.hobby.tracker.routes

import com.hobby.tracker.models.User
import com.hobby.tracker.models.UserSearchCriteria
import com.hobby.tracker.repository.UserRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.userRoutes(repository: UserRepository) {
    routing {
        createUserRoutes(repository)
        getUserRoutes(repository)
        deleteUserRoutes(repository)
        updateUserRoutes(repository)
    }
}

private fun Route.createUserRoutes(repository: UserRepository) {
    post("/create"){
        val user = call.receive<User>()
        repository.createUser(user)
        call.respond(HttpStatusCode.Created)
    }
}

private fun Route.getUserRoutes(repository: UserRepository) {
    get("/get"){
        val userSearchCriteria = call.receive<UserSearchCriteria>()

        try {
            val user = repository.getUser(userSearchCriteria.email, userSearchCriteria.password)
            call.respondNullable(user)
        } catch (_: Exception) {
            call.respond(HttpStatusCode.BadRequest)
        }
    }
}

private fun Route.deleteUserRoutes(repository: UserRepository) {
    delete("/remove"){
        val user = call.receive<UserSearchCriteria>()
        val hasRemoved = repository.deleteUser(user.email, user.password)
        if(hasRemoved){
            call.respond(HttpStatusCode.NoContent)
        } else {
            call.respond(HttpStatusCode.NotFound)
        }
    }
}

private fun Route.updateUserRoutes(repository: UserRepository) {
    post("/update"){
        val user = call.receive<User>()
        repository.updateUser(user)
        call.respond(HttpStatusCode.NoContent)
    }
}