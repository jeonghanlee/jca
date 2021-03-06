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
 * $Id: JNIContextMessageCallback.java,v 1.1.1.1 2004/02/16 15:59:06 boucher Exp $
 *
 * Modification Log:
 * 01. 05/07/2003  erb  initial development
 *
 */

package gov.aps.jca.jni;

import java.util.*;
import gov.aps.jca.*;
import gov.aps.jca.event.*;

class JNIContextMessageCallback extends JNICallback {
  protected JNIContext _source;
  JNIContextMessageCallback( JNIContext source, EventDispatcher dispatcher, List listeners ) {
    super( dispatcher, listeners );
    _source=source;
  }

  public void fire( String msg ) {
    dispatch( new ContextMessageEvent( _source, msg ) );
  }

}
