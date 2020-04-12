<#macro admin>
    list of users:
    <table class="table table-bordered">
    <tr>
        <th scope="col">login</th>
        <th scope="col">email</th>
        <th scope="col">phone number</th>
    </tr>
        <#list users as user>
        <tr>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <td>${user.phoneNumber}</td>
        </tr>
        </#list>
    </table>


</#macro>