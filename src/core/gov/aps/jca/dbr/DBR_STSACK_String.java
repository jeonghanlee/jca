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
 * $Id: DBR_STSACK_String.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

import java.io.*;

public class DBR_STSACK_String extends DBR_STS_String implements ACK {
  public static final DBRType TYPE= new DBRType("DBR_STSACK_STRING", 37, DBR_STSACK_String.class);
  
  
  protected int _ackt;

  protected int _acks;

  public DBR_STSACK_String() {

    this( 1 );

  }

  public DBR_STSACK_String( int count ) {

    this( new String[count] );

  }

  public DBR_STSACK_String( String[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
  }



  public int getAckS() {
    return _acks;
  }

  public void setAckS( int acks ) {
    _acks=acks;
  }

  public int getAckT() {
    return _ackt;
  }

  public void setAckT( int ackt ) {
    _ackt=ackt;
  }

  public void printInfo( PrintStream out ) {

    super.printInfo( out );

    out.println( "ACKS     : "+getAckS() );

    out.println( "ACKT     : "+getAckT() );

  }

}
