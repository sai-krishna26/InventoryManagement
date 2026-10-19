<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dairy</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="d-flex justify-content-center align-items-center">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h3 class="text-center mb-4">Fill your Dairy Details below</h3>

<!--            <form action="${pageContext.request.contextPath}/dairy" method="post">    // for backend validation-->
            <form action="${pageContext.request.contextPath}/dairy" method="post" onsubmit="return validateForm()">
                <input type="hidden" name="id" value="${dto.id}">

                <div class="form-field mb-3">
                    <label for="date" class="form-label">Today'sDate</label>
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
                        <c:forEach items="${location}" var="location">
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

                <div style="color:green">${success}</div>
                <div style="color:red">${error}</div>

                <c:forEach items="${errors}" var="error">
                    <div style="color:red">${error.defaultMessage}</div>
                </c:forEach>

            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function validatrForm()
    {

    const date = document.getElementById('date').value;
    const dairyName = document.getElementById('dairyName').value.trim();
    const ownerName = document.getElementById('ownerName').value.trim();
    const location = document.getElementById('location').value;
    const phoneNumber = document.getElementById('phoneNumber').value.trim();

    if(!date)
    {
        alert('choose a proper date');
        return false;
    }

    if(!dairyName || dairyName.length()<5)
    {
        alert('dairy name should be between 5 and 20 characters');
        return false;
    }

    if(!ownerName || ownerName.length()<3)
    {
        alert('owner name should be between 3 and 20 characters');
        return false;
    }

    if(!phoneNumber || phoneNumber.length()<10)
    {
        alert('phone number should be 10 digits');
        return false;
    }

    return true;
    }
</script>
</body>
</html>