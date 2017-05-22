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
 * $Id: DBR_String.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

public class DBR_String extends DBR implements STRING {
  static public final DBRType TYPE= new DBRType("DBR_STRING", 0, DBR_String.class);
  
  public DBR_String() {

    this( 1 );

  }

  public DBR_String( int count ) {

    this( new String[count] );

  }

  public DBR_String( byte[] value ) {

    this( new String( value ) );

  }

  public DBR_String( String value ) {

    this( new String[] {value} );

  }

  public DBR_String( char[] value ) {

    this( new String( value ) );

  }

  public DBR_String( String[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
  }



  public String[] getStringValue() {
    return( String[] )getValue();
  }

}
