package airtraffic.legacy;

/*import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class ServletAirport extends HttpServlet
{
	private String setHTML(String type, String[] datos)
	{
		String respuesta = "";
		if(type.equals("vueloEspecifico"))
		{
			respuesta = "<form action='http://localhost:8080/airport/airport' method ='get'>";
			respuesta = respuesta + "Estado: ";
			respuesta = respuesta + "<select>' name='estado'>";
			respuesta = respuesta + "		<option value=ON TIME>A TIEMPO</option>";
			respuesta = respuesta + "		<option value=DELAYED>RETRASADO</option>";
			respuesta = respuesta + "		<option value=ARRIVED>ARRIVÓ</option>";
			respuesta = respuesta + "		<option value=FLYING>VOLANDO</option>";
			respuesta = respuesta + " </select> <br>";
			respuesta = respuesta + "Día: ";
			respuesta = respuesta + "<input type='date' name='dia' > <br>";
			respuesta = respuesta + "Hora: ";
			respuesta = respuesta + "<input type='number' name='hora' > <br>";
			respuesta = respuesta + "<input type='submit' name='buscarVueloEspecifico' value='Search'> ";
			respuesta = respuesta + "</form>";
		}

		if(type.equals("consultarAeropuertos"))
		{
			int tam;
			respuesta = "<form action='http://localhost:8080/airport/airport' method ='get'>";	
			respuesta = respuesta + "Aeropuerto: ";
			respuesta = respuesta + "<select name = 'airportName'>";
			tam = datos.length;
						for(int i = 0; i<tam;i++)
						{
							respuesta = respuesta + "<option  value = "+datos[i]+">"+datos[i]+"</option>";
						}
			respuesta = respuesta + "</select><br>";
			respuesta = respuesta + "<input type='submit' name='buscarporAeropuerto' value='Search'> ";
			respuesta = respuesta + "</form>";
		}

		if(type.equals("formularioAeropuertos"))
		{
			respuesta = "<form action='http://localhost:8080/airport/airport' method ='get'>";	
			respuesta = respuesta + "Airport Code: ";
			respuesta = respuesta + "<input type='text' name='airportCode'> <br>";
			respuesta = respuesta + "Airport Name: ";
			respuesta = respuesta + "<input type='text' name='airportName'> <br>";
			respuesta = respuesta + "Airport Address: ";
			respuesta = respuesta + "<input type='text' name='airportAddress'> <br>";
			respuesta = respuesta + "<input type='submit' name='nuevoAeropuerto' value='Search'> ";
			respuesta = respuesta + "</form>";
		}

		if(type.equals("NombreAerolinea"))
		{
			int tam = 0;
			respuesta = "<form action='http://localhost:8080/airport/airport' method ='get'>";	
			respuesta = respuesta + "Airline Name: ";
			respuesta = respuesta + "<select name = 'airlineName'>";
			tam = datos.length;
						for(int i = 0; i<tam;i++)
						{
							respuesta = respuesta + "<option  value = "+datos[i]+">"+datos[i]+"</option>";
						}
			respuesta = respuesta + "</select>";
			respuesta = respuesta + "<input type='submit' name='datosAerolinea' value='Search'> ";
			respuesta = respuesta + "</form>";
		}

		if(type.equals("NewAirline"))
		{
			int tam = 0;
			respuesta = "<form action='http://localhost:8080/airport/airport' method ='get'>";	
			respuesta = respuesta + "Airline Code: ";
			respuesta = respuesta + "<input type='text' name='airLineCode'> <br>";
			respuesta = respuesta + "Airline Name: ";
			respuesta = respuesta + "<input type='text' name='airLineName'> <br>";
			respuesta = respuesta + "Base: ";
			respuesta = respuesta + "<select name = 'airlineBase'>";
			tam = datos.length;
						for(int i = 0; i<tam;i++)
						{
							respuesta = respuesta + "<option  value = "+datos[i]+">"+datos[i]+"</option>";
						}
			respuesta = respuesta + "</select><br>";
			respuesta = respuesta + "<input type='submit' name='datosNuevaAerolinea' value='Registrar'> ";
			respuesta = respuesta + "</form>";
			
		}

		if(type.equals("nuevoAvion"))
		{
			int tam = 0;
			respuesta = "<form action='http://localhost:8080/airport/airport' method ='get'>";	
			respuesta = respuesta + "Placa: ";
			respuesta = respuesta + "<input type='text' name='airplanePLate'> <br>";
			respuesta = respuesta + "Base: ";
			respuesta = respuesta + "<select name = 'airplaneAirline'>";
			tam = datos.length;
						for(int i = 0; i<tam;i++)
						{
							respuesta = respuesta + "<option  value = "+datos[i]+">"+datos[i]+"</option>";
						}
			respuesta = respuesta + "</select><br>";
			respuesta = respuesta + "Modelo: ";
			respuesta = respuesta + "<input type='text' name='airplaneModel'> <br>";
			respuesta = respuesta + "Horas: ";
			respuesta = respuesta + "<input type='text' name='airplaneHours'> <br>";
			respuesta = respuesta + "<input type='submit' name='datosNuevoAvion' value='Registrar'> ";
			respuesta = respuesta + "</form>";
		}
		
		return respuesta;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String respuesta = "";


		if(request.getParameter("bConsultaTodoVuelo") != null)
		{
			FlightAD flightAD = new FlightAD();
			respuesta = flightAD.checkAllFlights();
			respuestaServer(response, respuesta, "tablaCompleta");
		}

		if(request.getParameter("bConsultaEspecificaVuelo") != null)
		{
			respuesta = setHTML("vueloEspecifico",null);
			respuestaServer(response, respuesta, null);
		}	


				/*if(request.getParameter("buscarVueloEspecifico") != null)
				{
					String estado = "";
					String dia = "";
					String hora = "";
					String fecha = "";
				
					FlightAD flightAD = new FlightAD();

						estado = request.getParameter("estado");
						dia = request.getParameter("dia");
						hora = request.getParameter("hora");
						fecha = ""+dia + " "+ hora+":00:00";

						respuesta = flightAD.search(estado, fecha);
						respuestaServer(response, respuesta, "tablaCompleta");
				}


		if(request.getParameter("bConsultaTodosAeropuertos") != null)
		{
			AirportAD airportAD = new AirportAD();
			String[] data;

			data = airportAD.returnAirports();
			respuesta = setHTML("consultarAeropuertos",data);
			respuestaServer(response, respuesta, null);
		}
				if(request.getParameter("buscarporAeropuerto") != null)
				{
					AirportAD airportAD = new AirportAD();

					String airport = "";
					airport = request.getParameter("airportName");
					respuesta = airportAD.getFlights(airport);
					respuestaServer(response,respuesta,"tablaCompleta");
				}

		
		if(request.getParameter("bNuevoAeropuerto") != null)
		{
			respuesta = setHTML("formularioAeropuertos",null);
			respuestaServer(response, respuesta, null);
		}
				if(request.getParameter("nuevoAeropuerto")!=null)
				{
					NewAirportAD newAirportAD = new NewAirportAD();
					String code = "", name ="", address = "";
					code = request.getParameter("airportCode");
					name = request.getParameter("airportName");
					address = request.getParameter("airportAddress");

					respuesta = newAirportAD.setNewAirport(code, name, address);
					respuestaServer(response,respuesta, null);
				}


		if(request.getParameter("bConsultaPorAerolinea") != null)
		{
			AirlineAD airlineAD = new AirlineAD();
			String[] airlines;
			airlines= airlineAD.obtainAirlines();
			respuesta = setHTML("NombreAerolinea",airlines);
			respuestaServer(response,respuesta,null);
		}
				if(request.getParameter("datosAerolinea") != null)
				{
					AirlineAD airlineAD = new AirlineAD();
					String airlineName = request.getParameter("airlineName");	
					respuesta = airlineAD.obtainFlights(airlineName);

					respuestaServer(response,respuesta,"tablaMedia");
				}

		if(request.getParameter("bNuevaAerolinea") != null)
		{
			NewAirlineAD newAirlineAD = new NewAirlineAD();
			String[] bases;
			bases= newAirlineAD.getAirports();
			respuesta = setHTML("NewAirline",bases);
			respuestaServer(response,respuesta,null);
		}

			if(request.getParameter("datosNuevaAerolinea") != null)
			{
				NewAirlineAD newAirlineAD = new NewAirlineAD();
				String code="", name="", base="";
				code = request.getParameter("airLineCode");
				name = request.getParameter("airLineName");
				base = request.getParameter("airlineBase");

				respuesta = newAirlineAD.setNewAirline(code,name,base);
				respuestaServer(response,respuesta,null);
			}

		}
		if(request.getParameter("bConsultarTodosAviones") != null)
		{
			AirplaneAD airplaneAD = new AirplaneAD();
			respuesta = airplaneAD.searchAll();
			respuestaServer(response, respuesta, "tablaAviones");
		}

		
		if(request.getParameter("bNuevoAvion") != null)
		{
			NewAirplaneAD newAirplaneAD = new NewAirplaneAD();

			String[] data;
			data = newAirplaneAD.getAirlines();
			respuesta = setHTML("nuevoAvion", data);
			respuestaServer(response,respuesta,null);
		}
		
				if(request.getParameter("datosNuevoAvion") != null)
				{
					NewAirplaneAD newAirplaneAD = new NewAirplaneAD();	
					String placas="", aerolinea="", modelo="", horasString="";
					int horas;

					placas = request.getParameter("airplanePLate");
					aerolinea = request.getParameter("airplaneAirline");
					modelo = request.getParameter("airplaneModel");
					horasString = request.getParameter("airplaneHours");
					try{
						horas = Integer.parseInt(horasString);
						respuesta = newAirplaneAD.setNewAirplane(placas, aerolinea,modelo,horas);
					}
					catch(NumberFormatException nfe)
					{
						respuesta = "Las horas deben de ser numericas";
					}

					respuestaServer(response, respuesta, null);
				}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException	
	{
		doGet(request, response);
	}

	private void respuestaServer(HttpServletResponse response, String respuesta, String formato) throws IOException
	{
		PrintWriter out = response.getWriter();
		StringTokenizer st = new StringTokenizer(respuesta, "\n");
		StringTokenizer stColumn;

		String row = "";

		response.setContentType("text/html");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>First Servlet</title>");
		out.println("<meta charset='utf-8'></head>");
		out.println("		<body>");
		out.println("			<h1>Welcome to servlet Airport</h1>");

		if(formato!=null)
		{
			out.println("			<table border = '1px solid'>");
			if(formato.equals("tablaCompleta"))
			{
				out.println("			<tr>");
				out.println("				<td>Flight Number</td>");
				out.println("				<td>Status</td>");
				out.println("				<td>Airplane</td>");
				out.println("				<td>Origin</td>");
				out.println("				<td>Destiny</td>");
				out.println("				<td>Departure</td>");
				out.println("				<td>Arrival</td>");
				out.println("			</tr");
			}

			if(formato.equals("tablaMedia"))
			{
				out.println("			<tr>");
				out.println("				<td>Flight Number</td>");
				out.println("				<td>Status</td>");
				out.println("				<td>Airplane</td>");
				out.println("				<td>Origin</td>");
				out.println("				<td>Destiny</td>");		
				out.println("			</tr");
			}

			if(formato.equals("tablaAviones"))
			{
				out.println("			<tr>");
				out.println("				<td>Plate</td>");
				out.println("				<td>Owner</td>");
				out.println("				<td>Model</td>");
				out.println("				<td>Hours</td>");
				out.println("			</tr");
			}

			while(st.hasMoreTokens())
			{
				row = st.nextToken();
				stColumn = new StringTokenizer(row, "_");
				out.println(			"<tr>");
					while(stColumn.hasMoreTokens())
					{
						out.println("		<td>"+stColumn.nextToken()+"</td>");	
					}
				out.println("			</tr>");
			}
			out.println("			</table>");

		else
		{
			out.println(respuesta);
		}
		out.println("		</body>");
		out.println("</html>");
	}
}*/