<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <section id="admin" class="bg-main">
            <div class="container">
                <div class="row">
                    <h1>${title}</h1>

                    <h2>${message}</h2>

                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <h2>
                            Welcome : ${pageContext.request.userPrincipal.name}
                        </h2>
                    </c:if>
                </div>
            </div>
        </section>
    </tiles:putAttribute>
</tiles:insertDefinition>