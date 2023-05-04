/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consultas;

/**
 *
 * @author rjsaa
 */
public class BaseReq {
    private String HostId;
    private String OperationId;
    private String ClienteIPAddress;
    private String CultureCode;
    private String AccountNumber;

    public BaseReq() {
        super();
    }

    public String getHostId() {
        return HostId;
    }

    public void setHostId(String HostId) {
        this.HostId = HostId;
    }

    public String getOperationId() {
        return OperationId;
    }

    public void setOperationId(String OperationId) {
        this.OperationId = OperationId;
    }

    public String getClienteIPAddress() {
        return ClienteIPAddress;
    }

    public void setClienteIPAddress(String ClienteIPAddress) {
        this.ClienteIPAddress = ClienteIPAddress;
    }

    public String getCultureCode() {
        return CultureCode;
    }

    public void setCultureCode(String CultureCode) {
        this.CultureCode = CultureCode;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }
    
    
    
}
