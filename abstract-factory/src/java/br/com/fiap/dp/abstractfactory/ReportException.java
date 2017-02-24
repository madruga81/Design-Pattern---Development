package br.com.fiap.dp.abstractfactory ;

public class ReportException extends RuntimeException
{
	public ReportException( )
	{
		super( ) ;
	}

	public ReportException( String message, Throwable cause )
	{
		super( message, cause ) ;
	}

	public ReportException( String message )
	{
		super( message ) ;
	}

	public ReportException( Throwable cause )
	{
		super( cause ) ;
	}
}
