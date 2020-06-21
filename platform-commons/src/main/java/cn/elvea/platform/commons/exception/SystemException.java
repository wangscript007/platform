package cn.elvea.platform.commons.exception;

/**
 * SystemException
 *
 * @author elvea
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Throwable throwable) {
        super(throwable);
    }

    public SystemException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
