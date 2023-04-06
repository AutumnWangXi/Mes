package com.jotime.common.pdf.exception;

/**
 *
 * @author fgm
 * @date 2017/4/22
 */
public class PdfException extends BaseException {

    public PdfException(){
        super("PDF异常");
    }

    public PdfException(int errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
    }
    public PdfException(String errorMsg){
        super(errorMsg);
        this.errorCode=500;
        this.errorMsg=errorMsg;
    }
    public PdfException(String errorMsg, Exception e){
        super(errorMsg,e);
        this.errorCode=500;
        this.errorMsg=errorMsg;
    }


}
