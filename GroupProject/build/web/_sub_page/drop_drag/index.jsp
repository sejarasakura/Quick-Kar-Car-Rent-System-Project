<%-- 
    Document   : index
    Created on : Dec 27, 2019, 5:26:06 PM
    Author     : xps
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>HTML5 File Drag &amp; Drop API</title>
<link rel="stylesheet" type="text/css" media="all" href="styles.css" />
</head>
	<body>
            <form id="upload" action="/GroupProject/<%= request.getParameter("servlet")%>" method="POST" enctype="multipart/form-data">
		<fieldset>
			<legend>Upload photo here</legend>
			<input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE" value="300000" />
			<div>
				<label for="fileselect">Files to upload:</label>
				<input type="file" id="fileselect" name="fileselect[]" multiple="multiple" />
				<div id="filedrag">or drop files here</div>
			</div>
			<div id="submitbutton">
				<button type="submit">Upload Files</button>
			</div>
		</fieldset>
            </form>
            <script src="filedrag.js"></script>
	</body>
</html>