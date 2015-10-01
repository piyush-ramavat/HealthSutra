<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <section id="home">
            <!-- Carousel -->
                            <div id="main-slide" class="carousel" data-ride="carousel">

                                <!-- Indicators -->
                                <ol class="carousel-indicators">
                                    <li data-target="#main-slide" data-slide-to="0" class="active"></li>
                                    <li data-target="#main-slide" data-slide-to="1"></li>
                                    <li data-target="#main-slide" data-slide-to="2"></li>
                                </ol>
                                <!--/ Indicators end-->

                                <!-- Carousel inner -->
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/slider/bg1.jpg" alt="slider">

                                        <div class="slider-content">
                                            <div class="col-md-12 text-center">
                                                <h2 class="animated2">
                                                    <span>Welcome to <strong>HealthSutra</strong></span>
                                                </h2>

                                                <h3 class="animated3">
                                                    <span>Your friendly companion for health</span>
                                                </h3>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/ Carousel item end -->
                                    <div class="item">
                                        <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/slider/bg2.jpg" alt="slider">

                                        <div class="slider-content">
                                            <div class="col-md-12 text-center">
                                                <h2 class="animated4">
                                                    <span><strong>Healthsutra</strong> for the Trainers</span>
                                                </h2>

                                                <h3 class="animated5">
                                                    <span>To make things easy</span>
                                                </h3>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/ Carousel item end -->
                                    <div class="item">
                                        <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/slider/bg3.jpg" alt="slider">

                                        <div class="slider-content">
                                            <div class="col-md-12 text-center">
                                                <h2 class="animated7 white">
                                                    <span>The way of being <strong>Healthy</strong></span>
                                                </h2>

                                                <h3 class="animated8 white">
                                                    <span>Fitness, Peace and Happiness</span>
                                                </h3>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/ Carousel item end -->
                                </div>
                                <!-- Carousel inner end-->

                                <!-- Controls -->
                                <a class="left carousel-control" href="#main-slide" data-slide="prev">
                                    <span><i class="fa fa-angle-left"></i></span>
                                </a>
                                <a class="right carousel-control" href="#main-slide" data-slide="next">
                                    <span><i class="fa fa-angle-right"></i></span>
                                </a>
                            </div>
                           <!-- /carousel -->
        </section>
        <!-- End Home Page Slider -->
    </tiles:putAttribute>
</tiles:insertDefinition>