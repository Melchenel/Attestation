<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/autorizationForm.ftlh" as a/>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="Autorization" color="#673AB7">
    <div class="col  mt-10">
    <div class="row mt-10 pt-10">
        <div class="col pt-10"></div>
    <div class="col mt-10 pt-10">
        <h2>AUTHORIZATION</h2>
        <h6>Please log in to enter the site</h6>
    </div>
        <div class="col"></div>
    </div>

    <div class="row">
        <div class="col"></div>
    <div class="col">
        <div class="card " style="width: 20rem;">
            <div class="card-body">
            <@b.baseForm path="/auth" name="autorization" button="войти">
                <@a.authorization path="/auth"/>
            </@b.baseForm>
            <a href="/login" style="align-content:center">Have you forgotten your password?</a>
                ${message?ifExists}
            </div>
        </div>
    </div>
    <div class="col"></div>
    </div>
    </div>
</@bh.base>