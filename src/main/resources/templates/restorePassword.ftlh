<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/changePasswordForm.ftlh" as cp/>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="Restore Password">
    Придумайте новый пароль<br/>
    ${login?ifExists}
    <@b.baseForm path="/restorePassword" name="RestorePassword" button="ок">
        <@cp.changePass/>
    </@b.baseForm>

</@bh.base>