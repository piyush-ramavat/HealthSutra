<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <div class="section service">
            <div class="container">
                <div class="row">

                    <h1>Subject List</h1>
                    <table border="1">
                        <th>No</th>
                        <th>Name</th>
                        <th>Position</th>
                        <th>Visible</th>

                        <c:forEach var="subject" items="${subjectList}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>${subject.name}</td>
                                <td>${subject.position}</td>
                                <td>${subject.visible}</td>

                            </tr>
                        </c:forEach>
                    </table>

                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>