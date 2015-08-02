<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <div class="section service">
            <div class="container">
                <div class="row">

                    <!-- Start Big Heading -->
                    <div class="big-title text-center" data-animation="fadeInDown" data-animation-delay="01">
                        <h1>At your <strong>Service</strong></h1>
                    </div>
                    <!-- End Big Heading -->
                    <p class="text-center">We at HeathSutra are here for all trainers and patrons for their better health.</p>


                    <!-- Start Service Icon 1 -->
                    <div class="col-md-3 col-sm-3 service-box service-center" data-animation="fadeIn" data-animation-delay="01">
                        <div class="service-icon">
                            <i class="fa fa-leaf icon-large"></i>
                        </div>
                        <div class="service-content">
                            <h4><a href="<c:url value="/admin" />">Admin</a></h4>

                            <p>Manage your firm.</p>

                        </div>
                    </div>
                    <!-- End Service Icon 1 -->
                    <!-- Start Service Icon 2 -->
                    <div class="col-md-3 col-sm-3 service-box service-center" data-animation="fadeIn" data-animation-delay="02">
                        <div class="service-icon">
                            <i class="fa fa-desktop icon-large"></i>
                        </div>
                        <div class="service-content">
                            <h4><a href="<c:url value="/subjects/listAll" />">User Management</a></h4>

                            <p>Manage Your Users and Assign Training programs!</p>
                        </div>
                    </div>
                    <!-- End Service Icon 2 -->

                    <!-- Start Service Icon 3 -->
                    <div class="col-md-3 col-sm-6 service-box service-center" data-animation="fadeIn" data-animation-delay="03">
                        <div class="service-icon">
                            <i class="fa fa-umbrella icon-large"></i>
                        </div>
                        <div class="service-content">
                            <h4>Help & Support</h4>
                            <p>Got suggestions? Feel free to contact us.</p>
                        </div>
                    </div>
                    <!-- End Service Icon 3 -->

                    <!-- Start Service Icon 4 -->
                    <div class="col-md-3 col-sm-3 service-box service-center" data-animation="fadeIn" data-animation-delay="04">
                        <div class="service-icon">
                            <i class="fa fa-eye icon-large"></i>
                        </div>
                        <div class="service-content">
                            <h4><a href="javascript:formSubmit()"> Logout</a></h4>

                            <p>Done with your work? Fly home !!!</p>
                        </div>
                    </div>
                    <!-- End Service Icon 4 -->
                </div>
                <!-- .row -->
            </div>
            <!-- .container -->
        </div>
        <!-- End Services Section -->

    </tiles:putAttribute>
</tiles:insertDefinition>