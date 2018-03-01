<!doctype html>
<html>
    <head>
    </head>
    <body>

    <p><a href="/">Добавьте новое имя</a>, или сделайте поиск по списку имеющихся имён.

    <hr>
        <div>
        <p>    <#assign userText = ""><form action="/search">
                            <input type="text" name="userText" value="${userText}">
                            <input type="submit" value="Искать в списке">
                            </form></p>
        </div>

         <div>
           <Table><tr><th>Id</th><th>Имя</th></tr>
                <#list namesList as item>
                  <tr><td>${item.id}</td><td>${item.name}</td></tr>
                 </#list>
           </Table>
         </div>


</body>
</html>