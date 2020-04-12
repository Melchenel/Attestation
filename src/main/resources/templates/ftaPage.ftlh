<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/ftaForm.ftlh" as f/>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="FTA">

    <div class="col align-self-center">
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <h2>TWO-FACTOR AUTHENTICATION</h2>
                <h6>Please enter the one-time code that came to your email</h6>
            </div>
            <div class="col"></div>
        </div>

        <div class="row">
            <div class="col"></div>
            <div class="col align-self-center">
                <div class="card " style="width: 20rem;">
                    <div class="card-body">
                        <@b.baseForm path="/ftaPage" name="fta" button="ок">
                            <@f.fta/>
                        </@b.baseForm>

                        <@b.baseForm path="/repeatCode" name="repeat" button="resend code">
                        </@b.baseForm>

                        <@b.baseForm path="/sendCodeOnPhone" name="sendCodeOnPhone" button="I do not have access to email">
                        </@b.baseForm>

                        ${message?ifExists}
                    </div>
                </div>
            </div>
            <div class="col"></div>
        </div>
    </div>
</@bh.base>