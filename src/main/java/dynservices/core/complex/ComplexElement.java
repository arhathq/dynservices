package dynservices.core.complex;

import dynservices.core.Element;

/**
 *
 */
public interface ComplexElement<T>  extends Element<T> {

    ComplexType getType();

    Element asElementData();

}