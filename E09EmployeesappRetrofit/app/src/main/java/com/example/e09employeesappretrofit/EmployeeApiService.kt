package com.example.e09employeesappretrofit

import retrofit2.http.GET

interface EmployeeApiService {
    @GET("employees.json")
    suspend fun getEmployees(): ApiResponse
}
data class ApiResponse(
    val employees: List<Employee>
)