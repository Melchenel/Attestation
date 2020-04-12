<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/login.ftlh" as l>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="Login Page" color="#673AB7">
    <div class="col align-self-center">
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <h2>RESET PASSWORD</h2>
                <h6>Please enter your login</h6>
            </div>
            <div class="col"></div>
        </div>

        <div class="row">
            <div class="col"></div>
            <div class="col align-self-center">
                <div class="card " style="width: 20rem;">
                    <div class="card-body">
                        <@b.baseForm path="/login" name="Login" button="ок">
                            <@l.login/>
                        </@b.baseForm>
                     ${message?ifExists}
                    </div>
                </div>
            </div>
            <div class="col"></div>
        </div>
    </div>
</@bh.base>