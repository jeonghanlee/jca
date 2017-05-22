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
 * $Id: DBR_TIME_Float.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

import java.io.*;

public class DBR_TIME_Float extends DBR_STS_Float implements TIME {
  static public final DBRType TYPE= new DBRType("DBR_TIME_FLOAT", 16, DBR_TIME_Float.class);
  
  protected TimeStamp _stamp;

  public DBR_TIME_Float() {

    this( 1 );

  }

  public DBR_TIME_Float( int count ) {

    this( new float[count] );

  }

  public DBR_TIME_Float( float[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
  }



  public TimeStamp getTimeStamp() {
    return _stamp;
  }

  public void setTimeStamp( TimeStamp stamp ) {
    _stamp=stamp;
  }

  public void printInfo( PrintStream out ) {

    super.printInfo( out );

    out.println( "TIME     : "+getTimeStamp().toMMDDYY() );

  }

}
