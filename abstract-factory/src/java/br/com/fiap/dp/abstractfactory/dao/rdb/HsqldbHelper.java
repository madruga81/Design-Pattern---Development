package br.com.fiap.dp.abstractfactory.dao.rdb ;

import javax.sql.DataSource ;

import org.apache.commons.dbcp.BasicDataSource ;

class HsqldbHelper
{
	private static final String DRIVER_CLASSNAME = "org.hsqldb.jdbcDriver" ;
	private static final String CONNECT_URL = "jdbc:hsqldb:hsql://localhost/dp" ;
	private static final String USERNAME = "sa" ;
	private static final String PASSWORD = "" ;

	private static DataSource dataSource = null ;

	private HsqldbHelper( )
	{
	}

	public static DataSource getDataSource( )
	{
		if (dataSource != null)
		{
			return dataSource ;
		}

		dataSource = createDataSource( ) ;
		return dataSource ;
	}

	private static BasicDataSource createDataSource( )
	{
		BasicDataSource ds = new BasicDataSource( ) ;
		ds.setDriverClassName( DRIVER_CLASSNAME ) ;
		ds.setUrl( CONNECT_URL ) ;
		ds.setUsername( USERNAME ) ;
		ds.setPassword( PASSWORD ) ;
		return ds ;
	}
}
