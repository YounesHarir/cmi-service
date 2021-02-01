//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2021.02.01 à 11:50:28 PM WET 
//


package com.app.payments_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bill" type="{http://app.com/payments-service}billInfo"/>
 *         &lt;element name="accountID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creancier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bill",
    "accountID",
    "creancier"
})
@XmlRootElement(name = "paymentRequest")
public class PaymentRequest {

    @XmlElement(required = true)
    protected BillInfo bill;
    @XmlElement(required = true)
    protected String accountID;
    @XmlElement(required = true)
    protected String creancier;

    /**
     * Obtient la valeur de la propriété bill.
     * 
     * @return
     *     possible object is
     *     {@link BillInfo }
     *     
     */
    public BillInfo getBill() {
        return bill;
    }

    /**
     * Définit la valeur de la propriété bill.
     * 
     * @param value
     *     allowed object is
     *     {@link BillInfo }
     *     
     */
    public void setBill(BillInfo value) {
        this.bill = value;
    }

    /**
     * Obtient la valeur de la propriété accountID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     * Définit la valeur de la propriété accountID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountID(String value) {
        this.accountID = value;
    }

    /**
     * Obtient la valeur de la propriété creancier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreancier() {
        return creancier;
    }

    /**
     * Définit la valeur de la propriété creancier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreancier(String value) {
        this.creancier = value;
    }

}
