<#macro authorization path>

   <form method="post" name="authorization" action="${path}">

       <label for="login">Login</label>
        <input type="text" name="login" id="login"/> <br/>
       <label for="password">Password</label>
        <input type="password" name="password" id="password"><br/>

       <p><input type="submit"></p>
   </form>
</#macro>