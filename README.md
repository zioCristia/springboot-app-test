## Installation
To run the application go to the ```target``` folder and execute the ```.jar``` as below:
```
cd target
java -jar football-0.0.1-SNAPSHOT.jar
```

## Database
The database chosen is H2 for the simplicity of deployment without the need to prepare an external DB or a docker container.

However you should pay attention that the database will reset each time the application is lunched.

## Tests
The tests are neither completed nor sufficient for the application, but it should be enough to give an idea of how they should be implemented and thought out.

## Api
#### Get all teams

```http
  GET /api/teams
```
This REST API returns all the teams presents in the DB with all their players.
The response is a pagination type which means not all the teams will be presented but only a certain amount.
By default we have 5 elements per page and it is sent the first page.
Also the sorting element considered for the teams visualization order can be changed and by default they are sorted by id.
You can change it by adding filters in the api url:

| Filters  | Type     | Description                                                            |
|:---------|:---------|:-----------------------------------------------------------------------|
| `page`   | `int`    | Page requested.  `Default = 0`                                         |
| `size`   | `int`    | Number of elements per page.  `Default = 5`                            |
| `sortBy` | `string` | Element to be considered for ordering the output teams. `Default = id` |


Body response example:
```
{
    "totalItems": 2,
    "teams": [
        {
            "id": 2,
            "name": "ac milan",
            "acronym": "milan",
            "budget": 1500000,
            "players": [
                {
                    "id": 3,
                    "name": "dibala",
                    "number": 0
                },
                {
                    "id": 4,
                    "name": "buffon",
                    "number": 0
                }
            ]
        },
        {
            "id": 1,
            "name": "juve",
            "acronym": "juventus",
            "budget": 500000,
            "players": [
                {
                    "id": 1,
                    "name": "dibala",
                    "number": 0
                },
                {
                    "id": 2,
                    "name": "buffon",
                    "number": 0
                }
            ]
        }
    ],
    "totalPages": 1,
    "currentPage": 0
}
```


#### Create a team

```http
  POST /api/teams
```

This REST API allows the creation of a new football team with the possibility to add the players.

Players is the only not-mandatory field to provide in the request body.

| Parameter | Type           | Description                                 |
|:----------|:---------------|:--------------------------------------------|
| `name`    | `string`       | **Required**. Name of the new team          |
| `acronym` | `string`       | **Required**. Acronym of the new team       |
| `budget`  | `int`          | **Required**. Budget of the new team.       |
| `players` | `List<Player>` | List of the players which compose the team. |

Please provide JSON body as in the example below.
Body request example:
```
{
    "name": "ac milan",
    "acronym": "milan",
    "budget": "1500000",
    "players": [
        {
            "name": "dibala",
            "position": "10"
        },
        {
            "name": "buffon",
            "position": "1"
        }
    ]
}
```

## Lambrok
In order to avoid boilerplate code I used ```Lambrok``` library to create getters and setters, as well as no arguments constructors.