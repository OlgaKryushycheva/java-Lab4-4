# Chef console application

Консольна програма «Шеф-кухар» демонструє роботу з ієрархією овочів, дозволяє готувати салат, рахувати калорійність, сортувати інгредієнти та знаходити овочі за параметрами.

## Як запустити

### IntelliJ IDEA
1. Відкрийте проєкт як **Maven** (файл [`pom.xml`](pom.xml)). IDEA сама позначить `src/main/java` як джерела і підтягне ресурси з `src/main/resources`.
2. Після імпорту відкрийте короткий файл [`Main`](src/main/java/Main.java). Його зелений трикутник запускає застосунок без переходів у глибокі пакети.
3. Якщо значок сірий, перевірте що проєкт імпортовано як Maven: *File → Project Structure → Project Settings → Modules* повинен показувати модуль з джерелами `src/main/java`.
4. Запустіть конфігурацію **Run 'Main'** (або `ChefApplication`, якщо хочете напряму) чи використайте **Shift+F10**.

### Командний рядок
```bash
mvn -q -DskipTests package
java -cp target/chef-application-1.0.0.jar com.example.chef.ChefApplication
```

Ресурси (зокрема `data/vegetables.csv`) автоматично вбудовуються до JAR і доступні на classpath.

### Простіший запуск без Maven
```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out:src/main/resources Main   # у Windows замініть ':' на ';'
```
Файл `Main.java` лежить без вкладених пакетів, тому його легко знайти й запустити навіть у простих проєктах.
