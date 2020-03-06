 
<html>
<head>
<title>Start Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <h2>REST Upload demo</h2>
    
    <!-- <form method="post" action="rest/demo/upload"
        enctype="multipart/form-data">
        <input type="hidden" name="action" value="upload" /> <label>Load
            your file:</label> <input type="file" name="attachment" /> <br /> 
            <input type="submit" value="Upload" />
    </form> -->
    <font color="blue">${uploadStatus}</font>
    <form method="post"  enctype="multipart/form-data">
        <input type="hidden" name="action" value="upload" /> <label>Load
            your file:</label> <input type="file" name="file" /> <br /> 
            Order Id: <input type="text" name="orderId">
            File Type: <input type="text" name="fileType">
            <input type="submit" value="Upload file" />
    </form>
    <form action="download">
    <input type="submit" ${ isDownloadVisible  ? 'disabled="disabled"' : ''} 
 	value="Download" />
</form>
 
    <!-- <h2>REST Download demo</h2>
    <form method="post" action="rest/demo/download">
        Order ID: <input type="text" name="orderId"> 
        File Name: <input type="text" name="fileName">
        <input type="submit" value = "Download File">
 
 
    </form> -->
     
    <!-- <h2>Current Directory $HOME/uploads:</h2> -->
    <br/>
           
</body>
</html>