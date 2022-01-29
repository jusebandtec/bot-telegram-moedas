package br.com.obrigadobombcrypto.bot.domain.responses;

import java.util.Date;

public class StatusResponseCoinMarket {
    private Date timestamp;
    private int erro_code;
    private String error_message;
    private int elapsed;
    private int credit_count;
    private String notice;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getErro_code() {
        return erro_code;
    }

    public void setErro_code(int erro_code) {
        this.erro_code = erro_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public int getElapsed() {
        return elapsed;
    }

    public void setElapsed(int elapsed) {
        this.elapsed = elapsed;
    }

    public int getCredit_count() {
        return credit_count;
    }

    public void setCredit_count(int credit_count) {
        this.credit_count = credit_count;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
