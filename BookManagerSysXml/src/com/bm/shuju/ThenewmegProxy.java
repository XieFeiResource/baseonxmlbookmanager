package com.bm.shuju;

public class ThenewmegProxy implements com.bm.shuju.Thenewmeg {
  private String _endpoint = null;
  private com.bm.shuju.Thenewmeg thenewmeg = null;
  
  public ThenewmegProxy() {
    _initThenewmegProxy();
  }
  
  public ThenewmegProxy(String endpoint) {
    _endpoint = endpoint;
    _initThenewmegProxy();
  }
  
  private void _initThenewmegProxy() {
    try {
      thenewmeg = (new com.bm.shuju.ThenewmegServiceLocator()).getThenewmeg();
      if (thenewmeg != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)thenewmeg)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)thenewmeg)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (thenewmeg != null)
      ((javax.xml.rpc.Stub)thenewmeg)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.bm.shuju.Thenewmeg getThenewmeg() {
    if (thenewmeg == null)
      _initThenewmegProxy();
    return thenewmeg;
  }
  
  public void addbookmeg(com.bm.model.bean.Book b) throws java.rmi.RemoteException{
    if (thenewmeg == null)
      _initThenewmegProxy();
    thenewmeg.addbookmeg(b);
  }
  
  
}