<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/baseForm.ftlh" as b/>
<#import "parts/changePasswordForm.ftlh" as ch/>
<#import "parts/oldPasswordForm.ftlh" as op/>
<@bh.base title="Profile">

    <h1>This is your profile</h1>
    ${user?ifExists.login}
Сменить пароль
    <@b.baseForm path="/main" name="changePassword">
        <@op.oldPassword/>
        <@ch.changePass/>
    </@b.baseForm>

</@bh.base>

