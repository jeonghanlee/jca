

package gov.aps.jca.dbr;

import gov.aps.jca.*;


public class DBRType extends ValuedEnum {
  
  static private java.util.Map _map= new java.util.HashMap();

  static public final DBRType UNKNOWN= DBR.TYPE;
  static public final DBRType STRING= DBR_String.TYPE;
  static public final DBRType SHORT= DBR_Short.TYPE;
  static public final DBRType FLOAT= DBR_Float.TYPE;
  static public final DBRType ENUM= DBR_Enum.TYPE;
  static public final DBRType BYTE= DBR_Byte.TYPE;
  static public final DBRType INT= DBR_Int.TYPE;
  static public final DBRType DOUBLE= DBR_Double.TYPE;
  static public final DBRType STS_STRING= DBR_STS_String.TYPE;
  static public final DBRType STS_SHORT= DBR_STS_Short.TYPE;
  static public final DBRType STS_FLOAT= DBR_STS_Float.TYPE;
  static public final DBRType STS_ENUM= DBR_STS_Enum.TYPE;
  static public final DBRType STS_BYTE= DBR_STS_Byte.TYPE;
  static public final DBRType STS_INT= DBR_STS_Int.TYPE;
  static public final DBRType STS_DOUBLE= DBR_STS_Double.TYPE;
  static public final DBRType TIME_STRING= DBR_TIME_String.TYPE;
  static public final DBRType TIME_SHORT= DBR_TIME_Short.TYPE;
  static public final DBRType TIME_FLOAT= DBR_TIME_Float.TYPE;
  static public final DBRType TIME_ENUM= DBR_TIME_Enum.TYPE;
  static public final DBRType TIME_BYTE= DBR_TIME_Byte.TYPE;
  static public final DBRType TIME_INT= DBR_TIME_Int.TYPE;
  static public final DBRType TIME_DOUBLE= DBR_TIME_Double.TYPE;
  static public final DBRType GR_SHORT= DBR_GR_Short.TYPE;
  static public final DBRType GR_FLOAT= DBR_GR_Float.TYPE;
  static public final DBRType LABELS_ENUM= DBR_LABELS_Enum.TYPE;
  static public final DBRType GR_BYTE= DBR_GR_Byte.TYPE;
  static public final DBRType GR_INT= DBR_GR_Int.TYPE;
  static public final DBRType GR_DOUBLE= DBR_GR_Double.TYPE;
  static public final DBRType CTRL_SHORT= DBR_CTRL_Short.TYPE;
  static public final DBRType CTRL_FLOAT= DBR_CTRL_Float.TYPE;
  static public final DBRType CTRL_BYTE= DBR_CTRL_Byte.TYPE;
  static public final DBRType CTRL_INT= DBR_CTRL_Int.TYPE;
  static public final DBRType CTRL_DOUBLE= DBR_CTRL_Double.TYPE;
  static public final DBRType PUT_ACKT= DBR_PutAckT.TYPE;
  static public final DBRType PUT_ACKS= DBR_PutAckS.TYPE;
  static public final DBRType STSACK_STRING= DBR_STSACK_String.TYPE;
  
  int _value;
  Class _class;

  DBRType( final String name, final int value, final Class clazz ) {
    super(name, value, _map);
    _class=clazz;
  }
  
  public final boolean isBYTE() {
    return BYTE.class.isAssignableFrom(_class);
  }
  
  public final boolean isSHORT() {
    return SHORT.class.isAssignableFrom(_class);
  }
  
  public final boolean isINT() {
    return INT.class.isAssignableFrom(_class);
  }
  
  public final boolean isFLOAT() {
    return FLOAT.class.isAssignableFrom(_class);
  }
  
  public final boolean isDOUBLE() {
    return DOUBLE.class.isAssignableFrom(_class);
  }
  
  public final boolean isSTRING() {
    return STRING.class.isAssignableFrom(_class);
  }
  
  public final boolean isENUM() {
    return ENUM.class.isAssignableFrom(_class);
  }
  
  public final boolean isSTS() {
    return STS.class.isAssignableFrom(_class);
  }
  
  public final boolean isGR() {
    return GR.class.isAssignableFrom(_class);
  }
  
  public final boolean isCTRL() {
    return CTRL.class.isAssignableFrom(_class);
  }
  
  public final boolean isLABELS() {
    return LABELS.class.isAssignableFrom(_class);
  }
  
  public final boolean isTIME() {
    return TIME.class.isAssignableFrom(_class);
  }
  
  public final boolean isPRECISION() {
    return PRECISION.class.isAssignableFrom(_class);
  }
  
  
  
  public DBR newInstance( int count ) {
    try {
      java.lang.reflect.Constructor ctor=_class.getConstructor( new Class[] {Integer.TYPE} );
      //        System.out.println("ctor="+ctor);
      return( DBR )ctor.newInstance( new Object[] {new Integer( count )} );
    } catch( Exception ex ) {
    }
    return null;
  }

  
  static final public DBRType forName(final String name) {
    return (DBRType) _map.get(name);
  }
  
  static final public DBRType forValue(final int value ) {
    DBRType type;
    for(java.util.Iterator it= _map.values().iterator(); it.hasNext(); ) {
      type= (DBRType)it.next();
      if(type.getValue()==value) return type;
    }
    return null;
  }
 
  static public void main(String args[]) {
    java.util.TreeMap m= new java.util.TreeMap();
       
    for(java.util.Iterator it= _map.values().iterator(); it.hasNext(); ) {
      DBRType t= (DBRType) it.next();
      m.put(new Integer(t.getValue()), t);
    }
    
    for(java.util.Iterator it= m.values().iterator(); it.hasNext(); ) {
      DBRType t= (DBRType) it.next();
      System.out.println(t);
    }
    
  }
  
}



