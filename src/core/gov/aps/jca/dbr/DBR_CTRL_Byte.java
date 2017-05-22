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
 * $Id: DBR_CTRL_Byte.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

import java.io.*;

public class DBR_CTRL_Byte extends DBR_GR_Byte implements CTRL {
  public static final DBRType TYPE= new DBRType("DBR_CTRL_BYTE", 32, DBR_CTRL_Byte.class);
  
  protected Byte _ucl=ZEROB;

  protected Byte _lcl=ZEROB;

  public DBR_CTRL_Byte() {

    this( 1 );

  }

  public DBR_CTRL_Byte( int count ) {

    this( new byte[count] );

  }

  public DBR_CTRL_Byte( byte[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
  }

  public Number getUpperCtrlLimit() {
    return _ucl;
  }

  public void setUpperCtrlLimit( Number limit ) {
    _ucl=new Byte( limit.byteValue() );
  }

  public Number getLowerCtrlLimit() {
    return _lcl;
  }

  public void setLowerCtrlLimit( Number limit ) {
    _lcl=new Byte( limit.byteValue() );
  }

  public void printInfo( PrintStream out ) {

    super.printInfo( out );

    out.println( "UCL      : "+getUpperCtrlLimit() );

    out.println( "LCL      : "+getLowerCtrlLimit() );

  }

}
