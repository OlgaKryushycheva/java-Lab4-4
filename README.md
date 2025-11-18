# Chef console application

Консольна програма «Шеф-кухар» демонструє роботу з ієрархією овочів, дозволяє готувати салат, рахувати калорійність, сортувати інгредієнти та знаходити овочі за параметрами.

## Як запустити

### IntelliJ IDEA
1. Відкрийте проєкт як **Maven** (файл [`pom.xml`](pom.xml)). IDEA сама позначить `src/main/java` як джерела і підтягне ресурси з `src/main/resources`.
2. Після імпорту відкрийте клас [`ChefApplication`](src/main/java/com/example/chef/ChefApplication.java). Гутер‑іконка запуску праворуч від методу `main` має стати зеленою.
3. Якщо значок сірий, перевірте що проєкт імпортовано як Maven: *File → Project Structure → Project Settings → Modules* повинен показувати модуль з джерелами `src/main/java`.
4. Запустіть конфігурацію **Run 'ChefApplication'** або використайте клавішу **Shift+F10**.

### Командний рядок
```bash
mvn -q -DskipTests package
java -cp target/chef-application-1.0.0.jar com.example.chef.ChefApplication
```

Ресурси (зокрема `data/vegetables.csv`) автоматично вбудовуються до JAR і доступні на classpath.
