## Installation
To install the application use the Maven command:
```
mvn clean install
```

and then run the jar file created.

## Run
Alternatively, it is possible to run directly the application from the ```out/artificats/springbootApp_jar``` folder and execute the ```.jar``` as below:
```
cd out/artificats/springbootApp_jar
java -jar springbootApp.jar
```

## Database
The database chosen is H2 for the simplicity of deployment without the need to prepare an external DB or a docker container.

However you should pay attention that the database will reset each time the application is lunched.


## Api
#### Get user by id

```http
  GET /api/users/{id}
```
This REST API returns the user defined by the ```{id}``` presents in the DB.

Body response example:
```
{
    "id": 3,
    "userName": "Marcooo",
    "birthDate": "2000-01-01",
    "residenceCountry": "france",
    "phoneNumber": null,
    "gender": null
}
```

#### Create a user

```http
  POST /api/users
```

This REST API allows the creation of a new user.

| Parameter          | Type        | Description                                                   |
|:-------------------|:------------|:--------------------------------------------------------------|
| `userName`         | `string`    | **Required**. Username of the user.                           |
| `birthDate`        | `LocalDate` | **Required**. Birthdate of the user in the format yyyy-mm-dd. |
| `residenceCountry` | `string`    | **Required**. Residence country of the user                   |
| `gender`           | `char`      | Gender of the user.                                           |
| `phoneNumber`      | `string`    | Phone number of the user.                                     |

For the user creation there are some constraints. 

- Only users of legal age and resident in France may register.
Therefore, the date of birth and residence must be entered appropriately.

- The gender can be only `M` or `F`, no others possibilities are provided.

- Phone number should be between 8 and 14 characters, but no other constraints are provided.

Please provide JSON body as in the example below.
Body request example:
```
{
    "id": 3,
    "userName": "Marcooo",
    "birthDate": "2000-01-01",
    "residenceCountry": "france",
    "phoneNumber": "0593758182",
    "gender": "M"
}
```

## Lombok
In order to avoid boilerplate code I used ```Lombok``` library to create getters and setters, as well as no arguments constructors and the builder.

## Tests
In the code there are some unit test as well as integration test.
Unfortunately, due to lack of time, not all tests are working. Especially the integration ones need debug to make them work. 
Nevertheless, they were delivered to give an idea of how they should be done.
