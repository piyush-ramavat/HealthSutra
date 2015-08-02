<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!-- Start  Logo & Naviagtion  -->
<div class="navbar navbar-default navbar-top">
    <div class="container">
        <div class="navbar-header">
            <!-- Stat Toggle Nav Link For Mobiles -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <i class="fa fa-bars"></i>
            </button>
            <!-- End Toggle Nav Link For Mobiles -->
            <a class="navbar-brand" href="<c:url value="/welcome" />">
                <img alt="HealthSutra" width="150" src="${pageContext.request.contextPath}/resources/images/healthsutra.png">
            </a>
        </div>
        <div class="navbar-collapse collapse">
            <!-- Stat Search -->
            <div class="search-side">
                <a href="#" class="show-search"><i class="fa fa-search"></i></a>
                <div class="search-form">
                    <form autocomplete="off" role="search" method="get" class="searchform" action="#">
                        <input type="text" value="" name="s" id="s" placeholder="Search HealtySutra.com">
                    </form>
                </div>
            </div>
            <!-- End Search -->

            <!-- Start Navigation List -->
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a class="active" href="<c:url value="/welcome" />">Home</a>
                    <ul class="dropdown">
                        <li><a class="active" href="<c:url value="/about" />">about</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="<c:url value="/about" />">About</a>
                </li>
                <li>
                    <a href="javascript:formSubmit()"> Logout</a>
                </li>
            </ul>
            <!-- End Navigation List -->
        </div>
    </div>
</div>
<!-- End Header Logo & Naviagtion -->
