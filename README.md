# ShiftLabTask
Приложение, разработанное на Java с использованием Spring Boot и Spring Data JPA.
Выполнено в рамках тестового задания для "Лаборатория ШИФТ".



## Возможности приложения
1. Способно получать массив с интервалами цифр или букв в формате JSON, объединять все
пересекающиеся интервалы. Результат объединения сохраняется в in-memory Базу Данных H2.
2. Способно возвращатьм инимальный интервал в формате JSON.

## Как развернуть приложение?
1. Склонируйте репозиторий:
   ```
   git clone https://github.com/shumlesha/ShiftLabTask.git
   ```
2. Соберите проект при помощи Gradle, предварительно перейдя в каталог проекта:
   ```
   ./gradlew build
   ```
3. Затем можете запустить приложение:
   ```
   ./gradlew bootRun
   ```

## Инструкция по взаимодействую с приложением и API
**API-эндпоинты:**
- ***POST*** /api/v1/intervals/merge?kind=
- ***GET*** /api/v1/intervals/min?kind=

***_Передавать данные необходимо в json-формате:_***
_пример для буквенных интервалов_
```
POST /api/v1/intervals/merge?kind=letter
[{"intervalBegin": "a", "intervalEnd": "f"}, {"intervalBegin": "d", "intervalEnd": "j"},{"intervalBegin": "r", "intervalEnd": "z"}]
```

***_Поулчить интервал минимальной длины:_***
```
GET /api/v1/intervals/min?kind=[letters/digits]
```

## Доп. настройки
Настройки базы данных можно изменить в файле *application.properties*.



