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
 * $Id: DBR_PutAckS.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.dbr;

public class DBR_PutAckS extends DBR implements SHORT {
  static public final DBRType TYPE= new DBRType("DBR_PUT_ACKS",  36, DBR_PutAckS.class);
  
  
  public DBR_PutAckS() {

    this( 1 );

  }

  public DBR_PutAckS( int count ) {

    this( new short[count] );

  }

  public DBR_PutAckS( short[] value ) {
    super( value );
  }

  public DBRType getType() {
    return TYPE;
  }



  public short[] getShortValue() {
    return( short[] )getValue();
  }

}
