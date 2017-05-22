package gov.aps.jca.jni;

/**
 * <p>Title: JCA2</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author Erix Boucher
 * @version 1.0
 */

import java.text.*;

public class JNITargetArch {
  static public String getTargetArch() {

    String osname=System.getProperty( "os.name", "" );
    float osversion=0;

    try {
      osversion=NumberFormat.getInstance().parse( System.getProperty(
        "os.version" , "" ) ).floatValue();
    } catch( ParseException pe ) {
    }
    String osarch=System.getProperty( "os.arch", "" );

    if( osarch.equals( "i386" )||osarch.equals( "i486" )||osarch.equals( "i586" ) ) {
      osarch="x86";

    }
    if( osname.equals( "SunOS" ) ) {
      if( osversion>=5 ) {
        if( osarch.equals( "sparc" ) ) {
          return "solaris-sparc";
        } else if( osarch.equals( "x86" ) ) {
          return "solaris-x86";
        }
      }
    } else if( osname.equals( "Linux" ) ) {
      if( osarch.equals( "x86" ) ) {
        return "linux-x86";
      }
    } else if( osname.startsWith( "Win" ) ) {
      return "win32-x86";
    }
    return "unknown";
  }
}