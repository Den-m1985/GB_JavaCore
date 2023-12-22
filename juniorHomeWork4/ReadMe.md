* Задание
    * =======
    * Создайте базу данных (например, SchoolDB).
    * В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
    * Настройте Hibernate для работы с вашей базой данных.
    * Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
    * Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
    * Убедитесь, что каждая операция выполняется в отдельной транзакции.

В Services во вкладке Images в окне скачиваем mysql нажимаюм pull
После скачивания Images/mysql правой кпонкой выбираем Create container
Name: CourseDBConfig
Container name: schoolDB
Далее добавляем переменные сред нажав Modify options/Environmment veriables:
MYSQL_ROOT_PASSWORD password
MYSQL_DATABASE schoolDB
Далее пробрасываем порты Modify options/Bind ports:
3308:3306  у меня был занят стандартный порт
поэтому соединяем порт 3306 в контейнере с портом на компе 3307

нажимаем RUN
В workbench можно посмотреть базу даных
