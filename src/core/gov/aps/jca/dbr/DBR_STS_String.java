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
 * $Id: DBR_STS_String.java,v 1.2 2004/02/20 11:11:03 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

import java.io.*;

public class DBR_STS_String extends DBR_String implements STS {
  static public final DBRType TYPE= new DBRType("DBR_STS_STRING", 7, DBR_STS_String.class);
  
  protected Status _status;

  protected Severity _severity;

  public DBR_STS_String() {

    this( 1 );

  }

  public DBR_STS_String( int count ) {

    this( new String[count] );

  }

  public DBR_STS_String( String[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
  }



  public Status getStatus() {
    return _status;
  }

  public void setStatus( int status ) {
    setStatus(Status.forValue(status));
  }

  public void setStatus(Status status) {
    if(status==null) throw new IllegalArgumentException("Illegal status: null");
    _status=status;
  }
  
  
  public Severity getSeverity() {
    return _severity;
  }

  public void setSeverity( int severity ) {
    setSeverity(Severity.forValue(severity));
  }

  public void setSeverity(Severity severity) {
    if(severity==null) throw new IllegalArgumentException("Illegal severity: null");
    _severity=severity;
  }

  public void printInfo( PrintStream out ) {

    super.printInfo( out );

    out.println( "STATUS   : "+getStatus().getName() );
    out.println( "SEVERITY : "+getSeverity().getName() );

  }

}
