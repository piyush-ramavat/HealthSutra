<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start Footer Section -->
<footer>
    <div class="">
        <!-- Start Copyright -->
        <div class="copyright-section">
            <div class="row">
                <div class="col-md-6">
                    <p>&copy; 2015 HealthSutra - All Rights Reserved <a href="http://healthsutra.com.au">HealthSutra</a>
                    </p>
                </div>
                <!-- .col-md-6 -->
                <div class="col-md-6">
                    <ul class="footer-nav">
                        <li><a href="#">Sitemap</a>
                        </li>
                        <li><a href="#">Privacy Policy</a>
                        </li>
                        <li><a href="#">Contact</a>
                        </li>
                    </ul>
                </div>
                <!-- .col-md-6 -->
            </div>
            <!-- .row -->
        </div>
        <!-- End Copyright -->
    </div>
</footer>
<!-- End Footer Section -->


<c:url value="/j_spring_security_logout" var="logoutUrl"/>

<!-- csrf for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>