<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/autorizationForm.ftlh" as a/>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="Autorization">

<h1>Введите логин и пароль!</h1>
    ${message?ifExists}
<@b.baseForm path="/auth" name="autorization" button="войти">
    <@a.authorization path="/auth"/>
</@b.baseForm>
<a href="/login">Забыли пароль?</a>
</@bh.base>