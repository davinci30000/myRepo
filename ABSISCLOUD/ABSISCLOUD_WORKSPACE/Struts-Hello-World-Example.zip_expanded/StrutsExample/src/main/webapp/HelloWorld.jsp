<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<script src="libs/jquery-3.2.1.js"></script>
<html>
<script src="./libs/jquery-3.2.1.js"></script>
<head>
</head>
<body>
<h1><bean:write name="helloWorldForm" property="message" />
</h1>
<html:form action="helloWorld" method="post">Fichero
<html:file property="file"/>
Nombre
<html:text styleId="id" property="message" title="nombre"/>
<input type="submit" title="boton" value="boton"/>
</html:form>
<button id="but" value="ajax" onCLick="fun()"></button>
<a href="helloWorld.do?text="+$taxt></a>
<script>
function fun(){
	var taxt= document.getElementById('id').value;
	window.location.href="helloWorld.do?text="+taxt;
};
</script>

</body>
</html>