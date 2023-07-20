
Урок 1. Компиляция и интерпретация кода
1. Создать приложение с вложенностью пакетов не менее 3х, 
где будет класс для входа и несколько классов с логикой. 
Пример: приложение для внесения заметок во внешний файл с обязательной фиксацией времени
пример:
   Введите заметку: Hello, world!
   Дозапись в файл: 16.07.2023 -> Hello, world

Скомпилируйте и запустите посредством CLI


компилируем
javac -sourcepath ./src -d out src/ru/gb/jcore/sample/Main.java
запускаем
java -classpath ./out ru/gb/jcore/sample/Main


2. (доп).Создать два Docker-образа. Один должен компилировать Java-проект 
обратно в папку на компьютере пользователя, а второй забирать 
скомпилированные классы и исполнять их. Пример листинга для docker-compose 
приведен в презентации семинара


        docker-контейнер для компиляции программы

mkdir homework1
cd homework1
touch docker-compose-class.yml
sudo nano docker-compose-class.yml
cat docker-compose-class.yml

services:
  app:
    image: bellsoft/liberica-openjdk-alpine:11.0.16.1-1
    command: javac -sourcepath /app/src -d /app/out /app/src/ru/gb/jcore/sample/Main.java
    volumes:
      - ./bin:/app/out
      - ./src:/app/src


        docker-контейнер для выполнения программы
docker-compose-exec.yml
services:
  app:
    image: bellsoft/liberica-openjdk-alpine:11.0.16.1-1
    command: java -classpath /app/out ru.gb.jcore.sample.Main
    volumes:
      - ./bin:/app/out


sudo docker-compose-classe up -d
sudo docker-compose-exec up -d

      docker-контейнер для формирования полной документации по проекту
docker-compose-class.yml
services:
  app:
    image: bellsoft/liberica-openjdk-alpine:11.0.16.1-1
    command: javadoc -sourcepath /app/src -cp /app/out -d /app/doc -subpackages ru
    volumes:
      - ./bin:/app/out
      - ./src:/app/src
      - ./doc:/app/doc




