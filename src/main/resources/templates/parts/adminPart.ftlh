<#macro admin>

    <table>
    <caption>Список пользователей</caption>
    <tr>
        <th>Логин</th>
        <th>Email</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Номер телефона</th>
    </tr>
        <#list users as user>
        <tr> <td>${user.login}</td>
             <td>${user.email}</td>
             <td>${user.firstName}</td>
             <td>${user.lastName}</td>
             <td>${user.phoneNumber}</td>
        </tr>
        </#list>
    </table>


</#macro>