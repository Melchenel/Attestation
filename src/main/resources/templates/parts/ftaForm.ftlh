<#macro fta path>

    <form method="post" name="authorization" action="${path}">

        <label for="code">Введите код подтверждения, который пришел на Вашу почту</label>
        <input type="text" name="code" id="code"/> <br/>

        <p><input type="submit"></p>
    </form>
</#macro>