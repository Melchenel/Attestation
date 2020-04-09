<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/baseForm.ftlh" as b/>
<#import "parts/changePasswordForm.ftlh" as ch/>
<#import "parts/oldPasswordForm.ftlh" as op/>
<@bh.base title="Profile">

    <h1>This is your profile</h1>
    ${user?ifExists}
    <br/>
Сменить пароль
    <@b.baseForm path="/changePassword" name="changePassword" button="ок">
        <@op.oldPassword/>
        <@ch.changePass/>
    </@b.baseForm>
    ${message?ifExists}
</@bh.base>

