<#macro baseForm path name button>

    <form method="post" name="${path}" action="${path}">
        <#nested>
        <p><input type="submit" value="${button}"></p>
    </form>
</#macro>