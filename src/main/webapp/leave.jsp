<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Leave Application</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
    </style>
</head>
<body class="w3-light-grey">
<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <span class="w3-bar-item w3-right">Leave Applying Dashboard</span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar">
    <br>
    <div class="w3-container">
        <h5>Apply to your leave </strong></h5>
    </div>
    <hr>
    <div class="w3-container">
        <h5>Employee Dashboard</h5>
    </div>
    <div class="w3-bar-block">
        <a href="dash2.html" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw"></i> Profile</a>
        <a href="attendance.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-calendar fa-fw"></i> Attendance</a>
        <a href="leave.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-file-text fa-fw"></i> Leave Application</a>
        <a href="login.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
    </div>
</nav>

<!-- Page content -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

    <!-- Header -->
    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-file-text"></i> Leave Application</b></h5>
    </header>

    <!-- Leave Details -->
    <div class="w3-container">
        <h5>Your Leave Details</h5>
        <table class="w3-table w3-bordered">
            <tr>
                <th>Leave Type</th>
                <th>Total Leaves</th>
                <th>Remaining Leaves</th>
                <th>Pending Leave</th>
            </tr>
            <!-- Populate leave details dynamically -->
            <c:forEach var="leave" items="${leaveDetails}">
                <tr>
                    <td>${leave.leaveType}</td>
                    <td>${leave.totalLeaves}</td>
                    <td>${leave.remainingLeaves}</td>
                    <td>${leave.pendingLeave}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <!-- Apply Leave Form -->
    <div class="w3-container w3-margin-top">
        <h5>Apply New Leave</h5>
        <form action="Applyleave" method="post">
            <label for="leaveType">Leave Type:</label>
            <select class="w3-select w3-border" id="leaveType" name="leaveType" required>
                <option value="" disabled selected>Select Leave Type</option>
                <option value="annual">Annual</option>
                <option value="sick">Sick</option>
                <option value="short">Short</option>
            </select>
            <br><br>
            <label for="fromDate">From Date:</label>
            <input class="w3-input w3-border" type="date" id="fromDate" name="fromDate" required>
            <br><br>
            <label for="toDate">To Date:</label>
            <input class="w3-input w3-border" type="date" id="toDate" name="toDate" required>
            <br><br>
            <button class="w3-button w3-blue" type="submit">Submit</button>
        </form>
    </div>

</div>

<script>
    // Fetching the logged-in user's name from the session and updating the welcome message
    document.getElementById("loggedInUserName").innerText = '<%= session.getAttribute("loggedInUser") %>';
</script>

</body>
</html>