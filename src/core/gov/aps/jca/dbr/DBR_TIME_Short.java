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
 * $Id: DBR_TIME_Short.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

import java.io.*;

public class DBR_TIME_Short extends DBR_STS_Short implements TIME {
  static public final DBRType TYPE= new DBRType("DBR_TIME_SHORT", 15, DBR_TIME_Short.class);
  
  protected TimeStamp _stamp;

  public DBR_TIME_Short() {

    this( 1 );

  }

  public DBR_TIME_Short( int count ) {

    this( new short[count] );

  }

  public DBR_TIME_Short( short[] value ) {
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
