package com.example.demo.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum TestEnum {

    CREDIT("00001", "授信交易", true),
    LOAN("00010", "借款交易", true),
    REVERSE("00011", "借款撤销", false),
    REPAY("00100", "还款交易", true),
    REFUND("00101", "退款交易", false),
    WITHDRAW("00110", "提现交易", true),
    USER_INFO_QUERY("00111", "用户信息查询（总额度，可用额度等）", false),
    REPAY_SCHEDULE_QUERY("01000", "还款计划查询（总额度，可用额度等）", false),
    DUE_WITHHOLD("10001", "到期代扣", false),
    OVERDUE_WITHHOLD("10010", "逾期代扣", false),
    WITHHOLD("10011", "代扣", false),
    SUB_REPAY("10100", "代偿", false),
    // 代偿查询 10101
    BIND_CARD("10110", "绑卡", true),
    LOAN_BEFORE_PROCESS("LOAN_BEFORE_PROCESS", "借款预处理", false),
    CREDIT_BEFORE_PROCESS("CREDIT_BEFORE_PROCESS", "授信预处理", false);

    private final String txnTypeCode;

    private final String txnTypeName;

    private final boolean needConfirm;

    TestEnum(String txnTypeCode, String txnTypeName, boolean needConfirm) {
        this.txnTypeCode = txnTypeCode;
        this.txnTypeName = txnTypeName;
        this.needConfirm = needConfirm;
    }
    public static TestEnum parseTxnTypeCode(String txnTypeCode) {
        for (TestEnum txnTypes : values()) {
            if (StringUtils.equals(txnTypes.txnTypeCode, txnTypeCode)) {
                return txnTypes;
            }
        }

        throw new IllegalArgumentException("unknown txnTypeCode '" + txnTypeCode + "'.");
    }

    public static void main(String[] args) {
        System.out.println(parseTxnTypeCode("10100"));
    }
}
