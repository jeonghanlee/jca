
package gov.aps.jca.event;

import java.util.*;

import gov.aps.jca.*;
import gov.aps.jca.configuration.*;

/**
 * This EventDispatcher uses an internal thread to dispatch events.
 *
 * @author Eric Boucher
 * @version 1.0
 */
public class QueuedEventDispatcher extends AbstractEventDispatcher implements Runnable, Configurable {
  static protected int _count=0;
  
  boolean _killed=false;
  int _priority=Thread.NORM_PRIORITY;
  Thread _dispatcherThread;
  
  public QueuedEventDispatcher() {
    _dispatcherThread=new Thread( this, "QueuedEventDispatcher-"+(_count++));
    _dispatcherThread.setDaemon( true );
    setPriority( JCALibrary.getInstance().getPropertyAsInt( QueuedEventDispatcher.class.getName()+".priority", _priority ) );
    
    _dispatcherThread.start();
  }
  
  abstract class Event {
    CAEvent _ev;
    List _listeners;
    Event( CAEvent ev, List listeners ) {
      _ev=ev;
      _listeners=listeners;
    }
    
    abstract public void dispatch();
  }
  
  LinkedList _queue=new LinkedList();
  
  protected void queueEvent(Event ev) {
    _queue.addLast(ev);
  }
  
  public void run() {
    while( !_killed ) {
      Event ev;
      try {
          if( !_queue.isEmpty() ) {
            ev=( Event )_queue.removeFirst();
            ev.dispatch();
            Thread.yield();
          } else {
            Thread.sleep(10);
          }
      } catch(Exception ex) {
        ex.printStackTrace();
      }
    }
  }
  
  public void dispose() {
    _killed=true;
    _dispatcherThread=null;
  }
  
  public void configure(Configuration conf) throws ConfigurationException {
    int priority= getPriority();
    try {
      priority= conf.getChild("priority").getValueAsInteger();
    } catch(Exception ex) {
      priority= conf.getAttributeAsInteger("priority", priority);
    }
    setPriority(priority);
  }
  
  public int getPriority() {
    return _priority;
  }
  
  public void setPriority( int priority ) {
    if( _killed ) {
      throw new IllegalStateException( "Dispatcher thread has been killed" );
    }
    _priority=priority;
    _dispatcherThread.setPriority( _priority );
  }
  
  public void dispatch( ContextMessageEvent ev, List listeners ) {
    if( _killed ) {
      throw new IllegalStateException( "Dispatcher thread has been killed" );
    }
    
    queueEvent( new Event( ev, listeners ) {
      public void dispatch() {
        Object[] list=_listeners.toArray( new Object[0] );
        for( int t=0; t<list.length; ++t ) {
          if( list[t] instanceof ContextMessageListener ) {
            ( ( ContextMessageListener )list[t] ).contextMessage( ( ContextMessageEvent )_ev );
          }
        }
      }
    } );
  }
  
  public void dispatch( ContextExceptionEvent ev, List listeners ) {
    if( _killed ) {
      throw new IllegalStateException( "Dispatcher thread has been killed" );
    }
    queueEvent( new Event( ev, listeners ) {
      public void dispatch() {
        Object[] list=_listeners.toArray( new Object[0] );
        for( int t=0; t<list.length; ++t ) {
          if( list[t] instanceof ContextExceptionListener ) {
            ( ( ContextExceptionListener )list[t] ).contextException( ( ContextExceptionEvent )_ev );
          }
        }
      }
    } );
  }
  
  public void dispatch( ConnectionEvent ev, List listeners ) {
    if( _killed ) {
      throw new IllegalStateException( "Dispatcher thread has been killed" );
    }
    
    queueEvent( new Event( ev, listeners ) {
      public void dispatch() {
        Object[] list=_listeners.toArray( new Object[0] );
        for( int t=0; t<list.length; ++t ) {
          if( list[t] instanceof ConnectionListener ) {
            ( ( ConnectionListener )list[t] ).connectionChanged( ( ConnectionEvent )_ev );
          }
        }
      }
    } );
  }
  
  public void dispatch( AccessRightsEvent ev, List listeners ) {
    if( _killed ) {
      throw new IllegalStateException( "Dispatcher thread has been killed" );
    }
    queueEvent( new Event( ev, listeners ) {
      public void dispatch() {
        Object[] list=_listeners.toArray( new Object[0] );
        for( int t=0; t<list.length; ++t ) {
          if( list[t] instanceof AccessRightsListener ) {
            ( ( AccessRightsListener )list[t] ).accessRightsChanged( ( AccessRightsEvent )_ev );
          }
        }
      }
    } );
  }
  
  public void dispatch( MonitorEvent ev, List listeners ) {
    if( _killed ) {
      throw new IllegalStateException( "Dispatcher thread has been killed" );
    }
    queueEvent( new Event( ev, listeners ) {
      public void dispatch() {
        Object[] list=_listeners.toArray( new Object[0] );
        for( int t=0; t<list.length; ++t ) {
          if( list[t] instanceof MonitorListener ) {
            ( ( MonitorListener )list[t] ).monitorChanged( ( MonitorEvent )_ev );
          }
        }
      }
    } );
  }
  
  public void dispatch( GetEvent ev, List listeners ) {
    if( _killed ) {
      throw new IllegalStateException( "Dispatcher thread has been killed" );
    }
    queueEvent( new Event( ev, listeners ) {
      public void dispatch() {
        Object[] list=_listeners.toArray( new Object[0] );
        for( int t=0; t<list.length; ++t ) {
          if( list[t] instanceof GetListener ) {
            ( ( GetListener )list[t] ).getCompleted( ( GetEvent )_ev );
          }
        }
      }
    } );
    
  }
  
  public void dispatch( PutEvent ev, List listeners ) {
    if( _killed ) {
      throw new IllegalStateException( "Dispatcher thread has been killed" );
    }
    queueEvent( new Event( ev, listeners ) {
      public void dispatch() {
        Object[] list=_listeners.toArray( new Object[0] );
        for( int t=0; t<list.length; ++t ) {
          if( list[t] instanceof PutListener ) {
            ( ( PutListener )list[t] ).putCompleted( ( PutEvent )_ev );
          }
        }
      }
    } );
  }
  
}
