#SpringMavenDemoApp

Steps to Run and configure SpringMavenDemoApp Application -
1. Import project as a maven project in any IDE (Eclipse or STS).
2. Run SpringMavenDemoAppication as "Spring Boot Application".
3. The application is now started on port 8081.

Server Port : 8081
Database Name : "spring_demo"

APi Collection :

1. POST http://localhost:8081/save-employee
Request Body : {
    "name" : "Test Employee",
    "address" : "abc",
    "email":"testemp@gmail.com",
    "contactno" : "123456789"
}

2. GET http://localhost:8081/get-employee-by-id/{id}

Response :
{
    "error": false,
    "message": "Data fetched successfully",
    "data": {
        "id": 1,
        "name": "Test Employee",
        "email": "testemp@gmail.com",
        "contactno": 123456789,
        "address": "abc"
    }
}


3. GET http://localhost:8081/list-all-employee

Response :
{
    "error": false,
    "message": "Data fetched successfully",
    "data": [
        {
            "id": 1,
            "name": "Employee_1",
            "address": "abc",
            "email": "testemp1@gmail.com",
            "contactno": 123456789
        },
        {
            "id": 2,
            "name": "Employee_2",
            "address": "abc",
            "email": "testemp2@gmail.com",
            "contactno": 123456789
        }
    ]
}
