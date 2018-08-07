package dynservices.core.types;


/**
 * @author Alexander Kuleshov
 */
public interface ElementResolver<T> {
    T resolve(ElementContext ctx);
}