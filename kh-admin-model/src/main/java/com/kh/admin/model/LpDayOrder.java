package com.kh.admin.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LpDayOrder implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.order_sn
     *
     * @mbggenerated
     */
    private String orderSn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.pay_platform_order_sn
     *
     * @mbggenerated
     */
    private String payPlatformOrderSn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.liquidator_order_sn
     *
     * @mbggenerated
     */
    private String liquidatorOrderSn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.store_id
     *
     * @mbggenerated
     */
    private String storeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.liquidator_merchant_id
     *
     * @mbggenerated
     */
    private String liquidatorMerchantId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.liquidator_id
     *
     * @mbggenerated
     */
    private String liquidatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.notify_url
     *
     * @mbggenerated
     */
    private String notifyUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.order_type
     *
     * @mbggenerated
     */
    private Integer orderType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.pay_platform_type
     *
     * @mbggenerated
     */
    private Integer payPlatformType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.real_money
     *
     * @mbggenerated
     */
    private BigDecimal realMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.net_money
     *
     * @mbggenerated
     */
    private BigDecimal netMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.pay_platform_rate
     *
     * @mbggenerated
     */
    private BigDecimal payPlatformRate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.pay_platform_fee
     *
     * @mbggenerated
     */
    private BigDecimal payPlatformFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.bank_commission_rate
     *
     * @mbggenerated
     */
    private BigDecimal bankCommissionRate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.bank_commission_fee
     *
     * @mbggenerated
     */
    private BigDecimal bankCommissionFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.liquidator_commission_rate
     *
     * @mbggenerated
     */
    private BigDecimal liquidatorCommissionRate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.liquidator_commission_fee
     *
     * @mbggenerated
     */
    private BigDecimal liquidatorCommissionFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.pay_status
     *
     * @mbggenerated
     */
    private Integer payStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.pay_time
     *
     * @mbggenerated
     */
    private Long payTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.create_time
     *
     * @mbggenerated
     */
    private Long createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.update_time
     *
     * @mbggenerated
     */
    private Long updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.create_day
     *
     * @mbggenerated
     */
    private Integer createDay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.sub_mch_id
     *
     * @mbggenerated
     */
    private String subMchId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.attribute1
     *
     * @mbggenerated
     */
    private String attribute1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.attribute2
     *
     * @mbggenerated
     */
    private String attribute2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.attribute3
     *
     * @mbggenerated
     */
    private String attribute3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.attribute4
     *
     * @mbggenerated
     */
    private String attribute4;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lp_day_order.attribute5
     *
     * @mbggenerated
     */
    private String attribute5;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lp_day_order
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.order_sn
     *
     * @return the value of lp_day_order.order_sn
     *
     * @mbggenerated
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.order_sn
     *
     * @param orderSn the value for lp_day_order.order_sn
     *
     * @mbggenerated
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.pay_platform_order_sn
     *
     * @return the value of lp_day_order.pay_platform_order_sn
     *
     * @mbggenerated
     */
    public String getPayPlatformOrderSn() {
        return payPlatformOrderSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.pay_platform_order_sn
     *
     * @param payPlatformOrderSn the value for lp_day_order.pay_platform_order_sn
     *
     * @mbggenerated
     */
    public void setPayPlatformOrderSn(String payPlatformOrderSn) {
        this.payPlatformOrderSn = payPlatformOrderSn == null ? null : payPlatformOrderSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.liquidator_order_sn
     *
     * @return the value of lp_day_order.liquidator_order_sn
     *
     * @mbggenerated
     */
    public String getLiquidatorOrderSn() {
        return liquidatorOrderSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.liquidator_order_sn
     *
     * @param liquidatorOrderSn the value for lp_day_order.liquidator_order_sn
     *
     * @mbggenerated
     */
    public void setLiquidatorOrderSn(String liquidatorOrderSn) {
        this.liquidatorOrderSn = liquidatorOrderSn == null ? null : liquidatorOrderSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.store_id
     *
     * @return the value of lp_day_order.store_id
     *
     * @mbggenerated
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.store_id
     *
     * @param storeId the value for lp_day_order.store_id
     *
     * @mbggenerated
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.liquidator_merchant_id
     *
     * @return the value of lp_day_order.liquidator_merchant_id
     *
     * @mbggenerated
     */
    public String getLiquidatorMerchantId() {
        return liquidatorMerchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.liquidator_merchant_id
     *
     * @param liquidatorMerchantId the value for lp_day_order.liquidator_merchant_id
     *
     * @mbggenerated
     */
    public void setLiquidatorMerchantId(String liquidatorMerchantId) {
        this.liquidatorMerchantId = liquidatorMerchantId == null ? null : liquidatorMerchantId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.liquidator_id
     *
     * @return the value of lp_day_order.liquidator_id
     *
     * @mbggenerated
     */
    public String getLiquidatorId() {
        return liquidatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.liquidator_id
     *
     * @param liquidatorId the value for lp_day_order.liquidator_id
     *
     * @mbggenerated
     */
    public void setLiquidatorId(String liquidatorId) {
        this.liquidatorId = liquidatorId == null ? null : liquidatorId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.notify_url
     *
     * @return the value of lp_day_order.notify_url
     *
     * @mbggenerated
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.notify_url
     *
     * @param notifyUrl the value for lp_day_order.notify_url
     *
     * @mbggenerated
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.order_type
     *
     * @return the value of lp_day_order.order_type
     *
     * @mbggenerated
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.order_type
     *
     * @param orderType the value for lp_day_order.order_type
     *
     * @mbggenerated
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.pay_platform_type
     *
     * @return the value of lp_day_order.pay_platform_type
     *
     * @mbggenerated
     */
    public Integer getPayPlatformType() {
        return payPlatformType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.pay_platform_type
     *
     * @param payPlatformType the value for lp_day_order.pay_platform_type
     *
     * @mbggenerated
     */
    public void setPayPlatformType(Integer payPlatformType) {
        this.payPlatformType = payPlatformType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.real_money
     *
     * @return the value of lp_day_order.real_money
     *
     * @mbggenerated
     */
    public BigDecimal getRealMoney() {
        return realMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.real_money
     *
     * @param realMoney the value for lp_day_order.real_money
     *
     * @mbggenerated
     */
    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.net_money
     *
     * @return the value of lp_day_order.net_money
     *
     * @mbggenerated
     */
    public BigDecimal getNetMoney() {
        return netMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.net_money
     *
     * @param netMoney the value for lp_day_order.net_money
     *
     * @mbggenerated
     */
    public void setNetMoney(BigDecimal netMoney) {
        this.netMoney = netMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.pay_platform_rate
     *
     * @return the value of lp_day_order.pay_platform_rate
     *
     * @mbggenerated
     */
    public BigDecimal getPayPlatformRate() {
        return payPlatformRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.pay_platform_rate
     *
     * @param payPlatformRate the value for lp_day_order.pay_platform_rate
     *
     * @mbggenerated
     */
    public void setPayPlatformRate(BigDecimal payPlatformRate) {
        this.payPlatformRate = payPlatformRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.pay_platform_fee
     *
     * @return the value of lp_day_order.pay_platform_fee
     *
     * @mbggenerated
     */
    public BigDecimal getPayPlatformFee() {
        return payPlatformFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.pay_platform_fee
     *
     * @param payPlatformFee the value for lp_day_order.pay_platform_fee
     *
     * @mbggenerated
     */
    public void setPayPlatformFee(BigDecimal payPlatformFee) {
        this.payPlatformFee = payPlatformFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.bank_commission_rate
     *
     * @return the value of lp_day_order.bank_commission_rate
     *
     * @mbggenerated
     */
    public BigDecimal getBankCommissionRate() {
        return bankCommissionRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.bank_commission_rate
     *
     * @param bankCommissionRate the value for lp_day_order.bank_commission_rate
     *
     * @mbggenerated
     */
    public void setBankCommissionRate(BigDecimal bankCommissionRate) {
        this.bankCommissionRate = bankCommissionRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.bank_commission_fee
     *
     * @return the value of lp_day_order.bank_commission_fee
     *
     * @mbggenerated
     */
    public BigDecimal getBankCommissionFee() {
        return bankCommissionFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.bank_commission_fee
     *
     * @param bankCommissionFee the value for lp_day_order.bank_commission_fee
     *
     * @mbggenerated
     */
    public void setBankCommissionFee(BigDecimal bankCommissionFee) {
        this.bankCommissionFee = bankCommissionFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.liquidator_commission_rate
     *
     * @return the value of lp_day_order.liquidator_commission_rate
     *
     * @mbggenerated
     */
    public BigDecimal getLiquidatorCommissionRate() {
        return liquidatorCommissionRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.liquidator_commission_rate
     *
     * @param liquidatorCommissionRate the value for lp_day_order.liquidator_commission_rate
     *
     * @mbggenerated
     */
    public void setLiquidatorCommissionRate(BigDecimal liquidatorCommissionRate) {
        this.liquidatorCommissionRate = liquidatorCommissionRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.liquidator_commission_fee
     *
     * @return the value of lp_day_order.liquidator_commission_fee
     *
     * @mbggenerated
     */
    public BigDecimal getLiquidatorCommissionFee() {
        return liquidatorCommissionFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.liquidator_commission_fee
     *
     * @param liquidatorCommissionFee the value for lp_day_order.liquidator_commission_fee
     *
     * @mbggenerated
     */
    public void setLiquidatorCommissionFee(BigDecimal liquidatorCommissionFee) {
        this.liquidatorCommissionFee = liquidatorCommissionFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.pay_status
     *
     * @return the value of lp_day_order.pay_status
     *
     * @mbggenerated
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.pay_status
     *
     * @param payStatus the value for lp_day_order.pay_status
     *
     * @mbggenerated
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.pay_time
     *
     * @return the value of lp_day_order.pay_time
     *
     * @mbggenerated
     */
    public Long getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.pay_time
     *
     * @param payTime the value for lp_day_order.pay_time
     *
     * @mbggenerated
     */
    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.create_time
     *
     * @return the value of lp_day_order.create_time
     *
     * @mbggenerated
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.create_time
     *
     * @param createTime the value for lp_day_order.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.update_time
     *
     * @return the value of lp_day_order.update_time
     *
     * @mbggenerated
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.update_time
     *
     * @param updateTime the value for lp_day_order.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.create_day
     *
     * @return the value of lp_day_order.create_day
     *
     * @mbggenerated
     */
    public Integer getCreateDay() {
        return createDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.create_day
     *
     * @param createDay the value for lp_day_order.create_day
     *
     * @mbggenerated
     */
    public void setCreateDay(Integer createDay) {
        this.createDay = createDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.sub_mch_id
     *
     * @return the value of lp_day_order.sub_mch_id
     *
     * @mbggenerated
     */
    public String getSubMchId() {
        return subMchId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.sub_mch_id
     *
     * @param subMchId the value for lp_day_order.sub_mch_id
     *
     * @mbggenerated
     */
    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId == null ? null : subMchId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.attribute1
     *
     * @return the value of lp_day_order.attribute1
     *
     * @mbggenerated
     */
    public String getAttribute1() {
        return attribute1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.attribute1
     *
     * @param attribute1 the value for lp_day_order.attribute1
     *
     * @mbggenerated
     */
    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1 == null ? null : attribute1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.attribute2
     *
     * @return the value of lp_day_order.attribute2
     *
     * @mbggenerated
     */
    public String getAttribute2() {
        return attribute2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.attribute2
     *
     * @param attribute2 the value for lp_day_order.attribute2
     *
     * @mbggenerated
     */
    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2 == null ? null : attribute2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.attribute3
     *
     * @return the value of lp_day_order.attribute3
     *
     * @mbggenerated
     */
    public String getAttribute3() {
        return attribute3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.attribute3
     *
     * @param attribute3 the value for lp_day_order.attribute3
     *
     * @mbggenerated
     */
    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3 == null ? null : attribute3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.attribute4
     *
     * @return the value of lp_day_order.attribute4
     *
     * @mbggenerated
     */
    public String getAttribute4() {
        return attribute4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.attribute4
     *
     * @param attribute4 the value for lp_day_order.attribute4
     *
     * @mbggenerated
     */
    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4 == null ? null : attribute4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lp_day_order.attribute5
     *
     * @return the value of lp_day_order.attribute5
     *
     * @mbggenerated
     */
    public String getAttribute5() {
        return attribute5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lp_day_order.attribute5
     *
     * @param attribute5 the value for lp_day_order.attribute5
     *
     * @mbggenerated
     */
    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5 == null ? null : attribute5.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lp_day_order
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderSn=").append(orderSn);
        sb.append(", payPlatformOrderSn=").append(payPlatformOrderSn);
        sb.append(", liquidatorOrderSn=").append(liquidatorOrderSn);
        sb.append(", storeId=").append(storeId);
        sb.append(", liquidatorMerchantId=").append(liquidatorMerchantId);
        sb.append(", liquidatorId=").append(liquidatorId);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", orderType=").append(orderType);
        sb.append(", payPlatformType=").append(payPlatformType);
        sb.append(", realMoney=").append(realMoney);
        sb.append(", netMoney=").append(netMoney);
        sb.append(", payPlatformRate=").append(payPlatformRate);
        sb.append(", payPlatformFee=").append(payPlatformFee);
        sb.append(", bankCommissionRate=").append(bankCommissionRate);
        sb.append(", bankCommissionFee=").append(bankCommissionFee);
        sb.append(", liquidatorCommissionRate=").append(liquidatorCommissionRate);
        sb.append(", liquidatorCommissionFee=").append(liquidatorCommissionFee);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payTime=").append(payTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createDay=").append(createDay);
        sb.append(", subMchId=").append(subMchId);
        sb.append(", attribute1=").append(attribute1);
        sb.append(", attribute2=").append(attribute2);
        sb.append(", attribute3=").append(attribute3);
        sb.append(", attribute4=").append(attribute4);
        sb.append(", attribute5=").append(attribute5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lp_day_order
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LpDayOrder other = (LpDayOrder) that;
        return (this.getOrderSn() == null ? other.getOrderSn() == null : this.getOrderSn().equals(other.getOrderSn()))
            && (this.getPayPlatformOrderSn() == null ? other.getPayPlatformOrderSn() == null : this.getPayPlatformOrderSn().equals(other.getPayPlatformOrderSn()))
            && (this.getLiquidatorOrderSn() == null ? other.getLiquidatorOrderSn() == null : this.getLiquidatorOrderSn().equals(other.getLiquidatorOrderSn()))
            && (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getLiquidatorMerchantId() == null ? other.getLiquidatorMerchantId() == null : this.getLiquidatorMerchantId().equals(other.getLiquidatorMerchantId()))
            && (this.getLiquidatorId() == null ? other.getLiquidatorId() == null : this.getLiquidatorId().equals(other.getLiquidatorId()))
            && (this.getNotifyUrl() == null ? other.getNotifyUrl() == null : this.getNotifyUrl().equals(other.getNotifyUrl()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getPayPlatformType() == null ? other.getPayPlatformType() == null : this.getPayPlatformType().equals(other.getPayPlatformType()))
            && (this.getRealMoney() == null ? other.getRealMoney() == null : this.getRealMoney().equals(other.getRealMoney()))
            && (this.getNetMoney() == null ? other.getNetMoney() == null : this.getNetMoney().equals(other.getNetMoney()))
            && (this.getPayPlatformRate() == null ? other.getPayPlatformRate() == null : this.getPayPlatformRate().equals(other.getPayPlatformRate()))
            && (this.getPayPlatformFee() == null ? other.getPayPlatformFee() == null : this.getPayPlatformFee().equals(other.getPayPlatformFee()))
            && (this.getBankCommissionRate() == null ? other.getBankCommissionRate() == null : this.getBankCommissionRate().equals(other.getBankCommissionRate()))
            && (this.getBankCommissionFee() == null ? other.getBankCommissionFee() == null : this.getBankCommissionFee().equals(other.getBankCommissionFee()))
            && (this.getLiquidatorCommissionRate() == null ? other.getLiquidatorCommissionRate() == null : this.getLiquidatorCommissionRate().equals(other.getLiquidatorCommissionRate()))
            && (this.getLiquidatorCommissionFee() == null ? other.getLiquidatorCommissionFee() == null : this.getLiquidatorCommissionFee().equals(other.getLiquidatorCommissionFee()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateDay() == null ? other.getCreateDay() == null : this.getCreateDay().equals(other.getCreateDay()))
            && (this.getSubMchId() == null ? other.getSubMchId() == null : this.getSubMchId().equals(other.getSubMchId()))
            && (this.getAttribute1() == null ? other.getAttribute1() == null : this.getAttribute1().equals(other.getAttribute1()))
            && (this.getAttribute2() == null ? other.getAttribute2() == null : this.getAttribute2().equals(other.getAttribute2()))
            && (this.getAttribute3() == null ? other.getAttribute3() == null : this.getAttribute3().equals(other.getAttribute3()))
            && (this.getAttribute4() == null ? other.getAttribute4() == null : this.getAttribute4().equals(other.getAttribute4()))
            && (this.getAttribute5() == null ? other.getAttribute5() == null : this.getAttribute5().equals(other.getAttribute5()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lp_day_order
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderSn() == null) ? 0 : getOrderSn().hashCode());
        result = prime * result + ((getPayPlatformOrderSn() == null) ? 0 : getPayPlatformOrderSn().hashCode());
        result = prime * result + ((getLiquidatorOrderSn() == null) ? 0 : getLiquidatorOrderSn().hashCode());
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getLiquidatorMerchantId() == null) ? 0 : getLiquidatorMerchantId().hashCode());
        result = prime * result + ((getLiquidatorId() == null) ? 0 : getLiquidatorId().hashCode());
        result = prime * result + ((getNotifyUrl() == null) ? 0 : getNotifyUrl().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getPayPlatformType() == null) ? 0 : getPayPlatformType().hashCode());
        result = prime * result + ((getRealMoney() == null) ? 0 : getRealMoney().hashCode());
        result = prime * result + ((getNetMoney() == null) ? 0 : getNetMoney().hashCode());
        result = prime * result + ((getPayPlatformRate() == null) ? 0 : getPayPlatformRate().hashCode());
        result = prime * result + ((getPayPlatformFee() == null) ? 0 : getPayPlatformFee().hashCode());
        result = prime * result + ((getBankCommissionRate() == null) ? 0 : getBankCommissionRate().hashCode());
        result = prime * result + ((getBankCommissionFee() == null) ? 0 : getBankCommissionFee().hashCode());
        result = prime * result + ((getLiquidatorCommissionRate() == null) ? 0 : getLiquidatorCommissionRate().hashCode());
        result = prime * result + ((getLiquidatorCommissionFee() == null) ? 0 : getLiquidatorCommissionFee().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateDay() == null) ? 0 : getCreateDay().hashCode());
        result = prime * result + ((getSubMchId() == null) ? 0 : getSubMchId().hashCode());
        result = prime * result + ((getAttribute1() == null) ? 0 : getAttribute1().hashCode());
        result = prime * result + ((getAttribute2() == null) ? 0 : getAttribute2().hashCode());
        result = prime * result + ((getAttribute3() == null) ? 0 : getAttribute3().hashCode());
        result = prime * result + ((getAttribute4() == null) ? 0 : getAttribute4().hashCode());
        result = prime * result + ((getAttribute5() == null) ? 0 : getAttribute5().hashCode());
        return result;
    }
}