<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/autorizationForm.ftlh" as a/>

<@bh.base title="Autorization">

<h1>Welcome! Please, write your login and password!</h1>

<@a.authorization path="/auth"/>
</@bh.base>