<#macro base title color>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <style>
            h2 {
                font-family: Montserrat;
                padding-top: 50px;
                color: #FFFFFF;
            }

            h6{
                font-family: Montserrat;
                color: #D1C4E9;
            }

            body{
                font-family: Montserrat;
                font-style: normal;
                font-weight: normal;

            }

            .button{
                background: #D1C4E9;
                color: white;
            }
        </style>
    </head>
    <body class="container" style="background-color:${color}">
    <div class="row">

            <#nested>
    </div>

    </body>
    </html>
</#macro>