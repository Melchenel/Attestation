<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/changePasswordForm.ftlh" as cp/>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="Restore Password">
    Придумайте новый пароль
    <@b.baseForm path="/restorePassword" name="RestorePassword">
        <@cp.changePass/>
    </@b.baseForm>
    На Вашу почту была отправлена ссылка для смены пароля
</@bh.base>