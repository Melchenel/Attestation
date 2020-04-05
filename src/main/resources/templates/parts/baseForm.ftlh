<#macro baseForm path name>

    <form method="post" name="${path}" action="${path}">
        <#nested>
        <p><input type="submit"></p>
    </form>
</#macro>