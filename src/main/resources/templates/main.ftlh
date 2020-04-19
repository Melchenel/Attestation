<#import "parts/baseHtml.ftlh" as bh/>
<#import "parts/baseForm.ftlh" as b/>
<#import "parts/changePasswordForm.ftlh" as ch/>
<#import "parts/oldPasswordForm.ftlh" as op/>
<#import "parts/adminPart.ftlh" as a/>
<#import "parts/login.ftlh" as l/>
<#import "parts/userForm.ftlh" as u/>
<@bh.base title="Profile" color="white">
<div class="col align-self-center">
<div class="row pt-2">
    <div class="col-9">
       <h3 style="color: #673AB7"> Profile</h3>
    </div>
    <div class="col-3">
        <@b.baseForm path="/logout" name="logout" button="logout">
        </@b.baseForm>
    </div>
    <hr style="color: #673AB7"/>
</div>

<div class="row">
    <div class="col-7">
        <div class="row">
            <div class="col">LOGIN </div>
            <div class="col">${user?ifExists.login} </div>
        </div>
        <div class="row">
            <div class="col">EMAIL </div>
            <div class="col">${user?ifExists.email} </div>
        </div>
        <div class="row">
            <div class="col">PHONE </div>
            <div class="col">${user?ifExists.phoneNumber} </div>
        </div>
        <div class="row">
            <div class="col">LAST NAME </div>
            <div class="col">${user?ifExists.lastName} </div>
        </div>
        <div class="row">
            <div class="col">FIRST NAME </div>
            <div class="col">${user?ifExists.firstName} </div>
        </div>

    </div>


    <div class="col-5">
        change password:
        <div class="card " style="width: 20rem; background-color: #673AB7; color:white;">
            <div class="card-body">
                <@b.baseForm path="/changePassword" name="changePassword" button="ок">
                    <@op.oldPassword/>
                    <@ch.changePass/>
                 </@b.baseForm>
                ${message?ifExists}
            </div>
        </div>
    </div>

</div>

<br/>
<br/>

<div class="row">
    <#if user?ifExists.role == 2>

        <div class="col-7"/>
            <@a.admin/>
        </div>

        <div class="col-5 "/>

            <div class="row">
                <div class="col">
                    delete user:

                    <div class="card " style="width: 20rem; background-color: #673AB7; color:white;">
                        <div class="card-body">
                            <@b.baseForm path="/delete" name="delete" button="delete">
                                <@l.login/>
                            </@b.baseForm>
                            ${messageForAdmin?ifExists}
                        </div>
                    </div>
                </div>
            </div>
        <br/>
        <br/>
            <div class="row">
                <div class="col">
                    add user:
                    <div class="card " style="width: 20rem; background-color: #673AB7; color:white;">
                        <div class="card-body">
                            <@b.baseForm path="/add" name="add" button="add">
                                <@u.user/>
                            </@b.baseForm>
                            ${messageForAdmin?ifExists}
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </#if>

    </div>

</div>


</@bh.base>

