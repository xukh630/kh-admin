package com.kh.admin.dao;

import com.kh.admin.model.Finance;

public interface FinanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String orderSn);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance
     *
     * @mbggenerated
     */
    int insert(Finance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance
     *
     * @mbggenerated
     */
    int insertSelective(Finance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance
     *
     * @mbggenerated
     */
    Finance selectByPrimaryKey(String orderSn);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Finance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Finance record);
}