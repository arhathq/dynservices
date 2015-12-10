package dynservices.core.complex;

import dynservices.core.ElementData;

/**
 *
 */
public interface ComplexData<T>  extends ElementData<T> {

    ComplexType getType();

    ElementData asElementData();

}