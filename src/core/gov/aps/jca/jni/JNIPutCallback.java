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
 * $Id: JNIPutCallback.java,v 1.1.1.1 2004/02/16 15:59:06 boucher Exp $
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


class JNIPutCallback extends JNICallback {
  protected JNIChannel _source;

  JNIPutCallback(JNIChannel source, EventDispatcher dispatcher, PutListener listener) {
    super(dispatcher, listener);
    _source=source;
  }

  public void fire(int type, int count, int dbrid, int status) {
    dispatch(new PutEvent(_source, DBRType.forValue(type),count, CAStatus.forValue(status)));
  }
}

