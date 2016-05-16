package dynservices.block;

import dynservices.core.complex.ComplexType;

/**
 * @author Alexander Kuleshov
 */
public enum BlockType implements ComplexType {

    SERVICE("service"),
    REQUEST("request"),
    REQUEST_PARAMETER("request-parameter"),
    REQUEST_BODY("request-body"),
    ACTION("action"),
    ACTION_INPUT_PARAMETER("input-parameter"),
    ACTION_OUTPUT_PARAMETER("output-parameter"),
    RESPONSE("response"),
    ERROR("error"),
    ERRORCODE("errorcode"),
    ERRORDESCRIPTION("errordescription");

    private final String id;

    BlockType(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id;
    }
}
