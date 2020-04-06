<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/ftaForm.ftlh" as f/>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="FTA">

    <h1>Двухфакторная аутентификация</h1>
    <@b.baseForm path="/ftaPage" name="fta">
        <@f.fta/>
    </@b.baseForm>
</@bh.base>