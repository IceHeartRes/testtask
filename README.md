# testtask
**Запуск контейнера с базой данных**\
docker run --name postgres -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=demo -d postgres

**Запуск контейнера с микросервисом**\
docker run --name testtask --link postgres:test -p 8080:8080 -t resident/testtask

**Создать таблицы с демонстрационными данными**\
/create_tables

**Получить всех пользователей**\
/users

**Выбрать пользователей по идентификатору (ID)**\
/users/id={ID}

**Выбрать пользователей по тарифному плану (TP_ID)**\
/users/tpid={TP_ID}

**Получить все тарифные планы**\
/users/tariff_planes

**Получить все уведомления о смене условий тарифного плана**\
/users/messages