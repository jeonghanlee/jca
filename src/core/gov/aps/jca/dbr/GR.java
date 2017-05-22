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
 * $Id: GR.java,v 1.1.1.1 2004/02/16 15:59:05 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */





package gov.aps.jca.dbr;



public interface GR extends STS {
  static final public String  EMPTYUNIT="";
  static final public Byte    ZEROB= new Byte((byte)0);
  static final public Short   ZEROS= new Short((short)0);
  static final public Integer ZEROI= new Integer((int)0);
  static final public Float   ZEROF= new Float(0.0);
  static final public Double  ZEROD= new Double(0.0);


  public String getUnits();
  public void   setUnits(String unit);

  public Number getUpperDispLimit();
  public void   setUpperDispLimit(Number limit);
  public Number getLowerDispLimit();
  public void   setLowerDispLimit(Number limit);

  public Number getUpperAlarmLimit();
  public void   setUpperAlarmLimit(Number limit);
  public Number getUpperWarningLimit();
  public void   setUpperWarningLimit(Number limit);
  public Number getLowerWarningLimit();
  public void   setLowerWarningLimit(Number limit);
  public Number getLowerAlarmLimit();
  public void   setLowerAlarmLimit(Number limit);
}

