<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/autorizationForm.ftlh" as a/>

<@bh.base title="Autorization">

<h1>Введите логин и пароль!</h1>

<@a.authorization path="/auth"/>
</@bh.base>