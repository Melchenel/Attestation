<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/baseForm.ftlh" as b/>
<#import "parts/changePasswordForm.ftlh" as ch/>
<#import "parts/oldPasswordForm.ftlh" as op/>
<#import "parts/adminPart.ftlh" as a/>
<#import "parts/login.ftlh" as l/>
<#import "parts/userForm.ftlh" as u/>
<@bh.base title="Profile">

    <h1>This is your profile</h1>
    ${user?ifExists.login}
    ${user?ifExists.email}
    <br/>
    <br/>
Сменить пароль
    <@b.baseForm path="/changePassword" name="changePassword" button="ок">
        <@op.oldPassword/>
        <@ch.changePass/>
    </@b.baseForm>


    <@b.baseForm path="/logout" name="logout" button="Выйти из профиля">
    </@b.baseForm>

    <#if user?ifExists.role == 2>
        <@a.admin/>
        Удалить пользователя: <br/>
        <@b.baseForm path="/delete" name="delete" button="удалить">
           <@l.login/>
        </@b.baseForm>
        <br/>
        Добавить пользователя: <br/>

        <@b.baseForm path="/add" name="add" button="добавить">
            <@u.user/>
        </@b.baseForm>
    </#if>

</@bh.base>

