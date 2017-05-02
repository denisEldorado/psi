package org.muhia.app.psi.portal.service.orm;

import org.muhia.app.psi.orm.model.ProductsMaster;

import java.util.List;

/**
 * Created by ngatia on 1/11/17.
 */
public interface IProductMasterService {
    List<ProductsMaster> getAll();

    ProductsMaster get(Long id);
}
