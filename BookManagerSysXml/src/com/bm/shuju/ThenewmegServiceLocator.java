/**
 * ThenewmegServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bm.shuju;

public class ThenewmegServiceLocator extends org.apache.axis.client.Service implements com.bm.shuju.ThenewmegService {

    public ThenewmegServiceLocator() {
    }


    public ThenewmegServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ThenewmegServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Thenewmeg
    private java.lang.String Thenewmeg_address = "http://localhost:8989/BookManager/services/Thenewmeg";

    public java.lang.String getThenewmegAddress() {
        return Thenewmeg_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ThenewmegWSDDServiceName = "Thenewmeg";

    public java.lang.String getThenewmegWSDDServiceName() {
        return ThenewmegWSDDServiceName;
    }

    public void setThenewmegWSDDServiceName(java.lang.String name) {
        ThenewmegWSDDServiceName = name;
    }

    public com.bm.shuju.Thenewmeg getThenewmeg() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Thenewmeg_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getThenewmeg(endpoint);
    }

    public com.bm.shuju.Thenewmeg getThenewmeg(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.bm.shuju.ThenewmegSoapBindingStub _stub = new com.bm.shuju.ThenewmegSoapBindingStub(portAddress, this);
            _stub.setPortName(getThenewmegWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setThenewmegEndpointAddress(java.lang.String address) {
        Thenewmeg_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.bm.shuju.Thenewmeg.class.isAssignableFrom(serviceEndpointInterface)) {
                com.bm.shuju.ThenewmegSoapBindingStub _stub = new com.bm.shuju.ThenewmegSoapBindingStub(new java.net.URL(Thenewmeg_address), this);
                _stub.setPortName(getThenewmegWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Thenewmeg".equals(inputPortName)) {
            return getThenewmeg();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://shuju.bm.com", "ThenewmegService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://shuju.bm.com", "Thenewmeg"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Thenewmeg".equals(portName)) {
            setThenewmegEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
