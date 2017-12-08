<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

</head>
<style>
    .navbar {
        border-radius: 0 !important;
    }

    .btn-sq-lg {
        width: 500px !important;
    }

    .btn-sq {
        width: 100px !important;
        height: 100px !important;
        font-size: 10px;
    }

    .btn-sq-sm {
        width: 50px !important;
        height: 50px !important;
        font-size: 10px;
    }

    .btn-sq-xs {
        width: 25px !important;
        height: 25px !important;
        padding: 2px;
    }
</style>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Hospital Services</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
        </ul>
    </div>
</nav>
<br/><br/><br/><br/><br/>
<div class="container">
    <div>
        <div class="col-lg-6 col-md-offset-3">
            <p>
                <a href="/employees" class="btn btn-sq-lg btn-primary">
                    <i class="fa fa-user fa-5x"></i><br/>
                    Hospital Services
                </a>
            </p>
        </div>
        <div class="col-lg-6 col-md-offset-3">
            <p>

                <a href="/topnursing" class="btn btn-sq-lg btn-success">
                    <i class="fa fa-user fa-5x"></i><br/>
                    Search top nursing home for state
                </a>

            </p>
        </div>
        <div class="col-lg-6 col-md-offset-3">
            <p>

                <a href="/deficiency" class="btn btn-sq-lg btn-info">
                    <i class="fa fa-user fa-5x"></i><br/>
                    Nursing home deficiency with inspection cycle
                </a>

            </p>
        </div>
        <div class="col-lg-6 col-md-offset-3">
            <p>

                <a href="/fines" class="btn btn-sq-lg btn-warning">
                    <i class="fa fa-user fa-5x"></i><br/>
                    Nursing home with fines
                </a>

            </p>
        </div>
    </div>
</div>
</body>
</html>
