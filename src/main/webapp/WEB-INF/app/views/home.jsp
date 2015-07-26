<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <section id="home" class="bg-main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading">At Your Service</h2>
                            <%--
                                        <center>
                                            <h1>Title : ${title}</h1>

                                            <h1>Message : ${message}</h1>
                                        </center>
                            --%>
                        <hr class="primary">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-3 text-center">
                        <div class="col-lg-3 col-md-6 text-center">
                            <div class="service-box">
                                <i class="fa fa-4x fa-diamond wow bounceIn text-primary"></i>

                                <h3><a href="<c:url value="/admin" />">Admin</a></h3>

                                <p class="text-muted">Manage your Firm.</p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 text-center">
                            <div class="service-box">
                                <i class="fa fa-4x fa-newspaper-o wow bounceIn text-primary" data-wow-delay=".2s"></i>

                                <h3><a href="<c:url value="/subjects/listAll" />">User Management</a></h3>

                                <p class="text-muted">Manage Your Users and Assign Training programs!</p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 text-center">
                            <div class="service-box">
                                <i class="fa fa-4x fa-paper-plane wow bounceIn text-primary" data-wow-delay=".1s"></i>

                                <h3><a href="javascript:formSubmit()"> Logout</a></h3>

                                <p class="text-muted">Done with your work? Fly home !!!</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </tiles:putAttribute>
</tiles:insertDefinition>