package database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {
	
	private Connection 	connection = null;
	private Statement  	statement  = null;

	private String 	 	table  	   = null;
	private String[] 	fields     = null;
	private String[] 	values     = null;
	private String 	 	keyField   = null;
	
	public DBQuery() {
		this.connection = new DBConnection().getConnection();	
	}

	public DBQuery(Connection connection) {
		this.connection = connection;	
	}
	
	public DBQuery( String table, String[] fields, String keyField ) {
		this.connection = new DBConnection().getConnection();
		this.setTable(table);
		this.setFields(fields);
		this.setKeyField(keyField);
	}

	public DBQuery( Connection connection, String table, String[] fields, String keyField ) {
		this.connection = connection;
		this.setTable(table);
		this.setFields(fields);
		this.setKeyField(keyField);
	}
	
	
	public Connection getConnection() {
		return connection;
	}
	
	public ResultSet executeQuery(String sql) {
		
		ResultSet rs = null;
		try {
			this.statement 	= (Statement) this.connection.createStatement();
			rs = this.statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return (rs);
	}
	
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			this.statement 	= (Statement) this.connection.createStatement();
			result = this.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return (result);
	}
		
	public int insert(String[] values) {
		// evitar sql injection 
		for ( int i=0; i<values.length; i++ ) {
			values[i] = values[i].replace("'", "`");
		}
		
		String sql = "";
		
		String sqlFields = "";
		String sqlValues = "";
		
		for ( int i=0; i<fields.length; i++ ) {
			String sep = ((fields[i] == fields[fields.length-1])?"":",");
			sqlFields +=  fields[i] + sep;
			sqlValues +=  "'"+ values[i] +"'"+ sep;
		}
		
		sql += 
		"INSERT INTO " +  this.getTable() + "( " + sqlFields + " ) VALUES ( "+ sqlValues + " );";
		
		System.out.println(sql);
		return (this.executeUpdate(sql));
	}
	
	public ResultSet select() {
		return ( select(""));
	}
	
	public ResultSet select( String where ) {
		
		String sql = "";
		String sqlFields = "";
		
		for ( int i=0; i<fields.length; i++ ) {
			String sep = ((fields[i] == fields[fields.length-1])?"":", ");
			sqlFields +=  fields[i] + sep;
			}
		
		sql += "SELECT " + sqlFields + " FROM "+ this.getTable(); 
		sql += ((where != "")? " WHERE "+ where : "");
		System.out.println(sql);
		return ( this.executeQuery(sql));
	}

	public int delete(String keyValue) {
		String sql = "";
		
		sql += "DELETE FROM " + this.getTable() ;
		if (keyFieldPos() > -1)
			sql += " \nWHERE " + this.getKeyField() + " = " + "'" + keyValue + "'" ;
		else 
			return(0); // sql += " \nWHERE 1<>1";
		System.out.println(sql);
		return ( this.executeUpdate(sql) );
	}
	
	public int delete(int keyValue) {
		return ( this.delete( new Integer(keyValue).toString() ) );
	}
	
	private int keyFieldPos() {
		for (int i=0; i< fields.length; i++) {
			if (fields[i]==keyField) {
				return(i);
			}
		}
		return(-1);
	}
	
	public int update(String[] values) {
		String sql = "";
		
		sql += "UPDATE " + this.getTable() + " SET ";
		
		for ( int i=0; i<fields.length; i++ ) {
			String sep = ((fields[i] == fields[fields.length-1])?"":",");
			sql +=  "\n\t"+fields[i] + "=" + "'" + values[i] +"'"+ sep;
		}
		if (keyFieldPos() > -1)
			sql += " \nWHERE " + this.getKeyField() + " = " + "'" + values[keyFieldPos()] + "'" ;
		else 
			return(0); // sql += " \nWHERE 1<>1";
		System.out.println(sql);
		return ( this.executeUpdate(sql) );
	}
	
	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public String getKeyField() {
		return keyField;
	}

	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
}
