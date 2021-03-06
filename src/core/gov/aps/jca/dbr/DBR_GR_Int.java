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
 * $Id: DBR_GR_Int.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

import java.io.*;

public class DBR_GR_Int extends DBR_STS_Int implements GR {
  static public final DBRType TYPE= new DBRType("DBR_GR_INT", 26, DBR_GR_Int.class);
  
  
  protected String _unit=EMPTYUNIT;

  protected Integer _udl=ZEROI;

  protected Integer _ldl=ZEROI;

  protected Integer _ual=ZEROI;

  protected Integer _uwl=ZEROI;

  protected Integer _lwl=ZEROI;

  protected Integer _lal=ZEROI;

  public DBR_GR_Int() {

    this( 1 );

  }

  public DBR_GR_Int( int count ) {

    this( new int[count] );

  }

  public DBR_GR_Int( int[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
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
    _udl=new Integer( limit.intValue() );
  }

  public Number getLowerDispLimit() {
    return _ldl;
  }

  public void setLowerDispLimit( Number limit ) {
    _ldl=new Integer( limit.intValue() );
  }

  public Number getUpperAlarmLimit() {
    return _ual;
  }

  public void setUpperAlarmLimit( Number limit ) {
    _ual=new Integer( limit.intValue() );
  }

  public Number getUpperWarningLimit() {
    return _uwl;
  }

  public void setUpperWarningLimit( Number limit ) {
    _uwl=new Integer( limit.intValue() );
  }

  public Number getLowerWarningLimit() {
    return _lwl;
  }

  public void setLowerWarningLimit( Number limit ) {
    _lwl=new Integer( limit.intValue() );
  }

  public Number getLowerAlarmLimit() {
    return _lal;
  }

  public void setLowerAlarmLimit( Number limit ) {
    _lal=new Integer( limit.intValue() );
  }

  public void printInfo( PrintStream out ) {

    super.printInfo( out );

    out.println( "UNITS    : "+getUnits() );

    out.println( "UDL      : "+getUpperDispLimit() );

    out.println( "LDL      : "+getLowerDispLimit() );

    out.println( "UAL      : "+getUpperAlarmLimit() );

    out.println( "UWL      : "+getUpperWarningLimit() );

    out.println( "LWL      : "+getLowerWarningLimit() );

    out.println( "LAL      : "+getLowerAlarmLimit() );

  }

}
