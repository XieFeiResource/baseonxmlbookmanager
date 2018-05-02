/**
 * Book.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bm.model.bean;

public class Book  implements java.io.Serializable {
    private int baccount;

    private java.lang.String bauthor;

    private java.lang.String bdes;

    private java.lang.String bimagepath;

    private java.lang.String bname;

    private int bno;

    private int bprice;

    public Book() {
    }

    public Book(
           int baccount,
           java.lang.String bauthor,
           java.lang.String bdes,
           java.lang.String bimagepath,
           java.lang.String bname,
           int bno,
           int bprice) {
           this.baccount = baccount;
           this.bauthor = bauthor;
           this.bdes = bdes;
           this.bimagepath = bimagepath;
           this.bname = bname;
           this.bno = bno;
           this.bprice = bprice;
    }
    public Book(
            int baccount,
            java.lang.String bauthor,
            java.lang.String bdes,
            java.lang.String bimagepath,
            java.lang.String bname,
            int bprice) {
            this.baccount = baccount;
            this.bauthor = bauthor;
            this.bdes = bdes;
            this.bimagepath = bimagepath;
            this.bname = bname;
            this.bprice = bprice;
     }

    /**
     * Gets the baccount value for this Book.
     * 
     * @return baccount
     */
    public int getBaccount() {
        return baccount;
    }


    /**
     * Sets the baccount value for this Book.
     * 
     * @param baccount
     */
    public void setBaccount(int baccount) {
        this.baccount = baccount;
    }


    /**
     * Gets the bauthor value for this Book.
     * 
     * @return bauthor
     */
    public java.lang.String getBauthor() {
        return bauthor;
    }


    /**
     * Sets the bauthor value for this Book.
     * 
     * @param bauthor
     */
    public void setBauthor(java.lang.String bauthor) {
        this.bauthor = bauthor;
    }


    /**
     * Gets the bdes value for this Book.
     * 
     * @return bdes
     */
    public java.lang.String getBdes() {
        return bdes;
    }


    /**
     * Sets the bdes value for this Book.
     * 
     * @param bdes
     */
    public void setBdes(java.lang.String bdes) {
        this.bdes = bdes;
    }


    /**
     * Gets the bimagepath value for this Book.
     * 
     * @return bimagepath
     */
    public java.lang.String getBimagepath() {
        return bimagepath;
    }


    /**
     * Sets the bimagepath value for this Book.
     * 
     * @param bimagepath
     */
    public void setBimagepath(java.lang.String bimagepath) {
        this.bimagepath = bimagepath;
    }


    /**
     * Gets the bname value for this Book.
     * 
     * @return bname
     */
    public java.lang.String getBname() {
        return bname;
    }


    /**
     * Sets the bname value for this Book.
     * 
     * @param bname
     */
    public void setBname(java.lang.String bname) {
        this.bname = bname;
    }


    /**
     * Gets the bno value for this Book.
     * 
     * @return bno
     */
    public int getBno() {
        return bno;
    }


    /**
     * Sets the bno value for this Book.
     * 
     * @param bno
     */
    public void setBno(int bno) {
        this.bno = bno;
    }


    /**
     * Gets the bprice value for this Book.
     * 
     * @return bprice
     */
    public int getBprice() {
        return bprice;
    }


    /**
     * Sets the bprice value for this Book.
     * 
     * @param bprice
     */
    public void setBprice(int bprice) {
        this.bprice = bprice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.baccount == other.getBaccount() &&
            ((this.bauthor==null && other.getBauthor()==null) || 
             (this.bauthor!=null &&
              this.bauthor.equals(other.getBauthor()))) &&
            ((this.bdes==null && other.getBdes()==null) || 
             (this.bdes!=null &&
              this.bdes.equals(other.getBdes()))) &&
            ((this.bimagepath==null && other.getBimagepath()==null) || 
             (this.bimagepath!=null &&
              this.bimagepath.equals(other.getBimagepath()))) &&
            ((this.bname==null && other.getBname()==null) || 
             (this.bname!=null &&
              this.bname.equals(other.getBname()))) &&
            this.bno == other.getBno() &&
            this.bprice == other.getBprice();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getBaccount();
        if (getBauthor() != null) {
            _hashCode += getBauthor().hashCode();
        }
        if (getBdes() != null) {
            _hashCode += getBdes().hashCode();
        }
        if (getBimagepath() != null) {
            _hashCode += getBimagepath().hashCode();
        }
        if (getBname() != null) {
            _hashCode += getBname().hashCode();
        }
        _hashCode += getBno();
        _hashCode += getBprice();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Book.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.model.bm.com", "Book"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baccount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.bm.com", "baccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bauthor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.bm.com", "bauthor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bdes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.bm.com", "bdes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bimagepath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.bm.com", "bimagepath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.bm.com", "bname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.bm.com", "bno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bprice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.bm.com", "bprice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
