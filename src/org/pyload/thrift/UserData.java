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

public class UserData implements TBase<UserData, UserData._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("UserData");

  private static final TField NAME_FIELD_DESC = new TField("name", TType.STRING, (short)1);
  private static final TField EMAIL_FIELD_DESC = new TField("email", TType.STRING, (short)2);
  private static final TField ROLE_FIELD_DESC = new TField("role", TType.I32, (short)3);
  private static final TField PERMISSION_FIELD_DESC = new TField("permission", TType.I32, (short)4);
  private static final TField TEMPLATE_FIELD_DESC = new TField("template", TType.STRING, (short)5);

  public String name;
  public String email;
  public int role;
  public int permission;
  public String template;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    NAME((short)1, "name"),
    EMAIL((short)2, "email"),
    ROLE((short)3, "role"),
    PERMISSION((short)4, "permission"),
    TEMPLATE((short)5, "template");

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
        case 1: // NAME
          return NAME;
        case 2: // EMAIL
          return EMAIL;
        case 3: // ROLE
          return ROLE;
        case 4: // PERMISSION
          return PERMISSION;
        case 5: // TEMPLATE
          return TEMPLATE;
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
  private static final int __ROLE_ISSET_ID = 0;
  private static final int __PERMISSION_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new FieldMetaData("name", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.EMAIL, new FieldMetaData("email", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.ROLE, new FieldMetaData("role", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I32)));
    tmpMap.put(_Fields.PERMISSION, new FieldMetaData("permission", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I32)));
    tmpMap.put(_Fields.TEMPLATE, new FieldMetaData("template", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(UserData.class, metaDataMap);
  }

  public UserData() {
  }

  public UserData(
    String name,
    String email,
    int role,
    int permission,
    String template)
  {
    this();
    this.name = name;
    this.email = email;
    this.role = role;
    setRoleIsSet(true);
    this.permission = permission;
    setPermissionIsSet(true);
    this.template = template;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserData(UserData other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetEmail()) {
      this.email = other.email;
    }
    this.role = other.role;
    this.permission = other.permission;
    if (other.isSetTemplate()) {
      this.template = other.template;
    }
  }

  public UserData deepCopy() {
    return new UserData(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.email = null;
    setRoleIsSet(false);
    this.role = 0;
    setPermissionIsSet(false);
    this.permission = 0;
    this.template = null;
  }

  public String getName() {
    return this.name;
  }

  public UserData setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been asigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getEmail() {
    return this.email;
  }

  public UserData setEmail(String email) {
    this.email = email;
    return this;
  }

  public void unsetEmail() {
    this.email = null;
  }

  /** Returns true if field email is set (has been asigned a value) and false otherwise */
  public boolean isSetEmail() {
    return this.email != null;
  }

  public void setEmailIsSet(boolean value) {
    if (!value) {
      this.email = null;
    }
  }

  public int getRole() {
    return this.role;
  }

  public UserData setRole(int role) {
    this.role = role;
    setRoleIsSet(true);
    return this;
  }

  public void unsetRole() {
    __isset_bit_vector.clear(__ROLE_ISSET_ID);
  }

  /** Returns true if field role is set (has been asigned a value) and false otherwise */
  public boolean isSetRole() {
    return __isset_bit_vector.get(__ROLE_ISSET_ID);
  }

  public void setRoleIsSet(boolean value) {
    __isset_bit_vector.set(__ROLE_ISSET_ID, value);
  }

  public int getPermission() {
    return this.permission;
  }

  public UserData setPermission(int permission) {
    this.permission = permission;
    setPermissionIsSet(true);
    return this;
  }

  public void unsetPermission() {
    __isset_bit_vector.clear(__PERMISSION_ISSET_ID);
  }

  /** Returns true if field permission is set (has been asigned a value) and false otherwise */
  public boolean isSetPermission() {
    return __isset_bit_vector.get(__PERMISSION_ISSET_ID);
  }

  public void setPermissionIsSet(boolean value) {
    __isset_bit_vector.set(__PERMISSION_ISSET_ID, value);
  }

  public String getTemplate() {
    return this.template;
  }

  public UserData setTemplate(String template) {
    this.template = template;
    return this;
  }

  public void unsetTemplate() {
    this.template = null;
  }

  /** Returns true if field template is set (has been asigned a value) and false otherwise */
  public boolean isSetTemplate() {
    return this.template != null;
  }

  public void setTemplateIsSet(boolean value) {
    if (!value) {
      this.template = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case EMAIL:
      if (value == null) {
        unsetEmail();
      } else {
        setEmail((String)value);
      }
      break;

    case ROLE:
      if (value == null) {
        unsetRole();
      } else {
        setRole((Integer)value);
      }
      break;

    case PERMISSION:
      if (value == null) {
        unsetPermission();
      } else {
        setPermission((Integer)value);
      }
      break;

    case TEMPLATE:
      if (value == null) {
        unsetTemplate();
      } else {
        setTemplate((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case EMAIL:
      return getEmail();

    case ROLE:
      return new Integer(getRole());

    case PERMISSION:
      return new Integer(getPermission());

    case TEMPLATE:
      return getTemplate();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case EMAIL:
      return isSetEmail();
    case ROLE:
      return isSetRole();
    case PERMISSION:
      return isSetPermission();
    case TEMPLATE:
      return isSetTemplate();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserData)
      return this.equals((UserData)that);
    return false;
  }

  public boolean equals(UserData that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_email = true && this.isSetEmail();
    boolean that_present_email = true && that.isSetEmail();
    if (this_present_email || that_present_email) {
      if (!(this_present_email && that_present_email))
        return false;
      if (!this.email.equals(that.email))
        return false;
    }

    boolean this_present_role = true;
    boolean that_present_role = true;
    if (this_present_role || that_present_role) {
      if (!(this_present_role && that_present_role))
        return false;
      if (this.role != that.role)
        return false;
    }

    boolean this_present_permission = true;
    boolean that_present_permission = true;
    if (this_present_permission || that_present_permission) {
      if (!(this_present_permission && that_present_permission))
        return false;
      if (this.permission != that.permission)
        return false;
    }

    boolean this_present_template = true && this.isSetTemplate();
    boolean that_present_template = true && that.isSetTemplate();
    if (this_present_template || that_present_template) {
      if (!(this_present_template && that_present_template))
        return false;
      if (!this.template.equals(that.template))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(UserData other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    UserData typedOther = (UserData)other;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(typedOther.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = TBaseHelper.compareTo(this.name, typedOther.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEmail()).compareTo(typedOther.isSetEmail());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEmail()) {
      lastComparison = TBaseHelper.compareTo(this.email, typedOther.email);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRole()).compareTo(typedOther.isSetRole());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRole()) {
      lastComparison = TBaseHelper.compareTo(this.role, typedOther.role);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPermission()).compareTo(typedOther.isSetPermission());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPermission()) {
      lastComparison = TBaseHelper.compareTo(this.permission, typedOther.permission);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTemplate()).compareTo(typedOther.isSetTemplate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTemplate()) {
      lastComparison = TBaseHelper.compareTo(this.template, typedOther.template);
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
        case 1: // NAME
          if (field.type == TType.STRING) {
            this.name = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // EMAIL
          if (field.type == TType.STRING) {
            this.email = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // ROLE
          if (field.type == TType.I32) {
            this.role = iprot.readI32();
            setRoleIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // PERMISSION
          if (field.type == TType.I32) {
            this.permission = iprot.readI32();
            setPermissionIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // TEMPLATE
          if (field.type == TType.STRING) {
            this.template = iprot.readString();
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
    if (this.name != null) {
      oprot.writeFieldBegin(NAME_FIELD_DESC);
      oprot.writeString(this.name);
      oprot.writeFieldEnd();
    }
    if (this.email != null) {
      oprot.writeFieldBegin(EMAIL_FIELD_DESC);
      oprot.writeString(this.email);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(ROLE_FIELD_DESC);
    oprot.writeI32(this.role);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(PERMISSION_FIELD_DESC);
    oprot.writeI32(this.permission);
    oprot.writeFieldEnd();
    if (this.template != null) {
      oprot.writeFieldBegin(TEMPLATE_FIELD_DESC);
      oprot.writeString(this.template);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("UserData(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("email:");
    if (this.email == null) {
      sb.append("null");
    } else {
      sb.append(this.email);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("role:");
    sb.append(this.role);
    first = false;
    if (!first) sb.append(", ");
    sb.append("permission:");
    sb.append(this.permission);
    first = false;
    if (!first) sb.append(", ");
    sb.append("template:");
    if (this.template == null) {
      sb.append("null");
    } else {
      sb.append(this.template);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}
