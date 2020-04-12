<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/changePasswordForm.ftlh" as cp/>
<#import "parts/baseForm.ftlh" as b/>
<@bh.base title="Restore Password" color="#673AB7">

    <div class="col align-self-center">
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <h2>RESET PASSWORD</h2>
                <h6>Please create a new password</h6>
            </div>
            <div class="col"></div>
        </div>

        <div class="row">
            <div class="col"></div>
            <div class="col align-self-center">
                <div class="card " style="width: 20rem;">
                    <div class="card-body">
                        ${login?ifExists}
                        <@b.baseForm path="/restorePassword" name="RestorePassword" button="ок">
                            <@cp.changePass/>
                        </@b.baseForm>
                        ${message?ifExists}
                    </div>
                </div>
            </div>
            <div class="col"></div>
        </div>
    </div>


</@bh.base>