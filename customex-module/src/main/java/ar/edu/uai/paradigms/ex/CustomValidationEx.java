package ar.edu.uai.paradigms.ex;

/**
 * Created by EzequielPanoff on 16/7/15.
 */
public class CustomValidationEx extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomValidationEx(String msg) {
        super(msg);
    }
}
