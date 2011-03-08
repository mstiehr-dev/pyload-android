/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pyload.thrift;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

public class AccountInfo implements TBase<AccountInfo, AccountInfo._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("AccountInfo");

  private static final TField VALIDUNTIL_FIELD_DESC = new TField("validuntil", TType.I64, (short)1);
  private static final TField LOGIN_FIELD_DESC = new TField("login", TType.STRING, (short)2);
  private static final TField OPTIONS_FIELD_DESC = new TField("options", TType.MAP, (short)3);
  private static final TField VALID_FIELD_DESC = new TField("valid", TType.BOOL, (short)4);
  private static final TField TRAFFICLEFT_FIELD_DESC = new TField("trafficleft", TType.I64, (short)5);
  private static final TField MAXTRAFFIC_FIELD_DESC = new TField("maxtraffic", TType.I64, (short)6);
  private static final TField PREMIUM_FIELD_DESC = new TField("premium", TType.BOOL, (short)7);
  private static final TField TYPE_FIELD_DESC = new TField("type", TType.STRING, (short)8);

  public long validuntil;
  public String login;
  public Map<String,String> options;
  public boolean valid;
  public long trafficleft;
  public long maxtraffic;
  public boolean premium;
  public String type;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    VALIDUNTIL((short)1, "validuntil"),
    LOGIN((short)2, "login"),
    OPTIONS((short)3, "options"),
    VALID((short)4, "valid"),
    TRAFFICLEFT((short)5, "trafficleft"),
    MAXTRAFFIC((short)6, "maxtraffic"),
    PREMIUM((short)7, "premium"),
    TYPE((short)8, "type");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // VALIDUNTIL
          return VALIDUNTIL;
        case 2: // LOGIN
          return LOGIN;
        case 3: // OPTIONS
          return OPTIONS;
        case 4: // VALID
          return VALID;
        case 5: // TRAFFICLEFT
          return TRAFFICLEFT;
        case 6: // MAXTRAFFIC
          return MAXTRAFFIC;
        case 7: // PREMIUM
          return PREMIUM;
        case 8: // TYPE
          return TYPE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __VALIDUNTIL_ISSET_ID = 0;
  private static final int __VALID_ISSET_ID = 1;
  private static final int __TRAFFICLEFT_ISSET_ID = 2;
  private static final int __MAXTRAFFIC_ISSET_ID = 3;
  private static final int __PREMIUM_ISSET_ID = 4;
  private BitSet __isset_bit_vector = new BitSet(5);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.VALIDUNTIL, new FieldMetaData("validuntil", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.LOGIN, new FieldMetaData("login", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.OPTIONS, new FieldMetaData("options", TFieldRequirementType.DEFAULT, 
        new MapMetaData(TType.MAP, 
            new FieldValueMetaData(TType.STRING), 
            new FieldValueMetaData(TType.STRING))));
    tmpMap.put(_Fields.VALID, new FieldMetaData("valid", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.BOOL)));
    tmpMap.put(_Fields.TRAFFICLEFT, new FieldMetaData("trafficleft", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.MAXTRAFFIC, new FieldMetaData("maxtraffic", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.PREMIUM, new FieldMetaData("premium", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.BOOL)));
    tmpMap.put(_Fields.TYPE, new FieldMetaData("type", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(AccountInfo.class, metaDataMap);
  }

  public AccountInfo() {
  }

  public AccountInfo(
    long validuntil,
    String login,
    Map<String,String> options,
    boolean valid,
    long trafficleft,
    long maxtraffic,
    boolean premium,
    String type)
  {
    this();
    this.validuntil = validuntil;
    setValiduntilIsSet(true);
    this.login = login;
    this.options = options;
    this.valid = valid;
    setValidIsSet(true);
    this.trafficleft = trafficleft;
    setTrafficleftIsSet(true);
    this.maxtraffic = maxtraffic;
    setMaxtrafficIsSet(true);
    this.premium = premium;
    setPremiumIsSet(true);
    this.type = type;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AccountInfo(AccountInfo other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.validuntil = other.validuntil;
    if (other.isSetLogin()) {
      this.login = other.login;
    }
    if (other.isSetOptions()) {
      Map<String,String> __this__options = new HashMap<String,String>();
      for (Map.Entry<String, String> other_element : other.options.entrySet()) {

        String other_element_key = other_element.getKey();
        String other_element_value = other_element.getValue();

        String __this__options_copy_key = other_element_key;

        String __this__options_copy_value = other_element_value;

        __this__options.put(__this__options_copy_key, __this__options_copy_value);
      }
      this.options = __this__options;
    }
    this.valid = other.valid;
    this.trafficleft = other.trafficleft;
    this.maxtraffic = other.maxtraffic;
    this.premium = other.premium;
    if (other.isSetType()) {
      this.type = other.type;
    }
  }

  public AccountInfo deepCopy() {
    return new AccountInfo(this);
  }

  @Override
  public void clear() {
    setValiduntilIsSet(false);
    this.validuntil = 0;
    this.login = null;
    this.options = null;
    setValidIsSet(false);
    this.valid = false;
    setTrafficleftIsSet(false);
    this.trafficleft = 0;
    setMaxtrafficIsSet(false);
    this.maxtraffic = 0;
    setPremiumIsSet(false);
    this.premium = false;
    this.type = null;
  }

  public long getValiduntil() {
    return this.validuntil;
  }

  public AccountInfo setValiduntil(long validuntil) {
    this.validuntil = validuntil;
    setValiduntilIsSet(true);
    return this;
  }

  public void unsetValiduntil() {
    __isset_bit_vector.clear(__VALIDUNTIL_ISSET_ID);
  }

  /** Returns true if field validuntil is set (has been asigned a value) and false otherwise */
  public boolean isSetValiduntil() {
    return __isset_bit_vector.get(__VALIDUNTIL_ISSET_ID);
  }

  public void setValiduntilIsSet(boolean value) {
    __isset_bit_vector.set(__VALIDUNTIL_ISSET_ID, value);
  }

  public String getLogin() {
    return this.login;
  }

  public AccountInfo setLogin(String login) {
    this.login = login;
    return this;
  }

  public void unsetLogin() {
    this.login = null;
  }

  /** Returns true if field login is set (has been asigned a value) and false otherwise */
  public boolean isSetLogin() {
    return this.login != null;
  }

  public void setLoginIsSet(boolean value) {
    if (!value) {
      this.login = null;
    }
  }

  public int getOptionsSize() {
    return (this.options == null) ? 0 : this.options.size();
  }

  public void putToOptions(String key, String val) {
    if (this.options == null) {
      this.options = new HashMap<String,String>();
    }
    this.options.put(key, val);
  }

  public Map<String,String> getOptions() {
    return this.options;
  }

  public AccountInfo setOptions(Map<String,String> options) {
    this.options = options;
    return this;
  }

  public void unsetOptions() {
    this.options = null;
  }

  /** Returns true if field options is set (has been asigned a value) and false otherwise */
  public boolean isSetOptions() {
    return this.options != null;
  }

  public void setOptionsIsSet(boolean value) {
    if (!value) {
      this.options = null;
    }
  }

  public boolean isValid() {
    return this.valid;
  }

  public AccountInfo setValid(boolean valid) {
    this.valid = valid;
    setValidIsSet(true);
    return this;
  }

  public void unsetValid() {
    __isset_bit_vector.clear(__VALID_ISSET_ID);
  }

  /** Returns true if field valid is set (has been asigned a value) and false otherwise */
  public boolean isSetValid() {
    return __isset_bit_vector.get(__VALID_ISSET_ID);
  }

  public void setValidIsSet(boolean value) {
    __isset_bit_vector.set(__VALID_ISSET_ID, value);
  }

  public long getTrafficleft() {
    return this.trafficleft;
  }

  public AccountInfo setTrafficleft(long trafficleft) {
    this.trafficleft = trafficleft;
    setTrafficleftIsSet(true);
    return this;
  }

  public void unsetTrafficleft() {
    __isset_bit_vector.clear(__TRAFFICLEFT_ISSET_ID);
  }

  /** Returns true if field trafficleft is set (has been asigned a value) and false otherwise */
  public boolean isSetTrafficleft() {
    return __isset_bit_vector.get(__TRAFFICLEFT_ISSET_ID);
  }

  public void setTrafficleftIsSet(boolean value) {
    __isset_bit_vector.set(__TRAFFICLEFT_ISSET_ID, value);
  }

  public long getMaxtraffic() {
    return this.maxtraffic;
  }

  public AccountInfo setMaxtraffic(long maxtraffic) {
    this.maxtraffic = maxtraffic;
    setMaxtrafficIsSet(true);
    return this;
  }

  public void unsetMaxtraffic() {
    __isset_bit_vector.clear(__MAXTRAFFIC_ISSET_ID);
  }

  /** Returns true if field maxtraffic is set (has been asigned a value) and false otherwise */
  public boolean isSetMaxtraffic() {
    return __isset_bit_vector.get(__MAXTRAFFIC_ISSET_ID);
  }

  public void setMaxtrafficIsSet(boolean value) {
    __isset_bit_vector.set(__MAXTRAFFIC_ISSET_ID, value);
  }

  public boolean isPremium() {
    return this.premium;
  }

  public AccountInfo setPremium(boolean premium) {
    this.premium = premium;
    setPremiumIsSet(true);
    return this;
  }

  public void unsetPremium() {
    __isset_bit_vector.clear(__PREMIUM_ISSET_ID);
  }

  /** Returns true if field premium is set (has been asigned a value) and false otherwise */
  public boolean isSetPremium() {
    return __isset_bit_vector.get(__PREMIUM_ISSET_ID);
  }

  public void setPremiumIsSet(boolean value) {
    __isset_bit_vector.set(__PREMIUM_ISSET_ID, value);
  }

  public String getType() {
    return this.type;
  }

  public AccountInfo setType(String type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been asigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case VALIDUNTIL:
      if (value == null) {
        unsetValiduntil();
      } else {
        setValiduntil((Long)value);
      }
      break;

    case LOGIN:
      if (value == null) {
        unsetLogin();
      } else {
        setLogin((String)value);
      }
      break;

    case OPTIONS:
      if (value == null) {
        unsetOptions();
      } else {
        setOptions((Map<String,String>)value);
      }
      break;

    case VALID:
      if (value == null) {
        unsetValid();
      } else {
        setValid((Boolean)value);
      }
      break;

    case TRAFFICLEFT:
      if (value == null) {
        unsetTrafficleft();
      } else {
        setTrafficleft((Long)value);
      }
      break;

    case MAXTRAFFIC:
      if (value == null) {
        unsetMaxtraffic();
      } else {
        setMaxtraffic((Long)value);
      }
      break;

    case PREMIUM:
      if (value == null) {
        unsetPremium();
      } else {
        setPremium((Boolean)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case VALIDUNTIL:
      return new Long(getValiduntil());

    case LOGIN:
      return getLogin();

    case OPTIONS:
      return getOptions();

    case VALID:
      return new Boolean(isValid());

    case TRAFFICLEFT:
      return new Long(getTrafficleft());

    case MAXTRAFFIC:
      return new Long(getMaxtraffic());

    case PREMIUM:
      return new Boolean(isPremium());

    case TYPE:
      return getType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case VALIDUNTIL:
      return isSetValiduntil();
    case LOGIN:
      return isSetLogin();
    case OPTIONS:
      return isSetOptions();
    case VALID:
      return isSetValid();
    case TRAFFICLEFT:
      return isSetTrafficleft();
    case MAXTRAFFIC:
      return isSetMaxtraffic();
    case PREMIUM:
      return isSetPremium();
    case TYPE:
      return isSetType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AccountInfo)
      return this.equals((AccountInfo)that);
    return false;
  }

  public boolean equals(AccountInfo that) {
    if (that == null)
      return false;

    boolean this_present_validuntil = true;
    boolean that_present_validuntil = true;
    if (this_present_validuntil || that_present_validuntil) {
      if (!(this_present_validuntil && that_present_validuntil))
        return false;
      if (this.validuntil != that.validuntil)
        return false;
    }

    boolean this_present_login = true && this.isSetLogin();
    boolean that_present_login = true && that.isSetLogin();
    if (this_present_login || that_present_login) {
      if (!(this_present_login && that_present_login))
        return false;
      if (!this.login.equals(that.login))
        return false;
    }

    boolean this_present_options = true && this.isSetOptions();
    boolean that_present_options = true && that.isSetOptions();
    if (this_present_options || that_present_options) {
      if (!(this_present_options && that_present_options))
        return false;
      if (!this.options.equals(that.options))
        return false;
    }

    boolean this_present_valid = true;
    boolean that_present_valid = true;
    if (this_present_valid || that_present_valid) {
      if (!(this_present_valid && that_present_valid))
        return false;
      if (this.valid != that.valid)
        return false;
    }

    boolean this_present_trafficleft = true;
    boolean that_present_trafficleft = true;
    if (this_present_trafficleft || that_present_trafficleft) {
      if (!(this_present_trafficleft && that_present_trafficleft))
        return false;
      if (this.trafficleft != that.trafficleft)
        return false;
    }

    boolean this_present_maxtraffic = true;
    boolean that_present_maxtraffic = true;
    if (this_present_maxtraffic || that_present_maxtraffic) {
      if (!(this_present_maxtraffic && that_present_maxtraffic))
        return false;
      if (this.maxtraffic != that.maxtraffic)
        return false;
    }

    boolean this_present_premium = true;
    boolean that_present_premium = true;
    if (this_present_premium || that_present_premium) {
      if (!(this_present_premium && that_present_premium))
        return false;
      if (this.premium != that.premium)
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(AccountInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    AccountInfo typedOther = (AccountInfo)other;

    lastComparison = Boolean.valueOf(isSetValiduntil()).compareTo(typedOther.isSetValiduntil());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValiduntil()) {
      lastComparison = TBaseHelper.compareTo(this.validuntil, typedOther.validuntil);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLogin()).compareTo(typedOther.isSetLogin());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLogin()) {
      lastComparison = TBaseHelper.compareTo(this.login, typedOther.login);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOptions()).compareTo(typedOther.isSetOptions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOptions()) {
      lastComparison = TBaseHelper.compareTo(this.options, typedOther.options);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValid()).compareTo(typedOther.isSetValid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValid()) {
      lastComparison = TBaseHelper.compareTo(this.valid, typedOther.valid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTrafficleft()).compareTo(typedOther.isSetTrafficleft());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTrafficleft()) {
      lastComparison = TBaseHelper.compareTo(this.trafficleft, typedOther.trafficleft);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMaxtraffic()).compareTo(typedOther.isSetMaxtraffic());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxtraffic()) {
      lastComparison = TBaseHelper.compareTo(this.maxtraffic, typedOther.maxtraffic);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPremium()).compareTo(typedOther.isSetPremium());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPremium()) {
      lastComparison = TBaseHelper.compareTo(this.premium, typedOther.premium);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(typedOther.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = TBaseHelper.compareTo(this.type, typedOther.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // VALIDUNTIL
          if (field.type == TType.I64) {
            this.validuntil = iprot.readI64();
            setValiduntilIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // LOGIN
          if (field.type == TType.STRING) {
            this.login = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // OPTIONS
          if (field.type == TType.MAP) {
            {
              TMap _map12 = iprot.readMapBegin();
              this.options = new HashMap<String,String>(2*_map12.size);
              for (int _i13 = 0; _i13 < _map12.size; ++_i13)
              {
                String _key14;
                String _val15;
                _key14 = iprot.readString();
                _val15 = iprot.readString();
                this.options.put(_key14, _val15);
              }
              iprot.readMapEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // VALID
          if (field.type == TType.BOOL) {
            this.valid = iprot.readBool();
            setValidIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // TRAFFICLEFT
          if (field.type == TType.I64) {
            this.trafficleft = iprot.readI64();
            setTrafficleftIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // MAXTRAFFIC
          if (field.type == TType.I64) {
            this.maxtraffic = iprot.readI64();
            setMaxtrafficIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // PREMIUM
          if (field.type == TType.BOOL) {
            this.premium = iprot.readBool();
            setPremiumIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 8: // TYPE
          if (field.type == TType.STRING) {
            this.type = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(VALIDUNTIL_FIELD_DESC);
    oprot.writeI64(this.validuntil);
    oprot.writeFieldEnd();
    if (this.login != null) {
      oprot.writeFieldBegin(LOGIN_FIELD_DESC);
      oprot.writeString(this.login);
      oprot.writeFieldEnd();
    }
    if (this.options != null) {
      oprot.writeFieldBegin(OPTIONS_FIELD_DESC);
      {
        oprot.writeMapBegin(new TMap(TType.STRING, TType.STRING, this.options.size()));
        for (Map.Entry<String, String> _iter16 : this.options.entrySet())
        {
          oprot.writeString(_iter16.getKey());
          oprot.writeString(_iter16.getValue());
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(VALID_FIELD_DESC);
    oprot.writeBool(this.valid);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(TRAFFICLEFT_FIELD_DESC);
    oprot.writeI64(this.trafficleft);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(MAXTRAFFIC_FIELD_DESC);
    oprot.writeI64(this.maxtraffic);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(PREMIUM_FIELD_DESC);
    oprot.writeBool(this.premium);
    oprot.writeFieldEnd();
    if (this.type != null) {
      oprot.writeFieldBegin(TYPE_FIELD_DESC);
      oprot.writeString(this.type);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("AccountInfo(");
    boolean first = true;

    sb.append("validuntil:");
    sb.append(this.validuntil);
    first = false;
    if (!first) sb.append(", ");
    sb.append("login:");
    if (this.login == null) {
      sb.append("null");
    } else {
      sb.append(this.login);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("options:");
    if (this.options == null) {
      sb.append("null");
    } else {
      sb.append(this.options);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("valid:");
    sb.append(this.valid);
    first = false;
    if (!first) sb.append(", ");
    sb.append("trafficleft:");
    sb.append(this.trafficleft);
    first = false;
    if (!first) sb.append(", ");
    sb.append("maxtraffic:");
    sb.append(this.maxtraffic);
    first = false;
    if (!first) sb.append(", ");
    sb.append("premium:");
    sb.append(this.premium);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}
