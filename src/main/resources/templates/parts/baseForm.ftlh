<#macro baseForm path name button>

    <form method="post" name="${path}" action="${path}">
        <div class="form-group">
        <#nested>
            <div class="row">
                <div class="col">
                <p><input type="submit" value="${button}" class="btn btn-block button"></p>
                </div>
                <div class="col"></div>
            </div>
        </div>
    </form>
</#macro>