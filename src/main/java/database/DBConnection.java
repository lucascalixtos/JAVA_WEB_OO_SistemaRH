package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private String schema 	= "";
	private String host 	= "";
	private String port 	= "";
	private String user 	= "";
	private String password = "";
	
	private Connection  connection  = null;
	public  boolean 	isConnected = false;
	
	public DBConnection() {
		this.setSchema	("rh");
		this.setHost	("localhost");
		this.setPort	("3306");
		this.setUser	("root");
		this.setPassword("");
		this.mySqlConnect();
	}	
	
	public DBConnection(Connection connection) {
		this.connection = connection;
	}
	public DBConnection(String schema, String host, String port, String user, String password) {
		this.setSchema(schema);
		this.setHost(host);
		this.setPort(port);
		this.setUser(user);
		this.setPassword(password);
		this.mySqlConnect();
	}
	
	public void mySqlConnect(){
		 String url = 		
		    "jdbc:mysql://"	+
			this.getHost() 	+ ":" + 
			this.getPort() 	+ "/" + 
			this.getSchema()+
			"?user=" 	 	+ this.getUser() + 
			"&password=" 	+ this.getPassword() + 
			"&useTimezone=true&serverTimezone=UTC";
		 
		    try {
		    	Class.forName("com.mysql.jdbc.Driver").newInstance();
		    	isConnected = true;
		    	this.setConnection(DriverManager.getConnection(url)); 
		    	System.out.println("Banco de dados Conectado!");
		    } catch( SQLException e ) {
		    	e.printStackTrace();
		    	System.out.println(e.getMessage());
		    	isConnected = false;
		    } catch ( ClassNotFoundException e ) {
		    	e.printStackTrace();
		    	System.out.println(e.getMessage());
		    	isConnected = false;
		    } catch ( InstantiationException e ) {
		    	e.printStackTrace();
		    	System.out.println(e.getMessage());
		    	isConnected = false;
		    } catch ( IllegalAccessException e ) {
		    	e.printStackTrace();
		    	System.out.println(e.getMessage());
		    	isConnected = false;
		    } catch ( Exception e ) {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				System.exit(0);
			} finally {
				
			}
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
