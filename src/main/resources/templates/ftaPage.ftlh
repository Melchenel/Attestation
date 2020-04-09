<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/ftaForm.ftlh" as f/>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="FTA">

    <h1>Двухфакторная аутентификация</h1>
    <@b.baseForm path="/ftaPage" name="fta" button="ок">
        <@f.fta/>
    </@b.baseForm>

    <@b.baseForm path="/repeatCode" name="repeat" button="отправить повторно">
    </@b.baseForm>

    <@b.baseForm path="/sendCodeOnPhone" name="sendCodeOnPhone" button="отправить код на телефон">
    </@b.baseForm>
</@bh.base>