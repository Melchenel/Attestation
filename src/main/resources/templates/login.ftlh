<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/login.ftlh" as l>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="Login Page">
    <@b.baseForm path="/loginPage" name="Login">
        <@l.login/>
    </@b.baseForm>
    На Вашу почту была отправлена ссылка для смены пароля
</@bh.base>