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
 * $Id: DBR_LABELS_Enum.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

import java.io.*;

public class DBR_LABELS_Enum extends DBR_STS_Enum implements LABELS {
  static public final DBRType TYPE= new DBRType("DBR_LABELS_ENUM", 24, DBR_LABELS_Enum.class);
  
  
  protected String[] _strs;

  public DBR_LABELS_Enum() {

    this( 1 );

  }

  public DBR_LABELS_Enum( int count ) {

    this( new short[count] );

  }

  public DBR_LABELS_Enum( short[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
  }



  public String[] getLabels() {
    return _strs;
  }

  public void setLabels( String[] strs ) {
    _strs=strs;
  }

  public void printInfo( PrintStream out ) {

    super.printInfo( out );

    out.print( "LABELS   : " );

    printValue( getLabels(), out );

    out.println();

  }

}
