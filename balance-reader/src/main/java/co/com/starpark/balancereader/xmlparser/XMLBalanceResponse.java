/**
 * XML Balance Response Parser
 */
package co.com.starpark.balancereader.xmlparser;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "commandStatus", "accountBalance" })
@XmlRootElement(name = "iEnhancedInterfaceResponse")
public class XMLBalanceResponse {

	@XmlElement(name = "CommandStatus", required = true)
	protected XMLBalanceResponse.CommandStatus commandStatus;
	@XmlElement(name = "AccountBalance", required = true)
	protected XMLBalanceResponse.AccountBalance accountBalance;

	public XMLBalanceResponse.CommandStatus getCommandStatus() {
		return commandStatus;
	}

	public void setCommandStatus(XMLBalanceResponse.CommandStatus value) {
		this.commandStatus = value;
	}

	public XMLBalanceResponse.AccountBalance getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(XMLBalanceResponse.AccountBalance value) {
		this.accountBalance = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "accountNumber", "locID", "blockedAccessID", "registered",
			"membershipCashPeriodSum", "membershipDemotionTimeStamp", "firstName", "lastName", "empCredits",
			"empStatus", "newCard", "cashBalance", "cashBonusBalance", "tokenBalance", "tokenBonusBalance",
			"pointBalance", "tpStartTime", "tpEndTime", "tpDuration", "discount", "status", "activationDate",
			"expirationDate", "membershipPromoID", "linkedGA" })
	public static class AccountBalance {

		@XmlElement(name = "AccountNumber")
		protected int accountNumber;
		@XmlElement(name = "LocID")
		protected int locID;
		@XmlElement(name = "BlockedAccessID")
		protected int blockedAccessID;
		@XmlElement(name = "Registered", required = true)
		protected String registered;
		@XmlElement(name = "MembershipCashPeriodSum")
		protected float membershipCashPeriodSum;
		@XmlElement(name = "MembershipDemotionTimeStamp", required = true)
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar membershipDemotionTimeStamp;
		@XmlElement(name = "FirstName", required = true)
		protected String firstName;
		@XmlElement(name = "LastName", required = true)
		protected String lastName;
		@XmlElement(name = "EmpCredits")
		protected int empCredits;
		@XmlElement(name = "EmpStatus")
		protected int empStatus;
		@XmlElement(name = "NewCard", required = true)
		protected String newCard;
		@XmlElement(name = "CashBalance")
		protected float cashBalance;
		@XmlElement(name = "CashBonusBalance")
		protected float cashBonusBalance;
		@XmlElement(name = "TokenBalance")
		protected int tokenBalance;
		@XmlElement(name = "TokenBonusBalance")
		protected int tokenBonusBalance;
		@XmlElement(name = "PointBalance")
		protected int pointBalance;
		@XmlElement(name = "TP_StartTime", required = true)
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar tpStartTime;
		@XmlElement(name = "TP_EndTime", required = true)
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar tpEndTime;
		@XmlElement(name = "TP_Duration")
		protected int tpDuration;
		@XmlElement(name = "Discount")
		protected int discount;
		@XmlElement(name = "Status")
		protected int status;
		@XmlElement(name = "ActivationDate", required = true)
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar activationDate;
		@XmlElement(name = "ExpirationDate", required = true)
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar expirationDate;
		@XmlElement(name = "MembershipPromoID")
		protected int membershipPromoID;
		@XmlElement(name = "LinkedGA", required = true)
		protected XMLBalanceResponse.AccountBalance.LinkedGA linkedGA;

		public int getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(int value) {
			this.accountNumber = value;
		}

		public int getLocID() {
			return locID;
		}

		public void setLocID(int value) {
			this.locID = value;
		}

		public int getBlockedAccessID() {
			return blockedAccessID;
		}

		public void setBlockedAccessID(int value) {
			this.blockedAccessID = value;
		}

		public String getRegistered() {
			return registered;
		}

		public void setRegistered(String value) {
			this.registered = value;
		}

		public float getMembershipCashPeriodSum() {
			return membershipCashPeriodSum;
		}

		public void setMembershipCashPeriodSum(float value) {
			this.membershipCashPeriodSum = value;
		}

		public XMLGregorianCalendar getMembershipDemotionTimeStamp() {
			return membershipDemotionTimeStamp;
		}

		public void setMembershipDemotionTimeStamp(XMLGregorianCalendar value) {
			this.membershipDemotionTimeStamp = value;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String value) {
			this.firstName = value;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String value) {
			this.lastName = value;
		}

		public int getEmpCredits() {
			return empCredits;
		}

		public void setEmpCredits(int value) {
			this.empCredits = value;
		}

		public int getEmpStatus() {
			return empStatus;
		}

		public void setEmpStatus(int value) {
			this.empStatus = value;
		}

		public String getNewCard() {
			return newCard;
		}

		public void setNewCard(String value) {
			this.newCard = value;
		}

		public float getCashBalance() {
			return cashBalance;
		}

		public void setCashBalance(float value) {
			this.cashBalance = value;
		}

		public float getCashBonusBalance() {
			return cashBonusBalance;
		}

		public void setCashBonusBalance(float value) {
			this.cashBonusBalance = value;
		}

		public int getTokenBalance() {
			return tokenBalance;
		}

		public void setTokenBalance(int value) {
			this.tokenBalance = value;
		}

		public int getTokenBonusBalance() {
			return tokenBonusBalance;
		}

		public void setTokenBonusBalance(int value) {
			this.tokenBonusBalance = value;
		}

		public int getPointBalance() {
			return pointBalance;
		}

		public void setPointBalance(int value) {
			this.pointBalance = value;
		}

		public XMLGregorianCalendar getTPStartTime() {
			return tpStartTime;
		}

		public void setTPStartTime(XMLGregorianCalendar value) {
			this.tpStartTime = value;
		}

		public XMLGregorianCalendar getTPEndTime() {
			return tpEndTime;
		}

		public void setTPEndTime(XMLGregorianCalendar value) {
			this.tpEndTime = value;
		}

		public int getTPDuration() {
			return tpDuration;
		}

		public void setTPDuration(int value) {
			this.tpDuration = value;
		}

		public int getDiscount() {
			return discount;
		}

		public void setDiscount(int value) {
			this.discount = value;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int value) {
			this.status = value;
		}

		public XMLGregorianCalendar getActivationDate() {
			return activationDate;
		}

		public void setActivationDate(XMLGregorianCalendar value) {
			this.activationDate = value;
		}

		public XMLGregorianCalendar getExpirationDate() {
			return expirationDate;
		}

		public void setExpirationDate(XMLGregorianCalendar value) {
			this.expirationDate = value;
		}

		public int getMembershipPromoID() {
			return membershipPromoID;
		}

		public void setMembershipPromoID(int value) {
			this.membershipPromoID = value;
		}

		public XMLBalanceResponse.AccountBalance.LinkedGA getLinkedGA() {
			return linkedGA;
		}

		public void setLinkedGA(XMLBalanceResponse.AccountBalance.LinkedGA value) {
			this.linkedGA = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "linkedGateAccess" })
		public static class LinkedGA {

			@XmlElement(name = "LinkedGateAccess")
			protected List<XMLBalanceResponse.AccountBalance.LinkedGA.LinkedGateAccess> linkedGateAccess;

			public List<XMLBalanceResponse.AccountBalance.LinkedGA.LinkedGateAccess> getLinkedGateAccess() {
				if (linkedGateAccess == null) {
					linkedGateAccess = new ArrayList<XMLBalanceResponse.AccountBalance.LinkedGA.LinkedGateAccess>();
				}
				return this.linkedGateAccess;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "productTag", "deviceTag", "actuations" })
			public static class LinkedGateAccess {

				@XmlElement(name = "ProductTag")
				protected short productTag;
				@XmlElement(name = "DeviceTag")
				protected int deviceTag;
				@XmlElement(name = "Actuations")
				protected int actuations;

				public short getProductTag() {
					return productTag;
				}

				public void setProductTag(short value) {
					this.productTag = value;
				}

				public int getDeviceTag() {
					return deviceTag;
				}

				public void setDeviceTag(int value) {
					this.deviceTag = value;
				}

				public int getActuations() {
					return actuations;
				}

				public void setActuations(int value) {
					this.actuations = value;
				}

			}

		}

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "responseCode", "responseDescription" })
	public static class CommandStatus {

		@XmlElement(name = "ResponseCode")
		protected int responseCode;
		@XmlElement(name = "ResponseDescription", required = true)
		protected String responseDescription;

		public int getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(int value) {
			this.responseCode = value;
		}

		public String getResponseDescription() {
			return responseDescription;
		}

		public void setResponseDescription(String value) {
			this.responseDescription = value;
		}

	}

}
