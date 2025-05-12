package com.hobby.tracker.repository

import com.hobby.tracker.models.User
import io.ktor.util.logging.*

class FakeUserRepository(log: Logger) : UserRepository {
    private val fakeUserLog = log
    private val userDatabase = mutableListOf(
        User("1", "John", "john.doe@gmail.com", "123456"),
        User("2", "Jim", "jim.doe@gmail.com", "123456"),
        User("3", "Chris", "chris.doe@gmail.com", "123456"),
        User("4", "Mike", "mike.doe@gmail.com", "123456"),
    )

    override fun getUser(email: String, password: String): User? {
        userDatabase.find {it.email == email && it.password == password}?.let {
            return it
        }
        return null
    }

    override fun createUser(user: User) {
       check(!findUser(user)) { "User already created" }
        userDatabase.add(user)
    }

    override fun deleteUser(email: String, password: String): Boolean {
        var isRemoved = false
        userDatabase.find {it.email == email && it.password == password}?.let {
            userDatabase.remove(it)
            isRemoved = true
        }
        return isRemoved
    }

    override fun updateUser(user: User) {
        check(!findUser(user)) { "User already updated" }
        userDatabase.add(user)
    }

    private fun findUser(user: User): Boolean {
        userDatabase.find { it.username == user.username && it.password == user.password && it.email == user.email}
            ?.let {
            return true
        }
        return false
    }
}