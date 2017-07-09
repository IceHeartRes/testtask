# testtask
Запуск контейнера с базой данных\
**docker run --name postgres -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=demo -d postgres**

Запуск контейнера с микросервисом\
**docker run --name testtask --link postgres:test -p 8080:8080 -t resident/testtask**
