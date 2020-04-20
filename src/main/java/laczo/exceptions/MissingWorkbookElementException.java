package laczo.exceptions;

/**
 * Created by Andras Laczo 2020. 04. 20.
 */

public class MissingWorkbookElementException extends NullPointerException {
    public MissingWorkbookElementException(String missingElment) {
        super(missingElment);
    }
}
