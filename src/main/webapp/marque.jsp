

<%@page import="beans.Marque"%>


<%@page import="service.MarqueService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion des Marques</title>
        <style type="text/css">
        body{
        background-color:#2C6975;
        }
        *{
  margin: 0;
  padding: 0;
  font-family: "montserrat",sans-serif;
}
.contact-section{
  background: url(bg.png) no-repeat center;
  background-size: cover;
  padding: 40px 0;
}
.contact-section h1{
  text-align: center;
  color: #ddd;
}
.border{
  width: 100px;
  height: 10px;
  background: #34495e;
  margin: 40px auto;
}

.contact-form{
  max-width: 600px;
  margin: auto;
  padding: 0 10px;
  overflow: hidden;
}

.contact-form-text{
  display: block;
  width: 100%;
  box-sizing: border-box;
  margin: 16px 0;
  border: 0;
  background: #111;
  padding: 20px 40px;
  outline: none;
  color: #ddd;
  transition: 0.5s;
}
.contact-form-text:focus{
  box-shadow: 0 0 10px 4px #34495e;
}
textarea.contact-form-text{
  resize: none;
  height: 120px;
}
.contact-form-btn{
  float: right;
  border: 0;
  background: #34495e;
  color: #fff;
  padding: 12px 50px;
  border-radius: 20px;
  cursor: pointer;
  transition: 0.5s;
}
.contact-form-btn:hover{
  background: #2980b9;
}
h1{
  font-size: 30px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}
table{
  width:100%;
  table-layout: fixed;
}
.tbl-header{
  background-color: rgba(255,255,255,0.3);
 }
.tbl-content{
  height:300px;
  overflow-x:auto;
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 20px 15px;
  text-align: left;
  font-weight: 500;
  font-size: 12px;
  color: #fff;
  text-transform: uppercase;
}
td{
  padding: 15px;
  text-align: left;
  vertical-align:middle;
  font-weight: 300;
  font-size: 12px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}


/* demo styles */

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
body{
  background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4);
  font-family: 'Roboto', sans-serif;
}
section{
  margin: 50px;
}


/* follow me template */
.made-with-love {
  margin-top: 40px;
  padding: 10px;
  clear: left;
  text-align: center;
  font-size: 10px;
  font-family: arial;
  color: #fff;
}
.made-with-love i {
  font-style: normal;
  color: #F50057;
  font-size: 14px;
  position: relative;
  top: 2px;
}
.made-with-love a {
  color: #fff;
  text-decoration: none;
}
.made-with-love a:hover {
  text-decoration: underline;
}


/* for custom scrollbar for webkit browser*/

::-webkit-scrollbar {
    width: 6px;
} 
::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
} 
::-webkit-scrollbar-thumb {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
}
        </style>
    </head>
    <body>
    <div class="contact-section">
        <form action="MachineController"class="contact-form" method="POST">
            <input type="hidden" name="id"class="contact-form-text" value="<%= request.getParameter("idM") == null ? "" : request.getParameter("idM")%>" size="idM" />
                
                <h1>Nouvelle Marque</h1>  
                      <input required="" type="text" class="contact-form-text" placeholder="Marque Code" name="Mcode" value="<%= request.getParameter("Mcode") == null ? "" : request.getParameter("Mcode")%>" />
                      <input required="" type="text"class="contact-form-text"placeholder="Libelle" name="libelle" value="<%= request.getParameter("libelle") == null ? "" : request.getParameter("libelle")%>" />
                    
                        <input type="submit"class="contact-form-btn" value="Envoyer" /></td>
                        <input type="reset"class="contact-form-btn" value="Annuler" /></td>
                    </tr>

               
            
        </form>

        <section>
            <h1>Liste des Marques </h1>
            <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Code Marque</th>
                        <th>libelle</th>
                        <th>Supprimer</th>
                        <th>Modifier</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        MarqueService ms = new MarqueService();
                        for (Marque m : ms.findAll()) {
                    %>
                    <tr>
                        <td><%= m.getIdM()%></td>
                        <td><%= m.getCodeM()%></td>
                        <td><%= m.getLibelle()%></td>
                        
                        <td><a href="MarqueController?idM=<%= m.getIdM()%>&op=delete">Supprimer</a></td>
                        <td><a href="MarqueController?idM=<%= m.getIdM()%>&op=update">Modifier</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        
        </div>
        </section>
        
    </body>
    <script type="text/javascript">
    $(window).on("load resize ", function() {
    	  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
    	  $('.tbl-header').css({'padding-right':scrollWidth});
    	}).resize();
    </script>
</html>
