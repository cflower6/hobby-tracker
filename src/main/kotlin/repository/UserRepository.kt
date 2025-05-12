package com.hobby.tracker.repository

import com.hobby.tracker.models.User

interface UserRepository {
    fun getUser(email: String, password: String): User?
    fun createUser(user: User)
    fun deleteUser(email: String, password: String): Boolean
    fun updateUser(user: User)
}