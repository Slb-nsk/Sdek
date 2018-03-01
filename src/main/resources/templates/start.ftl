<!doctype html>
<html>
    <head>
    </head>
    <body>

    <p>Добавьте новое имя, или <a href="/search">сделайте поиск по списку имеющихся имён</a>.</p>

    <p>    <#assign userText = ""><form action="/insert">
                        <input type="text" name="userText" value="${userText}">
                        <input type="submit" value="Ввести имя">
                        </form></p>

     </body>
</html>