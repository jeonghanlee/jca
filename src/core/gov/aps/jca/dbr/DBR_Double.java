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
 * $Id: DBR_Double.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

public class DBR_Double extends DBR implements DOUBLE {
  static public final DBRType TYPE= new DBRType("DBR_DOUBLE", 6,  DBR_Double.class);
  
  public DBR_Double() {

    this( 1 );

  }

  public DBR_Double( int count ) {

    this( new double[count] );

  }

  public DBR_Double( double[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
  }


  public double[] getDoubleValue() {
    return( double[] )getValue();
  }

}
