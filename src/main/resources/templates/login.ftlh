<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/login.ftlh" as l>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="Login Page">
    <@b.baseForm path="/login" name="Login" button="ок">
        <@l.login/>
    </@b.baseForm>
</@bh.base>