C:\Users\User>echo.>Main.java

C:\Users\User>echo public class Main { >Main.java

C:\Users\User>echo     public static void main (String[] args){ >>Main.java

C:\Users\User>echo         System.out.println("Hello world"); >>Main.java

C:\Users\User>echo     } >>Main.java

C:\Users\User>echo } >>Main.java

C:\Users\User>javac Main.java

C:\Users\User>java Main
Hello world

C:\Users\User>



компилируем
javac -sourcepath ./src -d out src/ru/gb/jcore/sample/Main.java
запускаем
java -classpath ./out ru/gb/jcore/sample/Main
создаем документацию
javadoc -d docs -sourcepath src -cp out -subpackages ru
