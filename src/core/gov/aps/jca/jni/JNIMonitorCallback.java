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
 * $Id: JNIMonitorCallback.java,v 1.1.1.1 2004/02/16 15:59:06 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */


package gov.aps.jca.jni;

import gov.aps.jca.*;
import gov.aps.jca.event.*;
import gov.aps.jca.dbr.*;

import java.util.*;


class JNIMonitorCallback extends JNICallback {
  protected JNIChannel _source;

  JNIMonitorCallback(JNIChannel source, EventDispatcher dispatcher, List listeners) {
    super(dispatcher,listeners);
    _source=source;
  }

  public void fire(int type, int count, int dbrid, int status) {
    DBR dbr= DBRFactory.create(type,count);
    JNI.dbr_update(dbr,dbrid);
    dispatch(new MonitorEvent(_source, dbr, CAStatus.forValue(status)));
  }
}



