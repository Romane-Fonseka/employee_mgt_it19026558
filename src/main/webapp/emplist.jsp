<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
        <style>
        .search-container {
  		text-align: center;
		}
        
        </style>
</head>

<body>

<!--  <h1>Employee List</h1>-->
    <header>
        <nav class="navbar navbar-expand-md navbar-dark"
            style="background-color: skyblue">
            <div>
                <a href="TestEmpDash.html" class="navbar-brand"> Employee
                    Management </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="TestEmpDash.html"
                        class="nav-link">Employee</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div>
    		<form action="TestEmployeeServlet" method="get">
    		<div class="search-container">
    		Search: <input type="text" name="searchText" />
   			 <button type="submit">Search</button> </div>
  		</form> </div><BR>

    <div class="row">

        <div class="container">
            <h3 class="text-center">Report of Employees</h3>
            <hr>
            <div class="container text-left">

                <a href="TestEmpDash.html" class="btn btn-success">Add
                    New Employee</a>
            </div>
            
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Department</th>
                        <th>Salary</th>
                        <th>Action</th>
                    </tr>
                </thead>
                
                <tbody>
                    <c:forEach var="employee" items="${listEmployees}">
                        <tr>
                            <td><c:out value="${employee.id}" /></td>
                            <td><c:out value="${employee.firstName}" /></td>
                            <td><c:out value="${employee.lastName}" /></td>
                            <td><c:out value="${employee.email}" /></td>
                            <td><c:out value="${employee.department}" /></td>
                            <td><c:out value="${employee.salary}" /></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/Update?id=<c:out value='${employee.id}' />" class="btn btn-primary">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="<%=request.getContextPath()%>/Delete?action=delete&id=<c:out value='${employee.id}' />" class="btn btn-danger">Delete</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
								<a href="#" onclick="downloadEmployeeData(${employee.id})">  <button class="btn btn-danger">Download</button></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
<script>
// Function to download employee data using AJAX and handle errors
  // Function to download employee data using AJAX and handle errors
  function downloadEmployeeData(employeeId) {
    fetch('<%=request.getContextPath()%>/DownloadServlet?id=' + employeeId)
      .then(response => {
        if (!response.ok) {
          throw new Error(`Error downloading employee data: ${response.statusText}`);
        }
        return response.blob(); // Assuming server returns the data as a Blob
      })
      .then(blob => {
        // Create a temporary anchor element and trigger download
        var link = document.createElement("a");
        link.href = window.URL.createObjectURL(blob);

        // Set the filename (replace with a dynamic filename if needed)
        link.download = "employee_" + employeeId + ".csv"; // Adjust filename extension

        // Click the anchor to trigger the download
        link.click();
      })
      .catch(error => {
        // Handle download error (e.g., display an error message to the user)
        console.error("Error downloading employee data:", error);
        alert("Failed to download employee record. Please try again later.");
      });
  }

      
</script>

</body>
</html>