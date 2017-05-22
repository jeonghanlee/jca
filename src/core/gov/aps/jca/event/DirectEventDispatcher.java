

package gov.aps.jca.event;

import java.util.*;

import gov.aps.jca.*;


/**
 * This EventDispatcher will forward all events directly to the listeners.
 * The listeners will be called by the underlying JCA callback's thread.
 * JCA methods call (Context, Channel, Monitor) are not allowed within the
 * listener's callback methods and could result in an unpredictable behavior.
 * Listener's method should delegate all JCA calls to another thread.
 *
 *
 * @author Eric Boucher
 * @version 1.0
 */
public class DirectEventDispatcher extends AbstractEventDispatcher {

  public void dispatch( ContextMessageEvent ev, List listeners ) {
    Object[] list= listeners.toArray(new Object[0]);

    for(int t=0; t<list.length; ++t) {
      if(list[t] instanceof ContextMessageListener)  ((ContextMessageListener)list[t]).contextMessage(ev);
    }
  }

  public void dispatch( ContextExceptionEvent ev, List listeners ) {
    Object[] list= listeners.toArray(new Object[0]);

    for(int t=0; t<list.length; ++t) {
      if(list[t] instanceof ContextExceptionListener)  ((ContextExceptionListener)list[t]).contextException(ev);
    }
  }

  public void dispatch( ConnectionEvent ev, List listeners ) {
    Object[] list= listeners.toArray(new Object[0]);

    for(int t=0; t<list.length; ++t) {
      if(list[t] instanceof ConnectionListener)  ((ConnectionListener)list[t]).connectionChanged(ev);
    }
  }

  public void dispatch( AccessRightsEvent ev, List listeners ) {
    Object[] list= listeners.toArray(new Object[0]);

    for(int t=0; t<list.length; ++t) {
      if(list[t] instanceof AccessRightsListener)  ((AccessRightsListener)list[t]).accessRightsChanged(ev);
    }
  }

  public void dispatch( MonitorEvent ev, List listeners ) {
    Object[] list= listeners.toArray(new Object[0]);

    for(int t=0; t<list.length; ++t) {
      if(list[t] instanceof MonitorListener)  ((MonitorListener)list[t]).monitorChanged(ev);
    }
  }

  public void dispatch( GetEvent ev, List listeners ) {
    Object[] list= listeners.toArray(new Object[0]);

    for(int t=0; t<list.length; ++t) {
      if(list[t] instanceof GetListener)  ((GetListener)list[t]).getCompleted(ev);
    }
  }

  public void dispatch( PutEvent ev, List listeners ) {
    Object[] list= listeners.toArray(new Object[0]);

    for(int t=0; t<list.length; ++t) {
      if(list[t] instanceof PutListener)  ((PutListener)list[t]).putCompleted(ev);
    }
  }
}


