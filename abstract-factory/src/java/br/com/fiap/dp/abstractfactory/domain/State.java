package br.com.fiap.dp.abstractfactory.domain ;

public class State
{
	private String name ;
	private Country country ;

	public State( String name )
	{
		super( ) ;
		this.name = name ;
	}

	public State( String name, Country country )
	{
		super( ) ;
		this.name = name ;
		this.country = country ;
	}

	public Country getCountry( )
	{
		return country ;
	}

	public void setCountry( Country country )
	{
		this.country = country ;
	}

	public String getName( )
	{
		return name ;
	}

	public void setName( String name )
	{
		this.name = name ;
	}

	public boolean equals( Object obj )
	{
		if (!( obj instanceof State ))
		{
			return false ;
		}
		State other = ( State ) obj ;
		return name.equals( other.getName( ) ) ;
	}

	public int hashCode( )
	{
		return name.hashCode( ) ;
	}

	public String toString( )
	{
		return name + ", " + country ;
	}
}
