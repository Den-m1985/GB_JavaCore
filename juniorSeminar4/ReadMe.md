запись семинара:
https://gbcdn.mrgcdn.ru/uploads/record/300353/attachment/985542a150b1b630bd87346823d1f002.mp4

install Docker desctop:
https://www.docker.com/products/docker-desktop/

install plagin in IDEA: Docker
install plagin in IDEA: Database Navigator

В Services во вкладке Images в окне скачиваем mysql нажимаюм pull
После скачивания Images/mysql правой кпонкой выбираем Create container
Name: StudentDBConfig
Container name: students-db
Далее добавляем переменные сред нажав Modify options/Environmment veriables:
    MYSQL_ROOT_PASSWORD password
    MYSQL_DATABASE studentsDB
Далее пробрасываем порты Modify options/Bind ports:
 3307:3306  у меня был занят стандартный порт 
поэтому соединяем порт 3306 в контейнере с портом на компе 3307

нажимаем RUN
В workbench можно посмотреть базу даных



