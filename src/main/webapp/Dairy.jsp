<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dairy</title>

    <style>
        body
        {
            background-image: url('${pageContext.request.contextPath}/images/background.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            min-height: 100vh;
            margin: 0;
        }
    </style>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="d-flex justify-content-center align-items-center vh-100">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h3 class="text-center mb-4">Fill your Dairy Details below</h3>

            <form action="${pageContext.request.contextPath}/dairy" method="post">
                <input type="hidden" name="id" value="${dto.id}">

                <div class="form-field mb-3">
                    <label for="date" class="form-label">Date</label>
                    <input type="date" class="form-control"
                           id="date" name="date"
                           value="${dto.date}" required>
                </div>

                <div class="form-field mb-3">
                    <label for="dairyName" class="form-label">Dairy Name</label>
                    <input type="text" class="form-control"
                           id="dairyName" name="dairyName"
                           value="${dto.dairyName}"
                           placeholder="eg: Nandini Dairy" required>
                </div>

                <div class="form-field mb-3">
                    <label for="ownerName" class="form-label">Owner Name</label>
                    <input type="text" class="form-control"
                           id="ownerName" name="ownerName"
                           value="${dto.ownerName}"
                           placeholder="eg: Nikhil" required>
                </div>

                <div class="form-field mb-3">
                    <label for="location" class="form-label">Location</label>
                    <select class="form-select" id="location" name="location" required>
                        <c:forEach items="${companyLocation}" var="location">
                            <option value="${location}" ${dto.location == location ? 'selected' : ''}>${location}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-field mb-3">
                    <label for="phoneNumber" class="form-label">Phone Number</label>
                    <input type="text" class="form-control"
                           id="phoneNumber" name="phoneNumber"
                           value="${dto.phoneNumber}"
                           placeholder="eg: 9876543210" required>
                </div>

                <button type="submit" class="btn btn-success w-100">Submit</button>

                <div style="color:green">${message}</div>
                <div style="color:red">${error}</div>

                <c:forEach items="${errors}" var="error">
                    <div style="color:red">${error.defaultMessage}</div>
                </c:forEach>

            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>