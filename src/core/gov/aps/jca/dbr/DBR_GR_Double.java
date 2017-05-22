/**********************************************************************
 *
 *      Original Author: Eric Boucher
 *      Date:            05/05/2003
 *
 *      Experimental Physics and Industrial Control System (EPICS)
 *
 *      Copyright 1991, the University of Chicago Board of Governors.
 *
 *      This software was produced under  U.S. Government contract
 *      W-31-109-ENG-38 at Argonne National Laboratory.
 *
 *      Beamline Controls & Data Acquisition Group
 *      Experimental Facilities Division
 *      Advanced Photon Source
 *      Argonne National Laboratory
 *
 *
 * $Id: DBR_GR_Double.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

import java.io.*;

public class DBR_GR_Double extends DBR_STS_Double implements GR, PRECISION {
  static public final DBRType TYPE= new DBRType("DBR_GR_DOUBLE", 27, DBR_GR_Double.class);
  
  
  protected String _unit=EMPTYUNIT;

  protected Double _udl=ZEROD;

  protected Double _ldl=ZEROD;

  protected Double _ual=ZEROD;

  protected Double _uwl=ZEROD;

  protected Double _lwl=ZEROD;

  protected Double _lal=ZEROD;

  protected short _precision;

  public DBR_GR_Double() {

    this( 1 );

  }

  public DBR_GR_Double( int count ) {

    this( new double[count] );

  }

  public DBR_GR_Double( double[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
  }



  public short getPrecision() {
    return _precision;
  }

  public void setPrecision( short prec ) {
    _precision=prec;
  }

  public String getUnits() {
    return _unit;
  }

  public void setUnits( String unit ) {
    _unit=unit;
  }

  public Number getUpperDispLimit() {
    return _udl;
  }

  public void setUpperDispLimit( Number limit ) {
    _udl=new Double( limit.doubleValue() );
  }

  public Number getLowerDispLimit() {
    return _ldl;
  }

  public void setLowerDispLimit( Number limit ) {
    _ldl=new Double( limit.doubleValue() );
  }

  public Number getUpperAlarmLimit() {
    return _ual;
  }

  public void setUpperAlarmLimit( Number limit ) {
    _ual=new Double( limit.doubleValue() );
  }

  public Number getUpperWarningLimit() {
    return _uwl;
  }

  public void setUpperWarningLimit( Number limit ) {
    _uwl=new Double( limit.doubleValue() );
  }

  public Number getLowerWarningLimit() {
    return _lwl;
  }

  public void setLowerWarningLimit( Number limit ) {
    _lwl=new Double( limit.doubleValue() );
  }

  public Number getLowerAlarmLimit() {
    return _lal;
  }

  public void setLowerAlarmLimit( Number limit ) {
    _lal=new Double( limit.doubleValue() );
  }

  public void printInfo( PrintStream out ) {

    super.printInfo( out );

    out.println( "PRECISION: "+getPrecision() );

    out.println( "UNITS    : "+getUnits() );

    out.println( "UDL      : "+getUpperDispLimit() );

    out.println( "LDL      : "+getLowerDispLimit() );

    out.println( "UAL      : "+getUpperAlarmLimit() );

    out.println( "UWL      : "+getUpperWarningLimit() );

    out.println( "LWL      : "+getLowerWarningLimit() );

    out.println( "LAL      : "+getLowerAlarmLimit() );

  }

}
