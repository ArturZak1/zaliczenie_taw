# zaliczenie_taw

1. wprowadzenie przedmiotów do systemu

POST http://localhost:8080/api/courses

{
  "nazwa": "Metodologie obiektowe",
  "ects": 2,
  "numerSali": 216,
  "egzamin": true
}
201 Created 5 ms 128 B


POST http://localhost:8080/api/courses

{
  "nazwa": "Testowanie oprogramowania",
  "ects": 1,
  "numerSali": 216,
  "egzamin": false
}
201 Created 10 ms 128 B

POST http://localhost:8080/api/courses
{
  "nazwa": "Technologie i aplikacje webowe",
  "ects": 3,
  "numerSali": 208,
  "egzamin": false
}
201Created 5 ms 128 B 

POST http://localhost:8080/api/courses
{
  "nazwa": "Zarządzanie projektem informatycznym",
  "ects": 2,
  "numerSali": 216,
  "egzamin": false
}
201 Created 6 ms 128 B

POST http://localhost:8080/api/courses
{
  "nazwa": "Zaawansowane technologie bazodanowe",
  "ects": 3,
  "numerSali": 208,
  "egzamin": false
}
201 Created 7 ms 128 B

POST http://localhost:8080/api/courses
{
  "nazwa": "Technologie komponentowe i sieciowe",
  "ects": 2,
  "numerSali": 208,
  "egzamin": true
}

201 Created 3 ms 128 B




2. Pobranie wszystkich przedmiotów

GET http://localhost:8080/api/courses

[
    {
        "id": 1,
        "nazwa": "Metodologie obiektowe",
        "ects": 2,
        "numerSali": 216,
        "egzamin": true
    },
    {
        "id": 2,
        "nazwa": "Testowanie oprogramowania",
        "ects": 1,
        "numerSali": 216,
        "egzamin": false
    },
    {
        "id": 3,
        "nazwa": "Technologie i aplikacje webowe",
        "ects": 3,
        "numerSali": 208,
        "egzamin": false
    },
    {
        "id": 4,
        "nazwa": "Zarządzanie projektem informatycznym",
        "ects": 2,
        "numerSali": 216,
        "egzamin": false
    },
    {
        "id": 5,
        "nazwa": "Zaawansowane technologie bazodanowe",
        "ects": 3,
        "numerSali": 208,
        "egzamin": false
    },
    {
        "id": 6,
        "nazwa": "Technologie komponentowe i sieciowe",
        "ects": 2,
        "numerSali": 208,
        "egzamin": true
    }
]

200 OK 21 ms 712 B




3. Pobranie przedmiotów, które mają egzamin

GET http://localhost:8080/api/courses&egzamin=true

[
    {
        "id": 1,
        "nazwa": "Metodologie obiektowe",
        "ects": 2,
        "numerSali": 216,
        "egzamin": true
    },
    {
        "id": 6,
        "nazwa": "Technologie komponentowe i sieciowe",
        "ects": 2,
        "numerSali": 208,
        "egzamin": true
    }
]
200 OK 6 ms 355 B




4. Pobranie przedmiotów, które odbywają się w sali 216

GET http://localhost:8080/api/courses?numerSali=216

[
    {
        "id": 1,
        "nazwa": "Metodologie obiektowe",
        "ects": 2,
        "numerSali": 216,
        "egzamin": true
    },
    {
        "id": 2,
        "nazwa": "Testowanie oprogramowania",
        "ects": 1,
        "numerSali": 216,
        "egzamin": false
    },
    {
        "id": 4,
        "nazwa": "Zarządzanie projektem informatycznym",
        "ects": 2,
        "numerSali": 216,
        "egzamin": false
    }
]
200 OK 5 ms 444 B





5. Pobranie przedmiotów które nie mają egzaminu i odbywają się w sali 208

GET http://localhost:8080/api/courses?numerSali=208&egzamin=false

[
    {
        "id": 3,
        "nazwa": "Technologie i aplikacje webowe",
        "ects": 3,
        "numerSali": 208,
        "egzamin": false
    },
    {
        "id": 5,
        "nazwa": "Zaawansowane technologie bazodanowe",
        "ects": 3,
        "numerSali": 208,
        "egzamin": false
    }
]
200 OK 5ms 352 B




6. Pobranie przedmiotu o identyfikatorze 3

GET http://localhost:8080/api/courses/3

{
    "id": 3,
    "nazwa": "Technologie i aplikacje webowe",
    "ects": 3,
    "numerSali": 208,
    "egzamin": false
}
200 OK 6 ms 254 B




7. Pobranie przedmiotu o identyfikatorze 15

http://localhost:8080/api/courses/15
404 Not Found 5 ms 130 B





8. Usunięcie przedmiotu o identyfikatorze 2

DELETE http://localhost:8080/api/courses/2
204 No Content 9 ms 112 B




9. Pobranie wszystkich przedmiotów

GET http://localhost:8080/api/courses

[
    {
        "id": 1,
        "nazwa": "Metodologie obiektowe",
        "ects": 2,
        "numerSali": 216,
        "egzamin": true
    },
    {
        "id": 3,
        "nazwa": "Technologie i aplikacje webowe",
        "ects": 3,
        "numerSali": 208,
        "egzamin": false
    },
    {
        "id": 4,
        "nazwa": "Zarządzanie projektem informatycznym",
        "ects": 2,
        "numerSali": 216,
        "egzamin": false
    },
    {
        "id": 5,
        "nazwa": "Zaawansowane technologie bazodanowe",
        "ects": 3,
        "numerSali": 208,
        "egzamin": false
    },
    {
        "id": 6,
        "nazwa": "Technologie komponentowe i sieciowe",
        "ects": 2,
        "numerSali": 208,
        "egzamin": true
    }
]
200 OK 5 ms 626 B




10. Usunięcie wszystkich przedmiotów

DELETE http://localhost:8080/api/courses
204 No Content 5 ms 112 B




11. Pobranie wszystkich przedmiotów

GET http://localhost:8080/api/courses

[]

200 OK 5 ms 166 B

